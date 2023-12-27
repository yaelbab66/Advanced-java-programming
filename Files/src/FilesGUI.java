/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shay
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class FilesGUI extends JPanel {
     private JButton cmdClear;
    private JButton cmdCreate;
    private JButton cmdReadData;
    private JButton cmdReadObject;
    private JButton cmdReadText;
    private JButton cmdShowData;
    private JButton cmdWriteData;
    private JButton cmdWriteObject;
    private JButton cmdWriteText;
    private JLabel lblTitle;
    private JScrollPane jScrollPane1;
    private JLabel lblCopyRight;
    private JTextArea txtData;

    private FilesUtils fu;
    private File currentDir;

    public FilesGUI()
    {
        cmdClear = new JButton("Clear");
        cmdCreate= new JButton("Create File");
        cmdReadData = new JButton("Read Data");
        cmdReadObject = new JButton("Read Object");
        cmdReadText = new JButton("Read Text");
        cmdShowData = new JButton("Show Data");
        cmdWriteData = new JButton("Write Data");
        cmdWriteObject = new JButton("Write Object");
        cmdWriteText = new JButton("Write Text");
        lblTitle = new JLabel("Files and Streams Tester");
        txtData = new JTextArea(5, 20);
        jScrollPane1 = new JScrollPane(txtData);
        txtData.setFont(new java.awt.Font("Courier New", 0, 24));
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(txtData);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3, 20, 20));
        buttons.add(cmdCreate);
        buttons.add(cmdShowData);
        buttons.add(cmdWriteText);
        buttons.add(cmdReadText);
        buttons.add(cmdWriteData);
        buttons.add(cmdReadData);
        buttons.add(cmdWriteObject);
        buttons.add(cmdReadObject);
        buttons.add(cmdClear);
        
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       add(lblTitle);
       add(Box.createVerticalGlue());
       add(buttons);
       add(Box.createVerticalGlue());
       add(jScrollPane1);

       ButtonsListener listener = new ButtonsListener();
       cmdClear.addActionListener(listener);
        cmdCreate.addActionListener(listener);
        cmdReadData.addActionListener(listener);
        cmdReadObject.addActionListener(listener);
        cmdReadText.addActionListener(listener);
        cmdShowData.addActionListener(listener);
        cmdWriteData.addActionListener(listener);
        cmdWriteObject.addActionListener(listener);
        cmdWriteText.addActionListener(listener);
        
        fu = new FilesUtils();
        currentDir = new File("C:\\");
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
            if(e.getSource() == cmdCreate)
            {
                String fileName = JOptionPane.showInputDialog(FilesGUI.this, "Enter file path:");
                try {
                    fu.createFile(fileName);
                    JOptionPane.showMessageDialog(FilesGUI.this, "File Created");
                }
                catch(IOException ex)
                {
                    errorMsg("Error in creating the file");
                }
            }
            else if(e.getSource() == cmdShowData)
            {
                File f = getFile();
                if(f != null)
                {
                    fu.showFileData(f);
                }
            }
            else if(e.getSource() == cmdWriteText)
            {
                File f = getFile();
                if(f != null)
                {
                    try {
                        fu.writeToFile(f);
                        JOptionPane.showMessageDialog(FilesGUI.this, "Writing was done");
                    }
                    catch(IOException ex)
                    {
                        errorMsg("Error in Writing to File");
                    }
                }
            }
            else if(e.getSource() == cmdReadText)
            {
                File f = getFile();
                String res = "";
                try {
                    res = fu.readFromFile(f);
                    txtData.setText(res);
                }
                catch(IOException ex)
                {
                    errorMsg("Error in Reading from File");
                }
            }
            else if(e.getSource() == cmdWriteData)
            {
                File f = getFile();
                try {
                    fu.writeData(f);
                    JOptionPane.showMessageDialog(FilesGUI.this, "Writing is done");
                }
                catch(IOException ex)
                {
                    errorMsg("Error in Writing to File");
                }
            }
            else if(e.getSource() == cmdReadData)
            {
                File f = getFile();
                String res = "";
                try {
                    res = fu.readData(f);
                    txtData.setText(res);
                }
                catch(IOException ex)
                {
                    errorMsg("Error in reading from file");
                }
            }
            else if(e.getSource() == cmdWriteObject)
            {
                File f = getFile();
                try {
                    fu.writeObject(f);
                    JOptionPane.showMessageDialog(FilesGUI.this, "Writing is done");
                }
                catch(IOException ex)
                {
                    errorMsg("Error in Writing to File");
                }
            }
            else if(e.getSource() == cmdReadObject)
            {
                File f = getFile();
                String res = "";
                try {
                    res = fu.readObject(f);
                    txtData.setText(res);
                }
                catch(IOException ex)
                {
                    errorMsg("Error in reading from File");
                }
            }
            else if(e.getSource() == cmdClear)
            {
                txtData.setText("");
            }
        }
    }
}
