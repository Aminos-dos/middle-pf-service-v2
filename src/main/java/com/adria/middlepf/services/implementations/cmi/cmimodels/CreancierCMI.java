package com.adria.middlepf.services.implementations.cmi.cmimodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreancierCMI {
    String nomCreancier;
    String codeCreancier;
    String descriptionCreancier;
    String logoPath;
    String siteWeb;
    List<ParamCMI> params;
}
