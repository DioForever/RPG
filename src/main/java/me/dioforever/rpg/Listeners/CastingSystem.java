package me.dioforever.rpg.Listeners;

import me.dioforever.rpg.files.CCCombos;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class CastingSystem implements Listener {

    public String Combo;
    public static String combo;
    public static CastingSystem plugin;


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        plugin = this;
        Player p = e.getPlayer();
        String nick = p.getName();
        int lenghtS=0;
        int lenghtMg=0;
        int lenghtMa=0;
        int MaxLenght=0;
        List combosS = CCCombos.get().getList(nick+".Skills.Combos");
        List combosMg = CCCombos.get().getList(nick+".Magic.Combos");
        List combosMa = CCCombos.get().getList(nick+".MArt.Combos");
        for(int i = 0;i<combosS.size();i++){
            String comb = (String) combosS.get(i);
            if(comb.length()>lenghtS){
                lenghtS=comb.length();
            }

        }
        if(combosMg!=null){
            for(int i = 0;i<combosMg.size();i++){
                String comb = (String) combosMg.get(i);
                if(comb.length()>lenghtMg){
                    lenghtMg=comb.length();
                }

            }
        }
        if(combosMa!=null){
            for(int i = 0;i<combosMa.size();i++){
                String comb = (String) combosMa.get(i);
                if(comb.length()>lenghtMa){
                    lenghtMa=comb.length();
                }

            }
        }

        if(lenghtS>lenghtMa){
            MaxLenght=lenghtS;
        }else{
            MaxLenght=lenghtMa;
        }
        if(!(MaxLenght>lenghtMg)){
            MaxLenght=lenghtMg;
        }

        if(Combo==null){
            if (e.getAction().equals((Action.LEFT_CLICK_AIR))) {
                Combo = "L";
            } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                Combo = "L";
            } else if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                Combo = "R";
            } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Combo = "R";
            }
        }else if (!(Combo.length() > MaxLenght-1)) {
            if (e.getAction().equals((Action.LEFT_CLICK_AIR))) {
                Combo += "L";
            } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                Combo += "L";
            } else if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                Combo += "R";
            } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Combo += "R";
            }
        }else {
            Combo="";
        }
        combo = Combo;

    }

}




