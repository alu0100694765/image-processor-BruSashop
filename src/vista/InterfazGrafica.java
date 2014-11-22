package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfazGrafica.
 * 
 * Objetivo: Forma parte de la Vista, inicializa la interfaz, así como sus
 * elementos y cre los listeners para estos
 * 
 */
public class InterfazGrafica {

	/** The titulo. */
	private final String TITULO = "BruSaShop";

	/** The archivo. */
	private final String ARCHIVO = "Archivo";

	/** The editar. */
	private final String EDITAR = "Editar";

	/** The ayuda. */
	private final static String AYUDA = "Ayuda";
	
	/** The herramientas. */
	private final static String HERRAMIENTAS = "Herramientas";
	
	/** The abrir. */
	private final static String ABRIR = "Abrir";
	
	/** The salir. */
	private final static String SALIR = "Salir";
	
	/** The acerca de. */
	private final static String ACERCA_DE = "Acerca de";
	
	/** The histograma. */
	private final static String HISTOGRAMA = "Histograma";

	/** The histograma. */
	private final static String HISTOGRAMA_ACUMULATIVO = "Histograma Acumulativo";

	/** The Constant ENTROPIA. */
	private final static String ENTROPIA = "Entropia";
	
	/** The Constant GUARDAR. */
	private final static String GUARDAR = "Guardar";
	
	/** The Constant MONOCROMO. */
	private final static String MONOCROMO = "Monocromo";
	
	/** The Constant ROI. */
	private final static String ROI = "Region de Interes";
	
	/** The Constant EH. */
	private final static String EH = "Ecualizar Histograma";
	
	/** The Constant EsH. */
	private final static String EsH = "Especificar Histograma";
	
	/** The Constant GAMMA. */
	private final static String GAMMA = "Correccion Gamma";
	
	/** The Constant DIFERENCIA_IMAGENES. */
	private final static String DIFERENCIA_IMAGENES = "Diferencia de imagenes";
	
	/** The Constant DIGITALIZACION. */
	private final static String DIGITALIZACION = "Digitalizacion";
	
	/** The Constant PERFIL. */
	private final static String PERFIL = "Perfil";
	
	/** The Constant CONTRASTE. */
	private final static String CONTRASTE_BRILLO = "Contraste y Brillo";
	
	/** The Constant BINARIZAR. */
	private final static String BINARIZAR = "Binarizacion";
	
	/** The Constant OPEN_FILE. */
	private final static char OPEN_FILE = 'O';
	
	/** The Constant SAVE_FILE. */
	private final static char SAVE_FILE = 'S';
	
	/** The Constant HELP. */
	private final static char HELP = 'H';
	
	/** The Constant TFT. */
	public final static String TFT = "Transformaciones Lineales a Tramos";
	
	/** The Constant ACERCA_DE_MENSAJE. */
	public final static String ACERCA_DE_MENSAJE = "<html>BruSashop<br>Versi�n: 1.0<br>Autores: Sawan J Kapai Harpalani & Bruno Alessio Bibb�<br>Asignatura: Visi�n por Computador.<br>Grado en Ingener�a Inform�tica, Universidad La Laguna</html>";
	
	/** The Constant ESPEJO_V. */
	public final static String ESPEJO_V = "Espejo vertical";
	
	/** The Constant ESPEJO_H. */
	public final static String ESPEJO_H = "Espejo horizontal";
	
	/** The frame. */
	public JFrame frame;

	/** The barra_acciones. */
	public JMenuBar barra_acciones;

	/** The menu_acciones. */
	public JMenu menu_archivo;

	/** The menu_editar. */
	public JMenu menu_editar;

	/** The menu_ayuda. */
	public JMenu menu_ayuda;
	
	/** The menu_herramientas. */
	public JMenu menu_herramientas;

	/** The acciones_archivo. */
	public JMenuItem acciones_archivo_abrir;
	
	/** The acciones_archivo_salir. */
	public JMenuItem acciones_archivo_salir;
	
	/** The acciones_guardar_archivo. */
	public JMenuItem acciones_guardar_archivo;

	/** The acciones_ayuda_acercade. */
	public JMenuItem acciones_ayuda_acercade;

