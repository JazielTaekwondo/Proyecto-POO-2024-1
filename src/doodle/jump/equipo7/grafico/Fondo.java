package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.*;

public class Fondo extends JFrame {
    private JFrame fondo;
    public Fondo(){
        this.fondo = new JFrame("DOODLE JUMP");
        this.fondo.setLayout(new FlowLayout());
    }
    public void mostrarFondo(){
        this.fondo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fondo.setSize(400, 620);
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/images/doodleFondo.png"));
        JLabel label1 = new JLabel(imagenFondo);
        ImageIcon imagenDino = new ImageIcon(getClass().getResource("/images/Smily.png"));
        JLabel label2 = new JLabel(imagenDino);
        this.fondo.add(label1);
        this.fondo.add(label2);
        this.fondo.setResizable(false);
        this.fondo.setVisible(true);
        this.fondo.setLocationRelativeTo(null);
    }
}
