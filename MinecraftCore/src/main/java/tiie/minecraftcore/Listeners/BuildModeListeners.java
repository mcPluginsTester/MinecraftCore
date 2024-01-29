package tiie.minecraftcore.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import tiie.minecraftcore.Managers.BuildModeManager;
import tiie.minecraftcore.Utils.MessageUtils;

public class BuildModeListeners implements Listener {


    @EventHandler
    public void onPlaceBuildMode(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (BuildModeManager.getPlayersInBuildMode().contains(player)){
            event.setCancelled(true);
            MessageUtils.logoIGUESS(player, "you are In buildmode");
        }
    }

    @EventHandler
    public void onBreakBuildMode(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (BuildModeManager.getPlayersInBuildMode().contains(player)){
            event.setCancelled(true);
            MessageUtils.logoIGUESS(player, "you are In buildmode");
        }
    }

    @EventHandler
    public void onSpawnEgg(PlayerEggThrowEvent event){
        Player player = event.getPlayer();
        if (BuildModeManager.getPlayersInBuildMode().contains(player)){
            event.setHatching(false);
            MessageUtils.logoIGUESS(player, "you are In buildmode");
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the player right-clicked with a spawner egg
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.SPAWNER) {
            // Your logic here...

            // Cancel the event to prevent normal spawner behavior
            event.setCancelled(true);
            MessageUtils.logoIGUESS(player, "you are In buildmode");

        }
    }

}
