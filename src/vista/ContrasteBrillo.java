/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: ContrasteBrillo.java
  Fecha: 29/10/2014
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelo.Imagenes;
import modelo.ManipuladorImagenes;

// TODO: Auto-generated Javadoc
/**
 * The Class ContrasteBrillo.
 * 
 * @author Sawan
 */
public class ContrasteBrillo {

	/** The Constant TITULO. */
	private final static String TITULO = "Ajuste el brillo y el contraste de la imagen.";

	/** The Constant BRILLO. */
	private final static String BRILLO = "Brillo";

	/** The Constant CONTRASTE. */
	private final static String CONTRASTE = "Contraste";


	/** The Constant BRILLO_ACTUAL. */
	private final static String BRILLO_ACTUAL = "Brillo actual: ";

	/** The Constant CONTRASTE_ACTUAL. */
	private final static String CONTRASTE_ACTUAL = "Contraste actual: ";

	/** The Constant PREVISUALIZAR. */
	private final static String PREVISUALIZAR = "Previsualizar";
	
	/** The Constant REESTABLECER. */
	private final static String REESTABLECER = "Reestablecer";
	
	/** The frame. */
	public JScrollPane scrollpane;

	/** The panel_imagen. */
	public JPanel panel_imagen;

	/** The pic label. */
	public JLabel picLabel;

	/** The lbl_brillo. */
	public JLabel lbl_brillo;

	/** The lbl_contraste. */
	public JLabel lbl_contraste;

	/** The lbl_brillo_actual. */
	public JLabel lbl_brillo_actual;
	
	/** The lbl_contraste_actual. */
	public JLabel lbl_contraste_actual;
	
	/** The lbl_valor_brillo_actual. */
	public JLabel lbl_valor_brillo_actual;
	
	/** The lbl_valor_contraste_actual. */
	public JLabel lbl_valor_contraste_actual;
	
	/** The txt_valor_brillo. */
	public JTextField txt_valor_brillo;
	
	/** The txt_valor_contraste. */
	public JTextField txt_valor_contraste;
	
	/** The btn_preevisualizar. */
	public JButton btn_preevisualizar;
	
	/** The btn_reestablecer. */
	public JButton btn_reestablecer;
	
	/** The imagen. */
	private BufferedImage imagen;
	
	private BufferedImage imagen_resultado;

