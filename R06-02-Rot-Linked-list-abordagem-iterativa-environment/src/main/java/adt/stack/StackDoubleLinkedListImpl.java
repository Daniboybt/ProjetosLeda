package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (top.size() < size) {
			top.insert(element);
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T over = null;
		if (!(top.isEmpty())) {
			over = ((DoubleLinkedListImpl<T>) top).getLast().getData();
			top.removeLast();
		} else {
			throw new StackUnderflowException();
		}
		return over;
	}

	@Override
	public T top() {
		T over = null;
		if (!(top.isEmpty())) over = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		return over;
	}

	@Override
	public boolean isEmpty() {
		return (top.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (top.size() == size);
	}
}
