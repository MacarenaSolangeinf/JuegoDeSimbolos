package Modelo;
import java.util.*;

import Vista.SistemaVista;
public class SistemaJuego {
	private static final int DIM_FILA =5;
	private static final int DIM_COL = 5;
	private static final int MAX_SIMBOLO = 3;
	private static final int SEMILLA = 11;
    private static final int CANT_SIMBOLOS = 5;  
    private SistemaPreguntas sistemaPreguntas;
	private Simbolo[] simbolos =  new Simbolo[CANT_SIMBOLOS];
	private int numeroIntentos;
	private Tablero tablero;
	private SistemaVista sistemaVista; 
	private EstadoJuego estadoJuego;
	private Simbolo ultimoSeleccionado;
	private static final int MAX_ACIERTOS=5;
	private static final int MAX_VIDAS=5;
	private int vidaActual;
    private ArrayList<Simbolo> simbolosAcertados;
    private Ayuda ayuda;
	
	/**
	 * Metodo constructor por defecto
	 */
	
	
	public SistemaJuego () {
		
		   this.setVidaActual(SistemaJuego.getVidas());
		   this.setSimbolosAcertados(new ArrayList<Simbolo>());
		   this.setAyuda(new Ayuda());
		   this.setEstadoJuego(new EstadoEnJuego());
		   this.generarSimbolos();
		   this.setTablero(new Tablero(this));
		   this.setNumeroIntentos(0);
		   this.setSistemaPreguntas(new SistemaPreguntas());
		   this.setAyudaContextual(this.getAyudaGral().get(0));
	   }
	
	
	/**
	 *  controla el mensaje juego perdido cuando se quiere volvera iniciar el juego
	 */
	public void iniciarJuego (){
		this.getEstadoJuego().iniciarJuego(this);
		
	}

	 /**
	  *  Dadas una fila y una columna obtiene el simbolo para el controlador.
	  */
	public Simbolo obtenerSimbolo(int fila , int col ) {
	    return this.getTablero().getGrilla()[fila][col];
	}
	

/**
 * Muestra el tablero en pantalla , es utilizado para la clase de prueba.
 */
public void imprimirTablero(){
	this.getTablero().imprimirTablero();
}



/**
 * Dada una fila calcula la sumatoria y la devuelve en un entero.
 */
public int sumatoriaFila(int fila) {
	return this.getTablero().sumatoriaFila(fila);
}
/**
 Dada una columna calcula la sumatoria y la devuelve en un entero.
 */
public int sumatoriaColumna(int col) {
	return this.getTablero().sumatoriaColumna(col);
}
/**
 * Verifica si es valido el intercambio o no .
 */

public boolean esValidoIntercambio(int unSimboloFila ,int unSimboloCol ,int otroSimboloFila ,int otroSimboloCol){
	return this.getTablero().esValidoIntercambio(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol);
}
/**
 * Realiza el intercambio de los simbolos cuando es requerido
 */
public void intercambiarSimbolos(int unSimboloFila ,int unSimboloCol ,int otroSimboloFila ,int otroSimboloCol ) {
	this.tablero.intercambiarSimbolos(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol);
}



/**
 * Metodos getters y setters
 */


   public Tablero getTablero() {
		return tablero;
	}

	protected void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	 protected static int getCantSimbolos() {
		return CANT_SIMBOLOS;
	}

	protected Simbolo[] getSimbolos() {
		return simbolos;
	}

	public static int getDimCol() {
		return DIM_COL;
	}

	public static int getDimFila() {
		return DIM_FILA;
	}

	public static int getMaxSimbolo() {
		return MAX_SIMBOLO;
	}

	public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

	public int getNumeroIntentos() {
		return numeroIntentos;
	}
	

	
	/**
	 * Metodos privados
	 */
	private void generarSimbolos() {
		Random aleatorio = new Random();
		    this.getSimbolos()[0] = new Simbolo ("Estrella" , aleatorio.nextInt(SEMILLA));
		    this.getSimbolos()[1] = new Simbolo ("Cuadrado" , aleatorio.nextInt(SEMILLA));
		    this.getSimbolos()[2] = new Simbolo ("Circulo" , aleatorio.nextInt(SEMILLA));
		    this.getSimbolos()[3] = new Simbolo ("Pentagono" , aleatorio.nextInt(SEMILLA));
		    this.getSimbolos()[4] = new Simbolo ("Cruz" , aleatorio.nextInt(SEMILLA));
		 }


