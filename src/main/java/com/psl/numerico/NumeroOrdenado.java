package com.psl.numerico;

import java.io.BufferedWriter;
import java.io.IOException;

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
	 * @param textoSalida objeto para escribir el número ordenado M, 1 <= M <= 10^18
	 * @throws IOException 
	 * */
	public static void obtenerNumeroOrdenadoMenorQue(String numeroEntrada, BufferedWriter textoSalida) throws IOException{
		int longitudEntrada = numeroEntrada.length();
		if (longitudEntrada <= 1) {
			textoSalida.append(numeroEntrada);
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
			cambiarDigitosPorMaximoPosible(numeroEntrada, indice, repeticiones, textoSalida);
		}
		
	}
	
	private static void cambiarDigitosPorMaximoPosible(String numeroEntrada, int indice, int repeticiones, BufferedWriter textoSalida) throws IOException {
		int longitudEntrada = numeroEntrada.length();
		if (indice == longitudEntrada-1) {
			textoSalida.append(numeroEntrada);
		} else {
			textoSalida.append(numeroEntrada.substring(0, indice-repeticiones));
			if (numeroEntrada.charAt(indice-repeticiones) != '1') {
				char digitoParaDecrementar = numeroEntrada.charAt(indice-repeticiones);
				digitoParaDecrementar -= 1;
				textoSalida.append(digitoParaDecrementar);
			}
			int numeroDeDigitosParaRemplazar = numeroEntrada.length() - indice + repeticiones - 1;
			textoSalida.append(NUMERO_ORDENADO_MAXIMO.substring(0, numeroDeDigitosParaRemplazar)); 
		}
	}
	
}
