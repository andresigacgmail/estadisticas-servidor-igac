package com.igac.estadisticasservidorigac.timer;

import com.igac.estadisticasservidorigac.services.impl.EstadisticaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service @EnableScheduling
public class Begin {

    @Autowired private EstadisticaServiceImpl estadisticaService;

    @EventListener
    public void eventListener(ContextRefreshedEvent contextRefreshedEvent) {

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
