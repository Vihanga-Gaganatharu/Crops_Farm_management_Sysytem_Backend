package lk.ijse.crops_farm_management_sysytem_backend.service;

import lk.ijse.crops_farm_management_sysytem_backend.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipment);
    void updateEquipment(String id, EquipmentDTO equipment);
    EquipmentDTO searchEquipment(String id);
    boolean deleteEquipment(String id);
    List<EquipmentDTO> getAllEquipments();
}
