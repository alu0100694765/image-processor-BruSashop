import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.ManipuladorImagenes;
import vista.InterfazGrafica;
import controlador.Controlador;

// TODO: Auto-generated Javadoc
/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: AppBrusashop.java
  Fecha: 29/09/2014
 */

/**
 * @author Sawan
 *
 */
public class AppBrusashop {

	/** The controlador. */
	private static Controlador controlador;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		// Look And Feel
		UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		
		
		// TODO Auto-generated method stub
		InterfazGrafica grafica = new InterfazGrafica();
		ManipuladorImagenes imagenes = new ManipuladorImagenes();
		setControlador(new Controlador(imagenes, grafica));
	}

	public static Controlador getControlador() {
		return controlador;
	}

	public static void setControlador(Controlador controlador) {
		AppBrusashop.controlador = controlador;
	}

}
