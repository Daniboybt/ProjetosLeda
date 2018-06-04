package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if (!(array.length == 0) && !(rightIndex >= array.length)) {
			double fator = 1.25;
			int den = rightIndex - leftIndex + 1;
			int gap = (int) (den / fator);
			int i = leftIndex;
			
			while (gap >= 1) {
				if (i + gap <= rightIndex) {
					
					if (array[i].compareTo(array[i + gap]) > 0) {
						Util.swap(array, i, i + gap);
					}
					i++;
				
				} else {
					den--;
					gap = (int) (den / fator);
					i = leftIndex;
				}
			}
		}
	}
}
