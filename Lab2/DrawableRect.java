package l2;

import java.awt.*;
import javax.swing.*;

public class DrawableRect extends JPanel {
    public Color outColor; // Используем private для инкапсуляции
    public Rectangle rect;

    public DrawableRect(int x1, int y1, int x2, int y2, Color color) {
        rect = new Rectangle(x1, y1, x2, y2);
        this.outColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(outColor);
        if (rect.x1 < rect.x2 && rect.y1 > rect.y2) {
            g.drawRect(rect.x1, rect.y1, rect.getWidth(), rect.getHeight());
        } else {

            g.drawRect(0, 0, 100, 100);
        }
    }
}