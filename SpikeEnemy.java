//A.K.A Spikey

import java.util.List;
import javafx.scene.layout.Pane;

public class SpikeEnemy extends RangedEnemy {

    public SpikeEnemy(String img, int health, int coin, int width, int height, int shootSpeed) {
        super(img, health, coin, width, height, shootSpeed);
    }
    
    public void move(Character player, double width, double height) {
	if (player.getX() > this.getX() && player.getY() == this.getY()) { //right
            this.setCharacterView(3, 194);
            this.moveX(1, width, 1);
        }
        if (player.getX() < this.getX() && player.getY() == this.getY()) { //left
            this.setCharacterView(3, 65);
            this.moveX(-1, width, 1);
        }
        if (player.getX() == this.getX() && player.getY() > this.getY()) { //down
            this.setCharacterView(3, 0);
            this.moveY(1, height, 1);
        }
        if (player.getX() == this.getX() && player.getY() < this.getY()) { //up
            this.setCharacterView(3, 130);
            this.moveY(-1, height, 1);
        }

        if (player.getX() > this.getX() && player.getY() < this.getY()) { //quadrant1
            this.setCharacterView(74, 130);
            this.moveX(1, width, 1);
            this.moveY(-1, height, 1);
        }
        if (player.getX() < this.getX() && player.getY() < this.getY()) { //quadrant2
            this.setCharacterView(74, 65);
            this.moveX(-1, width, 1);
            this.moveY(-1, height, 1);
        }
        if (player.getX() < this.getX() && player.getY() > this.getY()) { //quadrant3
            this.setCharacterView(74, 0);
            this.moveX(-1, width, 1);
            this.moveY(1, height, 1);
        }
        if (player.getX() > this.getX() && player.getY() > this.getY()) { //quadrant4
            this.setCharacterView(74, 194);
            this.moveX(1, width, 1);
            this.moveY(1, height, 1);
        }
    }
    
    public void shoot(Character player, List<Projectile> projectiles, Pane gameRoot) {
        long timeNow = System.currentTimeMillis();
        long time = timeNow - timeOfLastProjectile;

        if (time < 0 || time > this.getShootSpeed()) {
            Spikes spike = new Spikes()
            //createProjectile(0, 0, projectiles, gameRoot, "file:src/Sprites/Spikes.png", 28, 28);
            timeOfLastProjectile = timeNow;
        }
    }
    
    public void hitView(Enemy enemy){
        this.setCharacterView(3, 0);
    }
}
