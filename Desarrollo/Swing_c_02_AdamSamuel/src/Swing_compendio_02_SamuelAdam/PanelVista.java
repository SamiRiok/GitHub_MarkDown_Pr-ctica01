/**
 * PanelVista.java
   23 nov 2022 8:30:10
   @author Samuel Adam
 */
package Swing_compendio_02_SamuelAdam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author usuario
 *
 */
public class PanelVista extends JPanel{
	private PaletaColores pl;
	public static JLabel Texto;
	public static JTable Jt;
	public static JScrollPane Sp;
	public static DefaultTableModel model;
	public static JPanel PanelTexto;
	private String extra;
	public static boolean guardarDatos = false;
	public static boolean vacio = true;

	/**
	 * 
	 */
	public PanelVista() {
		pl = new PaletaColores();
		Sp = new JScrollPane();
		Sp.getViewport().setBackground(pl.azulVista);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, pl.azulFondo));
		this.add(Sp, BorderLayout.CENTER);
		PanelTexto = new JPanel();
		PanelTexto.setBackground(pl.azulVista);
		Texto = new JLabel("No hay ningun registro, añadelos pulsando el icono '+'");
		Texto.setFont(new Font("", Font.BOLD | Font.ITALIC, 25));
		Texto.setForeground(pl.dorado);
		PanelTexto.add(Texto);
		
		String[] columnNames = { "Nombre Completo", "Habitaciones", "Tipo de Habitaciones", "Noches", "Extras" };
		model = new DefaultTableModel(null, columnNames);
		Jt = new JTable(model);
		
		if(vacio == false) {
			Sp.setViewportView(Jt);
			PanelTexto.setVisible(false);
		} else {
			Sp.getViewport().add(PanelTexto);
		}
		
		

		this.setVisible(true);
	

	
	}

	
	

}
