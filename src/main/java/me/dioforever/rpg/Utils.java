package me.dioforever.rpg;

import org.bukkit.ChatColor;

import java.util.logging.Logger;

public class Utils {

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
}