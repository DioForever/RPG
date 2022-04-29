package me.dioforever.rpg.Leveling;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.HashMap;

import static me.dioforever.rpg.Utils.color;


public class FishingListener implements Listener {
    static Main plugin;
    private int cooldown;
    private int coolrem;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public FishingListener(Main main){
        plugin = main;
    }
    @EventHandler
    public void onFishing(PlayerFishEvent e){
        if(e.getCaught()!=null){
            cooldown =2;
            coolrem=0;
            Player p = e.getPlayer();
            String nick = p.getName();
            double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
            double XP = CCPlayerInfo.get().getDouble(nick+".XP");
            int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
            int levelP = CCPlayerInfo.get().getInt(nick+".Level");
            if(XP+0.1>=XPN){
                CCPlayerInfo.get().set(nick+".Level",levelP+1);
                CCPlayerInfo.get().set(nick+".XP",0.1*2+XP);
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
                CCPlayerInfo.get().set(nick+".XP",XP+0.1*2);
                CCPlayerInfo.save();
            }
            double xp=0.1*2;
            if(CCPlayerInfo.get().getBoolean(nick+".LevelBars")==true){
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        HashMap<Player, BossBar> bossBM = (HashMap<Player, BossBar>) KillEntityListener.bossBarMap;
                        int Level = CCPlayerInfo.get().getInt(nick + ".Level");
                        double XP = CCPlayerInfo.get().getDouble(nick + ".XP");
                        int XPN = CCPlayerInfo.get().getInt(nick + ".XPNeeded");
                        BossBar levelbar = Bukkit.createBossBar(color("&6&lLEVEL " + Level + " " + df.format(XP) + "&6&lXP"+"(+"+xp+")" + "&6&l/" + XPN + "&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);

                        if(!(coolrem>=cooldown)){
                            if(bossBM.containsKey(p)){
                                bossBM.get(p).removePlayer(p);
                                levelbar.removePlayer(p);
                            }

                            bossBM.put(p,levelbar);
                            levelbar.addPlayer(p);
                            coolrem++;
                        }else{
                            levelbar.removePlayer(p);
                            bossBM.get(p).removePlayer(p);
                            this.cancel();
                        }
                    }
                }.runTaskTimer(plugin,0,20);
            }
        }

    }
}
