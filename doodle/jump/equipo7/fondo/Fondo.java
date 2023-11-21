package doodle.jump.equipo7.fondo;

import javax.swing.*;

public class Fondo {
    public void mostrarFondo(){
        JFrame fondo = new JFrame("DOODLE JUMP");
        fondo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.setSize(400, 620);
        ImageIcon imageIcon = new ImageIcon("\\Users\\jazie\\Desktop\\POO2024-1\\Proyecto-POO-2024-1\\images\\fondo2doodle.jpg");
        JLabel label = new JLabel(imageIcon);
        fondo.add(label);
        fondo.setVisible(true);
    }
}
