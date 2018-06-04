package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.head.isNIL()) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		SingleLinkedListNode<T> current = this.head; 
		while(!current.isNIL()) {
			size++;
			current = current.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<T> current = this.head; 
		while(!current.isNIL()) {
			if (current.getData().equals(element)) {
				return current.getData();
			}else{ 
				current = current.getNext();
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<T> current = this.head; 
		while(!current.isNIL()) {
			current = current.getNext();
		}
		current.setData(element);
		current.setNext(new SingleLinkedListNode<T>());
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<T> current = this.head;
		
		if(this.head != null && this.head.equals(element)) {
			this.setHead(this.getHead().getNext());
		}
		
		while(!current.isNIL()) {
			if(current.getNext().getData().equals(element)) {
				current.setNext(current.getNext().getNext());
				break;
			
			}else {
				current = current.getNext();
			}
		}	
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		
		int size = this.size();
		T[] array = (T[]) new Object[size];
		int iteracao = 0;
		
		SingleLinkedListNode<T> current = this.head;
		while(!current.isNIL()) {
			array[iteracao] = current.getData();
			current = current.getNext();
			iteracao++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}