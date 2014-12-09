/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: BottomBar.java
  Fecha: 22/10/2014
 */
package vista;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class BottomBar.
 *
 * @author Sawan
 */
public class BottomBar extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant HEIGHT. */
	public final static int HEIGHT = 16;
	
	/** The Constant HEIGHT_STR. */
	public final static String HEIGHT_STR = "Altura: ";
	
	/** The Constant WIDHT_STR. */
	public final static String WIDHT_STR = "Ancho: ";
	
	/** The Constant RED. */
	public final static String RED = "R: ";
	
	/** The Constant GREEN. */
	public final static String GREEN = "G: ";
	
	/** The Constant BLUE. */
	public final static String BLUE = "B: ";
	
	/** The Constant PIXEL. */
	public final static String PIXEL = "Pixel ";
	
	
	/** The Constant PIXEL_STR. */
	public final static String PIXEL_STR = "px";
	
	/** The lbl_informacion. */
	public JLabel lbl_informacion;
	
	
	
	/**
	 * Instantiates a new bottom bar.
	 *
	 * @param frame_widht the frame_widht
	 */
	public BottomBar(int frame_widht) {
		
		lbl_informacion = new JLabel();
		lbl_informacion.setHorizontalAlignment(SwingConstants.LEFT);
		
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(frame_widht, HEIGHT));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(lbl_informacion);
	}
	
	
	/**
	 * Show rgb.
	 * Muestra en la barra de tareas los valores rgb cuando se pasa el raton
	 * por encima de los pixeles en la imagen.
	 * 
	 * @param r the r
	 * @param g the g
	 * @param b the b
	 * @return the string
	 */
	public String showRGB(int r, int g , int b) {
		String rgb = RED + Integer.toString(r) + "  " + GREEN + Integer.toString(g) + "  " + BLUE +  Integer.toString(b);
		return rgb;
	}
}
