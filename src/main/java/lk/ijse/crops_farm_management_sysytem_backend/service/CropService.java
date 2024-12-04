package lk.ijse.crops_farm_management_sysytem_backend.service;


import lk.ijse.crops_farm_management_sysytem_backend.dto.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO crop);
    void updateCrop(String id, CropDTO crop);
    CropDTO searchCrop(String id);
    boolean deleteCrop(String id);
    List<CropDTO> getAllCrops();
}
