package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class racechange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()){
            if(args.length>0){
                Player player = (Player) sender;
                String race = args[0];
                String nick = sender.getName();
                int Health = CCStats.get().getInt(nick+".Health");
                int Defense = CCStats.get().getInt(nick+".Defense");
                int Intelligence = CCStats.get().getInt(nick+".Intelligence");
                int Luck = CCStats.get().getInt(nick+".Luck");
                int Agility = CCStats.get().getInt(nick+".Agility");
                int Strength = CCStats.get().getInt(nick+".Strength");
                int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                switch (race){
                    case"Human":
                        CCPlayerInfo.get().set(nick+".Race","Human");
                        CCStats.get().set(nick+".Agility",Agility+2);
                        CCStats.get().set(nick+".Strength",Strength+2);
                        CCStats.get().set(nick+".Defense",Defense+2);
                        CCStats.get().set(nick+".Health",Health+2);
                        CCStats.get().set(nick+".Intelligence",Intelligence+2);
                        CCStats.save();
                        CCPlayerInfo.save();
                        player.sendMessage(color("&aYou have selected &l&aHuman!"));
                        if(!CCSkills.get().getList(nick+".Skills.Epic.Name").contains("Goddess' Blessing")){
                            //Goddess' Blessing
                            if(true){
                                //Rare Skills
                                List EpSkills = CCSkills.get().getList(nick + ".Skills.Epic.Name");
                                List EpDesc = CCSkills.get().getList(nick + ".Skills.Epic.Description");
                                List EpRanks = CCSkills.get().getList(nick + ".Skills.Epic.Rank");
                                List EpProfHave = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Have");
                                List EpProfNeed = CCSkills.get().getList(nick + ".Skills.Epic.Proficiency.Need");
                                List EpType = CCSkills.get().getList(nick + ".Skills.Epic.Type");
                                double MXP = CCPlayerInfo.get().getDouble(nick+".MXP");
                                CCPlayerInfo.get().set(nick+".MXP",MXP+0.05);


                                EpSkills.add("Goddess' Blessing");
                                EpType.add("PASSIVE");
                                EpRanks.add("C");
                                //have to get to E to get to Hard as Rock
                                EpProfHave.add(0);
                                EpProfNeed.add(0);
                                EpDesc.add(2);
                                EpDesc.add("You get 5% more XP from everything");
                                EpDesc.add("however its Ungrowable skill");



                                CCSkills.get().set(nick + ".Skills.Epic.Name", EpSkills);
                                CCSkills.get().set(nick + ".Skills.Epic.Description", EpDesc);
                                CCSkills.get().set(nick + ".Skills.Epic.Rank", EpRanks);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Have", EpProfHave);
                                CCSkills.get().set(nick + ".Skills.Epic.Proficiency.Need", EpProfNeed);
                                CCSkills.get().set(nick + ".Skills.Epic.Type", EpType);
                                CCSkills.save();
                                CCPlayerInfo.save();
                            }
                        }

                        break;
                    case"Elf":
                        CCPlayerInfo.get().set(nick + ".Race", "Elf");
                        CCStats.get().set(nick + ".Agility", Agility + 5);
                        CCStats.get().set(nick + ".Strength", Strength + 5);
                        CCStats.save();
                        player.sendMessage(color("&aYou have selected &l&4Elf!"));
                        if(!CCSkills.get().getList(nick+".Skills.Rare.Name").contains("Friend of Nature")){
                            //Friend of Nature
                            if(true){
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Friend of Nature");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(3);
                                RarDesc.add("If attacked and at 20% health");
                                RarDesc.add("two Dire Wolfs with the level 3");
                                RarDesc.add("will be summoned");



                                CCSkills.get().set(nick + ".Skills.Rare.Name", RarSkills);
                                CCSkills.get().set(nick + ".Skills.Rare.Description", RarDesc);
                                CCSkills.get().set(nick + ".Skills.Rare.Rank", RarRanks);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Have", RarProfHave);
                                CCSkills.get().set(nick + ".Skills.Rare.Proficiency.Need", RarProfNeed);
                                CCSkills.get().set(nick + ".Skills.Rare.Type", RarType);
                                CCSkills.save();
                                CCPlayerInfo.save();
                            }
                        }

                        break;
                    case"Dwarf":
                        CCPlayerInfo.get().set(nick + ".Race", "Dwarf");
                        CCStats.get().set(nick + ".Strength", Strength + 3);
                        CCStats.get().set(nick + ".Defense", Defense + 4);
                        CCStats.get().set(nick + ".Health", Health + 3);
                        CCStats.save();
                        CCPlayerInfo.save();
                        player.sendMessage(color("&aYou have selected &l&aDwarf!"));
                        break;
                    case"Undead":
                        CCPlayerInfo.get().set(nick + ".Race", "Undead");
                        CCStats.get().set(nick + ".Health", Health - 2);
                        CCStats.get().set(nick + ".Intelligence", Intelligence + 6);
                        CCStats.get().set(nick + ".Wisdom", Wisdom + 6);
                        CCStats.save();
                        player.sendMessage(color("&aYou have selected &l&6Undead!"));
                        if(!CCSkills.get().getList(nick+".Skills.Rare.Name").contains("Twisted Sun and Moon")){
                            //Twisted Sun and Moon Rare Skill
                            if(true){
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Twisted Sun and Moon");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(3);
                                RarDesc.add("You are cursed when the sun is up");
                                RarDesc.add("for 10% of all your stats and,");
                                RarDesc.add("you are boosted by 15% when its night");


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
                    case"Dragonborn":
                        CCPlayerInfo.get().set(nick + ".Race", "Dragonborn");
                        CCStats.get().set(nick + ".Strength", Strength + 5);
                        CCStats.get().set(nick + ".Intelligence", Intelligence + 5);
                        CCStats.save();
                        CCPlayerInfo.save();
                        player.sendMessage(color("&aYou have selected &l&4Dragonborn"));
                        if(!CCSkills.get().getList(nick+".Skills.Rare.Name").contains("Fire Resistance")){
                            //Fire Resistance Rare Skill
                            if(true){
                                //Rare Skills
                                List RarSkills = CCSkills.get().getList(nick + ".Skills.Rare.Name");
                                List RarDesc = CCSkills.get().getList(nick + ".Skills.Rare.Description");
                                List RarRanks = CCSkills.get().getList(nick + ".Skills.Rare.Rank");
                                List RarProfHave = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Have");
                                List RarProfNeed = CCSkills.get().getList(nick + ".Skills.Rare.Proficiency.Need");
                                List RarType = CCSkills.get().getList(nick + ".Skills.Rare.Type");


                                RarSkills.add("Fire Resistance");
                                RarType.add("PASSIVE");
                                RarRanks.add("F");
                                //have to get to E to get to Hard as Rock
                                RarProfHave.add(1);
                                RarProfNeed.add(500);
                                RarDesc.add(4);
                                RarDesc.add("You are immune to fire for 5 sec");
                                RarDesc.add("from the moment you get on fire,");
                                RarDesc.add("this skill doesn´t work in lava");
                                RarDesc.add("with 30 sec cooldown");


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
            }
        }



        return true;
    }
}
