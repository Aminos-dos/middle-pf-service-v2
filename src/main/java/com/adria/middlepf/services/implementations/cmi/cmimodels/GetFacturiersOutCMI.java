package com.adria.middlepf.services.implementations.cmi.cmimodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor

public class GetFacturiersOutCMI {
    String dateServeur;
    int codeRetour;
    String msg;
    int nbreCreancier;
    List<CreancierCMI> listeCreanciers;
    String MAC;
}
