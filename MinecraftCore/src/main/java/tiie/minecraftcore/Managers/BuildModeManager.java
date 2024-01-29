package tiie.minecraftcore.Managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tiie.minecraftcore.Utils.MessageUtils;

import java.util.ArrayList;
import java.util.List;

public class BuildModeManager {



    private static List<Player> playersInBuildMode = new ArrayList<>();

    public static void buildMode(Player player){

        if (player.hasPermission("minecraftcore.buildmode")){
            if (!playersInBuildMode.contains(player)){
                playersInBuildMode.add(player);
                MessageUtils.logoIGUESS(player, "buildmode: " + ChatColor.GREEN + "ON");
            }else {
                playersInBuildMode.remove(player);
                MessageUtils.logoIGUESS(player, "buildmode: " + ChatColor.RED + "OFF");

            }
        }
    }



    public static List<Player> getPlayersInBuildMode() {
        return playersInBuildMode;
    }

}
