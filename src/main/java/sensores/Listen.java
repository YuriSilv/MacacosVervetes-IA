package sensores;

import agentes.Vector2D;
import ambiente.Tigre;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Listen extends Ellipse2D.Double {
    protected int countSignal = 0;
    private int message = 0;
    
    public Listen(double x, double y, double diametro){
        super(x-diametro/2, y-diametro/2, diametro, diametro);
    }
    
    public void update(int posX, int posY, Tigre agente){
        x = posX+16 - this.getWidth()/2; //centralizar
        y = posY - this.getWidth()/2;
        if(this.intersects(agente) && countSignal <= 0){
            setMessage(1);
            System.out.println("Tigre!!");
            countSignal = 30;
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
    
   
}
