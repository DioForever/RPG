package me.dioforever.rpg.StatWork;

import me.dioforever.rpg.files.CCStats;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class DamageListener implements Listener {


    @EventHandler
    public void DMGEvent(EntityDamageByEntityEvent event) {
        //Damage to a Player
        if (event.getEntity() instanceof Player) {
            if (event.getDamage() != 0) {
                    //Defense
                    Player player = ((Player) event.getEntity()).getPlayer();
                    String nick = player.getName();
                    double Defense = CCStats.get().getInt(nick + ".Defense");
                    double Strength = 0;
                    //Damage by Player
                    if (event.getDamager() instanceof Player) {
                        Strength = CCStats.get().getInt(nick + ".Strength");
                    }
                    //Damage by Monster
                    //have to check if its Mob with level U know
                    else {
                        if (event.getDamager().getCustomName() != null) {
                            String VName = ((Entity) event.getDamager()).getCustomName();
                            char[] vnch = VName.toCharArray();
                            boolean found = false;
                            String levelS = "";
                            List cints = new ArrayList<>();
                            cints.add('1');
                            cints.add('2');
                            cints.add('3');
                            cints.add('4');
                            cints.add('5');
                            cints.add('6');
                            cints.add('7');
                            cints.add('8');
                            cints.add('9');

                            //ž6[ž4LVL.150
                            if(cints.contains(vnch[10])){
                                if(cints.contains(vnch[11])){
                                    levelS = Character.toString(vnch[9])+Character.toString(vnch[10])+Character.toString(vnch[11]);
                                }else{
                                    levelS = Character.toString(vnch[9])+Character.toString(vnch[10]);
                                }
                            }else{
                                levelS = Character.toString(vnch[9]);
                            }
                            Strength = (Integer.parseInt(levelS)+10) + (Integer.parseInt(levelS)*2/4);
                        }
                    }



                        double DMG = event.getDamage();
                        double STR = Strength / 10;
                        double DFS = Defense / 10 ;
                        double finalDMG = DMG + STR - DFS;
                        if (finalDMG < 0) {
                            finalDMG = 0;
                        }
                        event.setDamage(finalDMG);
                    }
                }
            //Damage to a Mob
            else {
                Entity damager = event.getDamager();
            double Defense = 0;
            double Strength = 0;
            if (event.getDamager().getCustomName() != null) {
                String VName = ((Entity) event.getDamager()).getCustomName();
                char[] vnch = VName.toCharArray();
                String levelS = "";
                List cints = new ArrayList<>();
                cints.add('1');
                cints.add('2');
                cints.add('3');
                cints.add('4');
                cints.add('5');
                cints.add('6');
                cints.add('7');
                cints.add('8');
                cints.add('9');

                //ž6[ž4LVL.150
                if(cints.contains(vnch[10])){
                    if(cints.contains(vnch[11])){
                        levelS = Character.toString(vnch[9])+Character.toString(vnch[10])+Character.toString(vnch[11]);
                    }else{
                        levelS = Character.toString(vnch[9])+Character.toString(vnch[10]);
                    }
                }else{
                    levelS = Character.toString(vnch[9]);
                }
                Strength = (Integer.parseInt(levelS)+10) + (Integer.parseInt(levelS)*2/4);
            }
                if (damager instanceof Player) {
                    Player player = ((Player) damager).getPlayer();
                    Entity victim = event.getEntity();
                    String nick = damager.getName();
                    Strength = CCStats.get().getInt(nick + ".Strength");
                }
            double DMG = event.getDamage();
            double DFS = Defense/10;
            double STR = Strength/10;
            double finalDMG = DMG+STR-DFS;
            event.setDamage(finalDMG);
            }
        }
}

