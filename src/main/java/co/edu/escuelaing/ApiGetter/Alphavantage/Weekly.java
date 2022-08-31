package co.edu.escuelaing.ApiGetter.Alphavantage;

public class Weekly extends AlphaGetter {

    /**
     * Constructor metodo Weekly
     * 
     * @param symbol Simbolo de la empresa
     */

    public Weekly(String symbol) {
        super("TIME_SERIES_WEEKLY", symbol);
    }

}
