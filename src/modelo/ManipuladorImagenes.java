/**
 *Autores: Sawan Kapai Harpalani, Bruno Alessio Bibb�.
  Correo electronico : alu0100694765@ull.edu.es, alu0100697063@ull.edu.es
  Nombre fichero: ManipuladorImagenes.java
  Fecha: 22/10/2014
 */
package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import vista.PlotHistograma;

// TODO: Auto-generated Javadoc
/**
 * The Class ManipuladorImagenes.
 */
public class ManipuladorImagenes {

	/** The acumulador_imagenes. */
	private ArrayList<Imagenes> acumulador_imagenes;

	/** The imagen_actual. */
	private int imagen_actual;

	/** The histograma. */
	private Histograma histograma;

	/** The plot histograma. */
	private PlotHistograma plotHistograma;

	/**
	 * Instantiates a new manipulador imagenes.
	 */
	public ManipuladorImagenes() {
		acumulador_imagenes = new ArrayList<Imagenes>();
		imagen_actual = 0;
	}

	/**
	 * Crear imagen.
	 * 
	 * Constructor de imagenes para el manipulador.
	 * 
	 * Se encarga de aniadir una nueva imagen al manipulador cada vez que se
	 * abre o se realiza una operaci�n sobre una imagen.
	 * 
	 * - Se le aniade un identificador. - Se aniade al acumulador de imagenes
	 * del manipulador. - Se determina cual es la imagen actual (nueva imagen).
	 * - Se determina si la imagen es monocromo.
	 * 
	 * @param img
	 *            the img
	 */

	public void crearImagen(Imagenes img) {
		img.setId(acumulador_imagenes.size());
		acumulador_imagenes.add(img);
		imagen_actual = acumulador_imagenes.size() - 1;
		acumulador_imagenes.get(imagen_actual).isMonocromo();
	}

	/**
	 * Crear gris.
	 * 
	 * Genera una nueva imagen en monocromo. Tono de gris en formato: PAL.
	 */

	public void crearGris() {
		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		int red, green, blue, colorGrisPal;

		for (int i = 0; i < acumulador_imagenes.get(imagen_actual).getImagen()
				.getWidth(); i++) {
			for (int j = 0; j < acumulador_imagenes.get(imagen_actual)
					.getImagen().getHeight(); j++) {

				red = acumulador_imagenes.get(imagen_actual).getRedPoint(i, j);
				green = acumulador_imagenes.get(imagen_actual).getGreenPoint(i,
						j);
				blue = acumulador_imagenes.get(imagen_actual)
						.getBluePoint(i, j);

				colorGrisPal = (int) ((0.222 * red) + (0.707 * green) + (0.071 * blue));

				nuevaImagen.setPixelUnit(i, j, colorGrisPal, colorGrisPal,
						colorGrisPal);
			}
		}

		nuevaImagen.clearData();
		nuevaImagen.getData();

		crearImagen(nuevaImagen);
	}

	/**
	 * Crear histograma.
	 * 
	 * Construye el histograma de la imagen actual.
	 */

	public void crearHistograma() {
		histograma = new Histograma(acumulador_imagenes.get(imagen_actual));
		plotHistograma = new PlotHistograma(histograma);
	}

	/**
	 * Plot histograma.
	 * 
	 * Procesa los datos del histograma de la imagen actual para pintarlo en
	 * pantalla.
	 */

	public void plotHistograma() {
		histograma.reinicioDatos();
		histograma.getHistogram();
		plotHistograma.plotHistograma();
	}

	/**
	 * Plot histograma acumulativo.
	 * 
	 * Procesa los datos del histograma acumulativo de la imagen actual para
	 * pintarlo en pantalla.
	 */

	public void plotHistogramaAcumulativo() {
		histograma.reinicioDatos();
		histograma.getHistogramaAcumulativo();
		plotHistograma.plotHistogramaAcumulativo();
	}

	/**
	 * Ecualizar histograma.
	 * 
	 * Realiza la ecualizaci�n del histograma acumulativo de la imagen
	 * actualmente seleccionada.
	 * 
	 * * Procedimiento: - Creamos una nueva imagen (parte de la imagen actual).
	 * - Creamos su histograma acumulativo. - Para cada valor del pixel: -
	 * maximo(0, (Rango_pixel/n�_pixeles_imagen) *
	 * valor_histograma_acumulativo(V_in))
	 * 
	 * Donde V_in es el pixel que miramos en ese momento (0 - 255). - Se
	 * establecen los nuevos valores a la imagen anteriormente creada. -
	 * Aniadimos la imagen al manipulador de imagenes.
	 */

