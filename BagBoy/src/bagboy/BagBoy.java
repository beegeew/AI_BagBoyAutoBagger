package bagboy;

import java.io.*;
import java.util.Random;
import java.util.LinkedList;

public class BagBoy {

    public static void main(String[] args) {
        Random rand=new Random();
        Cart cart=new Cart();
        int numItems=generateNumber(1,20,rand);
        int index=0;
        for(int i=0;i<numItems;i++){
            Product item=createRandomItem(index,rand);
            cart.add(item);
            index++;
            int numCopies=rand.nextInt(6);
            for(int j=0;j<numCopies;j++){
                Product item2=new Product(index, item);
                cart.add(item2);
                index++;
            }
        }
        Bag bag=new Bag(Bag.bagType.plastic);
        
        try {
          System.out.println(index);
          String line;
          Process pr = Runtime.getRuntime().exec("CLIPS/CLIPS32bitDOS.exe");
          BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
          PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(pr.getOutputStream())));

          System.out.println(in.readLine());   
 
          
          out.println("(load CLIPS/rules.CLP)");
          out.flush();
          
          for(int i=0;i<index;i++){
              out.println("(assert(product "+cart.get(i).index +" "+cart.get(i) +"))");
              out.flush();
              
              out.println("(run)");
              out.flush();
          }
          out.println("(defglobal ?*maxbagweight* = "+bag.maxWeight+")");
          out.flush();
          out.println("(load CLIPS/bagrules.CLP)");
          out.flush();
          out.println("(load CLIPS/packingrules.CLP)");
          out.flush();
          out.println("(run)");
          out.flush();
          out.println("(facts)");
          out.flush();
          
          
          while(!(line=in.readLine()).contains("For a total of")){
              System.out.println(line);
          }
          System.out.println(line);
          
          out.println("(exit)");
          out.flush();
          in.close();
          //pr.waitFor();
          pr.destroy();
        }
        catch (Exception err) {
          err.printStackTrace();
        }        
    }
    
    public static int generateNumber(int lower, int upper, Random rand){
        long range=(long)upper-(long)lower+1;
        long fraction=(long)(range*rand.nextDouble());
        return (int)(fraction+lower);
    }
    
    public static Product createRandomItem(int index, Random rand){
        int[] size={0,0,0};
        Product.weightClass weight= Product.weightClass.m;
        Product.shapeType shape=Product.shapeType.box;
        Product.materialType material=Product.materialType.cardboard;
        Product.tempType temp=Product.tempType.roomTemp;
        Product.contentType content=Product.contentType.dryFood;
        LinkedList<Product.statusType> status=new LinkedList();
        status.add(Product.statusType.fragile);
        status.add(Product.statusType.thisSideUp);
        status.add(Product.statusType.stackable);
        
     switch(rand.nextInt(5)){
            case 0: break;
            case 1: weight=Product.weightClass.s;break;
            case 2: weight=Product.weightClass.m;break;
            case 3: weight=Product.weightClass.l;break;
            case 4: weight=Product.weightClass.xl;break;
     }
        switch(rand.nextInt(4)){
            case 0: break;
            case 1: shape=Product.shapeType.bag;break;
            case 2: shape=Product.shapeType.cylinder;break;
            case 3: shape=Product.shapeType.irregular;break;
        }
        switch(rand.nextInt(4)){
            case 0: break;
            case 1: temp=Product.tempType.hot;break;
            case 2: temp=Product.tempType.refrigerated;break;
            case 3: temp=Product.tempType.frozen;break;
        }
        if(shape.equals(Product.shapeType.bag)){
            switch(rand.nextInt(2)){
                case 0: material=Product.materialType.paper;break;
                case 1: material=Product.materialType.plastic;break;
            }
        }
        else if(shape.equals(Product.shapeType.box)){
            switch(rand.nextInt(3)){
                case 0: break;
                case 1: material=Product.materialType.metal;break;
                case 2: material=Product.materialType.plastic;break;
            }
        }
        else if(temp.equals(Product.tempType.hot)){
            switch(rand.nextInt(3)){
                case 0: break;
                case 1: material=Product.materialType.paper;break;
                case 2: material=Product.materialType.plastic;break;
            }
        }
        else{
            switch(rand.nextInt(5)){
                case 0: break;
                case 1: material=Product.materialType.glass;break;
                case 2: material=Product.materialType.metal;break;
                case 3: material=Product.materialType.paper;break;
                case 4: material=Product.materialType.plastic;break;
            }
        }
        
        if(!temp.equals(Product.tempType.hot)){
            switch(rand.nextInt(2)){
                case 0: break;
                case 1: content=Product.contentType.raw;break;
            }
        }
        if(temp.equals(Product.tempType.roomTemp)){
            switch(rand.nextInt(2)){
                case 0: break;
                case 1: content=Product.contentType.hazardous;break;
                case 2: content=Product.contentType.neutral;break;
            }
        }
        if((material.equals(Product.materialType.paper) || material.equals(Product.materialType.plastic)) &&
                !temp.equals(Product.tempType.hot)){
            switch(rand.nextInt(2)){
                case 0: break;
                case 1: content=Product.contentType.produce;break;
            }
        }
              
        int fraction=generateNumber(1,101,rand);
        int x=0;
        int y=0;
        int z=0;
        if(fraction<81){
            x=generateNumber(1,10,rand);
            y=generateNumber(1,10,rand);
            z=generateNumber(1,10,rand);
        }
        else if(fraction>=81 && fraction<96){
            x=generateNumber(1,15,rand);
            y=generateNumber(1,15,rand);
            z=generateNumber(1,15,rand);
        }
        else{
            x=generateNumber(1,20,rand);
            y=generateNumber(1,20,rand);
            z=generateNumber(1,20,rand);
        }
        if(shape.equals(Product.shapeType.cylinder)){
                size[0]=x;
                size[1]=x;
                size[2]=y;
            }
            else{
                size[0]=x;
                size[1]=y;
                size[2]=z;
            }
        
        if(shape.equals(Product.shapeType.bag)){
            status.remove(2);
        }
        int num=status.size()-rand.nextInt(status.size()+1);
        for(int i=0;i<num;i++){
            status.remove(rand.nextInt(status.size()));
        }
        int ref1=size[0]*size[1];
        int ref2=size[0]*size[2];
        int ref3=size[1]*size[2];
        int ref4=ref1/ref2;
        int ref5=ref1/ref3;
        int ref6=ref2/ref1;
        int ref7=ref2/ref3;
        int ref8=ref3/ref1;
        int ref9=ref3/ref2;
        if(ref4>5 || ref5>5 || ref6>5 || ref7>5 || ref8>5 || ref9>5){
            status.add(Product.statusType.oblong);
        }
        
        Product p=new Product(index, "Cup Cakes",size, weight, shape, material, temp, content, status);
        return p;
    }
}