	/** The acciones_herramientas_histograma. */
	public JMenuItem acciones_herramientas_histograma;

	/** The acciones_herramientas_histograma. */
	public JMenuItem acciones_herramientas_histograma_acumulativo;
	
	/** The acciones_herramientas_monocromo. */
	public JMenuItem acciones_herramientas_monocromo;
	
	/** The acciones_herramientas_ecualizar_histograma. */
	public JMenuItem acciones_herramientas_ecualizar_histograma;
	
	/** The acciones_herramientas_especificar_histograma. */
	public JMenuItem acciones_herramientas_especificar_histograma;
	
	/** The acciones_herramientas_correccion_gamma. */
	public JMenuItem acciones_herramientas_correccion_gamma;
	
	/** The acciones_herramientas_diferencia_imagenes. */
	public JMenuItem acciones_herramientas_diferencia_imagenes;
	
	/** The acciones_herramientas_digitalizacion. */
	public JMenuItem acciones_herramientas_digitalizacion;
	
	/** The acciones_editar_region_interes. */
	public JMenuItem acciones_editar_region_interes;
	
	/** The acciones_herramientas_entropia. */
	public JMenuItem acciones_herramientas_entropia;

	/** The acciones_herramientas_contraste. */
	public JMenuItem acciones_herramientas_contraste_brillo;
	
	/** The acciones_herramientas_binarizar. */
	public JMenuItem acciones_herramientas_binarizar;
	
	/** The acciones_herramientas_tft. */
	public JMenuItem acciones_herramientas_tft;
	
	/** The accion_herramientas_perfil. */
	public JMenuItem accion_herramientas_perfil;
	
	/** The accion_herramientas_espejo_vertical. */
	public JMenuItem accion_herramientas_espejo_vertical;
	
	/** The accion_herramientas_espejo_horizontal. */
	public JMenuItem accion_herramientas_espejo_horizontal;
	
