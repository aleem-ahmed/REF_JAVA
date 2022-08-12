package io.w3st;
import static spark.Spark.*;

/**
 * @title Main
*/
public final class Main {
	/**
	 * @param args The arguments of the program
	*/
	public static void main(String[] args) {
		get("/api", (req, res) -> {
			res.type("application/json");

			return "{ \"executed\": true, \"status\": true }";
		});

		get("/*", (req, res) -> {
			res.type("application/json");

			return "{ \"executed\": true, \"status\": false, \"message\":\"Custom 404\" }";
		});
	}
}
