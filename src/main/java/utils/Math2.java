package utils;
import java.util.ArrayList;
import java.util.Random;

public class Math2 {
    public Random rand = new Random();
    public ArrayList<Float> randNums = new ArrayList<>();
    
    public ArrayList<Float> distribuicao(int limite, int interacoes, boolean toInt){
        
        float num = 0;
        
        if(toInt){
            num = rand.nextInt(limite);
        }else{
            num = rand.nextFloat(limite);
        }
        
        
        for (int i = 0; i < interacoes; i++) {
            randNums.add(num);
        }
        
        return randNums;
    }
    
    public float mean(ArrayList<Float> values){
        float sum = 0;
        for(Float num : values){
            sum += num;
        }
        
        return sum/values.size();
    }
}
