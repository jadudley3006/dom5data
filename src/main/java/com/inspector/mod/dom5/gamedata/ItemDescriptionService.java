package com.inspector.mod.dom5.gamedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class ItemDescriptionService {

    @Autowired
    private TextReader textReader;

    @PostConstruct
    public void init() {
        Map<String, String> descriptions = textReader.loadDescriptions("./src/main/resources/gamedata/itemdescr");
        descriptions.keySet().forEach(s -> System.out.println(s + " -> " + descriptions.get(s)));
    }

}
