package exercises9;

public class ListNode<T> {
	
	T           value;
	ListNode<T> next;
	
	public ListNode(T value) {
		ListNode <Integer> p = null;
		this.value = value;
	}
	

	//
	// static and iterative
	//
	public static<T> int sizeIterative(ListNode<T> start) {
		int size = 0;
		for (ListNode<T> p = start; p != null; p = p.next) {
			size++;
		}
		return size;
	}
	
	//
	// static and recursive
	//
	public static<T> int size(ListNode<T> start) {
		if (start == null) return 0;
		else return 1 + size(start.next);
	}
	
	//
	// static and recursive
	//
	public static<T> int sum(ListNode<T> start) {
		if (start == null) return 0;
		else return (int)start.value + sum(start.next);
	}
	
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(131);
		head.next              = new ListNode<Integer>(132);
		head.next.next         = new ListNode<Integer>(240);
		head.next.next.next    = new ListNode<Integer>(241);
		System.out.println(head.value 
				+ " " + head.next.value
				+ " " + head.next.next.value 
				+ " " + head.next.next.next.value);
		System.out.println("From start " + size(head));
		System.out.println(" next " + size(head.next));
		System.out.println(" then " + size(head.next.next));
		System.out.println(" then " + size(head.next.next.next));
		System.out.println(" end " + size(head.next.next.next.next));
		System.out.println("From start " + sum(head));
		System.out.println(" next " + sum(head.next));
		System.out.println(" then " + sum(head.next.next));
		System.out.println(" then " + sum(head.next.next.next));
		System.out.println(" end " + sum(head.next.next.next.next));
	}

}
