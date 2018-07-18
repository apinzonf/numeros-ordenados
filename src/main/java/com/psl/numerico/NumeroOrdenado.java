package com.psl.numerico;

/**
 * Un número “ordenado” es un entero en base 10, sin cero a la izquierda, 
 * tiene todos sus dígitos ordenados en orden no-descendente
 * */
public class NumeroOrdenado {
	
	private static final String NUMERO_ORDENADO_MAXIMO = "999999999999999999"; // Para n = 10^18 

	/**
	 * Enccontrar el número ordenado que es el mayor de todos los 
	 * números ordenados menores que el número dado 
	 * @param numeroEntrada entero N, 1 <= N <= 10^18 
	 * @return número ordenado M, 1 <= M <= 10^18
	 * */
	public static String obtenerNumeroOrdenadoMenorQue(String numeroEntrada){
		String numeroSalida;
		int longitudEntrada = numeroEntrada.length();
		if (longitudEntrada <= 1) {
			numeroSalida = numeroEntrada;
		} else {
			int indice = 0;
			int repeticiones = 0;
			while ((indice + 1) != longitudEntrada 
				   && numeroEntrada.charAt(indice) <= numeroEntrada.charAt(indice+1)) {
				if (numeroEntrada.charAt(indice) == numeroEntrada.charAt(indice+1)) {
					repeticiones ++;
				} else {
					repeticiones = 0;
				}
				indice ++;
			}
			numeroSalida = cambiarDigitosPorMaximoPosible(numeroEntrada, indice, repeticiones);
		}
		return numeroSalida;
	}
	
	private static String cambiarDigitosPorMaximoPosible(String numeroEntrada, int indice, int repeticiones) {
		String numeroSalida;
		StringBuilder buferSalida = new StringBuilder(18);
		int longitudEntrada = numeroEntrada.length();
		if (indice == longitudEntrada-1) {
			numeroSalida = numeroEntrada;
		} else {
			buferSalida.append(numeroEntrada.substring(0, indice-repeticiones));
			if (numeroEntrada.charAt(indice-repeticiones) != '1') {
				char digitoParaDecrementar = numeroEntrada.charAt(indice-repeticiones);
				digitoParaDecrementar -= 1;
				buferSalida.append(digitoParaDecrementar);
			}
			int numeroDeDigitosParaRemplazar = numeroEntrada.length() - indice + repeticiones - 1;
			buferSalida.append(NUMERO_ORDENADO_MAXIMO.substring(0, numeroDeDigitosParaRemplazar));
			numeroSalida = buferSalida.toString(); 
		}
		return numeroSalida;
	}
	
}
