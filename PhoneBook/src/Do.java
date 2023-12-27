import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Do {
    
   public static void main(String[] args)
   {
	   
       JFrame frame = new JFrame("Files and Streams Tester");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 400);
       PhoneBookGUI gui = new PhoneBookGUI();
       frame.add(gui);
       frame.setVisible(true);
       
   }
   
   

}