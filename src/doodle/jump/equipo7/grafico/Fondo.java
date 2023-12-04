package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;


class Fondo extends JFrame {
    private JLayeredPane juego = new JLayeredPane();
    private JLabel labelDino;
    private ImageIcon imagenDinoDerecha;
    private ImageIcon imagenDinoIzquierda;
    private JLabel labelFondo;
    private int posicionFondo = 0;
    private boolean personajeEnMovimiento = false;

    public Fondo() {
        super("DOODLE JUMP");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Smily.png"));
        Image iconImage = icon.getImage();
        setIconImage(iconImage);
        setLayout(new BorderLayout());
        imagenDinoDerecha = new ImageIcon(getClass().getResource("/images/SmilyD.png"));
        imagenDinoIzquierda = new ImageIcon(getClass().getResource("/images/SmilyL.png"));

        // Configurar la imagen inicial del dino
        labelDino = new JLabel(imagenDinoDerecha);
        labelDino.setBounds(200, 300, imagenDinoDerecha.getIconWidth(), imagenDinoDerecha.getIconHeight());
        juego.add(labelDino, Integer.valueOf(1));

        // Configurar el fondo
        crearFondo();

        // Agregar controlador de eventos de teclado
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario para este caso
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    moverSmilyIzquierda();
                } else if (key == KeyEvent.VK_RIGHT) {
                    moverSmilyDerecha();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario para este caso
            }
        });


        setFocusable(true); // Permitir que el JFrame reciba eventos de teclado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 900);
        setLocationRelativeTo(null);

    }

    public void mostrarFondoyPersonaje() {
        add(juego, BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
        for (int i = 0; i < 10; i++) {
            moverSmilyAbajo();
            moverSmilyArriba();
        }

    }

    public void crearFondo() {
        juego.setPreferredSize(new Dimension(600, 900));
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 900);
        juego.add(labelFondo, Integer.valueOf(0));
    }

    public void moverSmilyAbajo() {
        int y = labelDino.getY();
        if (y < getHeight() - labelDino.getHeight()) {
            y += 150; // Ajusta la cantidad de píxeles que el dino se mueve hacia abajo
            labelDino.setLocation(labelDino.getX(), y);
        }
    }

    public void moverSmilyArriba() {
        int y = labelDino.getY();
        if (y > getHeight() - labelDino.getHeight()) {
            y -= 150; // Ajusta la cantidad de píxeles que el dino se mueve hacia abajo
            labelDino.setLocation(labelDino.getX(), y);
        }
    }

   public void moverSmilyIzquierda() {
    labelDino.setIcon(imagenDinoIzquierda);
    int x = labelDino.getX();
    if (x > 0) {
        x -= 10; // Ajusta la cantidad de píxeles que el dino se mueve a la izquierda
        labelDino.setLocation(x, labelDino.getY());
        personajeEnMovimiento = true;
    }
}

