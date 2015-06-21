package hello;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Chapter2 {

	public Chapter2() {
		super();
	}

	public static void main(String[] args) {
		Chapter2 t = new Chapter2();
		t.go();		
	}

	private void go() {
		//
		Runnable r = () -> System.out.println("hello.");
		
		//
		ActionListener o = event -> {
			System.out.println("hello 2.");
		};
		
		//
		BinaryOperator<Long> result = (Long x, Long y) -> x + y;

		//
		String name = "abc";	// must to final or effectively final
		ActionListener e = event -> {
			System.out.println("hi " + name);
		};
		
		//
		Predicate<Integer> atKeast5 = x -> x > 5;
		BinaryOperator<Long> addLongs = (x, y) -> x + y;
	}

}