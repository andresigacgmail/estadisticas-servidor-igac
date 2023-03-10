package com.igac.estadisticasservidorigac.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servidores")
public class Servidor {

    public Servidor() {
    }

    public Servidor(long id, String ip_publica, String ip_local, Date creado, Date actualizado) {
        this.id = id;
        this.ip_publica = ip_publica;
        this.ip_local = ip_local;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ip_publica;

    private String ip_local;

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

    public String getIp_publica() {
        return ip_publica;
    }

    public void setIp_publica(String ip_publica) {
        this.ip_publica = ip_publica;
    }

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
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
