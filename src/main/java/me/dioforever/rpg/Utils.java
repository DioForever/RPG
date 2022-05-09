package me.dioforever.rpg;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Utils {
    public static List<String> monsters = new ArrayList<>();

    private static Logger logger = Main.getPluginLogger();

    public static  String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String decolor(String text){
        return ChatColor.stripColor(text);
    }

    public static String recolor(String text){
        return text.replace(ChatColor.COLOR_CHAR,'&');
    }

    public static void log(String... messages){
        for(String message : messages){
            logger.info(message);
        }
    }
    public static void warn(String... messages){
        for(String message : messages){
            logger.warning(message);
        }
    }
    public static void error(String... messages){
        for(String message : messages){
            logger.severe(message);
        }
    }

    public static void dealDamage(Entity damager, Entity victim, Double damage, String cause){
        if(victim instanceof Player){
            //Check his stats and his skills
        }
        if(victim.getCustomName()!=null){
            if(monsters.contains(victim.getCustomName())){
                //Is one of the monsters
            }

        }

    }
}