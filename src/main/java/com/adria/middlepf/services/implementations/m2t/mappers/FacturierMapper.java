package com.adria.middlepf.services.implementations.m2t.mappers;

import com.adria.middlepf.models.facturier.Facturier;
import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;
import com.adria.middlepf.models.facturier.Params;
import com.adria.middlepf.services.implementations.m2t.generated.GetListeFacturiers;
import com.adria.middlepf.services.implementations.m2t.generated.GetListeFacturiersResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class FacturierMapper {
    public static FacturierResponse FacturierXmlResponseToFacturierResponse(GetListeFacturiersResponse xmlResponse) {
        FacturierResponse facturierResponse = new FacturierResponse();
        facturierResponse.setCodeRetour(Integer.valueOf(xmlResponse.getReturn().getErrorCod()));
        facturierResponse.setMessageRetour(xmlResponse.getReturn().getErrorMsg());
        facturierResponse.setNbrFacturiers(Integer.valueOf(xmlResponse.getReturn().getNbFacturiers()));
        facturierResponse.setDateOperationServeur(xmlResponse.getReturn().getDateOperationServeur());
        List<Facturier> facturiers = new ArrayList<>();
        xmlResponse.getReturn().getListeFacturiers().getItem().stream().forEach(f -> {
            List<Params> params = new ArrayList<>();
            f.getParams().stream().forEach(p -> {
                params.add(new Params(p.getDataName(), p.getDataVal()));
            });
            facturiers.add(new Facturier(Long.valueOf(f.getFacturierCod()), f.getFacturierName(), f.getFacturierDesc(), f.getFacturierLogo(), f.getFacturierWebSite(), params));
        });
        facturierResponse.setListeFacturiers(facturiers);
        return facturierResponse;
    }

    public static GetListeFacturiers listeFacturierRequestToXmlRequest(ListeFacturierRequest listeFacturierRequest) {
        GetListeFacturiers getListeFacturiers = new GetListeFacturiers();
        getListeFacturiers.setAccepteurCod(String.valueOf(listeFacturierRequest.getAccepteurCod()));
        getListeFacturiers.setCanalCod(String.valueOf(listeFacturierRequest.getCanalCod()));
        getListeFacturiers.setFacturierCategorie(String.valueOf(listeFacturierRequest.getFacturierCategorie()));
        getListeFacturiers.setDateOperationCanal(String.valueOf(listeFacturierRequest.getDateOperationCanal()));
        getListeFacturiers.setAuditNumber(String.valueOf(listeFacturierRequest.getAuditNumber()));
        getListeFacturiers.setCanalType(String.valueOf(listeFacturierRequest.getCanalType()));
        getListeFacturiers.setLang(String.valueOf(listeFacturierRequest.getLang()));
        //to set later using JWT
        getListeFacturiers.setSecurityMAC("JWT security tokent");

        return getListeFacturiers;
    }
}
