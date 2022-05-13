package me.dioforever.rpg.Customs.Entities;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.Utils;
import me.dioforever.rpg.files.CCPlayerInfo;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.PolarBear;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Stray;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static me.dioforever.rpg.Utils.color;
import static me.dioforever.rpg.Utils.damagePlayer;
import static me.dioforever.rpg.Utils.damageEntity;

public class Cryomancer implements Listener {
    /*
    BOSS MONSTER or ELITE MONSTER
    Skills:
        Shatter: Upon death, creates ice explosion and deals damage
        Frozen Touch: Every hit from C. will freeze player for a second
        +Rime of Winter: Makes the weather to snow and snow deals damage
        +Rime of Frost (Skill): Spell that Cryomancer casts once a minute, it will freeze everyone near 20blocks of her
            and deal them continuous damage for 3seconds of 30HP per hit
                - will appear as white particles
        Mark of Frost: [Normal Attack] every 2 seconds all players get attacked by a Cold ray --> deals 10HP per hit -> gives Freezing effect
        +Cold Snap (Skill): Spell that Cryomancer casts once per 10-20 seconds, it will make a wave that deals 15HP, however it doesnt go through blocks
        Glacial Wreath: Once the Cryomancer has 20% HP left this skill will be activated, it will make her invulnerable for 15 seconds and put them in ice, while using
            Cold Snap,Mark of Frost, Rime of Frost, Change to
        Cold Blood: 50% ice resistance
        Frozen Minions: Summons the Ice Golems 2x that will be her minions, summons them once she spawns and summon them every 1 to 2 minutes
                Frozen Bear - skills: Predator -> when hunting someone, is faster than the prey by 20%
                                      Frozen claws -> upon hit, the damage will be dealt and the freeze effect will be added to the player
                                      Shatter
        Ring of Ice (Magic): makes a ring around 3 blocks wide and will expand to 5 blocks away and deal damage of 15HP to whoever is there

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
        BossBar bossBar = Bukkit.createBossBar(color("&bCryomancer"), BarColor.YELLOW, BarStyle.SEGMENTED_10);
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();;
        helmetMeta.setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);
        Cryomancer.getEquipment().setHelmet(helmet);

        new BukkitRunnable() {
            @Override
            public void run() {
                bossBar.removeAll();
                if(Cryomancer.isDead()) {
                    cancel();
                }else{
                    List<Entity> nearby =Cryomancer.getNearbyEntities(20,20,20);
                    double health = Cryomancer.getHealth();
                    double healthMAX = Cryomancer.getMaxHealth();
                    double percent = health/healthMAX;

                    bossBar.setProgress(percent);
                    bossBar.removeAll();
                    for (Entity entity : nearby) {
                        if (entity instanceof Player) {
                            Player player = (Player) entity;
                            bossBar.addPlayer(player);
                        }
                    }
                }


            }
        }.runTaskTimer(plugin,0,20);

        new BukkitRunnable() {
            int cooldownRimeFrost = 63;
            int cooldownColdSnap = 10;
            boolean coldSnap = false;
            @Override
            public void run() {
                if(!Cryomancer.isDead()){
                        RimeOfWinter(Cryomancer);
                        //Rime of Frost
                    if(cooldownRimeFrost!=0){
                        //not yet
                        cooldownRimeFrost--;
                    }else{
                        //Can cast it
                        cooldownRimeFrost=63;
                        RimeOfFrost(Cryomancer);
                    }
                    //--Rime of Frost
                    //Cold Snap
                    if(!(cooldownColdSnap<=0)){
                        cooldownColdSnap--;
                    }else{
                        //Check if there is a player to attack
                        List<Entity> nearby =Cryomancer.getNearbyEntities(4,4,4);
                        for (Entity entity : nearby) {
                            if (entity instanceof Player) {
                                coldSnap = true;
                            }
                        }
                        if(coldSnap){
                            cooldownColdSnap=10;
                            ColdSnap(Cryomancer);
                            coldSnap=false;
                        }
                    }
                    //--Cold Snap



                }else{
                    this.cancel();
                }
                System.out.println(cooldownColdSnap);
                System.out.println(coldSnap);
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
                        damagePlayer(Cryomancer,victim,30, "Freeze");
                        PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW,25,100,true,false,false);
                        PotionEffect blindness = new PotionEffect(PotionEffectType.BLINDNESS,25,100,true,false,false);
                        victim.addPotionEffect(slowness);
                        victim.addPotionEffect(blindness);
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
                damageEntity(Cryomancer,victim,5, "Freeze");
                //victim.setFreezeTicks(160);
            }
        }
    }
    public static void ColdSnap(Stray Cryomancer){
        new BukkitRunnable() {
            int l =1;
            @Override
            public void run() {
                Location location = Cryomancer.getLocation();
                location.add(0,1,0);
                for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                    double radius = Math.sin(i);
                    double y = Math.cos(i)*l;
                    for (double a = 0; a < Math.PI * 2; a+= Math.PI / 10) {
                        double x = Math.cos(a) * radius*l;
                        double z = Math.sin(a) * radius*l;
                        location.add(x, y, z);
                        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.WHITE,0.8F);
                        Cryomancer.getWorld().spawnParticle(Particle.REDSTONE,location,1,dustOptions);
                        List<Entity> nearby = (List<Entity>) location.getWorld().getNearbyEntities(location,0.1,0.1,0.1);
                        for(int k=0;k<nearby.size();k++){
                            Entity entity = nearby.get(k);
                            damageEntity(Cryomancer,entity,15,"freeze");
                            if(entity instanceof Player){
                                Player p = (Player) entity;
                                p.sendMessage("Emotional DAMAGE");
                            }
                        }
                        location.subtract(x, y, z);
                    }
                }
                l++;
                if(l>5)cancel();
            }
        }.runTaskTimer(plugin,0,1);

        System.out.println("Cold Snap");

    }
    public static void MarkofFrost(Stray Cryomancer){

    }
    public static void GlacialWreath(Stray Cryomancer){

    }
    public static void FrozenMinions(PolarBear Cryomancer){
        Location spawnLoc1 = Cryomancer.getLocation().add(2,0,3);
        Location spawnLoc2 = Cryomancer.getLocation().add(2,0,-3);

        PolarBear FrozenM1 = spawnLoc1.getWorld().spawn(spawnLoc1, PolarBear.class);
        FrozenM1.setCustomNameVisible(true);
        FrozenM1.setCustomName(color("&Frozen Bear"));

        PolarBear FrozenM2 = spawnLoc2.getWorld().spawn(spawnLoc2, PolarBear.class);
        FrozenM2.setCustomNameVisible(true);
        FrozenM2.setCustomName(color("&Frozen Bear"));

        //Minion 1
        new BukkitRunnable() {
            @Override
            public void run() {
                if(!FrozenM1.isDead()){
                    FrozenM1.setAware(true);
                    FrozenM1.setLeashHolder(null);
                    //Predator skill
                    if(FrozenM1.getTarget()!=null){
                        Entity target = FrozenM1.getTarget();
                        if(target instanceof Player){
                            Player p = (Player) target;
                            double speedPlayer = p.getWalkSpeed();
                            double speed = speedPlayer*1.2;

                        }
                    }
                    //-- Predator skill

                }else{
                    this.cancel();
                }

            }
        }.runTaskTimer(plugin,0,20);

        //Minion 2
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(plugin,0,20);
    }
}




