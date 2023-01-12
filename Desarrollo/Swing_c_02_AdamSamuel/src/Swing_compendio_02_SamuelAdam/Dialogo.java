package Swing_compendio_02_SamuelAdam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialogo extends JDialog{
	private JLabel imagen;
	private JLabel texto;
	private JPanel jp;
	private PaletaColores pl;
	/**
	 * @param ventana
	 * @param modal
	 */
	public Dialogo(Ventana ventana, boolean modal){
		
		super(ventana, modal);
		this.setLayout(new BorderLayout());
		this.setTitle("Acerca de...");
		this.setResizable(false);
		positions(ventana);
		pl = new PaletaColores();
		Image icon = new ImageIcon(getClass().getResource("Recursos/Logo.jpg")).getImage();
		this.setIconImage(icon);
		
		
		
		
		Icon icono = new ImageIcon(icon.getScaledInstance(200, 150, icon.SCALE_FAST));
		imagen = new JLabel(icono);
		
		
		
		jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		textoCambiar(" ");
		textoCambiar(" Version: 0.1 Beta");
		textoCambiar(" ________________________________");
		textoCambiar(" Gestion de Hotel Palace");
		textoCambiar(" Practica 02 compendio");
		textoCambiar(" ___________________________");
		textoCambiar(" Creado por Samuel Adam");

		
		jp.setBackground(pl.azulOscuro);
		
		
		
		this.add(jp, BorderLayout.CENTER);
		this.add(imagen, BorderLayout.EAST);
		this.setVisible(true);
		
		
	}

	private void positions(Ventana ventana) {
		
		int dimensionVentanaX = ventana.getWidth() /2;
		int dimensionVentanaY = ventana.getHeight() /3;
		
		int PosicionVentanaX = ventana.getX();
		int PosicionVentanaY = ventana.getY();

		this.setSize(dimensionVentanaX, dimensionVentanaY);
		this.setLocation(PosicionVentanaX + dimensionVentanaX /2, PosicionVentanaY  + dimensionVentanaY /2);
		
	}
	
	private void textoCambiar(String text) {
		
		texto = new JLabel(text);
		texto.setFont(new Font("Caladea", Font.PLAIN, 14));
		texto.setForeground(pl.dorado);
		jp.add(texto);
		
		
	}
	


}
