package studio9;

import java.util.Iterator;

public class DoublyLinkedListOfInts implements IntList {
	
	private ListItem head, tail;
	
	public DoublyLinkedListOfInts() {
		ListItem sentinelH = new ListItem(666666, null);
		ListItem sentinelT = new ListItem(666666, null);
		
		this.head = sentinelH;
		this.tail = sentinelT;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(int item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLast(int item) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(int item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
