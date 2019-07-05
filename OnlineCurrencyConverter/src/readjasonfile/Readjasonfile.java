/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readjasonfile;

/**
 *
 * @author figoaranta
 */

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class Readjasonfile{

    public currency []currency= new currency[52];
            
    private String [] nameList={"USD","AED","ARS","AUD","BGN","BRL","BSD","CAD","CHF","CLP","CNY","COP","CZK",
                                "DKK","DOP","EGP","EUR","FJD","GBP","GTQ","HKD","HRK","HUF","IDR","ILS","INR","ISK","JPY",
                                "KRW","KZT","MXN","MYR","NOK","NZD","PAB","PEN","PHP","PKR","PLN","PYG","RON","RUB","SAR",
                                "SEK","SGD","THB","TRY","TWD","UAH","UYU","VND","ZAR"};
            
  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public Readjasonfile() throws IOException, JSONException {
    JSONObject readJson = readJsonFromUrl("https://api.exchangerate-api.com/v4/latest/USD");
    //System.out.println(readJson.toString());
    JSONObject obj1 = readJson.getJSONObject("rates");
    for (int i =0; i<52;i++)
    {   
        Object a = obj1.get(nameList[i]);
        Double d = Double.parseDouble(a.toString());
        currency[i]= new currency(nameList[i],d);
        
        //System.out.println(currency[i].getValue());
    }
    //System.out.println(USD* 10);
    
  }
  
}