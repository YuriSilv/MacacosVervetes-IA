package Agents;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


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
    
    public void saveMatrixToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int rows = tabela.length;
            int cols = tabela[0].length;

            writer.write("tigre,cobra,aguia"); // Escreve as colunas na primeira linha

            writer.newLine(); // Pula para a próxima linha

            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    writer.write(tabela[j][i] + " "); // Escreve cada elemento da matriz
                }
                writer.newLine(); // Pula para a próxima linha
            }

            System.out.println("Matriz salva com sucesso no arquivo: " + filePath);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar a matriz no arquivo: " + filePath);
            e.printStackTrace();
        }
    }
}