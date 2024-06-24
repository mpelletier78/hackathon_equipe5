package parsing;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Athlete;
import model.Competitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToJsonConverter {

    public String convertAthletes(String csvFilePath) throws IOException {
        List<Athlete> athletes = mapToAthletes(csvFilePath);
        Gson gson = new Gson();
        return gson.toJson(athletes);
    }

    public static List<Athlete> mapToAthletes(String csvFilePath) throws IOException {
        List<Athlete> athletes;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            athletes = new ArrayList<>();

            String line = reader.readLine(); // header;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                Athlete athlete = new Athlete();
                athlete.setAthlete(values[0]);
                athlete.setSexe(values[1]);
                athlete.setPays(values[2]);
                athlete.setDiscipline(values[3]);
                athlete.setYear(values[4]);
                athlete.setPosition(values[5]);
                athlete.setTemps(values[6]);
                if (values.length > 7) {
                    athlete.setNote(values[7]);
                }
                athletes.add(athlete);
            }
        }
        return athletes;
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