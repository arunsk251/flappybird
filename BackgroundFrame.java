import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundFrame extends JFrame {
    public BackgroundFrame() {
        // Set up the JFrame
        setTitle("LEVELS");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create a custom panel with background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("bg.jpg");

        // Set the layout to BoxLayout with Y_AXIS for vertical stacking
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        // Create buttons for levels
        JButton button1 = new JButton("EASY");
        JButton button2 = new JButton("MEDIUM");
        JButton button3 = new JButton("HARD");

        // Center the buttons and add some spacing around them
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to buttons
        button1.addActionListener(new ButtonActionListener(-4)); // Easy: velocityX = -4
        button2.addActionListener(new ButtonActionListener(-8)); // Medium: velocityX = -8
        button3.addActionListener(new ButtonActionListener(-12)); // Hard: velocityX = -12

        // Add buttons to the panel with some vertical spacing
        backgroundPanel.add(Box.createVerticalGlue()); // Add space at the top
        backgroundPanel.add(button1);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add spacing between buttons
        backgroundPanel.add(button2);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add spacing between buttons
        backgroundPanel.add(button3);
        backgroundPanel.add(Box.createVerticalGlue()); // Add space at the bottom

        // Add the custom panel to the frame
        add(backgroundPanel);

        setVisible(true); // Display the frame
    }

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

    private class ButtonActionListener implements ActionListener {
        private int velocityX;

        public ButtonActionListener(int velocityX) {
            this.velocityX = velocityX;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Game flappyBird = new Game(velocityX); // Pass selected velocity to Game constructor
            openGameWindow(flappyBird); // Open game window with selected velocity
            dispose(); // Close the level selection window after selection
        }

        private void openGameWindow(Game flappyBird) {
            JFrame gameFrame = new JFrame("Flappy Bird Game");
            gameFrame.setSize(360, 640);
            gameFrame.setLocationRelativeTo(null);
            gameFrame.setResizable(false);
            gameFrame.add(flappyBird); // Adds game to the JFrame
            gameFrame.pack();
            flappyBird.requestFocus(); // Requests focus for keyboard input
            gameFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BackgroundFrame::new);
    }
}