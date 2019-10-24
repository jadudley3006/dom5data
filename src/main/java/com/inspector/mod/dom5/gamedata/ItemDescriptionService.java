package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.util.TextReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemDescriptionService {

    private Map<String, String> descriptions = new HashMap<>();

    @Autowired
    private TextReader textReader;

    @PostConstruct
    public void init() {
        descriptions = textReader.loadDescriptions("./src/main/resources/gamedata/itemdescr");
    }

    public String getItemDescription(String name) {
        String parsedName = name.replaceAll("(\\s+|')", "");
        return descriptions.get(parsedName);
    }
}
