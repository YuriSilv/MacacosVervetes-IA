package ambiente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle{
   
    /**
     * Bloco que bloqueia o caminho
     * @param x
     * @param y 
     */
    public Blocks(int x, int y){
        super(x,y,32,32);
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }
}
