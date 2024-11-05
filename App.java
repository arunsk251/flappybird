/*import javax.swing.*;

public class App {
    public static void main(String[] args) {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game game = new Game(); // Ensure Game class extends JPanel
        frame.add(game);  // Adds game to the JFrame
        frame.pack();
        game.requestFocus(); // Requests focus for keyboard input
        frame.setVisible(true);
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

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

                // Assuming image files exist in the same directory
                Image image = new ImageIcon("bg.jpg").getImage();
                Image textimage = new ImageIcon("FLAPPY BIRD.jpg").getImage();
                Image sideimage = new ImageIcon("Rectangle 1.png").getImage();
                Image startimage = new ImageIcon("Group 8.png").getImage();
                Image settingimage = new ImageIcon("Group 11.png").getImage();

                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                g.drawImage(textimage, 50, 50, 250, 100, null);
                g.drawImage(sideimage, 50, 200, 250, 200, null);
                g.drawImage(startimage, 100, 220, 150, 55, null);
                g.drawImage(settingimage, 100, 300, 150, 55, null);

                // Create a Rectangle to represent the clickable area
                Rectangle startImageRect = new Rectangle(100, 220, 150, 55);

                // Add a MouseListener for click detection
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (startImageRect.contains(e.getPoint())) {
                            // Replace with your Game class implementation
                            Game flappyBird = new Game();
                            JFrame newf = new JFrame();
                            newf.setSize(boardWidth, boardHeight);
                            newf.setLocationRelativeTo(null);
                            newf.setResizable(false);

                             // Pass the JFrame for interaction
                            //nframe.setContentPane(flappyBird);
                            newf.add(flappyBird);  // Adds game to the JFrame
                            newf.pack();
                            flappyBird.requestFocus(); // Requests focus for keyboard input
                            newf.setVisible(true);

                            nframe.add(newf);  // Adds game to the JFrame
                            nframe.pack();
                   
                            nframe.setVisible(true);
                        }
                    }
                
                   
                });
                addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_A) {
                            Game flappyBird = new Game();
                            JFrame newf = new JFrame();
                            newf.setSize(boardWidth, boardHeight);
                            newf.setLocationRelativeTo(null);
                            newf.setResizable(false);

                             // Pass the JFrame for interaction
                            //nframe.setContentPane(flappyBird);
                            newf.add(flappyBird);  // Adds game to the JFrame
                            newf.pack();
                            flappyBird.requestFocus(); // Requests focus for keyboard input
                            newf.setVisible(true);

                            nframe.add(newf);  // Adds game to the JFrame
                            nframe.pack();
                   
                            nframe.setVisible(true);
                        }
                    }
                });
                
            }
        };

        nframe.setContentPane(panel);
        nframe.setVisible(true);
    }
}