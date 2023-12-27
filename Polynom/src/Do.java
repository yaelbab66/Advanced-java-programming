
public class Do {

	public static void main(String[] args) {
		int power[] = {1,2,3,4,4,6,5};
		double num[] = {13.5,2,5,4,7,5,90};
		Polynom p = new Polynom(power, num);
		int power2[] = {1,0,3};
		double num2[] = {1,27,90};
		Polynom p2 = new Polynom(power2, num2);
		p.print();
		p2.print();
		p = p.minus(p2);
		
		
		
		p.print();
		
	}

}
