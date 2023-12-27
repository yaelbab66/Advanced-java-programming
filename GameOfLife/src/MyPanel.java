import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
	
	private int pWidth;
	private int pHeight;
	private boolean m[][];
	final int SIZE = 50;
	
	//Build the matrix
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(0,0, 500, 500);
		for(int i =0 ; i< pWidth; i++){
			for(int j=0; j< pHeight; j++){
				if(getIsLive(i,j))
					paintBlack(g, i, j);
			}
		}
	
	}
	
	//Returns if cell is alive
	public boolean getIsLive(int width, int height){
		return m[width][height];
	}
	
	//Set matrix width
	public void setWidth(int width){
		pWidth = width;
	}
	//Set matrix height
	public void setHeight(int height){
		pHeight = height;
	}
	
	//Paint live cells black
	public void paintBlack(Graphics g, int i, int j){
		g.fillRect(i*50, j*50, SIZE, SIZE);
	}
	
	//Copies the matrix in order to paint it
	public void buildMatrix(MyFrame frame, MyPanel p, LifeMatrix m) {
		this.m = new boolean[pWidth][pHeight];
		for(int i =0 ; i< m.getWidth(); i++){
			for(int j=0; j< m.getHeight(); j++){
				this.m[i][j] = m.getIsLive(i, j);
			}
		}
		frame.add(p);
		repaint();
	}

	
}
