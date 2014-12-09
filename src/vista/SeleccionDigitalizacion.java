package vista;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeleccionDigitalizacion {
	
	private int muestreo_1;
	private int muestreo_2;
	private int cuantizacion;
	
	/**
	 * Instantiates a new seleccion imagen especifica.
	 */
	public SeleccionDigitalizacion(){
		JPanel panel = new JPanel(new FlowLayout());
		
		final JLabel selectionLabel = new JLabel("Elija el muestreo y la cuantizacion para digitalizar");
		panel.add(selectionLabel);
		
		JTextField muestreo1 = new JTextField("muestreo 1");
		panel.add(muestreo1);
		
		JTextField muestreo2 = new JTextField("muestreo 2");
		panel.add(muestreo2);
		
		JTextField cuantizacionT = new JTextField("cuantizacion");
		panel.add(cuantizacionT);
		
		int selectionImage = JOptionPane.showOptionDialog(null, panel,
				"eleccion de imagenes", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, null, null, null);
		
		if (selectionImage == JOptionPane.OK_OPTION && muestreo1.getText().matches("\\d+")
				&& muestreo2.getText().matches("\\d+")
				&& cuantizacionT.getText().matches("\\d+")){
			muestreo_1 = Integer.valueOf(muestreo1.getText());
			muestreo_2 = Integer.valueOf(muestreo2.getText());
			cuantizacion = Integer.valueOf(cuantizacionT.getText());
		}
	}

	public int getMuestreo_1() {
		return muestreo_1;
	}

	public int getMuestreo_2() {
		return muestreo_2;
	}

	public int getCuantizacion() {
		return cuantizacion;
	}
}
