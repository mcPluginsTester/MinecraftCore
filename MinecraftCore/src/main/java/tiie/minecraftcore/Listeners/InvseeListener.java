package tiie.minecraftcore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;

public class InvseeListener implements Listener {

    @EventHandler
    public void onInvsee(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (!player.hasPermission("minecraftcore.bypassinvsee")){
            if (event.getClickedInventory() != null){
                Inventory clickedInventory = event.getClickedInventory();

                // Check if the clicked inventory is the player's inventory
                if (clickedInventory.equals(event.getView().getTopInventory()) && clickedInventory.getHolder() instanceof Player) {
                    // Allow the player to interact with their own inventory
                    return;
                }

                event.setCancelled(true);
            }
        }

    }
}
