
package bagboy;

import javax.swing.JButton;

public class BagginatorButton extends javax.swing.JButton {
    
    public BagginatorButton(String incName)
    {
        name = incName;
    }
    
    public String getName()
    {
        return name;
    }
    
   private String name; 
}
