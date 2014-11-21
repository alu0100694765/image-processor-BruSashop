/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: ManipuladorImagenes.java
  Fecha: 29/09/2014
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManipuladorImagenes.
 *
 * @author Sawan
 */
/**
 * @author Sawan
 * 
 */
public class Imagenes {

	/** The Constant RANGO. */
	public final static int RANGO = 256;

	/** The Constant MAX_VALOR_PIXEL. */
	public final static int MAX_VALOR_PIXEL = 255;
	
	/** The Constant MIN_VALOR_PIXEL. */
	public final static int MIN_VALOR_PIXEL = 0;
	
	/** The imagen. */
	private BufferedImage imagen;

	/** The image_path. */
	private String image_path;

	/** The pixel_red. */
	private int[] pixel_red;

	/** The pixel_green. */
	private int[] pixel_green;

	/** The pixel_blue. */
	private int[] pixel_blue;

	/** The pixel_alpha. */
	private int[] pixel_alpha;

	/** The valores_red. */
	private int[][] valores_red;

	/** The valores_green. */
	private int[][] valores_green;

	/** The valores_blue. */
	private int[][] valores_blue;

	/** The id. */
	private int id;

	/** The max num samples red. */
	private int maxNumSamplesRed;

	/** The max num samples green. */
	private int maxNumSamplesGreen;

	/** The max num samples blue. */
	private int maxNumSamplesBlue;

	/** The max num samples alpha. */
	private int maxNumSamplesAlpha;

	/** The monocromo. */
	private boolean monocromo;

	/**
	 * Instantiates a new manipulador imagenes.
	 */
	public Imagenes() {
		image_path = null;

		imagen = null;

		id = 0;

		pixel_red = new int[RANGO];
		pixel_green = new int[RANGO];
		pixel_blue = new int[RANGO];
		pixel_alpha = new int[RANGO];

		maxNumSamplesRed = 0;
		maxNumSamplesGreen = 0;
		maxNumSamplesBlue = 0;
		maxNumSamplesAlpha = 0;

		inicializarCero(pixel_red);
		inicializarCero(pixel_green);
		inicializarCero(pixel_blue);
		inicializarCero(pixel_alpha);

		monocromo = false;

	}

	/**
	 * Inicializar cero.
	 * 
	 * Inicializamos el elemento pasado por parametro a cero.
	 */
	public void inicializarCero(int[] elemento) {
		for (int i = 0; i < elemento.length; i++) {
			elemento[i] = 0;
		}
	}

