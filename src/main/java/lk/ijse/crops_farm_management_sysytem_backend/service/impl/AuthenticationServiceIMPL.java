package lk.ijse.crops_farm_management_sysytem_backend.service.impl;

import lk.ijse.crops_farm_management_sysytem_backend.dao.UserDAO;
import lk.ijse.crops_farm_management_sysytem_backend.dto.UserDTO;
import lk.ijse.crops_farm_management_sysytem_backend.jwtModel.JWTAuthResponse;
import lk.ijse.crops_farm_management_sysytem_backend.jwtModel.SignIn;
import lk.ijse.crops_farm_management_sysytem_backend.service.AuthenticationService;
import lk.ijse.crops_farm_management_sysytem_backend.service.JWTService;
import lk.ijse.crops_farm_management_sysytem_backend.util.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDAO userDAO;
    private final JWTService jwtService;
    private final MappingUtil mapping;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userDAO.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO signUpUser) {
        var savedUser = userDAO.save(mapping.userConvertToEntity(signUpUser));
        var genToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(genToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity =
                userDAO.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(userEntity);
        return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
