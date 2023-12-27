import java.awt.Color;

import javax.swing.JButton;

public class PrimeThread extends Thread {
	Color black = new Color(0,0,0);
	Color white = new Color(255,255,255);
	final int Fixel = 100 ;
	JButton[][] board ; // will contain only thread image part
	boolean [][] image ;
	int passesInThread ;
	//Each thread will be created with define size

	public PrimeThread(JButton[][] tempBoard , int threadOffset , int numOfThread ,int passPerThread)
	{
		passesInThread = passPerThread ;
		int portionFromImage = 0;
		int offsetLast = 0 ; 
		if (threadOffset == numOfThread) 
		{
			int portionOffset = tempBoard[1].length / numOfThread ;
			portionFromImage = tempBoard[1].length - portionOffset * (threadOffset - 1);
			offsetLast = portionFromImage - portionOffset ;
		}
		portionFromImage = tempBoard[1].length / numOfThread;

		board = new JButton[Fixel][portionFromImage + offsetLast]; 
		image = new boolean[Fixel][portionFromImage + offsetLast]; 
		for (int i = 0 ; i < tempBoard.length ; i++)
		{
			for (int j = 0 ; j < portionFromImage + offsetLast ; j++)
			{
				board[i][j] = tempBoard[i][j + portionFromImage * (threadOffset - 1)];
			}
		}
	}


	public void run()
	{
		initBoolArray(image);
		
		//Checking neighbor
		for (int q = 0 ; q < passesInThread ; q ++ )
		{
			for (int i = 0 ; i < image.length ; i++)
			{
				for (int j = 0 ; j < image[1].length ; j++)
				{
					if (board[i][j].getBackground().equals(black) )
					{
						checkNeighbor(board,i,j);
					}
				}
			}
			for (int i = 0 ; i < image.length ; i++)
			{
				for (int j = 0 ; j < image[1].length ; j++)
				{
					if (image[i][j] == true)
						board[i][j].setBackground(white);
				}
			}
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void checkNeighbor(JButton[][] board2, int i, int j) {
		if (i == 0)
		{
			if (j == 0) //corner Thread

			{
				if (board[0][1].getBackground().equals(black) && board[1][0].getBackground().equals(black) )
				{
					//No change all neighbors white
				}
				else
				{
					image[0][0] = true ; //Color will be set later
				}
			}
			else if (j ==  board2[1].length -1) //corner again
			{


				if (board[0][j-1].getBackground().equals(black) && board[1][j].getBackground().equals(black))
				{
					//No change all neighbors white
				}
				else
				{
					image[i][j] = true ; //Color will be set later
				}
			}
			else //not a corner but first line 
			{
				// left right down
				if (board[0][j-1].getBackground().equals(black) && board[1][j].getBackground().equals(black)
						&& board[0][j+1].getBackground() == black)
				{
					//Surrounded by white
				}
				else
				{
					image[i][j] = true ;
				}


			}
		}
		else if (i == board.length -1)
		{
			if (j == 0) //corner Thread

			{
				if (board[i-1][0].getBackground().equals(black) && board[i][1].getBackground().equals(black) )
				{
					//No change all neighbors white
				}
				else
				{
					image[i][j] = true ; //Color will be set later
				}
			}
			else if (j ==  board2[1].length -1) //corner again
			{


				if (board[i][j-1].getBackground().equals(black) && board[i-1][j].getBackground().equals(black) )
				{
					//No change all neighbors white
				}
				else
				{
					image[i][j] = true ; //Color will be set later
				}
			}
			else //not a corner but first line 
			{

				// left right up
				if (board[i][j-1].getBackground().equals(black) && board[i-1][j].getBackground().equals(black)
						&& board[i][j+1].getBackground() == black)
				{
					//Surrounded by white
				}
				else
				{
					image[i][j] = true ;
				}


			}
		}
		else if (j == 0)
		{
			//Check up down and right
			if (board[i-1][j].getBackground().equals(black)
					&& board[i][j+1].getBackground().equals(black) && board[i+1][j].getBackground().equals(black))
			{
				//All neghbors ok do nothing
			}
			else
				image[i][j] = true ; // Only if need to change ce
		}
		else if (j ==  board2[1].length -1)
		{
			//check up down left up
			if (board[i][j-1].getBackground().equals(black) && board[i-1][j].getBackground().equals(black)
					&&  board[i+1][j].getBackground().equals(black))
			{
				//All neghbors ok do nothing
			}
			else
				image[i][j] = true ; // Only if need to change cell
		}

		else //Not first line or last line
		{
			//check up down left right
			if (board[i][j-1].getBackground().equals(black) && board[i-1][j].getBackground().equals(black)
					&& board[i][j+1].getBackground().equals(black) && board[i+1][j].getBackground().equals(black))
			{
				//All neghbors ok do nothing
			}
			else
				image[i][j] = true ; // Only if need to change cell

		}
	}


	private void initBoolArray(boolean[][] image2) {
		for (int i = 0 ; i < image2.length ; i++)
		{
			for (int j = 0 ; j < image2[1].length ; j++)
			{
				image2[i][j] = false ;
			}
		}

	}

}
