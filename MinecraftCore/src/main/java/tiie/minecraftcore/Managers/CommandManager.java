package tiie.minecraftcore.Managers;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import tiie.minecraftcore.Commands.BasicCmd;
import tiie.minecraftcore.Commands.PunishmentCmds;
import tiie.minecraftcore.MinecraftCore;

public class CommandManager {


    //registers the commands.

    /*

    //TODO DONT FORGET TO REGISTER CMDS IN PLUGIN.YML!!!!!


     */
    public void registerCommands(){
        registerCommand("feed");
        registerCommand("fly");
        registerCommand("buildmode");
        registerCommand("walkspeed");
        registerCommand("flyspeed");
        registerCommand("kitcreate");
        registerCommand("kit");
        registerCommand("kitremove");
        registerCommand("invsee");
        registerCommand("gmc");
        registerCommand("gms");
        registerCommand("gmp");
        registerCommand("gma");
        // basic cmds stop line
        punishRegistersCommand("kick");
        punishRegistersCommand("freeze");
        punishRegistersCommand("ban");
    }

    private void registerCommand(String commandName) {
        PluginCommand command = MinecraftCore.getInstance().getCommand(commandName);
        PluginCommand command2 = MinecraftCore.getInstance().getCommand(commandName);

        if (command != null) {
            command.setExecutor(new BasicCmd());
        } else {
            MinecraftCore.getInstance().getLogger().warning("Failed to register command: " + commandName);
        }

    }

    private void punishRegistersCommand(String commandPunishName){
        PluginCommand command2 = MinecraftCore.getInstance().getCommand(commandPunishName);

        if (command2 != null) {
            command2.setExecutor(new PunishmentCmds());
        } else {
            MinecraftCore.getInstance().getLogger().warning("Failed to register command: " + commandPunishName);
        }
    }
}
