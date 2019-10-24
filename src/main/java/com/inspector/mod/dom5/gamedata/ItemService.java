package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.repositories.*;
import com.inspector.mod.dom5.gamedata.models.Item;
import com.inspector.mod.dom5.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

import static com.inspector.mod.dom5.gamedata.GameData.BASE_I_CSV;
import static com.inspector.mod.dom5.gamedata.GameData.WEAPONS_CSV;
import static com.inspector.mod.dom5.util.CsvReader.getKeyValuePairs;

@Service
public class ItemService {

    private List<Item> items = new ArrayList<>();

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CONSTLEVEL = "constlevel";
    private static final String MAINPATH = "mainpath";
    private static final String MAINLEVEL = "mainlevel";
    private static final String SECONDARYPATH = "secondarypath";
    private static final String SECONDARYLEVEL = "secondarylevel";
    private static final String WEAPON = "weapon";
    private static final String ARMOR = "armor";
    private static final String TYPE = "type";
    private static final List<String> PRIMARY_ATTRIBUTES = Arrays.asList(ID, NAME, CONSTLEVEL, MAINPATH, MAINLEVEL, SECONDARYPATH, SECONDARYLEVEL, WEAPON, ARMOR, TYPE);

//    @Autowired
//    private ItemRepository itemRepository;
//
//    @Autowired
//    private ItemAttributeRepository itemAttributeRepository;
//
//    @Autowired
//    private WeaponRepository weaponRepository;

    @Autowired
    private ItemDescriptionService itemDescriptionService;

    @Autowired
    private CsvReader csvReader;

    @PostConstruct
    public void init() {
        List<String[]> raw_items = csvReader.processInputFile(BASE_I_CSV);
        String[] headers = raw_items.get(0);
        raw_items.stream().skip(1).forEach(element -> processItem(headers, element));

//        List<String[]> raw_weapons = csvReader.processInputFile(WEAPONS_CSV);
//        String[] weapon_headers = raw_weapons.get(0);
//        raw_weapons.stream().skip(1).forEach(element -> processWeapon(weapon_headers, element));
    }

    public List<Item> getItems() {
        return items;
    }

    private void processItem(String[] headers, String[] element) {
        Map<String, String> attributes = getKeyValuePairs(headers, element);

        Item item = getItem(attributes);

        items.add(item);
    }

    private Item getItem(Map<String, String> attributes) {
        return Item.builder()
                .name(attributes.get(NAME))
                .constlevel(Integer.parseInt(attributes.get(CONSTLEVEL)))
                .mainpath(attributes.get(MAINPATH))
                .mainlevel(attributes.get(MAINLEVEL))
                .secondarypath(attributes.get(SECONDARYPATH))
                .secondarylevel(attributes.get(SECONDARYLEVEL))
                .weapon(attributes.get(WEAPON) != null ? Integer.parseInt(attributes.get(WEAPON)) : null)
                .armor(attributes.get(ARMOR) != null ? Integer.parseInt(attributes.get(ARMOR)) : null)
                .type(attributes.get(TYPE))
                .attributes(getAttributes(attributes))
                .description(itemDescriptionService.getItemDescription(attributes.get(NAME)))
                .build();
    }

    private Map<String, String> getAttributes(Map<String, String> attributes) {
        Map<String, String> additionalAttributes = new HashMap<>();
        attributes.keySet().stream()
                .filter(key -> !PRIMARY_ATTRIBUTES.contains(key))
                .forEach(key -> additionalAttributes.put(key, attributes.get(key)));
        return additionalAttributes;
    }

}
