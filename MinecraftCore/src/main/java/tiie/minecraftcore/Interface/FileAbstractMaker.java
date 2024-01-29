package tiie.minecraftcore.Interface;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import tiie.minecraftcore.MinecraftCore;

import java.io.File;
import java.io.IOException;

public abstract class FileAbstractMaker implements Listener {

    public void abstractJoinMsg(Player player, String name) {
        player.sendMessage("Hello " + player.getName() + " welcome to the " + name);
    }
    public void fileCreate(String folder, String nameOfFile) {
        if (!doesFileExist(folder, nameOfFile)) {
            File file = new File(MinecraftCore.getInstance().getDataFolder() + File.separator + folder, nameOfFile + ".yml");
            YamlConfiguration configuration = new YamlConfiguration();
            if (!file.exists()) {
                try {
                    // Create the file
                    file.createNewFile();
                    configuration.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



            try {
               // configuration.set("message", "Hi");
                configuration.save(file);
                System.out.println("File created: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  boolean doesFileExist(String folder, String nameOfFile){
        File file = new File(MinecraftCore.getInstance().getDataFolder() + "/" +
                "" + folder,  nameOfFile + ".yml");
        File fileLoadedData = new File(file, nameOfFile + ".yml");
        return fileLoadedData.exists();
    }

    public void settingValueForFile(String folder, String nameOfFile, String key, Object value) {
        if (doesFileExist(folder, nameOfFile)) {
            File file = new File(MinecraftCore.getInstance().getDataFolder() + File.separator + folder, nameOfFile + ".yml");

            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return;
            }

            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

            try {
                configuration.load(file);
                configuration.set(key, value);
                configuration.save(file);
                System.out.println("Value saved to config: " + key + " - " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist: " + folder + "/" + nameOfFile);
        }
    }

    public void loadFile(String folder, String nameOfFile){
        if(doesFileExist(folder, nameOfFile)){
            YamlConfiguration config = new YamlConfiguration();
            File file = new File(MinecraftCore.getInstance().getDataFolder() + "/" +
                    "" + folder,  nameOfFile + ".yml");
            File fileLoadedData = new File(file, nameOfFile);
            try {
                config.load(fileLoadedData);

            }catch (Exception e){

            }
        }

    }
    public Object getConfigValue(String key, Object defaultValue, String folder, String nameOfFile) {
        if (doesFileExist(folder, nameOfFile)){
            File file = new File(MinecraftCore.getInstance().getDataFolder() + "/" +
                    "" + folder, nameOfFile + ".yml");


            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            try {
                config.load(file);
                return config.get(key, defaultValue);
            } catch (Exception e) {
                e.printStackTrace();  // Log the exception
                return defaultValue;
            }
        }

        return defaultValue;
    }


}
