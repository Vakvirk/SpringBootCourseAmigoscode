package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.SoftwareEngineerDTO;
import com.example.demo.mapper.SoftwareEngineerDTOMapper;
import com.example.demo.repository.SoftwareEngineerRepository;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final SoftwareEngineerDTOMapper softwareEngineerDTOMapper;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository,
            SoftwareEngineerDTOMapper softwareEngineerDTOMapper) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.softwareEngineerDTOMapper = softwareEngineerDTOMapper;
    }

    public List<SoftwareEngineerDTO> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll()
                .stream()
                .map(softwareEngineerDTOMapper)
                .collect(Collectors.toList());
    }

}