	public void ecualizarHistograma() {
		int[] LUT = new int[Imagenes.getRango()];

		double rango;
		double dimensiones;
		double primera_operacion;

		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		crearImagen(nuevaImagen);

		crearHistograma();
		histograma.getHistogramaAcumulativo();

		rango = Imagenes.getRango();
		dimensiones = (acumulador_imagenes.get(imagen_actual).getImagen()
				.getWidth() * acumulador_imagenes.get(imagen_actual)
				.getImagen().getHeight());

		primera_operacion = rango / dimensiones;

		for (int i = 0; i < LUT.length; i++) {
			LUT[i] = Math.max(0, Math
					.round((int) (primera_operacion * histograma
							.getPixel_red_histograma_acumulativo()[i])));

			if (LUT[i] == Imagenes.getRango())
				LUT[i] = Imagenes.getRango() - 1;
		}

		acumulador_imagenes.get(imagen_actual).setPixelGrey(LUT);
	}

	/**
	 * Especificar histograma.
	 * 
	 * Realiza la especificaci�n del histograma acumulativo normalizado de la
	 * imagen actual y la susodicha elegida a especificar.
	 * 
	 * * Procedimiento: - Creamos una nueva imagen (parte de la imagen actual).
	 * - Calculamos los valores del histograma acumulativo normalizado de cada
	 * imagen. - Para cada uno de los valores del pixel (i) = (0 - 255): -
	 * Mientras no se llegue al rango maximo (j) = (0 - 255): - si
	 * (valor_imagen_1[i] - valor_imagen_2[j]) <= (valor_imagen_1[i] -
	 * valor_imagen_2[j-1]): - Valor_pixel[i] = j - sino - Valor_pixel[i] = j-1
	 * - Se establecen los nuevos valores a la imagen anteriormente creada. -
	 * Aniadimos la imagen al manipulador de imagenes.
	 * 
	 * @param histogramaEspecificado
	 *            the histograma especificado
	 */

	public void especificarHistograma(int histogramaEspecificado) {
		int[] LUT = new int[Imagenes.getRango()];

		int iteradorJ = 0;

		double primeraResta;
		double segundaResta;

		double dimensionImagen1 = acumulador_imagenes.get(imagen_actual)
				.getImagen().getWidth()
				* acumulador_imagenes.get(imagen_actual).getImagen()
						.getHeight();

		double dimensionImagen2 = acumulador_imagenes
				.get(histogramaEspecificado).getImagen().getWidth()
				* acumulador_imagenes.get(histogramaEspecificado).getImagen()
						.getHeight();

		double valor_histograma_1;
		double valor_histograma_2;
		double valor_histograma_2_anterior;

		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		crearHistograma();
		histograma.getHistogramaAcumulativo();

		Histograma histogramaSegundaImagen = new Histograma(
				acumulador_imagenes.get(histogramaEspecificado));

		histogramaSegundaImagen.getHistogramaAcumulativo();

		for (int i = 0; i < LUT.length; i++) {
			iteradorJ = 1;

			while (true) {
				valor_histograma_1 = histograma
						.getPixel_red_histograma_acumulativo()[i];
				valor_histograma_2 = histogramaSegundaImagen
						.getPixel_red_histograma_acumulativo()[iteradorJ];
				valor_histograma_2_anterior = histogramaSegundaImagen
						.getPixel_red_histograma_acumulativo()[iteradorJ - 1];

				valor_histograma_1 = valor_histograma_1 / dimensionImagen1;
				valor_histograma_2 = valor_histograma_2 / dimensionImagen2;
				valor_histograma_2_anterior = valor_histograma_2_anterior
						/ dimensionImagen2;

				if (valor_histograma_1 < valor_histograma_2
						|| iteradorJ == Imagenes.getRango() - 1)
					break;
				else
					iteradorJ++;
			}

			primeraResta = Math.abs(valor_histograma_2 - valor_histograma_1);

			segundaResta = Math.abs(valor_histograma_2_anterior
					- valor_histograma_1);

			if (primeraResta <= segundaResta
					|| iteradorJ == Imagenes.getRango() - 1)
				LUT[i] = iteradorJ;
			else
				LUT[i] = iteradorJ - 1;
		}

		crearImagen(nuevaImagen);
		acumulador_imagenes.get(imagen_actual).setPixelGrey(LUT);

	}

