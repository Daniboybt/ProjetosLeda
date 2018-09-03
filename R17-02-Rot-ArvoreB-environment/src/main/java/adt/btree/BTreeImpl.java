package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		if(!this.root.isEmpty()) {
			return height(this.root);
		}
		return 0;
	}

	private int height(BNode<T> node) {
		// TODO Implement your code here
		//throw new UnsupportedOperationException("Not Implemented yet!");
		if(!node.isLeaf()) {
			return 1 + height(node.getChildren().getFirst());
		}
		return 1;
	}

	@Override
	public BNode<T>[] depthLeftOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public int size() {
		if(!this.root.isEmpty()) {
			return size(this.root); 
		}
		return 0;
	}

	private int size(BNode<T> current) {
		int res = current.getElements().size();
		if(!current.isLeaf()) {
			for(int i = 0; i < current.getChildren().size(); i++) {
				res += size(current.getChildren().get(i));
			}	
		}
		return res;
	}

	@Override
	public BNodePosition<T> search(T element) {
		if(!this.root.isEmpty()) {
			return this.search(element, this.root);
		}
		return null;
	}

	private BNodePosition<T> search(T element, BNode<T> current) {
		BNodePosition<T> node = new BNodePosition<T>();
		int positionNode;
		for(int i = 0; i < current.getElements().size(); i++) {
			if(element.compareTo(current.getElementAt(i)) < 0) {
				positionNode = i;
				break;
			}else if(element.compareTo(current.getElementAt(i)) > 0) {
				positionNode = i + 1;
			}else {
				return new BNodePosition(current, i);
			}
		}
		if(!current.isLeaf()) {
			
		}
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");

	}

	private void split(BNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	private void promote(BNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
