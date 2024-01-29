package tiie.minecraftcore.Utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageUtils {

    public static void logoIGUESS(Player player, String msg){
        player.sendMessage(ChatColor.GOLD + "[!] " + ChatColor.GRAY + msg);
    }

    public static void needPermMessage(Player player){
        player.sendMessage(ChatColor.RED + "[!] Lack permission");
    }

    public static void mustBetweenMsg(Player player, int num1, int num2){
        player.sendMessage(ChatColor.RED + "[!] Number must between " + num1 + " and " + num2);
    }

    public static void playerUnknown(Player player){
        player.sendMessage(ChatColor.RED + "[!] Invalid player or offline player");
    }

    public static void sendActionBar(Player player, String message) {
        TextComponent textComponent = new TextComponent(message);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, textComponent);
    }
}

