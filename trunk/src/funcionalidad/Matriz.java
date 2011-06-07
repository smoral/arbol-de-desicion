package funcionalidad;

import java.util.Vector;

public class Matriz {
	private Vector<Columna> columnas = new Vector<Columna>();
	private Columna categorias;
	private Columna columnaMayorGanancia;

	public Columna getColumnaMayorGanancia() {
		return columnaMayorGanancia;
	}

	private float entropiaDeCategorias = 0;

	public void agregarColumna(Columna col) {
		columnas.add(col);
	}

	public void agregarColumnaCategoria(Columna categorias) {
		this.categorias = categorias;
	}

	public Columna obtenerColumna(String nombreColumna) {
		for (Columna col : columnas) {
			if (col.getNombre().equals(nombreColumna)) {
				return col;
			}
		}
		return null;
	}

	public Vector<Resultado> obtenerResultados() {
		procesarGananciaInformacionDeColumnas();
		Vector<Resultado> resultados = new Vector<Resultado>();
		for (String valorPosible : columnaMayorGanancia
				.obtenerValoresPosibles()) {
			resultados.add(obtenerResultado(valorPosible));
		}
		return resultados;

	}

	/**
	 * @param valorPosible
	 * @return Devuelve, segun el valor ingresado, la categoria del valor en la
	 *         columnma de mayor ganancia de informacion o si hay mas de una
	 *         categoria para ese valor, devuelve un arbol con la matriz de los
	 *         valores posibles
	 */
	private Resultado obtenerResultado(String valorPosible) {
		Resultado resultado = null;
		Vector<Integer> filas = columnaMayorGanancia
				.obtenerFilasEnColumna(valorPosible);
		Vector<String> valoresPorFila = categorias.obtenerValoresPorFilas(
				filas, true);
		if (valoresPorFila.size() == 1) {
			resultado = new ResultadoFinal(columnaMayorGanancia.getNombre(),
					valorPosible, valoresPorFila.firstElement());
		} else {
			Matriz subMatriz = generarSubMatriz(filas,
					columnaMayorGanancia.getNombre());
			resultado = new Arbol(columnaMayorGanancia.getNombre(),
					valorPosible, subMatriz);
		}
		return resultado;
	}

	/**
	 * Devuelve una matriz a partir de las filas pasadas sin meter la de mayor
	 * ganancia
	 * 
	 * @param filas
	 * @param nombreColumnaPatron
	 *            indica a partir de que columna se desea obtener los valores de
	 *            las demas, esta no ingresa en la subMatriz
	 * @return
	 */
	public Matriz generarSubMatriz(Vector<Integer> filas,
			String nombreColumnaPatron) {
		Matriz subMatriz = new Matriz();
		for (Columna columna : columnas) {
			if (!columna.getNombre().equals(nombreColumnaPatron)) {
				Columna columnaNueva = new Columna();
				columnaNueva.setNombre(columna.getNombre());
				columnaNueva.setValores(columna.obtenerValoresPorFilas(filas,
						false));
				subMatriz.agregarColumna(columnaNueva);
			}
		}
		Columna categoriasNuevas = new Columna();
		categoriasNuevas.setNombre(categorias.getNombre());
		categoriasNuevas.setValores(categorias.obtenerValoresPorFilas(filas,
				false));
		subMatriz.agregarColumnaCategoria(categoriasNuevas);
		return subMatriz;
	}

	/**
	 * Calcula la ganancia de informacion de cada columna de la matriz y guarda
	 * cual es la de mayor ganancia
	 */
	private void procesarGananciaInformacionDeColumnas() {
		float entropiaDeLasCategorias = calcularEntropiaDeCategorias();
		for (Columna columna : columnas) {
			float sumatoriaEntropias = 0; // es el segundo termino de la funcion
											// de Ganancia de Informacion
			for (String valorPosible : columna.obtenerValoresPosibles()) {
				float cantidadOcurrencias = columna
						.cantidadOcurrencias(valorPosible);
				float cantidadFilas = columna.cantidadFilas();
				float entropia = calcularEntropia(columna, valorPosible);
				sumatoriaEntropias += entropia
						* (cantidadOcurrencias / cantidadFilas);
			}
			columna.setGananciaDeInformacion(entropiaDeLasCategorias
					- sumatoriaEntropias);
			if (columnaMayorGanancia != null) {
				if (columnaMayorGanancia.getGananciaDeInformacion() < columna
						.getGananciaDeInformacion()) {
					columnaMayorGanancia = columna;
				}
			} else {
				columnaMayorGanancia = columna;
			}
		}
	}

	/**
	 * Devuelve cual es la entropia de la columna categorias
	 * 
	 * @return
	 */
	private float calcularEntropiaDeCategorias() {
		if (entropiaDeCategorias == 0) {
			for (String categoria : categorias.obtenerValoresPosibles()) {
				float cantidadOcurrenciasValorEnCategorias = categorias
						.cantidadOcurrencias(categoria);
				float cantidadFilasEnCategoria = categorias.cantidadFilas();
				float probabilidadDelValorEnCategoria = cantidadOcurrenciasValorEnCategorias
						/ cantidadFilasEnCategoria;
				float logaritmo = (float) (Math
						.log10(probabilidadDelValorEnCategoria) / Math.log10(2));
				float entropiaParcial = -probabilidadDelValorEnCategoria
						* logaritmo;
				entropiaDeCategorias += entropiaParcial;
			}
		}
		return entropiaDeCategorias;
	}

	/**
	 * Devuelve cual es la entropia de la columna para un valor posible
	 * especificado
	 * 
	 * @param columna
	 * @param valorPosible
	 * @return
	 */
	private float calcularEntropia(Columna columna, String valorPosible) {
		float entropiaTotal = 0;
		for (String categoria : categorias.obtenerValoresPosibles()) {
			Vector<Integer> filasEnColumna = columna
					.obtenerFilasEnColumna(valorPosible);
			float cantidadOcurrenciasDeLaCategoriaSegunValor = categorias
					.cantidadOcurrenciasDelValorSegunFilas(filasEnColumna,
							categoria);
			float cantidadOcurrenciasValorEnColumna = filasEnColumna.size();
			float probabilidadDelValorSegunCategoria = cantidadOcurrenciasDeLaCategoriaSegunValor
					/ cantidadOcurrenciasValorEnColumna;
			if (probabilidadDelValorSegunCategoria != 0) { // si es cero la
															// entropia es
															// directamente 0
				float logaritmo = (float) (Math
						.log10(probabilidadDelValorSegunCategoria) / Math
						.log10(2));
				float entropiaParcial = -probabilidadDelValorSegunCategoria
						* logaritmo;
				entropiaTotal += entropiaParcial;
			}
		}
		return entropiaTotal;
	}

}
