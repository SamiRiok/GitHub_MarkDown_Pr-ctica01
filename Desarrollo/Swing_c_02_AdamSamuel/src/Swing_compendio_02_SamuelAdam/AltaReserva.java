/**
 * AltaReserva.java
   22 nov 2022 9:44:15
   @author Samuel Adam
 */
package Swing_compendio_02_SamuelAdam;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.text.MaskFormatter;

/**
 * @author usuario
 *
 */
public class AltaReserva extends JDialog implements FocusListener{
	private PaletaColores pl;
	private JPanel p1, p2;
	private Panel3 p3;
	private boolean b = true;
	public static MaskFormatter mascara1, mascara2, mascara3;
	/**
	 * CONSTRUCTOR
	 */
	public static JTextField CampoNombre, CampoApellidos;
	public static JFormattedTextField  CampoTelefono, CampoDNI;
	private JLabel Nombre, Apellidos, Telefono, DNI, FechaE, FechaS, CalculoDias;
	public static JLabel ResultadoDia;
	public static JSpinner CampoE, CampoS;
	
	private int dia1, dia2;
	public static int resultado;
	
	public static long dias = 1;
	
	public static boolean reiniciar = false;
	

	
	public AltaReserva(Ventana ventana, Boolean modal) {
		super(ventana, modal);
		Dimensiones(ventana);
		
		pl = new PaletaColores();
		this.setTitle("Alta Reservas");
		
		
		Panel1();
		Panel2();
		Panel3();
		
		Panel3.guardar.addActionListener(e->{
			if(!CampoNombre.getText().trim().isEmpty() && !CampoApellidos.getText().trim().isEmpty() && !CampoTelefono.getText().trim().isEmpty() && !CampoDNI.getText().trim().isEmpty()) {
				this.dispose();
				PanelVista.guardarDatos =  true;
			}
			else {
				JOptionPane.showMessageDialog(this, "Debes Rellenar Todos los datos del cliente");
			}
			
			
			
			
		});
		
		this.setVisible(true);
		
	}
	

	
	private void Panel1() {
		Icon icono = new ImageIcon(getClass().getResource("Recursos/Logo.jpg"));
		JLabel imagen = new JLabel(icono);
		JLabel texto1 = new JLabel("  PALACE HOTEL NALTAR  ");
		texto1.setFont(new Font("", Font.BOLD|Font.ITALIC, 45));
		texto1.setForeground(pl.dorado);
		
		JLabel texto2 = new JLabel(" -   ALTA NUEVAS RESERVAS");
		texto2.setFont(new Font("", Font.BOLD|Font.ITALIC, 25));
		texto2.setForeground(pl.dorado);
		
		p1 = new JPanel();
		p1.add(imagen, BorderLayout.WEST);
		p1.add(texto1, BorderLayout.CENTER);
		p1.add(texto2, BorderLayout.EAST);
		p1.setBackground(pl.azulOscuro);
		p1.setVisible(true);
		this.add(p1, BorderLayout.NORTH);
		

	}
	
