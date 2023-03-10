package com.igac.estadisticasservidorigac.dtos;

import com.sun.istack.NotNull;

public class ServidorDto {

    @NotNull
    private String ip_publica;

    @NotNull
    private String ip_local;




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

}
