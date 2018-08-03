package Enemies;
import Game.Character;
import Game.SpriteAnimation;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

public class JuppsTheo extends MeleeEnemy {
    
    SpriteAnimation theo;
    private final int count = 4;
    private final int columns = 4;
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final Duration duration = Duration.millis(500);
    private final Animation animation;
    
    public JuppsTheo(String img, int health, int coin, int width, int height) {
        super(img, health, coin, width, height);
        super.getChildren().remove(iv);
        theo = new SpriteAnimation(img, count, columns, offsetX, offsetY, width, height, duration);
        animation = theo;
        iv = theo.getIV();
        iv.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        getChildren().addAll(iv);
    }
    
    public void move(Character player, double width, double height) {
        animation.play();
        //there is a plus 20 for X since snake width is very small
	if (player.getX() + 20 > this.getX() && player.getY() - 30 == this.getY()) { //right
            theo.setOffset(0, 0);
            this.moveX(2, width);
        }
        if (player.getX() + 20 < this.getX() && player.getY() - 30 == this.getY()) { //left
            theo.setOffset(0, 70);
            this.moveX(-2, width);
        }
        if (player.getX() + 20 == this.getX() && player.getY() - 30 > this.getY()) { //down
            theo.setOffset(0, 216);
            this.moveY(2, height);
        }
        if (player.getX() + 20 == this.getX() && player.getY() - 30 < this.getY()) { //up
            theo.setOffset(0, 138);
            this.moveY(-2, height);
        }

        if (player.getX() + 20 > this.getX() && player.getY() - 30 < this.getY()) { //quadrant1
            theo.setOffset(0, 0);
            this.moveX(1, width);
            this.moveY(-1, height);
        }
        if (player.getX() + 20 < this.getX() && player.getY() - 30 < this.getY()) { //quadrant2
            theo.setOffset(0, 70);
            this.moveX(-1, width);
            this.moveY(-1, height);
        }
        if (player.getX() + 20 < this.getX() && player.getY() - 30 > this.getY()) { //quadrant3
            theo.setOffset(0, 70);
            this.moveX(-1, width);
            this.moveY(1, height);
        }
        if (player.getX() + 20 > this.getX() && player.getY() - 30 > this.getY()) { //quadrant4
            theo.setOffset(0, 0);
            this.moveX(1, width);
            this.moveY(1, height);
        }
    }
    
    public void hitView(Enemy enemy) {
        theo.setOffset(0, 0);
    }
}