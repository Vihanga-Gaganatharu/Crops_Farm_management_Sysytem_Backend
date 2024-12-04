package lk.ijse.crops_farm_management_sysytem_backend.service;

import lk.ijse.crops_farm_management_sysytem_backend.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void saveUser(UserDTO user);
    void updateUser(String email, UserDTO user);
    boolean searchUser(String email);
    boolean deleteUser(String email);
    UserDetailsService userDetailsService();
}
