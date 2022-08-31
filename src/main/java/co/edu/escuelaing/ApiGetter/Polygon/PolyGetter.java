package co.edu.escuelaing.ApiGetter.Polygon;

import co.edu.escuelaing.ApiGetter.APIClassGetter;

public abstract class PolyGetter extends APIClassGetter {

    private final static String url = "https://api.polygon.io/";
    private final static String key = "&apiKey=z4oDbzpleDaoOAHsJDjk9BZGKmjVfzgF";

    /**
     * Constructor de la consulta final que se envia a la API
     * 
     * @param finalQuery consulta a enviar
     */
    public PolyGetter(String finalQuery) {
        super(url + finalQuery + "?", key);
        query();
    }

    /**
     * Metodo que construye los parametros para la consulta
     *
     */
    public abstract void buildParameters();
}
