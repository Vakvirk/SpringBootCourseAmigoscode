
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SoftwareEngineer.SoftwareEngineerCreateDTO;
import com.example.demo.DTO.SoftwareEngineer.SoftwareEngineerDTO;
import com.example.demo.service.SoftwareEngineerService;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

        private final SoftwareEngineerService softwareEngineerService;

        public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
                this.softwareEngineerService = softwareEngineerService;
        }

        @GetMapping
        public List<SoftwareEngineerDTO> getEngineers() {
                return softwareEngineerService.getAllSoftwareEngineers();
        }

        @GetMapping("{id}")
        public SoftwareEngineerDTO getEngineersByID(@PathVariable Integer id) {
                return softwareEngineerService.getSoftwareEngineerById(id);
        }

        @PostMapping
        public void addSoftwareEngineer(@RequestBody SoftwareEngineerCreateDTO dto) {
                softwareEngineerService.createEngineer(dto);
        }

        @DeleteMapping("{id}")
        public void deleteSoftwareEngineer(@PathVariable Integer id) {
                softwareEngineerService.deleteEngineer(id);
        }

        @PutMapping("{id}")
        public void updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineerCreateDTO dto) {
                softwareEngineerService.updateEngineer(id, dto);
        }

}
