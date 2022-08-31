package co.edu.escuelaing.ApiGetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public abstract class APIClassGetter {

    // Request to the API
    private static final String USER_AGENT = "Mozilla/5.0";
    private String get_url = "https://www.alphavantage.co/query?";
    private String api_key = "&apikey=VB3JEBJ3S40IQWY9";

    // Attributes
    protected ArrayList<String> parameters = new ArrayList<>();
    protected ArrayList<String> input = new ArrayList<>();
    private StringBuilder query;
    private Cache cache = Cache.getInstance();

    /**
     * Constructor for APIClassGetter
     *
     * @param url URL of the API
     * @param key API key
     */
    public APIClassGetter(String url, String key) {
        this.get_url = url;
        this.api_key = key;
        query();
    }

    /**
     * Constructor vacio APIClassGetter
     */
    public APIClassGetter() {
    }

    /**
     * Metodo que construye los parametros para la consulta
     *
     */
    public abstract void buildParameters();

    /**
     * Metodo que construye la consulta
     *
     */
    public void query() {
        query = new StringBuilder();
        query.append(get_url);
        byte counter = 0;
        for (int i = 0; i < parameters.size(); i++) {
            query.append(parameters.get(i));
            try {
                query.append(input.get(counter));
            } catch (IndexOutOfBoundsException indexBounds) {
                System.out.println("Index out of bounds");
            }
            counter++;
        }
        query.append(api_key);
    }

    /**
     * Metodo que obtiene la respuesta de la consulta
     * 
     * @return String con la respuesta de la consulta
     * @throws IOException
     */
    public String getStock() throws IOException {
        if (cache.contains(query.toString())) {
            return cache.get(query.toString());
        } else {
            URL obj = new URL(query.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                cache.insert(query.toString(), response.toString());
                return response.toString();
            } else {
                System.out.println("GET request not worked: " + query.toString());
                return "GET request not worked";
            }
        }

    }

}
