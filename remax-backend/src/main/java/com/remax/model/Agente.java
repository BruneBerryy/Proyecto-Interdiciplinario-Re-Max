package com.remax.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agente")
public class Agente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agente;

    private int comision;

    public Agente() {}

    public Agente(String nombre, String email, int telefono, int comision) {
        super(nombre, email, telefono);
        this.comision = comision;
    }

    public Long getId_agente() {
        return id_agente;
    }

    public void setId_agente(Long id_agente) {
        this.id_agente = id_agente;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }
}
