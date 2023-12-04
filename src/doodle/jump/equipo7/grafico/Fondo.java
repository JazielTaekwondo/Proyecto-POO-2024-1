package doodle.jump.equipo7.grafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Fondo extends JFrame {
    private JLayeredPane juego = new JLayeredPane();
    private JLabel labelDino;
    private ImageIcon imagenDinoDerecha;
    private ImageIcon imagenDinoIzquierda;
    private JLabel labelFondo;
    private int posicionFondo = 0;
    private boolean personajeEnMovimiento = false;

    private String personajeSeleccionado;
    private String fondoSeleccionado;

    public Fondo(String personajeSeleccionado, String fondoSeleccionado) {
        super("DOODLE JUMP");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Smily.png"));
        Image iconImage = icon.getImage();
        setIconImage(iconImage);
        setLayout(new BorderLayout());
        imagenDinoDerecha = new ImageIcon(getClass().getResource("/images/SmilyD.png"));
        imagenDinoIzquierda = new ImageIcon(getClass().getResource("/images/SmilyL.png"));

        this.personajeSeleccionado = personajeSeleccionado;
        this.fondoSeleccionado = fondoSeleccionado;

        // Configurar la imagen inicial del dino
        labelDino = new JLabel(imagenDinoDerecha);
        labelDino.setBounds(300, 650, imagenDinoDerecha.getIconWidth(), imagenDinoDerecha.getIconHeight());
        juego.add(labelDino, Integer.valueOf(1));

        // Configurar el fondo
        crearFondo();

        // Configurar el InputMap y ActionMap para KeyBindings
        InputMap inputMap = juego.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = juego.getActionMap();

        // Mapear las teclas a acciones
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moverIzquierda");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moverDerecha");

        // Crear acciones y asociarlas a las teclas
        actionMap.put("moverIzquierda", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverSmilyIzquierda();
            }
        });

        actionMap.put("moverDerecha", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverSmilyDerecha();
            }
        });

        setFocusable(true); // Permitir que el JFrame reciba eventos de teclado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800); // Ajustar el tamaño de la ventana
        setLocationRelativeTo(null);
    }

    public void mostrarFondoyPersonaje() {
        add(juego, BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
    }

    public void crearFondo() {
        juego.setPreferredSize(new Dimension(600, 800)); // Ajustar la dimensión del JLayeredPane
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 600, 800); // Ajustar la posición y tamaño del fondo
        juego.add(labelFondo, Integer.valueOf(0));
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

    public void cambiarPersonaje(String nombrePersonaje) {
        // Lógica para cambiar el personaje en el juego
        System.out.println("Cambiando personaje a: " + nombrePersonaje);
        // Por ejemplo, podrías cambiar la imagen del personaje en el juego
        // labelDino.setIcon(new ImageIcon(getClass().getResource("/images/" + nombrePersonaje + ".png")));
    }

    public void cambiarFondo(String nombreFondo) {
        // Lógica para cambiar el fondo en el juego
        System.out.println("Cambiando fondo a: " + nombreFondo);
        // Por ejemplo, podrías cambiar la imagen de fondo en el juego
        // labelFondo.setIcon(new ImageIcon(getClass().getResource("/images/" + nombreFondo + ".png")));
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