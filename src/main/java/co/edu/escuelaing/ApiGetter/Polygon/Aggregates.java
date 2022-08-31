package co.edu.escuelaing.ApiGetter.Polygon;

public class Aggregates extends PolyGetter {

    private final static String finalQuery = "v2/aggs/ticker/";

    /**
     * constructor metodo Aggregates
     * 
     * @param symbol      simbolo de la empresa
     * @param inicialDate fecha inicial
     * @param finalDate   fecha final
     */
    public Aggregates(String symbol, String inicialDate, String finalDate) {
        super(finalQuery + symbol + "/range/1/day/" + inicialDate + "/" + finalDate);
    }

    @Override
    public void buildParameters() {
    }

}
