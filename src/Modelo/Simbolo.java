package Modelo;

public class Simbolo {
	private int valor;
	private String nombre;
	
	public Simbolo(String nombre, int valor) {

		this.setNombre(nombre);
		this.setValor(valor);
	}

	protected void setValor(int valor) {
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "Simbolo [valor=" + valor + ", nombre=" + nombre + "]";
	}

	public int getValor() {
		return valor;
	}
}
