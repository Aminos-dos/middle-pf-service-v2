package com.adria.middlepf.services.implementations.cmi.utils;

import com.adria.middlepf.models.facturier.Facturier;
import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;
import com.adria.middlepf.models.facturier.Params;
import com.adria.middlepf.services.implementations.cmi.cmimodels.CreancierCMI;
import com.adria.middlepf.services.implementations.cmi.cmimodels.GetFacturiersInCMI;
import com.adria.middlepf.services.implementations.cmi.cmimodels.GetFacturiersOutCMI;
import com.adria.middlepf.services.implementations.cmi.cmimodels.ParamCMI;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public ParamCMI paramFromMiddleToCMI(Params paramMiddle){
        return new ParamCMI(paramMiddle.getDataName(),paramMiddle.getDataVal());
    }
    public Params paramFromCMIToMiddle(ParamCMI paramCMI){
        return new Params(paramCMI.getNomChamp(),paramCMI.getValeurChamp());
    }
    public Facturier facturierFromCMIToMiddle(CreancierCMI creancierCMI){
        List<Params> params=new ArrayList<>();
        for(ParamCMI paramCMI:creancierCMI.getParams()){
            params.add(paramFromCMIToMiddle(paramCMI));
        }
        return new Facturier(Long.parseLong(creancierCMI.getCodeCreancier()),creancierCMI.getNomCreancier(),creancierCMI.getDescriptionCreancier(),
                creancierCMI.getLogoPath(),creancierCMI.getSiteWeb(),params);
    }
    public CreancierCMI facturierFromMiddleToCMI(Facturier facturier){
        List<ParamCMI> params = new ArrayList<>();
        for(Params param : facturier.getParams()){
            params.add(paramFromMiddleToCMI(param));
        }
        return new CreancierCMI(facturier.getFacturierName(),facturier.getFacturierId().toString(),facturier.getFacturierDesc(),facturier.getFacturierLogo(),
                facturier.getFacturierWebSite(),params);
    }
    public GetFacturiersInCMI requestGetFacturiersFromMiddleToCMI(ListeFacturierRequest listeFacturierRequest){
        return new GetFacturiersInCMI(listeFacturierRequest.getCanalType(),listeFacturierRequest.getAccepteurCod(),listeFacturierRequest.getCanalType(),
                listeFacturierRequest.getCanalCod(),listeFacturierRequest.getDateOperationCanal(),"JWT security tokent");
    }
    public ListeFacturierRequest requestGetFacturiersFromCMIToMiddle(GetFacturiersInCMI getFacturiersInCMI){
        return new ListeFacturierRequest(getFacturiersInCMI.getTypeCanal(),getFacturiersInCMI.getAcquereurID(),getFacturiersInCMI.getCanalID(),getFacturiersInCMI.getDateServeur(),getFacturiersInCMI.getCategorieCreance());
    }
    public FacturierResponse responseGetFacturiersFromCMIToMiddle(GetFacturiersOutCMI getFacturiersOutCMI){
        List<Facturier> facturiers = new ArrayList<Facturier>();
        for(CreancierCMI creancierCMI:getFacturiersOutCMI.getListeCreanciers()){
            facturiers.add(facturierFromCMIToMiddle(creancierCMI));
        }
        return new FacturierResponse(getFacturiersOutCMI.getDateServeur(), getFacturiersOutCMI.getCodeRetour(), getFacturiersOutCMI.getMsg(), facturiers.size(), facturiers);
    }
    public GetFacturiersOutCMI responseFacturiersFromMiddleToCMI(FacturierResponse facturierResponse){
        List<CreancierCMI> facturiers = new ArrayList<>();
        for(Facturier facturier:facturierResponse.getListeFacturiers()){
            facturiers.add(facturierFromMiddleToCMI(facturier));
        }
        return new GetFacturiersOutCMI(facturierResponse.getDateOperationServeur(),facturierResponse.getCodeRetour(),facturierResponse.getMessageRetour(),
                facturiers.size(),facturiers,"JWT security tokent");
    }
}
