package co.edu.escuelaing.ApiGetter.Alphavantage;

public class Daily extends AlphaGetter {

    /**
     * Constructor metodo Daily
     * 
     * @param symbol Simbolo de la empresa
     */
    public Daily(String symbol) {
        super("TIME_SERIES_DAILY", symbol);
    }

}
