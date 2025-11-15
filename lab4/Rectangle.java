package lab4;

import java.awt.*;

public class Rectangle {
    protected int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public void rect_print() {
        System.out.println(
                "Прямоугольник: левый верхний угол = (" + x1 + ", " + y1 + "), " +
                        "правый нижний угол = (" + x2 + ", " + y2 + "), " +
                        "ширина = " + (x2 - x1) + ", высота = " + (y2 - y1));
    }

    public void move(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

    public Rectangle Union(Rectangle other) {
        int nx1 = Math.min(this.x1, other.x1);
        int ny1 = Math.min(this.y1, other.y1);
        int nx2 = Math.max(this.x2, other.x2);
        int ny2 = Math.max(this.y2, other.y2);
        return new Rectangle(nx1, ny1, nx2, ny2);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
    }
}
