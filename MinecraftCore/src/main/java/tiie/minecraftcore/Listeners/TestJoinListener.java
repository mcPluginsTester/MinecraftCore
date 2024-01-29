package tiie.minecraftcore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tiie.minecraftcore.Interface.FileAbstractMaker;


public class TestJoinListener extends FileAbstractMaker implements Listener {



    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
       /* String welcomeMessage = (String) getConfigValue("message", "defaultMessage", "message", "test.yml");

        player.sendMessage(welcomeMessage);*/
    }

}
