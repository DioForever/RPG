package me.dioforever.rpg.CustomHealth;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.Skills.Toughness;
import me.dioforever.rpg.files.CCLeft;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class DamageListener implements Listener {
    static Main plugin;
    static Toughness toughness;




    //public DamageListener(Main main){
    //    plugin = main;
    //}

    @EventHandler
    public void onDamage(EntityDamageEvent e){
            if(e.getEntity() instanceof Player) {
                if(e.getCause()==EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    return
                }

                Player p = (Player) e.getEntity();
                String nick = p.getName();
                double damage = e.getDamage()*5;
                int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                int HP = CCLeft.get().getInt(nick+".HP");
                if(toughness.Thoughness(nick)!=null){
                if(toughness.Thoughness(nick)&& damage<=5){
                    //The player Thoughness and damage is smaller or equal to 5
                    e.setDamage(0);
                    //Temporary text
                    p.sendMessage("Thoughness has taken effect");
                    return;
                }
                }
                double  percent = damage/MAXHP*100;
                double FinalDamage = damage;
                CCLeft.get().set(nick+".HP",HP-damage);
                int HPNew = CCLeft.get().getInt(nick+".HP");

                p.setHealth(HPNew/5);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player){
            double strength = 0;
            double defense  = 0;
            Player p = (Player) e.getEntity();

            String nick = p.getName();
            if(e.getDamager() instanceof Player){
                Player pDamager = (Player) e.getDamager();
                String nickDamager = pDamager.getName();
                int strengthBasic = CCStats.get().getInt(nickDamager+".Strength");
                int strengthBonus = CCStats.get().getInt(nickDamager+".StrengthB");
                int strengthTemp = CCStats.get().getInt(nickDamager+".StrengthT");
                strength = (strengthBasic+strengthBonus+strengthTemp)/15;

                int defenseBasic = CCStats.get().getInt(nick+".Defense");
                int defenseBonus = CCStats.get().getInt(nick+".DefenseB");
                int defenseTemp = CCStats.get().getInt(nick+".DefenseT");
                defense = (defenseBasic + defenseBonus+ defenseTemp)/15;
            }


     
            if(toughness.Thoughness(nick)!=null){
            if(toughness.Thoughness(nick) && e.getDamage()*5+strength<=5){
                //The player Thoughness and damage is smaller or equal to 5
                e.setDamage(0);
                //Temporary text
                p.sendMessage("Thoughness has taken effect");
                return;
            }
            }

                    double damage = e.getDamage()*5;
                    int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                    int HP = CCLeft.get().getInt(nick+".HP");
                    //Get the % of the HP to show
                    double  percent = damage/MAXHP*100;
                    double FinalDamage = damage+strength-defense;
                    if(FinalDamage<0)FinalDamage=0;
                    CCLeft.get().set(nick+".HP",HP-FinalDamage);
                    int HPNew = CCLeft.get().getInt(nick+".HP");
                    if(HPNew/5!=p.getHealth()){
                        p.setHealth(HPNew/5);
                    }
            }
        }

    }
