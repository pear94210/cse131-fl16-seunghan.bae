package studio9;

import java.util.Iterator;

public class DoublyLinkedListOfInts implements IntList {
	
	private ListItem head, tail;
	
	public DoublyLinkedListOfInts() {
		ListItem sentinelH = new ListItem(666666, null, null);
		ListItem sentinelT = new ListItem(666666, null, null);
		
		this.head = sentinelH;
		this.tail = sentinelT;
		
		this.tail.setPrev(this.head);
		this.head.setNext(this.tail);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(int item) {
		ListItem p = new ListItem(item, this.head.getNext(), this.head);
		this.head.getNext().setPrev(p);
		this.head.setNext(p);
	}

	@Override
	public void addLast(int item) {
		ListItem p = new ListItem(item, this.tail, this.tail.getPrev());
		this.tail.getPrev().setNext(p);
		this.tail.setPrev(p);
	}

	@Override
	public int size() {
		int ans = 0;
		for (ListItem p = this.head.getNext(); p != this.tail; p = p.getNext()) {
			ans = ans + 1;
		}
		return ans;
	}

	@Override
	public int indexOf(int item) {
		int ans = 0;
		for (ListItem p = this.head.getNext(); p != this.tail; p = p.getNext()) {
			if (p.getValue() == item)
				return ans;
			ans++;
		}
		return -1;
	}

	@Override
	public boolean remove(int item) {
		for (ListItem p = this.head; p.getNext() != null; p = p.getNext()) {
			if (p.getNext().getValue() == item) {
				p.getNext().getNext().setPrev(p);
				p.setNext(p.getNext().getNext());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		String ans = "[";
		for (ListItem p = this.head.getNext(); p != this.tail; p = p.getNext()) {
			ans = ans + p.getValue() + " ";
		}
		ans = ans + "]";
		
		return ans;
	}

}
