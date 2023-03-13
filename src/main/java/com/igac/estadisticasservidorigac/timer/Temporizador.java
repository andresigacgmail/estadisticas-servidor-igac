package com.igac.estadisticasservidorigac.timer;

import com.igac.estadisticasservidorigac.entities.Servidor;
import com.igac.estadisticasservidorigac.services.ServidorService;
import com.igac.estadisticasservidorigac.services.impl.ServidorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TimerTask;


public class Temporizador {

    static ServidorServiceImpl servidorService = new ServidorServiceImpl();
    //@Autowired private ServidorService servidorService;
    //List<Servidor> servidors = servidorService.getAll();

    //@Override
    public static void run() {
      /*  List<Servidor> servidors = servidorService.getAll();
        for(Servidor servidor : servidors){
            System.out.println(servidor.getIp_publica());
        }*/

        System.out.println("syeyeasd");
        //get();

    }

    private static void get(){
        List<Servidor> servidors = servidorService.getAll();
        for (Servidor servidor : servidors){
            System.out.println(servidor.getIp_publica());
        }
    }
}
