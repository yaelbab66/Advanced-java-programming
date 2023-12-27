
public abstract class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private Birthday birthday;
	
	public Employee(String firstName, String lastName, String socialSecurityNumber, Birthday b){
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthday = b;
		
	}
	public Birthday getBirthday(){
		return birthday;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getlastName(){
		return lastName;
	}
	
	public String getsocialSecurityNumber(){
		return socialSecurityNumber;
	}
	
	@Override
	public String toString(){
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getlastName()
				, getsocialSecurityNumber());
	}
	
	public abstract double earning();

	

	public void setBirthday(Birthday birthday) {
		Birthday = birthday;
	}
}
