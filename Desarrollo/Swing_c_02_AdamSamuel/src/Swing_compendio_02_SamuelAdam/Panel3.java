/**
 * Panel3.java
   24 nov 2022 11:42:22
   @author Samuel Adam
 */
package Swing_compendio_02_SamuelAdam;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 * @author usuario
 *
 */
public class Panel3 extends JPanel{
	private PaletaColores pl;
	public static JComboBox tipoH, extras2;
	public static JLabel TipoHabitacion, NumeroHabitaciones, edadNiños, extras, PrecioTotal;
	public static JLabel Noches, numero, numero2;
	private JLabel DiasCalculo, Cextras, dias, Habitaciones;
	private String[] habitaciones = {"Simple", "Doble", "Suit"};
	String[] extrass = {"Ninguno", "Cuna", "Cama Supletoria Pequeña",  "Cama Supletoria Normal"};
	public static JCheckBox niños;
	public static int num = 1, edad, precio =50, contador = 0, total = 50;
	private JPanel panelniños, p3_2;
	public static JPanel panelCalculos;
	public static boolean ExtraActivado, contadorExtra = true;
	private JButton boton;
	private AltaReserva pa;
	public static JButton guardar, reset, imprimir;
	private String extra;
	private AltaReserva Ar;
	
	public Panel3() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pl = new PaletaColores();
		
