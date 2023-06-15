package Ambiente;

import Agents.Macaco;
import Sprites.SpriteSheet;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Mundo {
    
    public static List<Blocks> bloqueios = new ArrayList<>();
    public static Tigre tigre;
    public static Cobra cobra;
    public static Aguia aguia;
    public static String objCollision[] = {"parede", "tigre"};
    public static Macaco macaco[] = new Macaco[3];
    
    
    public Mundo(){
        for(int xx = 0; xx < 40; xx++){
            bloqueios.add(new Blocks(xx*32, 0));
            bloqueios.add(new Blocks(xx*32, 608));
        }
        
        for(int yy = 0; yy < 20; yy++){
            bloqueios.add(new Blocks(0, yy*32));
            bloqueios.add(new Blocks(1248, yy*32));
        }
        macaco[0] = new Macaco(640,220);
        macaco[1] = new Macaco(640,220);
        macaco[2] = new Macaco(200,150);
        tigre = new Tigre(200, 150);
        aguia = new Aguia(550, 220);
        cobra = new Cobra(200, 150);
    }
    /**
     * Checa se um objeto colidiu com ele
     * @param x pos x
     * @param y pos y
     * @return true se a colissão ocorreu
     */
    public static String collision(int x, int y){
        for (Blocks bloqueio : bloqueios) {
            if(bloqueio.intersects(new Rectangle(x,y,32,32))){
                return objCollision[0];
            }
        }
        
        if(tigre.intersects(new Rectangle(x,y,32,32))){
            return objCollision[1];
        }
        
        return "";
    }
    public void update(){
        macaco[0].update(tigre, cobra, aguia);
        macaco[1].update(tigre, cobra, aguia);
        macaco[2].update(tigre, cobra, aguia);
        tigre.update();
        aguia.update();
        cobra.update();
    }
    
    public void render(Graphics g){
        for (Blocks bloqueio : bloqueios) {
            bloqueio.render(g);
        }
        
        for(int xx = 0; xx < 38; xx++){
        	for(int yy = 0; yy < 18; yy++) {
        		g.drawImage(SpriteSheet.floor, 32+xx*32, 32+yy*32, 32, 32, null);
        	}
    	    
        }
        
        for(int xx = 32; xx < 40; xx++){
    	   
        }
        
        macaco[0].render(g);
        macaco[1].render(g);
        macaco[2].render(g);
        tigre.render(g);
        cobra.render(g);
        aguia.render(g);
    }
}

