package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.Customs.Outposts.OutpostGeneration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnStructer implements CommandExecutor {
    public static OutpostGeneration outpostGeneration;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(sender.isOp()){
                OutpostGeneration.spawnStructer(((Player) sender).getLocation());
            }
        }
        return true;
    }
}
