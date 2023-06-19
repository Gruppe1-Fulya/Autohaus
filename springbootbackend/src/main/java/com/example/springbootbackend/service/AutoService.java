package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoService {

    List<Auto> getAllAuto();

    Auto getAutoById(long theId);

    List<Auto> getAutoByMarkeAndModell(String marke, String modell);

    Auto saveAuto(Auto theAuto);

    Auto updateAuto(Auto theAuto, long theId);

    void deleteAutoById(long theId);



}
