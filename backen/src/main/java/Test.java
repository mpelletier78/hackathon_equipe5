import parsing.CSVToJsonConverter;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        CSVToJsonConverter converter = new CSVToJsonConverter();
        String path = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/ATHLE_Finales_CM_JO_1983_2022_.csv";
        System.out.println(converter.convertCompetitors(path));

        String path2 = "/Users/P002654/hackathon_equipe5/backen/src/main/resources/data_historique/NATATION_Finales_CM_2019_2024.csv";
        System.out.println(converter.convertAthletes(path2));

    }
}
