package com.springmvc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.springmvc.entity.Customer;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "a7379695a7379695a7379695a7379695";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final long SURVIVE_TIME = 60L * 1000L * 30L;


    private JwtUtil() {
    }

    /**
     * @param customer get customer's token
     * @return
     */
    public static String createJWT(Customer customer) {

        long currentMills = System.currentTimeMillis();
        long expiredMills = SURVIVE_TIME + currentMills;
        String token = JWT.create().withClaim("uid", customer.getId()).withIssuedAt(new Date(currentMills))
                .withExpiresAt(new Date(expiredMills))
                .sign(ALGORITHM);

        return token;
    }

    /**
     * @param token String
     * @return uid String
     */
    public static String parseJWT(String token) throws Exception {
        String uid = null;
        if (isVerify(token)) {
            DecodedJWT jwt = JWT.decode(token);
            if (jwt.getExpiresAt().getTime() < System.currentTimeMillis()) {
                throw new Exception("token has been expired");
            }
            uid = jwt.getClaim("uid").asString();
        }
        return uid;
    }

    private static Boolean isVerify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
