package lk.ijse.crops_farm_management_sysytem_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {
    private static final Logger logger = Logger.getLogger(HealthController.class.getName());

    @GetMapping
    public String checkHealth(){
        logger.info("Crop Monitoring System API is Running");
        return "Crop Monitoring System API is Running";
    }
}
