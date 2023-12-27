import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class PlaySet {

	public static void main(String arg[]){
		
		
		MySet<Integer> a = new MySet<Integer>();
		MySet<Integer> b = new MySet<Integer>();
		MySet<Integer> c = new MySet<Integer>();
		
		for(int i = 0;i<10;i++){
			
			a.insert((int) Math.round( Math.random()*100));
			
			b.insert((int) Math.round( Math.random()*100));
			
			c.insert((int) Math.round( Math.random()*100));
			
		}
		//Print sets: a, b, c
		System.out.println("a: "+a.toString());
		System.out.println("b: "+b.toString());
		System.out.println("c: "+c.toString());
		//a union b
		a.union(b);
		System.out.println("a: Union(a, b)"+a.toString());
		//a intersect c
		a.intersect(c);
		System.out.println("a: Intersect(a,c)"+a.toString());
		MySet<Integer> d = new MySet<Integer>();
		String num;
		
		Integer number = null;
		while(d.getSet().size() < 2){
			try {
				num = JOptionPane.showInputDialog("Please insert a number");
				number = Integer.parseInt(num);
				d.insert(number);
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Not a number");
			}
		}
		//Print Set d
		System.out.println("d: "+d.toString());
		//Check if d is subset of a b or c
		if(a.isSubset(d)){
			System.out.println("Set d:\n"+d.toString()+"\nis subset of the set a: \n"+a.toString());
		}
		if(b.isSubset(d)){
			System.out.println("Set d:\n"+d.toString()+"\nis subset of the set b: \n"+b.toString());
		}
		if(c.isSubset(d)){
			System.out.println("Set d:\n"+d.toString()+"\nis subset of the set c: \n"+c.toString());
		}
		boolean isNum = false;
		while(!isNum){
			try {
				num = JOptionPane.showInputDialog("Please insert a number");
				number = Integer.parseInt(num);
				isNum = true;
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Not a number");
			}
		}
		//Check if the number exists in a
		Iterator<Integer> it;
		for( it = a.iterator(); it.hasNext(); ){
			if(it.next().equals(number)){
				System.out.println("The number is a member of set a");
			}
		}
		//Insert the number to b
		b.insert(number);
		System.out.println("b: "+b.toString());
		//Delete the number fron d if exists
		c.delete(number);
		System.out.println("c: "+c.toString());
		//Persons = a set of persons
		Date date = new Date();
		Person personA = new Person("111", "abc", "red", date);
		Person personB = new Person("111", "bbb", "ase", date);
		Person personC = new Person("111", "atc", "ase", date);
		MySet<Person> persons = new MySet<Person>();
		persons.insert(personA);
		persons.insert(personB);
		persons.insert(personC);
		//Find the minimum of set persons
		Person min = MyCompare.min(persons);
		if(min != null)
			System.out.println(min.toString());
	}
}