		panelNiños();
		this.setBackground(pl.azulFondo);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, pl.azulMarco));
		setLabels();
		panelCaluclos();
		panelBotones();
		this.setVisible(true);
		


	}
	/**
	 * 
	 */
	private void panelBotones() {
		JPanel panelsur = new JPanel();
		panelsur.setBackground(pl.azulFondo);
		Icon icono = new ImageIcon(getClass().getResource("Recursos/Guardar.png"));
		guardar = new JButton(icono);
		guardar.setBackground(null);
		guardar.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		guardar.addActionListener(e->{
			if(!AltaReserva.CampoNombre.getText().trim().isEmpty() && !AltaReserva.CampoApellidos.getText().trim().isEmpty() && !AltaReserva.CampoTelefono.getText().trim().isEmpty() && !AltaReserva.CampoDNI.getText().trim().isEmpty()) {
				PanelVista.vacio = false;
				
				if(PanelVista.vacio == false) {
					PanelVista.Sp.setViewportView(PanelVista.Jt);
					PanelVista.PanelTexto.setVisible(false);
				} else {
					PanelVista.Sp.getViewport().add(PanelVista.PanelTexto);
				}
				
				if(extras2.getSelectedItem().toString() == "Ninguno") {
					extra = "No";
				}else {
					extra = "Si";
				}
				Object[] datos = {AltaReserva.CampoNombre.getText().trim() + " " + AltaReserva.CampoApellidos.getText().trim(), Panel3.num, Panel3.tipoH.getSelectedItem(), AltaReserva.dias, extra};
				PanelVista.model.addRow(datos);
			}
			
			
		});
		
		
		
		Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Resetear.png"));
		reset = new JButton(icono2);
		reset.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		reset.setBackground(null);
		reset.addActionListener(e->{
			
			DiasCalculo.setText("Habitacion " + tipoH.getSelectedItem().toString() +" ........ "+ precio+ " €");
			niños.setSelected(false);
			ExtraActivado = false;
			if(contadorExtra == false) {
				
				total -= 20;
				
				contadorExtra = true;
				
			}
			p3_2.setVisible(false);
			Cextras.setVisible(false);
			num = 1;
			numero.setText(""+num);
			Habitaciones.setText("Habitaciones Alquiladas "+" ........ " + num );
			tipoH.setSelectedItem(habitaciones[0]);
			AltaReserva.CampoNombre.setText("                                              ");
			AltaReserva.CampoApellidos.setText("                                              ");
			AltaReserva.CampoDNI.setText("");
			AltaReserva.CampoTelefono.setText("");
			
			SpinnerDateModel fecha = new SpinnerDateModel();
			AltaReserva.CampoE.setValue(fecha.getDate());
			

			Date calendario = new Date();
			int dia = calendario.getDate() + 1;		
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, dia);

			Date startTime = cal.getTime();
			

			SpinnerDateModel dateModel = new SpinnerDateModel(startTime, null, null, 0);
		    AltaReserva.CampoS.setValue(dateModel.getDate());
			
			AltaReserva.resultado = 1;
			AltaReserva.ResultadoDia.setText("" + AltaReserva.resultado);
			
			PrecioTotal.setText("Total................... " + total * num +"€");
			
			
		});
		
		
		
		Icon icono3 = new ImageIcon(getClass().getResource("Recursos/Imprimir.png"));
		imprimir = new JButton(icono3);
		imprimir.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		imprimir.setBackground(null);
		imprimir.addActionListener(e->{
			
			
			new PanelGuardar(pa, true);
			
			
		});
		
		panelsur.add(guardar);
		panelsur.add(reset);
		panelsur.add(imprimir);
		this.add(panelsur, BorderLayout.SOUTH);
		
	}
	/**
	 * 
	 */
	//PANEL DE LOS CALCULOS FINALES
	private void panelCaluclos() {
		panelCalculos = new JPanel();
		panelCalculos.setBackground(pl.azulFondo);
		panelCalculos.setLayout(new BoxLayout(panelCalculos, BoxLayout.Y_AXIS));
		
		JLabel titulo = new JLabel("COSTE");
		titulo.setBorder(BorderFactory.createEmptyBorder(30,210,30,210));
		titulo.setForeground(pl.dorado);
		titulo.setFont(new Font("", Font.BOLD | Font.ITALIC, 25));
		
		
		DiasCalculo = new JLabel("Habitacion " + tipoH.getSelectedItem().toString() +" ........ "+ precio+ " €");
		DiasCalculo.setForeground(pl.dorado);
		DiasCalculo.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		DiasCalculo.setFont(new Font("", Font.ITALIC, 20));
		
		Cextras = new JLabel("Extras - " + extras2.getSelectedItem().toString() +" ....... "+ "0€");
		Cextras.setForeground(pl.dorado);
		Cextras.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		Cextras.setFont(new Font("", Font.ITALIC, 20));
		Cextras.setVisible(false);
		
		Habitaciones = new JLabel("Habitaciones Alquiladas "+" ........ " + num );
		Habitaciones.setForeground(pl.dorado);
		Habitaciones.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		Habitaciones.setFont(new Font("", Font.ITALIC, 20));
		
		Noches = new JLabel("Noches................... " + AltaReserva.resultado);
		Noches.setForeground(pl.dorado);
		Noches.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		Noches.setFont(new Font("", Font.ITALIC, 20));
		
		JLabel linea = new JLabel("_____________________________");
		linea.setForeground(pl.dorado);
		linea.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		linea.setFont(new Font("", Font.ITALIC, 20));
		
		
		
		PrecioTotal = new JLabel("Total................... " + total * num +"€");
		PrecioTotal.setForeground(pl.dorado);
		PrecioTotal.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		PrecioTotal.setFont(new Font("", Font.ITALIC, 20));
		

		

		
		
		
		panelCalculos.add(titulo);
		panelCalculos.add(DiasCalculo);
		panelCalculos.add(Noches);
		panelCalculos.add(Cextras);
		panelCalculos.add(Habitaciones);
		panelCalculos.add(linea);
		panelCalculos.add(PrecioTotal);

		
		
		
	}
	/**
	 * 
	 */
	//PANEL EXTRA NIÑOS
	private void panelNiños() {
		panelniños = new JPanel();
		panelniños.setBackground(pl.azulFondo);
		
		edadNiños = new JLabel("Edad Niños: ");
		edadNiños.setForeground(pl.dorado);
		edadNiños.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		spinner2(panelniños, 14);
		
		extras = new JLabel("Extras: ");
		extras.setForeground(pl.dorado);
		extras.setBorder(BorderFactory.createEmptyBorder(15,100,15,5));
		
		
		extras2 = new JComboBox(extrass);
		extras2.setBackground(pl.azulOscuro);
		extras2.setForeground(pl.dorado);
		extras2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(extras2.getSelectedItem().toString() == "Ninguno") {
					
					Cextras.setText("Extras - " + extras2.getSelectedItem().toString() +" ....... "+ "0€");
					
					if(contadorExtra == false) {
						
						total -= 20;
						PrecioTotal.setText("Total................... " + total * num +"€");
						contadorExtra = true;
						
					}
					
				}
				else {
					ExtraActivado = true;
					Cextras.setText("Extras - " + extras2.getSelectedItem().toString() +" ....... "+ "20€");
					if(contadorExtra == true) {
						
						total += 20;
						PrecioTotal.setText("Total................... " + total * num +"€");
						contadorExtra = false;
						
					}
				}
			}	
		});
		
		

		this.setVisible(false);
		
	}
	
	/**
	 * 
	 */
	
	//COLOCACION DE LABELS
	private void setLabels() {
		JPanel p3 = new JPanel();
		JPanel p3_1 = new JPanel();
		p3_2 = new JPanel();
		p3_2.setVisible(false);
		p3.setBackground(pl.azulFondo);
		p3_1.setBackground(pl.azulFondo);
		p3_2.setBackground(pl.azulFondo);
		
		TipoHabitacion = new JLabel("Tipo de Habitacion: ");
		TipoHabitacion.setForeground(pl.dorado);
		TipoHabitacion.setBorder(BorderFactory.createEmptyBorder(15,30,15,5));
		
		
		tipoH = new JComboBox(habitaciones);
		tipoH.setBackground(pl.azulOscuro);
		tipoH.setForeground(pl.dorado);
		
		
		
		
		tipoH.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(tipoH.getSelectedItem() == "Simple") {
					precio = 50;
					total = (int) (precio * AltaReserva.dias);
					if(contadorExtra == false) {
						total += 20;
					}
					PrecioTotal.setText("Total................... " + total * num +"€");
				}
				if(tipoH.getSelectedItem() == "Doble") {
					precio = 75;
					total = (int) (precio * AltaReserva.dias);
					if(contadorExtra == false) {
						total += 20;
					}
					PrecioTotal.setText("Total................... " + total * num +"€");

				}
				if(tipoH.getSelectedItem() == "Suit") {
					precio = 125;
					total = (int) (precio * AltaReserva.dias);
					if(contadorExtra == false) {
						total += 20;
					}
					PrecioTotal.setText("Total................... " + total * num +"€");

				}
				DiasCalculo.setText("Habitacion " + tipoH.getSelectedItem().toString() +" ........ "+ precio+ " €");

				
			}
			
			
			
		});
			
			
		
		NumeroHabitaciones = new JLabel("Numero de Habitaciones:  ");
		NumeroHabitaciones.setForeground(pl.dorado);
		NumeroHabitaciones.setBorder(BorderFactory.createEmptyBorder(15,50,15,5));
		
		
		
		niños = new JCheckBox("¿Se hospedan niños?");
		niños.setBackground(pl.azulFondo);
		niños.setForeground(pl.dorado);
		
		niños.addActionListener(e->{
			if(niños.isSelected()) {
				
				p3_2.setVisible(true);
				extras2.setSelectedItem(extrass[0]);
				Cextras.setVisible(true);
				
			} else {

				ExtraActivado = false;
				if(contadorExtra == false) {
					
					total -= 20;
					PrecioTotal.setText("Total................... " + total * num +"€");
					contadorExtra = true;
					
				}
				p3_2.setVisible(false);
				Cextras.setVisible(false);
			}
			
			
		});
		
		

		
		
		
		p3.add(TipoHabitacion);
		p3.add(tipoH);
		p3.add(NumeroHabitaciones);
		spinner(p3, 50);
		this.add(p3);
		p3_1.add(niños);
		this.add(p3_1);
		p3_2.add(edadNiños);
		p3_2.add(panelniños);
		p3_2.add(extras);
		p3_2.add(extras2);
		this.add(p3_2);
		panelFotos();
		
	}
	/**
	 * 
	 */
	//PANEL DE FOTOS
	private void panelFotos() {
		JPanel panelFotos = new JPanel();
		panelFotos.setBackground(pl.azulFondo);
		panelFotos.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, pl.azulMarco));
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBackground(pl.azulOscuro);
		botonAtras.setForeground(pl.dorado);
		contador = 0;
		
		
		JButton botonAdelante = new JButton("Siguiente");
		botonAdelante.setBackground(pl.azulOscuro);
		botonAdelante.setForeground(pl.dorado);
		
		
		Icon icono = new ImageIcon(getClass().getResource("Recursos/Habitacion.jpg"));
		JLabel imagen = new JLabel(icono);
		imagen.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, pl.azulOscuro));;
		
		botonAtras.addActionListener(e->{
			
			if(contador > 0) {
				contador -= 1;
			}
			if(contador == 0) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Habitacion.jpg"));
				imagen.setIcon(icono2);

			}
			if(contador == 1) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Baño.jpg"));
				imagen.setIcon(icono2);

			}
			if(contador == 2) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Comedor.jpg"));
				imagen.setIcon(icono2);

			}
			
			
		});
		
		botonAdelante.addActionListener(e->{
			if(contador < 2) {
				contador += 1;
			}
			if(contador == 0) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Habitacion.jpg"));
				imagen.setIcon(icono2);
			}
			if(contador == 1) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Baño.jpg"));
				imagen.setIcon(icono2);
			}
			if(contador == 2) {
				Icon icono2 = new ImageIcon(getClass().getResource("Recursos/Comedor.jpg"));
				imagen.setIcon(icono2);
			}
			
			
		});
		

		panelFotos.add(botonAtras);
		panelFotos.add(imagen);
		panelFotos.add(botonAdelante);
		this.add(panelFotos);
		
	}
	/**
	 * 
	 */
	
	//SPINNER DE SELECCION DE NUMEROS
	private void spinner(JPanel panel, int Maximo) {
		JButton mas = new  JButton("+");
		mas.setBackground(pl.azulOscuro);
		mas.setForeground(pl.dorado);
		numero = new JLabel("1");
		num = Integer.parseInt (numero.getText());
		numero.setForeground(pl.dorado);
		numero.setBorder(BorderFactory.createEmptyBorder(15,0,15,15));
		panel.add(numero);
		
		mas.addActionListener(e->{
			
			if(num < Maximo) {
				num += 1;
				numero.setText(""+num);
				Habitaciones.setText("Habitaciones Alquiladas "+" ........ " + num );
				PrecioTotal.setText("Total................... " + total * num +"€");
			}
		});
		
		JButton menos = new  JButton("-");
		menos.setBackground(pl.azulOscuro);
		menos.setForeground(pl.dorado);
		menos.addActionListener(e->{

				if(num > 1) {
					num -= 1;
					numero.setText(""+num);
					Habitaciones.setText("Habitaciones Alquiladas "+" ........ " + num );
					PrecioTotal.setText("Total................... " + total * num +"€");
					
				}
				
			
		});
		
		
		panel.add(mas);
		panel.add(menos);
		
		
	}
	//SPINER PARA PANEL NIÑOS---------------------------------------------
	
	/**
	 * @param panel
	 * @param Maximo
	 */
	private void spinner2(JPanel panel, int Maximo) {
		JButton mas = new  JButton("+");
		mas.setBackground(pl.azulOscuro);
		mas.setForeground(pl.dorado);
		numero2 = new JLabel("1");
		edad = Integer.parseInt (numero2.getText());
		numero2.setForeground(pl.dorado);
		numero2.setBorder(BorderFactory.createEmptyBorder(15,0,15,15));
		panel.add(numero2);
		
		mas.addActionListener(e->{
			
			if(edad < Maximo) {
				edad += 1;
				numero2.setText(""+edad);

			}
			if(edad < 3) {
				extras2.setSelectedItem(extrass[1]);
				
			}
			if(edad > 3) {
				extras2.setSelectedItem(extrass[2]);
				
			}
			if(edad > 10) {
				extras2.setSelectedItem(extrass[3]);
				
			}
		});
		
		JButton menos = new  JButton("-");
		menos.setBackground(pl.azulOscuro);
		menos.setForeground(pl.dorado);
		menos.addActionListener(e->{

				if(edad > 1) {
					edad -= 1;
					numero2.setText(""+edad);
					
				}
				
				if(edad < 3) {
					extras2.setSelectedItem(extrass[1]);
					
				}
				if(edad > 3) {
					extras2.setSelectedItem(extrass[2]);
					
				}
				if(edad > 10) {
					extras2.setSelectedItem(extrass[3]);
					
				}
				
			
		});
		
		
		panel.add(mas);
		panel.add(menos);
		
		
	}
}
