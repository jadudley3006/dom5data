package com.inspector.mod.dom5.controllers;

import com.inspector.mod.dom5.gamedata.ItemService;
import com.inspector.mod.dom5.gamedata.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/", produces = "text/plain")
    String home() {
        List<Item> items = itemService.getItems();
        return items.stream().map(item -> item.toString() + "\n").collect(Collectors.joining());
    }
}
