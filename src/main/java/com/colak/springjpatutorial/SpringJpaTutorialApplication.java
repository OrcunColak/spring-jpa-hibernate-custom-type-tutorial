package com.colak.springjpatutorial;

import com.colak.springjpatutorial.customtype.IPAddress;
import com.colak.springjpatutorial.jpa.Device;
import com.colak.springjpatutorial.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaTutorialApplication implements CommandLineRunner {

    private DeviceService deviceService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Device device = new Device();
        device.setName("device1");
        IPAddress ipAddress = new IPAddress("10.10.10.1");
        device.setIpAddress(ipAddress);

        deviceService.create(device);
    }
}
