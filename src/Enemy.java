import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;
    public BufferedImage image;

    public Enemy(Vector2D position, int width, int height, Vector2D velocity, BufferedImage image) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.image = image;
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
    }
}
