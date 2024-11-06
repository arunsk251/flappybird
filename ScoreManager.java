import java.awt.*;

class ScoreManager
{
    private double score = 1;

    public void increaseScore() {
        score += 0.5; // Increment by 0.5 for each pipe passed
    }

    public int getScore() {
        return (int) score;
    }

    public void reset() {
        score = 0;
    }

    public void draw(Graphics g, boolean gameOver) {
        /*g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + getScore(), 10, 35);
        } else {
            g.drawString(String.valueOf(getScore()), 10, 35);
        }*/
        if (gameOver == true )
        {   
           GameOverScreen ggGameOverScreen = new GameOverScreen("bg.jpg");
            

        } else
        {
            g.drawString(String.valueOf(getScore()), 10, 35);
        }

    }
}
