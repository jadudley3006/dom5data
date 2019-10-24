package com.inspector.mod.dom5.gamedata.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Weapons {

    private List<Weapon> weapons;

}
