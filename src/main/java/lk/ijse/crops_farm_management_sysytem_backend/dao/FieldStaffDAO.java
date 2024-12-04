package lk.ijse.crops_farm_management_sysytem_backend.dao;

import lk.ijse.crops_farm_management_sysytem_backend.entity.FieldStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldStaffDAO extends JpaRepository<FieldStaffEntity, String > {
    void deleteByField_FieldId(String fieldId);
    List<FieldStaffEntity> findByField_FieldId(String fieldId);
}
