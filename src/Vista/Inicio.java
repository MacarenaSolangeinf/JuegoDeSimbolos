package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import Controlador.ControladorDelJuego;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Inicio extends JFrame{

	private SistemaVista svista;
	private Introduccion introduccion1;
	private Autor autor;
	private Ayuda ayuda ;
	private ControladorDelJuego controlador;
	private JTabbedPane JTPJuego;
	
	public Inicio(ControladorDelJuego controlador) {
	    this.setControlador(controlador);
	    initialize();
		this.setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/iconoJuego.png")).getImage());
	}


	private void iniciarJuego () {
	if (this.getJTPJuego().getSelectedIndex() == 1 )
	{	
    this.getControlador().getSistemaJuego().iniciarJuego();
	}
	ControladorDelJuego.jugar();	
	this.dispose();
	}
	
	private void initialize() {
		this.setBounds(100, 100, 1323, 742);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		this.setJTPJuego(new JTabbedPane(JTabbedPane.BOTTOM));
		this.getJTPJuego().setBounds(0, 25, 969, 679);
		this.getContentPane().add(this.getJTPJuego());
		this.setIntroduccion1(new Introduccion());
	
		this.getJTPJuego().addTab("Introduccion",new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/iconoInicio.png")).getImage()),this.getIntroduccion1());				
		this.setSvista(new SistemaVista(this.getControlador()));
		this.getJTPJuego().addTab("Juego",new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/iconoJSimbolos.png")).getImage()),this.getSvista());				
		//this.getJTPJuego().addTab("Autor",new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/iconoJSimbolos.png")).getImage()),this.getSvista());
		//this.getJTPJuego().addTab("Enlaces",null, null ,null);
		this.setAutor(new Autor());
		this.getJTPJuego().addTab("Autores",null, this.getAutor() ,null);
		
		this.setAyuda(new Ayuda(this));
		getContentPane().add(this.getAyuda());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 969, 28);
		getContentPane().add(menuBar);
		
		JMenu juego = new JMenu("Juego");
		juego.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(juego);
		
		JMenuItem nuevoJuego = new JMenuItem("Nuevo Juego");
		nuevoJuego.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		juego.add(nuevoJuego);
		nuevoJuego.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				iniciarJuego();
				
			}
		});
		
		JMenuItem salir = new JMenuItem("Salir");
		salir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		juego.add(salir);
	    
	}

	



	public SistemaVista getSvista() {
		return svista;
	}

	private void setSvista(SistemaVista svista) {
		this.svista = svista;
	}

	private Introduccion getIntroduccion1() {
		return introduccion1;
	}

	private void setIntroduccion1(Introduccion introduccion1) {
		this.introduccion1 = introduccion1;
	}

	protected ControladorDelJuego getControlador() {
		return controlador;
	}

	private void setControlador(ControladorDelJuego controlador) {
		this.controlador = controlador;
	}
	public Ayuda getAyuda() {
		return ayuda;
	}


	private void setAyuda(Ayuda ayuda) {
		this.ayuda = ayuda;
	}


	protected JTabbedPane getJTPJuego() {
		return JTPJuego;
	}


	protected void setJTPJuego(JTabbedPane jTPJuego) {
		JTPJuego = jTPJuego;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}