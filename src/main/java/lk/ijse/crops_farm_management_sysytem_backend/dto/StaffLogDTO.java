package lk.ijse.crops_farm_management_sysytem_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffLogDTO implements Serializable {
    private String staffLogId;
    private String staffId;
    private String logId;
}
