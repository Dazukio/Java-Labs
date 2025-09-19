package l2;

public class Rectangle {
    public int x1, x2, y1, y2;

    public Rectangle(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Rectangle(int x2, int y2) {
        this.x1 = 0;
        this.x2 = x2;
        this.y1 = 0;
        this.y2 = y2;
    }

    public Rectangle() {
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }

    public void print() {
        System.out.println("X1: " + x1 + " X2: " + x2 + " Y1: " + y1 + " Y2: " + y2);
    }

    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public Rectangle union(Rectangle other) {
        Rectangle rec = new Rectangle();
        rec.x1 = Math.min(this.x1, other.x1);
        rec.x2 = Math.max(this.x2, other.x2);
        rec.y1 = Math.max(this.y1, other.y1);
        rec.y2 = Math.min(this.y2, other.y2);
        return rec;
    }

    public int getWidth() {
        return Math.abs(x2 - x1);
    }

    public int getHeight() {
        return Math.abs(y2 - y1);
    }
}
