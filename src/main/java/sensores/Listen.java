package sensores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class Listen extends Ellipse2D.Double {
    protected int type;
    
    public Listen(double x, double y, double diametro){
        super(x,y, diametro, diametro);
    }
    
    public void update(int posX, int posY){
        x = posX+16; //centralizar
        y = posY;
    }
    
    public void render(Graphics g){
        g.setColor(new Color(0, 255, 0, 50));
        g.drawOval((int) (x - this.getWidth()/2) , (int) (y - this.getWidth()/2), (int) this.getWidth(), (int)this.getHeight());  
    }
}
