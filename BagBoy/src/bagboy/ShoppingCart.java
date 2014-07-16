package bagboy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;


public class ShoppingCart extends ArrayList<Product> {

    public ShoppingCart() {
        numItems = 0;
        numBags = 0;
        bagType = 'n';
        //Bag is set default to plastic.
        bag = new Bag(Bag.bagType.plastic);
                
        try {
          String line;
          pr = Runtime.getRuntime().exec("CLIPS/CLIPS32bitDOS.exe");
          br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
          pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(pr.getOutputStream())));

          System.out.println(br.readLine());   
 
          pw.println("(load CLIPS/rules.CLP)");
          pw.flush();
            pw.println("(defglobal ?*maxbagweight* = "+bag.maxWeight+")");
            pw.flush();
            pw.println("(load CLIPS/bagrules.CLP)");
            pw.flush();
             pw.println("(load CLIPS/packingrules.CLP)");
             pw.flush();
          
        } catch (Exception err) {
          err.printStackTrace();
        }    
    }

    public void addItem(String itemName) {
        numItems++;
        Product tempItem;
        LinkedList<Product.statusType> tempST = new LinkedList();
        Product.shapeType shape = null;
        Product.materialType mat = null;
        Product.tempType temp = null;
        Product.contentType cont = null;
        int[] tempInt = null;
        Product.weightClass weight = null;
        
        switch (itemName) {
            case "eggs": {
                tempST.add(Product.statusType.fragile); tempST.add(Product.statusType.thisSideUp);
                shape = Product.shapeType.box; mat = Product.materialType.cardboard; temp = Product.tempType.refrigerated; cont = Product.contentType.dryFood;
                tempInt = new int[] {12,4,2}; weight = Product.weightClass.l;
                break; }
            case "milk": {
                tempST.add(Product.statusType.thisSideUp);
                shape = Product.shapeType.cylinder; mat = Product.materialType.plastic; temp = Product.tempType.refrigerated; cont = Product.contentType.dryFood;
                tempInt = new int[] {4,4,10}; weight = Product.weightClass.l;
                break; }
            case "cheese":{
                shape = Product.shapeType.bag; mat = Product.materialType.plastic; temp = Product.tempType.refrigerated; cont = Product.contentType.dryFood;
                tempInt = new int[] {1,6,5}; weight = Product.weightClass.m;
                break; }
            case "yogurt":{ tempST.add(Product.statusType.stackable);
                shape = Product.shapeType.cylinder; mat = Product.materialType.plastic; temp = Product.tempType.refrigerated; cont = Product.contentType.dryFood;
                tempInt = new int[] {2,2,3}; weight = Product.weightClass.s;
                break; }
            case "delisand":{
                shape = Product.shapeType.irregular; mat = Product.materialType.paper; temp = Product.tempType.hot; cont = Product.contentType.dryFood;
                tempInt = new int[] {5,5,2}; weight = Product.weightClass.m;
                break; }
            case "frenchbread":{
                tempST.add(Product.statusType.fragile); tempST.add(Product.statusType.oblong);
                shape = Product.shapeType.irregular; mat = Product.materialType.paper; temp = Product.tempType.hot; cont = Product.contentType.dryFood;
                tempInt = new int[] {4,5,18}; weight = Product.weightClass.l;
                break; }
            case "frozenpeas":{
                shape = Product.shapeType.bag; mat = Product.materialType.plastic; temp = Product.tempType.frozen; cont = Product.contentType.dryFood;
                tempInt = new int[] {5,8,1}; weight = Product.weightClass.m;
                break; }
            case "ice cream":{
                tempST.add(Product.statusType.thisSideUp); tempST.add(Product.statusType.stackable);
                shape = Product.shapeType.bag; mat = Product.materialType.cardboard; temp = Product.tempType.frozen; cont = Product.contentType.dryFood;
                tempInt = new int[] {5,8,5}; weight = Product.weightClass.l;
                break; }
            case "steaks":{
                tempST.add(Product.statusType.thisSideUp);
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.refrigerated; cont = Product.contentType.raw;
                tempInt = new int[] {4,8,2}; weight = Product.weightClass.m;
                break; }
            case "groundbeef":{
                tempST.add(Product.statusType.thisSideUp);
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.refrigerated; cont = Product.contentType.raw;
                tempInt = new int[] {5,8,3}; weight = Product.weightClass.l;
                break; }
            case "apple":{
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.produce;
                tempInt = new int[] {3,3,3}; weight = Product.weightClass.m;
                break; }
            case "bananas":{
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.produce;
                tempInt = new int[] {5,3,3}; weight = Product.weightClass.l;
                break; }
            case "watermelon":{
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.produce;
                tempInt = new int[] {10,10,14}; weight = Product.weightClass.overweight;
                break; }
            case "tunacan":{
                tempST.add(Product.statusType.stackable);
                shape = Product.shapeType.cylinder; mat = Product.materialType.metal; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {3,3,1}; weight = Product.weightClass.s;
                break; }
            case "toiletpaper":{
                shape = Product.shapeType.irregular; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.neutral;
                tempInt = new int[] {4,12,10}; weight = Product.weightClass.l;
                break; }
            case "soup":{
                tempST.add(Product.statusType.stackable);
                shape = Product.shapeType.cylinder; mat = Product.materialType.metal; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {3,3,4}; weight = Product.weightClass.m;
                break; }
            case "shavecream":{
                shape = Product.shapeType.cylinder; mat = Product.materialType.metal; temp = Product.tempType.roomTemp; cont = Product.contentType.hazardous;
                tempInt = new int[] {3,3,6}; weight = Product.weightClass.m;
                break; }
            case "salsa":{
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.cylinder; mat = Product.materialType.glass; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {3,3,6}; weight = Product.weightClass.m;
                break; }
            case "raid":{
                shape = Product.shapeType.cylinder; mat = Product.materialType.metal; temp = Product.tempType.roomTemp; cont = Product.contentType.hazardous;
                tempInt = new int[] {3,3,10}; weight = Product.weightClass.m;
                break; }
            case "dogfood":
                { tempST.add(Product.statusType.oblong);
                shape = Product.shapeType.bag; mat = Product.materialType.paper; temp = Product.tempType.roomTemp; cont = Product.contentType.neutral;
                tempInt = new int[] {18,30,4}; weight = Product.weightClass.overweight;
                break; }
            case "coke2liter": {
                shape = Product.shapeType.cylinder; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {4,4,10}; weight = Product.weightClass.l;
                break; }
            case "chips": {
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.bag; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {3,8,12}; weight = Product.weightClass.m;
                break; }
            case "cereal": {
                shape = Product.shapeType.box; mat = Product.materialType.cardboard; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {2,8,10}; weight = Product.weightClass.m;
                break; }
            case "bread": {
                tempST.add(Product.statusType.fragile);
                shape = Product.shapeType.bag; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {5,5,12}; weight = Product.weightClass.l;
                break; }
            case "bleach":{
                tempST.add(Product.statusType.thisSideUp);
                shape = Product.shapeType.cylinder; mat = Product.materialType.plastic; temp = Product.tempType.roomTemp; cont = Product.contentType.hazardous;
                tempInt = new int[] {7,7,10}; weight = Product.weightClass.xl;
                break; }
            case "twelvepack":{
                shape = Product.shapeType.box; mat = Product.materialType.cardboard; temp = Product.tempType.roomTemp; cont = Product.contentType.dryFood;
                tempInt = new int[] {5,5,16}; weight = Product.weightClass.overweight;
                break; }
        }
        
        //XL=2L=8M=16S=32XS<overweight
        
        tempItem = new Product(numItems,itemName,tempInt,weight,shape,mat,temp,cont,tempST);
        add(tempItem);
        pw.println("(assert(product "+tempItem.index +" "+tempItem +"))");
        pw.flush();
        
        //if (size() % 8 == 0)
            runClips();
        
    }
    
    private void runClips() 
    {
        System.out.print(size() + get(0).toString());
//        if (size() == 0) {
//            try {
//            
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        try {            
            pw.println("(run)");
            pw.flush();
            String line;
            pw.println("(facts)");
            pw.flush();
            while(!(line=br.readLine()).contains("For a total of")){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          
    }
    
    public int getItems() {
        return numItems;
    }
    
    public int getBags() {
        return numBags;
    }
    
    public void setBagType(char newType) {
        bagType = newType;
        if (bagType == 'p') {
            bag = new Bag(Bag.bagType.paper);
        } else if (bagType == 'l') {
            bag = new Bag(Bag.bagType.plastic);
        } else if (bagType == 'c') {
            bag = new Bag(Bag.bagType.cloth); 
        }
        pw.println("(undefglobal ?*maxbagweight*)");
        pw.flush();
        pw.println("(defglobal ?*maxbagweight* = "+bag.maxWeight+")");
        pw.flush();
    }
    
    public char getBagType() {
        return bagType;
    }
    
    public String getBagTypeToString() {
        String bagName = "";
        if (bagType == 'p') 
            bagName = "Paper";
        else if (bagType == 'l')
            bagName = "Plastic";
        else if (bagType == 'c')
            bagName = "Cloth";
        
        return bagName;
    }
    
    public ArrayList<String> getBagContents(int bagNum){
        ArrayList<String> currBagContents = null;
        int i;
        
        if ( bagAndContents.size() < bagNum) 
        {   
            currBagContents.add("Happy Fun Stuff");
            currBagContents.add("More happy fun Stuff!");
        }
           
        return currBagContents;
    }
    
    private ArrayList<String> bagAndContents;
    private int numItems;
    private int numBags;
    private char bagType;
    private Bag bag;
    private BufferedReader br;
    private Process pr;
    private PrintWriter pw;
}
