package Agents;

import Ambiente.Aguia;
import Ambiente.Cobra;
import Ambiente.Mundo;
import Ambiente.Tigre;
import java.awt.Graphics;
import java.util.Random;
import Sensores.Listen;
import Sprites.SpriteSheet;

public class Macaco extends Vector2D{
    
    private final Random random = new Random();
    private Listen sensorListen;
    private int interator = 5;
    private Tabela simbolos;
    private float fatorConvergencia = 0.1f;
    public int memory = -1;
    public String nome;
    
    public Macaco(int x, int y, String nome) {
        super(x, y);
        this.nome = nome;
        sensorListen = new Listen(x, y, 200);
        simbolos = new Tabela();
    }
    
    /**
     * Move o macaco
     */
    public void move(){
        int randomInt = random.nextInt(4) + 1;
        
        if(randomInt == 1 && !this.getCollide(x+32, y).equals("parede")){
            x += speed;
        }
        else if(randomInt == 2 && !this.getCollide(x-32, y).equals("parede")){
            x -= speed;
        }
        else if(randomInt == 3 && !this.getCollide(x, y-32).equals("parede")){
            y -= speed;
        }
        else if(randomInt == 4 && !this.getCollide(x, y+32).equals("parede")){
            y += speed;
        }
    }
   
    public void update(Tigre tigre, Cobra cobra, Aguia aguia){
        move();
        sensorListen.update(x, y, tigre, cobra, aguia);
        if(sensorListen.getMessage() == 0){
        	sensorListen.sendMessage(Mundo.macaco, simbolos.maxValueOnCollumn(0), this);
        	observed(0);
            sensorListen.setMessage(-1);
        }
        else if(sensorListen.getMessage() == 1) {
        	sensorListen.sendMessage(Mundo.macaco, simbolos.maxValueOnCollumn(1), this);
        	observed(1);
            sensorListen.setMessage(-1);
        }
        else if(sensorListen.getMessage() == 2) {
        	sensorListen.sendMessage(Mundo.macaco, simbolos.maxValueOnCollumn(2), this);
        	observed(2);
            sensorListen.setMessage(-1);
        }
    }
    
    public void render(Graphics g){
        sensorListen.render(g);
        g.drawImage(SpriteSheet.player, x, y, 64, 64, null);
    }
    
    
    public void observed(int animal_id) {
    	
    	if(memory != -1) {
    		int maior_simbolo = simbolos.maxValueOnCollumn(animal_id);
    		if(maior_simbolo != memory) {
        		updateTable(animal_id, maior_simbolo, false);
        	}
    		updateTable(animal_id, memory, true);
    	}
    	
    	memory = -1;
    }
    
    public void updateTable(int col, int row, boolean crescer){
    	if(col == 0) {
        	System.out.println(nome + " " + "viu um(a) " + "tigre!");    		
    	}
    	else if(col == 1) {
    		System.out.println(nome + " " + "viu um(a) " + "cobra!");      		
    	}
    	else if(col == 2) {
    		System.out.println(nome + " " + "viu um(a) " + "aguia!");    		
    	}
    	
        float old_value = this.simbolos.tabela[col][row];
        
        if(crescer) {
        	this.simbolos.tabela[col][row] += fatorConvergencia;
        }else {
        	this.simbolos.tabela[col][row] -= fatorConvergencia;
        }
        
        if(this.simbolos.tabela[col][row] > 1) {
        	this.simbolos.tabela[col][row] = 1;
        }
        else if(this.simbolos.tabela[col][row] < 0) {
        	this.simbolos.tabela[col][row] = 0;
        }
        
        System.out.println("Simbolo " + "S"+row + " " + old_value + " --> " + this.simbolos.tabela[col][row]);
        System.out.println("---------------------------------------------------------------");
        
	    if(this.interator <= 0) {
	    	this.simbolos.saveMatrixToFile("C:\\Users\\yurid\\eclipse-workspace\\VervetsAgents\\matrix.txt");
	    }
    }
}
