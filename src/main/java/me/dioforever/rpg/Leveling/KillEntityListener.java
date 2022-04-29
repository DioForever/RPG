package me.dioforever.rpg.Leveling;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;

public class KillEntityListener implements Listener {

    static Main plugin;
    private int cooldown;
    private int coolrem;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static Map<Player, BossBar> bossBarMap = new HashMap<>();

    public KillEntityListener(Main main){
        plugin = main;
    }

    @EventHandler
    public void onKillMob(EntityDeathEvent event) {
        LivingEntity victim = event.getEntity();
        Entity killer = victim.getKiller();
        if (killer instanceof Player) {
            Player killerP = event.getEntity().getKiller().getPlayer();
            String nick = killerP.getName();
            double XP = CCPlayerInfo.get().getDouble(nick + ".XP");
            int XPN = CCPlayerInfo.get().getInt(nick + ".XPNeeded");
            int levelP = CCPlayerInfo.get().getInt(nick+".Level");
            double MXP = CCPlayerInfo.get().getDouble(nick+".MXP");
            double XPG = 0;


            if (victim instanceof Monster) {
                cooldown =2;
                coolrem=0;
                if(victim.getCustomName()!=null){
                    String VName = victim.getCustomName();
                    char[] vnch = VName.toCharArray();
                    boolean found = false;
                    String levelS = "";
                    List cints = new ArrayList<>();
                    cints.add('1');
                    cints.add('2');
                    cints.add('3');
                    cints.add('4');
                    cints.add('5');
                    cints.add('6');
                    cints.add('7');
                    cints.add('8');
                    cints.add('9');

                    //ž6[ž4LVL.150
                    if(cints.contains(vnch[10])){
                        if(cints.contains(vnch[11])){
                            levelS = Character.toString(vnch[9])+Character.toString(vnch[10])+Character.toString(vnch[11]);
                        }else{
                            levelS = Character.toString(vnch[9])+Character.toString(vnch[10]);
                        }
                    }else{
                        levelS = Character.toString(vnch[9]);
                    }

                    XPG= 0.1;
                    if(levelS!=""){
                        int level = Integer.parseInt(levelS);
                        XPG = level*0.25;
                    }


                double FXP = XPG*MXP+XP;

                CCPlayerInfo.get().set(nick+".XP",FXP);
                CCPlayerInfo.save();
                int XPP = (int) (FXP-XPN);
                if(FXP>XPN){
                    CCPlayerInfo.get().set(nick+".Level",levelP+1);
                    CCPlayerInfo.get().set(nick+".XP",0+XPP);
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
                }







                    CCPlayerInfo.save();
            }else{
                    XPG= 0.2;
                    double FXP = XPG*MXP+XP;

                    CCPlayerInfo.get().set(nick+".XP",FXP);
                    CCPlayerInfo.save();
                    int XPP = (int) (FXP-XPN);
                    if(FXP>XPN){
                        CCPlayerInfo.get().set(nick+".Level",levelP+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XPP);
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
                    }
                }

                double finalXPG = XPG;
                if(CCPlayerInfo.get().getBoolean(nick+".LevelBars")==true){
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            HashMap <Player, BossBar>bossBM = (HashMap<Player, BossBar>) bossBarMap;
                            int Level = CCPlayerInfo.get().getInt(nick + ".Level");
                            double XP = CCPlayerInfo.get().getDouble(nick + ".XP");
                            int XPN = CCPlayerInfo.get().getInt(nick + ".XPNeeded");
                            BossBar levelbar = Bukkit.createBossBar(color("&6&lLEVEL " + Level + " " + df.format(XP) + "&6&lXP"+"(+"+ finalXPG +")" + "&6&l/" + XPN + "&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                            if(!(coolrem>=cooldown)){
                                if(bossBM.containsKey(killerP)){
                                    bossBM.get(killerP).removePlayer(killerP);
                                    levelbar.removePlayer(killerP);
                                }

                                bossBM.put(killerP,levelbar);
                                levelbar.addPlayer(killerP);
                                coolrem++;
                            }else{
                                levelbar.removePlayer(killerP);
                                bossBM.get(killerP).removePlayer(killerP);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin,0,20);
                }

        }
    }
}
}
