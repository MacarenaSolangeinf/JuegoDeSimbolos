package Modelo;
import java.util.Random;


public class Tablero {
	private SistemaJuego sistJuego;
	private Simbolo[][] grilla = new Simbolo[SistemaJuego.getDimFila()][SistemaJuego.getDimCol()] ;
    
/**
 *  //Constructor por defecto
 */
	
	protected Tablero(SistemaJuego sistemajuego ) {
		this.setSistJuego(sistemajuego);
		this.incializarTablero();
	}
	
	/**
	   Metodos que sabe responder
	 */

	protected Simbolo obtenerSimbolo(int fila,int col ) {
		return this.getGrilla()[fila][col];
	}
	
	protected int sumatoriaFila (int fila) {
		int sumatoria=0;
		for (int i=0;i<SistemaJuego.getDimCol(); i++){
		  sumatoria = sumatoria + this.obtenerSimbolo(fila,i).getValor();
		}
		return sumatoria;
	}
	
	protected int sumatoriaColumna (int col) {
		int sumatoria=0;
		for (int i=0;i<SistemaJuego.getDimFila(); i++){
		  sumatoria = sumatoria + this.obtenerSimbolo(i,col).getValor();
		}
		return sumatoria;
	}
	
	protected void imprimirTablero() {
		for (int i=0; i<SistemaJuego.getDimFila() ; i++) {
			System.out.println(" ");
			for (int j=0 ; j<SistemaJuego.getDimCol() ; j++) {

		    System.out.print(this.getGrilla()[i][j].toString());

			} 
		}
	}
	
	
	protected boolean esValidoIntercambio(int unSimboloFila ,int unSimboloCol ,int otroSimboloFila ,int otroSimboloCol ) {
		this.intercambiarSimbolos(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol);
	     boolean valido=false;
	     
		if (this.esSimboloValidoEnColumna(this.getGrilla()[unSimboloFila][unSimboloCol],unSimboloCol)&&
				this.esSimboloValidoEnFila(this.getGrilla()[unSimboloFila][unSimboloCol],unSimboloFila)
				&& this.esSimboloValidoEnColumna(this.getGrilla()[otroSimboloFila][otroSimboloCol],otroSimboloCol)
				&& this.esSimboloValidoEnFila(this.getGrilla()[otroSimboloFila][otroSimboloCol],otroSimboloFila) )
			{
			 valido=true;
	}      
		this.intercambiarSimbolos(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol);
		
		return valido;
	}

	/*
	 * Realiza el intercambio de los simbolos cuando es requerido
	 */
	protected void intercambiarSimbolos(int unSimboloFila ,int unSimboloCol ,int otroSimboloFila ,int otroSimboloCol ) {	   	
		Simbolo simboloAux;
        simboloAux = this.getGrilla()[unSimboloFila][unSimboloCol];    
        this.getGrilla()[unSimboloFila][unSimboloCol] = this.getGrilla()[otroSimboloFila][otroSimboloCol];
        this.getGrilla()[otroSimboloFila][otroSimboloCol]= simboloAux;
		
	}


	/**
	 * Metodos privados
	 */
	
	private void colocarUltimoSimboloAlAzar(){
	   Random filaAleatoria = new Random();
	   Random columnaAleatoria = new Random();
	   for (int i =0 ; i<2; i++)
	   {
		this.getGrilla()[filaAleatoria.nextInt(SistemaJuego.getDimFila())][columnaAleatoria.nextInt(SistemaJuego.getDimCol())]
		                                                                   = this.sistJuego.getSimbolos()[SistemaJuego.getCantSimbolos()-1];
		  System.out.println("inserto cruz al azar");
	   }
	   
	}
	
	private void incializarTablero() {
		this.incializarGrilla();
	   if (!(this.corregirGrilla())) {
		  System.out.println("cruz al azar");
          colocarUltimoSimboloAlAzar();
	   }
		
	}

	private void incializarGrilla () {
		Random aleatorio = new Random();
		for (int i=0 ; i<SistemaJuego.getDimFila(); i++){
			for (int j=0 ;j <SistemaJuego.getDimCol() ;j++)
			{
			  getGrilla()[i][j] =  (sistJuego.getSimbolos() [aleatorio.nextInt(SistemaJuego.getCantSimbolos()-1)]);
			}
		}
	}
	
	/*
	 * Verifica que el simbolo no se repita mas de 3 veces en la fila o la columna
	 */
	private boolean esSimboloValidoEnFila ( Simbolo unSimbolo ,int fila ) {
		int cantSimbolo =0;
		boolean valido;
		valido=true;
		for (int j=0;j< SistemaJuego.getDimCol(); j++){	
	      if (unSimbolo.equals(this.getGrilla()[fila][j])) {
	    	  cantSimbolo++;
	      }
		}
		if (cantSimbolo>SistemaJuego.getMaxSimbolo()){
			System.out.print("no es valido el simbolo en fila " + cantSimbolo+ " "+ unSimbolo.getNombre());
			valido=false;
		}
   return valido; 
	}
	
	
	private boolean esSimboloValidoEnColumna ( Simbolo unSimbolo ,int columna ) {
		int cantSimbolo =0;
		boolean valido=true;
		
		for (int i=0;i< SistemaJuego.getDimFila(); i++){	
			
	      if (unSimbolo.equals(this.getGrilla()[i][columna])) {
	    	  cantSimbolo++;
	      }
		}
		if (cantSimbolo>SistemaJuego.getMaxSimbolo()){
			System.out.println("no es valido el simbolo en columna " + cantSimbolo + " "+ unSimbolo.getNombre());
			valido=false;
		}
   return valido; 
	}

	private boolean corregirGrilla() {
	 boolean corrigio = false;	
      for (int i=0 ;i < SistemaJuego.getDimFila();i++)
      {
    	  for (int j=0; j < SistemaJuego.getDimCol();j++)
    	  {
    		if(!(this.esSimboloValidoEnColumna(this.getGrilla()[i][j],j)) || 
    				!(this.esSimboloValidoEnFila(this.getGrilla()[i][j],i)))
    		{
    	      System.out.println("Remplaza por Cruz");
    		  this.getGrilla()[i][j] = this.sistJuego.getSimbolos()[SistemaJuego.getCantSimbolos()-1];
    		  corrigio=true;
    		}
    		
    	  }
      }
      return corrigio;
	}
	
	/**
	 * Metodos getters y Setters
	 */
	protected Simbolo[][] getGrilla() {
		return grilla;
	}
	

	private void setSistJuego(SistemaJuego sistJuego) {
		this.sistJuego = sistJuego;
	}
	
}
