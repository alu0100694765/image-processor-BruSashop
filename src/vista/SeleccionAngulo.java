/**
 * 
 */
package vista;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class SeleccionAngulo.
 *
 * @author Sawan
 */
public class SeleccionAngulo {
	
	private final static Integer[] ANGULOS = {90, 180, 270};
	
	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	/** The text. */
	JTextField text;
	
	JComboBox<Integer> angulo_box;
	
	/** The umbral. */
	int angulo;
	
	/** The cerrar. */
	boolean cerrar;

	
	/**
	 * Instantiates a new seleccion angulo.
	 */
	public SeleccionAngulo() {
		cerrar = false;
	}
	
	/**
	 * Pedir angulo.
	 */
	public void pedirAngulo(){
		panel = new JPanel(new BorderLayout());

		selectionLabel = new JLabel("Establezca un angulo");
		panel.add(selectionLabel, BorderLayout.CENTER);

		angulo_box = new JComboBox<Integer>(ANGULOS);
		panel.add(angulo_box, BorderLayout.SOUTH);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Eleccion de umbral", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);

		angulo = -1;
		
		if (selectionUmbral == JOptionPane.OK_OPTION) {
			angulo = Integer.parseInt(angulo_box.getSelectedItem().toString());
		}

		else{
			cerrar = true;
		}
	}

	/**
	 * Gets the angulo.
	 *
	 * @return the angulo
	 */
	public int getAngulo() {
		return angulo;
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
