
import javax.swing.*;
import java.awt.*;

public class backGround extends JPanel {
    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;

    public backGround(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, width, height);
    }
}

