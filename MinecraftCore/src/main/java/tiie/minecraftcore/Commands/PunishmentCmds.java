package tiie.minecraftcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tiie.minecraftcore.Handlers.PunishmentHandlers;
import tiie.minecraftcore.Managers.CommandManager;

public class PunishmentCmds implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("kick")){
                PunishmentHandlers.kickHandler(player, args);
                return true;
            } else if (command.getName().equalsIgnoreCase("freeze")) {
                if (args.length == 1){
                    String name = args[0];
                    Player  target = Bukkit.getPlayer(name);
                    PunishmentHandlers.freezeHandler(player, target, args);
                    return true;
                }

            } else if (command.getName().equalsIgnoreCase("ban")) {
                PunishmentHandlers.onBanhandler(player, args);

            }
        }
        return false;
    }
}
