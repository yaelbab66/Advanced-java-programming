import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class PhoneBookUtils {
	
	//Creating the file
	public File createFile(String fileName) throws IOException{
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
	//Add new record
	 public void writeObject(File f, PhoneBook p) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream
							(new FileOutputStream(f));
		
		String name = JOptionPane.showInputDialog("Enter name");
		String number = JOptionPane.showInputDialog("Enter number");
		p.addRecord(name, number);
		out.writeObject(p);
		out.close();
	 }
	 
	 //Updating a record 
	 public void updateObject(File f, PhoneBook p) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream
							(new FileOutputStream(f));
		
		String name = JOptionPane.showInputDialog("Enter name for update");
		String number = JOptionPane.showInputDialog("Enter new number");
		p.updateRecord(name, number);
		out.writeObject(p);
		out.close();
	 }
	 //Deleting a record
	 public void deleteObject(File f, PhoneBook p) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream
							(new FileOutputStream(f));
		
		String name = JOptionPane.showInputDialog("Enter name to delete");
		p.deleteRecord(name);
		out.writeObject(p);
		out.close();
	 }
	 //Find a record
	 public String findNumber(File f, PhoneBook p) throws IOException{
		 
		 ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream(f));
		 String name = JOptionPane.showInputDialog("Enter name to find");
		 String number = p.find(name);
		 out.writeObject(p);
		 out.close();
		 return name +" - "+number;
	 }
	 //Show phone book
	 public String readObject(File f, PhoneBook p) throws IOException{
	        ObjectInputStream in = new ObjectInputStream
	                            (new FileInputStream(f));
	        
	        String res = "";
	        try {
	            while(true)
	            {
	                p = (PhoneBook) in.readObject();
	                res = res + p + "\n";
	            }
	        }
	        catch(EOFException e)
	        {
	            res = res + "End Of Records";
	        }
	        catch(ClassNotFoundException e){}
	        return res;
	 }	
}
