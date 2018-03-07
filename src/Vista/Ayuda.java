package Vista;


import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Ayuda extends JPanel{
 
	private static final long serialVersionUID = 1L;
	
    private JTextArea textoAyuda;
    private JButton ayudaGeneral;
    private JButton ayudaAciertos;
    private JButton ayudaIntercambios;
    private JButton ayudaContextual;
    private JButton ayudaSeleccion;
    private JLabel imagenAyuda;
    private Inicio delegate;
    private JScrollPane scrollPane;


	public Ayuda(Inicio delegate) {
		this.setDelegate(delegate);
		initialize();
	}
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/Fondoa.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 * 
	 * 
	 */
	private void initialize() {
		

		this.setBounds(990,0, 373, 1000);
		this.setLayout(null);
	
		this.setAyudaGeneral(new JButton());
	//	this.getAyudaGeneral().setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getAyudaGeneral().setBounds(10, 512, 353, 37);
		this.getAyudaGeneral().setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/BotonAyudaGeneral.jpg")));
		//JLAyudaGral.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getAyudaGeneral().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            getTextoAyuda().setText(getDelegate().getControlador().getSistemaJuego().getAyudaGral().get(0));
            getImagenAyuda().setIcon(new ImageIcon(getClass().getResource(getDelegate().getControlador().getSistemaJuego().getAyudaGral().get(1))));

			}
		});
		this.add(this.getAyudaGeneral());
		
		this.setAyudaAciertos(new JButton("Ayuda Aciertos"));
		this.getAyudaAciertos().setBackground(Color.LIGHT_GRAY);
		this.getAyudaAciertos().setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getAyudaAciertos().setBounds(10, 602, 353, 37);
		this.getAyudaAciertos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            getTextoAyuda().setText(getDelegate().getControlador().getSistemaJuego().getAyudaAciertos().get(0));
            getImagenAyuda().setIcon(new ImageIcon(getClass().getResource(getDelegate().getControlador().getSistemaJuego().getAyudaAciertos().get(1))));

			}
		});
		this.add(this.getAyudaAciertos());
		
		this.setAyudaIntercambios(new JButton("Ayuda Intercambios"));

		this.getAyudaIntercambios().setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getAyudaIntercambios().setBounds(10, 558, 353, 37);
		this.getAyudaIntercambios().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            getTextoAyuda().setText(getDelegate().getControlador().getSistemaJuego().getAyudaIntercambios().get(0));
            getImagenAyuda().setIcon(new ImageIcon(getClass().getResource(getDelegate().getControlador().getSistemaJuego().getAyudaIntercambios().get(1))));
			}
		});
		this.add(this.getAyudaIntercambios());
		
		
		this.setAyudaSeleccion(new JButton("Ayuda Selección"));
		this.getAyudaSeleccion().setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getAyudaSeleccion().setBounds(10, 647, 353, 37);
		this.getAyudaSeleccion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            getTextoAyuda().setText(getDelegate().getControlador().getSistemaJuego().getAyudaSeleccion().get(0));
            getImagenAyuda().setIcon(new ImageIcon(getClass().getResource(getDelegate().getControlador().getSistemaJuego().getAyudaSeleccion().get(1))));

			}
		});
		this.add(this.getAyudaSeleccion());

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 237, 327, 264);
		this.add(scrollPane);
		
		this.setTextoAyuda(new JTextArea());
		this.getTextoAyuda().setFont(new Font("Tahoma", Font.BOLD, 18));
		this.getTextoAyuda().setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Ayuda");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 37));
		lblNewLabel.setBounds(136, 11, 119, 49);
		this.add(lblNewLabel);
		
		this.setImagenAyuda(new JLabel());
		this.getImagenAyuda().setBounds(64, 56, 238, 170);
		this.add(this.getImagenAyuda());
		
		this.setAyudaContextual(new JButton());
		this.getAyudaContextual().setBounds(0, 0, 60, 60);
		this.add(this.getAyudaContextual());
	}


	public JTextArea getTextoAyuda() {
		return textoAyuda;
	}

	private void setTextoAyuda(JTextArea textoAyuda) {
		this.textoAyuda = textoAyuda;
		textoAyuda.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(textoAyuda);
	}



	private JButton getAyudaGeneral() {
		return ayudaGeneral;
	}

	private void setAyudaGeneral(JButton ayudaGeneral) {
		this.ayudaGeneral = ayudaGeneral;
	}

	private JButton getAyudaAciertos() {
		return ayudaAciertos;
	}

	private void setAyudaAciertos(JButton ayudaAciertos) {
		this.ayudaAciertos = ayudaAciertos;
		ayudaAciertos.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/BotonAyudaAciertos.jpg")));
	}

	private JButton getAyudaIntercambios() {
		return ayudaIntercambios;
	}

	private void setAyudaIntercambios(JButton ayudaIntercambios) {
		this.ayudaIntercambios = ayudaIntercambios;
		ayudaIntercambios.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/BotonAyudaIntercambios.jpg")));
	}

	private JButton getAyudaContextual() {
		return ayudaContextual;
	}

	private void setAyudaContextual(JButton ayudaContextual) {
		this.ayudaContextual = ayudaContextual;
		ayudaContextual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        getTextoAyuda().setText(getDelegate().getControlador().getSistemaJuego().getAyudaContextual());	
	        getImagenAyuda().setIcon(null);

			}
		});
		ayudaContextual.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/Ayuda.png")));
	}

	public JLabel getImagenAyuda() {
		return imagenAyuda;
	}

	private void setImagenAyuda(JLabel imagenAyuda) {
		this.imagenAyuda = imagenAyuda;
	}

	private Inicio getDelegate() {
		return delegate;
	}

	private void setDelegate(Inicio delegate) {
		this.delegate = delegate;
	}

	private JButton getAyudaSeleccion() {
		return ayudaSeleccion;
	}

	private void setAyudaSeleccion(JButton ayudaSeleccion) {
		this.ayudaSeleccion = ayudaSeleccion;
		ayudaSeleccion.setIcon(new ImageIcon(Ayuda.class.getResource("/Imagenes/BotonAyudaSeleccion.jpg")));
	}	
}
