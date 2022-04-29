package me.dioforever.rpg.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static me.dioforever.rpg.Utils.color;

public class SummonCmd implements CommandExecutor {
    List<Player> summoned = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!summoned.contains(p)) {
                Wolf Seth = p.getWorld().spawn(p.getLocation(), Wolf.class);
                Seth.setCustomName(color("&6&lSeth - Egyptian God Owned: " + p.getName()));
                Seth.setTamed(true);
                Seth.setOwner(p);
                Seth.setMaxHealth(160);
                Seth.setHealth(160);

                Seth.setCustomNameVisible(true);
                summoned.add(p);
                return true;
            }
            World world = p.getWorld();
            for (Entity Seth : world.getEntities()) {
                if (Seth.getName().equalsIgnoreCase(color("&6&lSeth - Egyptian God Owned: " + p.getName()))) {
                    Seth.remove();
                    summoned.remove(p);

                }


            }

            return true;
        }
    return true;
    }
}
