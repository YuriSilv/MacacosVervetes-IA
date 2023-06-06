package com.yuri.vervets;

import agentes.Macaco;
import ambiente.Mundo;
import ambiente.Tigre;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.swing.JFrame;
import utils.Math2;
import utils.Settings;

public class Vervets extends Canvas implements Runnable{

    private Macaco macaco[] = new Macaco[2];
    private Mundo mundo;
    
    public Vervets() throws IOException{
        this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT)); //tamanho da tela
        //macaco[0] = new Macaco(640,320);
        macaco[1] = new Macaco(640,220);
        
        mundo = new Mundo();
    }
    
    public static void main(String[] args) throws IOException {
        Vervets game = new Vervets();
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
        //macaco[0].update(Mundo.tigre);
        macaco[1].update(Mundo.tigre);
        mundo.update();
    }
    
    public void render(){ //renderização
        BufferStrategy bs = this.getBufferStrategy(); //controlar o buffer do JFrame
        
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics graphics = bs.getDrawGraphics(); //desenhar gráficos
        
        graphics.setColor(new Color(125, 175, 105));
        graphics.fillRect(0,0, Settings.WIDTH, Settings.HEIGHT); //redesenha sobre o JFrame a cada frame (evita tela piscando)
        
        mundo.render(graphics);
        //macaco[0].render(graphics);
        macaco[1].render(graphics);
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
