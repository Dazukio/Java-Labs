package lab4;

import java.awt.*;

public class ColoredRect extends DrawableRect {
    private Color inColor;

    public ColoredRect(int x1, int y1, int x2, int y2, Color outColor, Color inColor) {
        super(x1, y1, x2, y2, outColor);
        this.inColor = inColor;
    }

    public ColoredRect(int width, int height, Color outColor, Color inColor) {
        super(width, height, outColor);
        this.inColor = inColor;
    }

    public ColoredRect(Color outColor, Color inColor) {
        super(outColor);
        this.inColor = inColor;
    }

    @Override
    public void draw(Graphics g) {
        int w = x2 - x1;
        int h = y2 - y1;

        g.setColor(inColor);
        g.fillRect(x1, y1, w, h);

        g.setColor(outColor);
        g.drawRect(x1, y1, w, h);
    }
}