	/**
	 * Gets the data.
	 * 
	 * La utilidad de esta funcion es recoger los datos de una imagen
	 * se recorre la imagen y se van almacenando los valores argb en vectores.
	 *  
	 * @return the data
	 */
	public void getData() {
		valores_red = new int[imagen.getWidth()][imagen.getHeight()];
		valores_green = new int[imagen.getWidth()][imagen.getHeight()];
		valores_blue = new int[imagen.getWidth()][imagen.getHeight()];

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				int alpha = (0xff & (imagen.getRGB(i, j) >> 24));
				int ired = (0xff & (imagen.getRGB(i, j) >> 16));
				int igreen = (0xff & (imagen.getRGB(i, j) >> 8));
				int iblue = (0xff & imagen.getRGB(i, j));

				valores_red[i][j] = ired;
				valores_green[i][j] = igreen;
				valores_blue[i][j] = iblue;

				pixel_alpha[alpha]++;
				if (pixel_alpha[alpha] > maxNumSamplesAlpha) {
					maxNumSamplesAlpha = pixel_alpha[alpha];
				}

				pixel_red[ired]++;
				if (pixel_red[ired] > maxNumSamplesRed) {
					maxNumSamplesRed = pixel_red[ired];
				}

				pixel_green[igreen]++;
				if (pixel_green[igreen] > maxNumSamplesGreen) {
					maxNumSamplesGreen = pixel_green[igreen];
				}

				pixel_blue[iblue]++;
				if (pixel_blue[iblue] > maxNumSamplesBlue) {
					maxNumSamplesBlue = pixel_blue[iblue];
				}
			}
		}
	}

	/**
	 * Clear data.
	 * 
	 * Limpia los datos de la imagen en cuestion.
	 */
	public void clearData() {
		pixel_red = new int[RANGO];
		pixel_green = new int[RANGO];
		pixel_blue = new int[RANGO];
		pixel_alpha = new int[RANGO];

		maxNumSamplesRed = 0;
		maxNumSamplesGreen = 0;
		maxNumSamplesBlue = 0;
		maxNumSamplesAlpha = 0;

		inicializarCero(pixel_red);
		inicializarCero(pixel_green);
		inicializarCero(pixel_blue);
		inicializarCero(pixel_alpha);
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the valores_red.
	 * 
	 * @param valores_red
	 *            the valores_red to set
	 */
	public void setValores_red(int[][] valores_red) {
		this.valores_red = valores_red;
	}

	/**
	 * Sets the valores_green.
	 * 
	 * @param valores_green
	 *            the valores_green to set
	 */
	public void setValores_green(int[][] valores_green) {
		this.valores_green = valores_green;
	}

	/**
	 * Sets the valores_blue.
	 * 
	 * @param valores_blue
	 *            the valores_blue to set
	 */
	public void setValores_blue(int[][] valores_blue) {
		this.valores_blue = valores_blue;
	}

	/**
	 * Gets the rango.
	 * 
	 * @return the rango
	 */
	public static int getRango() {
		return RANGO;
	}

	/**
	 * Gets the valores_red.
	 * 
	 * @return the valores_red
	 */
	public int[][] getValores_red() {
		return valores_red;
	}

	/**
	 * Gets the valores_green.
	 * 
	 * @return the valores_green
	 */
	public int[][] getValores_green() {
		return valores_green;
	}

	/**
	 * Gets the valores_blue.
	 * 
	 * @return the valores_blue
	 */
	public int[][] getValores_blue() {
		return valores_blue;
	}

	/**
	 * Gets the max num samples red.
	 * 
	 * @return the maxNumSamplesRed
	 */
	public int getMaxNumSamplesRed() {
		return maxNumSamplesRed;
	}

	/**
	 * Sets the max num samples red.
	 * 
	 * @param maxNumSamplesRed
	 *            the maxNumSamplesRed to set
	 */
	public void setMaxNumSamplesRed(int maxNumSamplesRed) {
		this.maxNumSamplesRed = maxNumSamplesRed;
	}

	/**
	 * Gets the max num samples green.
	 * 
	 * @return the maxNumSamplesGreen
	 */
	public int getMaxNumSamplesGreen() {
		return maxNumSamplesGreen;
	}

	/**
	 * Sets the max num samples green.
	 * 
	 * @param maxNumSamplesGreen
	 *            the maxNumSamplesGreen to set
	 */
	public void setMaxNumSamplesGreen(int maxNumSamplesGreen) {
		this.maxNumSamplesGreen = maxNumSamplesGreen;
	}

	/**
	 * Gets the max num samples blue.
	 * 
	 * @return the maxNumSamplesBlue
	 */
	public int getMaxNumSamplesBlue() {
		return maxNumSamplesBlue;
	}

	/**
	 * Sets the max num samples blue.
	 * 
	 * @param maxNumSamplesBlue
	 *            the maxNumSamplesBlue to set
	 */
	public void setMaxNumSamplesBlue(int maxNumSamplesBlue) {
		this.maxNumSamplesBlue = maxNumSamplesBlue;
	}

	/**
	 * Gets the max num samples alpha.
	 * 
	 * @return the maxNumSamplesAlpha
	 */
	public int getMaxNumSamplesAlpha() {
		return maxNumSamplesAlpha;
	}

	/**
	 * Sets the max num samples alpha.
	 * 
	 * @param maxNumSamplesAlpha
	 *            the maxNumSamplesAlpha to set
	 */
	public void setMaxNumSamplesAlpha(int maxNumSamplesAlpha) {
		this.maxNumSamplesAlpha = maxNumSamplesAlpha;
	}

	/**
	 * Gets the pixel_red.
	 * 
	 * @return the pixel_red
	 */
	public int[] getPixel_red() {
		return pixel_red;
	}

	/**
	 * Gets the pixel_green.
	 * 
	 * @return the pixel_green
	 */
	public int[] getPixel_green() {
		return pixel_green;
	}

	/**
	 * Gets the pixel_blue.
	 * 
	 * @return the pixel_blue
	 */
	public int[] getPixel_blue() {
		return pixel_blue;
	}

	/**
	 * Gets the pixel_alpha.
	 * 
	 * @return the pixel_alpha
	 */
	public int[] getPixel_alpha() {
		return pixel_alpha;
	}

	/**
	 * Gets the image_path.
	 * 
	 * @return the image_path
	 */
	public String getImage_path() {
		return image_path;
	}

	/**
	 * Sets the image_path.
	 * 
	 * @param image_path
	 *            the image_path to set
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setImage_path(String image_path) throws IOException {
		this.image_path = image_path;
		imagen = ImageIO.read(new File(image_path));
	}

	/**
	 * Gets the imagen.
	 * 
	 * @return the imagen
	 */
	public BufferedImage getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 * 
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(BufferedImage imagen) {
		this.imagen = deepCopy(imagen);
		clearData();
		getData();
	}

	/**
	 * Cambia imagen.
	 * 
	 * Se cambian los valores de color de la imagen.
	 */
	public void cambiaImagen() {
		Color color;
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				color = new Color(valores_red[i][j], valores_green[i][j],
						valores_blue[i][j]);
				imagen.setRGB(i, j, color.getRGB());
			}
		}
	}

	/**
	 * Sets the pixel grey.
	 *
	 * Se establecen todos los pixeles de la imagen
	 * a gris segun la LUT que se ha proporcionado.
	 */
	public void setPixelGrey(int[] LUT) {
		clearData();
		int pixel = 0;
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				pixel = this.getRedPoint(i, j);
				Color color = new Color(LUT[pixel], LUT[pixel], LUT[pixel]);
				imagen.setRGB(i, j, color.getRGB());
			}
		}
		getData();
	}
	
	public static void setPixelGrey(BufferedImage imagen ,int[] LUT) {
		int pixel = 0;
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				pixel = getRedPoint(imagen ,i, j);
				Color color = new Color(LUT[pixel], LUT[pixel], LUT[pixel]);
				imagen.setRGB(i, j, color.getRGB());
			}
		}
	}
	
	public void setDigitalizacion(int muestreo_1, int muestreo_2, int [] LUT){
		int i = 0;
		int j = 0;
		int avanceJ = 0;
		int avanceI = 0;
		int pixel_i = 0;
		int pixel_j = 0;
		int muestreo_original_1 = muestreo_1;
		int muestreo_original_2 = muestreo_2;
		boolean visitado = false;
		Color color;

		for( ; i < muestreo_1 + 1; i++ ){

			if(i == muestreo_1){
				i = i - avanceI;
				avanceI = 0;
			}
			
			color = new Color(LUT[valores_red[pixel_i][pixel_j]], LUT[valores_red[pixel_i][pixel_j]], LUT[valores_red[pixel_i][pixel_j]]);
			
			for( ; j < muestreo_2; j++){
				imagen.setRGB(i, j, color.getRGB());
				avanceJ++;
			}
			
			if(i < muestreo_1 - 1){
				j = j - avanceJ;
				avanceJ = 0;
			}
			
			else{
				if(muestreo_2 >= imagen.getHeight()){
					if(visitado)
						i++;
					
					j = 0;
					
					avanceJ = 0;
					avanceI = 0;
					
					muestreo_1 += muestreo_original_1;
					muestreo_2 = muestreo_original_2;
					
					pixel_i = i;
					pixel_j = j;
					
					if(muestreo_1 >= imagen.getWidth()){
						muestreo_1 = imagen.getWidth();
						visitado = true;
					}
				}
				else{
					avanceJ = 0;
				
					pixel_i = i;
					pixel_j = j;
				
					muestreo_2 += muestreo_original_2;
				
					if(muestreo_2 >= imagen.getHeight()){
						muestreo_2 = imagen.getHeight();
					
					}
				}
			}
			avanceI++;
		}
		clearData();
		getData();
	}
	
	/**
	 * Deep copy.
	 *
	 * @param bi the bi
	 * @return the buffered image
	 */
	public static BufferedImage deepCopy(BufferedImage bi) {
		BufferedImage b = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(bi, 0, 0, null);
	    g.dispose();
	    return b;
		}
	
	/**
	 * Sets the pixel unit.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param red the red
	 * @param green the green
	 * @param blue the blue
	 */
	public void setPixelUnit(int posX, int posY, int red, int green, int blue){
		Color color = new Color(red, green, blue);
		imagen.setRGB(posX, posY, color.getRGB());
	}
	
	/**
	 * Sets the pixel unit image.
	 *
	 * @param imagen the imagen
	 * @param posX the pos x
	 * @param posY the pos y
	 * @param red the red
	 * @param green the green
	 * @param blue the blue
	 */
	public static void setPixelUnitImage(BufferedImage imagen ,int posX, int posY, int red, int green, int blue){
		Color color = new Color(red, green, blue);
		imagen.setRGB(posX, posY, color.getRGB());
	}
	
	/**
	 * Sets the pixel to red.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 */
	public void setPixelToRed(int posX, int posY){
		int redConversion = 255;
		int greenConversion = 0;
		int blueConversion = 0;
		
		Color rojo = new Color(redConversion, greenConversion, blueConversion);
		imagen.setRGB(posX, posY, rojo.getRGB());
	}
	
	/**
	 * Sets the pixel to green.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 */
	public void setPixelToGreen(int posX, int posY){
		int redConversion = 0;
		int greenConversion = 255;
		int blueConversion = 0;
		
		Color verde = new Color(redConversion, greenConversion, blueConversion);
		imagen.setRGB(posX, posY, verde.getRGB());
	}
	
	/**
	 * Sets the pixel to blue.
	 *
	 * @param posX the pos x
	 * @param posY the pos y
	 */
	public void setPixelToBlue(int posX, int posY){
		int redConversion = 0;
		int greenConversion = 0;
		int blueConversion = 255;
		
		Color azul = new Color(redConversion, greenConversion, blueConversion);
		imagen.setRGB(posX, posY, azul.getRGB());
	}

	
	/**
	 * Color to rgb.
	 * 
	 * @param alpha
	 *            the alpha
	 * @param red
	 *            the red
	 * @param green
	 *            the green
	 * @param blue
	 *            the blue
	 * @return the int
	 */
	public static int colorToRGB(int alpha, int red, int green, int blue) {

		int newPixel = 0;
		newPixel += alpha;
		newPixel = newPixel << 8;
		newPixel += red;
		newPixel = newPixel << 8;
		newPixel += green;
		newPixel = newPixel << 8;
		newPixel += blue;

		return newPixel;

	}

	/**
	 * Truncar.
	 *
	 * @param valor the valor
	 * @return the int
	 */
	public static int truncar(int valor) {
		if (valor < MIN_VALOR_PIXEL) {
			valor = MIN_VALOR_PIXEL;
		} else if (valor > MAX_VALOR_PIXEL) {
			valor =  MAX_VALOR_PIXEL;
		}
		return valor;
	}
	
	/**
	 * Gets the red point.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the red point
	 */
	public int getRedPoint(int x, int y) {
		return (0xff & (imagen.getRGB(x, y) >> 16));
	}

	public static int getRedPoint(BufferedImage imagen ,int x, int y) {
		return (0xff & (imagen.getRGB(x, y) >> 16));
	}
	
	/**
	 * Gets the green point.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the green point
	 */
	public int getGreenPoint(int x, int y) {
		return (0xff & (imagen.getRGB(x, y) >> 8));
	}

	/**
	 * Gets the blue point.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the blue point
	 */
	public int getBluePoint(int x, int y) {
		return (0xff & (imagen.getRGB(x, y)));
	}

	/**
	 * Checks if is monocromo.
	 */
	public void isMonocromo() {
		monocromo = true;
		int red, green, blue;

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				red = getRedPoint(i, j);
				green = getGreenPoint(i, j);
				blue = getBluePoint(i, j);

				if ((red != green) || (red != blue) || (green != blue)) {
					monocromo = false;
					break;
				}
			}
			if (!monocromo) {
				break;
			}
		}
	}
	
	/**
	 * Es monocromo.
	 *
	 * @return true, if successful
	 */
	public boolean esMonocromo() {
		return monocromo;
	}

	/**
	 * Sets the monocromo.
	 *
	 * @param monocromo            the monocromo to set
	 */
	public void setMonocromo(boolean monocromo) {
		this.monocromo = monocromo;
	}
	
	public static int[] crearLUT() {
		int[] LUT = new int[RANGO];
		for (int i = 0; i < LUT.length; i++) {
			LUT[i] = i;
		}
		return LUT;
	}

}
