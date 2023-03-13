package com.igac.estadisticasservidorigac.dtos;

public class DiscoDto {


    public DiscoDto() {
    }

    public DiscoDto(String path, double disco_total, double disco_disponible, double disco_uso) {
        this.path = path;
        this.disco_total = disco_total;
        this.disco_disponible = disco_disponible;
        this.disco_uso = disco_uso;
    }

    private String path;
    private double disco_total;
    private double disco_disponible;
    private double disco_uso;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getDisco_total() {
        return disco_total;
    }

    public void setDisco_total(double disco_total) {
        this.disco_total = disco_total;
    }

    public double getDisco_disponible() {
        return disco_disponible;
    }

    public void setDisco_disponible(double disco_disponible) {
        this.disco_disponible = disco_disponible;
    }

    public double getDisco_uso() {
        return disco_uso;
    }

    public void setDisco_uso(double disco_uso) {
        this.disco_uso = disco_uso;
    }
}
