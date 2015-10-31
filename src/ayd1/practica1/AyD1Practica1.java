package ayd1.practica1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class AyD1Practica1 {
    public static void main(String[] args) 
    {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
        {
            if ("Windows".equals(info.getName())) 
            {
                try 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
                {
                    Logger.getLogger(AyD1Practica1.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
