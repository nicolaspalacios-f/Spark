package co.edu.escuelaing.ApiGetter.Alphavantage;

public class IntraDay extends AlphaGetter {

    /**
     * Constructor metodo IntraDay
     * 
     * @param symbol   Simbolo de la empresa
     * @param interval Intervalo de tiempo
     */

    public IntraDay(String symbol, String interval) {
        super("TIME_SERIES_INTRADAY", symbol);
        parameters.add(2, "&interval=");
        input.add(2, interval);
        query();
    }

}
