package com.inspector.mod.dom5.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "ITEM_ATTRIBUTE")
@NoArgsConstructor
@AllArgsConstructor
public class ItemAttributeEntity {

    @Id
    @GeneratedValue
    private int id;
    private String key;
    private String value;
    private int item_Id;
}
