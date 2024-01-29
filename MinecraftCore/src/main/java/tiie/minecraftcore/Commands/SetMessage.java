package tiie.minecraftcore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tiie.minecraftcore.Interface.FileAbstractMaker;

public class SetMessage extends FileAbstractMaker implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.sendMessage("Usage: /setmsg <msg>");
                return true;
            }

            if (args[0].equalsIgnoreCase("fileAdd")){
                if (args.length  == 2){
                    String setMsg = args[1];

                    fileCreate("message",setMsg);

                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("addData")){
                if (args.length < 4){
                    String setMsg = args[1];
                    String welcomeMEsage = args[2];
                    settingValueForFile("message", "test", "message.dez", welcomeMEsage);
                    player.sendMessage("set message to " + welcomeMEsage + "Extra Info: file "+ setMsg);

                }
            }




            if (args[0].equalsIgnoreCase("reload")){
                loadFile("message", "test.yml");
                player.sendMessage("reloaded file test.yml");
            }


        }
        return false;
    }
}
