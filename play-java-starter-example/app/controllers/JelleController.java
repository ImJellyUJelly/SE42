package controllers;

import play.mvc.*;
import models.*;
import views.html.*;
import play.libs.Json;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class JelleController extends Controller {
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(andereIndex.render());
    }

    public Result postRequest() {
        Store store = new Store("Rare naam voor een winkel");
        return ok(Json.toJson(store));
    }

    public Result putRequest() {
        return ok("Put request received and accepted. Won't do something with it.");
    }

    public Result deleteRequest(String id) {
        return ok("Delete op " + id + " uitgevoerd.");
    }
}
