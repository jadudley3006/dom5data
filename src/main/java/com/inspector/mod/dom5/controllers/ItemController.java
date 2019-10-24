package com.inspector.mod.dom5.controllers;

import com.inspector.mod.dom5.gamedata.ArmourService;
import com.inspector.mod.dom5.gamedata.ItemDescriptionService;
import com.inspector.mod.dom5.gamedata.ItemService;
import com.inspector.mod.dom5.gamedata.WeaponService;
import com.inspector.mod.dom5.gamedata.models.Armour;
import com.inspector.mod.dom5.gamedata.models.Armours;
import com.inspector.mod.dom5.gamedata.models.Items;
import com.inspector.mod.dom5.gamedata.models.Weapons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private WeaponService weaponService;

    @Autowired
    private ArmourService armourService;

    @Autowired
    private ItemDescriptionService itemDescriptionService;

    @RequestMapping
    ResponseEntity<Items> getItems() {
        return new ResponseEntity<>(Items.builder().items(itemService.getItems()).build(), HttpStatus.OK);
    }

//    @RequestMapping(value = "/{item}/description")
//    String itemDesc(@PathParam(value = "item") String name) {
//        return itemDescriptionService.getItemDescription(name);
//    }

    @RequestMapping(value = "/weapons")
    ResponseEntity<Weapons> getWeapons() {
        return new ResponseEntity<>(Weapons.builder().weapons(weaponService.getWeapons()).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/armours")
    ResponseEntity<Armours> getArmour() {
        return new ResponseEntity<>(Armours.builder().armours(armourService.getArmours()).build(), HttpStatus.OK);
    }
}
