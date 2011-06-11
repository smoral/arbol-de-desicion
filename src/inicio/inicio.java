package inicio;

import java.util.Vector;

import jxl.*;

import funcionalidad.Arbol;
import funcionalidad.Columna;
import funcionalidad.Matriz;
import funcionalidad.ReadExcel;

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
		Arbol arbolInicial = new Arbol(matrizInicial);
		Matriz matrizDeDatos = obtenerMatrizAEvaluar();
		String categoria = arbolInicial.obtenerCategoria(matrizDeDatos);
		System.out.println("La categoria es:" + categoria);
		//pruba();
	}


	/**
	 * @return Obtiene los datos del excel y los cargar en una matriz
	 */
	private static Matriz obtenerMatrizInicial() {
		ReadExcel nuevaTabla = new ReadExcel();
		Sheet hoja = nuevaTabla.leerArchivoExcel("docs/TREN.xls");
		Matriz matrizInicial = new Matriz();

		int numColumnas = hoja.getColumns();
		int numFilas = hoja.getRows();
		String data;

		for (int columna = 0; columna < numColumnas; columna++) { // Recorre cada
			// columna de la hoja de excel
			//creo una columna nueva para la matriz
			//asigno el nombre a la columna
			Columna nueva = new Columna();
			if(columna<numColumnas-1){//esta condicion es xq si toma la ultima columna
			//ya corresponde al vector categorias.
			nueva.setNombre(hoja.getCell(columna, 0).getContents());
			matrizInicial.agregarColumna(nueva);
			}
			for (int fila = 1; fila < numFilas; fila++) { 
				// Recorre cada fila de la colummna
				//asigno los valores a la columna creada anteriormente
				//el ciclo for empieza en 1 xq la fila 0 se utiliza para asignarle 
				//el nombre a la columna
				if(columna<numColumnas-1){
					//pongo la condicion <numColumnas-1 xq meintras agrega el valor
					//a la columna, sino lo toma como valor categoria.
					matrizInicial.obtenerColumna(nueva.getNombre()).agregarValor(hoja.getCell(columna, fila).getContents());
					data = hoja.getCell(columna, fila).getContents();
//					System.out.print(data + " ");
//					System.out.println("\n");
				}else{
					matrizInicial.getCategorias().agregarValor(hoja.getCell(columna,fila).getContents());
//					System.out.println(hoja.getCell(columna,fila).getContents() + "--------------------------------");
				}
			}
		}
		
		return matrizInicial;		
	}

	private static void pruba() {
		Matriz matrizInicial = new Matriz();
		Columna colNueva = null;

		//COLUMNA DIA
		colNueva = new Columna("dia");
		colNueva.agregarValor("lunes");
		colNueva.agregarValor("miercoles");
		colNueva.agregarValor("lunes");
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
		colNueva.agregarValor("invierno");
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
	
	public static Matriz crearMatrizDeDatos(){
		//Creo una matriz con datos que quiero categorizar
		Matriz matrizDeDatos = new Matriz();
		Columna colNueva = new Columna();
		
		colNueva = new Columna("dia");
		colNueva.agregarValor("lunes");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("estacion");
		colNueva.agregarValor("invierno");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("viento");
		colNueva.agregarValor("no");
		matrizDeDatos.agregarColumna(colNueva);

		colNueva = new Columna("lluvia");
		colNueva.agregarValor("no");
		matrizDeDatos.agregarColumna(colNueva);
		
		return matrizDeDatos;
	}
	
	private static Matriz obtenerMatrizAEvaluar() {
		ReadExcel nuevaTabla = new ReadExcel();
		Sheet hoja = nuevaTabla.leerArchivoExcel("docs/AEvaluar.xls");
		Matriz matrizInicial = new Matriz();

		int numColumnas = hoja.getColumns();
		int numFilas = hoja.getRows();
		String data;

		for (int columna = 0; columna < numColumnas; columna++) { // Recorre cada
			// columna de la hoja de excel
			//creo una columna nueva para la matriz
			//asigno el nombre a la columna
			Columna nueva = new Columna();
			if(columna<numColumnas-1){//esta condicion es xq si toma la ultima columna
			//ya corresponde al vector categorias.
			nueva.setNombre(hoja.getCell(columna, 0).getContents());
			matrizInicial.agregarColumna(nueva);
			}
			for (int fila = 1; fila < numFilas; fila++) { 
				// Recorre cada fila de la colummna
				//asigno los valores a la columna creada anteriormente
				//el ciclo for empieza en 1 xq la fila 0 se utiliza para asignarle 
				//el nombre a la columna
				if(columna<numColumnas-1){
					//pongo la condicion <numColumnas-1 xq meintras agrega el valor
					//a la columna, sino lo toma como valor categoria.
					matrizInicial.obtenerColumna(nueva.getNombre()).agregarValor(hoja.getCell(columna, fila).getContents());
					data = hoja.getCell(columna, fila).getContents();
//					System.out.print(data + " ");
//					System.out.println("\n");
				}else{
					matrizInicial.getCategorias().agregarValor(hoja.getCell(columna,fila).getContents());
//					System.out.println(hoja.getCell(columna,fila).getContents() + "--------------------------------");
				}
			}
		}
		return matrizInicial;		
	}
}
