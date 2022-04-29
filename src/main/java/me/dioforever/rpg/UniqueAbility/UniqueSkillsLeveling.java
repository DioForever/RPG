package me.dioforever.rpg.UniqueAbility;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.dioforever.rpg.Utils.color;


public class UniqueSkillsLeveling implements Listener {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    static Main plugin;
    private int cooldown;
    private int coolrem;
    public static Map<Player, BossBar> ProfBarMap = new HashMap<>();

    public UniqueSkillsLeveling(Main main) {
        plugin = main;
    }

    //Reinforcement I,II,III and Tank II USC Leveling
    @EventHandler
    public void onGetDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = ((Player) e.getEntity()).getPlayer();
            String nick = p.getName();
            String UniqueSkillClass = CCPlayerInfo.get().getString(nick + ".Class.Unique");
            if (e.getDamage() >= 6) {
                if (UniqueSkillClass.contains("Reinforcer")) {
                    if (UniqueSkillClass.equals("Reinforcer I")) {
                        List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                        List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                        List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                        List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                        int index = skills.indexOf("Hard as Rock");
                        String rank = (String) Ranks.get(index);
                        int curProf = (int) curProfL.get(index);
                        int nedProf = (int) nedProfL.get(index);
                        curProf += 400;
                        curProfL.set(index, curProf);
                        System.out.println(curProfL.get(index));
                        if (curProf + 400 >= nedProf) {
                            switch (rank) {
                                case "F":
                                    nedProfL.set(index, 500);
                                    Ranks.set(index, "E");
                                    break;
                                case "E":
                                    nedProfL.set(index, 1000);
                                    Ranks.set(index, "D");
                                    break;
                                case "D":
                                    nedProfL.set(index, 2000);
                                    Ranks.set(index, "C");
                                    break;
                                case "C":
                                    //NEW UNIQUE SKILL
                                    if (true) {
                                        //Epic Skills
                                        List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                                        List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                        List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                        List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                        List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                        List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                                        EpSkills.add("Hard as Iron");
                                        EpType.add("PASSIVE");
                                        EpRanks.add("C");
                                        //have to get to E to get to Hard as Rock
                                        EpProfHave.add(curProf);
                                        EpProfNeed.add(3000);
                                        EpDesc.add(4);
                                        EpDesc.add("This skill makes you as hard as Iron,");
                                        EpDesc.add("but for it to work you have to");
                                        EpDesc.add("eat Iron Ingots to regain your durability");
                                        EpDesc.add("and durability is taken from dmg (dmg*0,2)");


                                        CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                        CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                        CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                        CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                        CCPlayerInfo.get().set(nick + ".Class.Unique", "Reinforcer II");
                                        CCPlayerInfo.save();
                                        CCSkills.save();


                                        if (CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Hard as Rock")) {

                                            List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                            List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                            List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                            List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                            List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                            List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");

                                            int i = RarSkills.indexOf("Hard as Rock");
                                            for (int j = 0; j < RarDesc.size(); j++) {
                                                if (RarDesc.get(j) == "and durability is taken from dmg (dmg*0,3)") {
                                                    RarDesc.remove(j);
                                                    RarDesc.remove(j - 1);
                                                    RarDesc.remove(j - 2);
                                                    RarDesc.remove(j - 3);
                                                    RarDesc.remove(j - 4);
                                                }
                                            }
                                            RarSkills.remove(i);
                                            RarRanks.remove(i);
                                            RarProfHave.remove(i);
                                            RarProfNeed.remove(i);
                                            RarType.remove(i);


                                            CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                            CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                            CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                            CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                            CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                            CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                            CCSkills.save();
                                        }

                                    }

                                    break;
                            }
                        } else {
                            CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", curProfL);
                            CCSkills.save();
                        }
                        //Show Proeficency bar if 1% or 10% or 20% of another level
                        cooldown = 2;
                        coolrem = 0;
                        int finalCurProf = curProf;
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Hard as Rock " + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);
                                if (!(coolrem >= cooldown)) {
                                    if (ProfBarMap.containsKey(p)) {
                                        ProfBarMap.get(p).removePlayer(p);
                                        levelbar.removePlayer(p);
                                    }

                                    ProfBarMap.put(p, levelbar);
                                    levelbar.addPlayer(p);
                                    coolrem++;
                                } else {
                                    levelbar.removePlayer(p);
                                    ProfBarMap.get(p).removePlayer(p);
                                    this.cancel();
                                }
                            }
                        }.runTaskTimer(plugin, 0, 40);
                        //End of Proeficency
                    }

                } else if (UniqueSkillClass.contains("Tank")) {

                }
            }
            if (e.getDamage() >= 12) {
                if (UniqueSkillClass.equals("Reinforcer II")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                    List skills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                    int index = skills.indexOf("Hard as Iron");
                    String rank = (String) Ranks.get(index);
                    int curProf = (int) curProfL.get(index);
                    int nedProf = (int) nedProfL.get(index);
                    curProf += 400;
                    curProfL.set(index, curProf);
                    System.out.println(curProfL.get(index));
                    if (nedProf != 0) {
                        curProf += 400;
                        if (curProf + 400 >= nedProf) {
                            switch (rank) {
                                case "C":
                                    nedProfL.set(index, 3000);
                                    Ranks.set(index, "B");
                                    break;
                                case "B":
                                    nedProfL.set(index, 4000);
                                    Ranks.set(index, "A");
                                    break;
                                case "A":
                                    nedProfL.set(index, 8000);
                                    Ranks.set(index, "S");
                                    List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                                    List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                                    List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                                    List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                                    List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                                    List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                                    LegSkills.add("Hard as Diamond");
                                    LegType.add("PASSIVE");
                                    LegRanks.add("S");
                                    //have to get to E to get to Hard as Rock
                                    LegProfHave.add(curProf);
                                    LegProfNeed.add(8000);
                                    LegDesc.add(4);
                                    LegDesc.add("This skill makes you as hard as diamond,");
                                    LegDesc.add("but for it to work you have to");
                                    LegDesc.add("eat diamonds to regain your durability");
                                    LegDesc.add("and durability is taken from dmg (dmg*0,1)");


                                    CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                                    CCPlayerInfo.get().set(nick + ".Class.Unique", "Reinforcer III");
                                    CCPlayerInfo.save();
                                    CCSkills.save();

                                    if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Hard as Iron")) {

                                        //Epic Skills
                                        List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                                        List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                        List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                        List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                        List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                        List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");

                                        int i = EpSkills.indexOf("Hard as Iron");
                                        for (int j = 0; j < EpDesc.size(); j++) {
                                            if (EpDesc.get(j) == "and durability is taken from dmg (dmg*0,3)") {
                                                EpDesc.remove(j);
                                                EpDesc.remove(j - 1);
                                                EpDesc.remove(j - 2);
                                                EpDesc.remove(j - 3);
                                                EpDesc.remove(j - 4);
                                            }
                                        }
                                        EpSkills.remove(i);
                                        EpRanks.remove(i);
                                        EpProfHave.remove(i);
                                        EpProfNeed.remove(i);
                                        EpType.remove(i);


                                        CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                        CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                        CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                        CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                        CCSkills.save();
                                    }
                            }


                        } else {
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", curProfL);
                            CCSkills.save();
                        }
                    }
                    //Show Proeficency bar if 1% or 10% or 20% of another level
                    cooldown = 2;
                    coolrem = 0;
                    int finalCurProf = curProf;
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Hard as Iron - " + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);
                            if (!(coolrem >= cooldown)) {
                                if (ProfBarMap.containsKey(p)) {
                                    ProfBarMap.get(p).removePlayer(p);
                                    levelbar.removePlayer(p);
                                }

                                ProfBarMap.put(p, levelbar);
                                levelbar.addPlayer(p);
                                coolrem++;
                            } else {
                                levelbar.removePlayer(p);
                                ProfBarMap.get(p).removePlayer(p);
                                this.cancel();
                            }

                        }
                    }.runTaskTimer(plugin, 0, 40);
                    //End of Proeficency

                } else if (UniqueSkillClass.equals("Tank II")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                    List skills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                    int index = skills.indexOf("Wall of Stone");
                    String rank = (String) Ranks.get(index);
                    int curProf = (int) curProfL.get(index);
                    int nedProf = (int) nedProfL.get(index);
                    curProf += 5;
                    curProfL.set(index, curProf);
                    System.out.println(curProfL.get(index));
                    curProf += 5;
                    if (curProf + 5 >= nedProf) {
                        switch (rank) {
                            case "F":
                                nedProfL.set(index, 1000);
                                Ranks.set(index, "B");
                                break;
                            case "E":
                                nedProfL.set(index, 2000);
                                Ranks.set(index, "A");
                                break;
                            case "D":
                                if (true) {
                                    //Epic Skills
                                    List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                                    List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                    List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                    List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                    List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                    List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                                    EpSkills.add("Wall of Stone");
                                    EpType.add("ACTIVE");
                                    EpRanks.add("C");
                                    //have to get to E to get to Hard as Rock
                                    EpProfHave.add(1);
                                    EpProfNeed.add(3000);
                                    EpDesc.add(5);
                                    EpDesc.add("This skill makes invulnerable, but");
                                    EpDesc.add("as a side effect you have Slowness III");
                                    EpDesc.add("this skill longs 10seconds");
                                    EpDesc.add("and you can heal and deal damage while its");
                                    EpDesc.add("in effect");


                                    CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                    CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                    CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                    CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                    CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                    CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                    CCSkills.save();
                                }
                                break;

                        }
                    } else {
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", curProfL);
                        CCSkills.save();
                    }
                    //Show Proeficency bar if 1% or 10% or 20% of another level
                    cooldown = 2;
                    coolrem = 0;
                    int finalCurProf = curProf;
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Hard as Iron - " + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);

                            if (!(coolrem >= cooldown)) {
                                if (ProfBarMap.containsKey(p)) {
                                    ProfBarMap.get(p).removePlayer(p);
                                    levelbar.removePlayer(p);
                                }

                                ProfBarMap.put(p, levelbar);
                                levelbar.addPlayer(p);
                                coolrem++;
                            } else {
                                levelbar.removePlayer(p);
                                ProfBarMap.get(p).removePlayer(p);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 40);
                    //End of Proeficency
                }


            }
            if (e.getDamage() >= 20) {
                if (UniqueSkillClass.equals("Reinforcer III")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                    List skills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                    int index = skills.indexOf("Hard as Diamond");
                    String rank = (String) Ranks.get(index);
                    int curProf = (int) curProfL.get(index);
                    int nedProf = (int) nedProfL.get(index);
                    if (nedProf != 0) {
                        curProf += 400;
                        curProfL.set(index, curProf);
                        System.out.println(curProfL.get(index));
                        curProf += 400;
                        if (curProf + 400 >= nedProf) {
                            switch (rank) {
                                case "S":
                                    nedProfL.set(index, 10000);
                                    Ranks.set(index, "SS");
                                    break;
                                case "SS":
                                    curProfL.set(index, 0);
                                    nedProfL.set(index, 0);
                                    Ranks.set(index, "SSS");
                                    break;

                            }
                        } else {
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", curProfL);
                            CCSkills.save();
                        }
                    }


                    //Show Proeficency bar if 1% or 10% or 20% of another level
                    cooldown = 2;
                    coolrem = 0;
                    int finalCurProf = curProf;
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Hard as Diamond - " + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);

                            if (!(coolrem >= cooldown)) {
                                if (ProfBarMap.containsKey(p)) {
                                    ProfBarMap.get(p).removePlayer(p);
                                    levelbar.removePlayer(p);
                                }

                                ProfBarMap.put(p, levelbar);
                                levelbar.addPlayer(p);
                                coolrem++;
                            } else {
                                levelbar.removePlayer(p);
                                ProfBarMap.get(p).removePlayer(p);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 40);
                    //End of Proeficency
                }


            }

        }
    }
    //Blood Thief I,II,III
    @EventHandler
    public void onKillEntity(EntityDeathEvent e) {
        LivingEntity victim = e.getEntity();
        Entity killer = victim.getKiller();
        if (killer instanceof Player) {
            Player killerP = e.getEntity().getKiller().getPlayer();
            String nick = killerP.getName();
            String UniqueClass = CCPlayerInfo.get().getString(nick + ".Class.Unique");
            if (UniqueClass.contains("Blood Thief")) {
                if (UniqueClass.equals("Blood Thief I")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                    List skills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                    int index = skills.indexOf("Life Steal");
                    String rank = (String) Ranks.get(index);
                    int curProf = (int) curProfL.get(index);
                    int nedProf = (int) nedProfL.get(index);
                    System.out.println(curProf+400);
                    curProf += 400;
                    System.out.println(curProf);
                    switch (rank) {
                        case "F":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 1000);
                                Ranks.set(index, "E");
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need",nedProfL);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank",Ranks);
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                            }
                            break;
                        case "E":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 2000);
                                Ranks.set(index, "D");
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need",nedProfL);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank",Ranks);
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                            }
                            break;
                        case "D":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 3000);
                                Ranks.set(index, "C");
                                if (!CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Blood Domain")) {
                                    if (true) {
                                        //Epic Skills
                                        List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                                        List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                        List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                        List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                        List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                        List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                                        EpSkills.add("Blood Domain");
                                        EpType.add("PASSIVE");
                                        EpRanks.add("C");
                                        //have to get to E to get to Hard as Rock
                                        EpProfHave.add(1);
                                        EpProfNeed.add(3000);
                                        EpDesc.add(5);
                                        EpDesc.add("This skill heals you when someone");
                                        EpDesc.add("dies within 10 blocks from you by 50% of");
                                        EpDesc.add("the enemies max health, however you cant");
                                        EpDesc.add("be overhealed");
                                        EpDesc.add("Cooldown 30 sec");


                                        CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                        CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                        CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                        CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                        CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                        CCPlayerInfo.get().set(nick + ".Class.Unique", "Blood Thief II");
                                        CCPlayerInfo.save();
                                        CCSkills.save();
                                    }
                                }
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                            }
                            break;
                        //At Rank C the new Unique Skill will be unlocked
                    }
                    CCSkills.save();
                    CCPlayerInfo.save();
                    //Show Proeficency bar if 1% or 10% or 20% of another level
                    cooldown = 2;
                    coolrem = 0;
                    int finalCurProf = curProf;
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Life Steal - " + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);
                            if (!(coolrem >= cooldown)) {
                                if (ProfBarMap.containsKey(killerP)) {
                                    ProfBarMap.get(killerP).removePlayer(killerP);
                                    levelbar.removePlayer(killerP);
                                }

                                ProfBarMap.put(killerP, levelbar);
                                levelbar.addPlayer(killerP);
                                coolrem++;
                            } else {
                                levelbar.removePlayer(killerP);
                                ProfBarMap.get(killerP).removePlayer(killerP);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 40);
                    //End of Proeficency

                } else if (UniqueClass.equals("Blood Thief II")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                    List skills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                    int index = skills.indexOf("Blood Domain");
                    String rank = (String) Ranks.get(index);
                    int curProf = (int) curProfL.get(index);
                    int nedProf = (int) nedProfL.get(index);
                    curProf += 400;
                    switch (rank) {
                        case "C":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 4000);
                                Ranks.set(index, "B");
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have",curProfL);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need",nedProfL);
                                CCSkills.get().set(nick + ".Skills.Epic.Rank",Ranks);
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have",curProfL);
                            }
                            break;
                        case "B":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 5000);
                                Ranks.set(index, "A");
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have",curProfL);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need",nedProfL);
                                CCSkills.get().set(nick + ".Skills.Epic.Rank",Ranks);
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have",curProfL);
                            }
                            break;
                        case "A":
                            if (curProf + 400 >= nedProf) {
                                curProfL.set(index,curProf);
                                nedProfL.set(index, 6000);
                                Ranks.set(index, "S");
                                if (!CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Blood Explosion")) {
                                    //Epic Skills
                                    List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                                    List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                                    List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                                    List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                                    List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                                    List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                                    LegSkills.add("Blood Explosion");
                                    LegType.add("ACTIVE");
                                    LegRanks.add("S");
                                    //have to get to E to get to Hard as Rock
                                    LegProfHave.add(1);
                                    LegProfNeed.add(6000);
                                    LegDesc.add(5);
                                    LegDesc.add("This skill deals accumulated damage*0.3");
                                    LegDesc.add("in last 15 seconds upon activation");
                                    LegDesc.add("once you activate for the second time");
                                    LegDesc.add("the accumulated damage will be dealt");
                                    LegDesc.add("Cooldown 2 min after second activation");


                                    CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                                    CCPlayerInfo.get().set(nick + ".Class.Unique", "Blood Thief III");
                                    CCPlayerInfo.save();
                                    CCSkills.save();
                                }
                            }else{
                                curProfL.set(index,curProf);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have",curProfL);
                            }
                            break;
                        //At Rank S the new Unique Skill will be unlocked
                    }
                    CCSkills.save();
                    CCPlayerInfo.save();
                    //Show Proeficency bar if 1% or 10% or 20% of another level
                    cooldown = 2;
                    coolrem = 0;
                    int finalCurProf = curProf;
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Blood Domain -" + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);
                            if (!(coolrem >= cooldown)) {
                                if (ProfBarMap.containsKey(killerP)) {
                                    ProfBarMap.get(killerP).removePlayer(killerP);
                                    levelbar.removePlayer(killerP);
                                }

                                ProfBarMap.put(killerP, levelbar);
                                levelbar.addPlayer(killerP);
                                coolrem++;
                            } else {
                                levelbar.removePlayer(killerP);
                                ProfBarMap.get(killerP).removePlayer(killerP);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 40);
                    //End of Proeficency
                } else if (UniqueClass.equals("Blood Thief III")) {
                    List curProfL = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                    List nedProfL = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                    List Ranks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                    List skills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                    int index = skills.indexOf("Blood Explosion");
                    String rank = (String) Ranks.get(index);
                    if (rank != "SSS") {
                        int curProf = (int) curProfL.get(index);
                        int nedProf = (int) nedProfL.get(index);
                        curProf += 400;
                        switch (rank) {
                            case "S":
                                if (curProf + 400 >= nedProf) {
                                    curProfL.set(index,curProf);
                                    nedProfL.set(index, 10000);
                                    Ranks.set(index, "SS");
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have",curProfL);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need",nedProfL);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Rank",Ranks);
                                }
                                break;
                            case "SS":
                                if (curProf + 400 >= nedProf) {
                                    curProfL.set(index,curProf);
                                    curProfL.set(index, 0);
                                    nedProfL.set(index, 0);
                                    Ranks.set(index, "SSS");
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have",curProfL);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need",nedProfL);
                                    CCSkills.get().set(nick + ".Skills.Legendary.Rank",Ranks);
                                }
                                break;
                        }

                        CCSkills.save();
                        CCPlayerInfo.save();
                        //Show Proeficency bar if 1% or 10% or 20% of another level
                        cooldown = 2;
                        coolrem = 0;
                        int finalCurProf = curProf;
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                BossBar levelbar = Bukkit.createBossBar(color("&5&l" + "Blood Explosion -" + "Rank: " + rank + " " + finalCurProf + "&5&lPF" + "&5&l/" + nedProf + "&5&lPF"), BarColor.PURPLE, BarStyle.SOLID);
                                if (!(coolrem >= cooldown)) {
                                    if (ProfBarMap.containsKey(killerP)) {
                                        ProfBarMap.get(killerP).removePlayer(killerP);
                                        levelbar.removePlayer(killerP);
                                    }

                                    ProfBarMap.put(killerP, levelbar);
                                    levelbar.addPlayer(killerP);
                                    coolrem++;
                                } else {
                                    levelbar.removePlayer(killerP);
                                    ProfBarMap.get(killerP).removePlayer(killerP);
                                    this.cancel();
                                }
                            }
                        }.runTaskTimer(plugin, 0, 40);
                        //End of Proeficency
                    }

                }
            }

        }
    }
}
