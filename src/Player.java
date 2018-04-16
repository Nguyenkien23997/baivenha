import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    public Color color;
    private Polygon polygon;
    private List<Vector2D> vertices;
    public Vector2D velocity;

    public Player(Vector2D position,Vector2D velocity, Color color){
        this.position = position;
        this.color = color;
        this.velocity = velocity;
        this.setupPolygon();
//        this.polygon = new Polygon();
//        this.vertices = Arrays.asList(
//                new Vector2D(),new Vector2D(0,16),
//                new Vector2D(20,8)
//        );
//        this.vertices.forEach(vector2D -> polygon.addPoint((int) vector2D.x,(int) vector2D.y));

    }
    private void setupPolygon(){
        this.polygon = new Polygon();
        this.vertices = Arrays.asList(
                new Vector2D().rotate((double) 45),
                new Vector2D(0,16).rotate((double) 45),
                new Vector2D(20,8).rotate((double) 45)
        );
        this.vertices.forEach(vector2D -> polygon.addPoint((int) vector2D.x,(int) vector2D.y));
    }

    public void render(Graphics graphics){
        this.update();
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }

    private void update(){
        this.polygon.reset();
        Vector2D center = this.vertices.stream().reduce(new Vector2D(), (v1, v2) -> v1.add(v2).multiply(1.0f / (float) this.vertices.size()));
        Vector2D translate = this.position.subtract(center);
        this.vertices.stream().map(vector2D -> vector2D.add(translate)).forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));
    }

    public void run(){
        Random random = new Random();
        if (this.position.x > 1024){
            this.position.x = 0;
            this.position.y = random.nextInt(600);
        }
        else if(this.position.y > 600){
                this.position.y = 0;
                this.position.x = random.nextInt(1024);
        }
        this.position.addUp(velocity);
    }
}
