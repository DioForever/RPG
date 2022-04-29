package me.dioforever.rpg.Skills;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.StatWork.DamageListener;
import me.dioforever.rpg.files.CCLeft;
import me.dioforever.rpg.files.CCOn;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static me.dioforever.rpg.Utils.color;
import static org.bukkit.loot.LootTables.WOLF;

public class FriendofNature implements Listener {
    static Main plugin;

    public FriendofNature(Main main){
        plugin = main;
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e) throws InterruptedException {
        if(e.getEntity() instanceof Player){
            Player p = ((Player) e.getEntity()).getPlayer();
            String nick = p.getName();
            List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
            List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
            List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
            List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");

            if(skills.contains("Friend of Nature")){
                double percent = CCLeft.get().getInt(nick+".MAXHP")*0.2;
                int hp = CCLeft.get().getInt(nick+".HP");
                List skillss = new ArrayList<>();
                if(Main.getSkillsActivatedTemp().get(nick)!=null){
                    skillss=Main.getSkillsActivatedTemp().get(nick);
                }

                if(hp-e.getDamage()*5<=percent && !skillss.contains("Friend of Nature")){
                    for(int i = 0; i<2;i++){
                        Wolf Direwolf1 = p.getWorld().spawn(p.getLocation(), Wolf.class);
                        Direwolf1.setCustomName(color("&a&l[LVL.3] Dire Wolf [" + p.getName()+"]"));
                        Direwolf1.setTamed(true);
                        Direwolf1.setOwner(p);
                        Direwolf1.setMaxHealth(40+1);
                        Direwolf1.setHealth(40+1);
                    }

                    // nick - List(Skills)
                    Map<String,List> SkillsActivatedTemp = new HashMap<>();
                    if(Main.getSkillsActivatedTemp()!=null){
                        SkillsActivatedTemp = Main.getSkillsActivatedTemp();
                    }
                    //Add this to the skills on Temporary
                    List skillsAT = new ArrayList<>();
                    if(SkillsActivatedTemp.get(nick)!=null){
                        skillsAT=SkillsActivatedTemp.get(nick);
                    }
                    skillsAT.add("Friend of Nature");
                    SkillsActivatedTemp.put(nick,skillsAT);
                    Main.setSkillsActivatedTemp(SkillsActivatedTemp);

                    p.sendMessage(color("&a&l(!) Skill Friend of Nature has taken effect!"));

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            for (Entity DireWolf : p.getWorld().getEntities()) {
                                if (DireWolf.getName().equalsIgnoreCase(color("&a&l[LVL.3] Dire Wolf [" + p.getName()+"]"))) {
                                    DireWolf.remove();



                                }
                            }
                            p.sendMessage(color("&a&l(!) Skill Friend of Nature has taken effect!"));
                            p.sendMessage(color("&a&l(!) Skill Friend of Nature's cooldown of 5 minutes started!"));
                        }
                    }, 20*30L); //20 Tick (1 Second) delay before run() is called
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {

                            // nick - List(Skills)
                            Map<String,List> SkillsActivatedTemp1 = new HashMap<>();
                            if(Main.getSkillsActivatedTemp()!=null){
                                SkillsActivatedTemp1 = Main.getSkillsActivatedTemp();
                            }
                            //Remove this from the skills on Temporary
                            List skillsAT1 = new ArrayList<>();
                            if(SkillsActivatedTemp1.get(nick)!=null){
                                skillsAT1=SkillsActivatedTemp1.get(nick);
                            }
                            skillsAT1.remove("Friend of Nature");
                            SkillsActivatedTemp1.put(nick,skillsAT1);
                            Main.setSkillsActivatedTemp(SkillsActivatedTemp1);
                            p.sendMessage(color("&a&l(!)Skill Friend of Nature's cooldown has ended!"));
                        }
                    }, 20*330L); //20 Tick (1 Second) delay before run() is called






                }
            }
        }
    }

}
