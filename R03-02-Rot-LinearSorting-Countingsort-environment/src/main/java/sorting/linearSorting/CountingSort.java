package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
		if (rightIndex < leftIndex) return;
		if (confereArray(array)) return;
		int maiorNumero = maxElement(array, leftIndex, rightIndex);
		
		Integer[] arrayAux = ArrayContador(array, maiorNumero);
		
		arrayAux = somaDePrefixos(arrayAux);
		
		arrayAux = ordenacao(array, arrayAux, leftIndex, rightIndex);
		
		alteraArray(array, arrayAux, leftIndex, rightIndex);
		
	}

	private int maxElement(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[0];
		for (int i = leftIndex; i <= rightIndex; i++) if (array[i] > maior) maior = array[i];
		return maior;
	}
	
	private Integer[] ArrayContador(Integer[] array, int maiorNumero) {
		
		Integer[] arrayContador = new Integer[maiorNumero+1];
		
		for (int i = 0; i < arrayContador.length; i++) arrayContador[i] = 0;
		
		for (int i = 0; i < array.length; i++) arrayContador[array[i]]++;
		
		return arrayContador;
	}
	
	private Integer[] somaDePrefixos(Integer[] arrayContador) {
		for (int i = 0; i < arrayContador.length-1; i++) arrayContador[i+1] += arrayContador[i];
		return arrayContador;
	}
	
	private void alteraArray(Integer[] array, Integer[] arrayContador, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) array[i] = arrayContador[i];
	}
	
	private Integer[] ordenacao(Integer[] array, Integer[] arrayAux, int leftIndex, int rightIndex) {
		
		Integer[] aux = new Integer[array.length];
		
		for (int i = 0; i < aux.length; i++) aux[i] = 0;
		
		for (int i = array.length-1; i >= 0 ; i--) {
			int valorDaArrayOriginal = array[i];
			
			arrayAux[array[i]]--;
			int posicao = arrayAux[valorDaArrayOriginal];
			aux[posicao] = array[i];
		}
		return aux;
	}

	private boolean confereArray(Integer[] array) {
		return (array == null || array.length <= 1);
	}
}
