package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
}
