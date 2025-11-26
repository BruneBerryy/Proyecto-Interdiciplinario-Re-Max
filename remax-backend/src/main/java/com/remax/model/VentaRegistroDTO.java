package com.remax.model;

public class VentaRegistroDTO {

    private Integer idPropiedad;
    private Integer idCliente;
    private Integer idAgente;
    private Double monto;
    private String mensaje; 

    public VentaRegistroDTO() {
    }

    public VentaRegistroDTO(Integer idPropiedad, Integer idCliente, Integer idAgente, Double monto) {
        this.idPropiedad = idPropiedad;
        this.idCliente = idCliente;
        this.idAgente = idAgente;
        this.monto = monto;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdAgente() {
        return idAgente;
    }

    public Double getMonto() {
        return monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdAgente(Integer idAgente) {
        this.idAgente = idAgente;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}