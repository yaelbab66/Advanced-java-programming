
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class PhoneBookGUI extends JPanel {
    private JButton cmdDeleteObject;
    private JButton cmdReadObject;
    private JButton cmdWriteObject;
    private JButton cmdUpdateObject;
    private JButton cmdFindObject;
    private JLabel lblTitle;
    private JScrollPane jScrollPane1;
    private JLabel lblCopyRight;
    private JTextArea txtData;

    private PhoneBookUtils fu;
    private File currentDir;
    private PhoneBook MyBook;
    private File f;
    public PhoneBookGUI()
    {
    	
		
        cmdReadObject = new JButton("Read Phone Book");
        cmdWriteObject = new JButton("Write Phone Book");
        cmdUpdateObject = new JButton("Update Phone Book");
        cmdDeleteObject = new JButton("Delete a record from Phone Book");
        cmdFindObject = new JButton("Find a record");
        lblTitle = new JLabel("Phone Book");
        txtData = new JTextArea(5, 20);
        jScrollPane1 = new JScrollPane(txtData);
        txtData.setFont(new java.awt.Font("Courier New", 0, 24));
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(txtData);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3, 20, 20));
        buttons.add(cmdWriteObject);
        buttons.add(cmdReadObject);
        buttons.add(cmdUpdateObject);
        buttons.add(cmdDeleteObject);
        buttons.add(cmdFindObject);
        
        
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       add(lblTitle);
       add(Box.createVerticalGlue());
       add(buttons);
       add(Box.createVerticalGlue());
       add(jScrollPane1);

       ButtonsListener listener = new ButtonsListener();
       
       cmdReadObject.addActionListener(listener);
       cmdWriteObject.addActionListener(listener);
       cmdUpdateObject.addActionListener(listener);
       cmdDeleteObject.addActionListener(listener);
       cmdFindObject.addActionListener(listener);
        
        fu = new PhoneBookUtils();
        currentDir = new File("C:\\");
        try {
			f = fu.createFile("PhoneBook");
		} catch (IOException e1) {
			errorMsg("Error in Creating a File");
		}
        MyBook = new PhoneBook();
    }

    private void errorMsg(String msg)
    {
        JOptionPane.showMessageDialog(this,msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private File getFile()
    {
        JFileChooser fc = new JFileChooser(currentDir);
        fc.showOpenDialog(null);
        currentDir = fc.getSelectedFile();
        return fc.getSelectedFile();
    }
    private class ButtonsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	//Add new record
        	if(e.getSource() == cmdWriteObject)
            {
                
                try {
                    fu.writeObject(f, MyBook);
                    JOptionPane.showMessageDialog(PhoneBookGUI.this, "Writing is done");
                }
                catch(IOException ex)
                {
                    errorMsg("Error in Writing to File");
                }
            }
            else
            	//Show Phone Book
            	if(e.getSource() == cmdReadObject){
                File f = getFile();
                String res = "";
                try {
                    res = fu.readObject(f, MyBook);
                    txtData.setText(res);
                }
                catch(IOException ex)
                {
                    errorMsg("Error in reading from File");
                }
            }
            else 
            	//Find contact in the phone book 
            	if(e.getSource() == cmdFindObject){
               
                String res = "";
                try {
                    res = fu.findNumber(f, MyBook);
                    txtData.setText(res);
                }
                catch(IOException ex)
                {
                    errorMsg("Error in finding the record");
                }
            }
            else 
            	//Update record
            	if(e.getSource() == cmdUpdateObject){
            	try{
            	 fu.updateObject(f, MyBook);
                 JOptionPane.showMessageDialog(PhoneBookGUI.this, "Updating is done");
             }
             catch(IOException ex)
             {
                 errorMsg("Error in updeting the record");
             }
            }
            else 
            	//Deleting record
            	if(e.getSource() == cmdDeleteObject){
            	try{
            	 fu.deleteObject(f, MyBook);
                 JOptionPane.showMessageDialog(PhoneBookGUI.this, "Deleting is done");
             }
             catch(IOException ex)
             {
                 errorMsg("Error in deleting the record");
             }
            }
        }
    }
}
