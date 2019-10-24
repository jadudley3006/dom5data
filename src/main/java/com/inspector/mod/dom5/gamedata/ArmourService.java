package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.gamedata.models.Armour;
import com.inspector.mod.dom5.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.inspector.mod.dom5.gamedata.GameData.ARMORS_CSV;
import static com.inspector.mod.dom5.util.CsvReader.getKeyValuePairs;

@Service
public class ArmourService {

    private List<Armour> armours = new ArrayList<>();

    @Autowired
    private CsvReader csvReader;

    @PostConstruct
    public void init() {
        List<String[]> raw_armours = csvReader.processInputFile(ARMORS_CSV);
        String[] armour_headers = raw_armours.get(0);
        raw_armours.stream().skip(1).forEach(element -> processArmours(armour_headers, element));
    }

    public List<Armour> getArmours() {
        return armours;
    }

    private void processArmours(String[] headers, String[] element) {
        Map<String, String> attributes = getKeyValuePairs(headers, element);

        Armour armour = Armour.builder()
                .id(Integer.parseInt(attributes.get("id")))
                .name(attributes.get("name"))
                .type(Integer.parseInt(attributes.get("type")))
                .def(Integer.parseInt(attributes.get("def")))
                .enc(Integer.parseInt(attributes.get("enc")))
                .rcost(Integer.parseInt(attributes.get("rcost")))
                .build();

        armours.add(armour);
    }

}
