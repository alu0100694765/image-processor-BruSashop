/**
 *Nombre de Usuario: Sawan
  Correo electronico : alu0100694765@ull.edu.es
  Nombre fichero: Histograma.java
  Fecha: 30/09/2014
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;

import modelo.Histograma;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

// TODO: Auto-generated Javadoc
/**
 * The Class PlotHistograma.
 *
 * @author Sawan
 */
public class PlotHistograma {

	/** The Constant TITULO_FRAME. */
	private final static String TITULO_FRAME = "HISTOGRAMA";
	
	/** The Constant RED. */
	private final static String RED = "Red";
	
	/** The Constant GREEN. */
	private final static String GREEN = "Green";
	
	/** The Constant BLUE. */
	private final static String BLUE = "Blue";
	
	/** The Constant ALPHA. */
	private final static String ALPHA = "Alpha";
		
	/** The histograma. */
	private Histograma histograma;
	
	/** The frame_histograma. */
	//public JFrame frame_histograma;
	
	/**
	 * Instantiates a new plot histograma.
	 *
	 * @param histograma the histograma
	 */
	public PlotHistograma(Histograma histograma) {
		this.histograma = histograma;
		
	}

	/**
	 * Plot histograma acumulativo.
	 * 
	 */
	public void plotHistogramaAcumulativo() {
		JFrame frame_acumulativo = new JFrame(TITULO_FRAME);
		
        frame_acumulativo.setLayout(new GridLayout(0,2));
		
		frame_acumulativo.setSize(800, 800);
		frame_acumulativo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame_acumulativo.setBackground(Color.WHITE);
		frame_acumulativo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame_acumulativo.setVisible(true);

		
		/**
		 * Creacion de las series para el histograma
		 */
		IntervalXYDataset dataset_red = createDataset(histograma.getPixel_red_histograma_acumulativo());
		IntervalXYDataset dataset_green = createDataset(histograma.getPixel_green_histograma_acumulativo());
		IntervalXYDataset dataset_blue = createDataset(histograma.getPixel_blue_histograma_acumulativo());
		IntervalXYDataset dataset_alpha = createDataset(histograma.getPixel_alpha_histograma_acumulativo());
		
		/**
		 * Creacion de los histogramas
		 */
		JFreeChart chart_red = createChart(dataset_red, RED);
		JFreeChart chart_green = createChart(dataset_green, GREEN);
		JFreeChart chart_blue = createChart(dataset_blue, BLUE);
		JFreeChart chart_alpha = createChart(dataset_alpha, ALPHA);
		
		/**
		 * Creacion de los paneles en los que iran los histogramas
		 */
		 ChartPanel chartPanel_red = new ChartPanel(chart_red);
		 ChartPanel chartPanel_green = new ChartPanel(chart_green);
		 ChartPanel chartPanel_blue = new ChartPanel(chart_blue);
		 ChartPanel chartPanel_alpha = new ChartPanel(chart_alpha);
		
		/**
		 * Tamaño de los histogramas
		 */
		chartPanel_red.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_green.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_blue.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_alpha.setPreferredSize(new java.awt.Dimension(400, 400));
		
			
		/**
		 * Acceso al zoom de las graficas
		 */
		chartPanel_red.setMouseWheelEnabled(true);
        chartPanel_green.setMouseWheelEnabled(true);
        chartPanel_blue.setMouseWheelEnabled(true);
        chartPanel_alpha.setMouseWheelEnabled(true);
        
        frame_acumulativo.getContentPane().removeAll();
        frame_acumulativo.getContentPane().add(chartPanel_red);
		frame_acumulativo.getContentPane().add(chartPanel_green);
		frame_acumulativo.getContentPane().add(chartPanel_blue);
		frame_acumulativo.getContentPane().add(chartPanel_alpha);
	
	}
	
