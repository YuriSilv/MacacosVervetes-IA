package Ambiente;

import Agents.Macaco;
import Agents.Tabela;
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
    public static String objCollision[] = {"parede"};
    public static Macaco macaco[] = new Macaco[4];
    
    public Mundo(){
        for(int xx = 0; xx < 40; xx++){
            bloqueios.add(new Blocks(xx*32, 0));
            bloqueios.add(new Blocks(xx*32, 608));
        }
        
        for(int yy = 0; yy < 20; yy++){
            bloqueios.add(new Blocks(0, yy*32));
            bloqueios.add(new Blocks(992, yy*32));
        }
        macaco[0] = new Macaco(352,544, "juan");
        macaco[1] = new Macaco(544,224, "camila");
        macaco[2] = new Macaco(224,544, "yuri");
        macaco[3] = new Macaco(544,288, "lana");
        tigre = new Tigre(224, 288);
        aguia = new Aguia(288, 256);
        cobra = new Cobra(320, 544);
        Tabela.createTextFile();
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
        
        return "";
    }
    public void update(){
        macaco[0].update(tigre, cobra, aguia);
        macaco[1].update(tigre, cobra, aguia);
        macaco[2].update(tigre, cobra, aguia);
        macaco[3].update(tigre, cobra, aguia);
        tigre.update();
        aguia.update();
        cobra.update();
    }
    
    public void render(Graphics g){
        for (Blocks bloqueio : bloqueios) {
            bloqueio.render(g);
        }
        
        for(int xx = 0; xx < 30; xx++){
        	for(int yy = 0; yy < 18; yy++) {
        		g.drawImage(SpriteSheet.floor, 32+xx*32, 32+yy*32, 32, 32, null);
        	}
        }
        
        macaco[0].render(g);
        macaco[1].render(g);
        macaco[2].render(g);
        macaco[3].render(g);
        tigre.render(g);
        cobra.render(g);
        aguia.render(g);
    }
}

