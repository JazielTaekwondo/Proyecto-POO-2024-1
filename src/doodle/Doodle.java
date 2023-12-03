package doodle;
import doodle.jump.equipo7.grafico.Botones;

public class Doodle {
    public static void main(String[] args) {
        Botones juego = new Botones();
        juego.setBounds(0, 0, 600, 900);
        juego.setResizable(false);
        juego.setLocationRelativeTo(null);
        juego.setVisible(true);
    }
}
