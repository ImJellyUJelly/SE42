package controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.JsonNode;
import models.Authentication;
import models.JsonWebToken;
import models.Kapstok;
import play.libs.Json;
import play.mvc.*;
import repositories.AuthenticationRepository;

import java.io.UnsupportedEncodingException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AuthenticationController extends Controller {
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("Nothing to show here");
    }

    public Result login() {
        String username, password = "";
        JsonNode rootNode = request().body().asJson();
        username = rootNode.get("username").asText();
        password = rootNode.get("password").asText();
        Authentication auth = Kapstok.getAuthenticationByLogin(username, password);
        String jwt = Kapstok.getJsonWebToken(auth);
        if(auth != null) {
            return ok(auth.getUsername() + ": login successful - JWT: " + jwt);
        }
        return unauthorized("Not authorized with username/password combination.");
    }
}