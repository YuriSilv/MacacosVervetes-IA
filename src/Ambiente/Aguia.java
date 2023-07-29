package Ambiente;

import java.awt.Graphics;
import java.util.Random;

import Agents.Vector2D;
import Sprites.SpriteSheet;

public class Aguia extends Vector2D{
    
    private final Random random = new Random();
    
    public Aguia(int x, int y) {
        super(x, y);
        this.speed = 32;
        this.speed_col = 40;
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
    	g.drawImage(SpriteSheet.aguia, x, y, 64, 64, null);
    }

}
