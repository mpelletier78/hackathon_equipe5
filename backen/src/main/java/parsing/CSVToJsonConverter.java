package parsing;

import com.google.gson.Gson;
import model.Athlete;
import model.NatModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToJsonConverter {

    public String convertAthletes(String csvFilePath) throws IOException {
        List<Athlete> athletes = mapHistoricToAthletes(csvFilePath);
        Gson gson = new Gson();
        return gson.toJson(athletes);
    }

    public static List<Athlete> mapHistoricToAthletes(String csvFilePath) throws IOException {
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
                athlete.setPosition(Double.valueOf(values[5]));
                athlete.setTemps(values[6]);
                if (values.length > 7) {
                    athlete.setNote(values[7]);
                }
                athletes.add(athlete);
            }
        }
        return athletes;
    }

    public List<NatModel> mapToNat(String csvFilePath) throws IOException {
        List<NatModel> natList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String line = reader.readLine(); // header;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                NatModel nat = new NatModel();
                nat.setHour(values[1]);
                nat.setRound(values[2]);
                nat.setSport(values[3]);
                nat.setName(values[4]);
                nat.setSex(values[5]);
                nat.setNat(values[6]);
                nat.setPlace(values[7]);
                nat.setMark(Double.valueOf(values[8]));
                if (values.length > 9) {
                    nat.setComments(values[9]);
                }
                natList.add(nat);
            }
        }
        return natList;
    }


}