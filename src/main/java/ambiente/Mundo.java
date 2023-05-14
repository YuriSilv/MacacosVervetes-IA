package ambiente;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Mundo {
    
    public static List<Blocks> bloqueios = new ArrayList<>();
    
    
    public Mundo(){
        for(int xx = 0; xx < 40; xx++){
            bloqueios.add(new Blocks(xx*32, 0));
            bloqueios.add(new Blocks(xx*32, 608));
        }
        
        for(int yy = 0; yy < 20; yy++){
            bloqueios.add(new Blocks(0, yy*32));
            bloqueios.add(new Blocks(1248, yy*32));
        }
    }
    /**
     * Checa se um objeto colidiu com ele
     * @param x pos x
     * @param y pos y
     * @return true se a colissão ocorreu
     */
    public static boolean collision(int x, int y){
        for (Blocks bloqueio : bloqueios) {
            if(bloqueio.intersects(new Rectangle(x,y,32,32))){
                return true;
            }
        }
        
        return false;
    }
    public void update(){
        
    }
    
    public void render(Graphics g){
        for (Blocks bloqueio : bloqueios) {
            bloqueio.render(g);
        }
    }
}
