package queue;

public class QueueDemo {

	public static void main(String[] args) {

		Queue<Integer> Q = new Queue<>(4);
		Q.enQueue(1);
		Q.enQueue(3);
		Q.enQueue(9);
		Q.enQueue(6);
		Q.enQueue(14);
		Q.enQueue(19);
		
		Q.display();
		
		Q.deQueue();
		Q.deQueue();
		
		Q.display();
		
		Q.enQueue(14);
		Q.enQueue(19);
		Q.enQueue(23);
		
		Q.display();		
	}
}
