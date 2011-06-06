package funcionalidad;

public abstract class Resultado {
	private String nombreColumna;
	private String valorColumna;
	
	public String getNombreColumna() {
		return nombreColumna;
	}
	
	public Resultado(String nombreColumna, String valorColumna) {
		super();
		this.nombreColumna = nombreColumna;
		this.valorColumna = valorColumna;
	}

	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	
	public String getValorColumna() {
		return valorColumna;
	}
	
	public void setValorColumna(String valorColumna) {
		this.valorColumna = valorColumna;
	}
	
	/**
	 * @param matrizDeDatos
	 * @return Devuleve La categoria para los datos ingresados 
	 */
	public abstract String obtenerCategoria(Matriz matrizDeDatos);
	
}

