package com.inspector.mod.dom5.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "WEAPON")
@NoArgsConstructor
@AllArgsConstructor
public class WeaponEntity {

    @Id
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
