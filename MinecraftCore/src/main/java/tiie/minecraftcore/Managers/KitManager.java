package tiie.minecraftcore.Managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tiie.minecraftcore.Utils.MessageUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KitManager {
    private static final Map<String, ItemStack[]> kits = new HashMap<>();
    private static final File configFile = new File("plugins/minecraftcore/kits.yml");

    public static   void kitcreate(String kitName, ItemStack[] invItems){

        kits.put(kitName.toLowerCase(), invItems.clone());
        saveKitsToConfig();
    }
    public static void kitremove(String kitName){
        if (kits.containsKey(kitName)){
            kits.remove(kitName);
            saveKitsToConfig();
        }

    }

    public static   void giveKit(Player player, String kitname){
        kitname = kitname.toLowerCase();

        if (kits.containsKey(kitname)){

            ItemStack[] itemKits = kits.get(kitname);

            player.getInventory().setContents(itemKits);
            MessageUtils.logoIGUESS(player, "you have been given: " + kitname);
        }else {
            MessageUtils.logoIGUESS(player, "this kit " + kitname + " doesn't exist");
        }
    }

    private static void saveKitsToConfig() {
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        for (Map.Entry<String, ItemStack[]> entry : kits.entrySet()) {
            config.set("kits." + entry.getKey(), entry.getValue());
        }

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static   void loadKitsFromConfig() {
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        if (config.contains("kits")) {
            kits.clear();
            for (String kitName : config.getConfigurationSection("kits").getKeys(false)) {
                ItemStack[] kitItems = ((List<ItemStack>) config.getList("kits." + kitName)).toArray(new ItemStack[0]);
                kits.put(kitName, kitItems);
            }
        }
    }
}
