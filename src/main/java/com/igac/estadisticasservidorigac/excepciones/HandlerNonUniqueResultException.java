package com.igac.estadisticasservidorigac.excepciones;


import javax.persistence.PersistenceException;
public class HandlerNonUniqueResultException extends PersistenceException {


    public HandlerNonUniqueResultException(String nombreDelRecurso, String nombreDelCampo, String valorDelCampo) {
        super(String.format("%s multiples campos con : %s = '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private String valorDelCampo;


    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public String getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(String valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }
}
