package com.adria.middlepf.models.facturier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListeFacturierRequest {
    private int clientId;
    private int agregateurId;
    private int canalType;
    private int accepteurCod;
    private Long canalCod;
    private String dateOperationCanal;
    private int facturierCategorie;
    private String lang;
    private Long auditNumber;
    public ListeFacturierRequest(int canalType, int accepteurCod, Long canalCod, String dateOperationCanal, int facturierCategorie) {
        this.canalType = canalType;
        this.accepteurCod = accepteurCod;
        this.canalCod = canalCod;
        this.dateOperationCanal = dateOperationCanal;
        this.facturierCategorie = facturierCategorie;
    }
}
