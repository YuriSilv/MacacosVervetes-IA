import Agents.Macaco;
import Ambiente.Mundo;
import Ambiente.Tigre;
import Sprites.SpriteSheet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.swing.JFrame;
import Utils.Math2;
import Utils.Settings;

public class App extends Canvas implements Runnable{

	private Mundo mundo;
	
	public App() throws IOException{
	    this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT)); //tamanho da tela
	    new SpriteSheet();
	    mundo = new Mundo();
	}
	
	public static void main(String[] args) throws IOException {
		App game = new App();
	    JFrame frame = new JFrame();
	    
	    frame.add(game); //add canva
	    frame.setTitle("Vervets Game");
	    frame.pack(); //empacotar e calcular o tamanho certo da janela
	
	    frame.setLocationRelativeTo(null); //centralizar janela
	    frame.setResizable(false); //tamanho fixo
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar janela
	    frame.setVisible(true);
	    
	    new Thread(game).start(); // jogando o game para dentro de uma thread
	}
	
	public void update(){ //atualização
	    mundo.update();
	}
	
	public void render(){ //renderização
	    BufferStrategy bs = this.getBufferStrategy(); //controlar o buffer do JFrame
	    
	    if(bs==null){
	        this.createBufferStrategy(3);
	        return;
	    }
	    
	    Graphics graphics = bs.getDrawGraphics(); //desenhar gráficos
	    
	    graphics.setColor(new Color(62, 137, 72));
	    graphics.fillRect(0,0, Settings.WIDTH, Settings.HEIGHT); //redesenha sobre o JFrame a cada frame (evita tela piscando)
	    mundo.render(graphics);
	    
	    bs.show();
	}
	
	@Override
	public void run() {
	    while(true){
	        update();
	        render();
	        
	        try{
	            Thread.sleep((long) Settings.FPS);
	        }catch(InterruptedException e){
	            e.printStackTrace();
	        }
	    }
	
	}

}
