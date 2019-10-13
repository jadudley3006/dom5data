package com.inspector.mod.dom5.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "WEAPON")
@NoArgsConstructor
@AllArgsConstructor
public class WeaponEntity {



}
