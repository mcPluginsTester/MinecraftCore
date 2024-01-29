package tiie.minecraftcore.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tiie.minecraftcore.Managers.BuildModeManager;
import tiie.minecraftcore.Managers.KitManager;
import tiie.minecraftcore.Utils.MessageUtils;

import java.io.IOException;

public class BasicCmd_Handlers {


    //basic command logic

    public static void feedHandler(Player player){
        if (player.hasPermission("minecraftcore.feed")){
            player.setFoodLevel(20);
            MessageUtils.logoIGUESS(player, "successfully been fed");
        }else {
            MessageUtils.needPermMessage(player);
        }
    }

    public static void flyHandler(Player player){
        if (player.hasPermission("minecraftcore.fly")){

            if (!player.isFlying()){
                player.setAllowFlight(true);
                MessageUtils.logoIGUESS(player, "flight Is set: " + ChatColor.GREEN + "on");
            }else {
                player.setAllowFlight(false);
                MessageUtils.logoIGUESS(player, "flight Is set: " + ChatColor.RED + "off");
            }
        }else {
            MessageUtils.needPermMessage(player);
        }
    }
    public static void flySpeed_walkSpeed(Player player, boolean trueForFlySpeed, String[] args){

        if (trueForFlySpeed){
            if (player.hasPermission("minecraftcore.flyspeed")){
                int num = Integer.parseInt(args[0]);

                try {
                    if (num >= 1 && num <= 5){
                        float flySpeed = num / 10.0f;
                        player.setFlySpeed(flySpeed);
                        MessageUtils.logoIGUESS(player, "flyspeed set: " + num);


                    }else {
                        MessageUtils.mustBetweenMsg(player, 1, 5);
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }else {
                MessageUtils.needPermMessage(player);

            }
        }else {
            if (player.hasPermission("minecraftcore.walkspeed")){
                int num = Integer.parseInt(args[0]);

                try {
                    if (num >= 1 && num <= 5){
                        float walkspeed = num /10.0f;
                        player.setWalkSpeed(walkspeed);
                        MessageUtils.logoIGUESS(player, "walkspeed set: " + num);
                    }else {
                        MessageUtils.mustBetweenMsg(player, 1, 5);
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }else {
                MessageUtils.needPermMessage(player);

            }
        }
    }

    public static void kitcreateHandler(Player player, String[] args){
        if (player.hasPermission("minecraftcore.kitcreate")){
            if (args.length >= 1){
                String kitName= args[0];
                ItemStack[] invItems = player.getInventory().getContents();
                KitManager.kitcreate(kitName, invItems);
                MessageUtils.logoIGUESS(player, "successfully made " + kitName);
            }
        }else {
            MessageUtils.needPermMessage(player);

        }
    }

    public static void kitGiveHandler(Player player, String[] args){
        if (player.hasPermission("minecraftcore.kit")){
            if (args.length >= 1){
                String kitExists = args[0];
                KitManager.giveKit(player, kitExists);
            }
        }else {
            MessageUtils.needPermMessage(player);

        }
    }
    public static void kitremove(Player player, String[] args){
        if (player.hasPermission("minecraftcore.kitremove")){
            if (args.length >= 1){
                String kitExists = args[0];
                KitManager.kitremove(kitExists);
                MessageUtils.logoIGUESS(player, "successfully removed " + kitExists);

            }
        }else {
            MessageUtils.needPermMessage(player);

        }
    }
    public static void invseeHandler(Player player, String[] args){
        if (player.hasPermission("minecraftcore.invsee")){
            if (args.length >= 1){
                String nameOfPlayer = args[0];
                Player target = Bukkit.getPlayer(nameOfPlayer);
                if (target != null){
                    Inventory targetInv = Bukkit.createInventory(null, InventoryType.PLAYER, nameOfPlayer + "'s Inventory");
                    targetInv.setContents(target.getInventory().getContents());
                    MessageUtils.logoIGUESS(player, "currently spec inv " + nameOfPlayer);
                    player.openInventory(targetInv);
                }else {
                    MessageUtils.playerUnknown(player);
                }

            }else {
                MessageUtils.logoIGUESS(player, "Usage: /invsee <player>");
            }
        }else {
            MessageUtils.needPermMessage(player);

        }
    }
    public static void shortGMSelect(Player player,String perm, GameMode gameMode, ChatColor color, String msg){
        if (player.hasPermission("minecraftcore." + perm)){
            player.setGameMode(gameMode);
            MessageUtils.logoIGUESS(player, "you have been set to: " + color + msg);
        }else {
            MessageUtils.needPermMessage(player);

        }
    }
}
