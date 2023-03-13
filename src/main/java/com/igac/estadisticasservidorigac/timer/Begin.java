package com.igac.estadisticasservidorigac.timer;

import com.igac.estadisticasservidorigac.services.impl.EstadisticaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class Begin {

    @Autowired private static EstadisticaServiceImpl estadisticaService;

    @EventListener
    public void eventListener(ContextRefreshedEvent contextRefreshedEvent) {
         /*ScheduledExecutorService executorService;
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Begin::run, 0, 8, TimeUnit.SECONDS);*/


    }

    @Scheduled(fixedDelay = 8000)
    public  void run() {
       System.out.println("seep");
       try {
           estadisticaService.guardarEstadosAutomatico();
       }catch (Exception ex){
           System.out.println(ex.getMessage());
       }
    }
}
