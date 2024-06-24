package parsing;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Athlete;
import model.Competitor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVToJsonConverter {

    public String convertAthletes(String csvFilePath) throws IOException {
        List<Athlete> athletes = mapToAthletes(csvFilePath);
        Gson gson = new Gson();
        return gson.toJson(athletes);
    }

    private static List<Athlete> mapToAthletes(String csvFilePath) throws FileNotFoundException {
        return new CsvToBeanBuilder<Athlete>(new FileReader(csvFilePath))
            .withType(Athlete.class)
            .build()
            .parse();
    }

    public String convertCompetitors(String csvFilePath) throws IOException {
        List<Competitor> competitors = mapCompetitors(csvFilePath);

        Gson gson = new Gson();
        return gson.toJson(competitors);
    }

    private static List<Competitor> mapCompetitors(String csvFilePath) throws FileNotFoundException {
        return new CsvToBeanBuilder<Competitor>(new FileReader(csvFilePath))
            .withType(Competitor.class)
            .build()
            .parse();
    }
}