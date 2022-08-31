package co.edu.escuelaing.ApiGetter.Polygon;

public class OpenClose extends PolyGetter {

    private final static String finalQuery = "v1/open-close/";

    /**
     * Constructor metodo OpenClose
     * 
     * @param symbol      simbolo de la empresa
     * @param inicialDate Primer dia de la consulta
     */
    public OpenClose(String symbol, String inicialDate) {
        super(finalQuery + symbol + "/" + inicialDate);
    }

    @Override
    public void buildParameters() {
    }

}
