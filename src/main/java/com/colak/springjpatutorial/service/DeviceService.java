package com.colak.springjpatutorial.service;

import com.colak.springjpatutorial.jpa.Device;
import com.colak.springjpatutorial.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository repository;

    @Transactional
    public Device create(Device device) {
        return repository.save(device);
    }
}
