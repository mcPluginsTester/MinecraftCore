package tiie.minecraftcore.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tiie.minecraftcore.Managers.FreezeManager;
import tiie.minecraftcore.Utils.MessageUtils;

public class PunishmentHandlers {

    public static boolean kickHandler(Player player, String[] args){
        if (player.hasPermission("minecraftcore.kick")){
            if (args.length == 0){
                MessageUtils.logoIGUESS(player, "Usage: /kick <player> [reason]");
                return true;
            }
            if (args.length == 1){
                String nameOFPlayer = args[0];

                Player target = Bukkit.getPlayer(nameOFPlayer);
                if (target != null){
                    target.kickPlayer(ChatColor.RED + "You have been kicked from the server");
                    return true;

                }else {
                    MessageUtils.playerUnknown(player);
                }

            }
            if (args.length < 3){


                String nameOFPlayer = args[0];

                Player target = Bukkit.getPlayer(nameOFPlayer);
                if (target != null){
                    String reason = args[1];

                    target.kickPlayer(ChatColor.RED + "You have been kicked: " + reason);
                    return true;

                }else {
                    MessageUtils.playerUnknown(player);
                }
            }
        }else {
            MessageUtils.needPermMessage(player);
        }
        return false;
    }

    public static boolean onBanhandler(Player player, String[] args){
        if (player.hasPermission("minecraftcore.ban")){
            if (args.length == 0){
                MessageUtils.logoIGUESS(player, "Usage: /ban <player> [reason]");
                return true;
            }
            if (args.length == 1){
                String nameOFPlayer = args[0];

                Player target = Bukkit.getPlayer(nameOFPlayer);

                if (target != null){

                    Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(), "You have been banned" +
                            " from the server.", null, "TEST");


                    return true;
            }

        }
    }
        return false;

    }

    public static boolean  freezeHandler(Player player, Player target, String[] args){
        if (player.hasPermission("minecraftcore.freeze")){
            if (args.length == 0){
                MessageUtils.logoIGUESS(player, "Usage: /freeze <player>");
                return true;
            }

            if (player.equals(target)){
                MessageUtils.logoIGUESS(player, "you can't freeze yourself");
                return true;
            }

            if (target != null ){
                if (!FreezeManager.isStillFrozen(target)){
                    FreezeManager.addPlayerToBeFrozen(target, player);
                }else {
                    FreezeManager.removePlayerToBeFrozen(target, player);
                }

            }else {
                MessageUtils.playerUnknown(player);
            }
        }
        return false;
    }
}
