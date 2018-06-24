package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.Json;
import models.*;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ProductController extends Controller {
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok();
    }

    public Result getProductById(String id) {
        Product p = Kapstok.getProduct(id);
        if (p != null) {
            return ok(Json.toJson(p));
        } else {
            return notFound("Product not found.");
        }
    }

    public Result getProducts() {
        List<Product> products = Kapstok.getProducts();
        if (products != null && products.size() > 0) {
            return ok(Json.toJson(products));
        } else {
            return notFound("Products not found.");
        }
    }

    public Result postProduct(String productName) {
        return null;
    }

    public Result putProduct(String id, String name) {
        return ok(Json.toJson(Kapstok.putProduct(id, name)));
    }

    public Result deleteProduct(String productId) {
        String jwtString = request().getHeader("Authorization");
        String[] splitted = jwtString.split(" ");
        try {
            if (Kapstok.verifyToken(splitted[1])) {
                return ok(Json.toJson(Kapstok.deleteProduct(productId)));
            }
            return unauthorized("You're not authorized to delete a product.");
        } catch (Exception npEx) {
            return notAcceptable();
        }
    }
}
