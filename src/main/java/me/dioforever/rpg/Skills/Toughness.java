package me.dioforever.rpg.Skills;

import me.dioforever.rpg.files.CCSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class Toughness {

    //Every Damage related skill has to be in the me.dioforever.rpg.CustomHealth.DamageListener to work
    public boolean Thoughness(String nick){
        List skills = CCSkills.get().getList(nick+".Skills.Rare.Name");
        if(skills.contains("Toughness")){
            return true;
        }
        return false;
    }
}
