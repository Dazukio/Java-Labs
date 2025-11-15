package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Z1 extends JFrame implements MouseListener, MouseMotionListener {

    private int lastX, lastY;
    private Color currentColor = Color.BLACK;
    private final DrawPanel drawPanel;
    private final Random random = new Random();
    private final List<BrushStroke> brushStrokes;

    public Z1() {
        super("Scribble Pro — улучшенная рисовалка");

        brushStrokes = new ArrayList<>();
        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(this);
        drawPanel.addMouseMotionListener(this);

        JPanel buttonPanel = new JPanel();
        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener(e -> clearDrawing());
        buttonPanel.add(clearButton);

        this.add(drawPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            lastX = e.getX();
            lastY = e.getY();
        } else if (SwingUtilities.isRightMouseButton(e)) {
            currentColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            int x = e.getX();
            int y = e.getY();

            boolean drawCircles = true; // <-- меняй на false, чтобы были квадраты
            int size = 10;

            brushStrokes.add(new BrushStroke(x, y, size, currentColor, drawCircles));

            drawPanel.repaint();

            lastX = x;
            lastY = y;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private void clearDrawing() {
        brushStrokes.clear();
        drawPanel.repaint();
    }

    private static class BrushStroke {
        int x, y, size;
        Color color;
        boolean isCircle;

        BrushStroke(int x, int y, int size, Color color, boolean isCircle) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
            this.isCircle = isCircle;
        }
    }

    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            for (BrushStroke stroke : brushStrokes) {
                g2.setColor(stroke.color);
                if (stroke.isCircle) {
                    g2.fillOval(stroke.x - stroke.size / 2, stroke.y - stroke.size / 2, stroke.size, stroke.size);
                } else {
                    g2.fillRect(stroke.x - stroke.size / 2, stroke.y - stroke.size / 2, stroke.size, stroke.size);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Z1::new);
    }
}