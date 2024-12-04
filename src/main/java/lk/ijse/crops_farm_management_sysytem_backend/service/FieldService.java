package lk.ijse.crops_farm_management_sysytem_backend.service;

import lk.ijse.crop_monitoring_systembackend.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO field);
    void updateField(String id, FieldDTO field);
    FieldDTO searchField(String id);
    boolean deleteField(String id);
    List<FieldDTO> getAllFields();
}
