import model.Athlete;
import parsing.CSVToJsonConverter;
import service.AthleteService;

import java.io.IOException;
import java.util.List;

import static parsing.CSVToJsonConverter.mapHistoricToAthletes;

public class Test {

    public static void main(String[] args) throws IOException {

        CSVToJsonConverter converter = new CSVToJsonConverter();

//        CSVToJsonConverter converter = new CSVToJsonConverter();
//        String path = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/ATHLE_Finales_CM_JO_1983_2022_.csv";
//        System.out.println(converter.convertCompetitors(path));

        String path2 = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/NATATION_Finales_CM_2019_2024.csv";
//        System.out.println(converter.convertAthletes(path2));

        AthleteService service = new AthleteService();
        List<Athlete> athletes = mapHistoricToAthletes(path2);
        System.out.println(service.groupByCountry(athletes));

    }
}
