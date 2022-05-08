package me.dioforever.rpg.Customs.Entities;

import me.dioforever.rpg.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class Cryomancer implements Listener {
    /*
    BOSS MONSTER or ELITE MONSTER
    Skills:
        Shatter: Upon death, creates ice explosion and deals damage
        Frozen Touch: Every hit from C. will freeze player for a second
        Rime of Winter: Makes the weather to snow and snow deals damage
        Rime of Frost: Spell that Cryomancer casts once a minute, it will freeze everyone near 20blocks of her
            and deal them continuous damage for 3seconds of 30HP per hit
                - will appear as white particles
        Mark of Frost: [Normal Attack] every 2 seconds all players get attacked by a Cold ray --> deals 10HP per hit -> gives Freezing effect
        Cold Snap: Spell that Cryomancer casts once per 10-20 seconds, it will make a wave that deals 15HP, however it doesnt go through blocks
        Glacial Wreath: Once the Cryomancer has 20% HP left this skill will be activated, it will make her invulnerable for 15 seconds while casting
        Frozen Minions: Summons the Ice Golems 2x that will be her minions
     */

    static Main plugin;
    public  Cryomancer(Main main){
        plugin = main;
    }

    public static void spawnCryomancer(Location spawnLoc){
        Skeleton Cryomancer = spawnLoc.getWorld().spawn(spawnLoc, Skeleton.class);
        Cryomancer.getEquipment().getItemInMainHand().setType(Material.AIR);
        Cryomancer.getEquipment().getItemInMainHand().setAmount(0);

        new BukkitRunnable() {
            int cooldownRimeFrost = 60;
            @Override
            public void run() {
                if(!Cryomancer.isDead()){
                    if(cooldownRimeFrost!=0){
                        //not yet
                        cooldownRimeFrost--;
                    }else{
                        //Can cast it
                        cooldownRimeFrost=60;
                        RimeOfFrost(Cryomancer);
                    }


                }else{
                    cancel();
                }

            }
        }.runTaskTimer(plugin,0,20);

    }
    public static void RimeOfFrost(Skeleton Cryomancer){
        Entity entities = (Entity) Cryomancer.getNearbyEntities(20,20,20);

    }

}




