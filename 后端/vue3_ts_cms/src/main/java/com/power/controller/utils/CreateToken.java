package com.power.controller.utils;

import com.power.domain.Userinfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateToken {
    public static String getToken(Userinfo userinfo) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(userinfo.getId() + "")
                .setSubject(userinfo.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"power^_^")
                .setExpiration(new Date(new Date().getTime()+6000000));
        return jwtBuilder.compact();
    }
    public static String[] parseToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey("power^_^")
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return new String[]{};
        }
        return new String[]{claims.getId(),claims.getSubject()};
    }
}
