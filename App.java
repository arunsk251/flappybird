import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App {
    public static void main(String[] args) {
        JFrame nframe = new JFrame("Flappy Bird");
        int boardWidth = 350;
        int boardHeight = 600;
        nframe.setSize(boardWidth, boardHeight);
        nframe.setLocationRelativeTo(null);
        nframe.setResizable(false);
        nframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Load images
                Image image = new ImageIcon("bg.jpg").getImage();
                Image textimage = new ImageIcon("FLAPPY BIRD.jpg").getImage();
                Image sideimage = new ImageIcon("Rectangle 1.png").getImage();
                Image startimage = new ImageIcon("Group 8.png").getImage();
                Image settingimage = new ImageIcon("Group 11.png").getImage();

                // Draw images
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                g.drawImage(textimage, 50, 50, 250, 100, null);
                g.drawImage(sideimage, 50, 200, 250, 200, null);
                g.drawImage(startimage, 100, 220, 150, 55, null);
                g.drawImage(settingimage, 100, 300, 150, 55, null);

                // Create rectangles for clickable areas
                Rectangle startImageRect = new Rectangle(100, 220, 150, 55);
                Rectangle settingImageRect = new Rectangle(100, 300, 150, 55);

                // Add mouse listener for click detection
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (startImageRect.contains(e.getPoint())) {
                            // Start game when start image is clicked
                            Game flappyBird = new Game(-4); // Default velocity
                            openGameWindow(flappyBird);
                        } else if (settingImageRect.contains(e.getPoint())) {
                            // Open BackgroundFrame when settings image is clicked
                            BackgroundFrame backgroundFrame = new BackgroundFrame();
                            backgroundFrame.setVisible(true); // Show level selection frame
                            nframe.dispose(); // Close current frame if desired
                        }
                    }
                });
            }
        };

        nframe.setContentPane(panel);
        nframe.setVisible(true);
    }

    private static void openGameWindow(Game flappyBird) {
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