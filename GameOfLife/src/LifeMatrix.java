
public class LifeMatrix {

	private boolean matrix[][];
	private int width;
	private int height;
	
	//Constructor
	public LifeMatrix(int matrixSize){
		matrix = new boolean[matrixSize][matrixSize];
		int bool;
		for(int i = 0; i< matrixSize; i++){
			for(int j = 0; j< matrixSize; j++){
				bool = (int)(Math.random()*10)/5;
				if(bool == 0)
					matrix[i][j] = false;
				else
					matrix[i][j] = true;
			}
		}
		width = matrix.length;
		height = matrix[0].length;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	//Returns matrix[x][y] is a live cell
 	public boolean getIsLive(int x, int y){
		return matrix[x][y];
	}
 	
 	//Build the next round according to the rules
	public void buildNextLife() {
		boolean newMatrix[][] = new boolean[getWidth()][getHeight()];
		for(int i = 0; i< getWidth(); i++){
			for(int j = 0; j< getHeight(); j++){
				if(matrix[i][j])
					newMatrix[i][j] = checkDeath(i,j);
				else
					newMatrix[i][j] = checkBirth(i,j);
			}
		}
		copyMatrix(newMatrix);
		
		
	}

	//Copy the new matrix (next life)
	private void copyMatrix(boolean[][] newMatrix) {
		for(int i = 0; i< getWidth(); i++)
			for(int j = 0; j< getHeight(); j++)
				matrix[i][j] = newMatrix[i][j];
		
	}
	
	//Checks if a dead cell should be born 
	private boolean checkBirth(int i, int j) {
		int aliveNeighbors = checkNeighbors(i, j);
		
		if(aliveNeighbors == 3)
			return true;
		return false;
	}

	//check if alive cell should die
	private boolean checkDeath(int i, int j) {
		
		int aliveNeighbors = checkNeighbors(i, j)-1;
		
		if(aliveNeighbors == 2 || aliveNeighbors == 3)
			return true;
		return false;
	}

	//Return the number of alive neighbors of a cell (matrix[x][y]) 
	private int checkNeighbors(int x, int y) {
		int aliveNeighbors = 0;
		for(int n = x-1; n<= x+1 ; n++){
			if(n == -1)
				n++;
			if(n == getWidth())
				break;
			for(int m = y-1; m<= y+1; m++){
				if(m == -1 )
					m++;
				if(m == getWidth())
					break;
				if(matrix[n][m])
					aliveNeighbors++;
			}
		}
		return aliveNeighbors;
	}
	
	
}
