package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}
	
	@Override
	public void insert(T element) {
		if(this.getData() == null) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<T>());
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			return;
		}else if(this.getNext().getData() == null) {
			
			RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>)this.getNext();
			next.setData(element);
			next.setNext(new RecursiveDoubleLinkedListImpl<T>());
			next.setPrevious(this);
		}else {
			this.getNext().insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			if (!(isEmpty())) {
				if(getData() == element) {
					if(getPrevious().isEmpty() && getNext().isEmpty()) {
						setData(null); setNext(null); setPrevious(null);
					} else {
						setData(getNext().getData());
						setNext(getNext().getNext());
						
						if(next!= null) ((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
					}
				} else getNext().remove(element);
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
		if(!this.isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>(this.getData(),
								(RecursiveDoubleLinkedListImpl<T>)this.getNext(), this);
			this.setData(element);
			this.setNext(newNode);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!this.isEmpty()) {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(this.getData() == null) {
			return;
		}else if(this.getNext().getData() == null){
			this.getPrevious().setNext(this.getNext());
			return;
		}else {
			((RecursiveDoubleLinkedListImpl<T>)this.getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
