package co.edu.escuelaing.ApiGetter.Alphavantage;

public class Monthly extends AlphaGetter {

    /**
     * Constructor metodo Monthly
     * 
     * @param symbol Simbolo de la empresa
     */

    public Monthly(String symbol) {
        super("TIME_SERIES_MONTHLY", symbol);
    }

}
