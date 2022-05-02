package me.dioforever.rpg.CustomMobs.CreateEntities;

import me.dioforever.rpg.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.*;

public class OrcChampion {


    public static void SpawnOrcChampion(Player p, Location loc, int level){
        // TEXTURE
        // TEXTURE
        //            https://www.youtube.com/watch?v=CAnVzNODr5U
        // TEXTURE
        // TEXTURE
        //Spawn OrcChampion and his group

        Zombie OrcChampion = p.getWorld().spawn(loc,Zombie.class);
        UUID uuidOrcChampion = OrcChampion.getUniqueId();
        //Decide on stats
        //Give his bonus Stat Points between Agility, Defense, Strength randomly
        Random StrengthStatR = new Random(1);
        int StrengthStat = StrengthStatR.nextInt(level*2-2);
        Random AgilityStatR = new Random(1);
        int AgilityStat = AgilityStatR.nextInt(level*2-StrengthStat);
        Random DefenseStatR = new Random(1);
        int DefenseStat = DefenseStatR.nextInt(level*2-StrengthStat-AgilityStat);
        int HealthStat = level*2+10-StrengthStat-AgilityStat-DefenseStat;
        //Save the stats to list
        List StatsOrcChamp = new ArrayList<>();
        StatsOrcChamp.add(StrengthStat);
        StatsOrcChamp.add(AgilityStat);
        StatsOrcChamp.add(DefenseStat);
        StatsOrcChamp.add(HealthStat);

        Map customMobsStats = new HashMap<>();
        //the order will be known according to the Type of the mob
        //Check if the list exists, if not dont pay mind to it
        if(Main.getCustomMobsStats()!=null){
            customMobsStats = Main.getCustomMobsStats();
        }
        customMobsStats.put(uuidOrcChampion,StatsOrcChamp);
        //Give him the stats
        OrcChampion.setHealth(level+10+(HealthStat));
        //--FINISHED THE STATS PART


        //Orc Champ has:
        //		- Berserk (5% for obtaining upon killing the boss - Epic) the less HP he has, the bigger damage he deals, for every %1HP les +1%DMG
        //		- Orc Skin (5% for obtaining upon killing the boss - Epic) +10 Defense stat
        //		- Leadership, for every killed orc in the Orc Champions group, he gains +2stats to every stat
        // Will be createad class for each skill and called in the runnable for the Champ

        //Save skills in list
        List skillsOrcChamp = new ArrayList<>();
        skillsOrcChamp.add("Berserk");
        skillsOrcChamp.add("Orc Skin");
        skillsOrcChamp.add("Leadership");
        Map customMobsSkills = new HashMap<>();
        if(Main.getCustomMobsSkills()!=null){
            customMobsSkills = Main.getCustomMobsSkills();
        }
        customMobsSkills.put(uuidOrcChampion,skillsOrcChamp);
        //--FINISHED SKILLS PART

        //Give him armor


        //--FINISHED ARMOR PART

        //Spawn his group of 8 Orcs Guardians




    }


}
