package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {

}
