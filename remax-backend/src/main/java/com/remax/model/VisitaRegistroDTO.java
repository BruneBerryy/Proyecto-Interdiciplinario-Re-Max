package com.remax.model;

// @Data

public class VisitaRegistroDTO {

    private Integer idAgente;

    private Integer idCliente;

    private Integer idPropiedad;

    private String fecha; 

    private String mensaje;

	public Integer getIdAgente() {

		return idAgente;

	}

	

	public VisitaRegistroDTO() {

	}



	public VisitaRegistroDTO(Integer idAgente, Integer idCliente, Integer idPropiedad, String fecha, String mensaje) {

		super();

		this.idAgente = idAgente;

		this.idCliente = idCliente;

		this.idPropiedad = idPropiedad;

		this.fecha = fecha;

		this.mensaje = mensaje;

	}



	public void setIdAgente(Integer idAgente) {

		this.idAgente = idAgente;

	}

	public Integer getIdCliente() {

		return idCliente;

	}

	public void setIdCliente(Integer idCliente) {

		this.idCliente = idCliente;

	}

	public Integer getIdPropiedad() {

		return idPropiedad;

	}

	public void setIdPropiedad(Integer idPropiedad) {

		this.idPropiedad = idPropiedad;

	}

	public String getFecha() {

		return fecha;

	}

	public void setFecha(String fecha) {

		this.fecha = fecha;

	}

	public String getMensaje() {

		return mensaje;

	}

	public void setMensaje(String mensaje) {

		this.mensaje = mensaje;

	} 

    
 

}