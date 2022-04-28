package com.adria.middlepf.services.implementations.cmi.cmimodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class GetFacturiersInCMI {
    int typeCanal;
    int acquereurID;
    int modeID;
    Long canalID;
    String dateServeur;
    int categorieCreance;
    double refTxSysPmt;
    String MAC;

    public GetFacturiersInCMI(int typeCanal, int acquereurID, int modeID, Long canalID, String dateServeur, double refTxSysPmt, String MAC) {
        this.typeCanal = typeCanal;
        this.acquereurID = acquereurID;
        this.modeID = modeID;
        this.canalID = canalID;
        this.dateServeur = dateServeur;
        this.refTxSysPmt = refTxSysPmt;
        this.MAC = MAC;
    }

    public GetFacturiersInCMI(int typeCanal, int acquereurID, int modeID, Long canalID, String dateServeur, String MAC) {
        this.typeCanal = typeCanal;
        this.acquereurID = acquereurID;
        this.modeID = modeID;
        this.canalID = canalID;
        this.dateServeur = dateServeur;
        this.MAC = MAC;
    }
}
