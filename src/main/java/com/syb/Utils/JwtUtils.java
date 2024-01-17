package com.syb.Utils;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtils {
    public String createJwt(String username,Integer expire, String privateKey){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwt = jwtBuilder
                .claim("username",username)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS256,privateKey)
                .compact();
        return jwt;
    }
    public String parseJwt(String token,String privateKey){
        JwtParser jwtParser = Jwts.parser();
        //解析jwt时需要考虑处理超时的情况
        try{
            Jws<Claims> claimsJws = jwtParser.setSigningKey(privateKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            //用get方法获取payload中的参数内容
            String username = (String) claims.get("username");
            return username;
        }
        catch (ExpiredJwtException e) {
            return "token已失效";
        }
    }
}
