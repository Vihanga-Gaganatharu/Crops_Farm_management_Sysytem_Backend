package lk.ijse.crops_farm_management_sysytem_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CropsFarmManagementSysytemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CropsFarmManagementSysytemBackendApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
