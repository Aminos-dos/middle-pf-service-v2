package com.adria.middlepf.services.implementations.m2t;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class M2tWsConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.adria.middlepf.services.implementations.m2t.generated");
        return jaxb2Marshaller;
    }

    @Bean("m2tClient")
    public M2tImplementation m2tClient(Jaxb2Marshaller jaxb2Marshaller) {
        M2tImplementation m2tClientImp = new M2tImplementation();
        m2tClientImp.setDefaultUri("http://localhost:8085/");
        m2tClientImp.setMarshaller(jaxb2Marshaller);
        m2tClientImp.setUnmarshaller(jaxb2Marshaller);
        return m2tClientImp;
    }

}
