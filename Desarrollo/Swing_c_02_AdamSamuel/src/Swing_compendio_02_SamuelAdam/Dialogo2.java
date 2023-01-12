/**
 * Dialogo2.java
   22 nov 2022 9:51:48
   @author Samuel Adam
 */
package Swing_compendio_02_SamuelAdam;


import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * @author usuario
 *
 */
public class Dialogo2 extends JDialog{
	private PaletaColores pl;
	
	/**
	 * @param ventana
	 * @param modal
	 */
	public Dialogo2(Ventana ventana, boolean modal){
		super(ventana, modal);
		this.setTitle("No Disponible");
		dimensiones(ventana);
		pl = new PaletaColores();
		
		Icon icono = new ImageIcon(getClass().getResource("Recursos/Molestias.png"));
		JLabel imagen = new JLabel(icono);
		
		JLabel texto = new JLabel("Disponible en un futuro, Disculpe las molestias...");
		texto.setForeground(pl.dorado);
		
		JButton boton = new JButton("Aceptar");
		boton.setBackground(pl.azulOscuro);
		boton.setForeground(pl.dorado);
		boton.addActionListener(e->{
			
			this.dispose();
			
			
		});
		
		this.add(texto, BorderLayout.CENTER);
		this.add(imagen, BorderLayout.WEST);
		this.add(boton, BorderLayout.SOUTH);
		
		this.getContentPane().setBackground(pl.azulFondo);
		this.setVisible(true);
		
		
		
	}
	/**
	 * 
	 */
	private void dimensiones(Ventana ventana) {

		float dimensionVentanaX = ventana.getWidth() / 2.3f;
		int dimensionVentanaY = ventana.getHeight() /3;
		
		
		float PosicionVentanaX = ventana.getX() * 1.1f;
		float PosicionVentanaY = ventana.getY() * 1.3f;

		this.setSize((int)(dimensionVentanaX), dimensionVentanaY);
		this.setLocation((int)(PosicionVentanaX) + (int)(dimensionVentanaX /2), (int)(PosicionVentanaY)  + dimensionVentanaY /2);
		
	}

}
