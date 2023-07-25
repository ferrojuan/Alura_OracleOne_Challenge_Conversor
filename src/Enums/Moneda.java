package Enums;

public enum Moneda {
	PESO_COP(3962.45,"Pesos Colombianos"),
	EUROS_EUR(0.90,"Euros"),
	LIBRA_ESTERLINA_GBP(0.78,"Libras Esterlinas"),
	YEN_JPY(140.94,"Yenes Japones"),
	WON_KRW(1276.14,"Won Sur - Koreano"),
	DOLAR_USD(1,"Dolares Estadounidenses");
	
	final double valorMoneda;
	final String nombreMoneda;
	
	
	Moneda(double valorConversion,String nombreMoneda){
		this.valorMoneda =valorConversion;
		this.nombreMoneda =nombreMoneda;
	}
	
	

	public double getValorMoneda() {
		return valorMoneda;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}
	
	

}