	/**
	 * Correccion gamma.
	 * 
	 * Realizacion de la correccion gamma de una imagen.
	 * 
	 * * Procedimiento: - Creamos una nueva imagen (parte de la imagen actual).
	 * - Para cada uno de los valores del pixel (i): - Normalizamos el valor del
	 * pixel (i / n� maximo pixeles). - Elevamos el valor normalizado del pixel
	 * al valor gamma (pixel_normalizado ^ valor_gamma). - Establecemos el valor
	 * calculado al rango de valores (0 - 255). - Se establecen los nuevos
	 * valores a la imagen anteriormente creada. - Aniadimos la imagen al
	 * manipulador de imagenes.
	 * 
	 * @param valorGamma
	 *            the valor gamma
	 */
	public void correccionGamma(double valorGamma) {
		int[] LUT = new int[Imagenes.getRango()];

		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		double rango = Imagenes.getRango() - 1;

		double pixelNormalizado;
		double pixelNormalizadoGamma;

		for (double i = 0; i < LUT.length; i++) {
			pixelNormalizado = i / rango;
			pixelNormalizadoGamma = Math.pow(pixelNormalizado, valorGamma);
			LUT[(int) (i)] = (int) (pixelNormalizadoGamma * rango);
		}

		crearImagen(nuevaImagen);
		acumulador_imagenes.get(imagen_actual).setPixelGrey(LUT);

	}

	/**
	 * Diferencia imagenes lut.
	 * 
	 * Calcula las diferencias de los pixeles de una imagen, comparandolos con
	 * un umbral, para establecer si ese pixel ha cambiado o no.
	 * 
	 * @param umbral
	 *            the umbral
	 * @return the boolean[]
	 */

	public boolean[] diferenciaImagenesLUT(int umbral) {
		boolean[] LUT = new boolean[Imagenes.getRango()];

		for (int i = 0; i < LUT.length; i++) {
			if (i >= umbral)
				LUT[i] = true;
			else
				LUT[i] = false;
		}

		return LUT;
	}

	/**
	 * Resta imagenes.
	 * 
	 * Se realiza la resta de dos imagenes para establecer sus cambios.
	 * 
	 * * Procedimiento: - Creamos una nueva imagen (parte de la imagen actual).
	 * - Para cada uno de los pixeles de la nueva imagen: - Establecemos el
	 * valor del pixel a la resta de los valores de los pixeles de las imagenes.
	 * - Devolvemos la imagen que contiene la resta.
	 * 
	 * @param imagen2
	 *            the imagen2
	 * @return the imagenes
	 */

	public Imagenes restaImagenes(int imagen2) {
		int resta = 0;

		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		int widthImage1 = acumulador_imagenes.get(imagen_actual).getImagen()
				.getWidth();
		int heightImage1 = acumulador_imagenes.get(imagen_actual).getImagen()
				.getHeight();

		int widthImage2 = acumulador_imagenes.get(imagen2).getImagen()
				.getWidth();
		int heightImage2 = acumulador_imagenes.get(imagen2).getImagen()
				.getHeight();

		for (int i = 0; i < widthImage1; i++) {
			for (int j = 0; j < heightImage1; j++) {
				if (i >= widthImage2 || j >= heightImage2) {
					nuevaImagen.setPixelUnit(i, j, 0, 0, 0);
				}

				else {
					resta = Math.abs(acumulador_imagenes.get(imagen_actual)
							.getRedPoint(i, j)
							- acumulador_imagenes.get(imagen2)
									.getRedPoint(i, j));

					nuevaImagen.setPixelUnit(i, j, resta, resta, resta);
				}
			}
		}

		nuevaImagen.clearData();
		nuevaImagen.getData();

		return nuevaImagen;
	}

	/**
	 * Diferencia de imagenes.
	 * 
	 * Realiza la diferencia de la imagenes para sacar una nueva imagen donde se
	 * muestre los cambios entre las dos imagenes en rojo.
	 * 
	 * * Procedimiento: - Creamos una nueva imagen (parte de la imagen actual).
	 * - Por cada fila de la imagen (i): - Por cada columna de la imagen (j): -
	 * Si el pixel de la imagen se ha establecido como cambio, se establece ese
	 * pixel de la nueva imagen a color rojo. - Aniadimos la imagen al
	 * manipulador de imagenes.
	 * 
	 * @param imagenCopia
	 *            the imagen copia
	 * @param LUT
	 *            the lut
	 */

	public void diferenciaDeImagenes(Imagenes imagenCopia, boolean[] LUT) {
		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		int widthImage = acumulador_imagenes.get(imagen_actual).getImagen()
				.getWidth();
		int heightImage = acumulador_imagenes.get(imagen_actual).getImagen()
				.getHeight();

		for (int i = 0; i < widthImage; i++) {
			for (int j = 0; j < heightImage; j++) {
				if (LUT[imagenCopia.getRedPoint(i, j)]) {
					nuevaImagen.setPixelToRed(i, j);
				}
			}
		}

		nuevaImagen.clearData();
		nuevaImagen.getData();

		crearImagen(nuevaImagen);
	}

