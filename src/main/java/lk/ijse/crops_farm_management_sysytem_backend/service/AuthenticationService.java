package lk.ijse.crops_farm_management_sysytem_backend.service;

import lk.ijse.crop_monitoring_systembackend.dto.UserDTO;
import lk.ijse.crop_monitoring_systembackend.jwtModel.JWTAuthResponse;
import lk.ijse.crop_monitoring_systembackend.jwtModel.SignIn;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO signUp);
    JWTAuthResponse refreshToken(String accessToken);
}
