package co.edu.escuelaing.ApiGetter.Polygon;

public class PreviousClose extends PolyGetter {

    private final static String finalQuery = "v2/aggs/ticker/";

    /**
     * Constructor for PreviousClose
     * 
     * @param symbol Symbol of the company
     */
    public PreviousClose(String symbol) {
        super(finalQuery + symbol + "/prev");
    }

    @Override
    public void buildParameters() {
    }

}
