package com.igac.estadisticasservidorigac.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "estadisticas")
public class Estadistica {

    public Estadistica() {
    }


    public Estadistica(double disco_total, double disco_disponible, double disco_uso, double memoria_total, double memoria_disponible, double memoria_uso, long id_servidor) {
        this.disco_total = disco_total;
        this.disco_disponible = disco_disponible;
        this.disco_uso = disco_uso;
        this.memoria_total = memoria_total;
        Memoria_disponible = memoria_disponible;
        this.memoria_uso = memoria_uso;
        this.id_servidor = id_servidor;
    }

    public Estadistica(long id, double disco_total, double disco_disponible, double disco_uso, double memoria_total, double memoria_disponible, double memoria_uso, long id_servidor, Date creado, Date actualizado) {
        this.id = id;
        this.disco_total = disco_total;
        this.disco_disponible = disco_disponible;
        this.disco_uso = disco_uso;
        this.memoria_total = memoria_total;
        Memoria_disponible = memoria_disponible;
        this.memoria_uso = memoria_uso;
        this.id_servidor = id_servidor;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private double disco_total;
    private double disco_disponible;
    private double disco_uso;
    private double memoria_total;
    private double Memoria_disponible;
    private double memoria_uso;


    private long id_servidor;
    @CreationTimestamp
    private Date creado;
    @UpdateTimestamp
    private Date actualizado;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(long id_servidor) {
        this.id_servidor = id_servidor;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }
}