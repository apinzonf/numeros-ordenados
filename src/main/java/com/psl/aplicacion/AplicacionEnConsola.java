package com.psl.aplicacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.psl.numerico.NumeroOrdenado;

/**
 * Clase con metodo de entrada a la aplicación en consola.
 * */
public class AplicacionEnConsola {
	public static final String MENSAJE_SALIDA_POR_CASO = "Caso: ";
	
	private BufferedWriter bufferSalida;
	private LineIterator lineaDeEntrada;
	private StringBuilder textoSalida;
	
	/**
	 * @param nombreArchivoEntrada Nombre del archivo de entrada a procesar
	 * @param nombreArchivoSalida  Nombre del archivo de salida para escribir los resultados
	 * */
	public AplicacionEnConsola(String nombreArchivoEntrada, String nombreArchivoSalida) throws IOException {
		File archivoEntrada = new File(nombreArchivoEntrada);
		File archivoSalida = new File(nombreArchivoSalida);
		textoSalida = new StringBuilder(); 
		bufferSalida = new BufferedWriter(new FileWriter(archivoSalida));
		lineaDeEntrada = FileUtils.lineIterator(archivoEntrada, "UTF-8");
	}
	
	public void procesarArchivoDeEntrada() {
		int numeroDeCasosDePrueba = Integer.parseInt(lineaDeEntrada.next());
		
		for (int i=1; i<=numeroDeCasosDePrueba; i++) {
			String numeroEntrada = lineaDeEntrada.next();
			String numeroOrdenado = NumeroOrdenado.obtenerNumeroOrdenadoMenorQue(numeroEntrada);
			textoSalida.append(MENSAJE_SALIDA_POR_CASO + i + 
							   ": N=" +	numeroEntrada + ", O=" + numeroOrdenado + "\n");
		}
	}
	
	public void escribirResultadoEnArchivoDeSalida() throws IOException {
		LineIterator.closeQuietly(lineaDeEntrada);
		bufferSalida.write(textoSalida.toString());
		bufferSalida.flush();
		bufferSalida.close();
	}
	
	public static void main (String [] argumentos) throws IOException {
		if (argumentos.length < 2) {
			throw new IllegalArgumentException("Falta especificar los archivo entrada y salida");
		}
		String nombreArchivoEntrada = argumentos[0];
		String nombreArchivoSalida = argumentos[1];
		AplicacionEnConsola miAplicacionPrincipal = new AplicacionEnConsola(nombreArchivoEntrada, nombreArchivoSalida);
		miAplicacionPrincipal.procesarArchivoDeEntrada();
		miAplicacionPrincipal.escribirResultadoEnArchivoDeSalida();	
	}
	
}
