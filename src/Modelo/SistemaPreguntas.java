package Modelo;
import java.util.ArrayList;
import java.util.Random;


public class SistemaPreguntas {
private ArrayList <PreguntaRespuestas> preguntasRespuestas;
private PreguntaRespuestas preguntaActual;

public SistemaPreguntas(){

this.setPreguntasRespuestas(new ArrayList <PreguntaRespuestas>());
this.inicializaPreguntas();


}

/**
 * Inicializa el ArrayList con preguntas y respuestas.
 */
public void inicializaPreguntas(){

PreguntaRespuestas uno = new PreguntaRespuestas("¿De que origen es la compáñia de comunicaciones NOKIA?" ," China ");
uno.agregarRespuestaInvalida("Japon");
uno.agregarRespuestaInvalida("Finlandesa");
uno.agregarRespuestaInvalida("Argentina");
this.getPreguntasRespuestas().add(uno);
PreguntaRespuestas dos = new PreguntaRespuestas("¿Quien invento la radio?","Marconi");
dos.agregarRespuestaInvalida("Edison");
dos.agregarRespuestaInvalida("Einstein");
dos.agregarRespuestaInvalida("Graham Bell");
this.getPreguntasRespuestas().add(dos);
PreguntaRespuestas tres = new PreguntaRespuestas("¿Como se llamo la primer oveja clonada?","Dolly");
tres.agregarRespuestaInvalida("Polly");
tres.agregarRespuestaInvalida("Molly");
tres.agregarRespuestaInvalida("Tolly");
this.getPreguntasRespuestas().add(tres);
PreguntaRespuestas cuatro = new PreguntaRespuestas("¿En que año tuvo su debut cinematografico el raton Mickey?","1928");
cuatro.agregarRespuestaInvalida("1936");
cuatro.agregarRespuestaInvalida("1941");
cuatro.agregarRespuestaInvalida("1945");
this.getPreguntasRespuestas().add(cuatro);
PreguntaRespuestas cinco = new PreguntaRespuestas("¿Que son siroco y simun?" , "Vientos");
cinco.agregarRespuestaInvalida("Rios");
cinco.agregarRespuestaInvalida("Desiertos");
cinco.agregarRespuestaInvalida("Lagos");
this.getPreguntasRespuestas().add(cinco);
PreguntaRespuestas seis = new PreguntaRespuestas("¿Que famosos dibujos animados creo Matt Groening?","Los Simpsons");
seis.agregarRespuestaInvalida("Los pitufos");
seis.agregarRespuestaInvalida("Los picapiedras");
seis.agregarRespuestaInvalida("Pokemon");
this.getPreguntasRespuestas().add(seis);
PreguntaRespuestas siete = new PreguntaRespuestas("¿Que dia se acostumbra a comer ñoquis?","29");
siete.agregarRespuestaInvalida("9");
siete.agregarRespuestaInvalida("19");
siete.agregarRespuestaInvalida("12");
this.getPreguntasRespuestas().add(siete);
PreguntaRespuestas ocho = new PreguntaRespuestas("¿Cual es el pais mas poblado del mundo?","China");
ocho.agregarRespuestaInvalida("Japon");
ocho.agregarRespuestaInvalida("Brasil");
ocho.agregarRespuestaInvalida("Estados Unidos");
this.getPreguntasRespuestas().add(ocho);
PreguntaRespuestas nueve = new PreguntaRespuestas("¿A que disciplina se le decia *el deporte blanco* ?","Tenis");
nueve.agregarRespuestaInvalida("Esgrima");
nueve.agregarRespuestaInvalida("Atletismo");
nueve.agregarRespuestaInvalida("Hockey");
this.getPreguntasRespuestas().add(nueve);
PreguntaRespuestas diez = new PreguntaRespuestas("¿Quien dijo *Pienso,luego existo* ? ","Descartes");
diez.agregarRespuestaInvalida("Socrates");
diez.agregarRespuestaInvalida("Erasmo");
diez.agregarRespuestaInvalida("Platon");
this.getPreguntasRespuestas().add(diez);
this.setPreguntaActual(this.preguntaRapida());

}

/**
 * Verifica si la respuesta de la pregunta actual es valida.

 */
protected boolean esRespuestaValida(String respuestaUsuario) {

return this.getPreguntaActual().esRespuestaValida(respuestaUsuario);
}

private void setPreguntasRespuestas(ArrayList<PreguntaRespuestas> preguntasRespuestas) {
this.preguntasRespuestas= preguntasRespuestas;

}

protected PreguntaRespuestas getPreguntaActual() {
return this.preguntaActual;
}

private void setPreguntaActual(PreguntaRespuestas preguntaActual) {
this.preguntaActual = preguntaActual;
}
private ArrayList<PreguntaRespuestas> getPreguntasRespuestas() {
return this.preguntasRespuestas;
}

/**
 * Devuelve una lista con respuestas mescladas.
 */

public ArrayList<String> respuestasMescladas() {

return this.getPreguntaActual().respuestasMescladas();

}
/**
 * Obtiene una pregunta.
 */
public String obtenerPregunta () {
   this.setPreguntaActual(preguntaRapida());
   return this.getPreguntaActual().getPregunta();
	
}


private PreguntaRespuestas preguntaRapida(){
Random aleatorio = new Random();
int indice;
PreguntaRespuestas unaPreguntaRespuestas = new PreguntaRespuestas(null, null) ;

if (this.getPreguntasRespuestas().size() == 0) {
this.inicializaPreguntas();
}
indice=aleatorio.nextInt((this.getPreguntasRespuestas().size()));
unaPreguntaRespuestas = this.getPreguntasRespuestas().get(indice);
return unaPreguntaRespuestas;

}
}