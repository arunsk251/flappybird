import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class Player {
    int x, y, width, height, velocityY, gravity = 1;
    Image img;

    public Player(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.velocityY = 0;
    }

    public void update() {
        velocityY += gravity;
        y += velocityY;
        y = Math.max(y, 0); // Limit bird to not go above the canvas
    }

    public void jump() {
        velocityY = -9; // Bird jumps
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}
