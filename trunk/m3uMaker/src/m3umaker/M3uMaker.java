/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3umaker;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author xyBerWise
 */
public class M3uMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            LookAndFeel lf = new WindowsLookAndFeel();
            UIManager.setLookAndFeel(lf);
        } catch (Exception e) {
        }
        new M3U().setVisible(true);
    }
    
}
