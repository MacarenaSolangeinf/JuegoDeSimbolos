package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
public class JPPregunta extends JPanel {
    private String respuestaObtenida;
	private static final long serialVersionUID = -9188538853683711971L;
	private JTextPane JTPregunta;
	private JCheckBox JCBUno;
	private JCheckBox JCBDos;
	private JCheckBox JCBTres;
	/**
	 * 
	 */

	private ArrayList <String> respuestas;
	private SistemaVista delegate; 
	public JPPregunta(SistemaVista delegate) {
		this.setDelegate(delegate);
		this.inicializarPanelPregunta();
	}
	
	public void paintComponent(Graphics g )  {
		Dimension tamaño = this.getSize();
		ImageIcon fondo = new ImageIcon (new ImageIcon (getClass().getResource("/Imagenes/FondoPregunta.jpg")).getImage());
		g.drawImage(fondo.getImage(),0, 0,tamaño.width,tamaño.height,this);
	}
	
	 
	 
		protected void inicializarPanelPregunta() {
			this.setJTPregunta(new JTextPane());
			this.getJTPregunta().setFont(new Font("Arial", Font.BOLD, 20));
			this.getJTPregunta().setEditable(false);
        	this.getJTPregunta().setText(this.getDelegate().getControlador().getSistemaJuego().getSistemaPreguntas().obtenerPregunta());
			this.setBounds(650, 200, 336, 309);
			this.setBounds(650, 200, 230, 309);
            this.setRespuestas(this.getDelegate().getControlador().getSistemaJuego().getSistemaPreguntas().respuestasMescladas());

			 
			this.setJCBUno(new JCheckBox(this.getRespuestas().get(0)));
			this.getJCBUno().setFont(new Font("Arial", Font.PLAIN, 14));
			this.getJCBUno().addActionListener(this.getDelegate().getControlador().getControladorPreguntas());
			this.setJCBDos(new JCheckBox(this.getRespuestas().get(1)));
			this.getJCBDos().setFont(new Font("Arial", Font.PLAIN, 14));
			this.getJCBDos().addActionListener(this.getDelegate().getControlador().getControladorPreguntas());
			this.setJCBTres(new JCheckBox(this.getRespuestas().get(2)));
			this.getJCBTres().addActionListener(this.getDelegate().getControlador().getControladorPreguntas());
			this.getJCBTres().setFont(new Font("Arial", Font.PLAIN, 14));
			this.setBackground(new Color(70, 130, 180));
			
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(54)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(this.getJCBUno(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addComponent(this.getJCBDos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addComponent(this.getJCBTres(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(this.getJTPregunta(), GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(19)
						.addComponent(this.getJTPregunta(), GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(this.getJCBUno(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(this.getJCBDos(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(this.getJCBTres(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(26))
			);
			setLayout(groupLayout);

		}
		
        protected void preguntaRapida() {
    
        	this.getJTPregunta().setText(this.getDelegate().getControlador().getSistemaJuego().getSistemaPreguntas().obtenerPregunta());
            this.setRespuestas(this.getDelegate().getControlador().getSistemaJuego().getSistemaPreguntas().respuestasMescladas());
        	this.getJCBUno().setText(getRespuestas().get(0));
        	this.getJCBDos().setText(getRespuestas().get(1));
        	this.getJCBTres().setText(getRespuestas().get(2));
        	
        }

		private SistemaVista getDelegate() {
			return delegate;
		}


		private void setDelegate(SistemaVista delegate) {
			this.delegate = delegate;
		}



		private ArrayList<String> getRespuestas() {
			return respuestas;
		}



		private void setRespuestas(ArrayList<String> respuestas) {
			this.respuestas = respuestas;
		}



		protected String getRespuestaObtenida() {
			return respuestaObtenida;
		}


		private JTextPane getJTPregunta() {
			return JTPregunta;
		}



		private void setJTPregunta(JTextPane jTPregunta) {
			JTPregunta = jTPregunta;
		}



		private JCheckBox getJCBUno() {
			return JCBUno;
		}



		private void setJCBUno(JCheckBox jCBUno) {
			JCBUno = jCBUno;
		}



		private JCheckBox getJCBDos() {
			return JCBDos;
		}



		private void setJCBDos(JCheckBox jCBDos) {
			JCBDos = jCBDos;
		}



		private JCheckBox getJCBTres() {
			return JCBTres;
		}



		private void setJCBTres(JCheckBox jCBTres) {
			JCBTres = jCBTres;
		}
		
		
		
		
}