	/**
	 * Plot histograma.
	 */
	public void plotHistograma() {
		JFrame frame_histograma = new JFrame(TITULO_FRAME);
		
        frame_histograma.setLayout(new GridLayout(0,2));
		
		frame_histograma.setSize(800, 800);
		frame_histograma.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame_histograma.setBackground(Color.WHITE);
		frame_histograma.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame_histograma.setVisible(true);

		
		/**
		 * Creacion de las series para el histograma
		 */
		IntervalXYDataset dataset_r = createDataset(histograma.getPixel_red_histograma());
		IntervalXYDataset dataset_g = createDataset(histograma.getPixel_green_histograma());
		IntervalXYDataset dataset_b = createDataset(histograma.getPixel_blue_histograma());
		IntervalXYDataset dataset_a = createDataset(histograma.getPixel_alpha_histograma());
		
		/**
		 * Creacion de los histogramas
		 */
		JFreeChart chart_r = createChart(dataset_r, RED);
		JFreeChart chart_g = createChart(dataset_g, GREEN);
		JFreeChart chart_b = createChart(dataset_b, BLUE);
		JFreeChart chart_a = createChart(dataset_a, ALPHA);
		
		/**
		 * Creacion de los paneles en los que iran los histogramas
		 */
		 ChartPanel chartPanel_r = new ChartPanel(chart_r);
		 ChartPanel chartPanel_g = new ChartPanel(chart_g);
		 ChartPanel chartPanel_b = new ChartPanel(chart_b);
		 ChartPanel chartPanel_a = new ChartPanel(chart_a);
		
		/**
		 * Tamaño de los histogramas
		 */
		chartPanel_r.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_g.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_b.setPreferredSize(new java.awt.Dimension(400, 400));
		chartPanel_a.setPreferredSize(new java.awt.Dimension(400, 400));
		
			
		/**
		 * Acceso al zoom de las graficas
		 */
		chartPanel_r.setMouseWheelEnabled(true);
        chartPanel_g.setMouseWheelEnabled(true);
        chartPanel_b.setMouseWheelEnabled(true);
        chartPanel_a.setMouseWheelEnabled(true);
        
        frame_histograma.getContentPane().removeAll();
        frame_histograma.getContentPane().add(chartPanel_r);
		frame_histograma.getContentPane().add(chartPanel_g);
		frame_histograma.getContentPane().add(chartPanel_b);
		frame_histograma.getContentPane().add(chartPanel_a);
		
	}
	
	/**
	 * Creates the chart.
	 *
	 *	Crea un grafico pasandole un color por string y una serie de datos	
	 *
	 * @param dataset the dataset
	 * @param titulo the titulo
	 * @return the j free chart
	 */
	private JFreeChart createChart(IntervalXYDataset dataset, String titulo) {
		final JFreeChart chart = ChartFactory.createXYBarChart(
				titulo, "X", false, "Y", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYBarRenderer rend = (XYBarRenderer) plot.getRenderer();
        rend.setBarPainter( new StandardXYBarPainter() );
        rend.setShadowVisible(false);
		final IntervalMarker target = new IntervalMarker(400.0, 700.0);
		target.setLabel("Target Range");
		target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
		target.setLabelAnchor(RectangleAnchor.LEFT);
		target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
		if (titulo.equals(RED)) {
			plot.getRenderer().setSeriesPaint(0, Color.RED);
		} else if (titulo.equals(GREEN)) {
			plot.getRenderer().setSeriesPaint(0, Color.GREEN);
		} else if (titulo.equals(BLUE)) {
			plot.getRenderer().setSeriesPaint(0, Color.BLUE);
		} else if (titulo.equals(ALPHA)) {
			plot.getRenderer().setSeriesPaint(0, Color.BLACK);
		}
		plot.addRangeMarker(target, Layer.BACKGROUND);
		return chart;
	}

	

	/**
	 * Creates the dataset.
	 * 
	 * Crea las series de datos
	 * 
	 * @param data the data
	 * @return the interval xy dataset
	 */
	private IntervalXYDataset createDataset(int [] data) {
		final XYSeries series = new XYSeries("Pixeles");
		for (int i = 0; i < data.length - 1; i++) {
			series.add((double) i, (double) data[i]);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection(series);
		return dataset;
	}
}
