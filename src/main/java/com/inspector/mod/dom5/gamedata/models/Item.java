package com.inspector.mod.dom5.gamedata.models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Item {

    private String name;
    private Integer constlevel;
    private String mainpath;
    private String mainlevel;
    private String secondarypath;
    private String secondarylevel;
    private Integer weapon;
    private Integer armor;
    private String type;
    private Map<String, String> attributes;
    private String description;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(name).append("\n");
        stringBuilder.append("constlevel: ").append(constlevel).append("\n");
        stringBuilder.append("mainpath: ").append(mainpath).append("\n");
        stringBuilder.append("mainlevel: ").append(mainlevel).append("\n");
        stringBuilder.append("secondarypath: ").append(secondarypath).append("\n");
        stringBuilder.append("secondarylevel: ").append(secondarylevel).append("\n");
        stringBuilder.append("weapon: ").append(weapon).append("\n");
        stringBuilder.append("armor: ").append(armor).append("\n");
        stringBuilder.append("type: ").append(type).append("\n");
        stringBuilder.append("description: ").append(description).append("\n");
        attributes.forEach((s, s2) -> stringBuilder.append("\t").append(s).append(": ").append(s2).append("\n"));
        return stringBuilder.toString();
    }
}
