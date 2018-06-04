package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insertFirst(T element) {
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(super.isEmpty()) {
			super.insert(element);
		}
		if(super.getHead().getNext().getNext().isNIL()) {
			
			super.setHead(new SingleLinkedNode(element, new DoubleSinglelinkedNode));
		}
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}