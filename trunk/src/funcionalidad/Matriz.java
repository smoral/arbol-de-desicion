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
	
}
