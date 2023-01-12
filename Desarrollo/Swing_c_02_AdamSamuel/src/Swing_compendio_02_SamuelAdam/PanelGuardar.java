package Swing_compendio_02_SamuelAdam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Frewp
 *
 */
public class PanelGuardar extends JDialog{
	private JTabbedPane hotel;
	private JPanel p1, p2;
	private PaletaColores pl;
	public PanelGuardar(AltaReserva ventana, boolean modal) {
		
		super(ventana, modal);
		pl = new PaletaColores();
		Dimensiones();
		Datos();
		
		this.setTitle("Previsialuzacion Datos");
		
		Image icono = new ImageIcon(getClass().getResource("Recursos/Logo.jpg")).getImage();
		this.setIconImage(icono);
		
		this.setVisible(true);
		
	}
	
	private void Datos() {
		p1 = new JPanel();
		p1.setName("Datos Cliente");
		p1.setLayout(new BorderLayout());
		p1.setVisible(true);
		panel1();
		
		p2 = new JPanel();
		p2.setName("Datos Habitacion");
		p2.setVisible(true);
		p2.setBackground(Color.lightGray);
		p2.setLayout(new BorderLayout());
		Panel2();
		
		hotel = new JTabbedPane();
		p1.setBackground(Color.lightGray);
		hotel.setVisible(true);
		hotel.add(p1);
		hotel.add(p2);
		this.add(hotel);
		
	}


	private void Panel2() {
		JPanel ptitulo = new JPanel();
		JPanel contenido = new JPanel();
		contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
		JLabel Titulo = new JLabel("Datos de la Habitacion");
		ptitulo.add(Titulo);
		
		
		
		JLabel Nombre = new JLabel("Tipo de Habitacion :    " + Panel3.tipoH.getSelectedItem());
		Nombre.setBorder(BorderFactory.createEmptyBorder(30,15,15,15));
		contenido.add(Nombre);
		
		JLabel Apellido = new JLabel("Numero de Habitaciones alquiladas :    " + Panel3.num);
		Apellido.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		contenido.add(Apellido);
		
		
		if(Panel3.niños.isSelected()) {
			JLabel DNI = new JLabel("Extras :  Si" );
			DNI.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
			contenido.add(DNI);
			
			JLabel Telefono = new JLabel("Edad Hijo Acompañante :    " + Panel3.edad);
			Telefono.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
			contenido.add(Telefono);
			
			JLabel Dias = new JLabel("Seleccion de Extra :    " + Panel3.extras2.getSelectedItem().toString());
			Dias.setBorder(BorderFactory.createEmptyBorder(15,15,15,15)); 
			contenido.add(Dias);
		}
		else {
			JLabel DNI = new JLabel("Extras :  No" );
			DNI.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
			contenido.add(DNI);
		}
		
		
		JLabel Salida = new JLabel("Dias de la estancia:   " + AltaReserva.dias);
		Salida.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		JLabel Pago = new JLabel("Precio Total a pagar: " + Panel3.total * Panel3.num + "€");
		Pago.setBorder(BorderFactory.createEmptyBorder(50,15,15,15));
		
		JLabel Firma = new JLabel("Firma del Hotel No disponible por el momento");
		Firma.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		String texto = "<html><body>El Hotel garantiza una estancia completamente placentera <br> De no poder ser asi tenemos hojas de reclamacion <br>a disposicion del cliente<br><br>Fdo. Hotel Palace Naltar R®</body></html>";	
		JLabel Info = new JLabel(texto);
		Info.setBorder(BorderFactory.createEmptyBorder(60,15,15,15));
		
		
		p2.add(ptitulo, BorderLayout.NORTH);
		p2.add(contenido);
		
		
		
		
		
		contenido.add(Salida);
		contenido.add(Pago);
		contenido.add(Firma);
		contenido.add(Info);
		
	}

	private void panel1() {
		JPanel ptitulo = new JPanel();
		JPanel contenido = new JPanel();
		contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
		JLabel Titulo = new JLabel("Datos del Cliente");
		ptitulo.add(Titulo);
		
		
		
		JLabel Nombre = new JLabel("Nombre del huesped :    " + AltaReserva.CampoNombre.getText());
		Nombre.setBorder(BorderFactory.createEmptyBorder(30,15,15,15));
		JLabel Apellido = new JLabel("Apellidos del mismo :    " + AltaReserva.CampoApellidos.getText());
		Apellido.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		JLabel DNI = new JLabel("Documento de Identidad   (DNI) : " + AltaReserva.CampoDNI.getText());
		DNI.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		JLabel Telefono = new JLabel("Telefono de contacto :    " + AltaReserva.CampoTelefono.getText());
		Telefono.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		JLabel Dias = new JLabel("Estancia en dias :    " + AltaReserva.dias);
		Dias.setBorder(BorderFactory.createEmptyBorder(15,15,15,15)); 
		JLabel Salida = new JLabel("Dia y hora de Salida:   " + AltaReserva.CampoS.getValue());
		Salida.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		JLabel Pago = new JLabel("Metodo de pago Elegido: Efectivo/Tarjeta de credito");
		Pago.setBorder(BorderFactory.createEmptyBorder(50,15,15,15));
		
		JLabel Firma = new JLabel("Firma del cliente No disponible por el momento");
		Firma.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		String texto = "<html><body>El Hotel garantiza una estancia completamente placentera <br> De no poder ser asi tenemos hojas de reclamacion <br>a disposicion del cliente<br><br>Fdo. Hotel Palace Naltar R®</body></html>";	
		JLabel Info = new JLabel(texto);
		Info.setBorder(BorderFactory.createEmptyBorder(60,15,15,15));
		
		
		p1.add(ptitulo, BorderLayout.NORTH);
		p1.add(contenido);
		contenido.add(Nombre);
		contenido.add(Apellido);
		contenido.add(DNI);
		contenido.add(Telefono);
		contenido.add(Dias);
		contenido.add(Salida);
		contenido.add(Pago);
		contenido.add(Firma);
		contenido.add(Info);
		
	}

	private void Dimensiones() {
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int y = dm.height;
		int x = dm.width;
		this.setSize(500, 800);
		this.setLocation(x / 2 - 250, y / 2 - 400);
		
	}

}
