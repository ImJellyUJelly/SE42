package models;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import javax.persistence.*;

@NamedQuery(
        name = "Authentication.login",
        query = "select a from Authentication as a where a.username = :username and a.password = :password"
)

@Entity
public class Authentication {
    @Id @GeneratedValue
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    public Authentication() { }

    public Authentication(int id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static Jws<Claims> getAuthFromToken(String jwtString) {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
