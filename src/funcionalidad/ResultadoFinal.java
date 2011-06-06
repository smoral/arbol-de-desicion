package funcionalidad;

public class ResultadoFinal extends Resultado{
	private String categoria;

	public String obtenerCategoria(Matriz matrizDeDatos) {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ResultadoFinal(String nombreColumna, String valorColumna,
			String categoria) {
		super(nombreColumna, valorColumna);
		this.categoria = categoria;
	}

}
