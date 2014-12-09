/**
 * 
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import modelo.Imagenes;

// TODO: Auto-generated Javadoc
/**
 * The Class AbrirImagen.
 * 
 * @author Sawan
 */
public class AbrirImagen extends JPanel  implements MouseMotionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The img. */
	private Imagenes img;

	private BottomBar bottomBar;

	/**
	 * Instantiates a new abrir imagen.
	 * 
	 * @param image
	 *            the image
	 */
	public AbrirImagen(Imagenes image, BottomBar botbar) {
		img = image;
		bottomBar = botbar;
		addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(img.getImagen().getWidth(), img
				.getImagen().getHeight()));
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImagen(), 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Point point = e.getPoint();
		int red = img.getRedPoint((int) point.getX(), (int) point.getY());
		int green = img.getGreenPoint((int) point.getX(), (int) point.getY());
		int blue = img.getBluePoint((int) point.getX(), (int) point.getY());
		String mensaje_barra = BottomBar.HEIGHT_STR
				+ img.getImagen().getHeight() + " " + BottomBar.PIXEL_STR
				+ "   " + BottomBar.WIDHT_STR + img.getImagen().getWidth()
				+ " " + BottomBar.PIXEL_STR + "  " + BottomBar.PIXEL + "("
				+ point.getX() + ", " + point.getY() + ")" + " "
				+ bottomBar.showRGB(red, green, blue);
		bottomBar.lbl_informacion.setText(mensaje_barra);
	}



	/**
	 * @return the img
	 */
	public Imagenes getImg() {
		return img;
	}



	/**
	 * @param img the img to set
	 */
	public void setImg(Imagenes img) {
		this.img = img;
	}
	
	
}