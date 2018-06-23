package models;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JsonWebToken {
    public String createToken(Authentication auth) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            Date date = new Date();
            String token = JWT.create()
                    .withIssuer("admin")
                    .withClaim("userId", auth.getId())
                    .withClaim("isAdmin", auth.isAdmin())
//                    .withIssuedAt(date)
//                    .withExpiresAt(new Date(date.getTime() + 20))
                    .sign(algorithm);
            System.out.println(token);
            return token; // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhZG1pbiIsImlzQWRtaW4iOnRydWV9.DpLP5z9qGmxKo3uaQQifk-2vUPNYr2N_w5aDzV4Hyx0
        } catch (JWTCreationException | UnsupportedEncodingException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            return "Token creation failed";
        }
    }

    public boolean verifyToken(String jwtToken) {
        return JWT.decode(jwtToken)
                .getClaim("isAdmin")
                .asBoolean();
    }
}
