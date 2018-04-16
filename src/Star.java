import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public Vector2D position;
    public BufferedImage image;
    public int width;
    public int height;
    public Vector2D velocity;

    public Star(Vector2D position, int width, int height, BufferedImage image, Vector2D velocity) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.image = image;
        this.velocity = velocity;
    }

    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.height, this.width, null);
    }
}
