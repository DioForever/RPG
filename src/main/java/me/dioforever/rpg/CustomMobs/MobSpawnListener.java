package me.dioforever.rpg.CustomMobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.Random;

import static me.dioforever.rpg.Utils.color;

public class MobSpawnListener implements Listener {

    @EventHandler
    public void onSpawnMob(CreatureSpawnEvent e){

        if(e.getEntity() instanceof Monster) {
            Entity v = (Entity) e.getEntity();
            if(v.getType()==EntityType.ENDER_DRAGON){
                return;
            }
            if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG ||
                    e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.DEFAULT ||
                    e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER||
                    e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.COMMAND||
                    e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) {
                Random ch = new Random();
                int probability = ch.nextInt(8);
                switch (probability){
                    case 4:
                    case 8:


                        Random rand = new Random();
                        String MName = v.getType().toString();
                        String rarity = "";
                        String rarits = "";
                        int level = 1;
                        //1/4 Strenght
                        //1/4 Defense
                        //1/4 Health
                        //1/4 Agility





                        int rarch1 = rand.nextInt(30);
                        //0-12 1x
                        //13-20 1.1x
                        //21-26 1.15x
                        //27-30 1.2xx
                        //Level Groups
                        //0 - 0-10
                        //1 - 11-30
                        //2 - 31-51
                        //3 - 51-71
                        //4 - 72-150
                        //
                        Random lvlgr = new Random();
                        int lvlgroup = lvlgr.nextInt(3);
                        switch (lvlgroup){
                            case 0:
                                int max = 10;
                                int min = 1;
                                level = (int)Math.floor(Math.random()*(max-min+1)+min);
                                break;

                            case 1:
                                int max2 = 30;
                                int min2 = 11;
                                level = (int)Math.floor(Math.random()*(max2-min2+1)+min2);
                                break;

                            case 2:
                                int max3 = 50;
                                int min3 = 31;
                                level = (int)Math.floor(Math.random()*(max3-min3+1)+min3);
                                break;
                            case 3:
                                int max4 = 71;
                                int min4 = 51;
                                level = (int)Math.floor(Math.random()*(max4-min4+1)+min4);
                                break;
                            case 4:
                                int max5 = 150;
                                int min5 = 72;
                                level = (int)Math.floor(Math.random()*(max5-min5+1)+min5);
                                break;
                        }

                        double mult = 1;
                        /*
                        switch (rarity){
                            case "7":
                                mult = 1.1;
                                break;
                            case "1":
                                mult = 1.15;
                                break;
                            case "5":
                                mult = 1.2;
                                break;
                            case "6":
                                mult = 1.3;
                                break;
                        }*/

                        if(level>100){
                            rarity="6";
                            rarits="e";
                        }else if(level<100 && level>69){
                            rarity="5";
                            rarits="d";
                        }else if(level>30&&level<70){
                            rarity="1";
                            rarits="9";
                        }else if(level<31){
                            rarity="8";
                            rarits="7";
                        }

                        double statp = level*8;
                        if(!(statp/4<1)){
                            double hp = statp/4+20;
                            double speed = (0.2 + statp/10*0.01);

                            //Overwold
                            //Nether will be higher lvls
                            if(v instanceof Creeper){
                                Creeper cr = (Creeper) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Zombie){
                                Zombie cr = (Zombie) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Skeleton){
                                Skeleton cr = (Skeleton) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Spider){
                                Spider cr = (Spider) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Enderman){
                                Enderman cr = (Enderman) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Drowned){
                                Drowned cr = (Drowned) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }else if(v instanceof Slime){
                                Slime cr = (Slime) v;
                                cr.setMaxHealth(hp);
                                cr.setHealth(hp);
                                cr.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
                            }
                        }

                        //[LVL.150] CREEPER
                        v.setCustomName(color("&"+rarity+"[&"+rarits+"LVL."+level+"&"+rarity+"]&r "+MName));
                        v.setCustomNameVisible(true);
                        break;
                }
            }
        }
    }
}
