package inicio;

import java.util.Vector;

import funcionalidad.Arbol;
import funcionalidad.Columna;
import funcionalidad.Matriz;

/**
 * @author smoral
 *
 */
public class inicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		Matriz matrizInicial = obtenerMatrizInicial();
		pruba();
	}
	

	/**
	 * @return Obtiene los datos del excel y los cargar en una matriz
	 */
	private static Matriz obtenerMatrizInicial() {
		// TODO Obtener los datos del excel y cargarlos en una matriz (CHO)
		return null;		
	}
	
	private static void pruba() {
		Matriz matrizInicial = new Matriz();
		Columna colNueva = null;
		
		//COLUMNA DIA
		colNueva = new Columna("dia");
		colNueva.agregarValor("lunes");
		colNueva.agregarValor("miercoles");
		colNueva.agregarValor("jueves");
		matrizInicial.agregarColumna(colNueva);

		//COLUMNA ESTACION
		colNueva = new Columna("estacion");
		colNueva.agregarValor("primavera");
		colNueva.agregarValor("invierno");
		colNueva.agregarValor("invierno");
		matrizInicial.agregarColumna(colNueva);

		//COLUMNA VIENTO
		colNueva = new Columna("viento");
		colNueva.agregarValor("no");
		colNueva.agregarValor("no");
		colNueva.agregarValor("no");
		matrizInicial.agregarColumna(colNueva);
		
		//COLUMNA LLUVIA
		colNueva = new Columna("lluvia");
		colNueva.agregarValor("no");
		colNueva.agregarValor("leve");
		colNueva.agregarValor("leve");
		matrizInicial.agregarColumna(colNueva);
		
		//COLUMNA CATEGORIA
		colNueva = new Columna("categoria");
		colNueva.agregarValor("puntual");
		colNueva.agregarValor("puntual");
		colNueva.agregarValor("atrasado");
		matrizInicial.agregarColumnaCategoria(colNueva);
		
		//Agrego la matriz al arbol
		Arbol arbolInicial = new Arbol(matrizInicial);
		
		//Creo una matriz con datos que quiero categorizar
		Matriz matrizDeDatos = new Matriz();
		colNueva = new Columna("dia");
		colNueva.agregarValor("lunes");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("estacion");
		colNueva.agregarValor("primavera");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("viento");
		colNueva.agregarValor("no");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("lluvia");
		colNueva.agregarValor("no");
		matrizDeDatos.agregarColumna(colNueva);
		
		String categoria = arbolInicial.obtenerCategoria(matrizDeDatos);
		System.out.println("La categoria es:" + categoria);
		
	}	
}
