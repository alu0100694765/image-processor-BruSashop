package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelo.Imagenes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class TransformacionLinealesTramos.
 */
public class TransformacionLinealesTramos {

	/** The frame. */
	public JScrollPane scrollpanel;

	/** The chart panel. */
	private JPanel chartPanel;
	
	/** The chart. */
	private JFreeChart chart;
	
	/** The num_puntos. */
	private int num_puntos;

	/** The num_textfields. */
	private JTextField[][] num_textfields;

	/** The coordenadas_puntos. */
	private double[][] coordenadas_puntos;

	/** The Constant NUM_COL. */
	private final static int NUM_COL = 2;

	/** The Constant X_BOUND_TXTFIELD. */
	private final static int X_BOUND_TXTFIELD = 25;

	/** The Constant Y_BOUND_TXTFIELD. */
	private final static int Y_BOUND_TXTFIELD = 25;

	/** The Constant SPACING. */
	private final static int SPACING = 50;

	/** The Constant TXTFIELD_HEIGHT. */
	private final static int TXTFIELD_HEIGHT = 20;

	/** The Constant TXTFIELD_WIDTH. */
	private final static int TXTFIELD_WIDTH = 45;

	/** The Constant TABING. */
	private final static int TABING = 90;

	/** The Constant Y. */
	public final static int Y = 1;

	/** The Constant X. */
	public static final int X = 0;
		
	/** The imagen_transformada. */
	private BufferedImage imagen_transformada;

