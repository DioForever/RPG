package me.dioforever.rpg.Customs.Entities;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.Utils;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Stray;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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
        Frozen Minions: Summons the Ice Golems 2x that will be her minions, summons them once she spawns and summon them every 1 to 2 minutes
     */

    static Main plugin;
    public Cryomancer(Main main){
        plugin = main;
    }

    public static void spawnCryomancer(Location spawnLoc){
        Stray Cryomancer = spawnLoc.getWorld().spawn(spawnLoc, Stray.class);
        Cryomancer.setCustomNameVisible(true);
        Cryomancer.setCustomName(color("&bCryomancer"));
        ItemStack air = new ItemStack(Material.AIR,1);
        Cryomancer.getEquipment().setItemInMainHand(air);

        new BukkitRunnable() {
            int cooldownRimeFrost = 63;
            @Override
            public void run() {
                if(!Cryomancer.isDead()){
                        RimeOfWinter(Cryomancer);
                    if(cooldownRimeFrost!=0){
                        //not yet
                        cooldownRimeFrost--;
                    }else{
                        //Can cast it
                        cooldownRimeFrost=63;
                        RimeOfFrost(Cryomancer);
                    }


                }else{
                    this.cancel();
                }
                System.out.println(cooldownRimeFrost);

            }
        }.runTaskTimer(plugin,0,20);

    }
    public static void RimeOfFrost(Stray Cryomancer){
        //Spell that Cryomancer casts once a minute, it will freeze everyone near 20blocks of her
        //            and deal them continuous damage for 3seconds of 30HP per hit
        new BukkitRunnable() {
            int count = 2;
            @Override
            public void run() {
                List<Entity> entities = (List<Entity>) Cryomancer.getNearbyEntities(20,20,20);
                for(int i = 0; i<entities.size();i++){
                    if(entities.get(i) instanceof Player){
                        Player victim = (Player) entities.get(i);
                        Utils.dealDamage(Cryomancer,victim,3.0, "Freeze");
                        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW,25,100,true,false,false);
                        victim.addPotionEffect(slowness);
                    }
                }
                if(count==0){
                    this.cancel();
                }
                count--;


            }
        }.runTaskTimer(plugin,0,20);

    }
    public static void RimeOfWinter(Stray Cryomancer){
        //Makes the weather to snow and snow deals damage
        Location loc = Cryomancer.getLocation();
        Location test = new Location(loc.getWorld(),-310,73,-154);
        World world = loc.getWorld();
        world.spawnParticle(Particle.SNOWFLAKE,loc,2000,20,20,20);
        new BukkitRunnable() {
            @Override
            public void run() {
                world.spawnParticle(Particle.SNOWFLAKE,loc,1000,20,20,20);
            }
        }.runTaskLater(plugin,10);
        List<Entity> nearbyEntites = (List<Entity>) Cryomancer.getWorld().getNearbyEntities(loc, 20, 20, 20);
        for(int i =0;i<nearbyEntites.size();i++){
            if(nearbyEntites.get(i) instanceof Player){
                Player victim = (Player) nearbyEntites.get(i);
                Utils.dealDamage(Cryomancer,victim,0.5, "Freeze");
            }
        }
    }

}




