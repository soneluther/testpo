import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class lambdaDemo2 {

	public static void main(String[] args) {
		List<String> list=Arrays.asList("hello", "good", "afternoon");
		list.replaceAll(new MyUnaryOperator());
		list.forEach(t->System.out.print(t+" "));
		
		System.out.println("\n====================");
	
		list.replaceAll(t->t.toUpperCase());
		list.forEach(s->System.out.print(s+" "));
		
	}

}

class MyUnaryOperator implements UnaryOperator<String>{

	@Override
	public String apply(String t) {
		
		return t.toUpperCase();
	}
	
}