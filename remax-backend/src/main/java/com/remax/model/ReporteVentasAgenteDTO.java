package com.remax.model;

public class ReporteVentasAgenteDTO {

    private String nombreAgente;
    private Long totalVentas;
    private Double totalMontoVendido;
    private Double totalComisionEstimada;

    public ReporteVentasAgenteDTO() {}

    // Constructor 
    public ReporteVentasAgenteDTO(String nombreAgente, Long totalVentas, Double totalMontoVendido, Double totalComisionEstimada) {
        this.nombreAgente = nombreAgente;
        this.totalVentas = totalVentas;
        this.totalMontoVendido = totalMontoVendido;
        this.totalComisionEstimada = totalComisionEstimada;
    }

    // Getters y Setters
    public String getNombreAgente() { return nombreAgente; }
    public void setNombreAgente(String nombreAgente) { this.nombreAgente = nombreAgente; }
    public Long getTotalVentas() { return totalVentas; }
    public void setTotalVentas(Long totalVentas) { this.totalVentas = totalVentas; }
    public Double getTotalMontoVendido() { return totalMontoVendido; }
    public void setTotalMontoVendido(Double totalMontoVendido) { this.totalMontoVendido = totalMontoVendido; }
    public Double getTotalComisionEstimada() { return totalComisionEstimada; }
    public void setTotalComisionEstimada(Double totalComisionEstimada) { this.totalComisionEstimada = totalComisionEstimada; }
    
}
