package com.adria.middlepf.models.facturier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturierResponse {
    private String DateOperationServeur;
    private int codeRetour;
    private String messageRetour;
    private int NbrFacturiers;
    private List<Facturier> ListeFacturiers;
}
