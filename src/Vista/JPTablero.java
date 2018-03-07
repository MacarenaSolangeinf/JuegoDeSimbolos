package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.SistemaJuego;
import javax.swing.*;

public class JPTablero extends JPanel {


	private static final long serialVersionUID = 1L;
	private static final int ANCHO_SIMBOLO=100;	
	private JButton [][] tablero;
	private JButton ultimoSeleccionado;
	private JButton primerSeleccionado;
	private static final int X_TABLERO = 250;
	private static final int Y_TABLERO = 100;
	private SistemaVista delegate; 
	
	
	public JPTablero(SistemaVista sistemaVista) {
		
		this.setDelegate(sistemaVista);
		this.setTablero(new JButton [SistemaJuego.getDimFila()][SistemaJuego.getDimCol()]);
		this.setBounds(50,100, 500, 500);
		this.setLayout(null);
		inicializarPanelTablero(0 , 0);
		this.setUltimoSeleccionado(null);
		this.setVisible(true);

	}
	
	protected void intercambiarSimbolos(JButton simboloUno,JButton simboloDos) {
  Icon imagenAux=simboloUno.getIcon();
  simboloUno.setIcon(simboloDos.getIcon());
  simboloDos.setIcon(imagenAux);
  this.colocarCaraAcertada();

}

public static void limpiarButton(JButton button) {
    if (button != null) {
        for (Component item : button.getComponents()) {
        	  if (item instanceof JLabel) {
                  ((JLabel) item).removeAll();
                  ((JLabel) item).setIcon(null);
                  ((JLabel) item).setText(null);
               }
        }
     }

}

protected void colocarCaraAcertada() {

	for (JButton[] fila : this.getTablero()) {
		for (final JButton simbolo: fila) {
			limpiarButton(simbolo);
			if((this.getDelegate().getControlador().getSistemaJuego().yaAcertado(simbolo.getY()/100,simbolo.getX()/100))){
		    JLabel cara=new JLabel();	
		    JLabel texto=new JLabel();
		    cara.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Acertado.png")));
		    texto.setText(" " +this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(simbolo.getY()/100,simbolo.getX()/100).getValor() );
		    texto.setForeground(Color.BLACK);
		    texto.setBounds(simbolo.getBounds());
		    texto.setFont(new Font("Cambria", Font.BOLD,28));	    
	        cara.setBounds(0,0,100,100);
	        Dimension tamaño = simbolo.getSize();
		    texto.setBounds(simbolo.getY(),simbolo.getX(),tamaño.width + 10,tamaño.height+10);
	        simbolo.add(texto);
			simbolo.add(cara);
			}

		}
		}
}

protected void colocarCaraPerdiste() {

	for (JButton[] fila : this.getTablero()) {
		for (final JButton simbolo: fila) {
		 
			if((!this.getDelegate().getControlador().getSistemaJuego().yaAcertado(simbolo.getY()/100,simbolo.getX()/100))){
		    JLabel cara=new JLabel();	
		    cara.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Perdiste.png")));
		    JLabel textoRelleno = new JLabel();
		    textoRelleno.setText("" +this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(simbolo.getY()/100,simbolo.getX()/100).getValor() );
		    textoRelleno.setFont(new Font("Ballpark", Font.PLAIN,30));
		    textoRelleno.setForeground(Color.WHITE);	
		    textoRelleno.setFont(new Font("Cambria", Font.BOLD,28));
		    Dimension tamaño = simbolo.getSize();
		    textoRelleno.setBounds(simbolo.getY(),simbolo.getX(),tamaño.width + 10,tamaño.height+10);
	        cara.setBounds(0,0,100,100);
	        simbolo.add(textoRelleno);
			simbolo.add(cara);
			}

		}
		}
}


protected void colorearEnAzul( int i , int j) {
	this.getTablero()[i][j].setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+
	this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(i, j).getNombre()+".jpg")));

}


