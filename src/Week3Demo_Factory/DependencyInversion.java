package factoryPack;
import java.util.*;

public class DependencyInversion {

	public static void main(String[] args) {
		Set<Float> lst = new TreeSet<Float>();		
		lst.add(4.5f);
		lst.add(2.3f);
		lst.add((float) 6.5);
		
		float result = getSum(lst);
		System.out.println(result);
	}
	
	static float getSum(Iterable<Float> iterable){
		float result = 0.0f;
		Iterator<Float> it = iterable.iterator();
		while(it.hasNext()){
			result += it.next();
		}
		
		return result;
	}
}
