package com.remax.model;



public class PropiedadAsignacionDTO {

    

    private Integer idPropiedad;

    private Integer idAgente;

    private String mensaje; 



    

    public PropiedadAsignacionDTO() {}

    

    

    public PropiedadAsignacionDTO(Integer idPropiedad, Integer idAgente) {

        this.idPropiedad = idPropiedad;

        this.idAgente = idAgente;

    }



    public Integer getIdPropiedad() { return idPropiedad; }

    public void setIdPropiedad(Integer idPropiedad) { this.idPropiedad = idPropiedad; }

    public Integer getIdAgente() { return idAgente; }

    public void setIdAgente(Integer idAgente) { this.idAgente = idAgente; }

    public String getMensaje() { return mensaje; }

    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

}