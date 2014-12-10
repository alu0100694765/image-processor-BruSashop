/**
 * 
 */
package modelo;


// TODO: Auto-generated Javadoc
/**
 * The Class Histograma.
 * 
 * @author Sawan
 */
public class Histograma {

	/** The Constant RANGO. */
	private final static int RANGO = 256;
	
	/** The Constant ESCALA. */
	private final static int ESCALA = 200;
	
	/** The imagen. */
	private Imagenes imagen;

	/** The pixel_red. */
	private int[] pixel_red_histograma;

	/** The pixel_green. */
	private int[] pixel_green_histograma;

	/** The pixel_blue. */
	private int[] pixel_blue_histograma;

	/** The pixel_alpha. */
	private int[] pixel_alpha_histograma;

	/** The pixel_red_histograma_acumulativo. */
	private int[] pixel_red_histograma_acumulativo;

	/** The pixel_green_histograma_acumulativo. */
	private int[] pixel_green_histograma_acumulativo;

	/** The pixel_blue_histograma_acumulativo. */
	private int[] pixel_blue_histograma_acumulativo;

	/** The pixel_alpha_histograma_acumulativo. */
	private int[] pixel_alpha_histograma_acumulativo;

	/**
	 * Instantiates a new histograma.
	 * 
	 * @param img
	 *            the img
	 */
	public Histograma(Imagenes img) {

		imagen = img;
		//imagen.clearData();
		imagen.getData();

		pixel_red_histograma = img.getPixel_red().clone();
		pixel_green_histograma = img.getPixel_green().clone();
		pixel_blue_histograma = img.getPixel_blue().clone();
		pixel_alpha_histograma = img.getPixel_alpha().clone();

		
		pixel_red_histograma_acumulativo = img.getPixel_red().clone();
		pixel_green_histograma_acumulativo = img.getPixel_green().clone();
		pixel_blue_histograma_acumulativo = img.getPixel_blue().clone();
		pixel_alpha_histograma_acumulativo = img.getPixel_alpha().clone();	
		
	}

	/**
	 * Gets the histogram.
	 * 
	 * Calcula los valores para formar un histograma rgb.
	 * 
	 * @return the histogram
	 */
	public void getHistogram() {
		for (int i = 0; i < (RANGO); i++) {
			pixel_red_histograma[i] = (int) ((pixel_red_histograma[i] * ESCALA) / (imagen
					.getMaxNumSamplesRed()));
			pixel_green_histograma[i] = (int) ((pixel_green_histograma[i] * ESCALA) / (imagen
					.getMaxNumSamplesGreen()));
			pixel_blue_histograma[i] = (int) ((pixel_blue_histograma[i] * ESCALA) / (imagen
					.getMaxNumSamplesBlue()));
			pixel_alpha_histograma[i] = (int) ((pixel_alpha_histograma[i] * ESCALA) / (imagen
					.getMaxNumSamplesAlpha()));		
		}
		
	}

	/**
	 * Gets the histograma acumulativo.
	 * 
	 * Calula los valores para formar un histograma acumulativo
	 * Va acumulando el valor de los pixeles que va leyendo.
	 * El histograma es una curva ascendente, siempre positiva.
	 * 
	 * @return the histograma acumulativo
	 */
	public void getHistogramaAcumulativo() {
		for (int i = 0; i < (RANGO); i++) {
			if (i == 0) {
				pixel_red_histograma_acumulativo[i] = pixel_red_histograma_acumulativo[i];
				pixel_green_histograma_acumulativo[i] = pixel_green_histograma_acumulativo[i];
				pixel_blue_histograma_acumulativo[i] = pixel_blue_histograma_acumulativo[i];
				pixel_alpha_histograma_acumulativo[i] = pixel_alpha_histograma_acumulativo[i];
			} else {
				pixel_red_histograma_acumulativo[i] = pixel_red_histograma_acumulativo[i] + pixel_red_histograma_acumulativo[i - 1];
				pixel_green_histograma_acumulativo[i] = pixel_green_histograma_acumulativo[i] + pixel_green_histograma_acumulativo[i - 1];
				pixel_blue_histograma_acumulativo[i] = pixel_blue_histograma_acumulativo[i] + pixel_blue_histograma_acumulativo[i - 1];
				pixel_alpha_histograma_acumulativo[i] = pixel_alpha_histograma_acumulativo[i] + pixel_alpha_histograma[i - 1];
			}
		}
		
	}

	
	
	/**
	 * Reinicio datos.
	 * 
	 * Se reestablecen los valores de los vectores que contienen los datos
	 * de la imagen (rgb).
	 * 
	 */
	public void reinicioDatos() {
		
		pixel_red_histograma = imagen.getPixel_red().clone();
		pixel_green_histograma = imagen.getPixel_green().clone();
		pixel_blue_histograma = imagen.getPixel_blue().clone();
		pixel_alpha_histograma = imagen.getPixel_alpha().clone();

		
		pixel_red_histograma_acumulativo = imagen.getPixel_red().clone();
		pixel_green_histograma_acumulativo = imagen.getPixel_green().clone();
		pixel_blue_histograma_acumulativo = imagen.getPixel_blue().clone();
		pixel_alpha_histograma_acumulativo = imagen.getPixel_alpha().clone();	
		
	}
	
	/**
	 * Gets the pixel_red_histograma.
	 *
	 * @return the pixel_red_histograma
	 */
	public int[] getPixel_red_histograma() {
		return pixel_red_histograma;
	}

	/**
	 * Gets the pixel_green_histograma.
	 *
	 * @return the pixel_green_histograma
	 */
	public int[] getPixel_green_histograma() {
		return pixel_green_histograma;
	}

	/**
	 * Gets the pixel_blue_histograma.
	 *
	 * @return the pixel_blue_histograma
	 */
	public int[] getPixel_blue_histograma() {
		return pixel_blue_histograma;
	}

	/**
	 * Gets the pixel_alpha_histograma.
	 *
	 * @return the pixel_alpha_histograma
	 */
	public int[] getPixel_alpha_histograma() {
		return pixel_alpha_histograma;
	}

	/**
	 * Gets the pixel_red_histograma_acumulativo.
	 *
	 * @return the pixel_red_histograma_acumulativo
	 */
	public int[] getPixel_red_histograma_acumulativo() {
		return pixel_red_histograma_acumulativo;
	}

	/**
	 * Gets the pixel_green_histograma_acumulativo.
	 *
	 * @return the pixel_green_histograma_acumulativo
	 */
	public int[] getPixel_green_histograma_acumulativo() {
		return pixel_green_histograma_acumulativo;
	}

	/**
	 * Gets the pixel_blue_histograma_acumulativo.
	 *
	 * @return the pixel_blue_histograma_acumulativo
	 */
	public int[] getPixel_blue_histograma_acumulativo() {
		return pixel_blue_histograma_acumulativo;
	}

	/**
	 * Gets the pixel_alpha_histograma_acumulativo.
	 *
	 * @return the pixel_alpha_histograma_acumulativo
	 */
	public int[] getPixel_alpha_histograma_acumulativo() {
		return pixel_alpha_histograma_acumulativo;
	}

	
}
