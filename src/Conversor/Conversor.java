package Conversor;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Conversor {	
	final Font fontTitulo = new Font("Arial Narrow", Font.BOLD, 20);
	final Font fontLabel = new Font("Book Antiqua", Font.BOLD, 15);
	final Font fontButton = new Font("Book Antiqua", Font.PLAIN, 12);
	final Font fontItemMenu = new Font("Arial Narrow", Font.PLAIN, 15);
	final Font fontComboBox = new Font("Arial Narrow", Font.PLAIN, 12);
	final Color colorBase = new Color(255,255,255);
	final Color colorResaltar= new Color (46, 134, 193);	
	private static double  resultadoConversion;
	private static double valorAConvertir=0;
	private static double conversionInicial;	
	
	
	public  String conversorMonedaLongitud(double cantidad, double valorInicial,double valorFinal) {
		//se toma como valor estandar el dolar y el metro  por lo que todos los valores ingresaros se pasaran a ese valor y luego se convertirarn a el valor requerido.
		if(valorInicial == valorFinal) {
			resultadoConversion = cantidad;
			
		}else {
			valorAConvertir = cantidad/valorInicial;		
			resultadoConversion =valorAConvertir*valorFinal;			
		}
		
		BigDecimal bd = new BigDecimal(resultadoConversion);
		return bd.setScale(3,RoundingMode.UP).toString() ;		
		
		
	}
	

	public String  conversorTemperatura(double cantidad, double valorCeroIni,double valorIncrementalIni,double valorCeroFin, double valorIncrementalFin ) {
		//para realizar la conversion de temperaturas se toma como mediad estandar los grados celsius por lo que se convertira a es valor y luego a las demas medidas de temperatura que se requiera. 
		//1. para convertir a celsius se toma la cantidad requeridad menos el valor cero divido por el valor incremental del valor inicial
		
		conversionInicial = (cantidad -valorCeroIni)/valorIncrementalIni;
		//2. luego para la conversion a aotras unidades de temperatura se toma el valocero final y se suma a la multiplicacion entre la conversion inicial y el valor incremental final
		
		resultadoConversion = valorCeroFin+(conversionInicial*valorIncrementalFin);
		BigDecimal bd = new BigDecimal(resultadoConversion);
		return bd.setScale(3,RoundingMode.UP).toString() ;	
		
	}
	
	public int valorIndice(JComboBox comBox) {
		int indice =comBox.getSelectedIndex();
		return indice;		
	}
	public double obtenerCantidad(JTextField textField) {
		double cantidad = 0;
		try {String valorCantidad =textField.getText();
		cantidad =Double.parseDouble(valorCantidad);			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Ingresa el valor de la cantidad que quieres convertir, solo se permite valores numericos");				
		}return cantidad;		
	}	
	//Getters 
	public Color getColorBase() {
		return colorBase;
	}

	public Font getFontTitulo() {
		return fontTitulo;
	}

	public Font getFontLabel() {
		return fontLabel;
	}

	public Font getFontButton() {
		return fontButton;
	}

	public Font getFontItemMenu() {
		return fontItemMenu;
	}

	public Font getFontComboBox() {
		return fontComboBox;
	}

	public Color getColorResaltar() {
		return colorResaltar;
	}
	
	
	

}
