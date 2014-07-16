package bagboy;

import java.util.LinkedList;

public class Product {
    int index;
    protected String productName;
    protected int[] size;
    public enum weightClass {xs, s, m, l, xl, overweight};
    protected weightClass weight;
    public enum shapeType {box, cylinder, bag, irregular};
    protected shapeType shape;
    public enum materialType {cardboard, plastic, glass, metal, paper};
    protected materialType material;
    public enum tempType {roomTemp, refrigerated, frozen, hot};
    protected tempType temp;
    public enum contentType {dryFood, produce, raw, hazardous, neutral};
    protected contentType content;
    public enum statusType {fragile, thisSideUp, stackable, oblong};
    protected LinkedList<statusType> status;
    public enum productName {milk, eggs, bread, iceCream, chips, cereal, twelvepackSoda, salsa, bleach, groundBeef, cheese, frozenPeas, bagOfApples, watermelon, bananas, shavingCream, yogurt, twoLiterSoda, canOfSoup, canOfTuna, deliSandwich, frenchBread, dogFood, steaks, raid }

    
    public Product(int i, String name, int[] s, weightClass w, shapeType sh, materialType m, tempType t, contentType c, LinkedList<statusType> st){
        index=i;
        productName = name;
        size=s;
        weight=w;
        shape=sh;
        material=m;
        temp=t;
        content=c;
        status=st;
    }
    
    public Product(int i, Product p){
        index=i;
        productName = p.productName;
        size=p.size;
        weight=p.weight;
        shape=p.shape;
        material=p.material;
        temp=p.temp;
        content=p.content;
        status=p.status;
    }
    
    @Override  //Do not change; used for asserting in CLIPS
    public String toString(){
        String statuses="";
        
        int weightOut =0;
        switch (weight){
            case xs: weightOut = 10; break;
            case s: weightOut = 20; break;
            case m: weightOut = 40; break;
            case l: weightOut = 85; break;
            case xl: weightOut = 125; break;
            case overweight: weightOut = 250; break;
        }
        for(int i=0;i<status.size();i++){
            statuses=statuses+" "+status.get(i);
        }
        return (size[0]+" "+size[1]+" "+size[2]+" "+weightOut+" "+shape+" "+material+" "+temp+" "+content+statuses);
    }
}
