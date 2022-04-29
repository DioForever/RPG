package me.dioforever.rpg.UniqueAbility;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class UniqueAbilityWork implements Listener {

    public static ArrayList playersI;
    static Main plugin;

    int taskID;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String nick = p.getName();
        String UniqueAbility = CCPlayerInfo.get().getString(nick+".Class.Unique");
        //Reinforcement
        if(UniqueAbility!=null){
            if (UniqueAbility.contains("Reinforcer")) {
                if (true) {
                    if (UniqueAbility.equals("Reinforcer I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Hard as Rock")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Hard as Rock");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill makes you as hard as rock,");
                                RarDesc.add("but for it to work you have to");
                                RarDesc.add("eat cobblestone to regain your durability");
                                RarDesc.add("and durability is taken from dmg (dmg*0,3)");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Reinforcer II")) {


                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            if (!EpSkills.contains("Hard as Iron")) {
                                List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                                EpSkills.add("Hard as Iron");
                                EpType.add("PASSIVE");
                                EpRanks.add("C");
                                //have to get to E to get to Hard as Rock
                                EpProfHave.add(1);
                                EpProfNeed.add(2000);
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

                        }

                    } else if (UniqueAbility.equals("Reinforcer III")) {
                        if (CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Hard as Diamond")) {
                            return;
                        }
                        //Leg Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        if (!LegSkills.contains("Hard as Diamond")) {
                            List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                            List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                            List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                            List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                            List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                            LegSkills.add("Hard as Diamond");
                            LegType.add("PASSIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
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
                                    if (EpDesc.get(j) == "and durability is taken from dmg (dmg*0,2)") {
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

                    }
                }
            } else if (UniqueAbility.contains("Lucker")) {
                if (true){
                    if (UniqueAbility.equals("Lucker I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Lucky Coin")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Lucky Coin");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(12);
                                RarDesc.add("This skill allows you to craft,");
                                RarDesc.add("Lucky coins, that have a chance to");
                                RarDesc.add("multiple random stat by 1.25x for 2min");
                                RarDesc.add("however, upon failure random stat is");
                                RarDesc.add("changed to 0.85% for 20sec");
                                RarDesc.add("Chance is 5% + Luck_Stat*0.5 max=80%");
                                RarDesc.add("x = Emerald and + = Gold Ingot");
                                RarDesc.add("x x x");
                                RarDesc.add("x + x");
                                RarDesc.add("x x x");
                                RarDesc.add("Lucky coin  is craft-able in");
                                RarDesc.add("crafting bench - [Rare]");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Lucker II")) {



                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            if (!EpSkills.contains("Lucky Coin")) {
                                List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                                EpSkills.add("Lucky Coin");
                                EpType.add("PASSIVE");
                                EpRanks.add("A");
                                //have to get to E to get to Hard as Rock
                                EpProfHave.add(1);
                                EpProfNeed.add(2000);
                                EpDesc.add(12);
                                EpDesc.add("This skill allows you to craft,");
                                EpDesc.add("Lucky coins, that have a chance to");
                                EpDesc.add("multiple random stat by 1.25x for 2min");
                                EpDesc.add("However, upon failure random stat is");
                                EpDesc.add("changed to 0.85% for 20sec");
                                EpDesc.add("Chance is + Luck_Stat*0.5 max = 80%");
                                EpDesc.add("x = Emerald and + = Gold Ingot");
                                EpDesc.add("x x x");
                                EpDesc.add("x + x");
                                EpDesc.add("x x x");
                                EpDesc.add("Lucky coin [Epic] is craft-able in");
                                EpDesc.add("crafting bench - [Epic]");


                                CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                CCSkills.save();


                                if (CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Lucky Coin")) {

                                    List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                    List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                    List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                    List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                    List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                    List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");

                                    int i = RarSkills.indexOf("Lucky Coin");
                                    for (int j = 0; j < RarDesc.size(); j++) {
                                        if (RarDesc.get(j) == "crafting bench - [Rare]") {
                                            RarDesc.remove(j);
                                            RarDesc.remove(j - 1);
                                            RarDesc.remove(j - 2);
                                            RarDesc.remove(j - 3);
                                            RarDesc.remove(j - 4);
                                            RarDesc.remove(j - 5);
                                            RarDesc.remove(j - 6);
                                            RarDesc.remove(j - 7);
                                            RarDesc.remove(j - 8);
                                            RarDesc.remove(j - 9);
                                            RarDesc.remove(j - 10);
                                            RarDesc.remove(j - 11);
                                            RarDesc.remove(j - 12);
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

                        }

                    } else if (UniqueAbility.equals("Lucker III")) {
                        if (CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Critical Luck")) {
                            return;
                        }
                        //Leg Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");



                        LegSkills.add("Critical Luck");
                        LegType.add("PASSIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
                        LegDesc.add(4);
                        LegDesc.add("This skill gives you a chance");
                        LegDesc.add("to revive yourself upon death instantly");
                        LegDesc.add("however it depends purely on luck, base");
                        LegDesc.add("chance is Luck_Stat*0.5 with max = 35%");


                        CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                        CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                        CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                        CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                        CCSkills.save();

                    }
                }
            } else if (UniqueAbility.contains("Miner")) {
                if (true) {
                    if (UniqueAbility.equals("Miner I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Miner's Property")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Miner's Property");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill picks up the ores");
                                RarDesc.add("mined by you into your inventory,");
                                RarDesc.add("however if you have full inventory it gets");
                                RarDesc.add("dropped on the ground");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Miner II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Earth's Blessing")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("Earth's Blessing");
                            EpType.add("PASSIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(4);
                            EpDesc.add("This skill multiplies your defense stat");
                            EpDesc.add("when you are underground (at least 10 blocks");
                            EpDesc.add("above you, right next to each other)");
                            EpDesc.add("your defend stat gets multiplied by 1.25x");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();

                        }

                    } else if (UniqueAbility.equals("Miner III")) {
                        if (CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Ore Sniffer")) {
                            return;
                        }
                        //Leg Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");



                        LegSkills.add("Ore Sniffer");
                        LegType.add("PASSIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
                        LegDesc.add(5);
                        LegDesc.add("This skill sniffs your surroundings,");
                        LegDesc.add("when it says it smells a something stinks");
                        LegDesc.add("its coal/redstone once its weird smell its");
                        LegDesc.add("iron/gold and nice smell is diamond/netherite,");
                        LegDesc.add("however it has a chance of 15% to tell you");


                        CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                        CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                        CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                        CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                        CCSkills.save();
                    }
                }
            } else if (UniqueAbility.contains("Tank")) {
                if (true) {
                    if (UniqueAbility.equals("Tank I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Lion's Roar")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Lion's Roar");
                                RarType.add("ACTIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill makes players and monsters");
                                RarDesc.add("around you go to you or in case of players");
                                RarDesc.add("move them to you, which is basically a taunt skill");
                                RarDesc.add("area of effect is 10blocks around you");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Tank II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Wall of Stone")) {
                            return;
                        }

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
                            EpProfNeed.add(2000);
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

                    } else if (UniqueAbility.equals("Tank III")) {

                        //Epic Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        if(LegSkills.contains("Gateway Guards")){
                            return;
                        }

                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                        LegSkills.add("Gateway Guards");
                        LegType.add("PASSIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
                        LegDesc.add(7);
                        LegDesc.add("This skill summons three Gateway Guards");
                        LegDesc.add("when you are on the brink of death,");
                        LegDesc.add("but there is only chance 45%");
                        LegDesc.add("What is Gateway Guard ?");
                        LegDesc.add("Its a Iron Golem with half level of the");
                        LegDesc.add("player that summoned it and stats according");
                        LegDesc.add("to the level");


                        CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                        CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                        CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                        CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                        CCSkills.save();


                    }
                }
            } else if (UniqueAbility.contains("BlackSmith")) {
                if (false) {
                    if (UniqueAbility.equals("Blacksmith I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Blacksmith's Way")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Blacksmith's Way");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(3);
                                RarDesc.add("This skill gives you 5% higher chance");
                                RarDesc.add("of making higher rarities of items when");
                                RarDesc.add("in area of 5 from you is fire or lava");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Blacksmith II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Blacksmith's Blessing")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("Blacksmith's Blessing");
                            EpType.add("PASSIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(3);
                            EpDesc.add("This skill guarantees you Rare item once");
                            EpDesc.add("you make 20 items, Epic once 60 and");
                            EpDesc.add("for Legendary makes chance 40%");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();


                        }

                    } else if (UniqueAbility.equals("Blacksmith III")) {
                        if (CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Blacksmith's Blessing")) {
                            return;
                        }
                        //Epic Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                        LegSkills.add("Blacksmith's Blessing");
                        LegType.add("PASSIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
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
                                if (EpDesc.get(j) == "and durability is taken from dmg (dmg*0,2)") {
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
                }
            } else if (UniqueAbility.contains("Blood Thief")) {
                if (true) {
                    if (UniqueAbility.equals("Blood Thief I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Life Steal")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Life Steal");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(2);
                                RarDesc.add("This skill heals you by 0.25%");
                                RarDesc.add("of the damage dealt to the enemy");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Blood Thief II")) {


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
                                EpProfNeed.add(2000);
                                EpDesc.add(4);
                                EpDesc.add("This skill heals you when someone");
                                EpDesc.add("dies within 10blocks from you by 50% of");
                                EpDesc.add("the enemies max health");
                                EpDesc.add("Cooldown 30 sec");


                                CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                CCSkills.save();
                            }
                        }



                    } else if (UniqueAbility.equals("Blood Thief III")) {
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
                            LegProfNeed.add(2000);
                            LegDesc.add(4);
                            LegDesc.add("This skill deals accumulated damage*0.3");
                            LegDesc.add("in last 5 sec to your enemy once you hit");
                            LegDesc.add("him with your hand");
                            LegDesc.add("Cooldown 30 sec");


                            CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                            CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                            CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                            CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                            CCSkills.save();
                        }

                    }
                }
            } else if (UniqueAbility.contains("Master Swordsman")) {
                if (true) {
                    if (UniqueAbility.equals("Master Swordsman I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Sword's Blessing")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Sword's Blessing");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(2);
                                RarDesc.add("This skill boosts your sword");
                                RarDesc.add("by making it +1 Sharpness enchant");



                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Master Swordsman II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Dual Swordsman")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("Dual Swordsman");
                            EpType.add("PASSIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(3);
                            EpDesc.add("This skill makes you able to use");
                            EpDesc.add("swords in both hands, however the ");
                            EpDesc.add("swords will deal 75% of the original damage");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();

                        }

                    } else if (UniqueAbility.equals("Master Swordsman III")) {

                        if (CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Swordsman's Guard")) {
                            return;
                        }
                        //Epic Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                        LegSkills.add("Swordsman's Guard");
                        LegType.add("ACTIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
                        LegDesc.add(5);
                        LegDesc.add("This skill summons 3 Guards from");
                        LegDesc.add("Shadow Knight's Order with 40% level of the");
                        LegDesc.add("player and weapons of the Order with enchant");
                        LegDesc.add("Sharpness 3 and Protection 3");
                        LegDesc.add("Cooldown 2 min");


                        CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                        CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                        CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                        CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                        CCSkills.save();

                    }
                }
            } else if (UniqueAbility.contains("Master Archer")) {
                if (true) {
                    if (UniqueAbility.equals("Master Archer I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Knowledge of the Weapon")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Knowledge of the Weapon");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(2);
                                RarDesc.add("This skill boosts your bow/crossbow,");
                                RarDesc.add("by making it +1 Power enchant");



                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Master Archer II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Experts Aim")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("Experts Aim");
                            EpType.add("ACTIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(4);
                            EpDesc.add("This skill makes your arrow change");
                            EpDesc.add("direction every 3 sec once its ");
                            EpDesc.add("shot to the closest player it has 3");
                            EpDesc.add("uses and cooldown 10s to reaload 1 use");



                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();

                        }

                    } else if (UniqueAbility.equals("Master Archer III")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Legendary.Name").contains("Burst")) {
                            //Epic Skills
                            List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                            List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                            List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                            List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                            List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                            List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                            LegSkills.add("Burst");
                            LegType.add("ACTIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
                            LegDesc.add(3);
                            LegDesc.add("This skill makes your bow/crossbow");
                            LegDesc.add("shoot 5 arrows at the same time");
                            LegDesc.add("Cooldown 10s");


                            CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                            CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                            CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                            CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                            CCSkills.save();

                        }

                    }
                }
            } else if (UniqueAbility.contains("Mana Chosen")) {
                if (true) {
                    if (UniqueAbility.equals("Mana Chosen I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Drunk Wizard")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Drunk Wizard");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill gives you 20% more");
                                RarDesc.add("mana when consuming Potions that");
                                RarDesc.add("give you mana, however you get drunk if");
                                RarDesc.add("you drink more than 5 in 1 minute");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Mana Chosen II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("No Fees")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("No Fees");
                            EpType.add("PASSIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(3);
                            EpDesc.add("This skill gives you back 10%");
                            EpDesc.add("of used mana when skill/magic is");
                            EpDesc.add("used");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();
                        }

                    } else if (UniqueAbility.equals("Mana Chosen III")) {

                        //Epic Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        if(!LegSkills.contains("Mana Overload")){
                            List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                            List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                            List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                            List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                            List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                            LegSkills.add("Mana Overload");
                            LegType.add("ACTIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
                            LegDesc.add(3);
                            LegDesc.add("This skill makes your mana infinite");
                            LegDesc.add("for 5 sec");
                            LegDesc.add("Cooldown is 1 minute");




                            LegSkills.add("Drunk Wizard");
                            LegType.add("PASSIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
                            LegDesc.add(4);
                            LegDesc.add("This skill gives you 60% more");
                            LegDesc.add("mana when consuming Potions that");
                            LegDesc.add("give you mana, however you get drunk if");
                            LegDesc.add("you drink more than 2 in 2 minute");


                            CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                            CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                            CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                            CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                            CCSkills.save();

                            if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Drunk Wizard")) {

                                //Epic Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");

                                int i = RarSkills.indexOf("Drunk Wizard");
                                for (int j = 0; j < RarDesc.size(); j++) {
                                    if (RarDesc.get(j) == "you drink more than 5 in 1 minute") {
                                        RarDesc.remove(j);
                                        RarDesc.remove(j - 1);
                                        RarDesc.remove(j - 2);
                                        RarDesc.remove(j - 3);
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


                    }
                }
            } else if (UniqueAbility.contains("Commander")) {
                if (true) {
                    if (UniqueAbility.equals("Commander I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Knight's Order")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Knight's Order");
                                RarType.add("ACTIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill will summon 2 Knights");
                                RarDesc.add("of Knight's Order with level half of ");
                                RarDesc.add("yours and with iron armor protection 3");
                                RarDesc.add("and iron sword sharpness 3");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Commander II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("General")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("General");
                            EpType.add("ACTIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(5);
                            EpDesc.add("This skill will summon a General");
                            EpDesc.add("General will have 3/4 of your level");
                            EpDesc.add("and his armor will be Diamond with");
                            EpDesc.add("protection 4 and Diamond sword ");
                            EpDesc.add("sharpness 4");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();

                        }

                    } else if (UniqueAbility.equals("Commander III")) {
                        //Legendary Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        if(!LegSkills.contains("Art of Command")){
                            List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                            List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                            List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                            List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                            List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                            LegSkills.add("Art of Command");
                            LegType.add("ACTIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
                            LegDesc.add(5);
                            LegDesc.add("This skill makes you able to");
                            LegDesc.add("command your Knights and General");
                            LegDesc.add("Upon activation the summonings will");
                            LegDesc.add("go after the player/monster you ");
                            LegDesc.add("looked at when casting this skill");

                            LegSkills.add("Knight's Order");
                            LegType.add("ACTIVE");
                            LegRanks.add("S");
                            //have to get to E to get to Hard as Rock
                            LegProfHave.add(1);
                            LegProfNeed.add(2000);
                            LegDesc.add(4);
                            LegDesc.add("This skill will summon 3 Knights");
                            LegDesc.add("of Knight's Order with level half of ");
                            LegDesc.add("yours and with iron armor protection 3");
                            LegDesc.add("and iron sword sharpness 3");


                            CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                            CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                            CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                            CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                            CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                            CCSkills.save();

                            if (CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Knight's Order")) {

                                //Epic Skills
                                List EpSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List EpDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List EpRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List EpProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List EpType = CCSkills.get().getList(nick + ".Skills.Rare.Type");

                                int i = EpSkills.indexOf("Knight's Order");
                                for (int j = 0; j < EpDesc.size(); j++) {
                                    if (EpDesc.get(j) == "and iron sword sharpness 3") {
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


                                CCSkills.get().set(nick + ".Skills.Rare.Name", EpSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", EpDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", EpRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", EpProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", EpProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", EpType);
                                CCSkills.save();
                            }
                        }



                    }
                }
            } else if (UniqueAbility.contains("Solo")) {
                if (false) {
                    if (UniqueAbility.equals("Reinforcement I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Hard as Rock")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Hard as Rock");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill makes you as hard as rock,");
                                RarDesc.add("but for it to work you have to");
                                RarDesc.add("eat cobblestone to regain your durability");
                                RarDesc.add("and durability is taken from dmg (dmg*0,3)");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Reinforcement II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Hard as Iron")) {
                            return;
                        }

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
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
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

                    } else if (UniqueAbility.equals("Reinforcement III")) {
                        //Epic Skills
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
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
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
                                if (EpDesc.get(j) == "and durability is taken from dmg (dmg*0,2)") {
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
                }
            }else if (UniqueAbility.contains("Night Watcher")) {
                if (false) {
                    if (UniqueAbility.equals("Reinforcement I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("Hard as Rock")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Hard as Rock");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("This skill makes you as hard as rock,");
                                RarDesc.add("but for it to work you have to");
                                RarDesc.add("eat cobblestone to regain your durability");
                                RarDesc.add("and durability is taken from dmg (dmg*0,3)");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Reinforcement II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Hard as Iron")) {
                            return;
                        }

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
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
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

                    } else if (UniqueAbility.equals("Reinforcement III")) {
                        //Epic Skills
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
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
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
                                if (EpDesc.get(j) == "and durability is taken from dmg (dmg*0,2)") {
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
                }
            }else if (UniqueAbility.contains("Third Eye")) {
                if (true) {
                    if (UniqueAbility.equals("Third Eye I")) {
                        if (!CCSkills.get().getList(nick + ".Skills.Rare.Name").contains("True Vision")) {
                            if (true) {
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("True Vision");
                                RarType.add("ACTIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(3);
                                RarDesc.add("This skill gives you permission,");
                                RarDesc.add("to see other players levels/stats");
                                RarDesc.add("and if he is Mage or Warrior");


                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                            }
                        }


                    } else if (UniqueAbility.equals("Third Eye II")) {


                        if (CCSkills.get().getList(nick + ".Skills.Epic.Name").contains("Aura Vision")) {
                            return;
                        }

                        if (true) {
                            //Epic Skills
                            List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                            List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                            List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                            List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                            List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                            List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");


                            EpSkills.add("Aura Vision");
                            EpType.add("ACTIVE");
                            EpRanks.add("C");
                            //have to get to E to get to Hard as Rock
                            EpProfHave.add(1);
                            EpProfNeed.add(2000);
                            EpDesc.add(5);
                            EpDesc.add("This skill makes you able to see");
                            EpDesc.add("aura around players, the ammount ");
                            EpDesc.add("of aura you see depends on how much");
                            EpDesc.add("Mana or Stamina player has left");
                            EpDesc.add("Blue aura is mana and Red aura is Stamina");


                            CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                            CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                            CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                            CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                            CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                            CCSkills.save();

                        }

                    } else if (UniqueAbility.equals("Third Eye III")) {
                        //Epic Skills
                        List LegSkills = CCSkills.get().getList(nick + ".Skills.Legendary.Name");
                        List LegDesc = CCSkills.get().getList(nick + ".Skills.Legendary.Description");
                        List LegRanks = CCSkills.get().getList(nick + ".Skills.Legendary.Rank");
                        List LegProfHave = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Have");
                        List LegProfNeed = CCSkills.get().getList(nick + ".Skills.Legendary.Proficiency.Need");
                        List LegType = CCSkills.get().getList(nick + ".Skills.Legendary.Type");


                        LegSkills.add("True Weakness");
                        LegType.add("ACTIVE");
                        LegRanks.add("S");
                        //have to get to E to get to Hard as Rock
                        LegProfHave.add(1);
                        LegProfNeed.add(2000);
                        LegDesc.add(4);
                        LegDesc.add("This skill gives you permission");
                        LegDesc.add("to see what resistances player has");
                        LegDesc.add("and according to that you can chose");
                        LegDesc.add("what attack to use");


                        CCSkills.get().set(nick + ".Skills.Legendary.Name", LegSkills);
                        CCSkills.get().set(nick + ".Skills.Legendary.Description", LegDesc);
                        CCSkills.get().set(nick + ".Skills.Legendary.Rank", LegRanks);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Have", LegProfHave);
                        CCSkills.get().set(nick + ".Skills.Legendary.Proficiency.Need", LegProfNeed);
                        CCSkills.get().set(nick + ".Skills.Legendary.Type", LegType);
                        CCSkills.save();
                    }
                }
            }
        }


    }
}


