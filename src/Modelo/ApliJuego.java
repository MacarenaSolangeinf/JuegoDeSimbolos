package Modelo;

import java.util.Scanner;

public class ApliJuego {
	
	private static Scanner teclado;

	public static void main( String [] args ){
	  SistemaJuego unSistema = new SistemaJuego();
	  teclado = new Scanner (System.in);
	  int filaUno;
	  int colUno;
	  int filDos;
	  int colDos;
	  	  
 /**
  * Pruebo la sumatoria de las filas 
  */
	  System.out.print("Sumatoria de Fila");
	  for (int i=0 ; i<SistemaJuego.getCantSimbolos();i++) {
	   System.out.print( "\n" + "Fila "+ i + ": "+ unSistema.sumatoriaFila(i)+"\n");
	  }

	  /**
	   * pruebo la sumatoria de las columnas 
	   */

	  System.out.print("Sumatoria de columna");
	  for (int i=0 ; i<SistemaJuego.getCantSimbolos();i++) {
		   System.out.print( "\n" + "Columna "+ i + ": "+ unSistema.sumatoriaColumna(i)+"\n");

		  }
	  /**
	   * Imprimo todo el tablero 
	   */

	  unSistema.imprimirTablero();
	  
    for (int i=0;i <=3 ; i++){
	  /**
	   * Intercambio dos simbolos 
	   */
      System.out.println("\n"+"Ingrese fila del primer simbolo:" );
      filaUno= teclado.nextInt();
      System.out.println("\n"+"Ingrese columna del primer simbolo:");
      colUno= teclado.nextInt();
      
      System.out.println("\n"+"Ingrese fila del segundo simbolo:" );
      filDos= teclado.nextInt();
      System.out.println("\n"+"Ingrese columna del segundo simbolo:");
      colDos= teclado.nextInt();
    	
	 if ( unSistema.esValidoIntercambio( filaUno, colUno, filDos, colDos)){
	  /**
	   * Imprimo nuevamente el tablero
	   */
	  System.out.println("  ");
	  unSistema.intercambiarSimbolos(filaUno, colUno, filDos, colDos);
	  System.out.println("Intercambio correcto");
	  unSistema.imprimirTablero();
	 }
	 else
	 {
		 System.out.println("No se puede intercambiar");
	 }
    } 
	}
}
