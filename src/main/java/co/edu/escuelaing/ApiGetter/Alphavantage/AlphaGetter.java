package co.edu.escuelaing.ApiGetter.Alphavantage;

import co.edu.escuelaing.ApiGetter.APIClassGetter;

public class AlphaGetter extends APIClassGetter {

    private static final String ALPHA_URL = "https://www.alphavantage.co/query?";
    private static final String ALPHA_KEY = "&apikey=VB3JEBJ3S40IQWY9";

    /**
     * Constructor para AlphaGetter
     * 
     * @param function
     * @param symbol
     */
    public AlphaGetter(String function, String symbol) {
        super(ALPHA_URL, ALPHA_KEY);
        buildParameters();
        input.add(function);
        input.add(symbol);
        query();
    }

    /**
     * Metodo que construye los parametros para la consulta
     *
     */
    public void buildParameters() {
        parameters.add("function=");
        parameters.add("&symbol=");
    }

}
