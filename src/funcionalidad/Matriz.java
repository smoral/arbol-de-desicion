package funcionalidad;

import java.util.Vector;

public class Matriz {
	private Vector<Columna> columnas;
	private Columna	categorias;
	
	public void agregarColumna(Columna col){
		columnas.add(col);
	}
	
	public void agregarColumnaCategoria(Columna categorias) {
		this.categorias = categorias;
	}
	
	/**
	 * @param columnaPatron	Es la columna en la cual se buscara el valorPatron
	 * @param valorPatron	Es el valor por el cual se obtendran los valores de las otras columnas
	 * @return
	 */
	public Matriz obtenerSubMatriz(Columna columnaPatron, String valorPatron){
		return null;
	}	
	
}
