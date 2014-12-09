/**
 * 
 */
package vista;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Sawan
 *
 */
public class SeleccionDimensiones {
	/** The panel. */
	JPanel panel;
	
	/** The selection label. */
	JLabel selectionLabel;
	
	/** The text. */
	JTextField text_w;
	
	JTextField text_h;
	
	/** The width. */
	int width;

	/** The heigth. */
	int heigth;
	
	/** The cerrar. */
	boolean cerrar;

	/**
	 * Instantiates a new seleccion umbral.
	 */
	public SeleccionDimensiones() {
		cerrar = false;
	}
	
	public void pedirDimensiones(int w, int h){
		panel = new JPanel(new GridBagLayout());
		
		selectionLabel = new JLabel("Introduzca las nuevas dimensiones ancho x largo. Las dimensiones actuales son " + Integer.toString(w) + " x " + Integer.toString(h) + "  ");
		panel.add(selectionLabel);

		text_w = new JTextField(10);
		text_h = new JTextField(10);
		panel.add(text_w);
		panel.add(text_h);

		int selectionUmbral = JOptionPane.showOptionDialog(null, panel,
				"Seleccion Dimensiones", JOptionPane.OK_OPTION,
				JOptionPane.CANCEL_OPTION, null, null, null);

		width = -1;
		heigth = -1;
		
		if (selectionUmbral == JOptionPane.OK_OPTION
				&& (text_w.getText().matches("\\d+") || text_w.getText().matches(
						"\\d+.\\d+")) && (text_h.getText().matches("\\d+") || text_w.getText().matches(
								"\\d+.\\d+"))) {
			width = Integer.valueOf(text_w.getText());
			heigth = Integer.valueOf(text_h.getText());
		}

		else{
			cerrar = true;
		}
	}

	

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	
	/**
	 * @return the heigth
	 */
	public int getHeigth() {
		return heigth;
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
