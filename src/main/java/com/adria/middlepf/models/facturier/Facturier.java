package com.adria.middlepf.models.facturier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facturier {
    private Long FacturierId;
    private String FacturierName;
    private String FacturierDesc;
    private String FacturierLogo;
    private String FacturierWebSite;
    private List<Params> Params;
}
