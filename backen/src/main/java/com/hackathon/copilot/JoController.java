package com.hackathon.copilot;

import model.NatModel;
import model.ResultatNat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.NatResultatServiceImpl;

import java.io.IOException;
import java.util.List;

import static parsing.CSVToJsonConverter.mapToNat;

@SpringBootApplication
@RestController
public class JoController {

    // add rest ressource to expose array of json competitor
    @GetMapping("/resultat")
    public ResultatNat getCompetitors() throws IOException {
        String path3 = "backen/src/main/resources/J1/Nat_D1.csv";
        List<NatModel> natModels = mapToNat(path3);
        return new NatResultatServiceImpl().calculateResultat(natModels);
    }


}
