package com.inspector.mod.dom5.gamedata.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Items {

    private List<Item> items;
}
