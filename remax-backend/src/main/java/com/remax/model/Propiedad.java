package com.remax.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "propiedad")
public class Propiedad {

	private String tipo;
	private int precio;
	private String estado;
	private String direccion;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_propiedad;
    private String ambientes;
    private Long id_agente;
    private Long id_cliente;
    
	
	
	public Propiedad(String tipo, int precio, String estado, String direccion) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.estado = estado;
		this.direccion = direccion;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
