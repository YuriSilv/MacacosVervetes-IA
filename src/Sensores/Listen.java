package Sensores;

import Agents.Macaco;
import Agents.Vector2D;
import Ambiente.Aguia;
import Ambiente.Cobra;
import Ambiente.Tigre;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Listen extends Ellipse2D.Double {
    protected int countSignal = 0;
    private int message = -1; // 0 é tigre, 1 é cobra e 2 é aguia
    
    public Listen(double x, double y, double diametro){
        super(x-diametro/2, y-diametro/2, diametro, diametro);
    }
    
    public void update(int posX, int posY, Tigre tigre, Cobra cobra, Aguia aguia){
        x = posX+16 - this.getWidth()/2; //centralizar
        y = posY - this.getWidth()/2;
        if(this.intersects(tigre) && countSignal <= 0){
            setMessage(0);
            //System.out.println("Tigre!!");
            countSignal = 80;
        }
        
        if(this.intersects(cobra) && countSignal <= 0){
            setMessage(1);
            //System.out.println("Cobra!!");
            countSignal = 80;
        }
        
        if(this.intersects(aguia) && countSignal <= 0){
            setMessage(2);
            //System.out.println("Aguia!!");
            countSignal = 80;
        }
        
        
        countSignal -=1;
    }
    
    public void render(Graphics g){
        g.setColor(new Color(255, 250, 180, 150));
        g.drawOval((int) (x) , (int) (y), (int) this.getWidth(), (int)this.getHeight());  
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
    
    public void sendMessage(Macaco agentes[], int msg, Macaco auto){
        for(Macaco macaco : agentes){
            if(this.intersects(macaco) && macaco != auto){
                macaco.memory = msg; // linha que o simbolo de algum animal está ligado
            }
        }
    }
   
   public void observer() {
	   
   }
}