	/**
	 * Gets the number ocurrencias.
	 * 
	 * @param valor
	 *            the valor
	 * @param pixeles
	 *            the pixeles
	 * @return the number ocurrencias
	 */
	public static int getNumberOcurrencias(int valor, int[] pixeles) {
		return pixeles[valor];
	}

	/**
	 * P v_in.
	 * 
	 * - p(V_in): Probabilidad del nivel de gris V_in de la imagen.
	 * 
	 * @param valor
	 *            the valor
	 * @param pixeles
	 *            the pixeles
	 * @param numero_col
	 *            the numero_col
	 * @param numero_fil
	 *            the numero_fil
	 * @return the double
	 */
	public static double pV_in(int valor, int[] pixeles, int numero_col,
			int numero_fil) {
		return (double) getNumberOcurrencias(valor, pixeles)
				/ (numero_col * numero_fil);
	}

	/**
	 * Gets the entropia. - Entropía: Calcula el valor de la entropia, solo para
	 * imagenes en gris.
	 * 
	 * Entropía = desde V_in = 0 hasta 255 - ∑ ( p(V_in) * log( p(V_in) ) )
	 * 
	 * @param pixeles
	 *            the pixeles
	 * @param numero_columnas
	 *            the numero_columnas
	 * @param numero_filas
	 *            the numero_filas
	 * @return the entropia
	 */
	public double getEntropia(int[] pixeles, int numero_columnas,
			int numero_filas) {
		double entropia = 0;
		double primerOperando;
		for (int i = 0; i < pixeles.length; i++) {
			primerOperando = pV_in(i, pixeles, numero_columnas, numero_filas);

			if (primerOperando != 0)
				entropia += primerOperando
						* (Math.log(primerOperando) / Math.log(2));

		}
		return Math.abs(entropia);
	}

	/**
	 * Binarize. Binarizar # Se pide el valor a partir del cual se quiere
	 * binarizar la imagen (v).
	 * 
	 * # Construir una LUT igual que en el caso anterior.
	 * 
	 * # Por cada valor de V_in desde 0 a v - 1 que tome V_out, la
	 * transformación para V_out será un 0.
	 * 
	 * # Por cada valor de V_in desde v a 255 que tome V_out, la transformación
	 * para V_out será un 255.
	 * 
	 * @param original
	 *            the original
	 * @param umbral
	 *            the umbral
	 * @return the buffered image
	 */
	public BufferedImage binarize(BufferedImage original, int umbral) {

		int pixel;
		int newPixel;

		int threshold = umbral;

		BufferedImage binarized = new BufferedImage(original.getWidth(),
				original.getHeight(), original.getType());

		for (int i = 0; i < original.getWidth(); i++) {
			for (int j = 0; j < original.getHeight(); j++) {

				// Get pixels
				pixel = new Color(original.getRGB(i, j)).getRed();
				int alpha = new Color(original.getRGB(i, j)).getAlpha();
				if (pixel > threshold) {
					newPixel = Imagenes.MAX_VALOR_PIXEL;
				} else {
					newPixel = Imagenes.MIN_VALOR_PIXEL;
				}
				newPixel = Imagenes.colorToRGB(alpha, newPixel, newPixel,
						newPixel);
				binarized.setRGB(i, j, newPixel);

			}
		}

		return binarized;

	}

	/**
	 * Gets the brillo actual.
	 * 
	 * Calcula el brillo actual dado un objeto tipo imagen.
	 * 
	 * @param image
	 *            the image
	 * @return the brillo actual
	 */
	public static double getBrilloActual(Imagenes image) {
		double brillo_actual = 0;

		for (int v_in = 0; v_in < Imagenes.RANGO; v_in++) {
			brillo_actual += (v_in * pV_in(v_in, image.getPixel_red(), image
					.getImagen().getWidth(), image.getImagen().getHeight()));
		}

		return brillo_actual;
	}

	/**
	 * Gets the contraste actual.
	 * 
	 * Calcula el contraste actual dada una imagen.
	 * 
	 * @param image
	 *            the image
	 * @return the contraste actual
	 */
	public static double getContrasteActual(Imagenes image) {
		double contraste_actual = 0;
		double brillo_actual = getBrilloActual(image);

		for (int vi_in = 0; vi_in < Imagenes.RANGO; vi_in++) {
			double base = (vi_in - brillo_actual);
			contraste_actual += (Math.pow(base, 2) * pV_in(vi_in,
					image.getPixel_red(), image.getImagen().getWidth(), image
							.getImagen().getHeight()));
		}

		return Math.sqrt(contraste_actual);
	}

