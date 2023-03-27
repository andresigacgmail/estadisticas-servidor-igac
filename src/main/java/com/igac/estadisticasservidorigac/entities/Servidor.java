package com.igac.estadisticasservidorigac.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servidor")
public class Servidor {

    public Servidor() {
    }

    public Servidor(long t_id, String direccion_ip_privada, String direccion_ip_publica, String puerto, String usuario, String contrasenia, String nombre, String alias, String uso, String dominio, int tipo_protocolo) {
        this.t_id = t_id;
        this.direccion_ip_privada = direccion_ip_privada;
        this.direccion_ip_publica = direccion_ip_publica;
        this.puerto = puerto;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.alias = alias;
        this.uso = uso;
        this.dominio = dominio;
        this.tipo_protocolo = tipo_protocolo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long t_id;
    private String direccion_ip_privada;
    private String direccion_ip_publica;

    private String puerto;

    private String usuario;

    private String contrasenia;

    private String nombre;

    private String alias;
    private String uso;
    private String dominio;
    private int tipo_protocolo;

    public long getT_id() {
        return t_id;
    }

    public void setT_id(long t_id) {
        this.t_id = t_id;
    }

    public String getDireccion_ip_privada() {
        return direccion_ip_privada;
    }

    public void setDireccion_ip_privada(String direccion_ip_privada) {
        this.direccion_ip_privada = direccion_ip_privada;
    }

    public String getDireccion_ip_publica() {
        return direccion_ip_publica;
    }

    public void setDireccion_ip_publica(String direccion_ip_publica) {
        this.direccion_ip_publica = direccion_ip_publica;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public int getTipo_protocolo() {
        return tipo_protocolo;
    }

    public void setTipo_protocolo(int tipo_protocolo) {
        this.tipo_protocolo = tipo_protocolo;
    }
}
