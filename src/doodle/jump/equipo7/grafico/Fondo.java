package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fondo extends JFrame {
    private JLayeredPane juego = new JLayeredPane();
    private JLabel labelDino;
    private ImageIcon imagenDinoDerecha;
    private ImageIcon imagenDinoIzquierda;

    public Fondo() {
        super("DOODLE JUMP");
        setLayout(new BorderLayout());

        // Cargar imágenes del dino
        imagenDinoDerecha = new ImageIcon(getClass().getResource("/images/SmilyD.png"));
        imagenDinoIzquierda = new ImageIcon(getClass().getResource("/images/SmilyI.png"));

        // Configurar la imagen inicial del dino
        labelDino = new JLabel(imagenDinoDerecha);
        labelDino.setBounds(50, 50, imagenDinoDerecha.getIconWidth(), imagenDinoDerecha.getIconHeight());
        juego.add(labelDino, Integer.valueOf(1));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Smily.png"));
        Image iconImage = icon.getImage();
        setIconImage(iconImage);

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
                else if (key == KeyEvent.VK_UP) {
                    moverSmilyArriba();
                } else if (key == KeyEvent.VK_DOWN) {
                    moverSmilyAbajo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario para este caso
            }
        });

        setFocusable(true); // Permitir que el JFrame reciba eventos de teclado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 620);
        setLocationRelativeTo(null);
    }

    public void mostrarFondoyPersonaje() {
        crearFondo();
        add(juego, BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
    }

    public void crearFondo() {
        juego.setPreferredSize(new Dimension(400, 620));

        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, 400, 620);
        juego.add(labelFondo, Integer.valueOf(0));
    }

    public void moverSmilyIzquierda() {
        labelDino.setIcon(imagenDinoIzquierda);
        int x = labelDino.getX();
        if (x > 0) {
            x -= 10; // Ajusta la cantidad de píxeles que el dino se mueve a la izquierda
            labelDino.setLocation(x, labelDino.getY());
        }
    }

    public void moverSmilyDerecha() {
        labelDino.setIcon(imagenDinoDerecha);
        int x = labelDino.getX();
        if (x < getWidth() - labelDino.getWidth()) {
            x += 10; // Ajusta la cantidad de píxeles que el dino se mueve a la derecha
            labelDino.setLocation(x, labelDino.getY());
        }
    }

    public void moverSmilyArriba() {
        int y = labelDino.getY();
        if (y > 0) {
            y -= 10; // Ajusta la cantidad de píxeles que el dino se mueve hacia arriba
            labelDino.setLocation(labelDino.getX(), y);
        }
    }
    
    public void moverSmilyAbajo() {
        int y = labelDino.getY();
        if (y < getHeight() - labelDino.getHeight()) {
            y += 10; // Ajusta la cantidad de píxeles que el dino se mueve hacia abajo
            labelDino.setLocation(labelDino.getX(), y);
        }
    }
    
}