import java.util.Date;

public class Person implements  Comparable<Person>{

	private String id, firstName, lastName;
	private Date dob;
	
	public Person(String id, String firstName, String lastName, Date dob){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	@Override
	//Compare by last name and first name
	public int compareTo(Person arg0) {
		int j = 0;
		int i = 0;
		while(i<this.lastName.length() && j<arg0.lastName.length()){
			if(this.lastName.charAt(i)> arg0.lastName.charAt(j)){
				return 1;
			}
			else
				if(this.lastName.charAt(i)< arg0.lastName.charAt(j)){
					return -1;
				}
				else{
					i ++;
					j ++;
				}
		}
		i = 0;
		j = 0;
		while(i<this.firstName.length() && j<arg0.firstName.length()){
			if(this.firstName.charAt(i)> arg0.firstName.charAt(j)){
				return 1;
			}
			else
				if(this.firstName.charAt(i)< arg0.firstName.charAt(j)){
					return -1;
				}
				else{
					i ++;
					j ++;
				}
		}
		
		return 0;
	}
	
	public String toString(){
		return "person: " + this.firstName + " "+ this.lastName;
	}
	
	
	
}
