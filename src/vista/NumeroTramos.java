package vista;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class NumeroTramos.
 */
public class NumeroTramos {

	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	/** The text. */
	JTextField text;

	/** The num_puntos. */
	int num_puntos;

	/** The cerrar. */
	boolean cerrar;

	/**
	 * Instantiates a new numero tramos.
	 */
	public NumeroTramos() {
		cerrar = false;
	}

	/**
	 * Pedir numeros.
	 * 
	 * Pide el usuario el numero de tramos que desea crear
	 * 
	 */
	public void pedirNumeros() {
		panel = new JPanel(new BorderLayout());

		selectionLabel = new JLabel(
				"Establezca el numero de tramos que desea seleccionar");
		panel.add(selectionLabel, BorderLayout.CENTER);

		text = new JTextField();
		panel.add(text, BorderLayout.SOUTH);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Eleccion de umbral", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);

		num_puntos = -1;

		if (selectionUmbral == JOptionPane.OK_OPTION
				&& (text.getText().matches("\\d+") || text.getText().matches(
						"\\d+.\\d+"))) {
			num_puntos = Integer.valueOf(text.getText());
		}

		else {
			cerrar = true;
		}
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
	 * Checks if is cerrar.
	 *
	 * @return true, if is cerrar
	 */
	public boolean isCerrar() {
		return cerrar;
	}
}
