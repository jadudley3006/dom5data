package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.List;

import static com.inspector.mod.dom5.gamedata.GameData.*;

@Service
public class ItemProcessor {

    @Autowired
    private CsvReader csvReader;

    @PostConstruct
    public void process() {

        List<String[]> baseItems = csvReader.processInputFile(BASE_I_CSV);
        List<String[]> armor = csvReader.processInputFile(ARMORS_CSV);
        List<String[]> weapon = csvReader.processInputFile(WEAPONS_CSV);


    }

}
