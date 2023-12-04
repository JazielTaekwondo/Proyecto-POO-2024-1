package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Botones extends JFrame implements ActionListener {

    JButton inicio;
    JButton salir;

    public Botones(){
        super("DOODLE JUMP");
        setLayout(null);

        inicio = new JButton();
        salir = new JButton();

        ImageIcon fotoBoton = new ImageIcon(getClass().getResource("/images/BotonInicio.png"));
        ImageIcon fotoBoton2 = new ImageIcon(getClass().getResource("/images/BotonSalida.png"));

        inicio.setBounds(150, 430, 100, 40);
        salir.setBounds(350, 430, 100, 40);

        inicio.setIcon(fotoBoton);
        salir.setIcon(fotoBoton2);

        add(inicio);
        add(salir);
        
        inicio.addActionListener(this);
        salir.addActionListener(this);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Smily.png"));
        Image iconImage = icon.getImage();
        setIconImage(iconImage);

        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/FondoPantallaDoodle.png"));
        JLabel labelFondo = new JLabel(imagenFondo);
        labelFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight()); // Establece tamaño y posición del fondo
        add(labelFondo, Integer.valueOf(0));

        setSize(imagenFondo.getIconWidth(), imagenFondo.getIconHeight()); // Establece el tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==inicio){
            mostrarSeleccionVentana();
            this.setVisible(false);
        }
    }

    private void mostrarSeleccionVentana() {
        SeleccionVentana seleccionVentana = new SeleccionVentana(this);
        seleccionVentana.setVisible(true);
        this.setVisible(false);
    }

    public void iniciarJuego(String personajeSeleccionado, String fondoSeleccionado) {
        Fondo newGame = new Fondo(personajeSeleccionado, fondoSeleccionado);
        newGame.mostrarFondoyPersonaje();
        // Puedes agregar más configuraciones o lógica para el inicio del juego aquí
        this.setVisible(false); // Opcional: ocultar la ventana de selección
    }

    private Fondo ventanaJuego;  // Agrega esta línea

    public void setVentanaJuego(Fondo ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    // Métodos para actualizar el personaje y el fondo
    public void setPersonaje(String nombrePersonaje) {
        // Lógica para cambiar el personaje
        System.out.println("Personaje seleccionado: " + nombrePersonaje);
        if (ventanaJuego != null) {
            ventanaJuego.cambiarPersonaje(nombrePersonaje);
        }
    }

    public void setFondo(String nombreFondo) {
        // Lógica para cambiar el fondo
        System.out.println("Fondo seleccionado: " + nombreFondo);
        if (ventanaJuego != null) {
            ventanaJuego.cambiarFondo(nombreFondo);
        }
    }

}

// Clase SeleccionVentana
class SeleccionVentana extends JFrame {
    private Botones ventanaPrincipal;
    private String personajeSeleccionado;
    private String fondoSeleccionado;

    public SeleccionVentana(Botones ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Selección de Personaje y Fondo");
        setSize(600, 800); // Establecer el tamaño deseado
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Usar BorderLayout para organizar componentes
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/images/fondoseleccion.jpg"))));
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinear los componentes al centro
    }

    private void agregarComponentes() {
        // Etiqueta de selección de personaje
        JLabel lblSeleccionPersonaje = new JLabel("Selección de Personaje");
        configurarTitulo(lblSeleccionPersonaje);
        add(lblSeleccionPersonaje);

        // Panel para la selección de personaje
        JPanel panelPersonaje = new JPanel();
        panelPersonaje.setPreferredSize(new Dimension(300, 300)); // Establecer el tamaño deseado
        panelPersonaje.setOpaque(false); // Hacer el panel transparente

        // Preview de la foto de Smily.png
        ImageIcon previewSmily = new ImageIcon(getClass().getResource("/images/Smily.png"));
        JLabel lblPreviewSmily = new JLabel(previewSmily);
        panelPersonaje.add(lblPreviewSmily);

        // Botón para seleccionar a Smily como personaje
        JButton btnPersonaje = new JButton("Seleccionar Smily");
        btnPersonaje.addActionListener(e -> seleccionarPersonaje("Smily"));
        panelPersonaje.add(btnPersonaje);

        // Agregar panel de personaje
        add(panelPersonaje);

        // Etiqueta de selección de fondo
        JLabel lblSeleccionFondo = new JLabel("Selección de Fondo");
        configurarTitulo(lblSeleccionFondo);
        add(lblSeleccionFondo);

        // Panel para la selección de fondo
        JPanel panelFondo = new JPanel();
        panelFondo.setPreferredSize(new Dimension(300, 300)); // Establecer el tamaño deseado
        panelFondo.setOpaque(false); // Hacer el panel transparente

        // Preview de la foto de doodleFondo.png
        ImageIcon previewDoodleFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        Image imgDoodleFondo = previewDoodleFondo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon previewDoodleFondoRedimensionado = new ImageIcon(imgDoodleFondo);
        JLabel lblPreviewDoodleFondo = new JLabel(previewDoodleFondoRedimensionado);
        panelFondo.add(lblPreviewDoodleFondo);

        // Botón para seleccionar doodleFondo como fondo
        JButton btnFondo = new JButton("Seleccionar Doodle Fondo");
        btnFondo.addActionListener(e -> seleccionarFondo("Doodle Fondo"));
        panelFondo.add(btnFondo);

        // Agregar panel de fondo
        add(panelFondo);

        // Panel para los botones de regreso al menú principal y jugar
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setPreferredSize(new Dimension(600, 200));
        panelBotones.setOpaque(false);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar al Menú Principal");
        btnRegresar.addActionListener(e -> regresarAlMenuPrincipal());
        panelBotones.add(btnRegresar);

        // Botón para iniciar el juego
        JButton btnJugar = new JButton("Jugar");
        btnJugar.addActionListener(e -> {
            ventanaPrincipal.iniciarJuego(personajeSeleccionado, fondoSeleccionado);
            dispose(); // Cerrar la ventana de selección al iniciar el juego
        });
        panelBotones.add(btnJugar);

        // Agregar panel de botones
        add(panelBotones, BorderLayout.SOUTH);

    }

    private void seleccionarPersonaje(String nombrePersonaje) {
        personajeSeleccionado = nombrePersonaje;
        ventanaPrincipal.setPersonaje(personajeSeleccionado);
    }

    private void seleccionarFondo(String nombreFondo) {
        fondoSeleccionado = nombreFondo;
        ventanaPrincipal.setFondo(fondoSeleccionado);
    }

    private void regresarAlMenuPrincipal() {
        setVisible(false);
        ventanaPrincipal.setVisible(true);
    }

    private void configurarTitulo(Component componente) {
        if (componente instanceof JLabel || componente instanceof JButton) {
            Font font = new Font("Century Gothic", Font.BOLD, 25);
            componente.setFont(font);
            componente.setForeground(Color.black);
            componente.setPreferredSize(new Dimension(600, 50));
            if (componente instanceof JLabel) {
                ((JLabel) componente).setHorizontalAlignment(JLabel.CENTER);
                ((JLabel) componente).setVerticalAlignment(JLabel.CENTER);
            }
        }
        // Puedes agregar configuraciones adicionales para otros tipos de componentes aquí
        add(componente);
    }
}



