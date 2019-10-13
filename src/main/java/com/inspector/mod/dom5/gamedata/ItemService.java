package com.inspector.mod.dom5.gamedata;

import com.inspector.mod.dom5.repositories.ItemEntity;
import com.inspector.mod.dom5.gamedata.models.Item;
import com.inspector.mod.dom5.repositories.ItemAttributeEntity;
import com.inspector.mod.dom5.repositories.ItemAttributeRepository;
import com.inspector.mod.dom5.repositories.ItemRepository;
import com.inspector.mod.dom5.util.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.inspector.mod.dom5.gamedata.GameData.BASE_I_CSV;

@Service
public class ItemService {

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

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemAttributeRepository itemAttributeRepository;

    @Autowired
    private CsvReader csvReader;

    @PostConstruct
    public void init() {
        List<String[]> raw_items = csvReader.processInputFile(BASE_I_CSV);
        String[] headers = raw_items.get(0);
        raw_items.stream().skip(1).forEach(element -> processItem(headers, element));

        List<String[]> raw_weapons = csvReader.processInputFile(BASE_I_CSV);
        String[] weapon_headers = raw_weapons.get(0);
        raw_weapons.stream().skip(1).forEach(element -> processWeapon(weapon_headers, element));
    }

    private void processWeapon(String[] headers, String[] element) {
        Map<String, String> attributes = getAttributes(headers, element);

        String id = attributes.get("id");
        for (String key : attributes.keySet()) {

        }

    }

    public List<Item> getItems() {
        return itemRepository.findAll().stream()
                .map(this::mapToItem)
                .collect(Collectors.toList());
    }

    private Item mapToItem(ItemEntity itemEntity) {
        return Item.builder()
                .id(itemEntity.getId())
                .name(itemEntity.getName())
                .type(itemEntity.getType())
                .weapon(itemEntity.getWeapon())
                .armor(itemEntity.getArmor())
                .constlevel(itemEntity.getConstlevel())
                .mainpath(itemEntity.getMainpath())
                .mainlevel(itemEntity.getMainlevel())
                .secondarypath(itemEntity.getSecondarypath())
                .secondarylevel(itemEntity.getSecondarylevel())
                .attributes(itemEntity.getItemAttributes().stream().collect(Collectors.toMap(ItemAttributeEntity::getKey, ItemAttributeEntity::getValue)))
                .build();
    }

    private void processItem(String[] headers, String[] element) {
        Map<String, String> attributes = getAttributes(headers, element);

        ItemEntity item = getItemEntity(attributes);
        itemRepository.save(item);

        for (String key : attributes.keySet()) {
            if (!PRIMARY_ATTRIBUTES.contains(key)) {
                ItemAttributeEntity itemAttributeEntity = getItemAttributeEntity(attributes, item, key);
                itemAttributeRepository.save(itemAttributeEntity);
            }
        }
    }

    private ItemAttributeEntity getItemAttributeEntity(Map<String, String> attributes, ItemEntity item, String key) {
        return ItemAttributeEntity.builder()
                .item_Id(item.getId())
                .key(key)
                .value(attributes.get(key)).build();
    }

    private Map<String, String> getAttributes(String[] headers, String[] element) {
        Map<String, String> attributes = new HashMap<>();
        for (int i = 0; i < element.length; i++) {
            if (element[i] != null && element[i].length() > 0) {
                attributes.put(headers[i], element[i]);
            }
        }
        return attributes;
    }

    private ItemEntity getItemEntity(Map<String, String> attributes) {
        return ItemEntity.builder()
                .name(attributes.get(NAME))
                .constlevel(Integer.parseInt(attributes.get(CONSTLEVEL)))
                .mainpath(attributes.get(MAINPATH))
                .mainlevel(attributes.get(MAINLEVEL))
                .secondarypath(attributes.get(SECONDARYPATH))
                .secondarylevel(attributes.get(SECONDARYLEVEL))
                .weapon(attributes.get(WEAPON) != null ? Integer.parseInt(attributes.get(WEAPON)) : null)
                .armor(attributes.get(ARMOR) != null ? Integer.parseInt(attributes.get(ARMOR)) : null)
                .type(attributes.get(TYPE))
                .build();
    }

}
