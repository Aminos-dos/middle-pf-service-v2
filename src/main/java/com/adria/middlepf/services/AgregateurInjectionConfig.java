package com.adria.middlepf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;


@Configuration
public class AgregateurInjectionConfig {

    @Autowired
    Map<String, AgregateurWs> agregateurList;


    public AgregateurWs getImpl(int agregateurId) {
        switch (agregateurId) {
            case 1:
                return agregateurList.get("m2tClient");
            case 2:
                return agregateurList.get("cmiClient");
            default:
                return null;
        }
    }
}
