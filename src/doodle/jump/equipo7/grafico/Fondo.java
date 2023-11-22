package doodle.jump.equipo7.grafico;

import javax.swing.*;
import java.awt.*;

public class Fondo extends JFrame{
    JLayeredPane juego = new JLayeredPane();
    public Fondo() {
        super("DOODLE JUMP");
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Smily.png"));
        Image iconImage = icon.getImage();
        setIconImage(iconImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 620);
        setLocationRelativeTo(null);
    }

    public void mostrarFondoyPersonaje() {
        crearFondo();
        personaje();
        add(this.juego, BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
    }

    public void crearFondo(){
        this.juego.setPreferredSize(new Dimension(400, 620));

        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        JLabel label1 = new JLabel(imagenFondo);
        label1.setBounds(0, 0, 400, 620);
        this.juego.add(label1, Integer.valueOf(0));

    }

    public void personaje(){
        ImageIcon imagenDino = new ImageIcon(getClass().getResource("/images/Smily.png"));
        JLabel label2 = new JLabel(imagenDino);
        label2.setBounds(50, 50, imagenDino.getIconWidth(), imagenDino.getIconHeight());
        this.juego.add(label2, Integer.valueOf(1));
    }
}
