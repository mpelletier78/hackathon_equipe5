package service;

import model.NatModel;
import model.ResultatNat;

import java.util.List;

public interface NatResultatService {
    ResultatNat calculateResultat(List<NatModel> nats);
}
