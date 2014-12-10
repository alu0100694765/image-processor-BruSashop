package vista;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeleccionAnguloUsuario {
	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	/** The text. */
	JTextField angulo;
	
	/** The width. */
	double angulo_;
	
	/** The cerrar. */
	boolean cerrar;

	/**
	 * Instantiates a new seleccion umbral.
	 */
	public SeleccionAnguloUsuario() {
		cerrar = false;
	}
	
	public void pedirAngulo(){
		panel = new JPanel(new GridBagLayout());
		
		selectionLabel = new JLabel("Introduzca El angulo de rotacin deseado ");
		panel.add(selectionLabel);

		angulo = new JTextField(3);
		panel.add(angulo);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Seleccion Dimensiones", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);
		
		if (selectionUmbral == JOptionPane.OK_OPTION
				&& (angulo.getText().matches("\\d+"))) {
			angulo_ = Integer.valueOf(angulo.getText());
		}

		else{
			cerrar = true;
		}
	}

	public double getAngulo_() {
		return angulo_;
	}
}