	/**
	 * Instantiates a new contraste brillo.
	 * 
	 * @param img
	 *            the img
	 */
	public ContrasteBrillo(final Imagenes img) {
		scrollpane = new JScrollPane();
		imagen = Imagenes.deepCopy(img.getImagen());
		
		lbl_brillo = new JLabel(BRILLO);
		lbl_brillo.setBounds(15, 65 + imagen.getHeight(), 50, 16);
		lbl_contraste = new JLabel(CONTRASTE);
		lbl_contraste.setBounds(12, 110 + imagen.getHeight(), 80, 16);
		lbl_brillo_actual = new JLabel(BRILLO_ACTUAL);
		lbl_brillo_actual.setBounds(15, 10 + imagen.getHeight(), 100, 16);
		lbl_contraste_actual = new JLabel(CONTRASTE_ACTUAL);
		lbl_contraste_actual.setBounds(15, 27 + imagen.getHeight(), 125, 16);
		lbl_valor_brillo_actual = new JLabel();
		lbl_valor_brillo_actual.setBounds(120, 10 + imagen.getHeight(), 300, 16);
		lbl_valor_contraste_actual = new JLabel();
		lbl_valor_contraste_actual.setBounds(120, 27 + imagen.getHeight(), 300, 16);
		
		lbl_valor_brillo_actual.setText(Double.toString(ManipuladorImagenes.getBrilloActual(img)));
		lbl_valor_contraste_actual.setText(Double.toString(ManipuladorImagenes.getContrasteActual(img)));
		
		txt_valor_brillo = new JTextField();
		txt_valor_brillo.setBounds(50, 65 + imagen.getHeight(), 40, 16);
		txt_valor_contraste = new JTextField();
		txt_valor_contraste.setBounds(73, 110 + imagen.getHeight(), 40, 16);
		
		btn_preevisualizar = new JButton(PREVISUALIZAR);
		btn_preevisualizar.setBounds(15, 160 + imagen.getHeight(), 120, 16);
		btn_reestablecer = new JButton(REESTABLECER);
		btn_reestablecer.setBounds(150, 160 + imagen.getHeight(), 120, 16);
		
		btn_preevisualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setPrevisualization(Integer.parseInt(txt_valor_contraste.getText()), Integer.parseInt(txt_valor_brillo.getText()), ManipuladorImagenes.getBrilloActual(img), ManipuladorImagenes.getContrasteActual(img));
				Imagenes imagen_temp = new Imagenes();
				imagen_temp.setImagen(imagen);
				lbl_valor_brillo_actual.setText(Double.toString(ManipuladorImagenes.getBrilloActual(imagen_temp)));
				lbl_valor_contraste_actual.setText(Double.toString(ManipuladorImagenes.getContrasteActual(imagen_temp)));
			}
		});
		
		btn_reestablecer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reestablecerValores(img.getImagen());
				panel_imagen.repaint();
				Imagenes imagen_temp = new Imagenes();
				imagen_temp.setImagen(imagen);
				lbl_valor_brillo_actual.setText(Double.toString(ManipuladorImagenes.getBrilloActual(imagen_temp)));
				lbl_valor_contraste_actual.setText(Double.toString(ManipuladorImagenes.getContrasteActual(imagen_temp)));
			}
		});
		
		panel_imagen = new JPanel();
		panel_imagen.setBounds(5, 8, imagen.getWidth(), imagen.getHeight());
		picLabel = new JLabel(new ImageIcon(imagen));

		scrollpane.setLayout(null);
		panel_imagen.add(picLabel);

		scrollpane.add(panel_imagen);
		scrollpane.add(lbl_brillo);
		scrollpane.add(lbl_contraste);
		scrollpane.add(lbl_contraste_actual);
		scrollpane.add(lbl_brillo_actual);
		scrollpane.add(lbl_valor_brillo_actual);
		scrollpane.add(lbl_valor_contraste_actual);
		scrollpane.add(txt_valor_brillo);
		scrollpane.add(txt_valor_contraste);
		scrollpane.add(btn_preevisualizar);
		scrollpane.add(btn_reestablecer);
		
		scrollpane.setPreferredSize(new Dimension(800, 600));
		scrollpane.setVisible(true);
		

		int option_value = JOptionPane.showOptionDialog(null, scrollpane,
				TITULO, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
		
		if (option_value == JOptionPane.OK_OPTION) {
			imagen_resultado = Imagenes.deepCopy(imagen);
		}
		
	}

	
	/**
	 * Sets the previsualization.
	 *
	 * @param valor_k the valor_k
	 * @param valor_t the valor_t
	 * @param brillo_actual the brillo_actual
	 * @param contraste_actual the contraste_actual
	 */
	public void setPrevisualization(int valor_k, int valor_t, double brillo_actual, double contraste_actual) {
		int [] LUT = Imagenes.crearLUT();
		
		double valor_a = getA(valor_k, contraste_actual);
		double valor_b = getB(valor_t, brillo_actual, valor_a);
		
		for (int v_in = 0; v_in < LUT.length; v_in++) {
			LUT[v_in] = (int) ((int) (valor_a * v_in) + valor_b);
			if (LUT[v_in] < 0) {
				LUT[v_in] = Imagenes.MIN_VALOR_PIXEL;
			} else if (LUT[v_in] > Imagenes.MAX_VALOR_PIXEL) {
				LUT[v_in] = Imagenes.MAX_VALOR_PIXEL;
			}
		}
		
		Imagenes.setPixelGrey(imagen, LUT);
		panel_imagen.repaint();
	}
	
	/**
	 * Gets the a.
	 *
	 * @param valor_k the valor_k
	 * @param contraste_actual the contraste_actual
	 * @return the a
	 */
	public double getA(int valor_k, double contraste_actual ) {
		return (contraste_actual + valor_k) / contraste_actual;
	}
	
	/**
	 * Gets the b.
	 *
	 * @param valor_t the valor_t
	 * @param brillo_actual the brillo_actual
	 * @param valor_a the valor_a
	 * @return the b
	 */
	public double getB(int valor_t, double brillo_actual, double valor_a) {
		return (brillo_actual + valor_t) - (valor_a * brillo_actual);
	}
	
	
	/**
	 * Reestablecer valores.
	 *
	 * @param img the img
	 */
	public void reestablecerValores(BufferedImage img) {
		int red;
		int green;
		int blue;
		int alpha;

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				red = new Color(img.getRGB(i, j)).getRed();
				green = new Color(img.getRGB(i, j)).getGreen();
				blue = new Color(img.getRGB(i, j)).getBlue();
				alpha = new Color(imagen.getRGB(i, j)).getAlpha();

				imagen.setRGB(i, j,
						Imagenes.colorToRGB(alpha, red, green, blue));
			}
		}
	}


	/**
	 * @return the imagen
	 */
	public BufferedImage getImagen() {
		return imagen;
	}


	/**
	 * @return the imagen_resultado
	 */
	public BufferedImage getImagen_resultado() {
		return imagen_resultado;
	}
	
	
	
}