	/**
	 * Digitalizacion de imagen.
	 * 
	 * @param muestreo_1
	 *            the muestreo_1
	 * @param muestreo_2
	 *            the muestreo_2
	 * @param cuantizacion
	 *            the cuantizacion
	 */

	public void digitalizar(int muestreo_1, int muestreo_2, int cuantizacion) {
		Imagenes nuevaImagen = new Imagenes();
		nuevaImagen.setImagen(acumulador_imagenes.get(imagen_actual)
				.getImagen());

		int[] LUT = new int[Imagenes.getRango()];

		int umbral_n_muestras = (int) (Imagenes.getRango() / Math.pow(2,
				cuantizacion));
		int sumando = umbral_n_muestras;

		for (int i = 0; i < LUT.length; i++) {
			if (i < sumando)
				LUT[i] = sumando;
			else {
				sumando += umbral_n_muestras;
				if (sumando >= Imagenes.getRango())
					sumando = Imagenes.getRango() - 1;
				LUT[i] = sumando;
			}
		}

		nuevaImagen.setDigitalizacion(muestreo_1, muestreo_2, LUT);
		crearImagen(nuevaImagen);
	}

	/**
	 * Espejo vertical.
	 * 
	 * El espejo vertical se consigue realizando
	 * un cambio de filas en la matriz de la imagen.
	 * 
	 * @param image
	 *            the image
	 * @return the buffered image
	 */
	public BufferedImage espejoVertical(BufferedImage image) {
		BufferedImage image_result;

		int[][] matriz_imagen = Imagenes.getPixelMatrix(image);

		swapRows(matriz_imagen, matriz_imagen.length);

		image_result = Imagenes.deepCopy(Imagenes
				.crearImagenMatriz(matriz_imagen));

		return image_result;
	}

	/**
	 * Espejo horizontal.
	 * 
	 * El espejo horizontal se consigue realizando
	 * un cambio de columnas en la matriz de la imagen.
	 * 
	 * @param image
	 *            the image
	 * @return the buffered image
	 */
	public BufferedImage espejoHorizontal(BufferedImage image) {
		BufferedImage image_result;

		int[][] matriz_imagen = Imagenes.getPixelMatrix(image);

		swapColumns(matriz_imagen, matriz_imagen[0].length);

		image_result = Imagenes.deepCopy(Imagenes
				.crearImagenMatriz(matriz_imagen));

		return image_result;
	}

	/**
	 * Traspuesta imagen.
	 * 
	 * @param image
	 *            the image
	 * @return the buffered image
	 */
	public BufferedImage traspuestaImagen(BufferedImage image) {
		BufferedImage image_result;

		int[][] matriz_imagen = Imagenes.getPixelMatrix(image);

		int[][] matriz_traspuesta_imagen = transpose(matriz_imagen,
				matriz_imagen.length, matriz_imagen[0].length);

		image_result = Imagenes.deepCopy(Imagenes
				.crearImagenMatriz(matriz_traspuesta_imagen));

		return image_result;
	}

	/**
	 * Rotacion.
	 * 
	 * Se rota la imagen en funcion del angulo (90º, 180º, 270º)
	 * Si el angulo es 90º: Basta con hallar la traspuesta de la matriz de la imagen.
	 * Si el angulo es 180º: Basta con cambiar las columnas de la matriz de la imagen.
	 * Si el angulo es 270º: Se ha de cambiar las columnas y posteriormente hallar la traspuesta
	 * de esa matriz.
	 * 
	 * @param image the image
	 * @param angulo the angulo
	 * @return the buffered image
	 */
	public BufferedImage rotacion(BufferedImage image, int angulo) {
		final int ANGLE_90 = 90;
		final int ANGLE_180 = 180;
		final int ANGLE_270 = 270;

		BufferedImage image_result;
		
		int[][] matriz_imagen = Imagenes.getPixelMatrix(image); 
		
		int[][] matriz_traspuesta_imagen;
		
		switch (angulo) {
		case ANGLE_90:
			matriz_traspuesta_imagen = transpose(matriz_imagen,
					matriz_imagen.length, matriz_imagen[0].length);

			image_result = Imagenes.deepCopy(Imagenes
					.crearImagenMatriz(matriz_traspuesta_imagen));
			break;

		case ANGLE_180:
			swapColumns(matriz_imagen, matriz_imagen[0].length);

			image_result = Imagenes.deepCopy(Imagenes
					.crearImagenMatriz(matriz_imagen));
			break;
		
		case ANGLE_270:
			swapColumns(matriz_imagen, matriz_imagen[0].length);

			matriz_traspuesta_imagen = transpose(matriz_imagen,
					matriz_imagen.length, matriz_imagen[0].length);
			
			image_result = Imagenes.deepCopy(Imagenes
					.crearImagenMatriz(matriz_traspuesta_imagen));
			break;
			
		default:
			image_result = null;
			break;
		}

		return image_result;
	}
	
