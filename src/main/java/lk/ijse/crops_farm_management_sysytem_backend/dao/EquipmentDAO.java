package lk.ijse.crops_farm_management_sysytem_backend.dao;

import lk.ijse.crops_farm_management_sysytem_backend.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDAO extends JpaRepository<EquipmentEntity, String> {}
