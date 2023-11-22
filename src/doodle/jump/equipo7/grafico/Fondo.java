package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.*;

public class Fondo extends JFrame {
    private JFrame fondo;

    public Fondo() {
        this.fondo = new JFrame("DOODLE JUMP");
        this.fondo.setLayout(new BorderLayout());
    }

    public void mostrarFondo() {
        this.fondo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fondo.setSize(400, 620);
        JLayeredPane layeredPane = new JLayeredPane();

        layeredPane.setPreferredSize(new Dimension(400, 620));
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        JLabel label1 = new JLabel(imagenFondo);
        label1.setBounds(0, 0, 400, 620);
        layeredPane.add(label1, Integer.valueOf(0)); 

        ImageIcon imagenDino = new ImageIcon(getClass().getResource("/images/Smily.png"));
        JLabel label2 = new JLabel(imagenDino);
        label2.setBounds(50, 50, imagenDino.getIconWidth(), imagenDino.getIconHeight()); 
        layeredPane.add(label2, Integer.valueOf(1));

        this.fondo.add(layeredPane, BorderLayout.CENTER);
        this.fondo.setResizable(false);
        this.fondo.setVisible(true);
    }
}
