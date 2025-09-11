import javax.swing.*;
import java.awt.*;


public class Eratos {

    public static boolean prime(int N){
        for (int i = 2; i < Math.sqrt(N)+1; i++){
            if (N % i == 0){return false;}
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus is unavailable");
        }

        // Creating frame
        JFrame frame = new JFrame("Sieve of Eratosthenes");
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
        JTextArea output = new JTextArea(5, 20);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(output);

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
                StringBuilder result = new StringBuilder();
                // int count = 0;

                for (int i = 2; i <= n; i++) {
                    if (prime(i)) {
                    result.append(i).append(" ");
                    // count++;
                    // if (count % 10 == 0) result.append("\n");
            }
        }
        output.setText(result.toString());
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
        panel.add(scrollPane);

        // Adding panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}