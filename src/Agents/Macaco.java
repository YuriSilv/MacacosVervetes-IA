package Agents;

import Ambiente.Aguia;
import Ambiente.Cobra;
import Ambiente.Mundo;
import Ambiente.Tigre;
import java.awt.Graphics;
import java.util.Random;
import Sensores.Listen;
import Sensores.Sensor;
import Sprites.SpriteSheet;

public class Macaco extends Vector2D{
    
    private final Random random = new Random();
    private Listen sensorListen;
    private Sensor sensorObserve;
    private int interator = 0;
    public Tabela simbolos;
    private float fatorConvergencia = 0.08f;
    public int memory = -1;
    public String nome;
    
    public Macaco(int x, int y, String nome) {
        super(x, y);
        this.nome = nome;
        sensorListen = new Listen(x, y, 200);
        sensorObserve = new Sensor(x, y, 300);
        System.out.println("Tabela do Macaco " + nome);
        simbolos = new Tabela();
    }
    
    /**
     * Move o macaco
     */
    public void move(){
        int randomInt = random.nextInt(4) + 1;
        
        if(randomInt == 1 && !this.getCollide(x+speed_col, y).equals("parede")){
            x += speed;
        }
        else if(randomInt == 2 && !this.getCollide(x-speed_col, y).equals("parede")){
            x -= speed;
        }
        else if(randomInt == 3 && !this.getCollide(x, y-speed_col).equals("parede")){
            y -= speed;
        }
        else if(randomInt == 4 && !this.getCollide(x, y+speed_col).equals("parede")){
            y += speed;
        }
    }
   
    public void update(Tigre tigre, Cobra cobra, Aguia aguia){
        move();
        sensorListen.update(x, y, tigre, cobra, aguia);
        sensorObserve.update(x, y, tigre, cobra, aguia);
        actions();
    }
    
    public void actions() {
    	int animal_escutado = sensorListen.getMessage();
        int animal_avistado = sensorObserve.getMessage();
        
        if( animal_escutado != -1){
        	sensorListen.sendMessage(Mundo.macaco, simbolos.maxValueOnCollumn(animal_escutado), this);
            sensorListen.setMessage(-1);
        }
        
        
        if( animal_avistado != -1){
        	observed(animal_avistado);
            sensorObserve.setMessage(-1);
            
        }
    }
    
    public void render(Graphics g){
        sensorListen.render(g);
        sensorObserve.render(g);
        g.drawImage(SpriteSheet.player, x, y, 64, 64, null);
    }
    
    
    public void observed(int animal_id) {
    	if(memory != -1) {
    		updateTable(animal_id, memory, true);
    		memory = -1;
    	}
    }
    
    
    public void fixParams() {
    	int maiorSimboloTigre = simbolos.maxValueOnCollumn(0);
    	int maiorSimboloCobra = simbolos.maxValueOnCollumn(1);
    	int maiorSimboloAguia = simbolos.maxValueOnCollumn(2);
    	
    	if(maiorSimboloTigre == maiorSimboloCobra) {
    		updateTable(0, maiorSimboloTigre, false);
    	}
    	if(maiorSimboloTigre == maiorSimboloAguia) {
    		updateTable(0, maiorSimboloTigre, false);
    	}
    	if(maiorSimboloAguia == maiorSimboloCobra) {
    		updateTable(1, maiorSimboloCobra, false);
    	}
    }
    
    public void updateTable(int col, int row, boolean crescer){
    	
        float old_value = this.simbolos.tabela[row][col]; //[[1,2,5],
                                                          // [3,4,6]]
        
        if(crescer) {
        	this.simbolos.tabela[row][col] += fatorConvergencia;
        }else {
        	this.simbolos.tabela[row][col] -= fatorConvergencia;
        }
        
        fixParams();
    	if(col == 0) {
        	System.out.println(nome + " " + "viu um(a) " + "tigre!");
        	interator +=1;
	    	this.simbolos.saveMatrixToFile(nome + "_tigre" +".txt", col);

    	}
    	else if(col == 1) {
    		System.out.println(nome + " " + "viu um(a) " + "cobra!");
    		interator +=1;
	    	this.simbolos.saveMatrixToFile(nome + "_cobra" +".txt", col);
    	}
    	else if(col == 2) {
    		System.out.println(nome + " " + "viu um(a) " + "aguia!"); 
    		interator +=1;
	    	this.simbolos.saveMatrixToFile(nome + "_aguia" +".txt", col);
    	}
        
        
        System.out.println("Simbolo " + "S"+row + " " + old_value + " --> " + this.simbolos.tabela[row][col]);
        System.out.println("---------------------------------------------------------------");
        
    }
}
