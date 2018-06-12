package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(this.data == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(this.getData() == null) {
			return 0;
		}else {
			return 1 + this.getNext().size();
		}
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(this.getData() == null) {
			return null;
		}else if(this.getData().equals(element)) {
			return this.getData();
		}else {
			return this.getNext().search(element);
		}
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		RecursiveSingleLinkedListImpl<T> current = this;
		
		if(this.getData() == null) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<T>());
			return;
		}else {
			this.getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
		if(this.getData() == null) {
			return;
		}else if(this.getData().equals(element)){
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
		}else {
			this.getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		RecursiveSingleLinkedListImpl<T> current = this;
		T[] array = (T[])new Object[this.size()];
		int count = 0;
		
		while(current.getData() != null) {
			array[count] = current.getData();
			current = current.getNext();
			count++;
		}
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
