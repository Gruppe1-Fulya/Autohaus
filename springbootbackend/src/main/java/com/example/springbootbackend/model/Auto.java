package com.example.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "marke")
    private String marke;

    @Column(name = "modell")
    private String modell;

    @Column(name = "zustand")
    private String zustand;

    public Auto() {
    }

    public Auto(String marke, String modell, String zustand) {
        this.marke = marke;
        this.modell = modell;
        this.zustand = zustand;
    }

    public long getId() {
        return id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marke='" + marke + '\'' +
                ", modell='" + modell + '\'' +
                ", zustand='" + zustand + '\'' +
                '}';
    }
}
