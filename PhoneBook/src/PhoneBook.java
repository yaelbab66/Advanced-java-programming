import java.io.Serializable;
import java.util.TreeMap;

public class PhoneBook implements Serializable{

	private TreeMap<String, String> record;
	
	public PhoneBook(){
		record = new TreeMap<String , String>();
	}
		
	public void addRecord(String name, String number){
		record.put(name, number);
	}
	
	public void updateRecord(String name, String number){
		
		for (String key: record.keySet()){
			if(key.equals(name)){
				record.put(key, number);
			}
		}
	}
	
	public void deleteRecord(String name){
		record.remove(name);
	}
	
	public String find(String name){
		return record.get(name);
	}
	
	public String toString(){
		String s = "";
		for (String name: record.keySet()){
            s+= name.toString()+" - ";
            s+= record.get(name).toString()+ "\n";  
              
		} 
		return s;
	}
}
