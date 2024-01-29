package tiie.minecraftcore;

import org.bukkit.plugin.java.JavaPlugin;
import tiie.minecraftcore.Commands.SetMessage;
import tiie.minecraftcore.Interface.FileAbstractMaker;
import tiie.minecraftcore.Listeners.BuildModeListeners;
import tiie.minecraftcore.Listeners.TestJoinListener;
import tiie.minecraftcore.Managers.CommandManager;
import tiie.minecraftcore.Managers.FreezeManager;
import tiie.minecraftcore.Managers.KitManager;
import tiie.minecraftcore.Managers.ListenersManager;

public final class MinecraftCore extends JavaPlugin {

    private static MinecraftCore instance;

    private KitManager kitManager;

    ListenersManager listenersManager;
    CommandManager commandManager;
    FreezeManager freezeManager;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;





        kitManager = new KitManager();
        kitManager.loadKitsFromConfig();


        listenersManager = new ListenersManager();
        listenersManager.registerListeners();

        commandManager = new CommandManager();
        commandManager.registerCommands();

      //  getServer().getPluginManager().registerEvents(new TestJoinListener(), this);
      //  getCommand("setmsg").setExecutor(new SetMessage());





    }

    public static MinecraftCore getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
