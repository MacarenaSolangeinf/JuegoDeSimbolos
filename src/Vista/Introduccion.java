package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Introduccion extends JPanel{

	/**
	 * Create the application.
	 */
	public Introduccion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/Fondo.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
	}
	
	
	private void initialize() {
		this.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		this.setBackground(Color.CYAN);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos!");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 99));
		lblNewLabel.setBounds(68, 177, 603, 266);
		this.add(lblNewLabel);
		this.setBounds(100, 100, 985, 657);
	}
}
