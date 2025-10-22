package lab3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BouncingBox extends JPanel implements Runnable {
    private Rectangle[] shapes;
    private int[] dx;
    private int[] dy;
    private Thread animator;
    private volatile boolean running = true;
    private Random rand = new Random();

    public BouncingBox() {
        int total = 30;
        shapes = new Rectangle[total];
        dx = new int[total];
        dy = new int[total];

        int w = 60, h = 40;

        for (int i = 0; i < 10; i++) {
            shapes[i] = new Rectangle(rand.nextInt(500), rand.nextInt(300),
                    rand.nextInt(500) + w, rand.nextInt(300) + h);
        }

        for (int i = 10; i < 20; i++) {
            shapes[i] = new DrawableRect(rand.nextInt(400), rand.nextInt(300),
                    rand.nextInt(400) + w, rand.nextInt(300) + h,
                    new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }

        for (int i = 20; i < 30; i++) {
            shapes[i] = new ColoredRect(rand.nextInt(400), rand.nextInt(300),
                    rand.nextInt(400) + w, rand.nextInt(300) + h,
                    new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)),
                    new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }

        for (int i = 0; i < total; i++) {
            dx[i] = rand.nextInt(9) + 2;
            dy[i] = rand.nextInt(9) + 2;
        }

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void run() {
        while (running) {
            animate();
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void animate() {
        int w = getWidth();
        int h = getHeight();

        for (int i = 0; i < shapes.length; i++) {
            Rectangle r = shapes[i];

            if (r.x1 + dx[i] < 0 || r.x2 + dx[i] > w)
                dx[i] = -dx[i];
            if (r.y1 + dy[i] < 0 || r.y2 + dy[i] > h)
                dy[i] = -dy[i];

            r.move(dx[i], dy[i]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle r : shapes) {
            r.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("BouncingBox");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.add(new BouncingBox());
        f.setVisible(true);
    }
}
