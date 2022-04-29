package me.dioforever.rpg.Skills;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;

public class IncompleteFireDragonsSkin implements Listener {
    static Main plugin;


    public IncompleteFireDragonsSkin(Main main){
        plugin = main;
    }

    @EventHandler
    public void onfireDamage(EntityDamageEvent e){
            if(e.getEntity() instanceof Player) {
                if(e.getCause()== EntityDamageEvent.DamageCause.FIRE_TICK){
                Player p = ((Player) e.getEntity()).getPlayer();
                String nick = p.getName();
                List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                if(skills.contains("Incomplete Fire Dragon's Scales")){
                    //add it to SkillsActivatedTemp
                    // nick - List(Skills)
                    List<String> skillsAT = new ArrayList<>();
                    Map<String,List> SkillsActivatedTemp = new HashMap<>();
                    if(Main.getSkillsActivatedTemp()!=null){
                        SkillsActivatedTemp = Main.getSkillsActivatedTemp();
                        if(SkillsActivatedTemp.get(nick)!=null){
                            skillsAT = SkillsActivatedTemp.get(nick);
                        }
                    }

                    // nick - Map(skill - seconds)
                    Map <String,HashMap> SkillsCooldownT= new HashMap<>();
                    if(Main.getSkillsCooldown()!=null){
                        SkillsCooldownT = Main.getSkillsCooldownT();
                    }

                     int cooldown = 35;
                    String cooldownS = "";
                    boolean work = true;
                    HashMap skillscooldownPlayer = new HashMap<>();
                    //check if player has any skill on
                    if(SkillsCooldownT.get(nick)!=null){
                        //player has any skill on indeed
                        skillscooldownPlayer=SkillsCooldownT.get(nick);
                        //Check if the skill already has the skill on
                        if(skillscooldownPlayer.containsKey("Incomplete Fire Dragon's Scales")){
                            //Does have the skill on, so get the cooldown
                                cooldown = (int) skillscooldownPlayer.get("Incomplete Fire Dragon's Scales");

                        }//Player does not have activated the skill, so dont care about the cooldown, set the new one

                    }//Player doesnt have any skill on, so we will dont get the already created variables


                    //At first run do everything

                    //Check if the skill was already created, if was check the cooldown
                        if(!skillscooldownPlayer.containsKey("Incomplete Fire Dragon's Scales")){
                            //wasnt already used, so create it
                            p.sendMessage("Incomplete Fire Dragon's Scales creating");
                            skillscooldownPlayer.put("Incomplete Fire Dragon's Scales",35);
                            SkillsCooldownT.put(nick,skillscooldownPlayer);
                            Main.setSkillsCooldownT(SkillsCooldownT);
                            //Put it in the temp skills list
                            skillsAT.add("Incomplete Fire Dragon's Scales");
                            SkillsActivatedTemp.put(nick,skillsAT);
                            Main.setSkillsActivatedTemp(SkillsActivatedTemp);

                            p.sendMessage(color("&c&l[RPG]&r&c Skill Incomplete Fire Dragon's Scales has taken effect!"));

                            //Now create the runnable
                            new BukkitRunnable() {
                                int i = 40;
                                @Override
                                public void run() {
                                    i--;
                                    i--;
                                    i--;
                                    i--;
                                    i--;
                                    //Now set the cooldown less

                                    int cooldown1 = 35;
                                    HashMap skillscooldownPlayer1 = new HashMap<>();
                                    // nick - Map(skill - seconds)
                                    Map <String,HashMap> SkillsCooldownT1= new HashMap<>();
                                    if(Main.getSkillsCooldown()!=null){
                                        SkillsCooldownT1 = Main.getSkillsCooldownT();
                                    }
                                    //check if player has any skill on
                                    if(SkillsCooldownT1.get(nick)!=null){
                                        //player has any skill on indeed
                                        skillscooldownPlayer1=SkillsCooldownT1.get(nick);
                                        //Check if the skill already has the skill on
                                        if(skillscooldownPlayer1.containsKey("Incomplete Fire Dragon's Scales")){
                                            //Does have the skill on, so get the cooldown
                                            cooldown1 = (int) skillscooldownPlayer1.get("Incomplete Fire Dragon's Scales");

                                        }//Player does not have activated the skill, so dont care about the cooldown, set the new one

                                    }//Player doesnt have any skill on, so we will dont get the already created variables

                                    List<String> skillsAT1 = new ArrayList<>();
                                    Map<String,List> SkillsActivatedTemp1 = new HashMap<>();
                                    if(Main.getSkillsActivatedTemp()!=null){
                                        SkillsActivatedTemp1 = Main.getSkillsActivatedTemp();
                                        if(SkillsActivatedTemp1.get(nick)!=null){
                                            skillsAT1 = SkillsActivatedTemp1.get(nick);
                                        }
                                    }


                                    //if specific time left, inform player and or end this
                                    if(i==30){
                                        p.sendMessage(color("&c&l[RPG]&r&c Skill Incomplete Fire Dragon's Scales's cooldown has started!"));
                                    }
                                    if(i==0){
                                        //Inform player
                                        p.sendMessage(color("&c&l[RPG]&r&c Skill Incomplete Fire Dragon's Scales's cooldown has ended!"));
                                        //Remove the Cooldown
                                        skillscooldownPlayer1.remove("Incomplete Fire Dragon's Scales");
                                        SkillsCooldownT1.put(nick,skillscooldownPlayer1);
                                        Main.setSkillsCooldownT(SkillsCooldownT1);
                                        //Remove the Skill
                                        skillsAT1.remove("Incomplete Fire Dragon's Scales");
                                        SkillsActivatedTemp1.put(nick,skillsAT1);
                                        Main.setSkillsActivatedTemp(SkillsActivatedTemp1);

                                        //Cancel the runnable
                                        this.cancel();
                                    }else{
                                        //Now change the cooldown
                                        cooldown1=i;
                                        skillscooldownPlayer1.put("Incomplete Fire Dragon's Scales",cooldown1);
                                        SkillsCooldownT1.put(nick,skillscooldownPlayer1);
                                        Main.setSkillsCooldownT(SkillsCooldownT1);
                                    }

                                }
                                //Repeat this task every 5 seconds
                            }.runTaskTimer(plugin,0,20*5);
                        }
                    //if cooldown bigger than 30, then nullify the dmg
                    if(cooldown>30){
                        e.setDamage(0);
                    }
                }
            }
        }
    }
}
