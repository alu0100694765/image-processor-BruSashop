/**
 * 
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import modelo.Histograma;
import modelo.Imagenes;
import modelo.ManipuladorImagenes;
import vista.AbrirImagen;
import vista.BottomBar;
import vista.ContrasteBrillo;
import vista.InterfazGrafica;
import vista.NumeroTramos;
import vista.Perfil;
import vista.PintarImagen;
import vista.PlotHistograma;
import vista.SeleccionDigitalizacion;
import vista.SeleccionGamma;
import vista.SeleccionImagenEspecifica;
import vista.SeleccionUmbral;
import vista.SelectionArea;
import vista.TransformacionLinealesTramos;

// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 * 
 * @author Sawan
 */
public class Controlador {

	/** The manipulador imagenes. */
	private ManipuladorImagenes manipulador;

	/** The interfaz grafica. */
	private InterfazGrafica interfazGrafica;

	/**
	 * Instantiates a new controlador.
	 * 
	 * @param imagenes
	 *            the imagenes
	 * @param ig
	 *            the ig
	 */
	public Controlador(ManipuladorImagenes imagenes, InterfazGrafica ig) {
		manipulador = imagenes;
		interfazGrafica = ig;

		this.interfazGrafica.addListenerAccionAbrir(new AccionAbrirListener());
		this.interfazGrafica
				.addListenerAccionHistograma(new AccionHistogramaListener());
		this.interfazGrafica
				.addListenerAccionGuardarImagen(new AccionGuardarImagenListener());
		this.interfazGrafica
				.addListenerAccionHistogramaAcumulativo(new AccionHistogramaAcumulativoListener());
		this.interfazGrafica
				.addListenerAccionMonocromo(new AccionMonocromoListener());
		this.interfazGrafica
				.addListenerAccionEcualizarHistograma(new AccionEcualizarHistogramaListener());
		this.interfazGrafica
				.addListenerAccionEspecificarHistograma(new AccionEspecificarHistogramaListener());
		this.interfazGrafica
				.addListenerAccionCorreccionGamma(new AccionCorreccionGammaListener());
		this.interfazGrafica
				.addListenerAccionDiferenciaImagenes(new AccionDiferenciaImagenesListener());
		this.interfazGrafica
				.addListenerAccionDigitalizacion(new AccionDigitalizacionListener());
		this.interfazGrafica.addListenerAccionROI(new AccionROIListener());
		this.interfazGrafica
				.addListenerAccionEntropia(new AccionEntropiaListener());
		this.interfazGrafica
				.addListenerAccionContrasteBrillo(new AccionContrasteBrilloListner());
		this.interfazGrafica
				.addListenerAccionBinarizar(new AccionBinarizarListener());
		this.interfazGrafica
				.addListenerAccionAcercaDe(new AccionAcercaDeListener());
		this.interfazGrafica.addListenerAccionTFT(new AccionTFTListener());
		this.interfazGrafica.addListenerAccionSalir(new AccionSalirListener());
		this.interfazGrafica
				.addListenerAccionPerfil(new AccionPerfilListener());
		this.interfazGrafica
				.addListenerAccionEspejoVertical(new AccionEspejoVerticalListener());
	}

	/**
	 * The listener interface for receiving accionAbrir events. The class that
	 * is interested in processing a accionAbrir event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionAbrirListener<code> method. When
	 * the accionAbrir event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionAbrirEvent
	 */
	public class AccionAbrirListener implements ActionListener {

		/** The frame. */
		public JFrame frame = new JFrame();

		/** The abrir imagen. */
		public AbrirImagen abrirImagen;

		/** The bottom bar. */
		public BottomBar bottomBar;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Imagenes nueva_imagen = new Imagenes();
			JFileChooser chooser;
			frame.setLayout(new BorderLayout());
			String choosertitle = null;
			chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle(choosertitle);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);

