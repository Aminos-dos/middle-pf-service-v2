package com.adria.middlepf.services.implementations.m2t;

import com.adria.middlepf.models.facturier.FacturierResponse;
import com.adria.middlepf.models.facturier.ListeFacturierRequest;
import com.adria.middlepf.services.AgregateurWs;
import com.adria.middlepf.services.implementations.m2t.generated.GetListeFacturiers;
import com.adria.middlepf.services.implementations.m2t.generated.GetListeFacturiersResponse;
import com.adria.middlepf.services.implementations.m2t.generated.ObjectFactory;
import com.adria.middlepf.services.implementations.m2t.mappers.FacturierMapper;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;


public class M2tImplementation extends WebServiceGatewaySupport implements AgregateurWs {
    @Override
    public FacturierResponse getListeFacturier(ListeFacturierRequest listeFacturierRequest) {
        GetListeFacturiers request = FacturierMapper.listeFacturierRequestToXmlRequest(listeFacturierRequest);
        JAXBElement<GetListeFacturiers> jAXBElement = new ObjectFactory().createGetListeFacturiers(request);
        JAXBElement<GetListeFacturiersResponse> aXBElementResponse = (JAXBElement<GetListeFacturiersResponse>) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8085/", jAXBElement, new SoapActionCallback("getListeFacturier"));
        return FacturierMapper.FacturierXmlResponseToFacturierResponse(aXBElementResponse.getValue());
    }
}
