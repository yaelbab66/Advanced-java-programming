/*
 * FilesUtils.java
 *
 *
 * implements all kinds of files manipulations
 */

/**
 *
 * @author Shay Tavor, shay.tavor@gmail.com
 */

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FilesUtils {

    public File createFile(String fileName) throws IOException
    {
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
    public void showFileData(File f)
    {
        String msg = "";
        msg = msg + "File name: " + f.getName() + "\n";
        msg = msg + "File path: "  + f.getAbsolutePath() + "\n";
        msg = msg + "File length: "  + f.length() + "\n";
        msg = msg + "File last modified: "  + new java.util.Date(f.lastModified()) + "\n";
        JOptionPane.showMessageDialog(null, msg);
    }
     public void writeToFile(File f) throws IOException
    {
        FileWriter fw = new FileWriter(f);
        fw.write("Hello");
        fw.write("\r\n");
        fw.write("Bye");
        
        fw.close();
    }
     public String readFromFile(File f) throws IOException
    {
        FileReader fr = new FileReader(f);
        int size = (int) f.length();
        char[] data = new char[size];
        fr.read(data);
        return new String(data);
    }
     
    public void writeBuffered(File f) throws IOException
    {
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write("Hello");
	bw.write("Bye");
	bw.close();
    }

    public void writeData(File f) throws IOException
    {
	FileOutputStream fo = new FileOutputStream(f);
	DataOutputStream out = new DataOutputStream(fo);
	String[] prods = {"Bread", "Milk", "Onions"};
	double[] prices = {4.5, 5.3, 1.78};
	for(int i = 0; i < prods.length; i++)
	{
		out.writeInt(i+1);
		out.writeUTF(prods[i]);
		out.writeDouble(prices[i]);
	}
	out.close();
    }
    
    public String readData(File f) throws IOException
    {
        FileInputStream fi = new FileInputStream(f);
        DataInputStream in = new DataInputStream(fi);
        int i;
        double d;
        String s;
        String res = "";
        try {
            while(true)
            {
                i = in.readInt();
                s = in.readUTF();
                d = in.readDouble();
                res = res + i + ". \t" + s + "\t" + d + "\n";
            }
        }
        catch(EOFException e)
        { res = res + "End of Records"; }
        return res;
    }
    
    public void writeObject(File f) throws IOException
    {
	ObjectOutputStream out = new ObjectOutputStream
						(new FileOutputStream(f));
	Product p;
	p = new Product(1, 3.8, "Milk");
	out.writeObject(p);
    	p = new Product(2, 4.5, "Bread");
    	out.writeObject(p);
	out.close();
    }
    public String readObject(File f) throws IOException
    {
        ObjectInputStream in = new ObjectInputStream
                            (new FileInputStream(f));
        Product p;
        String res = "";
        try {
            while(true)
            {
                p = (Product) in.readObject();
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
    
    public void writeRandom(File f) throws IOException
    {
	RandomAccessFile r = new RandomAccessFile(f, "rw");
        for(int i = 0; i < 5; i++)
             r.writeInt(i);
         r.close();
    }

    public void readRandom(File f) throws IOException
   {
	RandomAccessFile r = new RandomAccessFile(f, "rw");
          try {
             while(true)
             { 
               int j;
               j = r.readInt();
               System.out.println(j);
            }
         }
       catch(EOFException e) {}
    }

    public void readFromPosition(File f, int pos) throws IOException
   {
        RandomAccessFile r = new RandomAccessFile(f, "rw");
       int location = pos * 4;
       try {
        r.seek(location);
        int i = r.readInt();
        System.out.println(i);
       }
       catch(EOFException e)
       {
           System.out.println("Illegal position");
       }
       
   }
    
    public void writeToPosition(File f, int pos, int data) throws IOException
    {
        RandomAccessFile r = new RandomAccessFile(f, "rw");
        int location = pos * 4;
        r.seek(location);
        r.writeInt(data);
    }

     public File openFile()
     {
         JFileChooser fc = new JFileChooser();
         fc.showOpenDialog(null);
         return fc.getSelectedFile();
     }

}
