package com.adria.middlepf.controllers;

import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;
import com.adria.middlepf.services.AgregateurInjectionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class FacturierRestController {
    @Autowired
    AgregateurInjectionConfig agregateurInjectionConfig;
    @GetMapping(path = "/GetListeFacturier")
    public FacturierResponse getListeFacturier(@RequestBody ListeFacturierRequest request) {
        return agregateurInjectionConfig.getImpl(request.getAgregateurId()).getListeFacturier(request);
    }
}
