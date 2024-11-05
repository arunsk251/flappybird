/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen {

    public static void main(String[] args) {
        // Create a new frame (window)
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a label to display the "Game Over" message
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(gameOverLabel, BorderLayout.NORTH);

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create a "Retry" button
        JButton retryButton = new JButton("Retry");
        retryButton.setFont(new Font("Arial", Font.PLAIN, 20));
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for retrying the game here
                JOptionPane.showMessageDialog(frame, "Retrying the game...");
            }
        });
        buttonPanel.add(retryButton);

        // Create an "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        // Add the button panel to the center of the main panel
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen {

    private JFrame frame;

    // Constructor to display the Game Over screen
    public GameOverScreen() {
        // Create a new frame (window)
        frame = new JFrame("Game Over");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a label to display the "Game Over" message
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(gameOverLabel, BorderLayout.NORTH);

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create a "Retry" button
        JButton retryButton = new JButton("Retry");
        retryButton.setFont(new Font("Arial", Font.PLAIN, 20));
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for retrying the game here
                JOptionPane.showMessageDialog(frame, "Retrying the game...");
                frame.dispose(); // Close the Game Over screen
                // Call your game restart logic here
            }
        });
        buttonPanel.add(retryButton);

        // Create an "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application
                frame.dispose();
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        // Add the button panel to the center of the main panel
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}