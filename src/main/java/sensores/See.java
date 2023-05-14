package sensores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.Random;

public class See extends Line2D.Double{
    
    public static double range = 400;
    Random random = new Random();
    
    public See(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY);
    }
    
    public void update(int posX, int posY){
        int multiplicadoAleatorio = random.nextInt(5)+1;
        
        int randomInt = random.nextInt(100000) * multiplicadoAleatorio;
        if(randomInt > 40000){
            x1 = posX;
            y1 = posY+16; //16 para centralizar

            x2= posX+range;
            y2 = posY;
        }else if (randomInt <= 40000 && randomInt > 10000){
            x1 = posX;
            y1 = posY+16;

            x2= posX-range;
            y2 = posY;
        }
        else if (randomInt <= 10000 && randomInt > 5000){
            x1 = posX+16;
            y1 = posY; 

            x2= posX+16;
            y2 = posY-range;
        }
        else{
            x1 = posX+16;
            y1 = posY; 

            x2= posX+16;
            y2 = posY+range;
        }
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawLine((int) this.getX1(), (int) this.getY1(), (int) this.getX2(),(int) this.getY2()+16);
    }
    
}
