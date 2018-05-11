package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      //throw new UnsupportedOperationException("Not implemented yet!");

      int pivô;

      if (rightIndex - leftIndex <= 0) {
         return;
      } else {
         pivô = (rightIndex + leftIndex) / 2;

         sort(array, leftIndex, pivô);
         sort(array, pivô + 1, rightIndex);

         this.mergeList(array, leftIndex, pivô, rightIndex);
      }
   }

   private void mergeList(T[] array, int leftIndex, int middleIndex, int rightIndex) {

      int iteracao = 0;
      int iteracaoList1 = leftIndex;
      int iteracaoList2 = middleIndex + 1;
      Object[] arrayAux = new Object[rightIndex - leftIndex + 1];

      while (iteracaoList1 <= middleIndex && iteracaoList2 <= rightIndex) {

         if (array[iteracaoList1].compareTo(array[iteracaoList2]) <= 0) {
            arrayAux[iteracao] = array[iteracaoList1];
            iteracaoList1++;

         } else {
            arrayAux[iteracao] = array[iteracaoList2];
            iteracaoList2++;
         }
         iteracao++;
      }
      while (iteracaoList1 <= middleIndex) {
         arrayAux[iteracao] = array[iteracaoList1];
         iteracaoList1++;
         iteracao++;
      }
      while (iteracaoList2 <= rightIndex) {
         arrayAux[iteracao] = array[iteracaoList2];
         iteracaoList2++;
         iteracao++;
      }

      iteracao = leftIndex;
      for (int i = 0; i < arrayAux.length; i++) {

         array[iteracao] = (T) arrayAux[i];
         iteracao++;
      }
   }
}
