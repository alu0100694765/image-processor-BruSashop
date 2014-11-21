package vista;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class SeleccionImagenEspecifica.
 */
public class SeleccionImagenEspecifica {
	
	/** The eleccion. */
	private int eleccion;
	
	/**
	 * Instantiates a new seleccion imagen especifica.
	 */
	public SeleccionImagenEspecifica(){
		JPanel panel = new JPanel(new BorderLayout());
		
		final JLabel selectionLabel = new JLabel("Elija la imagen cuyo histograma quiere especificar");
		panel.add(selectionLabel, BorderLayout.CENTER);
		
		JTextField text = new JTextField();
		panel.add(text, BorderLayout.SOUTH);
		
		int selectionImage = JOptionPane.showOptionDialog(null, panel,
				"eleccion de imagenes", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
		
		eleccion = -1;
		
		if (selectionImage == JOptionPane.OK_OPTION && text.getText().matches("\\d+")){
			eleccion += Integer.valueOf(text.getText());
		}
	}

	/**
	 * Error.
	 */
	public void error(){
		JPanel panel = new JPanel(new BorderLayout());
		
		final JLabel selectionLabel = new JLabel("Error: No se ha especificado la imagen correctamente");
		panel.add(selectionLabel, BorderLayout.CENTER);
		
		JOptionPane.showOptionDialog(null, panel,
				"eleccion de imagenes", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
	}
	
	/**
	 * Gets the eleccion.
	 *
	 * @return the eleccion
	 */
	public int getEleccion() {
		return eleccion;
	}
}
