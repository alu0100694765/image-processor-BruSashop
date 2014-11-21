package vista;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class SeleccionUmbral.
 */
public class SeleccionUmbral {
	
	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	/** The text. */
	JTextField text;
	
	/** The umbral. */
	int umbral;
	
	/** The cerrar. */
	boolean cerrar;

	/**
	 * Instantiates a new seleccion umbral.
	 */
	public SeleccionUmbral() {
		cerrar = false;
	}
	
	/**
	 * Pedir umbral.
	 */
	public void pedirUmbral(){
		panel = new JPanel(new BorderLayout());

		selectionLabel = new JLabel("Establezca un umbral");
		panel.add(selectionLabel, BorderLayout.CENTER);

		text = new JTextField();
		panel.add(text, BorderLayout.SOUTH);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Eleccion de umbral", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);

		umbral = -1;
		
		if (selectionUmbral == JOptionPane.OK_OPTION
				&& (text.getText().matches("\\d+") || text.getText().matches(
						"\\d+.\\d+"))) {
			umbral = Integer.valueOf(text.getText());
		}

		else{
			cerrar = true;
		}
	}

	/**
	 * Gets the umbral.
	 *
	 * @return the umbral
	 */
	public int getUmbral() {
		return umbral;
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
