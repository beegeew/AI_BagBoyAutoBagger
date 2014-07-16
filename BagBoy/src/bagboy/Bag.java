package bagboy;

import java.util.ArrayList;

public class Bag extends ArrayList<Product>{
    public enum bagType {plastic, paper, cloth};
    private bagType type;
    public int maxWeight;
    public int[] dimension;
    
    public Bag(bagType t){
        type=t;
        dimension = new int[3];
        if(this.isPlastic()){
            maxWeight=150;
            dimension[0]=12;
            dimension[1]=8;
            dimension[2]=12;
        }
        else if(this.isPaper()){
            maxWeight=200;
            dimension[0]=14;
            dimension[1]=8;
            dimension[2]=14;
        }
        else if(this.isCloth()){
            maxWeight=225;
            dimension[0]=14;
            dimension[1]=8;
            dimension[2]=16;
        }
    }
    
    public boolean isPlastic(){
        return this.type==bagType.plastic;
    }
    
    public boolean isPaper(){
        return this.type==bagType.paper;
    }
    
    public boolean isCloth(){
        return this.type==bagType.cloth;
    }
    
}
