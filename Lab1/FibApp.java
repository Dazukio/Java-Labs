import javax.swing.*;
import java.awt.*;

public class FibApp {

    public static int Fib(int n) {
        if (n <= 0) return -1;
        if (n == 1 || n == 2) return 1;
        int a = 1, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus недоступен, используем стандартный стиль.");
        }

        // Creating frame
        JFrame frame = new JFrame("Fibonacci Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Panel w/ GridLayout (3 row, 2 col, margin 10px)
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Creating elements
        JLabel inputLabel = new JLabel("Enter N: ");
        JTextField textField = new JTextField(10);
        JButton btn = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");
        JLabel output = new JLabel("...");

        // Making it stylish
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBackground(new Color(70, 130, 180)); // синий
        btn.setForeground(Color.WHITE);

        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        output.setFont(new Font("Consolas", Font.PLAIN, 14));
        output.setForeground(Color.BLUE);

        // Buttond handler
        btn.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textField.getText());
                int result = Fib(n);
                if (result == -1) {
                    output.setText("Enter N > 0");
                } else {
                    output.setText(String.valueOf(result));
                }
            } catch (Exception ex) {
                output.setText("Input error!");
            }
        });

        // Adding elements to the panel
        panel.add(inputLabel);
        panel.add(textField);
        panel.add(btn);
        panel.add(new JLabel("")); // empty cell for alignment 
        panel.add(resultLabel);
        panel.add(output);

        // Adding panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
