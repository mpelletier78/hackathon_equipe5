package parsing;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Athlete;
import model.Competitor;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVToJsonConverter {

    public String convertAthletes(String csvFilePath) throws IOException {
        List<Athlete> athletes = new CsvToBeanBuilder<Athlete>(new FileReader(csvFilePath))
            .withType(Athlete.class)
            .build()
            .parse();

        Gson gson = new Gson();
        return gson.toJson(athletes);
    }

    public String convertCompetitors(String csvFilePath) throws IOException {
        List<Competitor> competitors = new CsvToBeanBuilder<Competitor>(new FileReader(csvFilePath))
            .withType(Competitor.class)
            .build()
            .parse();

        Gson gson = new Gson();
        return gson.toJson(competitors);
    }
}