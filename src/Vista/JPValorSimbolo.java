package Vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.Color;

public class JPValorSimbolo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel JLSimbolo;
	private JTextField JTacierto;
    private SistemaVista delegate; 

	public JPValorSimbolo(SistemaVista delegate) {
		this.setBackground(new Color(70, 130, 180));
		this.setDelegate(delegate);
		inicializarPanelValorSimbolo();
		
	}
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/FondoValor.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializarPanelValorSimbolo() {
		this.setBounds(650, 200, 230, 309);
	
		this.setLayout(null);
		this.setJLSimbolo( new JLabel());
		this.getJLSimbolo().setBounds(43, 11, 131, 142);
		this.add(this.getJLSimbolo());
		
		JLabel lblculEsSu = new JLabel("\u00BFCu\u00E1l es su valor?");
		lblculEsSu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblculEsSu.setBounds(56, 186, 164, 14);
		this.add(lblculEsSu);
		
		this.setJTAcierto(new JTextField());
		this.getJTAcierto().setBounds(73, 211, 86, 20);
		this.add(this.getJTAcierto());
		this.getJTAcierto().setColumns(10);
		this.getJTAcierto().addKeyListener(new KeyAdapter() {
			public void keyTyped (KeyEvent evento) {
				if (!Character.isDigit(evento.getKeyChar())) {
					evento.consume();
				}
			}
		});
		
		JButton btnNewButton = new JButton("Acertar");
		btnNewButton.setBounds(73, 242, 89, 23);
		btnNewButton.addActionListener(this.getDelegate().getControlador().getControladorValores());
		this.add(btnNewButton);
	}

	protected JLabel getJLSimbolo() {
		return JLSimbolo;
	}

	private void setJLSimbolo(JLabel jLSimbolo) {
		JLSimbolo = jLSimbolo;
	}

	protected JTextField getJTAcierto() {
		return JTacierto;
	}

	private void setJTAcierto(JTextField JTacierto) {
		this.JTacierto = JTacierto;
	}

	private SistemaVista getDelegate() {
		return delegate;
	}

	private void setDelegate(SistemaVista delegate) {
		this.delegate = delegate;
	}
	protected void limpiarValores() {
		this.getJTAcierto().setText(null);
	}
	
	
	
}