	/**
	 * Escalado vmp. Crea una nueva imagen a partir de unas nuevas
	 * dimensiones.
	 *
	 * @param img the img
	 * @param new_width the new_width
	 * @param new_heigth the new_heigth
	 * @return the buffered image
	 */
	public BufferedImage escaladoVMP(BufferedImage img, int new_width, int new_heigth) {
		BufferedImage imagen_escalada;
		
		imagen_escalada = Imagenes.deepCopy(VMP(img, new_width, new_heigth));
		
		return imagen_escalada;
	}
	
	/**
	 * Escalado bilineal. Crea una nueva imagen a partir de unas nuevas
	 * dimensiones.
	 *
	 * @param img the img
	 * @param new_width the new_width
	 * @param new_heigth the new_heigth
	 * @return the buffered image
	 */
	public BufferedImage escaladoBilineal(BufferedImage img, int new_width, int new_heigth) {
		BufferedImage imagen_escalada;
		
		imagen_escalada = Imagenes.deepCopy(algoritmoBilinear(img, new_width, new_heigth));
		
		return imagen_escalada;
	}
	
	/**
	 * Algoritmo bilinear.
	 *
	 * @param img the img
	 * @param new_width the new_width
	 * @param new_heigth the new_heigth
	 * @return the int[][]
	 */
	public BufferedImage algoritmoBilinear(BufferedImage img, int new_width,
			int new_heigth) {
		Imagenes antigua_imagen = new Imagenes();
		antigua_imagen.setImagen(img);
		
		Imagenes nueva_imagen = new Imagenes();
		nueva_imagen.setImagen(new BufferedImage(new_width, 
				new_heigth, img.getType()));
		
		// Calculo de factores del escalado
		float factor_ancho = (float) ((float)new_width / (float)img.getWidth());
		float factor_alto = (float) ((float)new_heigth / (float)img.getHeight());

		float px, py;
		
		for (int i = 0; i < new_width; i++) {
			for (int j = 0; j < new_heigth; j++) {
				px = i / factor_ancho;
				py = j / factor_alto;

				nueva_imagen.setPixelUnitGrey(i, j, colorBilineal(px, py, antigua_imagen));
			}
		}

		return nueva_imagen.getImagen();
	}
	
	public int colorBilineal(float px, float py, Imagenes antigua_imagen){
		int p_x, p_y;
		
		int A, B, C, D, P;
		float p, q;
		
		p_x = (int)px;
		p_y = (int)py;
		
		if(p_x + 1 >= antigua_imagen.getImagen().getWidth())
			p_x = antigua_imagen.getImagen().getWidth() - 2;
		if(p_y + 1 >= antigua_imagen.getImagen().getHeight())
			p_y = antigua_imagen.getImagen().getHeight() - 2;
		
		//System.out.println("P_X: " + p_x + ", P_Y: " + p_y);
		
		C = antigua_imagen.getBluePoint(p_x, p_y);
		D = antigua_imagen.getBluePoint(p_x + 1, p_y);
		A = antigua_imagen.getBluePoint(p_x, p_y + 1);
		B = antigua_imagen.getBluePoint(p_x + 1, p_y + 1);
		p = px - ((int)px);
		q = py - ((int)py);
		
		P = Math.round(C + ((D - C) * p) + ((A - C) * q) + ((B + C - A - D) * p * q));
		
		return P;
	}
	
	/**
	 * Vmp. Algoritmo Vecino mas Proximo
	 *
	 * @param img the img
	 * @param new_width the new_widht
	 * @param new_heigth the new_height
	 * @return the bufferedImage
	 */
	public BufferedImage VMP(BufferedImage img, int new_width, int new_heigth) {
		Imagenes antigua_imagen = new Imagenes();
		antigua_imagen.setImagen(img);
		
		Imagenes nueva_imagen = new Imagenes();
		nueva_imagen.setImagen(new BufferedImage(new_width, 
				new_heigth, img.getType()));
		
		// Calculo del factor de escalado
		float factor_ancho = (float) ((float)new_width / (float)img.getWidth());
		float factor_alto = (float) ((float)new_heigth / (float)img.getHeight());

		int px, py;
		
		for (int i = 0; i < new_width; i++) {
			for (int j = 0; j < new_heigth; j++) {
				px = Math.round(i / factor_ancho);
				py = Math.round(j / factor_alto);
				
				nueva_imagen.setPixelUnitGrey(i, j, colorVMP(px, py, antigua_imagen));
			}
		}

		return nueva_imagen.getImagen();
	}
	