	private void Panel2() {
		JPanel p2_1 = new JPanel();
		JPanel p2_2 = new JPanel();
		JPanel p2_3 = new JPanel();
		JPanel p2_4 = new JPanel();
		JPanel p2_5 = new JPanel();
		JPanel p2_6 = new JPanel();
		JPanel p2_7 = new JPanel();
		
		p2 = new JPanel();
		p2.setBackground(pl.azulFondo);
		p2_2.setBackground(pl.azulFondo);
		p2_3.setBackground(pl.azulFondo);
		p2_4.setBackground(pl.azulFondo);
		p2_5.setBackground(pl.azulFondo);
		p2_6.setBackground(pl.azulFondo);
		p2_7.setBackground(pl.azulFondo);
		
		p2_1.setLayout(new BoxLayout(p2_1, BoxLayout.Y_AXIS));
		
		setLabels();
		setFields();
		
		
		p2.add(Nombre);
		p2.add(CampoNombre);
		p2_2.add(Apellidos);
		p2_2.add(CampoApellidos);
		p2_3.add(Telefono);
		p2_3.add(CampoTelefono);
		p2_4.add(DNI);
		p2_4.add(CampoDNI);
		p2_5.add(FechaE);
		p2_5.add(CampoE);
		p2_6.add(FechaS);
		p2_6.add(CampoS);
		p2_7.add(CalculoDias);
		p2_7.add(ResultadoDia);
		
		
		p2_1.add(p2);
		p2_1.add(p2_2);
		p2_1.add(p2_3);
		p2_1.add(p2_4);
		p2_1.add(p2_5);
		p2_1.add(p2_6);
		p2_1.add(p2_7);
		p2_1.setBackground(pl.azulFondo);
		p2_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, pl.azulMarco));
		p2_1.setVisible(true);
		
		this.add(p2_1, BorderLayout.WEST);
		
		
	}
	
	
	
	private void Panel3() {
		p3 = new Panel3();
		this.add(p3, BorderLayout.CENTER);
		this.add(p3.panelCalculos, BorderLayout.EAST);
		p3.panelCalculos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, pl.azulMarco));
		

		
	}


	private void Dimensiones(Ventana ventana) {
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int y = dm.height;
		int x = dm.width;
		this.setSize(x+ 14, y- 30);
		this.setLocation(-7, 0);
		
	}
	
	
	private void setLabels() {

		Nombre = new JLabel("Nombre: ");
		Nombre.setForeground(pl.dorado);
		Nombre.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		Apellidos = new JLabel("Apellidos: ");
		Apellidos.setForeground(pl.dorado);
		Apellidos.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		Telefono = new JLabel("Telefono: ");
		Telefono.setForeground(pl.dorado);
		Telefono.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		DNI = new JLabel("DNI: ");
		DNI.setForeground(pl.dorado);
		DNI.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		FechaE = new JLabel("Fecha Entrada: ");
		FechaE.setForeground(pl.dorado);
		FechaE.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		FechaS = new JLabel("Fecha Salida: ");
		FechaS.setForeground(pl.dorado);
		FechaS.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		CalculoDias = new JLabel("Dias: ");
		CalculoDias.setForeground(pl.dorado);
		CalculoDias.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		
		
	}
	

	@SuppressWarnings("deprecation")
	private void setFields() {
		
		CampoNombre = new JTextField("                                              ");
		CampoNombre.setBackground(pl.azulMarco);
		CampoNombre.setForeground(pl.dorado);
		CampoNombre.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));
		CampoNombre.addFocusListener(this);
		

		
		
		CampoApellidos = new JTextField("                                              ");
		CampoApellidos.setBackground(pl.azulMarco);
		CampoApellidos.setForeground(pl.dorado);
		CampoApellidos.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));

		

		
		
		try {
			mascara1 = new MaskFormatter("#########                                    ");
			mascara2 = new MaskFormatter("########U                                           ");

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CampoTelefono = new JFormattedTextField(mascara1);
		CampoTelefono.setBackground(pl.azulMarco);
		CampoTelefono.setForeground(pl.dorado);
		CampoTelefono.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));

		

		
		
		CampoDNI = new JFormattedTextField(mascara2);
		CampoDNI.setBackground(pl.azulMarco);
		CampoDNI.setForeground(pl.dorado);
		CampoDNI.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));

		
		SpinnerDateModel fecha = new SpinnerDateModel();
		
		CampoE = new JSpinner(fecha);
		CampoE.getEditor().getComponent(0).setBackground(pl.azulMarco);
		CampoE.getEditor().getComponent(0).setForeground(pl.dorado);
		CampoE.setBackground(pl.azulMarco);
		CampoE.setForeground(pl.dorado);
		CampoE.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));
		
				
		
		Date calendario = new Date();
		int dia = calendario.getDate() + 1;		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);

		Date startTime = cal.getTime();
		

		SpinnerDateModel dateModel = new SpinnerDateModel(startTime, null, null, 0);
	    CampoS = new JSpinner(dateModel);
		CampoS.getEditor().getComponent(0).setBackground(pl.azulMarco);
		CampoS.getEditor().getComponent(0).setForeground(pl.dorado);
		CampoS.setBackground(pl.azulMarco);
		CampoS.setForeground(pl.dorado);
		CampoS.setBorder(BorderFactory.createEmptyBorder(5,5,5,0));

		
		dia1 = fecha.getDate().getDate();
		dia2 = dateModel.getDate().getDate();
		resultado = dia2 - dia1;
		
		ResultadoDia = new JLabel();
		ResultadoDia.setText("" + resultado);
		ResultadoDia.setForeground(pl.dorado);
		ResultadoDia.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		
		
		dateModel.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(dateModel.getDate().getTime() > fecha.getDate().getTime()) {

					long diasDesde = (long) Math.floor(fecha.getDate().getTime() / (1000*60*60*24));
					long diasHasta = (long) Math.floor(dateModel.getDate().getTime() / (1000*60*60*24));
					dias = diasHasta - diasDesde;
					ResultadoDia.setForeground(pl.dorado);
					ResultadoDia.setText(""+dias);
					Panel3.Noches.setText("Noches................... " + dias);  
					Panel3.total = (int) (dias * Panel3.precio);
					if(Panel3.contadorExtra == false) {
						Panel3.total += 20;
					}
					Panel3.PrecioTotal.setText("Total................... " + Panel3.total * Panel3.num +"€");

				}else {
					
					String texto = "<html><body>LA FECHA DE SALIDA <br> NO PUEDE SER IGUAL O <br> ANTES QUE LA ENTRADA</body></html>";		
					ResultadoDia.setText(texto);
					ResultadoDia.setForeground(Color.red);
				}
				
				
			}
			
		});
		
		fecha.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(dateModel.getDate().getTime() > fecha.getDate().getTime()) {

					long diasDesde = (long) Math.floor(fecha.getDate().getTime() / (1000*60*60*24));
					long diasHasta = (long) Math.floor(dateModel.getDate().getTime() / (1000*60*60*24));
					dias = diasHasta - diasDesde;
					ResultadoDia.setForeground(pl.dorado);
					ResultadoDia.setText(""+dias);
					Panel3.Noches.setText("Noches................... " + dias);   
					Panel3.total = (int) (dias * Panel3.precio);
					if(Panel3.contadorExtra == false) {
						Panel3.total += 20;
					}
					Panel3.PrecioTotal.setText("Total................... " + Panel3.total * Panel3.num +"€");
					    

				}else {
					
					String texto = "<html><body>LA FECHA DE SALIDA <br> NO PUEDE SER IGUAL O <br> ANTES QUE LA ENTRADA</body></html>";		
					ResultadoDia.setText(texto);
					ResultadoDia.setForeground(Color.red);
				}
				
			}
			
		});
		
		

		
		
	}
	


	@Override
	public void focusGained(FocusEvent e) {
		if(CampoNombre.getText().trim().isEmpty()) {
			CampoNombre.setText("");
		}
		if(CampoApellidos.getText().trim().isEmpty()) {
			CampoApellidos.setText("");
		}

	}



	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}




}
