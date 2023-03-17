package com.igac.estadisticasservidorigac.dtos;

public class MesDto {

    public MesDto() {
    }

    public MesDto(String mes, String uso) {
        this.mes = mes;
        this.uso = uso;
    }

    private String mes;
    private String uso;


    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
}
