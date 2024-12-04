package lk.ijse.crops_farm_management_sysytem_backend.service;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    String refreshToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