	/**
	 * Instantiates a new transformacion lineales tramos.
	 *
	 * @param img the img
	 * @param n_puntos            the n_puntos
	 */
	public TransformacionLinealesTramos(BufferedImage img ,int n_puntos) {
		scrollpanel = new JScrollPane();
		scrollpanel.setPreferredSize(new Dimension(800,600));
		scrollpanel.setLayout(null);
		num_puntos = n_puntos + 1;
		num_textfields = new JTextField[num_puntos][NUM_COL];
		coordenadas_puntos = new double[num_puntos][NUM_COL];
		
		inicializarTextField();
		inicializarCoord();
		plotCoord();
		changeListenerTxtFields();
		
		int option_value = JOptionPane.showOptionDialog(null, scrollpanel,
				"Ingrese los puntos", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
		
		if (option_value  == JOptionPane.OK_OPTION) {
			imagen_transformada = Imagenes.deepCopy(tranformacionTramos(img, coordenadas_puntos));
		}
		
	
		
	}

	/**
	 * Inicializar text field.
	 */
	public void inicializarTextField() {
		for (int i = 0; i < num_puntos; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				if (i == (num_puntos - 1) && j == 0) {
					num_textfields[i][j] = new JTextField(
							String.valueOf(Imagenes.MAX_VALOR_PIXEL));
					num_textfields[i][j].setEditable(false);
				} else {
					num_textfields[i][j] = new JTextField(String.valueOf(0));
				}
				num_textfields[i][j].setBounds(X_BOUND_TXTFIELD + j * TABING,
						Y_BOUND_TXTFIELD + i * SPACING, TXTFIELD_WIDTH,
						TXTFIELD_HEIGHT);

				num_textfields[i][j].setVisible(true);
				scrollpanel.add(num_textfields[i][j]);

			}
		}
	}

	
	/**
	 * Change listener txt fields.
	 */
	public void changeListenerTxtFields() {
		for (int i = 0; i < num_puntos; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				num_textfields[i][j].getDocument().addDocumentListener(
						new TextFieldListener(i, j));
			}
		}
	}

	/**
	 * Sets the coordenadas.
	 * 
	 * @param index_i
	 *            the pos_i
	 * @param index_j
	 *            the pos_j
	 * @param d
	 *            the valor
	 */
	public void setCoordenadas(int index_i, int index_j, int d) {
		coordenadas_puntos[index_i][index_j] = d;
	}

	/**
	 * Prints the coord.
	 */
	public void printCoord() {
		for (int i = 0; i < num_puntos; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				System.out.println(coordenadas_puntos[i][j]);
			}
		}
	}

	/**
	 * Inicializar coord.
	 */
	public void inicializarCoord() {
		for (int i = 0; i < num_puntos; i++) {
			for (int j = 0; j < NUM_COL; j++) {
				coordenadas_puntos[i][j] = Integer
						.parseInt(num_textfields[i][j].getText());
			}
		}
	}

	/**
	 * The listener interface for receiving textField events. The class that is
	 * interested in processing a textField event implements this interface, and
	 * the object created with that class is registered with a component using
	 * the component's <code>addTextFieldListener<code> method. When
	 * the textField event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see TextFieldEvent
	 */
	public class TextFieldListener implements DocumentListener {

		/** The index_i. */
		private int index_i;

		/** The index_j. */
		private int index_j;

		/**
		 * Instantiates a new text field listener.
		 * 
		 * @param i
		 *            the i
		 * @param j
		 *            the j
		 */
		public TextFieldListener(int i, int j) {
			// TODO Auto-generated constructor stub
			this.index_i = i;
			this.index_j = j;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.event.DocumentListener#changedUpdate(javax.swing.event
		 * .DocumentEvent)
		 */
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.event.DocumentListener#insertUpdate(javax.swing.event
		 * .DocumentEvent)
		 */
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			setCoordenadas(
					index_i,
					index_j,
					Integer.parseInt(num_textfields[index_i][index_j].getText()));
			refreshChart();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.event.DocumentListener#removeUpdate(javax.swing.event
		 * .DocumentEvent)
		 */
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Plot coord.
	 */
	public void plotCoord() {
		chart = ChartFactory.createXYLineChart(
				"XY Series Demo", "X", "Y",  createData(coordenadas_puntos), PlotOrientation.VERTICAL,
				true, true, false);
		chartPanel = new JPanel();
		ChartPanel subchart = new ChartPanel(chart);
		chartPanel.add(subchart);
		chartPanel.setLayout(new BorderLayout());
		chartPanel.setBounds(X_BOUND_TXTFIELD + 200, Y_BOUND_TXTFIELD , 500, 270);
		scrollpanel.add(chartPanel);
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
	
	/**
	 * Refresh chart.
	 */
	private void refreshChart() {
	    chartPanel.removeAll();
	    chartPanel.revalidate(); // This removes the old chart 
	    ChartPanel cPanel = new ChartPanel(refreshChartData());
	    chartPanel.setBounds(X_BOUND_TXTFIELD + 200, Y_BOUND_TXTFIELD , 500, 270);
	    chartPanel.add(cPanel); 
	    chartPanel.repaint(); // This method makes the new chart appear
	}
	
	/**
	 * Refresh chart data.
	 *
	 * @return the j free chart
	 */
	public JFreeChart refreshChartData() {
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Tramos", "X", "Y",  createData(coordenadas_puntos), PlotOrientation.VERTICAL,
				true, true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.black);
		XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
		r.setSeriesShape(0, ShapeUtilities.createDiamond(5));
		r.setSeriesShapesVisible(0, true);
		return chart;
	}

	
	

	/**
	 * Tranformacion tramos.
	 *
	 * @param image the image
	 * @param puntos the puntos
	 * @return the buffered image
	 */
	public BufferedImage tranformacionTramos(BufferedImage image, double[][] puntos) {
		int[] LUT = Imagenes.crearLUT();
		int tramo = 0;
		for (int v_in = 0; v_in < LUT.length; v_in++) {
			if (v_in > puntos[tramo + 1][0]) {
				tramo++;
			}
			double a = getA(puntos[tramo][TransformacionLinealesTramos.X],
					puntos[tramo][TransformacionLinealesTramos.Y],
					puntos[tramo + 1][TransformacionLinealesTramos.X],
					puntos[tramo + 1][TransformacionLinealesTramos.Y]);
			double b = getB(puntos[tramo][TransformacionLinealesTramos.X],
					puntos[tramo][TransformacionLinealesTramos.Y], a);
			LUT[v_in] = (int) (a * v_in + b);
			
		}
		
		BufferedImage imagen_transformada = Imagenes.deepCopy(image);
		
		Imagenes.setPixelGrey(imagen_transformada, LUT);
		
		return imagen_transformada;
	}

	/**
	 * Gets the a.
	 *
	 * @param p1_x the p1_x
	 * @param p1_y the p1_y
	 * @param p2_x the p2_x
	 * @param p2_y the p2_y
	 * @return the a
	 */
	public double getA(double p1_x, double p1_y, double p2_x, double p2_y) {
		double termino_a;
		termino_a = (p2_y - p1_y) / (p2_x - p1_x);
		return termino_a;
	}

	/**
	 * Gets the b.
	 *
	 * @param p1_x the p1_x
	 * @param p1_y the p1_y
	 * @param termino_a the termino_a
	 * @return the b
	 */
	public double getB(double p1_x, double p1_y, double termino_a) {
		double termino_b;
		termino_b = p1_y - (termino_a * p1_x);
		return termino_b;
	}

	
	/**
	 * Gets the coordenadas_puntos.
	 *
	 * @return the coordenadas_puntos
	 */
	public double[][] getCoordenadas_puntos() {
		return coordenadas_puntos;
	}

	/**
	 * Sets the coordenadas_puntos.
	 *
	 * @param coordenadas_puntos the coordenadas_puntos to set
	 */
	public void setCoordenadas_puntos(double[][] coordenadas_puntos) {
		this.coordenadas_puntos = coordenadas_puntos;
	}

	/**
	 * Gets the num_puntos.
	 *
	 * @return the num_puntos
	 */
	public int getNum_puntos() {
		return num_puntos;
	}

	/**
	 * Gets the imagen_transformada.
	 *
	 * @return the imagen_transformada
	 */
	public BufferedImage getImagen_transformada() {
		return imagen_transformada;
	}

	
}
