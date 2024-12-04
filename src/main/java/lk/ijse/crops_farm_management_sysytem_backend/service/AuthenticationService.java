package lk.ijse.crops_farm_management_sysytem_backend.service;


import lk.ijse.crops_farm_management_sysytem_backend.dto.UserDTO;
import lk.ijse.crops_farm_management_sysytem_backend.jwtModel.JWTAuthResponse;
import lk.ijse.crops_farm_management_sysytem_backend.jwtModel.SignIn;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO signUp);
    JWTAuthResponse refreshToken(String accessToken);
}
