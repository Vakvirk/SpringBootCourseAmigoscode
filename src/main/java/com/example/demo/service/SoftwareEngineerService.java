package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.SoftwareEngineer.SoftwareEngineerCreateDTO;
import com.example.demo.DTO.SoftwareEngineer.SoftwareEngineerDTO;
import com.example.demo.mapper.SoftwareEngineerDTOMapper;
import com.example.demo.model.SoftwareEngineer;
import com.example.demo.repository.SoftwareEngineerRepository;

import jakarta.persistence.EntityNotFoundException;

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
                .toList();
    }

    public SoftwareEngineerDTO getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).map(softwareEngineerDTOMapper)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono inżyniera z id " + id));
    }

    public void createEngineer(SoftwareEngineerCreateDTO dto) {
        SoftwareEngineer engineer = new SoftwareEngineer();
        engineer.setName(dto.name());
        engineer.setTechStack(dto.techStack());
        softwareEngineerRepository.save(engineer);
    }

    public void deleteEngineer(Integer id) {
        if (!softwareEngineerRepository.existsById(id)) {
            throw new EntityNotFoundException("Nie znaleziono inżyniera z id " + id);
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateEngineer(Integer id, SoftwareEngineerCreateDTO dto) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono inżyniera z id " + id));
        engineer.setName(dto.name());
        engineer.setTechStack(dto.techStack());
        softwareEngineerRepository.save(engineer);
    }

}
