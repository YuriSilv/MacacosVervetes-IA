package Agents;

import Ambiente.Aguia;
import Ambiente.Cobra;
import Ambiente.Mundo;
import Ambiente.Tigre;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;
import Sensores.Listen;
import Sensores.See;
import Sprites.SpriteSheet;

public class Macaco extends Vector2D{
    
    private final Random random = new Random();
    private Listen sensorListen;
    private See sensorSee;
    private Tabela simbolos;
    private float fatorConvergencia = 0.1f;
    
    public Macaco(int x, int y) {
        super(x, y);
        sensorListen = new Listen(x, y, 200);
       // sensorSee = new See(x,y, See.range, y);
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
   
    public void update(Tigre tigre, Cobra cobra, Aguia aguia){
        move();
        sensorListen.update(x, y, tigre, cobra, aguia);
        if(sensorListen.getMessage() == 1){
            speak();
            sensorListen.setMessage(0);
        }
        //sensorSee.update(x, y, (Tigre) agente);
    }
    
    public void render(Graphics g){
        sensorListen.render(g);
        //sensorSee.render(g);
        
        //g.setColor(new Color(90, 70, 60));
        //g.fillRect(x, y, width, height);
        g.drawImage(SpriteSheet.player, x, y, 64, 64, null);
    }
    
    public void speak(){
       int msgs[] = sensorListen.sendMessage(Mundo.macaco, simbolos.maxValueOnCollumn(0), this);
       if(msgs[1] != -1 && msgs[0] != -1) {
    	   updateTable(msgs[1], 0, msgs[0]);
       }
       
    }
    
    public void updateTable(int agente, int col, int row){
        System.out.println(Mundo.macaco[agente].simbolos.tabela[col][row]);
        //Mundo.macaco[agente].simbolos.tabela[col][row] += fatorConvergencia;
        //System.out.println(Mundo.macaco[agente].simbolos.tabela[col][row]);
    }
}