	/**
	 * Instantiates a new interfaz grafica.
	 */
	public InterfazGrafica() {

		frame = new JFrame(TITULO);

		// Inicializa la barra del menu
		barra_acciones = new JMenuBar();

		// Inicializando las pestañas de la barra (archivo,editar,ayuda)
		menu_archivo = new JMenu(ARCHIVO);
		menu_editar = new JMenu(EDITAR);
		menu_ayuda = new JMenu(AYUDA);
		menu_herramientas = new JMenu(HERRAMIENTAS);

		// Añadiendo menus a la barra
		addToBarraAcciones(menu_archivo);
		addToBarraAcciones(menu_editar);
		addToBarraAcciones(menu_herramientas);
		addToBarraAcciones(menu_ayuda);

		// Inicializando las acciones
		acciones_archivo_abrir = new JMenuItem(ABRIR);
		acciones_archivo_salir = new JMenuItem(SALIR);
		acciones_ayuda_acercade = new JMenuItem(ACERCA_DE);
		acciones_herramientas_histograma = new JMenuItem(HISTOGRAMA);
		acciones_guardar_archivo = new JMenuItem(GUARDAR);
		acciones_herramientas_histograma_acumulativo = new JMenuItem(HISTOGRAMA_ACUMULATIVO);
		acciones_herramientas_monocromo = new JMenuItem(MONOCROMO);
		acciones_herramientas_ecualizar_histograma = new JMenuItem(EH);
		acciones_herramientas_especificar_histograma = new JMenuItem(EsH);
		acciones_herramientas_correccion_gamma = new JMenuItem(GAMMA);
		acciones_herramientas_diferencia_imagenes = new JMenuItem(DIFERENCIA_IMAGENES);
		acciones_herramientas_digitalizacion = new JMenuItem(DIGITALIZACION);
		acciones_editar_region_interes = new JMenuItem(ROI);
		acciones_herramientas_entropia = new JMenuItem(ENTROPIA);
		acciones_herramientas_contraste_brillo = new JMenuItem(CONTRASTE_BRILLO);
		acciones_herramientas_binarizar =  new JMenuItem(BINARIZAR);
		acciones_herramientas_tft = new JMenuItem(TFT);
		accion_herramientas_perfil = new JMenuItem(PERFIL);
		accion_herramientas_espejo_vertical = new JMenuItem(ESPEJO_V);
		accion_herramientas_espejo_horizontal = new JMenuItem(ESPEJO_H);
		
		//Añadiendo atajos
		acciones_archivo_abrir.setMnemonic(OPEN_FILE);
		acciones_archivo_abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		acciones_guardar_archivo.setMnemonic(SAVE_FILE);
		acciones_guardar_archivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		acciones_ayuda_acercade.setMnemonic(HELP);
		acciones_ayuda_acercade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		// Añadiendo la acciones a los menus
		menu_archivo.add(acciones_archivo_abrir);
		menu_archivo.add(acciones_guardar_archivo);
		menu_archivo.add(acciones_archivo_salir);
		menu_ayuda.add(acciones_ayuda_acercade);
		menu_herramientas.add(acciones_herramientas_histograma);
		menu_herramientas.add(acciones_herramientas_histograma_acumulativo);
		menu_herramientas.add(acciones_herramientas_monocromo);
		menu_herramientas.add(acciones_herramientas_ecualizar_histograma);
		menu_herramientas.add(acciones_herramientas_especificar_histograma);
		menu_herramientas.add(acciones_herramientas_correccion_gamma);
		menu_herramientas.add(acciones_herramientas_entropia);
		menu_herramientas.add(acciones_herramientas_diferencia_imagenes);
		menu_herramientas.add(acciones_herramientas_digitalizacion);
		menu_herramientas.add(acciones_herramientas_contraste_brillo);
		menu_herramientas.add(acciones_herramientas_binarizar);
		menu_herramientas.add(acciones_herramientas_tft);
		menu_herramientas.add(accion_herramientas_perfil);
		menu_herramientas.add(accion_herramientas_espejo_vertical);
		menu_herramientas.add(accion_herramientas_espejo_horizontal);
		menu_editar.add(acciones_editar_region_interes);
		
		
		acciones_herramientas_entropia.setEnabled(false);

		frame.setSize(600, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(barra_acciones);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	/**
	 * Adds the to barra acciones.
	 * 
	 * Objetivo: Añade un menu a la barra de acciones
	 * 
	 * @param componente
	 *            the componente
	 */
	public void addToBarraAcciones(JMenu componente) {
		barra_acciones.add(componente);
	}


	/**
	 * Listeners de los items de los menus.
	 *
	 * @param ListenForAbrir the listen for abrir
	 */

	public void addListenerAccionAbrir(ActionListener ListenForAbrir) {
		acciones_archivo_abrir.addActionListener(ListenForAbrir);
	}

	/**
	 * Adds the listener accion salir.
	 *
	 * @param ListenForSalir the listen for salir
	 */
	public void addListenerAccionSalir(ActionListener ListenForSalir) {
		acciones_archivo_salir.addActionListener(ListenForSalir);
	}

	/**
	 * Adds the listener accion acerca de.
	 *
	 * @param ListenForAcercaDe the listen for acerca de
	 */
	public void addListenerAccionAcercaDe(ActionListener ListenForAcercaDe) {
		acciones_ayuda_acercade.addActionListener(ListenForAcercaDe);
	}
	
	/**
	 * Adds the listener accion histograma.
	 *
	 * @param ListenForHistograma the listen for histograma
	 */
	public void addListenerAccionHistograma(ActionListener ListenForHistograma) {
		acciones_herramientas_histograma.addActionListener(ListenForHistograma);
	}
	
	/**
	 * Adds the listener accion guardar imagen.
	 *
	 * @param ListenForGuardarImagen the listen for guardar imagen
	 */
	public void addListenerAccionGuardarImagen(ActionListener ListenForGuardarImagen) {
		acciones_guardar_archivo.addActionListener(ListenForGuardarImagen);
	}
	
	/**
	 * Adds the listener accion histograma acumulativo.
	 *
	 * @param ListenForHistogramaAcumulativo the listen for histograma acumulativo
	 */
	public void addListenerAccionHistogramaAcumulativo(ActionListener ListenForHistogramaAcumulativo) {
		acciones_herramientas_histograma_acumulativo.addActionListener(ListenForHistogramaAcumulativo);
	}
	
	/**
	 * Adds the listener accion monocromo.
	 *
	 * @param ListenForMonocromo the listen for monocromo
	 */
	public void addListenerAccionMonocromo(ActionListener ListenForMonocromo) {
		acciones_herramientas_monocromo.addActionListener(ListenForMonocromo);
	}
	
	/**
	 * Adds the listener accion ecualizar histograma.
	 *
	 * @param ListenForEH the listen for eh
	 */
	public void addListenerAccionEcualizarHistograma(ActionListener ListenForEH) {
		acciones_herramientas_ecualizar_histograma.addActionListener(ListenForEH);
	}
	
	/**
	 * Adds the listener accion especificar histograma.
	 *
	 * @param ListenForEsH the listen for es h
	 */
	public void addListenerAccionEspecificarHistograma(ActionListener ListenForEsH) {
		acciones_herramientas_especificar_histograma.addActionListener(ListenForEsH);
	}
	
	/**
	 * Adds the listener accion correccion gamma.
	 *
	 * @param ListenForGamma the listen for gamma
	 */
	public void addListenerAccionCorreccionGamma(ActionListener ListenForGamma) {
		acciones_herramientas_correccion_gamma.addActionListener(ListenForGamma);
	}
	
	/**
	 * Adds the listener accion diferencia imagenes.
	 *
	 * @param ListenForDI the listen for di
	 */
	public void addListenerAccionDiferenciaImagenes(ActionListener ListenForDI) {
		acciones_herramientas_diferencia_imagenes.addActionListener(ListenForDI);
	}
	
	/**
	 * Adds the listener accion digitalizacion.
	 *
	 * @param ListenForDigitalizacion the listen for digitalizacion
	 */
	public void addListenerAccionDigitalizacion(ActionListener ListenForDigitalizacion) {
		acciones_herramientas_digitalizacion.addActionListener(ListenForDigitalizacion);
	}
	
	/**
	 * Adds the listener accion entropia.
	 *
	 * @param ListenForEntropia the listen for entropia
	 */
	public void addListenerAccionEntropia(ActionListener ListenForEntropia) {
		acciones_herramientas_entropia.addActionListener(ListenForEntropia);
	}
	
	/**
	 * Adds the listener accion roi.
	 *
	 * @param ListenForROI the listen for roi
	 */
	public void addListenerAccionROI(ActionListener ListenForROI) {
		acciones_editar_region_interes.addActionListener(ListenForROI);
	}
	
	/**
	 * Adds the listener accion contraste.
	 *
	 * @param ListenForContrasteBrillo the listen for contraste
	 */
	public void addListenerAccionContrasteBrillo(ActionListener ListenForContrasteBrillo) {
		acciones_herramientas_contraste_brillo.addActionListener(ListenForContrasteBrillo);
	}
	
	/**
	 * Adds the listener accion binarizar.
	 *
	 * @param ListenForBinarizar the listen for binarizar
	 */
	public void addListenerAccionBinarizar(ActionListener ListenForBinarizar) {
		acciones_herramientas_binarizar.addActionListener(ListenForBinarizar);
	}
	
	/**
	 * Adds the listener accion tft.
	 *
	 * @param ListenForTFT the listen for tft
	 */
	public void addListenerAccionTFT(ActionListener ListenForTFT) {
		acciones_herramientas_tft.addActionListener(ListenForTFT);
	}
	
	/**
	 * Adds the listener accion perfil.
	 *
	 * @param ListenForPerfil the listen for perfil
	 */
	public void addListenerAccionPerfil(ActionListener ListenForPerfil) {
		accion_herramientas_perfil.addActionListener(ListenForPerfil);
	}
	
	/**
	 * Adds the listener accion espejo vertical.
	 *
	 * @param ListenForEspejoVertical the listen for espejo vertical
	 */
	public void addListenerAccionEspejoVertical(ActionListener ListenForEspejoVertical) {
		accion_herramientas_espejo_vertical.addActionListener(ListenForEspejoVertical);
	}

	/**
	 * Adds the listener accion espejo horizontal.
	 *
	 * @param ListenForEspejoHorizontal the listen for espejo horizontal
	 */
	public void addListenerAccionEspejoHorizontal(ActionListener ListenForEspejoHorizontal) {
		accion_herramientas_espejo_horizontal.addActionListener(ListenForEspejoHorizontal);
	}
	
}
