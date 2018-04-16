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

    private List<Star> stars;
    private List<Enemy> enemies;
    private backGround background;
    private Graphics graphics;
    private BufferedImage backbuffered;
    private int countEnemy = 0;
    private int countStar = 0;
    private Random random = new Random();
    private Player player;

    public game() {
        this.setSize(1024, 600);
        this.enemies = new ArrayList<>();
        createPlayer();
        this.stars = new ArrayList<>();
        this.setupBackbuffered();
//        this.player = new Player(new Vector2D(200,200), Color.RED);
        this.setVisible(true);
    }

    private void setupBackbuffered() {
        this.backbuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backbuffered.getGraphics();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.backbuffered, 0, 0, null);
    }

//    private void setPlayer() {
//        this.player = new Player(new Vector2D(200, 200), Color.RED);
//        this.player.render(this.graphics);
//    }

    private void createEnemy() {
        if (this.countEnemy == 10) {
//            Enemy enemy = new Enemy(0, this.random.nextInt(600), 20, 20, this.random.nextInt(1) + 1, this.loadImage("resources/images/circle.png"));
            Enemy enemy = new Enemy(new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)), 20, 20, new Vector2D(this.random.nextInt(2) + 1, 0),this.loadImage("resources/images/circle.png"));
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private void createStar() {
        if (this.countStar == 40) {
            Star star = new Star(new Vector2D(1024, this.random.nextInt(600)), 5, 5, this.loadImage("resources/images/star.png"), new Vector2D(this.random.nextInt(2) + 1, 0));
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createPlayer(){
        this.player = new Player(new Vector2D(random.nextInt(1024),random.nextInt(600)),
                new Vector2D(5,5),Color.RED);
    }
    public void renderAll() {
        this.drawBackGround();
        this.enemies.forEach(enemy -> enemy.paint(graphics));
        this.stars.forEach(Star -> Star.render(graphics));
        this.player.render(this.graphics);
        this.repaint();

    }

    public void runAll() {
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
        this.createStar();
        this.stars.forEach(Star -> Star.run());
        this.createPlayer();
        this.player.run();

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
