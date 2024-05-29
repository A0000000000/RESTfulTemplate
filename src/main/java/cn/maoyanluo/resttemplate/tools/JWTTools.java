package cn.maoyanluo.resttemplate.tools;

import cn.maoyanluo.resttemplate.bean.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTTools {

    public static final ThreadLocal<User> tl = new ThreadLocal<>();


    public static String genJWT(Integer id, User user) {
        JwtBuilder builder = Jwts.builder();
        String token = builder
                .setId(String.valueOf(id))
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "rest-login")
                .setExpiration(new Date(new Date().getTime() + 86400000))
                .compact();
        return token;
    }

    public static User parseJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("rest-login")
                .parseClaimsJws(token)
                .getBody();
        if (claims.getExpiration().getTime() < new Date().getTime()) {
            return null;
        }
        User result = new User();
        result.setId(Integer.valueOf(claims.getId()));
        result.setUsername(claims.getSubject());
        return result;
    }

}
