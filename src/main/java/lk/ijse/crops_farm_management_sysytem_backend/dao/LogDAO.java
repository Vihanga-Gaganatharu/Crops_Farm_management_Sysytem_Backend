package lk.ijse.crops_farm_management_sysytem_backend.dao;

import lk.ijse.crop_monitoring_systembackend.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDAO extends JpaRepository<LogEntity, String> {}
