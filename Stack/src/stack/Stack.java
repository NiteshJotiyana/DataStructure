package stack;

public class Stack<Item> {

	private Item[] A;
	private int DEFAULT_CAPACITY = 16;
	private int top = -1;
	private int capacity;

	public Stack() {
		this.capacity = DEFAULT_CAPACITY;
		A = (Item[]) new Object[this.capacity];
	}

	public Stack(int capacity) {
		this.capacity = capacity;
		A = (Item[]) new Object[this.capacity];
	}

	public boolean isFull() {
		if (top + 1 == capacity)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public void push(Item item) {

		if (!isFull()) {
			top++;
			A[top] = item;
		} else {
			System.out.println("Stack is Full !");
		}
	}

	public Item pop() {

		if (!isEmpty()) {
			Item cur = A[top];
			top--;
			return cur;
		} else {
			System.out.println("Stack is Empty !");
		}
		return null;
	}

	public Item peek() {
		if (!isEmpty()) {
			Item cur = A[top];
			return cur;
		}
		return null;
	}

	public void display() {
		if (!isEmpty()) {
			System.out.println("-----Start------");
			for (int i = top; i >= 0; i--) {
				System.out.println(A[i]);
			}
			System.out.println("------End------");
		} else {
			System.out.println("Stack is Empty !");
		}
	}
}
