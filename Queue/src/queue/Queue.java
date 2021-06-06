package queue;

public class Queue<Item> {

	public static final int DEFAULT_CAPACITY = 16;

	private Item A[] = null;
	private int capacity;

	// for remove
	private int head = -1;

	// for add
	private int tail = -1;

	public Queue() {
		this.capacity = DEFAULT_CAPACITY;
		A = (Item[]) new Object[this.capacity];
	}

	public Queue(int capacity) {
		this.capacity = capacity;
		A = (Item[]) new Object[this.capacity];
	}

	public boolean isFull() {
		// System.out.println(head + " " + tail);
		if ((tail + 1) % capacity == head)
			return true;

		return false;
	}

	public boolean isEmpty() {
		if (head == -1)
			return true;

		return false;
	}

	public int size() {
		return (capacity - head + tail + 1) % capacity;
	}

	public void enQueue(Item item) {

		if (!isFull()) {
			tail = (tail + 1) % capacity;
			A[tail] = item;
			if (head == -1) {
				head = tail;
			}
		} else {
			System.out.println("Queue is Full !");
		}
	}

	public Item deQueue() {

		if (!isEmpty()) {
			Item item = A[head];
			A[head] = null;
			if (head == tail) {
				head = -1;
				tail = -1;
			} else {
				head = (head + 1) % capacity;
			}
			return item;
		} else {
			System.out.println("Queue is Empty !");
		}
		return null;
	}

	public void display() {
		System.out.println("---------------------");
		for (int i = 0; i < A.length; i++) {
			System.out.println(i + " : " + A[i]);
		}
		System.out.println("---------------------");
	}
}
