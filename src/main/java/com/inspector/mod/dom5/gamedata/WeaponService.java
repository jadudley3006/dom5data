package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.gamedata.models.Weapon;
import com.inspector.mod.dom5.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.inspector.mod.dom5.gamedata.GameData.WEAPONS_CSV;
import static com.inspector.mod.dom5.util.CsvReader.getKeyValuePairs;

@Service
public class WeaponService {

    private List<Weapon> weapons = new ArrayList<>();

    @Autowired
    private CsvReader csvReader;

    @PostConstruct
    public void init() {
        List<String[]> raw_weapons = csvReader.processInputFile(WEAPONS_CSV);
        String[] weapon_headers = raw_weapons.get(0);
        raw_weapons.stream().skip(1).forEach(element -> processWeapon(weapon_headers, element));
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    private void processWeapon(String[] headers, String[] element) {
        Map<String, String> attributes = getKeyValuePairs(headers, element);

        Weapon weapon = Weapon.builder()
                .id(Integer.parseInt(attributes.get("id")))
                .name(attributes.get("name"))
                .att(Integer.parseInt(attributes.get("att")))
                .def(Integer.parseInt(attributes.get("def")))
                .ammo(Integer.parseInt(attributes.get("ammo")))
                .effect_record_id(Integer.parseInt(attributes.get("effect_record_id")))
                .len(Integer.parseInt(attributes.get("len")))
                .nratt(Integer.parseInt(attributes.get("nratt")))
                .rcost(Integer.parseInt(attributes.get("rcost")))
                .secondaryeffect(Integer.parseInt(attributes.get("secondaryeffect")))
                .secondaryeffectalways(Integer.parseInt(attributes.get("secondaryeffectalways")))
                .build();

        weapons.add(weapon);
    }
}
