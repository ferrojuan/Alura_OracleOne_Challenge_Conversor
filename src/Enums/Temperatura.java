package Enums;

public enum Temperatura  {
	CELSIUS(0,1,"°C"),
	FAHRENHEIT(32,1.8,"°F"),
	KELVIN(273.15,1,"K"),
	RANKINE(491.67,1.8,"°RA"),
	REAUMUR(0,0.8,"°RE");
	
	final double valorCero;
	final double valorIncremental;
	final String signo;
	String resultadoConversion;
	
	Temperatura(double valorCero,double valorIncremental,String signo){
		this.valorCero = valorCero;
		this.valorIncremental = valorIncremental;
		this.signo = signo;		
	}

	public double getValorCero() {
		return valorCero;
	}

	public double getValorIncremental() {
		return valorIncremental;
	}

	public String getSigno() {
		return signo;
	}
	
		
	

}
