package Agents;

import java.util.Random;

public class Tabela {
    Random rand = new Random();
    float tabela[][] = new float[3][10];
    
    public Tabela(){
        fillTable();
    }
    
    public final void fillTable(){
        for (int i = 0; i < 3; i++) { //tigre(0), aguia(1), cobra(2)
            for (int j = 0; j < 10; j++) {
                this.tabela[i][j] = rand.nextFloat(10)/10; // 0 <= x <= 1
            }
        }
    }
    
    public int  maxValueOnCollumn(int col){
        float val = this.tabela[col][0];
        int largePos = 0;
        for (int j = 0; j < 10; j++) {
            if(this.tabela[col][j] > val){
                val = this.tabela[col][j];
                largePos = j;
            }
        }
        return largePos;
    }
}