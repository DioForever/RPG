package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.CCPlayerInfo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.dioforever.rpg.Utils.color;

public class xpmultiplier implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.isOp()){
                String nick = p.getName();
                if(args.length==1){
                    CCPlayerInfo.get().set(nick+".MXP",Integer.parseInt(args[0]));
                    CCPlayerInfo.save();
                    p.sendMessage(color("&e&l(!)&r&e Your XP Multiplier changed to"+args[0]+"!"));
                }else{
                    p.sendMessage(color("&e&l(!)&r&e You didn´t specify the integer of XP Multiplier or specified more!"));
                }
            }
        }

        return true;
    }
}
