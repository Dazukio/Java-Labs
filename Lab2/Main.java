package l2;

import java.awt.Color;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        DrawableRect r3 = new DrawableRect(50, 200, 300, 100, Color.RED);
        // ColoredRect r4 = new ColoredRect(
        // 50, 50, 300, 200, // координаты
        // Color.BLUE, // цвет границы
        // Color.YELLOW // цвет заливки
        // );
        JFrame frame = new JFrame("Отображение прямоугольника");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(r3);
        // frame.add(r4);

        frame.setVisible(true);
    }
}
