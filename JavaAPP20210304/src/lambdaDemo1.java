import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class lambdaDemo1 {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
		for(Integer i:list) {
			System.out.print(i+" ");
		}
		
		System.out.println("\n====================");
		
		list.forEach(i->System.out.print(i+" "));
		
		System.out.println("\n====================");
		
		list.forEach(new MyConsumer());
		
		System.out.println("\n====================");
		
		list.forEach(t->System.out.print(t+" "));
	}

}

class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.print(t+" ");		
	}
	
}
