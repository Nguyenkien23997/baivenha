import javax.swing.*;

public class window extends JFrame {
    private game Game;
    private long lastTime = 0;

    public window() {
        this.setSize(1024, 600);
        this.setupGame();
        this.setVisible(true);
    }

    public void setupGame() {
        this.Game = new game();
        this.add(this.Game);

    }

    public void gameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                this.Game.renderAll();
            }
        }
    }

}
