package Enums;

public enum Longitud {
	MILIMETRO(1000,"mm"),
	CENTIMETRO(100,"cm"),
	METRO(1,"mts"),
	KILOMETRO(0.001,"km"),
	YARDA(1.09361,"yd"),
	PULGADA(39.36996,"inch"),
	PIE(3.28083,"ft"),
	MILLA(5279.98407552,"mi");
	final double valorLongitud;
	final String sigla;
	 Longitud(double valorLongitud,String sigla) {
		this.valorLongitud = valorLongitud;
		this.sigla = sigla;
		
	}
	public double getValorLongitud() {
		return valorLongitud;
	}
	public String getSigla() {
		return sigla;
	}
	 

}
