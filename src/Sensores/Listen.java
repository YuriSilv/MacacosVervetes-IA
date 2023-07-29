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

public class Listen extends Sensor {
    
    public Listen(double x, double y, double diametro){
        super(x-diametro/2, y-diametro/2, diametro);
    }
    
    public void render(Graphics g){
        g.setColor(new Color(255, 250, 180, 150));
        g.drawOval((int) (x) , (int) (y), (int) this.getWidth(), (int)this.getHeight());  
    }
    
    public void sendMessage(Macaco agentes[], int msg, Macaco auto){
        for(Macaco macaco : agentes){
            if(this.intersects(macaco) && macaco != auto){
                macaco.memory = msg; // linha que o simbolo de algum animal está ligado
                System.out.println(auto.nome + " GRITOU PARA " + macaco.nome + " A MSG " + macaco.memory);
            }
        }
    }
}