protected void colorearEnVerde( int i , int j) {
	this.getTablero()[i][j].setIcon(new ImageIcon(getClass().getResource("/Imagenes/" +
			this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(i, j).getNombre()+"Verde.jpg")));
	 	
}


	private void inicializarPanelTablero(int posicionXPanel , int posicionYPanel) {
		int x = posicionXPanel;
		int y =posicionYPanel;
	
		for (int i = 0 ;i<SistemaJuego.getDimCol() ;i++ )
		{
			for (int j=0;j<SistemaJuego.getDimFila() ; j++ )
			{			
				JButton unButton = new JButton();
				unButton.setBounds(x,y, JPTablero.getAnchoSimbolo(), JPTablero.getAnchoSimbolo());

				unButton.setIcon(new ImageIcon( getClass().getResource("/Imagenes/" + 
			     this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(j,i).getNombre()+".jpg")));
		
				this.add(unButton);
				y = y + JPTablero.getAnchoSimbolo();
				this.getTablero()[j][i]=unButton;
				
					
				
			}
			x = x + JPTablero.getAnchoSimbolo();
			y = posicionYPanel;
		}
       this.iniActionListernerJPTablero();
	}
	
	
	

	private void iniActionListernerJPTablero () {
      
		for (JButton[] fila : this.getTablero()) {
			for (final JButton simbolo: fila) {
				simbolo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
                         getDelegate().getControlador().getSistemaJuego().setAyudaContextual(getDelegate().getControlador().getSistemaJuego().getAyudaSeleccion().get(0));


				        if (getPrimerSeleccionado() == null)
				        {   
				        	
				        	if (!(getDelegate().getControlador().getSistemaJuego().yaAcertado(simbolo.getY()/100 , simbolo.getX()/100))) {
	
				        	getDelegate().acertarSimbolo(simbolo.getIcon());
				        	colorearEnVerde( simbolo.getY()/100 , simbolo.getX()/100);
				        	setPrimerSeleccionado(simbolo);
				        	getDelegate().getControlador().getSistemaJuego().establecerSeleccion(simbolo.getY()/100 , simbolo.getX()/100);
				        	}
				        	else 
				        	{
				        		
				        		colorearEnVerde( simbolo.getY()/100 , simbolo.getX()/100);
					        	setPrimerSeleccionado(simbolo);
				        	}
				       
				        }
				        else
				        {
				        	if (getPrimerSeleccionado() == evento.getSource()) {
				        		colorearEnAzul( simbolo.getY()/100 , simbolo.getX()/100);
				        		getDelegate().getJpValorSimbolo().setVisible(false);
				        		setPrimerSeleccionado(null);
				        		
				        	}
				        	else 
				        	{
				        	
		                         getDelegate().getControlador().getSistemaJuego().setAyudaContextual(getDelegate().getControlador().getSistemaJuego().getAyudaIntercambios().get(0));
		                       //  getDelegate().getControlador().getSistemaJuego().getAyudaContextual().add(getDelegate().getControlador().getSistemaJuego().getAyudaIntercambios().get(1));
				        	setUltimoSeleccionado(simbolo);
				        	getDelegate().getControlador().intercambiar(getPrimerSeleccionado().getY()/100, getPrimerSeleccionado().getX()/100, 
				        			getUltimoSeleccionado().getY()/100, getUltimoSeleccionado().getX()/100);
				        }

				        }
						
						}
					});
			}
		
	}
		
	}

	
	
	
	
	protected JButton[][] getTablero() {
		return this.tablero;
	}

  
	private void setTablero(JButton [][] tablero) {
		this.tablero = tablero;
	}


	private static int getAnchoSimbolo() {
		return ANCHO_SIMBOLO;
	}


	public JButton getUltimoSeleccionado() {
		return ultimoSeleccionado;
	}


	protected void setUltimoSeleccionado(JButton ultimoSeleccionado) {
		this.ultimoSeleccionado = ultimoSeleccionado;
	}
	
	protected void colorearEnRojo( int i , int j) {
		this.getTablero()[i][j].setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+
				this.getDelegate().getControlador().getSistemaJuego().obtenerSimbolo(i, j).getNombre()+"Rojo.jpg")));
		 this.setUltimoSeleccionado(null);
		 this.setPrimerSeleccionado(null);
		
		
	}




	protected static int getxTablero() {
		return X_TABLERO;
	}




	protected static int getyTablero() {
		return Y_TABLERO;
	}




	private SistemaVista getDelegate() {
		return delegate;
	}




	private void setDelegate(SistemaVista delegate) {
		this.delegate = delegate;
	}




	public JButton getPrimerSeleccionado() {
		return primerSeleccionado;
	}




	protected void setPrimerSeleccionado(JButton primerSeleccionado) {
		this.primerSeleccionado = primerSeleccionado;
	}



	
	

}
