package funcionalidad;

import java.util.Vector;

public class Matriz {
	private Vector<Columna> columnas;
	private Columna categorias;
	private float entropiaDeCategorias = 0;

	public void agregarColumna(Columna col) {
		columnas.add(col);
	}

	public void agregarColumnaCategoria(Columna categorias) {
		this.categorias = categorias;
	}

	/**
	 * @param columnaPatron
	 *            Es la columna en la cual se buscara el valorPatron
	 * @param valorPatron
	 *            Es el valor por el cual se obtendran los valores de las otras
	 *            columnas
	 * @return
	 */
	public Matriz obtenerSubMatriz(Columna columnaPatron, String valorPatron) {
		return null;
	}

	public Vector<Resultado> obtenerResultados() {
		obtenerGananciaInformacionDeColumnas();
		// TODO Generar los resultados
		return null;

	}	

	/**
	 * Calcula la ganancia de informacion de cada columna de la matriz
	 */
	private void obtenerGananciaInformacionDeColumnas() {
		float entropiaDeLasCategorias = calcularEntorpiaDeCategorias();
		for (Columna columna : columnas) {
			float sumatoriaEntropias = 0; //es el segundo termino de la funcion de Ganancia de Informacion 
			for (String valorPosible : columna.obtenerValoresPosibles()) {
				float cantidadOcurrencias = columna.cantidadOcurrencias(valorPosible);
				float cantidadFilas = columna.cantidadFilas();
				float entropia = calcularEntropia(columna,valorPosible);
				sumatoriaEntropias += entropia * (cantidadOcurrencias / cantidadFilas);
			}
			columna.setGananciaDeInformacion(entropiaDeLasCategorias-sumatoriaEntropias);
		}		
	}

	/**
	 * Devuelve cual es la entropia de la columna categorias
	 * @return
	 */
	private float calcularEntorpiaDeCategorias() {
		if (entropiaDeCategorias == 0){
			for (String categoria : categorias.obtenerValoresPosibles()) {
				float cantidadOcurrenciasValorEnCategorias = categorias.cantidadOcurrencias(categoria);
				float cantidadFilasEnCategoria = categorias.cantidadFilas();
				float probabilidadDelValorEnCategoria = cantidadOcurrenciasValorEnCategorias / cantidadFilasEnCategoria;
				float logaritmo = (float)(Math.log10(probabilidadDelValorEnCategoria)/Math.log10(2));
				float entropiaParcial = probabilidadDelValorEnCategoria * logaritmo;
				entropiaDeCategorias += entropiaParcial;
			}
		}
		return entropiaDeCategorias;
	}

	/**
	 * Devuelve cual es la entropia de la columna para un valor posible especificado  
	 * @param columna
	 * @param valorPosible
	 * @return
	 */
	private float calcularEntropia(Columna columna, String valorPosible) {
		float entropiaTotal = 0;
		for (String categoria : categorias.obtenerValoresPosibles()) {
			Vector<Integer> filasEnColumna = columna.filasEnColumna(valorPosible);
			float cantidadOcurrenciasDeLaCategoriaSegunValor = categorias.cantidadOcurrenciasDelValorSegunFilas(filasEnColumna, categoria);
			float cantidadOcurrenciasValorEnColumna =filasEnColumna.size();
			float probabilidadDelValorSegunCategoria = cantidadOcurrenciasDeLaCategoriaSegunValor / cantidadOcurrenciasValorEnColumna;
			if (probabilidadDelValorSegunCategoria != 0){ //si es cero la entropia es directamente 0
				float logaritmo = (float)(Math.log10(probabilidadDelValorSegunCategoria)/Math.log10(2));
				float entropiaParcial = probabilidadDelValorSegunCategoria * logaritmo;
				entropiaTotal += entropiaParcial;	
			}
		}
		return entropiaTotal;
	}
	
	
	
}
