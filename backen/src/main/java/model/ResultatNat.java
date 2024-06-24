package model;

import java.util.List;
import java.util.Map;

public class ResultatNat {

    private Map<String, Map<String, List<NatModel>>> resultat;

    public Map<String, Map<String, List<NatModel>>> getResultat() {
        return resultat;
    }

    public void setResultat(Map<String, Map<String, List<NatModel>>> resultat) {
        this.resultat = resultat;
    }
}
