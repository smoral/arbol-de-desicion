package funcionalidad;

import java.util.Vector;

public class Arbol extends Resultado {
	private Matriz matriz;
	private Vector<Resultado> resultados;
	
	public Arbol(String nombreColumna, String valorColumna, Matriz matriz) {
		super(nombreColumna, valorColumna);
		this.matriz = matriz;
	}

	public Arbol(Matriz matriz) {
		super();
		this.matriz = matriz;
	}

	public String obtenerCategoria(Matriz matrizDeDatos) {
		if (resultados == null) {
			procesarResultados();
		}
		/*
		 * obteniendo la columna con mayor ganacia de la matriz del arbol, se busca en la matriz
		 * de datos el valor que esta columna tiene y a partir de este valor se
		 * busca cual es su categoria en el vectorresultados (encontrando el
		 * Resultado con ese valor y aplicando el metodo obtenerCategoria a ese
		 * Resultado
		 */
		String valorColumnaMayorGanancia = matrizDeDatos.obtenerColumna(matriz.getColumnaMayorGanancia().getNombre()).obtenerValor(0);
		for (Resultado resultado : resultados) {
			if (resultado.getValorColumna().equals(valorColumnaMayorGanancia)){
				return resultado.obtenerCategoria(matrizDeDatos);
			} 
		}
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
