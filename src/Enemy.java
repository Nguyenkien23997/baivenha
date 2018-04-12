import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityX;
    public BufferedImage image;

    public Enemy(int x,int y,int width,int height, int velocityX, BufferedImage image){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.velocityX=velocityX;
        this.image=image;
    }
    public void run(){
        this.x += this.velocityX;
    }
    public void paint(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,this.width,this.height,null);
    }
}