	public int colorVMP(int px, int py, Imagenes antigua_imagen){
		if(px >= antigua_imagen.getImagen().getWidth())
			px--;
		
		if(py >= antigua_imagen.getImagen().getHeight())
			py--;
		
		return antigua_imagen.getBluePoint(px, py);
	}

	public BufferedImage algoritmoRotacion_I(Imagenes antigua_imagen, double angulo){
		Imagenes nueva_imagen = new Imagenes();
		
		//Recogiendo los puntos 
		double x, y;
		
		x = 0;
		y = 0;
		
		double E[], F[], G[], H[];
		
		E = new double [2];
		F = new double [2];
		H = new double [2];
		G = new double [2];
		
		angulo = Math.toRadians(angulo);
		
		E[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		E[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		y = antigua_imagen.getImagen().getHeight();

		F[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		F[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		x = antigua_imagen.getImagen().getWidth();
		y = 0;

		H[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		H[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		x = antigua_imagen.getImagen().getWidth();
		y = antigua_imagen.getImagen().getHeight();

		G[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		G[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		int width, height;
		double x_min, x_max, y_min, y_max;
		x_min = x_max = y_min = y_max = 0;
		
		x_min = Math.min(E[0], Math.min(F[0], Math.min(H[0], G[0])));
		x_max = Math.max(E[0], Math.max(F[0], Math.max(H[0], G[0])));
		
		y_min = Math.min(E[1], Math.min(F[1], Math.min(H[1], G[1])));
		y_max = Math.max(E[1], Math.max(F[1], Math.max(H[1], G[1])));
		
		width = (int)(Math.abs(x_min) + Math.abs(x_max));
		height = (int)(Math.abs(y_min) + Math.abs(y_max));
		
		nueva_imagen.setImagen(new BufferedImage(width, 
				height, antigua_imagen.getImagen().getType()));
		
		float x_min_bucle = (float) x_min;
		float y_min_bucle = (float) y_min;
		
		float transformada_x, transformada_y;
		
		for(int i = 0; i < nueva_imagen.getImagen().getWidth(); i++){
			y_min_bucle = (float) y_min;
			for(int j = 0; j < nueva_imagen.getImagen().getHeight(); j++){	
				transformada_x = (float)((Math.cos(angulo)*x_min_bucle)
						+ (Math.sin(angulo)*y_min_bucle));
				
				transformada_y = (float)((-Math.sin(angulo)*x_min_bucle)
						+ (Math.cos(angulo)*y_min_bucle));
				
				if(transformada_x < 0 || transformada_y < 0 ||
						transformada_x > antigua_imagen.getImagen().getWidth() ||
						transformada_y > antigua_imagen.getImagen().getHeight())
					nueva_imagen.setPixelToWhite(i, j);
				else
					nueva_imagen.setPixelUnitGrey(i, j, colorBilineal(transformada_x,
							transformada_y, antigua_imagen));
				
				y_min_bucle++;
			}
			x_min_bucle++;
		}
		
		return nueva_imagen.getImagen();
	}
	
	public BufferedImage algoritmoRotacion_D(Imagenes antigua_imagen, double angulo){
		Imagenes nueva_imagen = new Imagenes();
		
		//Recogiendo los puntos 
		double x, y;
		
		x = 0;
		y = 0;
		
		double E[], F[], G[], H[];
		
		E = new double [2];
		F = new double [2];
		H = new double [2];
		G = new double [2];
		
		angulo = Math.toRadians(angulo);
		
		E[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		E[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		y = antigua_imagen.getImagen().getHeight();

		F[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		F[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		x = antigua_imagen.getImagen().getWidth();
		y = 0;

		H[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		H[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		x = antigua_imagen.getImagen().getWidth();
		y = antigua_imagen.getImagen().getHeight();

		G[0] = (Math.cos(angulo)*x) + (-Math.sin(angulo)*y);
		G[1] = (Math.sin(angulo)*x) + (Math.cos(angulo)*y);
		
		int width, height;
		double x_min, x_max, y_min, y_max;
		x_min = x_max = y_min = y_max = 0;
		
		x_min = Math.min(E[0], Math.min(F[0], Math.min(H[0], G[0])));
		x_max = Math.max(E[0], Math.max(F[0], Math.max(H[0], G[0])));
		
		y_min = Math.min(E[1], Math.min(F[1], Math.min(H[1], G[1])));
		y_max = Math.max(E[1], Math.max(F[1], Math.max(H[1], G[1])));
		
		width = (int)(Math.abs(x_min) + Math.abs(x_max));
		height = (int)(Math.abs(y_min) + Math.abs(y_max));
		
		nueva_imagen.setImagen(new BufferedImage(width, 
				height, antigua_imagen.getImagen().getType()));
		
		float sin;
		float cos;
		
		float transformada_x, transformada_y;
		
		for(int i = 0; i < nueva_imagen.getImagen().getWidth(); i++)
			for(int j = 0; j < nueva_imagen.getImagen().getHeight(); j++)
				nueva_imagen.setPixelToWhite(i, j);
			
		
		for(int i = 0; i < antigua_imagen.getImagen().getWidth(); i++){
			for(int j = 0; j < antigua_imagen.getImagen().getHeight(); j++){	
				sin = (float) (-Math.sin(angulo)*j);
				cos = (float) (Math.cos(angulo)*i);
				
				transformada_x = cos + sin;
				transformada_x = (float) (transformada_x + Math.abs(x_min));
				
				if(Math.round(Math.abs(transformada_x)) >= nueva_imagen.getImagen().getWidth())
					transformada_x = nueva_imagen.getImagen().getWidth() - 1;
				
				sin = (float) (Math.sin(angulo)*i);
				cos = (float) (Math.cos(angulo)*j);
				
				transformada_y = sin + cos;
				transformada_y = (float) (transformada_y + Math.abs(y_min));
				
				if(Math.round(Math.abs(transformada_y)) >= nueva_imagen.getImagen().getHeight())
					transformada_y = nueva_imagen.getImagen().getHeight() - 1;
				
				if(transformada_x > 0 && transformada_y > 0 &&
						transformada_x < nueva_imagen.getImagen().getWidth() &&
						transformada_y < nueva_imagen.getImagen().getHeight())
					nueva_imagen.setPixelUnitGrey(Math.round(Math.abs(transformada_x)), 
							Math.round(Math.abs(transformada_y)),
							colorBilineal(i, j, antigua_imagen));
			}
		}
		
		return nueva_imagen.getImagen();
	}

	/**
	 * Transpose.
	 * 
	 * @param data
	 *            the data
	 * @param rows
	 *            the rows
	 * @param columns
	 *            the columns
	 * @return the int[][]
	 */
	public static int[][] transpose(int[][] data, int rows, int columns) {
		int[][] transpose = new int[columns][rows];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				transpose[j][i] = data[i][j];
			}
		}

		return transpose;
	}

	/**
	 * Swap columns.
	 * 
	 * @param data
	 *            the data
	 * @param columns
	 *            the columns
	 */
	public static void swapColumns(int[][] data, int columns) {
		int start = 0;
		int end = columns - 1;

		int mitad = columns / 2;

		while ((start <= mitad) && (end >= mitad)) {
			for (int value = 0; value < data.length; value++) {
				int temp = data[value][start];
				data[value][start] = data[value][end];
				data[value][end] = temp;
			}
			start++;
			end--;
		}

	}

	/**
	 * Swap rows.
	 * 
	 * @param data
	 *            the data
	 * @param rows
	 *            the rows
	 */
	public static void swapRows(int[][] data, int rows) {
		int start = 0;
		int end = data.length - 1;

		int mitad = rows / 2;

		while ((start <= mitad) && (end >= mitad)) {
			for (int value = 0; value < data[start].length; value++) {
				int temp = data[start][value];
				data[start][value] = data[end][value];
				data[end][value] = temp;
			}
			start++;
			end--;

		}
	}

	/**
	 * Gets the acumulador_imagenes.
	 * 
	 * @return the acumulador_imagenes
	 */
	public ArrayList<Imagenes> getAcumulador_imagenes() {
		return acumulador_imagenes;
	}

	/**
	 * Gets the imagen_actual.
	 * 
	 * @return the imagen_actual
	 */
	public int getImagen_actual() {
		return imagen_actual;
	}

	/**
	 * Gets the histograma.
	 * 
	 * @return the histograma
	 */
	public Histograma getHistograma() {
		return histograma;
	}

	/**
	 * Gets the plot histograma.
	 * 
	 * @return the plotHistograma
	 */
	public PlotHistograma getPlotHistograma() {
		return plotHistograma;
	}

	/**
	 * Sets the imagen_actual.
	 * 
	 * @param imagen_actual
	 *            the new imagen_actual
	 */
	public void setImagen_actual(int imagen_actual) {
		this.imagen_actual = imagen_actual;
		crearHistograma();
	}

}
