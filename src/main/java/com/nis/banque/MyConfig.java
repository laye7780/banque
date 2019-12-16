package com.nis.banque;

import com.nis.banque.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
    @Bean
    public SimpleJaxWsServiceExporter getJWS(){
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter=new SimpleJaxWsServiceExporter();
        simpleJaxWsServiceExporter.setBaseAddress("http://localhost:8089/maBanque");
        return simpleJaxWsServiceExporter;
    }
    @Bean
    public RmiServiceExporter getRmiService(ApplicationContext applicationContext){
        RmiServiceExporter rmiServiceExporter=new RmiServiceExporter();
        rmiServiceExporter.setService(applicationContext.getBean("myRmiService"));
        rmiServiceExporter.setRegistryPort(1099);
        rmiServiceExporter.setServiceName("BK");
        rmiServiceExporter.setServiceInterface(BanqueRmiRemote.class);
        return rmiServiceExporter;
    }
}
