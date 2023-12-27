public class SumThread  extends Thread{ 
	private Controller controller;
	
	public SumThread (Controller c){
		controller = c ;
	}
	
	
	public void run(){
        while(!controller.isFinish()){
        	controller.sumTwoNums();
        }
	}
}
