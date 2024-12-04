package lk.ijse.crops_farm_management_sysytem_backend.dao;

import lk.ijse.crops_farm_management_sysytem_backend.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffDAO extends JpaRepository<StaffEntity, String> {
    Optional<StaffEntity> findByEmail(String email);
    Optional<StaffEntity.Role> findRoleByEmail(String email);
}
