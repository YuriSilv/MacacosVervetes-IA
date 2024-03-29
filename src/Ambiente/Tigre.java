package Ambiente;

import Agents.Vector2D;
import Sprites.SpriteSheet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tigre extends Vector2D{
    
    private final Random random = new Random();
    
    public Tigre(int x, int y) {
        super(x, y);
        this.speed = 24;
        this.speed_col = 32;
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
    	g.drawImage(SpriteSheet.tigre, x, y, 64, 64, null);
    }
    
}
