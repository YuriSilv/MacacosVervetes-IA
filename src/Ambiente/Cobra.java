package Ambiente;

import java.awt.Graphics;
import java.util.Random;

import Agents.Vector2D;
import Sprites.SpriteSheet;

public class Cobra extends Vector2D{
    
    private final Random random = new Random();
    
    public Cobra(int x, int y) {
        super(x, y);
    }
    
    public void move(){
        int randomInt = random.nextInt(4) + 1;
        
        if(randomInt == 1 && !this.getCollide(x+speed_col, y).equals("parede")){
            x += speed;
        }
        else if(randomInt == 2 && !this.getCollide(x-speed_col, y).equals("parede")){
            x -= speed;
        }
        else if(randomInt == 3 && !this.getCollide(x, y-speed_col).equals("parede")){
            y -= speed;
        }
        else if(randomInt == 4 && !this.getCollide(x, y+speed_col).equals("parede")){
            y += speed;
        }
    }
    
    public void update(){
        move();
    }
    
    public void render(Graphics g){
    	g.drawImage(SpriteSheet.cobra, x, y, 64, 64, null);
    }

}
