import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PixelPic extends JApplet{
	private int pointCount = 0; // count number of points
	private int width;
	private int height;
	final int Fixel = 100 ;
	JButton[][] board = new JButton[Fixel][Fixel];
	private Point points[] = new Point[ 100 ];  
	Color black = new Color(255,255,255);
	Color white = new Color(0,0,0);
	JButton startBiting;
	JButton restart;
	
	// set up GUI and register mouse event handler
	public PixelPic()
	{
		// handle frame mouse motion event
		Color black = new Color(255,255,255);
		JPanel drawErea = new JPanel();
		JPanel butoonMenu = new JPanel();
		JPanel includePanel = new JPanel();
		startBiting = new JButton("Start with threads");
		restart = new JButton("restart");
		drawErea.setLayout(new GridLayout(100,100));

		for (int i=0 ; i <Fixel ; i++ )
			for (int j=0 ; j <Fixel ; j++ )
			{
				board[i][j] = new JButton();
				board[i][j].setText(null);
				board[i][j].setBackground(black);
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				board[i][j].addActionListener(new ButtonListener());
				drawErea.add(board[i][j]);
			}
		startBiting.addActionListener(new StartWithThreads());
		restart.addActionListener(new StartWithThreads());
		butoonMenu.add(startBiting);
		butoonMenu.add(restart);
		includePanel.setLayout(new BorderLayout());
		includePanel.add(drawErea , BorderLayout.CENTER);
		includePanel.add(butoonMenu, BorderLayout.SOUTH);	
		this.add(includePanel);
	} // end PaintPanel constructor
	public void paint( Graphics g )
	{
		super.paint( g ); // clears drawing area
		width = this.getWidth() ;
		height = this.getHeight() ;

	} 

	private class StartWithThreads implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startBiting)
			{
				int numOfThreads = getNumFromUser("Enter number of threads") ; 
				int numOfPasses = getNumFromUser("Enter number of passes per thread") ; 
				for (int i = 1 ; i <= numOfThreads ; i++)
				{
					new PrimeThread(board , i , numOfThreads , numOfPasses ).start();

				}
				System.out.println();
			}
			else
			{
				for (int i=0 ; i <Fixel ; i++ )
					for (int j=0 ; j <Fixel ; j++ )
						board[i][j].setBackground(black);
			}

		}

	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			Color tempColor;
			for (int i=0 ; i <Fixel ; i++ )
				for (int j=0 ; j <Fixel ; j++ )
				{
					if (e.getSource() == board[i][j])
					{
						tempColor = board[i][j].getBackground();
						if (tempColor.equals(black))
							board[i][j].setBackground(white);
						else
							board[i][j].setBackground(black);
						
					}	
				}

		}		
	}


	//Getting number from the user
	private static int getNumFromUser(String inputString){
		boolean inputAgian=true;
		int input=-1;
		while(inputAgian){
			try{
				input = Integer.parseInt(JOptionPane.showInputDialog(inputString));
				if ((input > 0) )
					inputAgian = false;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Please Enter an Integer");
			}

		}
		return input;
	}
}