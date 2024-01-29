package tiie.minecraftcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tiie.minecraftcore.Handlers.BasicCmd_Handlers;
import tiie.minecraftcore.Managers.BuildModeManager;
import tiie.minecraftcore.Managers.KitManager;

public class BasicCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


            if (command.getName().equalsIgnoreCase("feed")) {
                BasicCmd_Handlers.feedHandler(player);
                return true;
            } else if (command.getName().equalsIgnoreCase("fly")) {
                BasicCmd_Handlers.flyHandler(player);
            }else if (command.getName().equalsIgnoreCase("buildmode")) {
                BuildModeManager.buildMode(player);
                return true;
            }else if (command.getName().equalsIgnoreCase("flyspeed")){
                BasicCmd_Handlers.flySpeed_walkSpeed(player, true, args);
                return true;
            }else if (command.getName().equalsIgnoreCase("walkspeed")){
                BasicCmd_Handlers.flySpeed_walkSpeed(player, false, args);
                return true;
            }else if (command.getName().equalsIgnoreCase("kitcreate")){
                BasicCmd_Handlers.kitcreateHandler(player, args);
                return true;
            } else if (command.getName().equalsIgnoreCase("kit")) {
                BasicCmd_Handlers.kitGiveHandler(player, args);
                return true;
            } else if (command.getName().equalsIgnoreCase("kitremove")) {
                BasicCmd_Handlers.kitremove(player, args);
                return true;
            }else if (command.getName().equalsIgnoreCase("invsee")){
                BasicCmd_Handlers.invseeHandler(player, args);
                return true;
            }else if (command.getName().equalsIgnoreCase("gmc")){
                BasicCmd_Handlers.shortGMSelect(player, "gmc", GameMode.CREATIVE, ChatColor.AQUA, "creativ" +
                        "e");
                return true;
            }else if (command.getName().equalsIgnoreCase("gms")){
                BasicCmd_Handlers.shortGMSelect(player, "g" +
                        "ms", GameMode.SURVIVAL, ChatColor.RED, "survival");
                return true;

            }else if (command.getName().equalsIgnoreCase("gmp")){
                BasicCmd_Handlers.shortGMSelect(player, "gm" +
                        "p", GameMode.SPECTATOR, ChatColor.GOLD, "specatator");
                return true;


            } else if (command.getName().equalsIgnoreCase("gma")) {
                BasicCmd_Handlers.shortGMSelect(player, "gma", GameMode.ADVENTURE, ChatColor.GREEN, "adventure");

            }


        }
        return false;

    }
}
