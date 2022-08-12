package io.w3st;
import static spark.Spark.*;

/**
 * @title App
 */
public final class App {
    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
