package service;

import model.Athlete;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AthleteService {

    public Map<String, List<Athlete>> groupByCountry(List<Athlete> athletes) {
        return athletes.stream()
            .filter(athlete -> athlete.getPays() != null)
            .collect(Collectors.groupingBy(Athlete::getPays));
    }

}
