package Agents;

import Ambiente.Mundo;
import java.awt.Rectangle;

public class Vector2D extends Rectangle{
    
    protected float speed = 16f;
    
    public Vector2D(int x, int y){
        super(x,y,32,32);
    }
    
    public String getCollide(int x, int y){
        return Mundo.collision(x, y);
    } 
}

