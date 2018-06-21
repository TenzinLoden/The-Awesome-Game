//package pkg2dsidescroll; //(Ray's Package)

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Character extends Pane {

    ImageView iv;
    int offsetX = 0;
    int offsetY = 0;
    int width = 66;
    int height = 33;
    int x;
    int y;
    
    public Character(ImageView iv, int posX, int posY) {
        this.iv = iv;
        this.iv.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.x = posX;
        this.y = posY;
        this.getChildren().addAll(iv);
    }
    
    public void setCharacterView(int offsetX, int offsetY) {
        this.iv.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
    }
    
    public void moveX(int x, double width) {
        boolean right = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            if (right)
            {
                if(this.x > width - this.width)
                    this.setTranslateX(width - this.width);
                else
                {
                    this.setTranslateX(this.getTranslateX() + 1);
                    this.x++;
                }
            }
            else 
            {
                if(this.x < 0)
                    this.setTranslateX(0);
                else
                {
                    this.setTranslateX(this.getTranslateX() - 1);
                    this.x--;
                }
            }
        }
    }
    
    public void moveY(int y, double height) {
        boolean down = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down)
            {
                if(this.y > height - this.height)
                    this.setTranslateY(height - this.height);
                else
                {
                    this.setTranslateY(this.getTranslateY() + 1);
                    this.y++;
                }
            }
            else 
            {
                if(this.y < 0)
                    this.setTranslateY(0);
                else
                {
                    this.setTranslateY(this.getTranslateY() - 1);
                    this.y--;
                }
            }
        }
    }
}