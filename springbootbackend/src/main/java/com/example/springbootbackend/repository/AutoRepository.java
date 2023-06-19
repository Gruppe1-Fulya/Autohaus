package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {
    public List<Auto> findByMarkeAndModell(String marke, String modell);

}
