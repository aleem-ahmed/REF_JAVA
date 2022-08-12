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
		path("/api", () -> {
			/**
			 * @title Base Route
			*/
			get("", (req, res) -> {
				res.type("application/json");

				JSONObject r = new JSONObject();

				r.put("executed", true);
				r.put("status", true);
				r.put("message", "/api");

				return r;
			});

			path("/:action", () -> {
				get("", (req, res) -> {
					res.type("application/json");
	
					JSONObject r = new JSONObject();
	
					r.put("executed", true);
					r.put("status", true);
					r.put("message", "/api/" + req.params("action"));
	
					return r;
				});
			});
		});

		/**
		 * @title 404
		*/
		get("/*", (req, res) -> {
			res.type("application/json");

			JSONObject r = new JSONObject();

			r.put("executed", true);
			r.put("status", false);
			r.put("message", "(404) - Not Found");

			return r;
		});
	}
}
