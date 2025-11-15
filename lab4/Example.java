package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Example extends JFrame implements MouseListener, MouseMotionListener {

    private int lastX, lastY;
    private final DrawPanel drawPanel;
    private java.util.List<Line> lines; // Храним все нарисованные линии

    public Example() {
        super("Scribble — Рисовалка на Swing");

        lines = new java.util.ArrayList<>();
        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(this);
        drawPanel.addMouseMotionListener(this);

        // Создаем панель для кнопки
        JPanel buttonPanel = new JPanel();
        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener(e -> clearDrawing());
        buttonPanel.add(clearButton);

        this.add(drawPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // центрируем окно
        this.setVisible(true);
    }

    // Реализация MouseListener
    @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
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

    // Реализация MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX(), y = e.getY();

        // Сохраняем линию в списке
        lines.add(new Line(lastX, lastY, x, y));

        // Перерисовываем панель
        drawPanel.repaint();

        lastX = x;
        lastY = y;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    // Метод для очистки рисунка
    private void clearDrawing() {
        lines.clear();
        drawPanel.repaint();
    }

    // Класс для хранения информации о линии
    private static class Line {
        int x1, y1, x2, y2;

        Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    // Панель для рисования
    private class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));

            // Рисуем все сохраненные линии
            for (Line line : lines) {
                g2.drawLine(line.x1, line.y1, line.x2, line.y2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Example::new);
    }
}