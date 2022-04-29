package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.*;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        CCStats.reload();
        CCSkills.reload();
        CCMagic.reload();
        CCPlayerInfo.reload();

        return true;
    }
}
