package Modelo;

public class EstadoEnJuego extends EstadoJuego{
	
	protected void iniciarJuego(SistemaJuego sistemaJuego) {
		
		   sistemaJuego.getSistemaVista().haPerdido();
		
	}


protected void acertar(SistemaJuego sistemaJuego, int valorSimbolo) {
		
		if	(sistemaJuego.getUltimoSeleccionado().getValor()==valorSimbolo){
			
			sistemaJuego.agregarSimboloAcertado(); 
			 sistemaJuego.getSistemaVista().haAcertado();
		}
			else
			{
				sistemaJuego.setVidaActual(sistemaJuego.getVidaActual()-1);
				sistemaJuego.getSistemaVista().noHaAcertado();
			}

		if (sistemaJuego.getSimbolosAcertados().size()==SistemaJuego.getMaxAciertos()-1 || sistemaJuego.getVidaActual()==1){
			
			EstadoPorFinalizar estadoPorFinalizar = new EstadoPorFinalizar();
			sistemaJuego.setEstadoJuego(estadoPorFinalizar);		
		}	
		}
	
/*
 * Controla que la respuesta sea correcta
 */
	public void responderPregunta(SistemaJuego sistemaJuego, String respuesta) {
				
				if (sistemaJuego.getSistemaPreguntas().esRespuestaValida(respuesta)
						){
					sistemaJuego.getSistemaVista().respondioCorrectamente();
				}
				
				else{
					sistemaJuego.setVidaActual(sistemaJuego.getVidaActual()-1);
					sistemaJuego.getSistemaVista().respondioIncorrectamente();
				}
				
				if (sistemaJuego.getSimbolosAcertados().size()==SistemaJuego.getMaxAciertos()-2 || sistemaJuego.getVidaActual()==1){
					
					EstadoPorFinalizar estadoPorFinalizar = new EstadoPorFinalizar();
					sistemaJuego.setEstadoJuego(estadoPorFinalizar);		
				}	
			}
}
