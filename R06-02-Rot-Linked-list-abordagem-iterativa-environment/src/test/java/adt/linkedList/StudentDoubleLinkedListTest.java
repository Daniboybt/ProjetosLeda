package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;
	private DoubleLinkedList<Integer> lista4;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
		
		//lista com 2 elementos
		lista4.insert(4);
		lista4.insert(5);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
		lista4 = new DoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}
	
	@Test
	public void testSearch2() {
		Assert.assertEquals(new Integer(1), lista3.search(1));
		Assert.assertEquals(new Integer(5), lista4.search(5));
	}
	
	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista3).removeLast();
		//Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		Assert.assertArrayEquals(new Integer[] { }, lista3.toArray());
	}
}