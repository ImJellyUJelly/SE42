package models;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JsonWebToken {
    public String createToken(Authentication auth) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("changeme");
            Date date = new Date();
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userId", auth.getId())
                    .withClaim("isAdmin", auth.isAdmin())
                    //.withIssuedAt(date)
                    //.withExpiresAt(new Date(date.getTime() + 20))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException | UnsupportedEncodingException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            return "Token creation failed";
        }
    }

    public boolean verifyToken(String jwtToken) {
        try {
            return JWT.decode(jwtToken)
                    .getClaim("isAdmin")
                    .asBoolean();
        } catch(Exception npEx) {
            return false;
        }
    }
}