			chooser.addChoosableFileFilter(new FileFilter() {

				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					return f.getName().endsWith(".jpg");
				}

				@Override
				public String getDescription() {
					return "JPEG files";
				}

			});

			chooser.addChoosableFileFilter(new FileFilter() {

				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					return f.getName().endsWith(".png");
				}

				@Override
				public String getDescription() {
					return "PNG files";
				}

			});

			chooser.addChoosableFileFilter(new FileFilter() {

				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					return f.getName().endsWith(".bmp");
				}

				@Override
				public String getDescription() {
					return "BMP files";
				}

			});

			chooser.addChoosableFileFilter(new FileFilter() {

				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					return f.getName().endsWith(".tiff");
				}

				@Override
				public String getDescription() {
					return "TIFF files";
				}

			});

			String path = null;

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				path = chooser.getSelectedFile().toString();
			} else {
				System.out.println("No Selection ");
			}

			try {
				nueva_imagen.setImage_path(path);
			} catch (IOException e2) {
				e2.printStackTrace();
			}

			nueva_imagen.getData();
			manipulador.crearImagen(nueva_imagen);

			PintarImagen nuevaPintura = new PintarImagen(manipulador);
			nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));

		}

	}

	/**
	 * The listener interface for receiving accionHistograma events. The class
	 * that is interested in processing a accionHistograma event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionHistogramaListener<code> method. When
	 * the accionHistograma event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionHistogramaEvent
	 */
	public class AccionHistogramaListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manipulador.plotHistograma();
		}

	}

	/**
	 * The listener interface for receiving accionGuardarImagen events. The
	 * class that is interested in processing a accionGuardarImagen event
	 * implements this interface, and the object created with that class is
	 * registered with a component using the component's
	 * <code>addAccionGuardarImagenListener<code> method. When
	 * the accionGuardarImagen event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionGuardarImagenEvent
	 */
	public class AccionGuardarImagenListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");

			int userSelection = fileChooser
					.showSaveDialog(interfazGrafica.frame);

			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				try {
					ImageIO.write(
							manipulador.getAcumulador_imagenes()
									.get(manipulador.getImagen_actual())
									.getImagen(), "jpg", fileToSave);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}

	/**
	 * The Class AccionHistogramaAcumulativo.
	 * 
	 * @see AccionHistogramaAcumulativoEvent
	 */
	public class AccionHistogramaAcumulativoListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manipulador.plotHistogramaAcumulativo();
		}

	}

	/**
	 * The Class AccionMonocromo.
	 * 
	 * @see AccionMonocromoEvent
	 */
	public class AccionMonocromoListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			manipulador.crearGris();

			PintarImagen nuevaPintura = new PintarImagen(manipulador);
			nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));

		}
	}

	/**
	 * The listener interface for receiving windowActive events. The class that
	 * is interested in processing a windowActive event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addWindowActiveListener<code> method. When
	 * the windowActive event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see WindowActiveEvent
	 */
	public class WindowActiveListener implements WindowListener {

		/** The id. */
		int id;

		/**
		 * Instantiates a new window active listener.
		 * 
		 * @param manipulator
		 *            the manipulator
		 */
		public WindowActiveListener(ManipuladorImagenes manipulator) {
			id = manipulator.getImagen_actual();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent
		 * )
		 */
		@Override
		public void windowActivated(WindowEvent arg0) {
			manipulador.setImagen_actual(id);
			if (manipulador.getAcumulador_imagenes().get(id).esMonocromo()) {
				interfazGrafica.acciones_herramientas_entropia.setEnabled(true);
			} else {
				interfazGrafica.acciones_herramientas_entropia
						.setEnabled(false);
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent
		 * )
		 */
		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent
		 * )
		 */
		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.
		 * WindowEvent)
		 */
		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.
		 * WindowEvent)
		 */
		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent
		 * )
		 */
		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent
		 * )
		 */
		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * The Class AccionROI.
	 * 
	 * @see AccionROIEvent
	 */
	public class AccionROIListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			SelectionArea roi = null;
			try {
				roi = new SelectionArea(manipulador.getAcumulador_imagenes()
						.get(manipulador.getImagen_actual()).getImagen(),
						manipulador);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Imagenes imagen_roi = null;
			imagen_roi = new Imagenes();
			imagen_roi.setImagen(roi.getImagen_roi());
			manipulador.crearImagen(imagen_roi);

			PintarImagen nueva_pintura = new PintarImagen(manipulador);
			nueva_pintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}
	}

	/**
	 * The Class AccionEcualizarHistograma.
	 * 
	 * @see AccionEcualizarHistogramaEvent
	 */
	public class AccionEcualizarHistogramaListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			manipulador.ecualizarHistograma();

			PintarImagen nuevaPintura = new PintarImagen(manipulador);
			nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}
	}

	/**
	 * The Class AccionEspecificarHistograma.
	 * 
	 * @see AccionEspecificarHistogramaEvent
	 */
	public class AccionEspecificarHistogramaListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SeleccionImagenEspecifica seleccionImagen = new SeleccionImagenEspecifica();

			if (seleccionImagen.getEleccion() < 0
					|| seleccionImagen.getEleccion() > manipulador
							.getAcumulador_imagenes().size())
				seleccionImagen.error();
			else {
				manipulador
						.especificarHistograma(seleccionImagen.getEleccion());

				PintarImagen nuevaPintura = new PintarImagen(manipulador);
				nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
						manipulador));
			}
		}
	}

	/**
	 * The Class AccionCorreccionGamma.
	 * 
	 * @see AccionCorreccionGammaEvent
	 */
	public class AccionCorreccionGammaListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SeleccionGamma seleccionGamma = new SeleccionGamma();

			if (seleccionGamma.getEleccion() < 0.0)
				seleccionGamma.error();
			else {
				manipulador.correccionGamma(seleccionGamma.getEleccion());

				PintarImagen nuevaPintura = new PintarImagen(manipulador);
				nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
						manipulador));
			}
		}
	}

	/**
	 * The Class AccionDiferenciaImagenes.
	 * 
	 * @see AccionDiferenciaImagenesEvent
	 */
	public class AccionDiferenciaImagenesListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SeleccionImagenEspecifica seleccionImagen = new SeleccionImagenEspecifica();

			if (seleccionImagen.getEleccion() < 0
					|| seleccionImagen.getEleccion() > manipulador
							.getAcumulador_imagenes().size())
				seleccionImagen.error();
			else {
				Imagenes nuevaImagen = manipulador
						.restaImagenes(seleccionImagen.getEleccion());
				Histograma nuevoHistograma = new Histograma(nuevaImagen);
				nuevoHistograma.getHistogram();
				PlotHistograma pintarHisograma = new PlotHistograma(
						nuevoHistograma);
				pintarHisograma.plotHistograma();

				SeleccionUmbral nuevaSeleccion = new SeleccionUmbral();

				int imagenActual = manipulador.getImagen_actual();

				do {
					nuevaSeleccion.pedirUmbral();

					if (!nuevaSeleccion.isCerrar()) {
						manipulador.setImagen_actual(imagenActual);

						manipulador.diferenciaDeImagenes(nuevaImagen,
								manipulador
										.diferenciaImagenesLUT(nuevaSeleccion
												.getUmbral()));

						PintarImagen nuevaPintura = new PintarImagen(
								manipulador);
						nuevaPintura
								.addWindowListenerFrame(new WindowActiveListener(
										manipulador));
					}
				} while (!nuevaSeleccion.isCerrar());
			}
		}
	}

	/**
	 * The listener interface for receiving accionDigitalizacion events. The
	 * class that is interested in processing a accionDigitalizacion event
	 * implements this interface, and the object created with that class is
	 * registered with a component using the component's
	 * <code>addAccionDigitalizacionListener<code> method. When
	 * the accionDigitalizacion event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionDigitalizacionEvent
	 */
	public class AccionDigitalizacionListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		public void actionPerformed(ActionEvent arg0) {
			SeleccionDigitalizacion seleccionDigital = new SeleccionDigitalizacion();

			manipulador.digitalizar(seleccionDigital.getMuestreo_1(),
					seleccionDigital.getMuestreo_2(),
					seleccionDigital.getCuantizacion());

			PintarImagen nuevaPintura = new PintarImagen(manipulador);
			nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}
	}

	/**
	 * The listener interface for receiving accionEntropia events. The class
	 * that is interested in processing a accionEntropia event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionEntropiaListener<code> method. When
	 * the accionEntropia event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionEntropiaEvent
	 */
	public class AccionEntropiaListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double entropia = manipulador
					.getEntropia(
							manipulador.getAcumulador_imagenes()
									.get(manipulador.getImagen_actual())
									.getPixel_red(),
							manipulador.getAcumulador_imagenes()
									.get(manipulador.getImagen_actual())
									.getImagen().getWidth(),
							manipulador.getAcumulador_imagenes()
									.get(manipulador.getImagen_actual())
									.getImagen().getWidth());

			JOptionPane.showMessageDialog(interfazGrafica.frame,
					Double.toString(entropia), null,
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * The Class AccionContraste.
	 */
	public class AccionContrasteBrilloListner implements ActionListener {

		/** The contraste brillo. */
		private ContrasteBrillo contrasteBrillo;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			setContrasteBrillo(new ContrasteBrillo(manipulador
					.getAcumulador_imagenes().get(
							manipulador.getImagen_actual())));

			Imagenes imagen = null;
			imagen = new Imagenes();

			imagen.setImagen(contrasteBrillo.getImagen_resultado());
			manipulador.crearImagen(imagen);

			PintarImagen nuevaPintura = new PintarImagen(manipulador);
			nuevaPintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));

		}

		/**
		 * Gets the contraste brillo.
		 * 
		 * @return the contraste brillo
		 */
		public ContrasteBrillo getContrasteBrillo() {
			return contrasteBrillo;
		}

		/**
		 * Sets the contraste brillo.
		 * 
		 * @param contrasteBrillo
		 *            the new contraste brillo
		 */
		public void setContrasteBrillo(ContrasteBrillo contrasteBrillo) {
			this.contrasteBrillo = contrasteBrillo;
		}

	}

	/**
	 * The listener interface for receiving accionBinarizar events. The class
	 * that is interested in processing a accionBinarizar event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionBinarizarListener<code> method. When
	 * the accionBinarizar event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionBinarizarEvent
	 */
	public class AccionBinarizarListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			SeleccionUmbral umbral = new SeleccionUmbral();
			umbral.pedirUmbral();

			Imagenes imagen_binarizada = null;
			imagen_binarizada = new Imagenes();

			imagen_binarizada.setImagen(manipulador.binarize(
					manipulador.getAcumulador_imagenes()
							.get(manipulador.getImagen_actual()).getImagen(),
					umbral.getUmbral()));
			manipulador.crearImagen(imagen_binarizada);

			PintarImagen nueva_pintura = new PintarImagen(manipulador);
			nueva_pintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}
	}

	/**
	 * The listener interface for receiving accionAcercaDe events. The class
	 * that is interested in processing a accionAcercaDe event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionAcercaDeListener<code> method. When
	 * the accionAcercaDe event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionAcercaDeEvent
	 */
	public class AccionAcercaDeListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(interfazGrafica.frame,
					InterfazGrafica.ACERCA_DE_MENSAJE);
		}

	}

	/**
	 * The listener interface for receiving accionTFT events. The class that is
	 * interested in processing a accionTFT event implements this interface, and
	 * the object created with that class is registered with a component using
	 * the component's <code>addAccionTFTListener<code> method. When
	 * the accionTFT event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionTFTEvent
	 */
	public class AccionTFTListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			NumeroTramos pedir_numeros = new NumeroTramos();
			pedir_numeros.pedirNumeros();
			TransformacionLinealesTramos sTramos = new TransformacionLinealesTramos(
					manipulador.getAcumulador_imagenes()
							.get(manipulador.getImagen_actual()).getImagen(),
					pedir_numeros.getNum_puntos());

			Imagenes imagen_resultado = new Imagenes();
			imagen_resultado.setImagen(sTramos.getImagen_transformada());

			manipulador.crearImagen(imagen_resultado);
			PintarImagen nueva_pintura = new PintarImagen(manipulador);
			nueva_pintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}

	}

	/**
	 * The listener interface for receiving accionSalir events. The class that
	 * is interested in processing a accionSalir event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionSalirListener<code> method. When
	 * the accionSalir event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionSalirEvent
	 */
	public class AccionSalirListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

	}

	/**
	 * The listener interface for receiving accionPerfil events. The class that
	 * is interested in processing a accionPerfil event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addAccionPerfilListener<code> method. When
	 * the accionPerfil event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see AccionPerfilEvent
	 */
	public class AccionPerfilListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Perfil perfil = new Perfil(manipulador.getAcumulador_imagenes()
					.get(manipulador.getImagen_actual()).getImagen());
		}

	}

	public class AccionEspejoVerticalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Imagenes imagen_espejo = new Imagenes();
			imagen_espejo.setImagen(manipulador.espejoVertical(manipulador
					.getAcumulador_imagenes()
					.get(manipulador.getImagen_actual()).getImagen()));
			manipulador.crearImagen(imagen_espejo);
			PintarImagen nueva_pintura = new PintarImagen(manipulador);
			nueva_pintura.addWindowListenerFrame(new WindowActiveListener(
					manipulador));
		}

	}
}
