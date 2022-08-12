package io.w3st;

import org.json.JSONObject;
import static spark.Spark.*;

/**
 * @title Main
*/
public final class Main {
	/**
	 * @param args The arguments of the program
	*/
	public static void main(String[] args) {
		/**
		 * @title Base Route
		*/
		get("/api", (req, res) -> {
			res.type("application/json");

			JSONObject r = new org.json.JSONObject();

			r.put("executed", true);
			r.put("status", true);
			r.put("message", "API Live");

			return r;
		});

		/**
		 * @title 404
		*/
		get("/*", (req, res) -> {
			res.type("application/json");

			JSONObject r = new org.json.JSONObject();

			r.put("executed", true);
			r.put("status", false);
			r.put("message", "404 Not Found");

			return r;
		});
	}
}
