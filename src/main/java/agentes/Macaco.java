package agentes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import sensores.Listen;
import sensores.See;

public class Macaco extends Vector2D{
    
    private final Random random = new Random();
    private Listen sensorListen;
    private See sensorSee;
    
    
    public Macaco(int x, int y) {
        super(x, y);
        sensorListen = new Listen(x, y, 200);
        sensorSee = new See(x,y, See.range, y);
    }
    
    /**
     * Move o macaco
     */
    public void move(){
        int randomInt = random.nextInt(4) + 1;
        
        if(randomInt == 1 && !this.getCollide(x+32, y)){
            x += speed;
        }
        else if(randomInt == 2 && !this.getCollide(x-32, y)){
            x -= speed;
        }
        else if(randomInt == 3 && !this.getCollide(x, y-32)){
            y -= speed;
        }
        else if(randomInt == 4 && !this.getCollide(x, y+32)){
            y += speed;
        }
    }
   
    public void update(){
        move();
        sensorListen.update(x, y);
        sensorSee.update(x, y);
    }
    
    public void render(Graphics g){
        sensorListen.render(g);
        sensorSee.render(g);
        
        g.setColor(new Color(150, 75, 0));
        g.fillRect(x, y, width, height);
    }
    
}
