package me.dioforever.rpg.Leveling.Skills;

import me.dioforever.rpg.files.CCAchieved;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class LumberingSkill implements Listener {

    @EventHandler
    public void onBreakWood(BlockBreakEvent e) {
        List wood = new ArrayList<>();
        //Normal
        wood.add(Material.OAK_LOG);
        wood.add(Material.SPRUCE_LOG);
        wood.add(Material.BIRCH_LOG);
        wood.add(Material.ACACIA_LOG);
        wood.add(Material.JUNGLE_LOG);
        wood.add(Material.DARK_OAK_LOG);
        //Stripped
        wood.add(Material.STRIPPED_ACACIA_LOG);
        wood.add(Material.STRIPPED_OAK_LOG);
        wood.add(Material.STRIPPED_BIRCH_LOG);
        wood.add(Material.STRIPPED_SPRUCE_LOG);
        wood.add(Material.STRIPPED_JUNGLE_LOG);
        wood.add(Material.STRIPPED_DARK_OAK_LOG);


        if (wood.contains(e.getBlock().getType())) {
            Player p = e.getPlayer();
            String nick = p.getName();
            int mWood = CCAchieved.get().getInt(nick + ".Mined.Wood");
            mWood++;
            CCAchieved.get().set((nick + ".Mined.Wood"), mWood);
                /*
                F   None
                E   Haste I
                D   HasteHaste I
                C   20%Haste II
                B   25%Haste II
                A   30%Haste III
                S   40%Haste III
                SS  Haste III
                SSS 50% Haste IIII
                 */
            int amp = 0;
            int time = 0;
            List CmnSkills = CCSkills.get().getList(nick + ".Skills.Common.Name");
            List CmnRanks = CCSkills.get().getList(nick + ".Skills.Common.Rank");
            int index = CmnSkills.indexOf("Lumbering");
            if (index != -1) {
                switch ((String) CmnRanks.get(index)) {
                    case "F":
                        amp = 0;
                        time = 40;
                        break;
                    case "E":
                        amp = 1;
                        time = 40;
                        break;
                    case "D":
                        amp = 1;
                        time = 40;
                        break;
                    case "C":
                        amp = 2;
                        time = 40;
                        break;
                    case "B":
                        amp = 2;
                        time = 40;
                        break;
                    case "A":
                        amp = 3;
                        time = 40;
                        break;
                    case "S":
                        amp = 3;
                        time = 40;
                        break;
                    case "SS":
                        amp = 3;
                        time = 20;
                        break;
                    case "SSS":
                        amp = 4;
                        time = 20;
                        break;
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, time, amp, false, false));
            }

            if (mWood == 100) {
                if (!CCSkills.get().getList(nick + ".Skills.Common.Name").contains("Lumbering")) {
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnType = CCSkills.get().getList(nick + ".Skills.Common.Type");


                    CmnSkills.add("Lumbering");
                    CmnType.add("PASSIVE");
                    CmnRanks.add("F");
                    //have to get to E to get to Hard as Rock
                    CmnProfHave.add(100);
                    CmnProfNeed.add(2000);
                    CmnDesc.add(5);
                    CmnDesc.add("This skill makes Lumbering");
                    CmnDesc.add("faster!");
                    CmnDesc.add("When you mine a tree it breaks");
                    CmnDesc.add("down faster than normally");
                    CmnDesc.add("Current boost: Haste 0");


                    CCSkills.get().set(nick + ".Skills.Common.Name", CmnSkills);
                    CCSkills.get().set(nick + ".Skills.Common.Description", CmnDesc);
                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.get().set(nick + ".Skills.Common.Type", CmnType);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) You have acquired new skill! Lumbering Skill - Common"));
                }
        }else if (mWood == 2000) {
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");


                CmnRanks.set(index, "E");
                //have to get to E to get to Hard as Rock
                CmnProfHave.set(index, mWood);
                CmnProfNeed.set(index, 4000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 4000) {
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");


                CmnRanks.set(index, "D");
                //have to get to E to get to Hard as Rock
                CmnProfHave.set(index, mWood);
                CmnProfNeed.set(index,8000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 8000) {
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                CmnRanks.set(index, "C");
                //have to get to E to get to Hard as Rock
                CmnProfHave.set(index, mWood);
                CmnProfNeed.set(index, 12000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 12000) {
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                CmnRanks.set(index, "B");
                //have to get to E to get to Hard as Rock
                CmnProfHave.set(index, mWood);
                CmnProfNeed.set(index, 15000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 15000) {
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                CmnRanks.set(index, "A");
                //have to get to E to get to Hard as Rock
                CmnProfHave.set(index, mWood);
                CmnProfNeed.set(index, 17000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 17000) {
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                CmnRanks.set(index, "S");
                //have to get to E to get to Hard as Rock
                CmnProfNeed.set(index, 22000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 22000) {
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                CmnRanks.set(index, "SS"); 
                //have to get to E to get to Hard as Rock
                CmnProfNeed.set(index, 30000);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            } else if (mWood == 30000) {
                List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");


                CmnRanks.set(index, "SSS");
                //have to get to E to get to Hard as Rock
                CmnProfNeed.set(index, 0);


                CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                CCSkills.save();
            }
            List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");

            if (CmnSkills.contains("Lumbering")) {
                CmnProfHave.set(index, mWood);
                CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                CCSkills.save();
            }
        }
    }
}
