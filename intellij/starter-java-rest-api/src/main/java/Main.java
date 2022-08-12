import static spark.Spark.get;

import spark.Request;
import spark.Response;
import spark.Route;

public class Main {
    public static void main(String[] args) {
        get(
            "/api",
            (req, res) -> {
                res.type("application/json");

                return "{ \"status\": true }";
            }
        );
    }
}