public void moverSmilyDerecha() {
    labelDino.setIcon(imagenDinoDerecha);
    int x = labelDino.getX();
    if (x < getWidth() - labelDino.getWidth()) {
        x += 10; // Ajusta la cantidad de píxeles que el dino se mueve a la derecha
        labelDino.setLocation(x, labelDino.getY());
        personajeEnMovimiento = true;
    }
}
    
}


    /*public void crearFondo() {
        juego.setPreferredSize(new Dimension(400, 620));

        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 400, 620);
        juego.add(labelFondo, Integer.valueOf(0));

        ImageIcon imagenPlataforma = new ImageIcon(getClass().getResource("/images/Plataforma.png"));
        JLabel labelPlataforma = new JLabel(imagenPlataforma);
        labelPlataforma.setBounds(150, 400,256, 128);
        juego.add(labelPlataforma, Integer.valueOf(1));

    }
    public void moverSmilyAbajo() {
        int y = labelDino.getY();
        if (y < getHeight() - labelDino.getHeight()) {
            y += 10; // Ajusta la cantidad de píxeles que el dino se mueve hacia abajo
            labelDino.setLocation(labelDino.getX(), y);
        }
    }
    

    public void generarPlataformas() {
        Random random = new Random();
        int numeroDePlataformas = 2; // Cantidad inicial de plataformas
        int yInicial = 500; // Altura inicial de las plataformas

        for (int i = 0; i < numeroDePlataformas; i++) {
            ImageIcon imagenPlataforma = new ImageIcon(getClass().getResource("/images/Plataforma.png"));
            JLabel labelPlataforma = new JLabel(imagenPlataforma);
            int x = random.nextInt(400 - imagenPlataforma.getIconWidth()); // Ajuste para evitar que las plataformas salgan del ancho del juego
            int y = yInicial - i * 150; // Espaciado vertical entre plataformas
            labelPlataforma.setBounds(x, y, imagenPlataforma.getIconWidth(), imagenPlataforma.getIconHeight());
            juego.add(labelPlataforma, Integer.valueOf(1));
            plataformas.add(labelPlataforma); // Agrega la plataforma a la lista
        }
    }

    private boolean tocaPlataforma() {
        // Obtener las coordenadas del muñeco
        int xMuñeco = labelDino.getX();
        int yMuñeco = labelDino.getY();
        int anchoMuñeco = labelDino.getWidth();
        int altoMuñeco = labelDino.getHeight();
    
        // Iterar sobre las plataformas para verificar si el muñeco toca alguna
        for (JLabel plataforma : plataformas) {
            // Obtener las coordenadas de la plataforma
            int xPlataforma = plataforma.getX();
            int yPlataforma = plataforma.getY();
            int anchoPlataforma = plataforma.getWidth();
            int altoPlataforma = plataforma.getHeight();
    
            // Verificar si hay intersección entre el muñeco y la plataforma
            if (xMuñeco < xPlataforma + anchoPlataforma &&
                xMuñeco + anchoMuñeco > xPlataforma &&
                yMuñeco < yPlataforma + altoPlataforma &&
                yMuñeco + altoMuñeco > yPlataforma) {
                // El muñeco toca la plataforma
                // Detener el temporizador
                temporizador.stop();
                // Cambiar la dirección del movimiento a caída
                cayendo = false;
                // Reiniciar el temporizador para el próximo ciclo de salto
                temporizador.start();
                return true;
            }
        }
        // El muñeco no toca ninguna plataforma
        return false;

        public void moverFondo(int velocidad) {
        // Obtén la posición actual de los fondos
        Point posFondo1 = labelFondo1.getLocation();
        Point posFondo2 = labelFondo2.getLocation();
        
        // Mueve los fondos hacia arriba o abajo dependiendo de la velocidad proporcionada
        posFondo1.translate(0, velocidad);
        posFondo2.translate(0, velocidad);
        
        // Verifica si el primer fondo se salió de la pantalla
        if (posFondo1.y >= 900) {
            // Coloca el primer fondo arriba del segundo fondo
            posFondo1.setLocation(0, posFondo2.y - 900);
        } else if (posFondo1.y <= -900) {
            // Coloca el primer fondo debajo del segundo fondo
            posFondo1.setLocation(0, posFondo2.y + 900);
        }
        
        // Verifica si el segundo fondo se salió de la pantalla
        if (posFondo2.y >= 900) {
            // Coloca el segundo fondo arriba del primer fondo
            posFondo2.setLocation(0, posFondo1.y - 900);
        } else if (posFondo2.y <= -900) {
            // Coloca el segundo fondo debajo del primer fondo
            posFondo2.setLocation(0, posFondo1.y + 900);
        }
    
        // Actualiza las posiciones de los fondos
        labelFondo1.setLocation(posFondo1);
        labelFondo2.setLocation(posFondo2);
    }
    
    public void generarNuevaPlataforma() {
        Random random = new Random();
        ImageIcon imagenPlataforma = new ImageIcon(getClass().getResource("/images/Plataforma.png"));
        JLabel labelPlataforma = new JLabel(imagenPlataforma);
        
        // Define la posición X de la nueva plataforma de forma aleatoria dentro del ancho del juego
        int x = random.nextInt(600 - imagenPlataforma.getIconWidth());
        // Define la posición Y de la nueva plataforma justo debajo del límite inferior
        int y = 100;
        
        labelPlataforma.setBounds(x, y, imagenPlataforma.getIconWidth(), imagenPlataforma.getIconHeight());
        juego.add(labelPlataforma, Integer.valueOf(1));
        plataformas.add(labelPlataforma); // Agrega la nueva plataforma a la lista de plataformas
    }
    }
    */