import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class lambdaDemo3 {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6);
		list=new ArrayList<>(list);
		//list.removeIf(new MyPredicate());
		//list.forEach(i->System.out.print(i+" "));
		
		System.out.println("\n===============");
		
		//list.removeIf(t->t%2==1);
		//list.forEach(i->System.out.print(i+" "));
		
		list.removeIf(t->{
			return t%2==1;
		});
		list.forEach(i->System.out.print(i+" "));

	}

}

class MyPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
	
		return t%2==1;
	}
	
}