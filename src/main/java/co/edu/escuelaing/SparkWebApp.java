package co.edu.escuelaing;

import static spark.Spark.*;

import java.io.IOException;

import co.edu.escuelaing.ApiGetter.Alphavantage.Daily;
import co.edu.escuelaing.ApiGetter.Alphavantage.IntraDay;
import co.edu.escuelaing.ApiGetter.Alphavantage.Monthly;
import co.edu.escuelaing.ApiGetter.Alphavantage.Weekly;
import co.edu.escuelaing.ApiGetter.Polygon.Aggregates;
import co.edu.escuelaing.ApiGetter.Polygon.OpenClose;
import co.edu.escuelaing.ApiGetter.Polygon.PreviousClose;
import spark.Request;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        post("/hello", (req, res) -> "Hello " + req.queryParams("name"));
        get("/hello", (req, res) -> "Hello " + req.queryParams("name"));
        get("/stockAlpha", (req, res) -> {
            res.type("application/json");
            return FunctionAlpha(req);
        });
        get("/stockPoly", (req, res) -> {
            res.type("application/json");
            return FunctionPolygon(req);
        });
    }

    public static String reqSymbol(Request req) {
        return req.queryParams("symbol");
    }

    /**
     * Metodo que identifica la funcion a realizar para el API Polygon
     * 
     * @param req Request con la informacion de la peticion
     * @return String con la respuesta de la API
     */
    private static String FunctionPolygon(Request req) throws IOException {
        String function = req.queryParams("function");
        switch (function) {
            case "aggregates":
                return new Aggregates(reqSymbol(req), req.queryParams("day1"), req.queryParams("day2"))
                        .getStock();
            case "openclose":
                return new OpenClose(reqSymbol(req), req.queryParams("day1")).getStock();
            case "previousclose":
                return new PreviousClose(reqSymbol(req)).getStock();
            default:
                return "Invalid function";
        }
    }

    /**
     * Metodo que identifica la funcion a realizar para el API Alpha
     * 
     * @param req Request con la informacion de la peticion
     * @return String con la respuesta a la peticion
     */
    private static String FunctionAlpha(Request req) throws IOException {
        switch (req.queryParams("function")) {
            case "daily":
                return new Daily(reqSymbol(req)).getStock();
            case "intraday":
                return new IntraDay(reqSymbol(req), req.queryParams("interval")).getStock();
            case "weekly":
                return new Weekly(reqSymbol(req)).getStock();
            case "monthly":
                return new Monthly(reqSymbol(req)).getStock();
            default:
                return "Invalid function";
        }
    }

    /**
     * Metodo que obtiene el puerto del servidor
     * 
     * @return int con el puerto del servidor
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}