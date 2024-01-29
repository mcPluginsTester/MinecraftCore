package tiie.minecraftcore.Managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tiie.minecraftcore.MinecraftCore;
import tiie.minecraftcore.Utils.MessageUtils;

import java.util.ArrayList;
import java.util.List;

public class FreezeManager {




    private static final List<Player > getFrozenPlayers = new ArrayList<>();

    public static List<Player> getGetFrozenPlayers() {
        return getFrozenPlayers;
    }

    public static void addPlayerToBeFrozen(Player target, Player player){
        if (!getGetFrozenPlayers().contains(target)){
            getGetFrozenPlayers().add(target);
            MessageUtils.logoIGUESS(player, "you have frozen: " + target.getName());

        }
    }
    public static void removePlayerToBeFrozen(Player target, Player player){
        if (getGetFrozenPlayers().contains(target)){
            getGetFrozenPlayers().remove(target);
            MessageUtils.logoIGUESS(player, "you have unfrozen: " + target.getName());
            new BukkitRunnable(){

                @Override
                public void run() {
                    MessageUtils.sendActionBar(target, ChatColor.GREEN + "" + ChatColor.BOLD + "YOU" +
                            " ARE UNFROZEN");
                }
            }.runTaskLater(MinecraftCore.getInstance(), 20L );
        }
    }
    public static boolean isStillFrozen(Player target){
        return getGetFrozenPlayers().contains(target);
    }



}
