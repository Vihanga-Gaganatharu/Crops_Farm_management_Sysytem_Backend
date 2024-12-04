package lk.ijse.crops_farm_management_sysytem_backend.service;

import lk.ijse.crop_monitoring_systembackend.dto.LogDTO;

import java.util.List;

public interface LogService {
    void saveLog(LogDTO log);
    void updateLog(String id, LogDTO log);
    LogDTO searchLog(String id);
    boolean deleteLog(String id);
    List<LogDTO> getAllLogs();
}
