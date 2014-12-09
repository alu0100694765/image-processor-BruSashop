import java.io.IOException;

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
	 */
	public static void main(String[] args) throws IOException {
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
