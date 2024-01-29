package tiie.minecraftcore.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import tiie.minecraftcore.Managers.FreezeManager;
import tiie.minecraftcore.Utils.MessageUtils;

public class PunishmentListeners implements Listener {
    @EventHandler
    public void onFrozen(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (FreezeManager.isStillFrozen(player)){
           player.sendMessage(ChatColor.RED + "You are frozen!");
            MessageUtils.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD  + "YOU ARE FROZEN");

            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDRop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if (FreezeManager.isStillFrozen(player)) {
            player.sendMessage(ChatColor.RED + "You are frozen!");
            event.setCancelled(true);
        }

    }



    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase(); // Get the command in lowercase

        // Check if the player is frozen
        if (FreezeManager.isStillFrozen(player)){
            // Cancel specific commands for frozen players
            if (command.startsWith("/home") || command.startsWith("/spawn") || command.startsWith("/tp")  ) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are frozen and cannot use this command.");
            }
        }
    }
}
