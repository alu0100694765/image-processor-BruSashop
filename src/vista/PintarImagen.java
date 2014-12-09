package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import modelo.ManipuladorImagenes;

// TODO: Auto-generated Javadoc
/**
 * The Class PintarImagen.
 */
public class PintarImagen extends Thread{


	/** The frame. */
	private JFrame frame;
	
	/** The abrir imagen. */
	private AbrirImagen abrirImagen;
	
	/** The bottom bar. */
	private BottomBar bottomBar;
	
	private final static String N_IMAGEN = "Imagen ";
	
	/**
	 * Instantiates a new pintar imagen.
	 *
	 * @param manipulator the manipulator
	 */
	public PintarImagen(ManipuladorImagenes manipulator){
		frame = new JFrame(N_IMAGEN + (manipulator.getAcumulador_imagenes()
				.get(manipulator.getImagen_actual()).getId() + 1));

		frame.setSize(new Dimension(
				manipulator.getAcumulador_imagenes()
						.get(manipulator.getImagen_actual()).getImagen()
						.getWidth(), manipulator.getAcumulador_imagenes()
						.get(manipulator.getImagen_actual()).getImagen()
						.getHeight()
						+ BottomBar.HEIGHT));
		
		manipulator.crearHistograma();
		
		// interfazGrafica.frame.getContentPane().removeAll();
		bottomBar = new BottomBar(frame.getWidth());
		abrirImagen = new AbrirImagen(manipulator.getAcumulador_imagenes().get(manipulator.getImagen_actual()), bottomBar);
		frame.add(bottomBar, BorderLayout.SOUTH);
		frame.add(abrirImagen);
		frame.setVisible(true);
	}

	/**
	 * Adds the window listener frame.
	 *
	 * @param WindowEventActive the window event active
	 */
	public void addWindowListenerFrame(WindowListener WindowEventActive){
		frame.addWindowListener(WindowEventActive);
	}

	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Sets the frame.
	 *
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Gets the abrir imagen.
	 *
	 * @return the abrirImagen
	 */
	public AbrirImagen getAbrirImagen() {
		return abrirImagen;
	}

	/**
	 * Sets the abrir imagen.
	 *
	 * @param abrirImagen the abrirImagen to set
	 */
	public void setAbrirImagen(AbrirImagen abrirImagen) {
		this.abrirImagen = abrirImagen;
	}

	/**
	 * Gets the bottom bar.
	 *
	 * @return the bottomBar
	 */
	public BottomBar getBottomBar() {
		return bottomBar;
	}

	/**
	 * Sets the bottom bar.
	 *
	 * @param bottomBar the bottomBar to set
	 */
	public void setBottomBar(BottomBar bottomBar) {
		this.bottomBar = bottomBar;
	}

}
