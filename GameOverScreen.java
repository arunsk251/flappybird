import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen {

    private JFrame frame;

    // Constructor to display the Game Over screen
    public GameOverScreen(String imagePath) {
        // Create a new frame (window)
        frame = new JFrame("Game Over");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a custom panel with a background image
        BackgroundPanel panel = new BackgroundPanel(imagePath);
        panel.setLayout(new BorderLayout());

        // Create a label to display the "Game Over" message
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameOverLabel.setForeground(Color.WHITE); // Set text color for better contrast
        panel.add(gameOverLabel, BorderLayout.NORTH);

        // Create a panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the button panel transparent to show the background
        buttonPanel.setLayout(new FlowLayout());

        // Create a "Retry" button
        JButton retryButton = new JButton("Retry");
        retryButton.setFont(new Font("Arial", Font.PLAIN, 20));
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    // Custom JPanel to display the background image
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            // Load the background image
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image to fill the panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Provide the path to your background image when creating GameOverScreen
        new GameOverScreen("bg.jpg");
    }
}