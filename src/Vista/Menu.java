package Vista;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import Controlador.ControladorDelJuego;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1,1, 1200, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu = new JMenu("Opciones");
		JMenu ayuda = new JMenu("Ayuda");
		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem juego = new JMenuItem("Jugar");
		juego.setIcon(new ImageIcon("C:\\Users\\Universidad\\Documents\\Poo 2014\\JuegoDeSimbolos\\src\\Imagenes\\Jugar.gif"));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}});
		juego.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ControladorDelJuego.jugar();
						frame.dispose();
					}});
					
		menu.add(juego);
		menu.add(salir);
		menuBar.add(menu);
		menuBar.add(ayuda);
		frame.getContentPane().setLayout(null);

		
	}
}
