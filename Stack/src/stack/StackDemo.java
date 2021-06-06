package stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> S = new Stack<>(3);

		
		S.push(1);
		S.push(10);
		S.push(5);
		S.push(3);
		S.push(14);
		
		S.display();
		
		System.out.println(S.peek());
		
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		System.out.println(S.pop());
		
		
		S.display();
	}
}
