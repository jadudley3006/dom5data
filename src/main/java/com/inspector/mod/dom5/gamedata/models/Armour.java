package com.inspector.mod.dom5.gamedata.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Armour {

    private int id;
    private String name;
    private int type;
    private int def;
    private int enc;
    private int rcost;

}
