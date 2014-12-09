/**
 * 
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.ManipuladorImagenes;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectionArea.
 * 
 * @author Sawan
 */
public class SelectionArea {

	/** The Constant MENSAJE_SELECCION. */
	private final static String MENSAJE_SELECCION = "Seleccione  la región de interes que desea ver";

	/** The Constant ROI. */
	private final static String ROI = "Region de interes: ";

	/** The Constant PUNTO_COMIENZO. */
	private final static String PUNTO_COMIENZO = "Puntos de Comienzo: ";

	/** The Constant MENSAJE_PRE. */
	private final static String MENSAJE_PRE = "Seleccione en un rectangulo la region que desea ver";

	/** The capture rect. */
	private Rectangle captureRect;

	/** The x_rect. */
	private int x_rect;
	
	/** The y_rect. */
	private int y_rect;
	
	/** The width_rect. */
	private int width_rect;
	
	/** The height_rect. */
	private int height_rect;
	
	/** The imagen_roi. */
	private BufferedImage imagen_roi;
	
	/**
	 * Instantiates a new selection area.
	 *
	 * @param screen            the screen
	 * @param mImagenes the m imagenes
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public SelectionArea(final BufferedImage screen,
			ManipuladorImagenes mImagenes) throws IOException {
		final BufferedImage screenCopy = new BufferedImage(screen.getWidth(),
				screen.getHeight(), screen.getType());
		final JLabel screenLabel = new JLabel(new ImageIcon(screenCopy));
		JScrollPane screenScroll = new JScrollPane(screenLabel);
		
		setImagen_roi(null);
		
		x_rect = 0;
		y_rect = 0;
		width_rect = 0;
		height_rect = 0;
		
		screenScroll.setPreferredSize(new Dimension(screen.getWidth(), screen
				.getHeight()));

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(screenScroll, BorderLayout.CENTER);

		final JLabel selectionLabel = new JLabel(MENSAJE_PRE);
		panel.add(selectionLabel, BorderLayout.SOUTH);

		repaint(screen, screenCopy);
		screenLabel.repaint();

		screenLabel.addMouseMotionListener(new MouseMotionAdapter() {

			Point start = new Point();

			@Override
			public void mouseMoved(MouseEvent me) {
				start = me.getPoint();
				repaint(screen, screenCopy);
				selectionLabel.setText(PUNTO_COMIENZO + start);
				screenLabel.repaint();
			}

			@Override
			public void mouseDragged(MouseEvent me) {
				Point end = me.getPoint();
				captureRect = new Rectangle(start, new Dimension(end.x
						- start.x, end.y - start.y));
				x_rect = captureRect.getBounds().x;
				y_rect = captureRect.getBounds().y;
				width_rect = captureRect.getBounds().width;
				height_rect = captureRect.getBounds().height;
				repaint(screen, screenCopy);
				screenLabel.repaint();
				selectionLabel.setText(ROI + captureRect);
			}
		});

		int roi_value = JOptionPane.showOptionDialog(null, panel,
				MENSAJE_SELECCION, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);

		if (roi_value == JOptionPane.OK_OPTION) {
			setImagen_roi(screen.getSubimage(x_rect, y_rect, width_rect, height_rect));
		}

	}

	/**
	 * Repaint.
	 * 
	 * @param orig
	 *            the orig
	 * @param copy
	 *            the copy
	 */
	public void repaint(BufferedImage orig, BufferedImage copy) {
		Graphics2D g = copy.createGraphics();
		g.drawImage(orig, 0, 0, null);
		if (captureRect != null) {
			g.setColor(Color.RED);
			g.draw(captureRect);
			g.setColor(new Color(255, 255, 255, 150));
			g.fill(captureRect);
		}
		g.dispose();
	}

	public BufferedImage getImagen_roi() {
		return imagen_roi;
	}

	public void setImagen_roi(BufferedImage imagen_roi) {
		this.imagen_roi = imagen_roi;
	}

	
}