	public void setSistemaPreguntas(SistemaPreguntas sistemaPreguntas) {
		this.sistemaPreguntas = sistemaPreguntas;
	}

   
	public SistemaPreguntas getSistemaPreguntas() {
		return sistemaPreguntas;
	}


/**
 * Se establece la seleccion del ultimo simbolo seleccionado.
 */

public void establecerSeleccion(int x ,int y){
		
		this.setUltimoSeleccionado(this.getTablero().obtenerSimbolo(x, y));
		
	}
/**
 * Agrega a una lista los simbolos que ya se han acertado.
 */
public void agregarSimboloAcertado(){
	
	//un simbolo lo agrego a la lista;
this.getSimbolosAcertados().add(this.getUltimoSeleccionado());
	
	
}
/**
 * Verifica si ese simbolo ya ha sido acertado o no.
 */

public boolean yaAcertado(int x,int y){
	
	return this.getSimbolosAcertados().contains(this.getTablero().getGrilla()[x][y]);
	
}
/**
 * Controla si la respuesta de la pregunta es correcta o no, le pide colaboracion a su estado.
 */
public void responderPregunta(String respuesta){
	
	this.getEstadoJuego().responderPregunta(this, respuesta);
	
	
}

/**
 * Controla si el valor del simbolo es acertado o no, le pide colaboracion a su estado.
 */
public void acertar(int valorSimbolo){
	
	this.getEstadoJuego().acertar(this,valorSimbolo);
}

	protected ArrayList<Simbolo> getSimbolosAcertados() {
	return simbolosAcertados;
}


protected void setSimbolosAcertados(ArrayList<Simbolo> simbolosAcertados) {
	this.simbolosAcertados = simbolosAcertados;
}

	protected SistemaVista getSistemaVista() {
		return sistemaVista;
	}

	public void setSistemaVista(SistemaVista sistemaVista) {
		this.sistemaVista = sistemaVista;
	}

	protected EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}


	protected void setEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}


	protected Simbolo getUltimoSeleccionado() {
		return ultimoSeleccionado;
	}


	protected void setUltimoSeleccionado(Simbolo ultimoSeleccionado) {
		this.ultimoSeleccionado = ultimoSeleccionado;
	}


	protected void setSimbolos(Simbolo[] simbolos) {
		this.simbolos = simbolos;
	}


	public int getVidaActual() {
		return vidaActual;
	}


	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	 
	public ArrayList<String> getAyudaGral() {
		return this.getAyuda().getAyudaGral();
	}

	public ArrayList<String> getAyudaIntercambios() {
		return this.getAyuda().getAyudaIntercambios();
	}
	
	public ArrayList<String> getAyudaAciertos() {
		return this.getAyuda().getAyudaAciertos();
	}
	
	private Ayuda getAyuda() {
		return ayuda;
	}

	private void setAyuda(Ayuda ayuda) {
		this.ayuda = ayuda;
	}
	public String getAyudaContextual() {
		return this.getAyuda().getAyudaContextual();
	}

	public void setAyudaContextual(String ayudaContextual) {
		this.getAyuda().setAyudaContextual(ayudaContextual);
	}


	protected static int getSemilla() {
		return SEMILLA;
	}


	protected static int getMaxAciertos() {
		return MAX_ACIERTOS;
	}


	protected static int getVidas() {
		return MAX_VIDAS;
	}
    
    
	public ArrayList<String> getAyudaSeleccion() {
		return this.getAyuda().getAyudaSeleccion();
	}
	
	public void setAyudaSeleccion (ArrayList<String> ayudaSeleccion) {
		this.getAyuda().setAyudaSeleccion(ayudaSeleccion);
	}	
}

	