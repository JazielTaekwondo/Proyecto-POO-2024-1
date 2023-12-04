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
    private int velocidadFondo = 1;
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

        Thread movimientoFondo = new Thread(() -> {
            while (true) {
                moverFondo();
                try {
                    Thread.sleep(10); // Pequeño retraso para el efecto visual
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        movimientoFondo.start();
    }

    public void moverFondo() {
        int y = labelFondo.getY();
        y += velocidadFondo; // Ajusta la velocidad de desplazamiento del fondo
    
        // Si el fondo superior sale de la pantalla, reposiciónalo arriba del fondo inferior
        if (y >= getHeight()) {
            y = -labelFondo.getHeight();
        }
    
        labelFondo.setLocation(labelFondo.getX(), y);
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




   