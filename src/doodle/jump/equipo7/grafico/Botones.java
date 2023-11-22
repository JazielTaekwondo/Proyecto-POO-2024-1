package doodle.jump.equipo7.grafico;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones extends JFrame implements ActionListener {
    JButton inicio;
    public Botones(){
        setLayout(null);
        inicio = new JButton("JUGAR");
        inicio.setBounds(150, 290, 100, 40);
        add(inicio);
        inicio.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==inicio){
            Fondo newGame = new Fondo();
            newGame.mostrarFondoyPersonaje();
        }
    }
}
