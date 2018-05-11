package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends AbstractSorting<T> {

   public void sort(T[] array, int leftIndex, int rightIndex) {

      T temp;
      int min;
      int max;
      int interacao = array.length - 1;

      for (int i = leftIndex; i <= ((rightIndex) / 2); i++) {
         min = i;
         max = interacao;
         for (int j = i; j < array.length; j++) {
            if (array[j].compareTo(array[min]) < 0) {
               min = j;
            }
            if (array[j].compareTo(array[max]) > 0 && j <= interacao) {
               max = j;
            }
         }
         if (i != min) {
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
         }

         if (interacao != max) {
            if (i != max) {
               temp = array[max];
               array[max] = array[interacao];
               array[interacao] = temp;

            } else {
               temp = array[min];
               array[min] = array[interacao];
               array[interacao] = temp;
            }
         }
         interacao--;
      }
   }
}