package Modelo;
import java.util.ArrayList;
public class Ayuda {
	
	private ArrayList <String> ayudaGral;
	private ArrayList <String> ayudaIntercambios; 
	private ArrayList <String> ayudaAciertos;
	private String ayudaContextual;
	private ArrayList <String> ayudaSeleccion;
	public Ayuda () {
		this.inicializarAyuda();
	}

	/*
	 * Descripcion de los tipos de ayuda
	 */
	private void inicializarAyuda() {

	   this.setAyudaAciertos(new ArrayList<String>());
	   this.setAyudaGral(new ArrayList<String>());
	   this.setAyudaIntercambios(new ArrayList<String>());
	   this.setAyudaSeleccion(new ArrayList<String>());
	   this.getAyudaAciertos().add("Introduce el valor del \n" +
		   		"símbolo que consideres correcto, \n"
				+"teniendo como guía la \n" 
			    +"sumatoria de filas y columnas.\n"+
		   		"Este valor se encuentra \n" +
		   		"en un rango de valores \n" +
		   		"del 0 al 10.");
		   this.getAyudaAciertos().add("/Imagenes/AyudaAciertos.jpg");
		   this.getAyudaGral().add("Cada símbolo del tablero tiene \n" +
		   		"un valor, en cada fila y columna\n" +
		   		"se muestra la sumatoria de estos.\n" +
		   		"Se pueden intercambiar, y se \n" +
		   		"actualizaran los valores de las\n" +
		   		"sumatorias, teniendo como \n" +
		   		"obstaculo una pregunta. \n" + 
		   		"Finalizara la partida\n" +
		   		"actual del juego, cuando se logre\n" +
		   		"descubrir el valor de los 5 \n" +
		   		"símbolos antes de que se \n" +
		   		"terminen las 5 vidas. \n");
		   this.getAyudaGral().add("/Imagenes/AyudaGral.jpg");
		   this.getAyudaIntercambios().add("Debes seleccionar dos símbolos, \n" +
		   		"teniendo en cuenta que en una \n" +
		   		"fila o columna no debe haber \n" +
		   		"más de 3 símbolos iguales.\n" +
		   		"El intercambio se efectuará \n" +
		   		"si respondes correctamente \n" +
		   		"la pregunta que aparecera, \n" +
		   		"de lo contrario perderás una vida.\n");
		   this.getAyudaIntercambios().add("/Imagenes/AyudaIntercambio.jpg");
		   this.getAyudaSeleccion().add("Seleccionaras un símbolo \n" +
		   		"haciendo un click con el \n" +
		   		"mouse sobre el mismo, \n" +
		   		"este se coloreara en verde,\n" +
		   		"y para deseleccionarlo has \n" +
		   		"otro click sobre el mismo.\n");
		   this.getAyudaSeleccion().add("/Imagenes/AyudaSeleccion.jpg");

		}


	protected ArrayList<String> getAyudaGral() {
		return ayudaGral;
	}

	private void setAyudaGral(ArrayList<String> ayudaGral) {
		this.ayudaGral = ayudaGral;
	}

	protected ArrayList<String> getAyudaIntercambios() {
		return ayudaIntercambios;
	}

	private void setAyudaIntercambios(ArrayList<String> ayudaIntercambios) {
		this.ayudaIntercambios = ayudaIntercambios;
	}

	protected ArrayList<String> getAyudaAciertos() {
		return ayudaAciertos;
	}

	private void setAyudaAciertos(ArrayList<String> ayudaAciertos) {
		this.ayudaAciertos = ayudaAciertos;
	}

	protected String getAyudaContextual() {
		return ayudaContextual;
	}

	protected void setAyudaContextual(String ayudaContextual) {
		this.ayudaContextual = ayudaContextual;
	}

	public ArrayList<String> getAyudaSeleccion() {

		return ayudaSeleccion;
	}

	public void setAyudaSeleccion(ArrayList<String> ayudaSeleccion) {
	 this.ayudaSeleccion= ayudaSeleccion;
	}
}
