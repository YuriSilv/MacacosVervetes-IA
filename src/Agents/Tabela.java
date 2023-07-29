package Agents;

import java.util.Random;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tabela {
    Random rand = new Random();
    float tabela[][] = new float[10][3];
    
    public Tabela(){
        fillTable();
        fixTablePesos();
        
    }
    
    public final void fillTable(){
        for (int i = 0; i < 10; i++) { 
            for (int j = 0; j < 3; j++) { //tigre(0), aguia(1), cobra(2)
                this.tabela[i][j] = rand.nextFloat(9)/10; // 0.0 <= x <= 0.9
            }
        }
    }
    
    public int  maxValueOnCollumn(int col){
        float val = this.tabela[0][col];
        int largePos = 0;
        for (int i = 0; i < 10; i++) {
            if(this.tabela[i][col] > val){
                val = this.tabela[i][col];
                largePos = i;
            }
        }
        return largePos;
    }
    
    public void saveMatrixToFile(String filePath, int animalCol) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            int rows_length = 9;

            //writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10"); // Escreve as colunas na primeira linha

            writer.newLine(); // Pula para a próxima linha
            
            for (int j = 0; j <=rows_length; j++) {
            	if(j < 9) {
            		writer.write(tabela[j][animalCol] + ",");
            	}
            	else {
            		writer.write(tabela[j][animalCol] + "");
            	}
            	
            }

            //System.out.println("Matriz salva com sucesso no arquivo: " + filePath);
        } catch (IOException e) {
            //System.out.println("Ocorreu um erro ao salvar a matriz no arquivo: " + filePath);
            e.printStackTrace();
        }
    }
    
    public static void createTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("camila_aguia.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("camila_cobra.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("camila_tigre.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("yuri_aguia.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("yuri_cobra.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("yuri_tigre.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("juan_aguia.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("juan_cobra.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("juan_tigre.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lana_aguia.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lana_cobra.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lana_tigre.txt"))) {
            writer.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void fixTablePesos() {
    	int maiorValorCol1 = maxValueOnCollumn(0);
    	int maiorValorCol2 = maxValueOnCollumn(1);
    	int maiorValorCol3 = maxValueOnCollumn(2);
    	System.out.println("Palavra Tigre: s" + maiorValorCol1);
        System.out.println("Palavra Aguia: s" + maiorValorCol2);
        System.out.println("Palavra Cobra: s" + maiorValorCol3);
        System.out.println("--------------------------------------------");
        while(maiorValorCol1 == maiorValorCol2 || maiorValorCol1 == maiorValorCol3 || maiorValorCol2 == maiorValorCol3) {
        	
        	if(maiorValorCol1 == maiorValorCol2) {
        		tabela[maiorValorCol1][0] = rand.nextFloat(9)/10;
        	}
        	
        	if(maiorValorCol1 == maiorValorCol3) {
        		tabela[maiorValorCol1][0] = rand.nextFloat(9)/10;
        	}
        	
        	if(maiorValorCol2 == maiorValorCol3) {
        		tabela[maiorValorCol1][1] = rand.nextFloat(9)/10;
        	}
        	maiorValorCol1 = maxValueOnCollumn(0);
        	maiorValorCol2 = maxValueOnCollumn(1);
        	maiorValorCol3 = maxValueOnCollumn(2);
        	
        	System.out.println("Tabela Anterior eh Invalida. Nova tabela gerada: ");
        	System.out.println("Palavra Tigre: s" + maiorValorCol1);
            System.out.println("Palavra Aguia: s" + maiorValorCol2);
            System.out.println("Palavra Cobra: s" + maiorValorCol3);
            System.out.println("--------------------------------------------");
        }
        
        
    }
}