package com.adria.middlepf.services.implementations.cmi;

import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;
import com.adria.middlepf.services.AgregateurWs;
import com.adria.middlepf.services.implementations.cmi.cmimodels.GetFacturiersInCMI;
import com.adria.middlepf.services.implementations.cmi.cmimodels.GetFacturiersOutCMI;
import com.adria.middlepf.services.implementations.cmi.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service("cmiClient")
public class CmiImplementation implements AgregateurWs {
    @Autowired
    private WebClient.Builder webClientBuilder;
    private String URL_CMI_WS = "http://localhost:8080/getlistefacturiers";
    @Override
    public FacturierResponse getListeFacturier(ListeFacturierRequest request) {
        Converter converter = new Converter();
        GetFacturiersOutCMI responseFromCmi = webClientBuilder.build().method(HttpMethod.POST)
                .uri(URL_CMI_WS)
                .body(Mono.just(converter.requestGetFacturiersFromMiddleToCMI(request)), GetFacturiersInCMI.class)
                .retrieve()
                .bodyToMono(GetFacturiersOutCMI.class)
                .block();
        return converter.responseGetFacturiersFromCMIToMiddle(responseFromCmi);
    }
}
