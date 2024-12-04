package lk.ijse.crops_farm_management_sysytem_backend.service;


import lk.ijse.crops_farm_management_sysytem_backend.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicle);
    void updateVehicle(String id, VehicleDTO vehicle);
    VehicleDTO searchVehicle(String id);
    boolean deleteVehicle(String id);
    List<VehicleDTO> getAllVehicles();
}
