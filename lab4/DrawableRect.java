package lab4;

import java.awt.*;

public class DrawableRect extends Rectangle {
    protected Color outColor;

    public DrawableRect(int x1, int y1, int x2, int y2, Color outColor) {
        super(x1, y1, x2, y2);
        this.outColor = outColor;
    }

    public DrawableRect(int width, int height, Color outColor) {
        super(width, height);
        this.outColor = outColor;
    }

    public DrawableRect(Color outColor) {
        super();
        this.outColor = outColor;
    }

    public void draw(Graphics g) {
        g.setColor(outColor);
        int w = x2 - x1;
        int h = y2 - y1;
        g.drawRect(x1, y1, w, h);
    }
}
