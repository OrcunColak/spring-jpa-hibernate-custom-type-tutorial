package com.colak.springjpatutorial.repository;

import com.colak.springjpatutorial.jpa.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
