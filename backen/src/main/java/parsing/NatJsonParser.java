package parsing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.NatModel;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NatJsonParser {

    public static List<NatModel> parseFile(String path) {
        Gson gson = new Gson();
        List<NatModel> natModels = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(path))){

            // Convert the JSON file to a List of Maps
            List<Map<String, Object>> list = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());

            // Print the list
            for (Map<String, Object> map : list) {
                NatModel natModel = new NatModel();
                natModel.setHour((String) map.get("HOUR"));
                natModel.setRound((String) map.get("ROUND"));
                natModel.setSport((String) map.get("SPORT"));
                natModel.setName((String) map.get("NAME"));
                natModel.setSex((String) map.get("SEX"));
                natModel.setNat((String) map.get("NAT."));

                Object place = map.get("PLACE");
                if (place != null) {
                    natModel.setPlace(place.toString());
                }

                Object mark = map.get("MARK");
                if (mark != null) {
                    try {
                      Double value = Double.valueOf((String) mark);
                      natModel.setMark(value);
                    } catch (NumberFormatException ex) {
                      ex.printStackTrace();
                    }
                }
                String comments = (String) map.get("COMMENTS");
                if (comments != null) {
                    natModel.setComments(comments);
                }
                natModels.add(natModel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return natModels;
    }

}
