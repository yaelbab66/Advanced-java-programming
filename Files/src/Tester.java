/*
 * Tester.java
 *
 * Created on 31 דצמבר 2008, 11:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Shay Tavor
 */
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Tester {
    
   public static void main(String[] args)
   {
       JFrame frame = new JFrame("Files and Streams Tester");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 400);
       FilesGUI gui = new FilesGUI();
       frame.add(gui);
       frame.setVisible(true);
       
   }
   
   

}
