import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;

    // Images
    Image backgroundImg, birdImg, topPipeImg, bottomPipeImg;

    // Player (Bird)
    Player player;

    // Obstacles (Pipes)
    ArrayList<Obstacle> obstacles;
    Random random = new Random();

    // Score Manager
    ScoreManager scoreManager;

    // Game Logic
    Timer gameLoop;
    Timer placePipeTimer;
    int velocityX = -4;
    boolean gameOver = false;

    public Game() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        // Load images
        backgroundImg = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("bottompipe.png")).getImage();

        // Initialize player, obstacles, and score manager
        player = new Player(boardWidth / 8, boardHeight / 2, 34, 24, birdImg);
        obstacles = new ArrayList<>();
        scoreManager = new ScoreManager();

        // Timers
        placePipeTimer = new Timer(1500, e -> placePipes());
        placePipeTimer.start();

        gameLoop = new Timer(1000 / 60, this); // Game loop running at ~60 FPS
        gameLoop.start();
    }

    public void placePipes() {
        int pipeHeight = 512;
        int randomPipeY = (int) (0 - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = boardHeight / 4;

        Obstacle topPipe = new Obstacle(boardWidth, randomPipeY, 64, pipeHeight, topPipeImg);
        Obstacle bottomPipe = new Obstacle(boardWidth, randomPipeY + pipeHeight + openingSpace, 64, pipeHeight, bottomPipeImg);

        obstacles.add(topPipe);
        obstacles.add(bottomPipe);
    }

    public void move() {
        player.update();  // Update player movement

        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle pipe = obstacles.get(i);
            pipe.update(velocityX);  // Move pipes

            // Check if player passed the pipe for scoring
            if (!pipe.passed && player.x > pipe.x + pipe.width) {
                scoreManager.increaseScore();
                pipe.passed = true;
            }

            // Collision detection
            if (collision(player, pipe)) {
                gameOver = true;
            }
        }

        if (player.y > boardHeight) {  // Bird hits the ground
            gameOver = true;
        }
    }

    public boolean collision(Player player, Obstacle pipe) {
        return player.x < pipe.x + pipe.width &&
                player.x + player.width > pipe.x &&
                player.y < pipe.y + pipe.height &&
                player.y + player.height > pipe.y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        // Draw player (bird)
        player.draw(g);

        // Draw obstacles (pipes)
        for (Obstacle pipe : obstacles) {
            pipe.draw(g);
        }

        // Draw score
        scoreManager.draw(g, gameOver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();  // Update game objects
        repaint();  // Redraw the screen

        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump();

            if (gameOver) {
                resetGame();
            }
        }
    }

    private void resetGame() {
        player.y = boardHeight / 2;
        player.velocityY = 0;
        obstacles.clear();
        scoreManager.reset();
        gameOver = false;
        placePipeTimer.start();
        gameLoop.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
