package funcionalidad;

import java.util.Vector;

public class Columna {
	private String nombre;
	private Vector<String> valores;
	private float gananciaDeInformacion;

	public void agregarValor (String valor){
		valores.add(valor);
	}
	
	public Columna(String nombre) {
		this.valores = new Vector<String>();
		this.nombre = nombre;
	}

	public Columna() {
		this.valores = new Vector<String>();
	}

	public float getGananciaDeInformacion() {
		return gananciaDeInformacion;
	}

	public void setGananciaDeInformacion(float gananciaDeInformacion) {
		this.gananciaDeInformacion = gananciaDeInformacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vector<String> getValores() {
		return valores;
	}

	public void setValores(Vector<String> valores) {
		this.valores = valores;
	}
	
	public String obtenerValor (int fila){
		return valores.elementAt(fila);
	}

	/**
	 * @return Obtiene Todos los valores posibles que puede tener la columna
	 */
	public Vector<String> obtenerValoresPosibles() {
		Vector<String> valoresPosibles = new Vector<String>();
		for (String valor : valores) {
			if (!valoresPosibles.contains(valor)) {
				valoresPosibles.add(valor);
			}
		}
		return valoresPosibles;
	}

	/**
	 * Devuelve la cantidad de veces que el valorPosible aparece en la columna
	 * 
	 * @param valorPosible
	 * @return
	 */
	public float cantidadOcurrencias(String valorPosible) {
		float cantidadOcurrencias = 0;
		for (String valor : valores) {
			if (valor.equals(valorPosible)) {
				cantidadOcurrencias++;
			}
		}
		return cantidadOcurrencias;
	}

	/**
	 * Devuelve la cantidad de filas que posee la columna
	 * 
	 * @return
	 */
	public float cantidadFilas() {
		float cantidadFilas = (float) valores.size();
		return cantidadFilas;
	}

	/**
	 * Obtiene las filas en la cual aparece el valor ingresado;
	 * 
	 * @param valorPosible
	 */
	public Vector<Integer> obtenerFilasEnColumna(String valorPosible) {
		Vector<Integer> filasEnColumna = new Vector<Integer>();
		for (int i = 0; i < valores.size(); i++) {
			if (valores.elementAt(i).equals(valorPosible)) {
				filasEnColumna.add(i);
			}
		}
		return filasEnColumna;
	}

	/**
	 * Indica la cantidad de veces que aparece esa categoria en las filas
	 * pasadas como parametro
	 * 
	 * @param categoria
	 * @param posicionesEnColumna
	 *            *
	 */
	public float cantidadOcurrenciasDelValorSegunFilas(
			Vector<Integer> filasEnColumna, String categoria) {
		float cantidadOcurrencias = 0;
		for (Integer fila : filasEnColumna) {
			if (valores.elementAt(fila).equals(categoria)) {
				cantidadOcurrencias++;
			}
		}
		return cantidadOcurrencias;
	}

	/**
	 * @param filas
	 * @return Devuelve los valores de de la columna para las filas indicadas,
	 *         si existe un solo valor para todas las filas, se devuelve un
	 *         vector con este unico valor
	 */
	public Vector<String> obtenerValoresPorFilas(Vector<Integer> filas) {
		Vector<String> valoresPorFilas = new Vector<String>();
		boolean existeUnaSolaCategoria = true;
		String valor = null;
		for (Integer fila : filas) {
			valor = valores.elementAt(fila);
			valoresPorFilas.add(valor);
			if (existeUnaSolaCategoria) {
				if (!valor.equals(valoresPorFilas.firstElement())) {
					existeUnaSolaCategoria = false;
				}
			}
		}
		if (existeUnaSolaCategoria) {
			valoresPorFilas = new Vector<String>();
			valoresPorFilas.add(valor);
		}
		return valoresPorFilas;
	}

}
