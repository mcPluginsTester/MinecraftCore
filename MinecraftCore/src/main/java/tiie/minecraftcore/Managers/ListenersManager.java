package tiie.minecraftcore.Managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import tiie.minecraftcore.Listeners.BuildModeListeners;
import tiie.minecraftcore.Listeners.InvseeListener;
import tiie.minecraftcore.Listeners.PunishmentListeners;
import tiie.minecraftcore.MinecraftCore;

public class ListenersManager {



    public void registerListeners(){
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new BuildModeListeners(), MinecraftCore.getInstance());
        pluginManager.registerEvents(new InvseeListener(), MinecraftCore.getInstance());
        pluginManager.registerEvents(new PunishmentListeners(), MinecraftCore.getInstance());
    }
}
