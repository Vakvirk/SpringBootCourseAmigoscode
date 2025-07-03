
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SoftwareEngineer;

// JpaRepository<Model, typ klucza>

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {

}
