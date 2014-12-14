package vista;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeleccionAnguloUsuario {
	
	private final static String[] INTERPOLACION = {"Interpolacion VMP", "Interpolacion Bilineal"};
	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	JLabel selectionLabelInterp;
	/** The text. */
	JTextField angulo;
	
	JComboBox<String> interp_box;
	
	/** The width. */
	double angulo_;
	
	boolean seleccion = false;
	
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
		
		selectionLabel = new JLabel("Introduzca El angulo de rotacion deseado ");
		panel.add(selectionLabel);

		angulo = new JTextField(3);
		panel.add(angulo);
		
		selectionLabelInterp = new JLabel("Introduzca El metodo de interpolacion deseado ");
		panel.add(selectionLabelInterp);
		
		interp_box = new JComboBox<String>(INTERPOLACION);
		panel.add(interp_box);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Seleccion Dimensiones", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);
		
		if (selectionUmbral == JOptionPane.OK_OPTION
				&& (angulo.getText().matches("\\d+"))) {
			angulo_ = Integer.valueOf(angulo.getText());
			if(interp_box.getSelectedItem().toString().matches("Interpolacion Bilineal"))
				seleccion = true;
		}

		else{
			cerrar = true;
		}
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public double getAngulo_() {
		return angulo_;
	}
}
