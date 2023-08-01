package Enums;

import java.math.BigDecimal;
import Conversor.ApiData;

public enum Moneda {
	
	PESO_COP(traerDatos().getCop(), "Pesos Colombianos"),
	EUROS_EUR(traerDatos().getEur(),"Euros"),
	LIBRA_ESTERLINA_GBP(traerDatos().getBgp(),"Libras Esterlinas"),
	YEN_JPY(traerDatos().getJpy(),"Yenes Japones"),
	WON_KRW(traerDatos().getCop(),"Won Sur - Koreano"),
	DOLAR_USD(traerDatos().getUsd(),"Dolares Estadounidenses");
	 final BigDecimal valorMoneda ;
	 final String nombreMoneda;
	 
	
	
	Moneda(BigDecimal valorConversion,String nombreMoneda){
		this.valorMoneda =valorConversion;
		this.nombreMoneda =nombreMoneda;
	}
	
	

	public BigDecimal getValorMoneda() {
		return valorMoneda;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}
	static private ApiData traerDatos() {
		ApiData apiData =new ApiData();
		return apiData;
		
	}
	
	

}
