package me.dioforever.rpg.CustomMobs.CustomHealth;

import me.dioforever.rpg.files.CCLeft;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class HealListener implements Listener {
    //Have custom HP as a main hp, and the HP from MC as a visual one


    /*
    https://minecraft.fandom.com/wiki/Hunger#Exhaustion_level_increase
    https://minecraft.fandom.com/wiki/Healing#Saturation_healing

     It will be a runnable with for for every player
     get difficulty
     get the saturation if 18+ = half hearth every 4seconds -> -1 hunger
     +6 exhaustion per half heart = 5HP


     if has left over saturation then its heart = 10HP per second
     -> -1.5 saturation per half a heart = 5HP
     PlAYER HAS UP TO 20 SATURATION = 6.5 Heart = *2*5 = 65HP per saturation

          //FIRSTLY
          check if player has saturation, if has then fast heal full heart per second, but -1.5 saturation per half a heart


     */

    @EventHandler
    public void onHeal(EntityRegainHealthEvent e){
            if(e.getEntity() instanceof  Player){

                Player p = (Player) e.getEntity();
                double heal = e.getAmount()*5;
                String nick = e.getEntity().getName();
                int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                int HP = CCLeft.get().getInt(nick+".HP");
                double  percent = heal/MAXHP*100;
                double Finalheal = p.getMaxHealth()/100*percent;

                CCLeft.get().set(nick+".HP",HP+heal);
                CCLeft.save();
                int HPNew = CCLeft.get().getInt(nick+".HP");
                if(HPNew>MAXHP){
                    CCLeft.get().set(nick+".HP",MAXHP);
                }

                if(Finalheal+p.getHealth()>=p.getMaxHealth()-1&& HP+heal<MAXHP){
                    e.setAmount(0);

                }else{
                    e.setAmount(MAXHP/5);
                }
                //Check if custom HP isnt right
                if(HPNew/5!=p.getHealth()){
                    if(!(HPNew/5>p.getMaxHealth())){
                        p.setHealth(HPNew/5);
                    }else{
                        p.setHealth(p.getMaxHealth());
                    }

                }
                e.setAmount(0);

                //Check if real HP isnt right
                //if((p.getHealth()*5)>HPNew){
                  //  double percentNew = MAXHP/HPNew*100;
                    //p.setHealth(percentNew);
                //}





            }

    }

    @EventHandler
    public void onSpawn(PlayerRespawnEvent e){
            Player p = e.getPlayer();
            String nick = p.getName();
            int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
            CCLeft.get().set(nick+".HP",MAXHP);
        }
    }
