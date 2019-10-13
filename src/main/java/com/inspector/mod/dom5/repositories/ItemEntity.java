package com.inspector.mod.dom5.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "ITEM")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String mainpath;
    private String mainlevel;
    private String secondarypath;
    private String secondarylevel;
    private String type;
    private Integer weapon;
    private Integer armor;
    private Integer constlevel;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "ID", name = "ITEM_ID")
    private Set<ItemAttributeEntity> itemAttributes;

}
