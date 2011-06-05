package funcionalidad;

import java.util.Vector;

public class Arbol extends Resultado {
	private Matriz matriz;
	private Columna columnaMayorGanancia;
	private Vector<Resultado> resultados;

	public String obtenerCategoria(Matriz matrizDeDatos) {
		if (resultados == null) {
			procesarResultados();
		}
		// TODO Hay que devolver la categoria (CANOTTO90)
		/*
		 * sabiendo cual es la columna con mayor ganacia, se busca en la matriz
		 * de datos el valorque esta columna tiene y a partir de este valor se
		 * busca cual es su categoria en el vectorresultados (encontrando el
		 * Resultado con ese valor y aplicando el metodo obtenerCategoria a ese
		 * Resultado
		 */

		return null;
	}

	private void procesarResultados() {
		resultados = matriz.obtenerResultados();
	}

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

}
