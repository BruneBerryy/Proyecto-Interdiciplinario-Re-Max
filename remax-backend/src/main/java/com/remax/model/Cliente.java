package com.remax.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String preferencias;

    public Cliente() {}

    public Cliente(String nombre, String email, int telefono, String preferencias) {
        super(nombre, email, telefono);
        this.preferencias = preferencias;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
