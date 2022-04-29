package me.dioforever.rpg.Leveling;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.PluginSettings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;

public class FarmMineListener implements Listener {

    static Main plugin;


    private int cooldown;
    private int coolrem;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static Map<Player, BossBar> bossBarMap = new HashMap<>();
    private boolean farmed;
    private boolean mined;
    private double xp;

    public FarmMineListener(Main main){
        plugin = main;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        List<Item> crops = new ArrayList<>();
        Block block = event.getBlock();
        farmed = false;
        mined = false;
        xp = 0;


        //Corpses
        if(PluginSettings.get().getBoolean("Leveling.Farming")==true){
            cooldown =2;
            coolrem=0;
            Player player = event.getPlayer();
            String nick = player.getName();
            if (block.getBlockData() instanceof Ageable) {
                double XPM = CCPlayerInfo.get().getDouble(nick+".XPM");
                Ageable age = (Ageable) block.getBlockData();
                if (block.getType() == Material.WHEAT) {
                    if (age.getAge() == age.getMaximumAge()) {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.05+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.05);
                            CCPlayerInfo.save();
                        }
                        farmed=true;
                    }
                }else if(block.getType() == Material.POTATOES){
                    if (age.getAge() == age.getMaximumAge()) {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.05+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.05);
                            CCPlayerInfo.save();
                        }
                        farmed=true;
                    }
                }else if(block.getType() == Material.CARROTS){
                    if (age.getAge() == age.getMaximumAge()) {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.05+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.05);
                            CCPlayerInfo.save();
                        }
                        farmed=true;
                    }
                }
            }
            if(block.getType()==Material.MELON){
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                if(XP+0.05>=XPN){
                    CCPlayerInfo.get().set(nick+".Level",levelP+1);
                    CCPlayerInfo.get().set(nick+".XP",0.05+XP);
                    CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                    int StatStrength = CCStats.get().getInt(nick+".Strength");
                    int StatDefense = CCStats.get().getInt(nick+".Defense");
                    int StatHealth= CCStats.get().getInt(nick+".Health");
                    int StatAgility = CCStats.get().getInt(nick+".Agility");
                    int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                    int StatStamina = CCStats.get().getInt(nick+".Stamina");
                    int Points = CCStats.get().getInt(nick+".Points");
                    Points+=2;
                    StatStrength++;
                    StatAgility++;
                    StatDefense++;
                    StatHealth++;
                    StatIntelligence++;
                    StatStamina++;
                    CCStats.get().set(nick+".Points",Points);
                    CCStats.get().set(nick+".Strength",StatStrength);
                    CCStats.get().set(nick+".Defense",StatDefense);
                    CCStats.get().set(nick+".Health",StatHealth);
                    CCStats.get().set(nick+".Intelligence",StatIntelligence);
                    CCStats.get().set(nick+".Stamina",StatStamina);
                    CCStats.get().set(nick+".Agility",StatAgility);
                }else {
                    CCPlayerInfo.get().set(nick+".XP",XP+0.05);
                    CCPlayerInfo.save();
                }
                farmed=true;
            }
            if(farmed==true && CCPlayerInfo.get().getBoolean(nick+".LevelBars")==true){
                farmed=false;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        HashMap<Player, BossBar> bossBM = (HashMap<Player, BossBar>) bossBarMap;
                        int Level = CCPlayerInfo.get().getInt(nick + ".Level");
                        double XP = CCPlayerInfo.get().getDouble(nick + ".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick + ".XPNeeded");
                        BossBar levelbar = Bukkit.createBossBar(color("&6&lLEVEL " + Level + " " + df.format(XP) + "&6&lXP"+"(+"+0.1+")" + "&6&l/" + XPN + "&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);

                        if(!(coolrem>=cooldown)){
                            if(bossBM.containsKey(player)){
                                bossBM.get(player).removePlayer(player);
                                levelbar.removePlayer(player);
                            }

                            bossBM.put(player,levelbar);
                            levelbar.addPlayer(player);
                            coolrem++;
                        }else{
                            levelbar.removePlayer(player);
                            bossBM.get(player).removePlayer(player);
                            this.cancel();
                        }
                    }
                }.runTaskTimer(plugin,0,40);
            }

        }



        if(PluginSettings.get().getBoolean("Leveling.Mining")==true){
            //Ores
            Player player = event.getPlayer();
            String nick = player.getName();
            if(!(player.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH))){
                if(block.getType()==Material.DIAMOND_ORE||block.getType()==Material.DEEPSLATE_DIAMOND_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",1+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+1);
                            CCPlayerInfo.save();
                        }
                        xp=1;
                        mined=true;
                    }
                }else if(block.getType()==Material.IRON_ORE||block.getType()==Material.DEEPSLATE_IRON_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.20>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.2+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.20);
                            CCPlayerInfo.save();
                        }
                        xp=0.20;
                        mined=true;
                    }
                }else if(block.getType()==Material.REDSTONE_ORE||block.getType()==Material.DEEPSLATE_REDSTONE_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.2>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+2);
                            CCPlayerInfo.get().set(nick+".XP",0.2+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.2);
                            CCPlayerInfo.save();
                        }
                        xp=0.2;
                        mined=true;
                    }
                }else if(block.getType()==Material.EMERALD_ORE||block.getType()==Material.DEEPSLATE_EMERALD_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",1+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+1);
                            CCPlayerInfo.save();
                        }
                        xp=1;
                        farmed=true;
                    }

                }else if(block.getType()==Material.GOLD_ORE||block.getType()==Material.DEEPSLATE_GOLD_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.4>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.4+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.4);
                            CCPlayerInfo.save();
                        }
                        xp=0.4;
                        mined=true;
                    }

                }else if(block.getType()==Material.LAPIS_ORE||block.getType()==Material.DEEPSLATE_LAPIS_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.1+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.1);
                            CCPlayerInfo.save();
                        }
                        xp=0.1;
                        mined=true;
                    }

                }else if(block.getType()==Material.COAL_ORE||block.getType()==Material.DEEPSLATE_COAL_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.1+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.1);
                            CCPlayerInfo.save();
                        }
                        xp=0.1;
                        mined=true;
                    }

                } else if(block.getType()==Material.NETHER_QUARTZ_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.2>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.2+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.2);
                            CCPlayerInfo.save();
                        }
                        xp=0.2;
                        mined=true;
                    }

                } else if(block.getType()==Material.NETHER_GOLD_ORE){
                    {
                        double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                        int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                        if(XP+0.1>=XPN){
                            CCPlayerInfo.get().set(nick+".Level",levelP+1);
                            CCPlayerInfo.get().set(nick+".XP",0.1+XP);
                            CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                            int StatStrength = CCStats.get().getInt(nick+".Strength");
                            int StatDefense = CCStats.get().getInt(nick+".Defense");
                            int StatHealth= CCStats.get().getInt(nick+".Health");
                            int StatAgility = CCStats.get().getInt(nick+".Agility");
                            int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                            int StatStamina = CCStats.get().getInt(nick+".Stamina");
                            int Points = CCStats.get().getInt(nick+".Points");
                            Points+=2;
                            StatStrength++;
                            StatAgility++;
                            StatDefense++;
                            StatHealth++;
                            StatIntelligence++;
                            StatStamina++;
                            CCStats.get().set(nick+".Points",Points);
                            CCStats.get().set(nick+".Strength",StatStrength);
                            CCStats.get().set(nick+".Defense",StatDefense);
                            CCStats.get().set(nick+".Health",StatHealth);
                            CCStats.get().set(nick+".Intelligence",StatIntelligence);
                            CCStats.get().set(nick+".Stamina",StatStamina);
                            CCStats.get().set(nick+".Agility",StatAgility);
                        }else {
                            CCPlayerInfo.get().set(nick+".XP",XP+0.1);
                            CCPlayerInfo.save();
                        }
                        xp=0.1;
                        mined=true;
                    }
                }
                if(mined==true && CCPlayerInfo.get().getBoolean(nick+".LevelBars")==true){
                    mined=false;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            HashMap<Player, BossBar> bossBM = (HashMap<Player, BossBar>) bossBarMap;
                            int Level = CCPlayerInfo.get().getInt(nick + ".Level");
                            double XP = CCPlayerInfo.get().getDouble(nick + ".XP");
                            int XPN = CCPlayerInfo.get().getInt(nick + ".XPNeeded");
                            BossBar levelbar = Bukkit.createBossBar(color("&6&lLEVEL " + Level + " " + df.format(XP) + "&6&lXP"+"(+"+xp+")" + "&6&l/" + XPN + "&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);

                            if(!(coolrem>=cooldown)){
                                if(bossBM.containsKey(player)){
                                    bossBM.get(player).removePlayer(player);
                                    levelbar.removePlayer(player);
                                }

                                bossBM.put(player,levelbar);
                                levelbar.addPlayer(player);
                                coolrem++;
                            }else{
                                levelbar.removePlayer(player);
                                bossBM.get(player).removePlayer(player);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin,0,40);
                }
            }
        }
    }
}

