package Lab2;

/**
 * 
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║      Sadfriendd - vendetta! (prod. Mupp)                         ║
 * ╟──────────────────────────────────────────────────────────────────╢
 * ║ [▶] ██████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 00:15/01:49 ║
 * ╚══════════════════════════════════════════════════════════════════╝
 *
 */

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    private Rectangle r1, r2, r3, rUnion;
    private DrawableRect dr1;
    private ColoredRect cr1;

    public Main() {
        // Создание трех прямоугольников
        r1 = new Rectangle(50, 50, 150, 100);
        r2 = new Rectangle(30, 60);
        r3 = new Rectangle();

        // Перемещение
        r1.move(50, 50); // теперь (100,100) - (200,150)
        r2.move(200, 100); // теперь (200,100) - (230,160)
        r3.move(350, 150); // точка (350,150)

        // Union r1 и r2
        rUnion = r1.Union(r2);

        // DrawableRect и ColoredRect
        dr1 = new DrawableRect(100, 200, 200, 300, Color.RED);
        cr1 = new ColoredRect(250, 100, 400, 200, Color.BLUE, Color.YELLOW);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисуем r1
        g.setColor(Color.BLACK);
        g.drawRect(r1.x1, r1.y1, r1.x2 - r1.x1, r1.y2 - r1.y1);
        g.drawString("r1", r1.x1 - 20, r1.y1 - 5);

        // Рисуем r2
        g.drawRect(r2.x1, r2.y1, r2.x2 - r2.x1, r2.y2 - r2.y1);
        g.drawString("r2", r2.x1 - 20, r2.y1 - 5);

        // Рисуем r3 (может быть невидимым)
        g.drawRect(r3.x1, r3.y1, r3.x2 - r3.x1, r3.y2 - r3.y1);
        g.drawString("r3", r3.x1 - 20, r3.y1 - 5);

        // Рисуем Union зелёным
        g.setColor(Color.GREEN);
        g.drawRect(rUnion.x1, rUnion.y1, rUnion.x2 - rUnion.x1, rUnion.y2 - rUnion.y1);
        g.drawString("Union(r1,r2)", rUnion.x1, rUnion.y1 - 5);

        // Рисуем DrawableRect
        dr1.draw(g);
        g.setColor(Color.RED);
        g.drawString("DrawableRect", dr1.x1, dr1.y1 - 5);

        // Рисуем ColoredRect
        cr1.draw(g);
        g.setColor(Color.BLUE);
        g.drawString("ColoredRect", cr1.x1, cr1.y1 - 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangles Demo");
        Main panel = new Main();

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Дополнительно выводим в консоль
        System.out.println("Initial and moved states:");
        panel.r1.rect_print();
        panel.r2.rect_print();
        panel.r3.rect_print();
        System.out.println("\nUnion r1 и r2:");
        panel.rUnion.rect_print();
    }
}
