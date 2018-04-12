import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game extends JPanel {
    private Random random;
    private List<Enemy> enemies;
    private backGround background;
    private Graphics graphics;
    private BufferedImage backbuffered;
    private int countEnemy = 0;

    public game() {
        this.setSize(1024, 600);
        this.enemies = new ArrayList<>();
        this.setVisible(true);
    }

    private void setupBackbuffered() {
        this.backbuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backbuffered.getGraphics();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.backbuffered, 0, 0, null);
    }

    private void createEnemy() {
        if (this.countEnemy == 20) {
            Enemy enemy = new Enemy(0, this.random.nextInt(600), 10, 10, this.random.nextInt(3) + 1, this.loadImage("resources/images/circle.png"));
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    public void renderAll() {
        this.drawBackGround();
        this.enemies.forEach(enemy -> enemy.paint(graphics));
        this.repaint();
    }

    public void runAll() {
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
    }

    private void drawBackGround() {
        this.background = new backGround(0, 0, 1024, 600, Color.BLACK);
        this.background.render(this.graphics);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
