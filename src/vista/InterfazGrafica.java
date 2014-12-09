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
	
	/** The Constant TRASPUESTA. */
	public final static String TRASPUESTA = "Traspuesta de la imagen";
	
	/** The Constant ROTACION. */
	public final static String ROTACION = "Rotacion";
	
	/** The Constant ESCALADO_VMP. */
	public final static String ESCALADO_VMP = "Escalado VMP";
	
	/** The Constant ESCALADO_BILINEAR. */
	public final static String ESCALADO_BILINEAR = "Escalado bilinear";
	
	public final static String OPERACIONES_LINEALES = "Operaciones lineales";
	
	public final static String OPERACIONES_NO_LINEALES = "Operaciones no lineales";
	
	public final static String ROTACIONES = "Rotaciones";
	
	public final static String ESCALADOS = "Escalados";
	
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
	
	/** The accion_herramientas_traspuesta_imagen. */
	public JMenuItem accion_herramientas_traspuesta_imagen;
	
	/** The accion_herramientas_rotacion. */
	public JMenuItem accion_herramientas_rotacion;
	
	/** The accion_herramientas_escalado_vmp. */
	public JMenuItem accion_herramientas_escalado_vmp;
	
	/** The accion_herramientas_escalado_bilinear. */
	public JMenuItem accion_herramientas_escalado_bilinear;
	
	public JMenu submenu_histogramas;
	
	public JMenu submenu_operaciones_lineales;
	
	public JMenu submenu_operaciones_no_lineales;
	
	public JMenu submenu_rotaciones;
	
	public JMenu submenu_escalados;
	
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
		
		// Inicializando submenus
		submenu_histogramas = new JMenu(HISTOGRAMA);
		submenu_operaciones_lineales = new JMenu(OPERACIONES_LINEALES);
		submenu_operaciones_no_lineales = new JMenu(OPERACIONES_NO_LINEALES);
		submenu_rotaciones = new JMenu(ROTACIONES);
		submenu_escalados = new JMenu(ESCALADOS);
		
		// Aniadiendo submenus a sus menus correspondientes
		addToSubMenu(menu_herramientas, submenu_histogramas);
		addToSubMenu(menu_herramientas, submenu_operaciones_lineales);
		addToSubMenu(menu_herramientas, submenu_operaciones_no_lineales);
		addToSubMenu(menu_herramientas, submenu_rotaciones);
		addToSubMenu(menu_herramientas, submenu_escalados);
		
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
		accion_herramientas_traspuesta_imagen = new JMenuItem(TRASPUESTA);
		accion_herramientas_rotacion = new JMenuItem(ROTACION);
		accion_herramientas_escalado_vmp = new JMenuItem(ESCALADO_VMP);
		accion_herramientas_escalado_bilinear = new JMenuItem(ESCALADO_BILINEAR);
		
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
		
		submenu_histogramas.add(acciones_herramientas_histograma);
		submenu_histogramas.add(acciones_herramientas_histograma_acumulativo);
		
		submenu_operaciones_lineales.add(acciones_herramientas_tft);
		submenu_operaciones_lineales.add(acciones_herramientas_contraste_brillo);
		submenu_operaciones_lineales.add(acciones_herramientas_binarizar);
		
		submenu_operaciones_no_lineales.add(acciones_herramientas_ecualizar_histograma);
		submenu_operaciones_no_lineales.add(acciones_herramientas_especificar_histograma);
		submenu_operaciones_no_lineales.add(acciones_herramientas_correccion_gamma);
		
		submenu_rotaciones.add(accion_herramientas_espejo_vertical);
		submenu_rotaciones.add(accion_herramientas_espejo_horizontal);
		submenu_rotaciones.add(accion_herramientas_traspuesta_imagen);
		submenu_rotaciones.add(accion_herramientas_rotacion);
		
		submenu_escalados.add(accion_herramientas_escalado_vmp);
		submenu_escalados.add(accion_herramientas_escalado_bilinear);
		
		menu_herramientas.add(acciones_herramientas_monocromo);
		menu_herramientas.add(acciones_herramientas_entropia);
		menu_herramientas.add(acciones_herramientas_diferencia_imagenes);
		menu_herramientas.add(acciones_herramientas_digitalizacion);
		menu_herramientas.add(accion_herramientas_perfil);
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

	public void addToSubMenu(JMenu menu, JMenu submenu) {
		menu.add(submenu);
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
	
	/**
	 * Adds the listener accion traspuesta imagen.
	 *
	 * @param ListenForTraspuestaImagen the listen for traspuesta imagen
	 */
	public void addListenerAccionTraspuestaImagen(ActionListener ListenForTraspuestaImagen) {
		accion_herramientas_traspuesta_imagen.addActionListener(ListenForTraspuestaImagen);
	}
	
	/**
	 * Adds the listener accion rotacion.
	 *
	 * @param ListenForRotacion the listen for rotacion
	 */
	public void addListenerAccionRotacion(ActionListener ListenForRotacion) {
		accion_herramientas_rotacion.addActionListener(ListenForRotacion);
	}
	
	/**
	 * Adds the listener accion escalado vmp.
	 *
	 * @param ListenForEscaladoVMP the listen for escalado vmp
	 */
	public void addListenerAccionEscaladoVMP(ActionListener ListenForEscaladoVMP) {
		accion_herramientas_escalado_vmp.addActionListener(ListenForEscaladoVMP);
	}
	
	/**
	 * Adds the listener accion escalado bilinear.
	 *
	 * @param ListenForEscaladoBilinear the listen for escalado bilinear
	 */
	public void addListenerAccionEscaladoBilinear(ActionListener ListenForEscaladoBilinear) {
		accion_herramientas_escalado_bilinear.addActionListener(ListenForEscaladoBilinear);
	}
}
