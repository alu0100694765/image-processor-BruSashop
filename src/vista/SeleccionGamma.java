package vista;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class SeleccionGamma.
 */
public class SeleccionGamma {
	
	/** The eleccion. */
	private double eleccion;
	
	/**
	 * Instantiates a new seleccion gamma.
	 */
	public SeleccionGamma() {
		JPanel panel = new JPanel(new BorderLayout());
		
		final JLabel selectionLabel = new JLabel("Establezca un valor gamma");
		panel.add(selectionLabel, BorderLayout.CENTER);
		
		JTextField text = new JTextField();
		panel.add(text, BorderLayout.SOUTH);
		
		int selectionGamma = JOptionPane.showOptionDialog(null, panel,
				"Eleccion de valor Gamma", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
		
		eleccion = -1.0;
		
		if (selectionGamma == JOptionPane.OK_OPTION && (text.getText().matches("\\d+") || text.getText().matches("\\d+.\\d+"))){
			eleccion = Double.valueOf(text.getText());
		}
	}
	
	/**
	 * Error.
	 */
	public void error(){
		JPanel panel = new JPanel(new BorderLayout());
		
		final JLabel selectionLabel = new JLabel("Error: No se ha especificado bien el valor gamma");
		panel.add(selectionLabel, BorderLayout.CENTER);
		
		JOptionPane.showOptionDialog(null, panel,
				"Eleccion de valor Gamma", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
	}

	/**
	 * Gets the eleccion.
	 *
	 * @return the eleccion
	 */
	public double getEleccion() {
		return eleccion;
	}
}
