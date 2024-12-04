package lk.ijse.crops_farm_management_sysytem_backend.service;


import lk.ijse.crops_farm_management_sysytem_backend.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staff);
    void updateStaff(String id, StaffDTO staff);
    boolean deleteStaff(String id);
    StaffDTO searchStaff(String id);
    List<StaffDTO> getAllStaffs();
}
