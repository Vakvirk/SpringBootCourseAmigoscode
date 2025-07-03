package com.example.demo.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.SoftwareEngineerDTO;
import com.example.demo.model.SoftwareEngineer;

@Service
public class SoftwareEngineerDTOMapper implements Function<SoftwareEngineer, SoftwareEngineerDTO> {
    @Override
    public SoftwareEngineerDTO apply(SoftwareEngineer softwareEngineer) {
        return new SoftwareEngineerDTO(
                softwareEngineer.getId(),
                softwareEngineer.getName(),
                softwareEngineer.getTechStack());
    }

}
