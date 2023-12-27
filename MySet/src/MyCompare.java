
public class MyCompare{

	public static <E extends Comparable> E min(MySet<E> set){
		E min = null;
		if(set.getSet().size() != 0){
			min = (E) set.getSet().get(0);
		}
		for (int i = 0; i < set.getSet().size(); i++){
			if(((Comparable) set.getSet().get(i)).compareTo(min) < 0){
				min = (E) set.getSet().get(i);
			}
		}
		return min;
		
	}
}
