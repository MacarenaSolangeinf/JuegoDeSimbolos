package Controlador;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.*;
import Vista.*;
import Modelo.SistemaJuego;

public class ControladorDelJuego {
	
private Vista.SistemaVista sistemaVista ;
private SistemaJuego sistemaJuego;
private ControladorPreguntas controladorPreguntas;
private ControladorValores  controladorValores;
private Inicio inicio;

public static void main(String []args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			ControladorDelJuego controladorDelJuego = new ControladorDelJuego();
			controladorDelJuego.getInicio().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}

public static void jugar() {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ControladorDelJuego controladorDelJuego = new ControladorDelJuego();
				controladorDelJuego.getInicio().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public ControladorDelJuego () {
	 this.setSistemaJuego(new SistemaJuego());
	  this.setControladorPreguntas(new ControladorPreguntas(this));
	  this.setControladorValores(new ControladorValores(this));
	  this.setInicio(new Inicio (this));
	  this.setSistemaVista(this.getInicio().getSvista());
      this.getSistemaJuego().setSistemaVista(this.getSistemaVista());
}

protected Vista.SistemaVista getSistemaVista() {
	return sistemaVista;
}

public void setSistemaVista(Vista.SistemaVista sistemaVista) {
	this.sistemaVista = sistemaVista;
}

public SistemaJuego getSistemaJuego() {
	return sistemaJuego;
}

public void setSistemaJuego(SistemaJuego sistemaJuego) {
	this.sistemaJuego = sistemaJuego;
} 	

public void intercambiar (final int unSimboloFila , final int unSimboloCol , final int otroSimboloFila ,final int otroSimboloCol) {
	if (!(this.getSistemaJuego().esValidoIntercambio(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol)))
	{
	    this.getSistemaVista().colorearEnRojo(unSimboloFila, unSimboloCol);
	    this.getSistemaVista().colorearEnRojo(otroSimboloFila, otroSimboloCol);
	    this.getSistemaVista().obtenerJButton(unSimboloFila, unSimboloCol).addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub		
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			public void mouseExited(MouseEvent evento) {
			
				getSistemaVista().colorearEnAzul(unSimboloFila, unSimboloCol);
				getSistemaVista().colorearEnAzul(otroSimboloFila, otroSimboloCol);
			}
			
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
});
	    
 this.getSistemaVista().obtenerJButton(otroSimboloFila, otroSimboloCol).addMouseListener(new MouseListener() {
			
		
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			public void mouseExited(MouseEvent arg0) {
				getSistemaVista().colorearEnAzul(unSimboloFila, unSimboloCol);
				getSistemaVista().colorearEnAzul(otroSimboloFila, otroSimboloCol);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		
			public void mouseClicked(MouseEvent arg0) {				
			}
});
	    
	}
	else 
	{   
		for(Component c: this.getSistemaVista().getJPTablero().getComponents()) {
			c.setEnabled(false);
			}
		
	this.getSistemaVista().getJpValorSimbolo().setVisible(false);
	this.getSistemaVista().preguntaRapida();
	}	
}

public void intercambiarSimbolos (int unSimboloFila, int unSimboloCol, int otroSimboloFila,int otroSimboloCol) {
this.getSistemaJuego().intercambiarSimbolos(unSimboloFila, unSimboloCol, otroSimboloFila, otroSimboloCol);
}
public ControladorPreguntas getControladorPreguntas() {
	return controladorPreguntas;
}
public void setControladorPreguntas(ControladorPreguntas controladorPreguntas) {
	this.controladorPreguntas = controladorPreguntas;
}
public ControladorValores getControladorValores() {
	return controladorValores;
}
private void setControladorValores(ControladorValores controladorValores) {
	this.controladorValores = controladorValores;
}
protected Inicio getInicio() {
	return inicio;
}
public void setInicio(Inicio inicio) {
	this.inicio = inicio;
}
}
