package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
			if (rightIndex < leftIndex) return;
			if (confereArray(array)) return;
			
			int maiorNumero = maxElement(array, leftIndex, rightIndex);
			int menorNumero = minElement(array, leftIndex, rightIndex);
			
			
			Integer[] arrayAux = arrayContador(array, maiorNumero, menorNumero);
			arrayAux = somaDePrefixos(arrayAux);
			arrayAux = ordenacao(array, arrayAux, leftIndex, rightIndex, menorNumero);
			modificar(array, arrayAux, leftIndex, rightIndex);
		}

		private int minElement(Integer[] array, int leftIndex, int rightIndex) {
			int menor = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) if (array[i] < menor) menor = array[i];
			return menor;
		}

		private int maxElement(Integer[] array, int leftIndex, int rightIndex) {
			int maior = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) if (array[i] > maior) maior = array[i];
			return maior;
		}
		
		private Integer[] arrayContador(Integer[] array, int maiorNumero, int menorNumero) {
			
			Integer[] arrayContador = new Integer[maiorNumero-menorNumero+1];
			
			for (int i = 0; i < arrayContador.length; i++) arrayContador[i] = 0;
			
			for (int i = 0; i < array.length; i++) arrayContador[array[i]-menorNumero]++;
			
			return arrayContador;
		}
		
		
		private boolean confereArray(Integer[] array) {
			return (array == null || array.length <= 1);
		}
		
		private Integer[] ordenacao(Integer[] array, Integer[] arrayContador, int leftIndex, int rightIndex, int menorNumero) {
			
			Integer[] aux = new Integer[array.length];
			
			for (int i = 0; i < aux.length; i++) aux[i] = 0;
			
			for (int i = array.length-1; i >= 0 ; i--) {
				int valorDaArrayOriginal = array[i];
				
				arrayContador[array[i]-menorNumero]--;
				int posicaoContador = arrayContador[valorDaArrayOriginal-menorNumero];
				aux[posicaoContador] = array[i];
			}
			return aux;
		}

		private Integer[] somaDePrefixos(Integer[] arrayContador) {
			for (int i = 0; i < arrayContador.length-1; i++) arrayContador[i+1] += arrayContador[i];
			return arrayContador;
		}
		
		private void modificar(Integer[] array, Integer[] arrayContador, int leftIndex, int rightIndex) {
			for (int i = leftIndex; i <= rightIndex; i++) array[i] = arrayContador[i];
		}

}
