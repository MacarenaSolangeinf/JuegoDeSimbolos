package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

public class ControladorPreguntas implements ActionListener {
    private ControladorDelJuego delegate; 
	
	public ControladorPreguntas (ControladorDelJuego delegate) {
		this.setDelegate(delegate);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() instanceof JCheckBox) {
			if (((JCheckBox)evento.getSource()).isSelected()) {
				((JCheckBox)evento.getSource()).doClick();
				this.getDelegate().getSistemaJuego().responderPregunta(((JCheckBox)evento.getSource()).getText());
			}

		}

	}
	
	private ControladorDelJuego getDelegate() {
		return delegate;
	}
	
	private void setDelegate(ControladorDelJuego delegate) {
		this.delegate = delegate;
	}
}
