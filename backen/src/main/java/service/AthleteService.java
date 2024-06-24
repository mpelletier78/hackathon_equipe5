package service;

import model.Athlete;
import model.NatModel;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AthleteService {

    public Map<String, List<Athlete>> groupByCountry(List<Athlete> athletes) {
        return athletes.stream()
            .filter(athlete -> athlete.getPays() != null)
            .collect(Collectors.groupingBy(Athlete::getPays));
    }

    public Map<String, Map<String, Map<String, List<NatModel>>>> groupBySportSexRound(List<NatModel> nats) {
        return nats.stream()
            .collect(Collectors.groupingBy(NatModel::getSport,
                Collectors.groupingBy(NatModel::getSex,
                    Collectors.groupingBy(NatModel::getRound,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            list.sort(Comparator.comparing(NatModel::getMark));
                            return list;
                        })))));
    }

}
