package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.*;
import Controlador.ControladorDelJuego;
import Modelo.SistemaJuego;

import javax.swing.*;


public class SistemaVista extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPTablero jpTablero ; 
	private ControladorDelJuego controlador;
	private JLabel[] jlSumatoriaCol=new JLabel[SistemaJuego.getDimCol()];
	private JLabel[] jlSumatoriaFila=new JLabel[SistemaJuego.getDimFila()];
	private JPPregunta jppregunta;
	private JPValorSimbolo jpValorSimbolo;
	private JLabel JLVidas ;
 
	
	public SistemaVista(ControladorDelJuego controlador) {
     this.inicializarVista(controlador);

	}
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/Fondo2.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
	}
	
   public void inicializarVista(ControladorDelJuego controlador){
		this.setBackground(Color.CYAN);
        this.setControlador(controlador);
        this.setJPTablero(new JPTablero(this) );
		this.setLayout(null);
		this.setBackground(new Color(0, 255, 255));
		this.setBounds(100, 100, 906, 606);
		this.setLayout(null);
		this.add(this.getJPTablero());
	
        this.JLSumatoriaColumna();
        this.JLSumatoriaFila();
        this.setJppregunta(new JPPregunta(this));
     
        this.add(this.getJppregunta());
        this.getJppregunta().setVisible(false);
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/Logo2.png")));
        lblNewLabel.setBounds(25, 11, 600, 76);
        this.add(lblNewLabel);
    	this.setJpValorSimbolo(new JPValorSimbolo(this));
		this.add(this.getJpValorSimbolo());
		this.getJpValorSimbolo().setVisible(false);
	    JLabel vidas = new JLabel();
        vidas.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/Vidas.png")));
        vidas.setBounds(700, 11, 200,200);;
        this.JLVidas = new JLabel(""+this.getControlador().getSistemaJuego().getVidaActual());
	    JLVidas.setBounds(810, 11, 200,200);
	    this.JLVidas.setFont(new Font("Ballpark", Font.BOLD, 30));
	    this.JLVidas.setForeground(Color.RED);
	    this.add(JLVidas);
	    this.add(vidas);
   }
   
   
	
	
   public void preguntaRapida () {
	 this.getJppregunta().preguntaRapida();
	 this.getJppregunta().setVisible(true);
   }
	
	protected void acertarSimbolo (Icon imagenSimbolo) {
		this.getControlador().getSistemaJuego().setAyudaContextual(this.getControlador().getSistemaJuego().getAyudaAciertos().get(0));
		this.getJppregunta().setVisible(false);
       this.getJpValorSimbolo().getJLSimbolo().setIcon(imagenSimbolo);
		this.getJpValorSimbolo().setVisible(true);

	}
	

	public void JLSumatoriaColumna (){

		   int colInicial = 85; 
		    for (int i=0 ;i<SistemaJuego.getDimCol(); i++){
			this.getJLSumatoriaCol()[i]=new JLabel("" + this.getControlador().getSistemaJuego().sumatoriaColumna(i));
			this.getJLSumatoriaCol()[i].setFont(new Font("Ballpark", Font.PLAIN,30));
			this.getJLSumatoriaCol()[i].setBounds(colInicial + (i*100) , 613, 46, 40);
			this.add(this.getJLSumatoriaCol()[i]);
		    }
		    
		
	}
	private void JLSumatoriaFila () {
	
		   int filInicial = 145; 
			for (int i=0 ;i<SistemaJuego.getDimFila(); i++){
			this.getJlSumatoriaFila()[i]=new JLabel("" + this.getControlador().getSistemaJuego().sumatoriaFila(i));
			this.getJlSumatoriaFila()[i].setFont(new Font("Ballpark", Font.PLAIN,30));
			this.getJlSumatoriaFila()[i].setBounds(575, filInicial + (i*100), 46, 40);
			this.add(this.getJlSumatoriaFila()[i]);
		    }

	}
 public void actualizarSumatorias (int unaFila , int unaCol ,int otraFila,int otraCol) {	
	 this.getJLSumatoriaCol()[unaCol].setText("" + this.getControlador().getSistemaJuego().sumatoriaColumna(unaCol));
	 this.getJLSumatoriaCol()[otraCol].setText("" + this.getControlador().getSistemaJuego().sumatoriaColumna(otraCol));
	 this.getJlSumatoriaFila()[unaFila].setText("" + this.getControlador().getSistemaJuego().sumatoriaFila(unaFila));
	 this.getJlSumatoriaFila()[otraFila].setText("" + this.getControlador().getSistemaJuego().sumatoriaFila(otraFila));
 }
 


	public JPTablero getJPTablero() {
		return jpTablero;
	}
	
	public void setJPTablero(JPTablero jpTablero) {
		this.jpTablero = jpTablero;
	}
	
	
	public JButton [][] getTablero() {
		return this.getJPTablero().getTablero();
	}


	protected ControladorDelJuego getControlador() {
		return controlador;
	}


	public void setControlador(ControladorDelJuego controlador) {
		this.controlador = controlador;
	}
	
	public void intercambiarSimbolos(int unSimboloFila , int unSimboloCol , int otroSimboloFila ,int otroSimboloCol) {
		this.getJPTablero().intercambiarSimbolos(getJPTablero().getTablero()[unSimboloFila][unSimboloCol],
				getJPTablero().getTablero()[otroSimboloFila][otroSimboloCol]);
	
	}
	

	public void colorearEnRojo( int i , int j) {
		this.getJPTablero().colorearEnRojo(i, j);
	}
	
	public void colorearEnAzul( int i , int j) {
		this.getJPTablero().colorearEnAzul(i, j);
	}
	private JLabel[] getJLSumatoriaCol() {
		return this.jlSumatoriaCol;
	}

	private JLabel[] getJlSumatoriaFila() {
		return this.jlSumatoriaFila;
	}

	private JPPregunta getJppregunta() {
		return jppregunta;
	}

	private void setJppregunta(JPPregunta jppregunta) {
		this.jppregunta = jppregunta;
	}



	public JPValorSimbolo getJpValorSimbolo() {
		return jpValorSimbolo;
	}

    public void colorearEnVerde(int i,int j) {
    	this.getJPTablero().colorearEnVerde(i, j);
    }

	private void setJpValorSimbolo(JPValorSimbolo jpValorSimbolo) {
		this.jpValorSimbolo = jpValorSimbolo;
	}

    public JButton obtenerJButton (int x , int y) {
    	return this.getTablero()[x][y];
    }


	public JTextField getJTAcierto() {
		return this.getJpValorSimbolo().getJTAcierto();
	}

	public void haAcertado(){
		JOptionPane.showMessageDialog(null, "¡Muy bien! Has acertado el valor");
		this.getJpValorSimbolo().setVisible(false);
		this.getJPTablero().colorearEnAzul(this.getJPTablero().getPrimerSeleccionado().getY()/100, this.getJPTablero().getPrimerSeleccionado().getX()/100);
		this.getJPTablero().setPrimerSeleccionado(null);
		this.getJPTablero().colocarCaraAcertada();
        this.getControlador().getSistemaJuego().setAyudaContextual(this.getControlador().getSistemaJuego().getAyudaSeleccion().get(0));

	}
	public void noHaAcertado(){
		this.JLVidas.setText(""+this.getControlador().getSistemaJuego().getVidaActual());
		JOptionPane.showMessageDialog(null, "No has acertado el valor");
        this.getControlador().getSistemaJuego().setAyudaContextual(this.getControlador().getSistemaJuego().getAyudaSeleccion().get(0));

	}
	public void respondioCorrectamente(){
		JOptionPane.showMessageDialog(null, "¡Muy bien!Has respondido correctamente ");
		this.getJPTablero().colorearEnAzul(this.getJPTablero().getUltimoSeleccionado().getY()/100,this.getJPTablero().getUltimoSeleccionado().getX()/100);
		this.getJPTablero().colorearEnAzul(this.getJPTablero().getPrimerSeleccionado().getY()/100,this.getJPTablero().getPrimerSeleccionado().getX()/100);
		
		this.getJppregunta().setVisible(false);
		this.getJpValorSimbolo().setVisible(false);
	    this.getControlador().intercambiarSimbolos(this.getJPTablero().getPrimerSeleccionado().getY()/100,this.getJPTablero().getPrimerSeleccionado().getX()/100,
	    		this.getJPTablero().getUltimoSeleccionado().getY()/100,this.getJPTablero().getUltimoSeleccionado().getX()/100);
	    this.actualizarSumatorias(this.getJPTablero().getPrimerSeleccionado().getY()/100,this.getJPTablero().getPrimerSeleccionado().getX()/100
	    		,this.getJPTablero().getUltimoSeleccionado().getY()/100,this.getJPTablero().getUltimoSeleccionado().getX()/100);
	    this.getJPTablero().intercambiarSimbolos(this.getJPTablero().getPrimerSeleccionado(),this.getJPTablero().getUltimoSeleccionado());
	    this.getJPTablero().setPrimerSeleccionado(null);
		this.getJPTablero().setUltimoSeleccionado(null);
		for(Component c: this.getJPTablero().getComponents()) {
			c.setEnabled(true);
			}
		this.getJppregunta().setVisible(false);
		this.getJpValorSimbolo().setVisible(false);
        this.getControlador().getSistemaJuego().setAyudaContextual(this.getControlador().getSistemaJuego().getAyudaSeleccion().get(0));

	}
	public void respondioIncorrectamente(){
		JOptionPane.showMessageDialog(null, "Su respuesta es incorrecta");
		this.JLVidas.setText(""+this.getControlador().getSistemaJuego().getVidaActual());
		this.getJPTablero().colorearEnAzul(this.getJPTablero().getUltimoSeleccionado().getY()/100,this.getJPTablero().getUltimoSeleccionado().getX()/100);
		this.getJPTablero().colorearEnAzul(this.getJPTablero().getPrimerSeleccionado().getY()/100,this.getJPTablero().getPrimerSeleccionado().getX()/100);
		this.getJppregunta().setVisible(false);
		this.getJpValorSimbolo().setVisible(false);
		   this.getJPTablero().setPrimerSeleccionado(null);
			this.getJPTablero().setPrimerSeleccionado(null);
		for(Component c: this.getJPTablero().getComponents()) {
			c.setEnabled(true);
			}
        this.getControlador().getSistemaJuego().setAyudaContextual(this.getControlador().getSistemaJuego().getAyudaSeleccion().get(0));

	}
	public void haGanado(){
		JOptionPane.showMessageDialog(null, "Felicitaciones!!! Has ganado el juego!!!");
		this.getJppregunta().setVisible(false);
		this.getJpValorSimbolo().setVisible(false);
		this.deshabilitarPanel();
	}
	public void haPerdido(){
		this.getJPTablero().colocarCaraPerdiste();
		this.JLVidas.setText(""+this.getControlador().getSistemaJuego().getVidaActual());
		JOptionPane.showMessageDialog(null, "Perdiste puedes intentarlo de nuevo");
		this.getJppregunta().setVisible(false);
		this.getJpValorSimbolo().setVisible(false);
		this.deshabilitarPanel();
	}
	public void haTerminado(){
		JOptionPane.showMessageDialog(null, "El juego terminó, comienze una nueva partida");
		this.deshabilitarPanel();
	}
	

 private void deshabilitarPanel() {
		for(Component c: this.getJPTablero().getComponents()) {
			c.setEnabled(false);
			}
 }
 public void limpiarValores() {
	 this.getJpValorSimbolo().limpiarValores();
 }
	
	
	
}
