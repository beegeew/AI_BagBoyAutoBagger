
package bagboy;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class DerBagginator extends javax.swing.JFrame {

    /** Creates new form DerBagginator */
    public DerBagginator() {
        initComponents();
        
        int numItems = 30;
        
        groceryHandler newGrocer = new groceryHandler();
        
        groceries = new BagginatorButton[numItems];
        bags = new BagginatorButton[3];
        
        custCart = new ShoppingCart();
        
        //bags
        bags[0] = new BagginatorButton("plastic");
        bags[0].setIcon(plastic);
        bagDisplay.add(bags[0]);
        bags[1] = new BagginatorButton("paper");
        bags[1].setIcon(paperBag);
        bagDisplay.add(bags[1]);
        bags[2] = new BagginatorButton("cloth");
        bags[2].setIcon(cloth);
        bagDisplay.add(bags[2]);
        
        bags[0].addActionListener(newGrocer);
        bags[1].addActionListener(newGrocer);
        bags[2].addActionListener(newGrocer);
        
        //refrigerated items
        groceries[0] = new BagginatorButton("eggs");
        groceries[0].setIcon(eggs);
        refrigerated.add(groceries[0]);
        groceries[1] = new BagginatorButton("milk");
        groceries[1].setIcon(milk);
        refrigerated.add(groceries[1]);
        groceries[2] = new BagginatorButton("cheese");
        groceries[2].setIcon(cheese);
        refrigerated.add(groceries[2]);
        groceries[3] = new BagginatorButton("yogurt");
        groceries[3].setIcon(yogurt);
        refrigerated.add(groceries[3]);
     
        //Dry Goods
        groceries[4] = new BagginatorButton("twelvepack");
        groceries[4].setIcon(twelvepack);
        dryGoods.add(groceries[4]); 
        
        groceries[5] = new BagginatorButton("bleach");
        groceries[5].setIcon(bleach);
        dryGoods.add(groceries[5]);        
        
        groceries[6] = new BagginatorButton("bread");
        groceries[6].setIcon(bread);
        dryGoods.add(groceries[6]);        
        
        groceries[7] = new BagginatorButton("cereal");
        groceries[7].setIcon(cereal);
        dryGoods.add(groceries[7]);        
        
        groceries[8] = new BagginatorButton("chips");
        groceries[8].setIcon(chips);
        dryGoods.add(groceries[8]);
        
        groceries[9] = new BagginatorButton("coke2liter");
        groceries[9].setIcon(coke2liter);
        dryGoods.add(groceries[9]);
        
        groceries[10] = new BagginatorButton("dogfood");
        groceries[10].setIcon(dogfood);
        dryGoods.add(groceries[10]);
        
        groceries[11] = new BagginatorButton("raid");
        groceries[11].setIcon(raid);
        dryGoods.add(groceries[11]);
        
        groceries[12] = new BagginatorButton("salsa");
        groceries[12].setIcon(salsa);
        dryGoods.add(groceries[12]);
        
        groceries[13] = new BagginatorButton("shavecream");
        groceries[13].setIcon(shavecream);
        dryGoods.add(groceries[13]);
        
        groceries[14] = new BagginatorButton("soup");
        groceries[14].setIcon(soup);
        dryGoods.add(groceries[14]);
        
        groceries[15] = new BagginatorButton("toiletpaper");
        groceries[15].setIcon(toiletpaper);
        dryGoods.add(groceries[15]);
                
        groceries[16] = new BagginatorButton("tunacan");
        groceries[16].setIcon(tunacan);
        dryGoods.add(groceries[16]);
        
        groceries[17] = new BagginatorButton("frozenpeas");
        groceries[17].setIcon(frozenpeas);
        frozen.add(groceries[17]);
        
        groceries[18] = new BagginatorButton("icecream");
        groceries[18].setIcon(icecream);
        frozen.add(groceries[18]);
        
        groceries[19] = new BagginatorButton("groundbeef");
        groceries[19].setIcon(groundbeef);
        meats.add(groceries[19]);
        
        groceries[20] = new BagginatorButton("steaks");
        groceries[20].setIcon(steaks);
        meats.add(groceries[20]);
        
        groceries[21] = new BagginatorButton("apple");
        groceries[21].setIcon(apple);
        produce.add(groceries[21]);
        
        groceries[22] = new BagginatorButton("bananas");
        groceries[22].setIcon(bananas);
        produce.add(groceries[22]);
        
        groceries[23] = new BagginatorButton("watermelon");
        groceries[23].setIcon(watermelon);
        produce.add(groceries[23]);
        
        groceries[24] = new BagginatorButton("delisand");
        groceries[24].setIcon(delisand);
        deli.add(groceries[24]);
        
        groceries[25] = new BagginatorButton("frenchbread");
        groceries[25].setIcon(frenchbread);
        deli.add(groceries[25]);
        
        for (int i = 0; i < 26; i++)
            groceries[i].addActionListener(newGrocer);    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shoppingPane = new javax.swing.JTabbedPane();
        produce = new javax.swing.JPanel();
        deli = new javax.swing.JPanel();
        meats = new javax.swing.JPanel();
        refrigerated = new javax.swing.JPanel();
        frozen = new javax.swing.JPanel();
        dryGoods = new javax.swing.JPanel();
        bagDisplay = new javax.swing.JPanel();
        shoppingCartResult = new javax.swing.JPanel();
        bagContentDisplay = new javax.swing.JScrollPane();
        bagOutputData = new javax.swing.JTextPane();
        numItemsLabel = new javax.swing.JLabel();
        numBagsLabel = new javax.swing.JLabel();
        bagTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Der Bagginator");

        produce.setLayout(new java.awt.GridLayout(4, 3));
        shoppingPane.addTab("Produce", produce);

        deli.setLayout(new java.awt.GridLayout(4, 3));
        shoppingPane.addTab("Bakery/Deli", deli);

        meats.setLayout(new java.awt.GridLayout(3, 4));
        shoppingPane.addTab("Meats", meats);

        refrigerated.setLayout(new java.awt.GridLayout(3, 4));
        shoppingPane.addTab("Refrigerated", refrigerated);

        frozen.setLayout(new java.awt.GridLayout(3, 4));
        shoppingPane.addTab("Frozen", frozen);

        dryGoods.setLayout(new java.awt.GridLayout(4, 3));
        shoppingPane.addTab("Dry Goods", dryGoods);

        bagDisplay.setLayout(new java.awt.GridLayout(1, 3));

        bagOutputData.setEditable(false);
        bagContentDisplay.setViewportView(bagOutputData);

        numItemsLabel.setText("Number of Items: 0");

        numBagsLabel.setText("Number of Bags: 0 ");

        bagTypeLabel.setText("Choose a bag type to begin.");

        javax.swing.GroupLayout shoppingCartResultLayout = new javax.swing.GroupLayout(shoppingCartResult);
        shoppingCartResult.setLayout(shoppingCartResultLayout);
        shoppingCartResultLayout.setHorizontalGroup(
            shoppingCartResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shoppingCartResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bagContentDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addGroup(shoppingCartResultLayout.createSequentialGroup()
                        .addComponent(numItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(numBagsLabel))
                    .addComponent(bagTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        shoppingCartResultLayout.setVerticalGroup(
            shoppingCartResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartResultLayout.createSequentialGroup()
                .addGroup(shoppingCartResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numBagsLabel)
                    .addComponent(numItemsLabel))
                .addGap(9, 9, 9)
                .addComponent(bagTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bagContentDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(shoppingPane, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shoppingCartResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bagDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bagDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoppingCartResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(shoppingPane, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DerBagginator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DerBagginator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DerBagginator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DerBagginator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DerBagginator().setVisible(true);
            }
        });
    }
    
    private class groceryHandler implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            BagginatorButton item = (BagginatorButton) e.getSource();
            String buttonName = item.getName();
            
            switch (buttonName) 
            {
                //these cases handle all the bag types - highlighing the proper button, etc.
                case "plastic": if (custCart.getItems() == 0) { bags[0].setBackground(Color.DARK_GRAY);
                    bags[1].setBackground(Color.LIGHT_GRAY);
                    bags[2].setBackground(Color.LIGHT_GRAY);
                    custCart.setBagType('l');} else berror();
                    break;
                case "paper": if (custCart.getItems() == 0) { 
                    bags[0].setBackground(Color.LIGHT_GRAY);
                    bags[1].setBackground(Color.DARK_GRAY);
                    bags[2].setBackground(Color.LIGHT_GRAY);
                    custCart.setBagType('p'); } else berror();
                    break;
                case "cloth": if (custCart.getItems() == 0) { 
                    bags[0].setBackground(Color.LIGHT_GRAY);
                    bags[1].setBackground(Color.LIGHT_GRAY);
                    bags[2].setBackground(Color.DARK_GRAY);
                    custCart.setBagType('c'); } else berror();
                    break;
                
                    //This section handles the addition of each separate item type.
                    //It allows the Shopping Cart to decide what to add based on what the item is.
                default:    if (custCart.getBagType() != 'n')
                    {
                        custCart.addItem(buttonName);
                    }
            }
            
            //This section updates the labels which shows how many items and bags
            //that we currently have. 
            if (custCart.getBagType() != 'n') {
                numItemsLabel.setText("Number of items: " + custCart.getItems());
                numBagsLabel.setText("Number of bags: " + custCart.getBags());
                bagTypeLabel.setText("Current bag type is: " + custCart.getBagTypeToString());
            } else
            {
                        
            javax.swing.JOptionPane.showMessageDialog(null,
                "Please choose a bag type to begin the bagging process",
                "Notice",
                javax.swing.JOptionPane.INFORMATION_MESSAGE); 
            }
        }
    }
    
    private void berror() {
        javax.swing.JOptionPane.showMessageDialog(null,
                "Items are already bagged\nCannot change bag type.",
                "Notice",
                javax.swing.JOptionPane.INFORMATION_MESSAGE); 
    }
    
    private Icon delisand = new ImageIcon(getClass().getResource("/bagboy/resources/deli/delisandwich.png"));
    private Icon frenchbread = new ImageIcon(getClass().getResource("/bagboy/resources/deli/frenchbread.png"));
    
    private Icon apple = new ImageIcon(getClass().getResource("/bagboy/resources/produce/apple.png"));
    private Icon bananas = new ImageIcon(getClass().getResource("/bagboy/resources/produce/bananas.png"));
    private Icon watermelon = new ImageIcon(getClass().getResource("/bagboy/resources/produce/watermelon.png"));
    
    private Icon groundbeef = new ImageIcon(getClass().getResource("/bagboy/resources/meats/groundbeef.png"));
    private Icon steaks = new ImageIcon(getClass().getResource("/bagboy/resources/meats/steaks.png"));
    
    private Icon icecream = new ImageIcon(getClass().getResource("/bagboy/resources/frozen/icecream.png"));
    private Icon frozenpeas = new ImageIcon(getClass().getResource("/bagboy/resources/frozen/frozenpeas.png"));
    
    private Icon twelvepack = new ImageIcon(getClass().getResource("/bagboy/resources/dry/12pack.png"));
    private Icon bleach = new ImageIcon(getClass().getResource("/bagboy/resources/dry/bleach.png"));
    private Icon bread = new ImageIcon(getClass().getResource("/bagboy/resources/dry/bread.png"));
    private Icon cereal = new ImageIcon(getClass().getResource("/bagboy/resources/dry/cereal.png"));
    private Icon chips = new ImageIcon(getClass().getResource("/bagboy/resources/dry/chips.png"));
    private Icon coke2liter = new ImageIcon(getClass().getResource("/bagboy/resources/dry/coke2liter.png"));
    private Icon dogfood = new ImageIcon(getClass().getResource("/bagboy/resources/dry/dogfood.png"));
    private Icon raid = new ImageIcon(getClass().getResource("/bagboy/resources/dry/raids.png"));
    private Icon salsa = new ImageIcon(getClass().getResource("/bagboy/resources/dry/salsa.png"));
    private Icon shavecream = new ImageIcon(getClass().getResource("/bagboy/resources/dry/shavecream.png"));
    private Icon soup = new ImageIcon(getClass().getResource("/bagboy/resources/dry/soup.png"));
    private Icon toiletpaper = new ImageIcon(getClass().getResource("/bagboy/resources/dry/toiletpaper.png"));
    private Icon tunacan = new ImageIcon(getClass().getResource("/bagboy/resources/dry/tunacan.png"));
    
    private Icon eggs = new ImageIcon(getClass().getResource("/bagboy/resources/refrigerated/eggs.png"));
    private Icon milk = new ImageIcon(getClass().getResource("/bagboy/resources/refrigerated/milk.png"));
    private Icon cheese = new ImageIcon(getClass().getResource("/bagboy/resources/refrigerated/shreddedcheese.png"));
    private Icon yogurt = new ImageIcon(getClass().getResource("/bagboy/resources/refrigerated/yogurt.png"));
    
    private Icon plastic = new ImageIcon(getClass().getResource("/bagboy/resources/bags/plasticbag.png"));
    private Icon paperBag = new ImageIcon(getClass().getResource("/bagboy/resources/bags/paperbag.png"));
    private Icon cloth = new ImageIcon(getClass().getResource("/bagboy/resources/bags/clothbag.png"));
    
    private ShoppingCart custCart;
    
    private BagginatorButton bags[];
    private BagginatorButton groceries[];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane bagContentDisplay;
    private javax.swing.JPanel bagDisplay;
    private javax.swing.JTextPane bagOutputData;
    private javax.swing.JLabel bagTypeLabel;
    private javax.swing.JPanel deli;
    private javax.swing.JPanel dryGoods;
    private javax.swing.JPanel frozen;
    private javax.swing.JPanel meats;
    private javax.swing.JLabel numBagsLabel;
    private javax.swing.JLabel numItemsLabel;
    private javax.swing.JPanel produce;
    private javax.swing.JPanel refrigerated;
    private javax.swing.JPanel shoppingCartResult;
    private javax.swing.JTabbedPane shoppingPane;
    // End of variables declaration//GEN-END:variables
}
