package l2;

import java.awt.*;

// Расширяем класс DrawableRect
public class ColoredRect extends DrawableRect {
    private Color inColor; // Цвет заливки

    // Конструктор с дополнительным параметром для цвета заливки
    public ColoredRect(int x1, int y1, int x2, int y2, Color outColor, Color inColor) {
        super(x1, y1, x2, y2, outColor);
        this.inColor = inColor;
    }

    // Переопределяем метод отрисовки
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Устанавливаем и рисуем цвет заливки
        g.setColor(inColor);
        g.fillRect(rect.x1, rect.y1, rect.getWidth(), rect.getHeight());

        // Устанавливаем и рисуем цвет границы
        g.setColor(outColor);
        g.drawRect(rect.x1, rect.y1, rect.getWidth(), rect.getHeight());
    }
}
