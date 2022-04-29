package me.dioforever.rpg.Skills;

import me.dioforever.rpg.files.CCSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class Toughness implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e instanceof Player){
            Player p = ((Player) e).getPlayer();
            String nick = p.getName();
            List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
            List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
            List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
            List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
            p.sendMessage(String.valueOf(e.getDamage()*5));
            if(skills.contains("Toughness")){
                e.setDamage(0);
                p.sendMessage("test");
            }
        }
    }
}
