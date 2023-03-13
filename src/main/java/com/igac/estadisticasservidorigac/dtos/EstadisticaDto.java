package com.igac.estadisticasservidorigac.dtos;

import java.util.List;

public class EstadisticaDto {



    public EstadisticaDto() {

    }

    public EstadisticaDto(List<DiscoDto> discos, double memoria_total, double memoria_disponible, double memoria_uso) {
        this.discos = discos;
        this.memoria_total = memoria_total;
        Memoria_disponible = memoria_disponible;
        this.memoria_uso = memoria_uso;
    }

    private List<DiscoDto> discos;

    private double memoria_total;
    private double Memoria_disponible;
    private double memoria_uso;


    public List<DiscoDto> getDiscos() {
        return discos;
    }

    public void setDiscos(List<DiscoDto> discos) {
        this.discos = discos;
    }

    public double getMemoria_total() {
        return memoria_total;
    }

    public void setMemoria_total(double memoria_total) {
        this.memoria_total = memoria_total;
    }

    public double getMemoria_disponible() {
        return Memoria_disponible;
    }

    public void setMemoria_disponible(double memoria_disponible) {
        Memoria_disponible = memoria_disponible;
    }

    public double getMemoria_uso() {
        return memoria_uso;
    }

    public void setMemoria_uso(double memoria_uso) {
        this.memoria_uso = memoria_uso;
    }
}
