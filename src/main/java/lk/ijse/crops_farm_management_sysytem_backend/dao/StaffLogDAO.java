package lk.ijse.crops_farm_management_sysytem_backend.dao;

import lk.ijse.crops_farm_management_sysytem_backend.entity.StaffLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffLogDAO extends JpaRepository<StaffLogEntity, String> {
    void deleteByLogEntity_LogId(String logId);
    List<StaffLogEntity> findByLogEntity_LogId(String logId);
}
