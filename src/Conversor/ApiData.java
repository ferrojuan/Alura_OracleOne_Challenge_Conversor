package Conversor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiData {
	
	private BigDecimal cop;
	private BigDecimal eur;
	private BigDecimal bgp;
	private BigDecimal jpy;
	private BigDecimal krw;
	private BigDecimal usd;
	
	
	
	public  ApiData() {
	 StringBuffer response = new StringBuffer();	 
		try {
		    //String apikey = "cur_live_z1QFU0wo1JtcMURcGNB1HG5pZbvQCQDsZyedJoJQ";
		    String url = "https://api.currencyapi.com/v3/latest?apikey=cur_live_z1QFU0wo1JtcMURcGNB1HG5pZbvQCQDsZyedJoJQ";
		    URL urlForGetRequest = new URL(url);
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();

		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		        
		        while ((readLine = in.readLine()) != null) {
		            response.append(readLine);
		        }
		        in.close();     
		               
		        
		    } else {
		        throw new Exception("Error in API Call");
		    }
		    
		    
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		JSONObject dataObject  = new JSONObject(response.toString());
		this.cop = dataObject.getJSONObject("data").getJSONObject("COP").getBigDecimal("value");
		this.eur = dataObject.getJSONObject("data").getJSONObject("EUR").getBigDecimal("value");
		this.bgp = dataObject.getJSONObject("data").getJSONObject("GBP").getBigDecimal("value");
		this.jpy = dataObject.getJSONObject("data").getJSONObject("JPY").getBigDecimal("value");
		this.krw = dataObject.getJSONObject("data").getJSONObject("EUR").getBigDecimal("value");
		this.usd = dataObject.getJSONObject("data").getJSONObject("USD").getBigDecimal("value");				
	}
	
	


	public BigDecimal getCop() {
		return cop;
	}


	public BigDecimal getEur() {
		return eur;
	}


	public BigDecimal getBgp() {
		return bgp;
	}


	public BigDecimal getJpy() {
		return jpy;
	}


	public BigDecimal getKrw() {
		return krw;
	}


	public BigDecimal getUsd() {
		return usd;
	}
		
	

}
