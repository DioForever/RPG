package me.dioforever.rpg.commands;

import me.dioforever.rpg.files.CCPlayerInfo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.dioforever.rpg.Utils.color;

public class levelBarCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            String nick = p.getName();

            if(CCPlayerInfo.get().getBoolean(nick+".LevelBars")==true){
                CCPlayerInfo.get().set(nick+".LevelBars",false);
                p.sendMessage(color("&e&l(!)&r&e Your XP/PRF Bars will not show up from now on!"));
            }else{
                CCPlayerInfo.get().set(nick+".LevelBars",true);
                p.sendMessage(color("&e&l(!)&r&e Your XP/PRF Bars will show up again from now on!"));
            }
            CCPlayerInfo.save();
        }


        return true;
    }
}
