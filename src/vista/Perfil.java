/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: Perfil.java
  Fecha: 18/11/2014
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Imagenes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// TODO: Auto-generated Javadoc
/**
 * The Class Perfil.
 * 
 * @author Sawan
 */
public class Perfil implements MouseListener, MouseMotionListener {

	/** The Constant TITULO. */
	private final static String TITULO = "Perfil de imagen";

	/** The Constant MAX_ERROR. */
	private final static double MAX_ERROR = 0.5;

	/** The scrollpane. */
	public JScrollPane scrollpane;

	/** The imagen. */
	private BufferedImage imagen;

	/** The pic label. */
	public JLabel picLabel;

	/** The panel_imagen. */
	public JPanel panel_imagen;

	/** The start y. */
	private int startX, startY;

	/** The prev y. */
	private int prevX, prevY;

	/** The dragging. */
	private boolean dragging = false;

	/** The gc. */
	private Graphics gc;

	/** The x_points. */
	private ArrayList<Integer> x_points;

	/** The y_points. */
	private ArrayList<Integer> y_points;
	
	private ArrayList<Integer> x_derivative_points;
	private ArrayList<Integer> y_derivative_points;

	/** The chart panel. */
	private JPanel chartPanel;
	private JPanel charJPanel;
	
	/** The chart. */
	private JFreeChart chart;
	
	private JFreeChart chart_derative;
	
	/** The coordenadas_puntos. */
	private double[][] coordenadas_puntos;
	
	private double[][] coordenadas_derivada;
	
