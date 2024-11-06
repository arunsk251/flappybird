import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
class Obstacle {
    int x, y, width, height;
    boolean passed;
    Image img;

    public Obstacle(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.passed = false;
    }

    public void update(int velocityX) {
        x += velocityX;
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}
