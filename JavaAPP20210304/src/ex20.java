import java.util.Arrays;
import java.util.List;

public class ex20 {

	public static void main(String[] args) {
		List<Integer> prices=Arrays.asList(3,4,5);
		prices.stream()
		.filter(e->e>4)
		.peek(e->System.out.print("Price "+e))
		.map(n->n-1)
		.peek(n->System.out.println(" New price "+n));
		//.forEach(n->System.out.println(" New price "+n));

	}

}
