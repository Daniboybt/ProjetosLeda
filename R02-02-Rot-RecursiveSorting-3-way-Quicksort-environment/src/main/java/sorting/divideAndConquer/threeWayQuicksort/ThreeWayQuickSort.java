package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		 if (rightIndex - leftIndex <= 0) {
	         return;

	      } else {
	         int[] index_pivot = ordenacao(array, leftIndex, rightIndex);

	         sort(array, leftIndex, index_pivot[0] - 1);
	         sort(array, index_pivot[1] + 1, rightIndex);
	      }
	   }

	   private int[] ordenacao(T[] array, int leftIndex, int rightIndex) {

	      T pivot = array[leftIndex];
	      int i = leftIndex;

	      for (int j = leftIndex + 1; j <= rightIndex; j++) {
	         if (array[j].compareTo(pivot) < 0) {
	            i += 1;
	            T aux = array[i];
	            array[i] = array[j];
	            array[j] = aux;
	         }
	      }
	      T aux = array[leftIndex];
	      array[leftIndex] = array[i];
	      array[i] = aux;
	      
	      int indexIguais = i;
	      for(int j = i + 1; j < rightIndex; j++) {	    	  
	    	  if (array[j].compareTo(array[i]) == 0) {
	    		  indexIguais++;
	    		  aux = array[indexIguais];
	    	      array[indexIguais] = array[j];
	    	      array[j] = aux;
	    	  }
	      }
	      
	      return new int[] {i, indexIguais};
	   }
}
