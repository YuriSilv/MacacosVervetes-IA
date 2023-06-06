package agentes;

import ambiente.Tigre;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import sensores.Listen;
import sensores.See;

public class Macaco extends Vector2D{
    
    private final Random random = new Random();
    private Listen sensorListen;
    private See sensorSee;
    private Tabela simbolos;
    
    
    public Macaco(int x, int y) {
        super(x, y);
        sensorListen = new Listen(x, y, 200);
        sensorSee = new See(x,y, See.range, y);
        simbolos = new Tabela();
    }
    
    /**
     * Move o macaco
     */
    public void move(){
        int randomInt = random.nextInt(4) + 1;
        
        if(randomInt == 1 && !this.getCollide(x+32, y).equals("parede")){
            x += speed;
        }
        else if(randomInt == 2 && !this.getCollide(x-32, y).equals("parede")){
            x -= speed;
        }
        else if(randomInt == 3 && !this.getCollide(x, y-32).equals("parede")){
            y -= speed;
        }
        else if(randomInt == 4 && !this.getCollide(x, y+32).equals("parede")){
            y += speed;
        }
    }
   
    public void update(Vector2D agente){
        move();
        sensorListen.update(x, y, (Tigre) agente);
        if(sensorListen.getMessage() == 1){
            System.out.println(simbolos.maxValueOnCollumn(0));
            sensorListen.setMessage(0);
        }
        sensorSee.update(x, y, (Tigre) agente);
    }
    
    public void render(Graphics g){
        sensorListen.render(g);
        sensorSee.render(g);
        
        g.setColor(new Color(90, 70, 60));
        g.fillRect(x, y, width, height);
    }
    
}
