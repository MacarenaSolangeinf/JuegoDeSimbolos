package Modelo;
import java.util.ArrayList;
import java.util.Random;

public class PreguntaRespuestas {
	
	private String pregunta; 
	private ArrayList <String> respuestasInvalidas;
	private String respuestaValida ; 
	
/*
 * Metodo constructor
 */
	
protected PreguntaRespuestas (String pregunta ,String respuestaValida) {
		this.setPregunta(pregunta);
		this.setRespuestaValida(respuestaValida);
		this.setRespuestasInvalidas(new ArrayList<String>());
	}
	
	
	/*
	 * Metodos que sabe responder
	 */
	
	protected ArrayList<String> respuestasMescladas() {	
     Random aleatorio = new Random();
	 ArrayList<String> respuestas=copiarRespuestasInvalidas(); 
	 respuestas.set(aleatorio.nextInt(respuestas.size()),this.getRespuestaValida());
	 return respuestas; 
       }

	
    protected boolean esRespuestaValida(String respuestaUsuario) {
    	return this.getRespuestaValida().equals(respuestaUsuario); 
    }
    
    protected void agregarRespuestaInvalida (String respuesta) {
         this.getRespuestasInvalidas().add(respuesta);
    }
    
    
    /*
     * Metodos privados
     */
	
    private ArrayList<String> copiarRespuestasInvalidas() {
    	 ArrayList <String> respuestas = new ArrayList<String>();
         for (String respuesta : this.getRespuestasInvalidas()) {
      	  respuestas.add(respuesta);
         }
         return respuestas;
    }
	
    
   /*
    * Metodos getters y setters
    */
    
    protected String getPregunta() {
		return pregunta;
	}

	private void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	protected ArrayList<String> getRespuestasInvalidas() {
		return respuestasInvalidas;
	}
	
	protected String getRespuestaValida() {
		return respuestaValida;
	}

	private void setRespuestaValida(String respuestaValida) {
		this.respuestaValida = respuestaValida;
	}
	
	private void setRespuestasInvalidas(ArrayList<String> respuestasInvalidas) {
		this.respuestasInvalidas = respuestasInvalidas;
	}    
}
