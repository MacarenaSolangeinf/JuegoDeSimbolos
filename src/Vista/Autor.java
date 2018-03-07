
package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
@SuppressWarnings("serial")

public class Autor extends JPanel {
	
	public Autor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/Fondo.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
		ImageIcon fondo1= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/proyesimbolos.png")).getImage());
	g.drawImage(fondo1.getImage(), 1,1, tamaño.width,tamaño.height,this);
	}
	
	

	private void initialize() {
//	
	
	}

	

}