	/**
	 * Instantiates a new perfil.
	 * 
	 * @param img
	 *            the img
	 */
	public Perfil(final BufferedImage img) {
		scrollpane = new JScrollPane();
		imagen = Imagenes.deepCopy(img);

		x_points = new ArrayList<Integer>();
		y_points = new ArrayList<Integer>();
		x_derivative_points = new ArrayList<Integer>();
		y_derivative_points = new ArrayList<Integer>();
		
		panel_imagen = new JPanel();
		panel_imagen.setBounds(5, 8, imagen.getWidth(), imagen.getHeight());
		picLabel = new JLabel(new ImageIcon(imagen));
		panel_imagen.addMouseListener(this);
		panel_imagen.addMouseMotionListener(this);

		chartPanel = new JPanel();
		chartPanel.setLayout(new BorderLayout());
		chartPanel.setBounds(imagen.getWidth() + 50, 8 , 500, imagen.getHeight());
		chartPanel.setVisible(true);

		
		charJPanel = new JPanel();
		charJPanel.setLayout(new BorderLayout());
		charJPanel.setBounds(5, imagen.getHeight() + 21 , 500, imagen.getHeight());
		charJPanel.setVisible(true);
		
		scrollpane.setLayout(null);
		panel_imagen.add(picLabel);

		scrollpane.add(panel_imagen);

		scrollpane.add(chartPanel);
		scrollpane.add(charJPanel);

		
		scrollpane.setPreferredSize(new Dimension(1300, 750));
		scrollpane.setVisible(true);

		int option_value = JOptionPane.showOptionDialog(null, scrollpane,
				TITULO, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	@Override
	public void mouseDragged(MouseEvent evt) {
		// TODO Auto-generated method stub

		if (!dragging)
			return;
		gc.drawLine(startX, startY, prevX, prevY);
		prevX = evt.getX();
		prevY = evt.getY();
		gc.drawLine(startX, startY, prevX, prevY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		x_points.clear();
		y_points.clear();
		
		startX = evt.getX();
		startY = evt.getY();
		prevX = startX;
		prevY = startY;
		dragging = true;
		gc = picLabel.getGraphics();
		picLabel.repaint();
		gc.setColor(Color.BLUE);
		gc.setXORMode(picLabel.getBackground());
		gc.drawLine(startX, startY, prevX, prevY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent evt) {
		// TODO Auto-generated method stub
		if (!dragging)
			return;
		gc.drawLine(startX, startY, prevX, prevY);
		int endX = evt.getX();
		int endY = evt.getY();
		gc.setPaintMode();
		gc.drawLine(startX, startY, endX, endY);
		if (startX == endX) {
			verticalLinePoints(startX, endX, startY, endY);
		} else {
			bresenhamPoints(startX, endX, startY, endY);
		}
		coordenadas_puntos = createChartData(x_points, y_points);
		getDerivativePoints();
		coordenadas_derivada = createChartDataDerivative(x_derivative_points, y_derivative_points);
		//showMatrix();
		plotCoord();
		plotDerivative();
		gc.dispose();
		
		
		
	}

	public void getDerivativePoints() {
		for (int i = 0; i < coordenadas_puntos.length; i++) {
			if (i ==  0) {
				x_derivative_points.add((int) coordenadas_puntos[i][0]);
				y_derivative_points.add((int) coordenadas_puntos[i][1]);
			} else {
				x_derivative_points.add((int) coordenadas_puntos[i][0]);
				y_derivative_points.add((int) coordenadas_puntos[i][1]  - (int) coordenadas_puntos[i - 1][1]);
			}
		}
	}
	
	
	/**
	 * Show matrix.
	 */
	public void showMatrix() {
		for (int i = 0; i < coordenadas_puntos.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(coordenadas_puntos[i][j]);
			}
		}
	}
	
	/**
	 * Bresenham points.
	 * 
	 * @param x0
	 *            the x0
	 * @param x1
	 *            the x1
	 * @param y0
	 *            the y0
	 * @param y1
	 *            the y1
	 * @return the double[][]
	 */
	public void bresenhamPoints(int x0, int x1, int y0, int y1) {

		int delta_x = x1 - x0;
		int delta_y = y1 - y0;

		double error = 0;
		double delta_error = Math.abs(delta_y / delta_x);

		int y = y0;

		for (int x = x0; x <= x1; x++) {
			x_points.add(x);
			y_points.add(y);

			
			error = error + delta_error;
			if (error >= MAX_ERROR) {
				y++;
				error--;
			}
		}

	}

	/**
	 * Vertical line points.
	 * 
	 * @param x0
	 *            the x0
	 * @param x1
	 *            the x1
	 * @param y0
	 *            the y0
	 * @param y1
	 *            the y1
	 */
	public void verticalLinePoints(int x0, int x1, int y0, int y1) {
		for (int x = x0; x <= x1; x++) {
			x_points.add(x);
			y_points.add(y0);
		}
	}

	
	
	/**
	 * Plot coord.
	 */
	public void plotCoord() {
		chart = ChartFactory.createXYLineChart(
				"Grafica", "Posicion", "Nivel de Gris",  createData(coordenadas_puntos), PlotOrientation.VERTICAL,
				true, true, false);
		chart_derative = ChartFactory.createXYLineChart(
				"Grafica", "Posicion", "Nivel de Gris",  createData(coordenadas_derivada), PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel subchart = new ChartPanel(chart);
		chartPanel.add(subchart);
		chartPanel.validate();
		
	}

	public void plotDerivative() {
		chart_derative = ChartFactory.createXYLineChart(
				"1º Derivada", "Posicion", "Nivel de Gris",  createData(coordenadas_derivada), PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel subchart = new ChartPanel(chart_derative);
		charJPanel.add(subchart);
		charJPanel.validate();
	}
	
	/**
	 * Checks if is component in panel.
	 *
	 * @param component the component
	 * @return true, if is component in panel
	 */
	public boolean isComponentInPanel(Component component) {
	    return
	            java.util.Arrays.asList(scrollpane.getComponents())
	                .contains(component);
	    }
	
	/**
	 * Creates the data.
	 *
	 * @param data the data
	 * @return the XY dataset
	 */
	private XYDataset createData(double[][] data) {
		final XYSeries series = new XYSeries("Pixeles");
		int iterator;
		for (int i = 0; i < data.length; i++) {
			iterator = 0;
			series.add(data[i][iterator], data[i][iterator + 1]);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection(series);
		return dataset;
	}
		
	public double[][] createChartDataDerivative(ArrayList<Integer> x_points, ArrayList<Integer> y_points) {
		double[][] data  = new double[x_points.size()][2];
		
		Iterator<Integer> x_iterator = x_points.iterator();
		Iterator<Integer> y_iterator = y_points.iterator();
		
		int i = 0;
		
		while (x_iterator.hasNext() && y_iterator.hasNext()) {
			int x_value = x_iterator.next();
			int y_value = y_iterator.next();
			
			
			data[i][0] = x_value;
			data[i][1] = y_value;
			i++;
		}
		return data;
	}
	
	
	
	/**
	 * Creates the chart data.
	 *
	 * @param x_points the x_points
	 * @param y_points the y_points
	 * @return the double[][]
	 */
	public double[][] createChartData(ArrayList<Integer> x_points, ArrayList<Integer> y_points) {
		double[][] data  = new double[x_points.size()][2];
		
		Iterator<Integer> x_iterator = x_points.iterator();
		Iterator<Integer> y_iterator = y_points.iterator();
		
		int i = 0;
		
		while (x_iterator.hasNext() && y_iterator.hasNext()) {
			int x_value = x_iterator.next();
			int y_value = y_iterator.next();
			
			
			data[i][0] = x_value;
			data[i][1] = Imagenes.getRedPoint(imagen, x_value, y_value);
			i++;
		}
		return data;
	}
	
}
