package me.dioforever.rpg;

import me.dioforever.rpg.files.CCLeft;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.HashMap;
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
    //Causes:
    /*
    fire
    ice
    lightning
    earth  (physical resistance)
    metal (physical resistance)
    water
    wind
    void -> no resistance works against it
    divine -> no resistance works
     */

    public static void damagePlayer(Entity damager, Player victim, int damage, String cause){
            //Check his stats and his skills
            String nick = victim.getName();
            double resistance = getFireResistance(victim);
            double damageFinal = damage-resistance;
            victim.damage(0.5);
            if(damage-resistance<=0)damageFinal=0;
            if(victim.isDead())return;
            int HP = CCLeft.get().getInt(nick+".HP");
            CCLeft.get().set(nick+".HP",HP-damageFinal);
            int HPNew = CCLeft.get().getInt(nick+".HP");
            if(HPNew/5<=0)victim.setHealth(0);
            else victim.setHealth(HPNew/5);


    }
    public static void damageEntity(Entity damager, Entity victim, int damage, String cause){
        if(victim.getCustomName()!=null){
            if(monsters.contains(victim.getCustomName())){

            }

        }

    }

    public static double getFireResistance(Entity entity){
        double resistance = 1;
        //get skills
        List skills = new ArrayList<>();
        if(entity instanceof Player){
            if(CCSkills.get()!=null){
                Player p = (Player) entity;
                String nick = p.getName();
                if(CCSkills.get().getList(nick+".Skills.Name")!=null){
                    skills =CCSkills.get().getList(nick+".Skills.Name");
                    HashMap<String,Integer> skillsEffects = recognizeSkills(skills);
                    double fireResistance = skillsEffects.get("fireResistance");
                    resistance = fireResistance;
                }
            }
        }else{
            //Its a monster


        }




        //get armor - LATER




        return resistance;
    }
    public static double getIceResistance(Entity entity){
        double resistance = 1;
        return resistance;
    }
    public static double getSkills(Entity entity){
        double resistance = 1;
        return resistance;
    }
    public static double getLightningResistance(Entity entity){
        double resistance = 1;
        return resistance;
    }
    public static double getPhysicalResistance(Entity entity){
        double resistance = 1;
        return resistance;
    }

    public static HashMap recognizeSkills(List<String> skills){
        HashMap skillsEffects = new HashMap<String, Integer>();
        double physicalDef = 0;
        double iceResistance = 0;
        double fireResistance = 0;
        double lightingResistance = 0;
        for (String skill:skills
             ) {
            switch (skill){
                default:

                    break;
            }
        }

        skillsEffects.put("physicalResistance",physicalDef);
        skillsEffects.put("iceResistance",iceResistance);
        skillsEffects.put("fireResistance",fireResistance);
        skillsEffects.put("lightningResistance",lightingResistance);
        skillsEffects.put("curseResistance",0);

        return skillsEffects;
    }
}