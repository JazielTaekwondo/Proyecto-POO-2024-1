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
            Fondo newGame = new Fondo();
            newGame.mostrarFondoyPersonaje();
            //newGame.generarPlataformas();
            this.setVisible(false);
        }
        if(e.getSource()==salir){
            System.exit(0);
        }
    }

}
