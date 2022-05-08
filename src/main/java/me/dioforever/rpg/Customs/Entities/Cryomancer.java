package me.dioforever.rpg.Customs.Entities;

import me.dioforever.rpg.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

import static me.dioforever.rpg.Utils.color;

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
    public Cryomancer(Main main){
        plugin = main;
    }

    public static void spawnCryomancer(Location spawnLoc){
        Skeleton Cryomancer = spawnLoc.getWorld().spawn(spawnLoc, Skeleton.class);
        Cryomancer.setCustomNameVisible(true);
        Cryomancer.setCustomName(color("&bCryomancer"));
        Cryomancer.getEquipment().getItemInMainHand().setType(Material.AIR);
        Cryomancer.getEquipment().getItemInMainHand().setAmount(0);

        new BukkitRunnable() {
            int cooldownRimeFrost = 60;
            @Override
            public void run() {
                if(!Cryomancer.isDead()){
                        RimeOfWinter(Cryomancer);
                    if(cooldownRimeFrost!=0){
                        //not yet
                        cooldownRimeFrost--;
                    }else{
                        //Can cast it
                        cooldownRimeFrost=60;
                        RimeOfFrost(Cryomancer);
                    }


                }else{
                    this.cancel();
                }

            }
        }.runTaskTimer(plugin,0,20);

    }
    public static void RimeOfFrost(Skeleton Cryomancer){
        Entity entities = (Entity) Cryomancer.getNearbyEntities(20,20,20);

    }
    public static void RimeOfWinter(Skeleton Cryomancer){
        Location loc = Cryomancer.getLocation();
        Location test = new Location(loc.getWorld(),-310,73,-154);
        World world = loc.getWorld();
        System.out.println(Cryomancer.getLocation().getBlockX());
        System.out.println(Cryomancer.getLocation().getBlockY());
        System.out.println(Cryomancer.getLocation().getBlockZ());
        world.spawnParticle(Particle.SNOWFLAKE,loc,2000,20,20,20);
        new BukkitRunnable() {
            @Override
            public void run() {
                world.spawnParticle(Particle.SNOWFLAKE,loc,1000,20,20,20);
            }
        }.runTaskLater(plugin,10);
        List<Entity> nearbyEntites = (List<Entity>) Cryomancer.getWorld().getNearbyEntities(loc, 8, 8, 8);
        for(int i =0;i<nearbyEntites.size();i++){
            if(nearbyEntites.get(i) instanceof Player){
                Player player = (Player) nearbyEntites.get(i);
                player.setFreezeTicks(160);
            }
        }


        System.out.println("Rime of Winter my boi");
    }

}




