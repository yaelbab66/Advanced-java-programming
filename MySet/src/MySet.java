import java.util.ArrayList;
import java.util.Iterator;

public class MySet <E> {
	private boolean equals = false;
	private ArrayList<E> set;

	public MySet(){
		set = new ArrayList<E>();
	}
	
	public MySet(ArrayList<E> NewSet){
		set = new ArrayList<E>();
		for(int j = 0; j < NewSet.size(); j++){
			for(int i = 0; i  < set.size(); i++ ){
				if(set.get(i).equals(NewSet.get(j))){
					equals = true;
					break;
				}
				if(!equals){
				set.add(NewSet.get(j));
				}
			}
		}
	}
	
	public ArrayList<E> getSet(){
		return this.set;
	}
	
	public void union(MySet set2){
		boolean equals = false;
		
		for(int j = 0; j < set2.set.size(); j++){
			for(int i = 0; i  < set.size(); i++ ){
				equals = false;
				if(set.get(i).equals(set2.set.get(j))){
					equals = true;
					break;
				}
				
			}
			if(!equals){
				set.add((E)set2.set.get(j));
				
			}
		
		}
	}
	
		public void intersect(MySet set2){
		ArrayList<E> intersect = new ArrayList<E>();
		boolean equals = false;
		for(int j = 0; j < set2.set.size(); j++){
			for(int i = 0; i  < set.size(); i++ ){
				equals = false;
				if(set.get(i).equals(set2.set.get(j))){
					equals = true;
					break;
				}
				
			}
			if(equals){
				intersect.add((E) set2.set.get(j));
			}
		}
		set.removeAll(set);
		set.addAll(intersect);
	}
	
	public boolean isSubset(MySet set2){
		boolean equals = false;
		for(int i=0; i< set2.getSet().size(); i++){
			equals = false;
			for(int j =0; j< set.size(); j++){
				if(set2.getSet().get(i).equals(set.get(j))){
					equals =true;
					break;
				}
			}
			if(!equals){
				return false;
			}
		}
		return true;
	}
	
	public boolean isMember(E member){
		
		for(int i = 0 ; i < set.size(); i ++){
			if(set.get(i).equals(member)){
				return true;
			}
		}
		return false;
	}
	
	public void insert(E member){
		if(!isMember(member)){
			set.add(member);
		}
	}
	
	public void delete(E member){
		for(int i = 0 ; i < set.size(); i ++){
			if(set.get(i).equals(member)){
				set.remove(i);
			}
		}
	}
	
	public Iterator<E> iterator(){
		
		return set.iterator();		
	}
	
	public String toString(){
		String s = "";
		for(int i = 0 ; i < set.size(); i ++){
			s+= set.get(i).toString()+ ", ";
		}
		return s;
		
	}

}
