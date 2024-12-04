package lk.ijse.crops_farm_management_sysytem_backend.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lk.ijse.crop_monitoring_systembackend.service.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceIMPL implements JWTService {
    @Value("${token.key}")
    private String jwtKey;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    @Override
    public String refreshToken(UserDetails userDetails) {
        return refreshToken(new HashMap<>(),userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        var username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimResolve) {
        final Claims claims = getAllClaims(token);
        return claimResolve.apply(claims);
    }

    private String generateToken(Map<String,Object> extractClaims, UserDetails userDetails){
        extractClaims.put("role",userDetails.getAuthorities());
        Date now = new Date();
        Date expire = new Date(now.getTime() + 1000 * 60 * 60 * 8); // 8 hours

        return Jwts.builder().setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }

    private String refreshToken(Map<String,Object> extractClaims,UserDetails userDetails){
        extractClaims.put("role",userDetails.getAuthorities());
        Date now = new Date();
        Date expire = new Date(now.getTime() + 1000 * 60 * 60 * 8); // 8 hours
        Date refreshExpire = new Date(now.getTime() + 1000 * 60 * 60 * 24);

        return Jwts.builder().setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setExpiration(refreshExpire)
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
    private Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token)
                .getBody();
    }

    private Key getSignKey(){
        byte[] decode = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(decode);
    }
}