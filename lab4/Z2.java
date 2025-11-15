package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Z2 extends JFrame {

    private final DrawPanel panel;
    private final java.util.List<lab4.Rectangle> rects = new ArrayList<>();
    private lab4.Rectangle selectedRect = null;
    private int offsetX, offsetY;
    private final Random random = new Random();

    public Z2() {
        super("Rect Applet Swing — Рисование и перетаскивание");

        panel = new DrawPanel();
        panel.setBackground(new Color(250, 250, 250));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = rects.size() - 1; i >= 0; i--) {
                    lab4.Rectangle r = rects.get(i);
                    if (contains(r, e.getX(), e.getY())) {
                        selectedRect = r;
                        offsetX = e.getX() - Math.min(r.x1, r.x2);
                        offsetY = e.getY() - Math.min(r.y1, r.y2);
                        rects.remove(i);
                        rects.add(r);
                        panel.repaint();
                        return;
                    }
                }
                selectedRect = null;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedRect = null;
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedRect != null) {
                    int newX = e.getX() - offsetX;
                    int newY = e.getY() - offsetY;

                    int width = Math.abs(selectedRect.x2 - selectedRect.x1);
                    int height = Math.abs(selectedRect.y2 - selectedRect.y1);

                    selectedRect.x1 = newX;
                    selectedRect.y1 = newY;
                    selectedRect.x2 = newX + width;
                    selectedRect.y2 = newY + height;

                    panel.repaint();
                }
            }
        });

        JButton btnRect = makeButton("Rectangle", new Color(0x4CAF50));
        JButton btnDrawable = makeButton("DrawableRect", new Color(0x2196F3));
        JButton btnColored = makeButton("ColoredRect", new Color(0xE91E63));
        JButton btnClear = makeButton("Очистить", new Color(0x9E9E9E));

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(245, 245, 245));
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        buttons.add(btnRect);
        buttons.add(btnDrawable);
        buttons.add(btnColored);
        buttons.add(btnClear);

        btnRect.addActionListener(e -> {
            int x1 = randomX();
            int y1 = randomY();
            int width = 80;
            int height = 60;
            rects.add(new lab4.Rectangle(x1, y1, x1 + width, y1 + height));
            panel.repaint();
        });

        btnDrawable.addActionListener(e -> {
            int x1 = randomX();
            int y1 = randomY();
            int width = 100;
            int height = 70;
            rects.add(new DrawableRect(x1, y1, x1 + width, y1 + height, randomColor()));
            panel.repaint();
        });

        btnColored.addActionListener(e -> {
            int x1 = randomX();
            int y1 = randomY();
            int width = 100;
            int height = 70;
            rects.add(new ColoredRect(x1, y1, x1 + width, y1 + height,
                    randomColor(), randomColor()));
            panel.repaint();
        });

        btnClear.addActionListener(e -> {
            rects.clear();
            panel.repaint();
        });

        this.setLayout(new BorderLayout());
        this.add(buttons, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JButton makeButton(String text, Color baseColor) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setBackground(baseColor);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.setBorderPainted(false);
        btn.setOpaque(true);
        Color hover = baseColor.brighter();
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(baseColor);
            }
        });
        return btn;
    }

    private boolean contains(lab4.Rectangle r, int px, int py) {
        int left = Math.min(r.x1, r.x2);
        int right = Math.max(r.x1, r.x2);
        int top = Math.min(r.y1, r.y2);
        int bottom = Math.max(r.y1, r.y2);

        return px >= left && px <= right && py >= top && py <= bottom;
    }

    private int randomX() {
        return random.nextInt(500) + 50;
    }

    private int randomY() {
        return random.nextInt(400) + 50;
    }

    private Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (lab4.Rectangle r : rects) {
                r.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Z2::new);
    }
}