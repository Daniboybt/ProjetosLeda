package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
		if (!(array.length == 0) && !(leftIndex < 0 || rightIndex >= array.length)) {
			int pivo = leftIndex + 1;
			
			while (pivo < rightIndex) {
				if (array[pivo].compareTo(array[pivo + 1]) > 0) {
					Util.swap(array, pivo, pivo + 1);
					
					if(pivo == leftIndex) {
						pivo++;
					
					} else {
						pivo--;
					}
				} else {
					pivo++;
				}
			}
		}
	}
}
