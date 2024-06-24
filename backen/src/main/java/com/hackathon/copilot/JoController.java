package com.hackathon.copilot;

import model.NatModel;
import model.ResultatNat;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import parsing.NatJsonParser;
import service.NatResultatServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static parsing.CSVToJsonConverter.mapCsvToNat;

@SpringBootApplication
@RestController
public class JoController {

    // add rest ressource to expose array of json competitor
    @GetMapping("/resultat")
    public ResultatNat getResultat() throws IOException {
        String path3 = "backen/src/main/resources/J1/Nat_D1.csv";
        List<NatModel> natModels = mapCsvToNat(path3);
        return new NatResultatServiceImpl().calculateResultat(natModels);
    }

    @GetMapping("/resultat-par-jour/{jour}")
    public ResultatNat getResultatParJour(@PathVariable("jour") String jour) throws IOException {
        List<NatModel> natModels = getNatModels(jour);
        return new NatResultatServiceImpl().calculateResultat(natModels);
    }

    private static List<NatModel> getNatModels(String jour) throws IOException {
        String day = switch (jour) {
            case "J1" -> "D1";
            case "J2" -> "D2";
            case "J3" -> "D3";
            default -> "Invalid input";
        };
        String path = pickPath(jour, day);
        return isCsv(path) ? mapCsvToNat(path) : NatJsonParser.parseFile(path);
    }

    private static String pickPath(String jour, String day) {
        String path = String.format("backen/src/main/resources/%s/Nat_%s.csv", jour, day);
        File file = new File(path);
        if (!file.exists()) {
            return String.format("backen/src/main/resources/%s/Nat_%s.json", jour, day);
        }
        return path;
    }

    private static boolean isCsv(String filePath) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
        return extension.equals("csv");
    }

}
