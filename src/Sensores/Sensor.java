package Sensores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import Agents.Macaco;
import Ambiente.Aguia;
import Ambiente.Cobra;
import Ambiente.Tigre;

public class Sensor extends Ellipse2D.Double {

    protected int countSignal = 5;
    private int message = -1; // 0 é tigre, 1 é cobra e 2 é aguia
    
    public Sensor(double x, double y, double diametro){
        super(x-diametro/2, y-diametro/2, diametro, diametro);
    }
    
    public void update(int posX, int posY, Tigre tigre, Cobra cobra, Aguia aguia){
        x = posX+16 - this.getWidth()/2; //centralizar
        y = posY - this.getWidth()/2;
        

        if(this.intersects(tigre) && countSignal <= 0){
            setMessage(0);
            countSignal = 20;
        }
        
        if(this.intersects(cobra) && countSignal <= 0){
            setMessage(1);
            countSignal = 20;
        }
        
        if(this.intersects(aguia) && countSignal <= 0){
            setMessage(2);
            countSignal = 20;
        }
        
        countSignal -=1;
    }
    
    public void render(Graphics g){
        g.setColor(new Color(254, 174, 52, 150));
        g.drawOval((int) (x) , (int) (y), (int) this.getWidth(), (int)this.getHeight());  
    }
    
    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
