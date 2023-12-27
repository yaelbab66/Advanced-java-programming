import java.util.*;

public class Controller {
	public static Vector<Integer> array ; 

	boolean isFinish = false ;

	
	public Controller(Vector numbers , int maxThreads)
	{
		array = numbers ;
	}
	
	
	/**
	 * Will sum 2 numbers from the array
	 * Only one thread can access at a time
	 */
	public synchronized void sumTwoNums(){
		int sum = 0;
		if(!isFinish){
			sum = array.remove(0) + array.remove(0);
			System.out.print("-new sum-" + sum);
			array.add(sum);

		}

		if (array.size() == 1){
			isFinish = true;
		}

	}
	
	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

}
