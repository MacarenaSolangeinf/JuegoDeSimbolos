package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorValores implements ActionListener {
    private ControladorDelJuego delegate; 
    
	
    public ControladorValores (ControladorDelJuego controladorDelJuego ) {
    	this.setDelegate(controladorDelJuego);
    }
    
	public void actionPerformed(ActionEvent evento) {
     if (evento.getSource() instanceof JButton )	{	
	 getDelegate().getSistemaJuego().acertar(Integer.parseInt(this.getDelegate().getSistemaVista().getJTAcierto().getText()));
	 getDelegate().getSistemaVista().limpiarValores();
     }
	}

	private ControladorDelJuego getDelegate() {
		return delegate;
	}

	private void setDelegate(ControladorDelJuego delegate) {
		this.delegate = delegate;
	}	
}
