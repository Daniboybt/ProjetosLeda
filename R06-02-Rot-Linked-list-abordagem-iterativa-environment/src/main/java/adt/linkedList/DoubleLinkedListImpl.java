package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super.setHead(new DoubleLinkedListNode<T>());
		this.last = (DoubleLinkedListNode<T>) super.getHead();
	}
	
	@Override
	public T search(T element) {
		
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>)this.getHead();
		DoubleLinkedListNode<T> auxLast = (DoubleLinkedListNode<T>)this.getLast();
		T elemento;
		
		while(auxHead != auxLast && auxHead.getNext() != auxLast && 
				!element.equals(auxHead.getData()) && !element.equals(auxLast.getData())) {
			
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
			
		}
		if(element.equals(auxHead.getData())) {
			return auxHead.getData();
			
		}else if(element.equals(auxLast.getData())){
			return auxLast.getData();
		}
		return null;
	}
	
	@Override
	public void remove(T element) {
		
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>)this.getHead();
		DoubleLinkedListNode<T> auxLast = (DoubleLinkedListNode<T>)this.getLast();
		T elemento;
		
		while(auxHead != auxLast && auxHead.getNext() != auxLast && 
				!element.equals(auxHead.getData()) && !element.equals(auxLast.getData())) {
			
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
			
		}
		if(element.equals(auxHead.getData())) {	
			auxHead.getPrevious().setNext(auxHead.getNext());
			if(auxHead.getNext().isNIL()) this.setLast(auxHead.getPrevious());
			if(auxHead.getPrevious().isNIL())  this.setHead(auxHead.getPrevious());
		
		}else if(element.equals(auxLast.getData())){
			
			auxLast.getPrevious().setNext(auxHead.getNext());
			if(auxHead.getNext().isNIL()) this.setLast(auxHead.getPrevious());
			if(auxHead.getPrevious().isNIL())  this.setHead(auxHead.getPrevious());
		}
	}
	
	@Override
	public void insert(T element) {
		
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),this.last);
		this.last.setNext(newLast);
		
		if(this.last.isNIL()) this.setHead(newLast);
		this.setLast(newLast);
	}
	
	@Override
	public void insertFirst(T element) {
		//throw new UnsupportedOperationException("Not implemented yet!");
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element,
										(DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<T>());
		((DoubleLinkedListNode<T>)this.getHead()).setPrevious(newHead);
		
		if(this.head.isNIL()) this.setLast(newHead);
		this.setHead(newHead);
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!this.getHead().isNIL()) {			
			((DoubleLinkedListNode<T>)this.getHead().getNext()).setPrevious(new DoubleLinkedListNode<T>());
			this.setHead(this.getHead().getNext());
			
			if(this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>)this.getHead());
			}
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(!(getLast().isNIL())) {
			setLast(getLast().getPrevious());
			if (getLast().isNIL()) {
				setHead(getLast());
			}
			getLast().setNext(new DoubleLinkedListNode<T>());
		}
	}
	
	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}