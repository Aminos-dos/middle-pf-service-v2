package com.adria.middlepf.services;

import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;

public interface AgregateurWs {
    FacturierResponse getListeFacturier(ListeFacturierRequest request);
}
