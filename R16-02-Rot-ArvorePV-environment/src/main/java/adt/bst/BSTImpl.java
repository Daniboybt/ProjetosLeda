package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
		if(this.isEmpty()) 
			return -1;
		
		return height(this.root) - 1;
	}

	private int height(BTNode<T> current) {
		if(current.isEmpty()) return 0;
		
		else {			
			int left = 1 + height(current.getLeft());
			int right = 1 + height(current.getRight());
			
			if(left > right) 
				return left;
			else 
				return right;
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> current) {
		
		if(current.isEmpty()) {
			return current;
		}else {			
			if(element.compareTo(current.getData()) < 0) {
				return search(element, (BSTNode<T>) current.getLeft());
			}else if(element.compareTo(current.getData()) > 0) {
				return search(element, (BSTNode<T>) current.getRight());
			}else {
				return current;
			}
		}
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
		insert(element, this.root, new BSTNode<T>());
	}

	private void insert(T element, BSTNode<T> current, BSTNode<T> parent) {
		
		if(current.isEmpty()) {
			current.setData(element);
			current.setLeft(new BSTNode.Builder<T>().build());
			current.setRight(new BSTNode.Builder<T>().build());
			current.setParent(parent);
		}else {
			if(element.compareTo(current.getData()) < 0){
				insert(element, (BSTNode<T>)current.getLeft(), current);
			}else if(element.compareTo(current.getData()) > 0) {
				insert(element, (BSTNode<T>)current.getRight(), current);
			}
		}	
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");	
		if(this.isEmpty()) {
			return null;
		}
		
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> current) {
		
		if(current.getRight().isEmpty()) {
			return current;
		}else {
			return maximum((BSTNode<T>)current.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
		if(this.isEmpty()) {
			return null;
		}
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> current) {
		if(current.getLeft().isEmpty()) {
			return current;
		}else {
			return minimum((BSTNode<T>) current.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		BSTNode<T> node = search(element);
		if(node.isEmpty()) return null;
		
		if(!node.getRight().isEmpty()) {
			return this.minimum((BSTNode<T>)node.getRight());
		}
		BSTNode<T> son = node;
		node = (BSTNode<T>)node.getParent();
		// ajeitar
		while(!node.isEmpty() && son.getData().equals(node.getRight().getData())) {
			
			son = node;
			node = (BSTNode<T>)node.getParent();
		}
		if(node.isEmpty()) 
			return null;	
		else 
			return node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		BSTNode<T> node = search(element);
		if(node.isEmpty()) {
			return null;
		}
		if(!node.getLeft().isEmpty()) {
			return this.maximum((BSTNode<T>)node.getLeft());
		}
		BSTNode<T> son = node;
		node = (BSTNode<T>)node.getParent();
		//ajeitar
		while(!node.isEmpty() && son.equals((BSTNode<T>)node.getLeft())) {
			
			son = node;
			node = (BSTNode<T>)node.getParent();
		}
		if(!node.isEmpty()) {
			return node;
		}
		return null;
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");		
		BSTNode<T> node = this.search(element);
		remove(element, node);
	}

	private void remove(T element, BSTNode<T> node) {
		if(node.isEmpty()) {
			return;
		}		
		if(node.isLeaf()) {
			node.setData(null);
		}else if(node.getRight().isEmpty()) {
			node.setData(node.getLeft().getData());
			node.setRight(node.getLeft().getRight());
			node.setLeft(node.getLeft().getLeft());
		}else if(node.getLeft().isEmpty()) {
			node.setData(node.getRight().getData());
			node.setLeft(node.getRight().getLeft());
			node.setRight(node.getRight().getRight());
		}else if(!node.getRight().isEmpty() && !node.getLeft().isEmpty()) {
			BSTNode<T> sucessor = sucessor(element);
			node.setData(sucessor.getData());
			this.remove(sucessor.getData(), sucessor);
		}		
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		T[] array = (T[])new Comparable[this.size()];
		
		if(!this.isEmpty()) {			
			preOrderArray(this.root, array, 0);
		}
		return array;
	}

	private int preOrderArray(BSTNode<T> current, T[] array, int posicao) {
		if(!current.isEmpty()) {
			array[posicao++] = current.getData();
			posicao = preOrderArray((BSTNode<T>)current.getLeft(), array, posicao);
			posicao = preOrderArray((BSTNode<T>)current.getRight(), array, posicao);
		}
		return posicao; 
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		T[] array = (T[])new Comparable[this.size()];
		if(!this.isEmpty()) {			
			orderArray(this.root, array, 0);
		}	
		return array;
	}

	private int orderArray(BSTNode<T> current, T[] array, int posicao) {
		if(!current.isEmpty()) {
			posicao = orderArray((BSTNode<T>)current.getLeft(), array, posicao);
			array[posicao++] = current.getData();
			posicao = orderArray((BSTNode<T>)current.getRight(), array, posicao);
		}
		return posicao;
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		T[] array = (T[])new Comparable[this.size()];
		if(!this.isEmpty()) {			
			postOrderArray(this.root, array, 0);
		}
		return array;
	}

	private int postOrderArray(BSTNode<T> current, T[] array, int posicao) {
		if(!current.isEmpty()) {
			posicao = orderArray((BSTNode<T>)current.getLeft(), array, posicao);
			posicao = orderArray((BSTNode<T>)current.getRight(), array, posicao);
			array[posicao++] = current.getData();
		}
		return posicao;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}
