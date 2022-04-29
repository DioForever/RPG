package me.dioforever.rpg.CustomMobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class MobDamageDealingDefenseStat implements Listener {

    @EventHandler
    public void onGetDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            String nick = p.getName();
            Entity dealer = e.getDamager();

            if(dealer instanceof Monster){
                String VName = dealer.getCustomName();
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

                for(int i = vnch.length-1; i>0;i--){
                    if(!found){
                        if(vnch[i]==']'){
                            if(cints.contains(vnch[i-3])){
                                if(cints.contains(vnch[i-4])){
                                    if(cints.contains(i-5)){
                                        //Has 3 cifer Level
                                        levelS = Character.toString(vnch[i-5])+Character.toString(vnch[i-4])+Character.toString(vnch[i-3]);
                                        found=true;
                                    }else{
                                        //Has 2 cifer Level
                                        levelS = Character.toString(vnch[i-4])+Character.toString(vnch[i-3]);
                                        found=true;
                                    }
                                }else{
                                    //Has 1 cifer Level
                                    levelS = Character.toString(vnch[i-5]);
                                    found=true;
                                }
                            }
                        }
                    }
                    int levelM = Integer.parseInt(levelS);

                    double damageB = e.getDamage();


                }
            }else{

            }

        }
    }
}
