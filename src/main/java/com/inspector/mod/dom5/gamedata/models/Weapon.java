package com.inspector.mod.dom5.gamedata.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weapon {

    private int id;
    private String name;
    private int effect_record_id;
    private int att;
    private int def;
    private int len;
    private int nratt;
    private int ammo;
    private int secondaryeffect;
    private int secondaryeffectalways;
    private int rcost;

}
