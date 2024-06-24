package service;

import model.Athlete;
import model.NatModel;
import model.ResultatNat;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NatResultatServiceImpl implements NatResultatService {

    public Map<String, List<Athlete>> groupByCountry(List<Athlete> athletes) {
        return athletes.stream()
            .filter(athlete -> athlete.getPays() != null)
            .collect(Collectors.groupingBy(Athlete::getPays));
    }

    @Override
    public ResultatNat calculateResultat(List<NatModel> nats) {
        ResultatNat resultatNat = new ResultatNat();
        resultatNat.setResultat(calculateResulta(nats));
        return resultatNat;
    }

    private static Map<String, Map<String, List<NatModel>>> calculateResulta(List<NatModel> nats) {
        return nats.stream()
            .filter(nat -> nat.getSport() != null && nat.getRound() != null && nat.getMark() != null)
            .collect(Collectors.groupingBy(NatModel::getSport,
                Collectors.groupingBy(NatModel::getRound,
                    Collectors.collectingAndThen(Collectors.toList(), list -> {
                        list.sort(Comparator.comparing(NatModel::getMark));
                        return list;
                    }))));
    }

}
