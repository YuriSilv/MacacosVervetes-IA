package agentes;

import ambiente.Mundo;
import java.awt.Rectangle;

public class Vector2D extends Rectangle{
    
    protected int speed = 16;
    
    public Vector2D(int x, int y){
        super(x,y,32,32);
    }
    
    public boolean getCollide(int x, int y){
        return Mundo.collision(x, y);
    } 
}
