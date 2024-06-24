import model.Athlete;
import model.NatModel;
import parsing.CSVToJsonConverter;
import service.AthleteService;

import java.io.IOException;
import java.util.List;

import static parsing.CSVToJsonConverter.mapHistoricToAthletes;
import static parsing.CSVToJsonConverter.mapToNat;

public class Test {

    public static void main(String[] args) throws IOException {

        CSVToJsonConverter converter = new CSVToJsonConverter();

//        CSVToJsonConverter converter = new CSVToJsonConverter();
//        String path = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/ATHLE_Finales_CM_JO_1983_2022_.csv";
//        System.out.println(converter.convertCompetitors(path));

        String path2 = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/NATATION_Finales_CM_2019_2024.csv";
        String path3 = "/Users/C453079/repo/hackathon_equipe5/backen/src/main/resources/data_historique/Nat_D1.csv";
//        System.out.println(converter.convertAthletes(path2));

        AthleteService service = new AthleteService();

        List<NatModel> natModels = mapToNat(path3);


        service.groupBySportRound(natModels);

        System.out.println(service.groupBySportRound(natModels));

    }
}
