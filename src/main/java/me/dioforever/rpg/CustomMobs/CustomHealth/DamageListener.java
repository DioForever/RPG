package me.dioforever.rpg.CustomMobs.CustomHealth;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCLeft;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;

public class DamageListener implements Listener {
    static Main plugin;


    //public DamageListener(Main main){
    //    plugin = main;
    //}

    @EventHandler
    public void onDamage(EntityDamageEvent e){
            if(e.getEntity() instanceof Player) {
                if(e.getCause()==EntityDamageEvent.DamageCause.ENTITY_ATTACK)return;
                Player p = (Player) e.getEntity();
                String nick = p.getName();
                double damage = e.getDamage()*5;
                int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                int HP = CCLeft.get().getInt(nick+".HP");
                double  percent = damage/MAXHP*100;
                double FinalDamage = p.getMaxHealth()/100*percent;
                CCLeft.get().set(nick+".HP",HP-damage);
                //STOPPED THERE
                //STOPPED THERE
                //STOPPED THERE
                //STOPPED THERE
                //STOPPED THERE
                //STOPPED THERE
                int HPNew = CCLeft.get().getInt(nick+".HP");

                p.setHealth(HPNew/5);
                /*
                if(!(HP-damage<=0)){
                        CCLeft.get().set(nick+".HP",HP-damage);
                        e.setDamage(FinalDamage+strength);
                }else{
                    //DIE
                    e.setDamage(FinalDamage+strength);
                }*/

                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
                //NOT FINISHED THIS
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player){
            if(e.getDamager() instanceof Player){
                    Player pDamager = (Player) e.getDamager();
                    Player p = (Player) e.getEntity();
                    String nickDamager = pDamager.getName();
                    String nick = p.getName();
                    int strengthBasic = CCStats.get().getInt(nickDamager+".Strength");
                    int strengthBonus = CCStats.get().getInt(nickDamager+".StrengthB");
                    int strengthTemp = CCStats.get().getInt(nickDamager+".StrengthT");
                    double strength = (strengthBasic+strengthBonus+strengthTemp)/15;

                    double damage = e.getDamage()*5;
                    int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                    int HP = CCLeft.get().getInt(nick+".HP");
                    //Get the % of the HP to show
                    double  percent = damage/MAXHP*100;
                    double FinalDamage = p.getMaxHealth()/100*percent+strength;
                    CCLeft.get().set(nick+".HP",HP-damage);
                    int HPNew = CCLeft.get().getInt(nick+".HP");

            }
        }
    }
}
