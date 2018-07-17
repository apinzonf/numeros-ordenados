package com.psl.numerico;

public class NumeroOrdenado {
	
	public static final String NUMERO_ORDENADO_MAXIMO = "999999999999999999"; // Para n = 10^18 
	
	public static String obtenerNumeroOrdenadoMenorQue(String numeroEntrada){
		String numeroSalida;
		char[] digitosEntrada = numeroEntrada.toCharArray();
		int longitudEntrada = digitosEntrada.length;
		if (longitudEntrada <= 1) {
			numeroSalida = numeroEntrada;
		} else {
			int indice = 0;
			int repeticiones = 0;
			while ((indice + 1) != longitudEntrada 
				   && digitosEntrada[indice] <= digitosEntrada[indice+1]) {
				if (digitosEntrada[indice] == digitosEntrada[indice+1]) {
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
	
	public static String cambiarDigitosPorMaximoPosible(String numeroEntrada, int indice, int repeticiones) {
		String numeroSalida;
		int longitudEntrada = numeroEntrada.length();
		if (indice == longitudEntrada-1) {
			numeroSalida = numeroEntrada;
		} else {
			numeroSalida = numeroEntrada.substring(0, indice-repeticiones);
			if (numeroEntrada.charAt(indice-repeticiones) != '1') {
				char digitoParaDecrementar = numeroEntrada.charAt(indice-repeticiones);
				digitoParaDecrementar -= 1;
				numeroSalida += digitoParaDecrementar;
			}
			int numeroDeDigitosParaRemplazar = numeroEntrada.length() - indice + repeticiones - 1;
			numeroSalida += NUMERO_ORDENADO_MAXIMO.substring(0, numeroDeDigitosParaRemplazar);
		}
		return numeroSalida;
	}
	
	public static boolean esOrdenado(String entrada) {
		int index = 0;
		while(index+1 < entrada.length() && entrada.charAt(index) <=  entrada.charAt(index+1)) {
			index++;
		}
		return index == entrada.length()-1;
	}
	
}
