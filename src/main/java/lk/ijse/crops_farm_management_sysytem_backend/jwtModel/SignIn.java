package lk.ijse.crops_farm_management_sysytem_backend.jwtModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignIn {
    public String email;
    public String password;
}
