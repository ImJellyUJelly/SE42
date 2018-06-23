package models;

import repositories.AuthenticationRepository;
import repositories.ProductRepository;

import java.util.List;

public class Kapstok {
    private static AuthenticationRepository authRepo = new AuthenticationRepository();
    private static ProductRepository prodRepo = new ProductRepository();
    private static JsonWebToken jwt = new JsonWebToken();

    // BEGIN JWT STUFF //

    public static String getJsonWebToken(Authentication auth) {
        return jwt.createToken(auth);
    }

    public static boolean verifyToken(String token) {
        return jwt.verifyToken(token);
    }

    // END JWT STUFF //

    // AUTHENTICATION STUFF //

    public static Authentication getAuthenticationByLogin(String username, String password) {
        return authRepo.login(username, password);
    }

    // END AUTHENTICATION STUFF //

    // BEGIN PRODUCT STUFF //

    public static Product getProduct(String productId) {
        return prodRepo.getProductById(productId);
    }

    public static List<Product> getProducts() {
        return prodRepo.getAllProducts();
    }

    public static Product putProduct(String productId, String name) {
        Product p = prodRepo.getAllProducts().get(0);
        prodRepo.updateProduct(p);
        return p;
    }

    public static Product deleteProduct(String productId) {
        prodRepo.deleteProduct(productId);
        return getProduct(productId);
    }

    // END PRODUCT STUFF //
}
