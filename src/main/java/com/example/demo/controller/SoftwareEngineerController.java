
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SoftwareEngineerDTO;
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

}
