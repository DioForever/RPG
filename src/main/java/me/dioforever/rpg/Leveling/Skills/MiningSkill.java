package me.dioforever.rpg.Leveling.Skills;

import me.dioforever.rpg.files.CCAchieved;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class MiningSkill implements Listener {

    @EventHandler
    public void onBreakEarth(BlockBreakEvent e) {
        Player p = e.getPlayer();
        List cobbles = new ArrayList<>();
        List ores = new ArrayList<>();
        //Normal
        cobbles.add(Material.STONE);
        cobbles.add(Material.ANDESITE);
        cobbles.add(Material.GRANITE);
        cobbles.add(Material.DIORITE);
        cobbles.add(Material.DEEPSLATE);
        cobbles.add(Material.CALCITE);
        cobbles.add(Material.TUFF);
        //ORES
        ores.add(Material.COAL_ORE);
        ores.add(Material.DEEPSLATE_COAL_ORE);
        ores.add(Material.IRON_ORE);
        ores.add(Material.DEEPSLATE_IRON_ORE);
        ores.add(Material.COPPER_ORE);
        ores.add(Material.DEEPSLATE_COPPER_ORE);
        ores.add(Material.GOLD_ORE);
        ores.add(Material.DEEPSLATE_GOLD_ORE);
        ores.add(Material.REDSTONE_ORE);
        ores.add(Material.DEEPSLATE_REDSTONE_ORE);
        ores.add(Material.EMERALD_ORE);
        ores.add(Material.DEEPSLATE_EMERALD_ORE);
        ores.add(Material.LAPIS_ORE);
        ores.add(Material.DIAMOND_ORE);
        ores.add(Material.DEEPSLATE_DIAMOND_ORE);
        //NETHER
        ores.add(Material.DEEPSLATE_LAPIS_ORE);
        ores.add(Material.NETHER_GOLD_ORE);
        ores.add(Material.NETHER_QUARTZ_ORE);
        ores.add(Material.ANCIENT_DEBRIS);
        if(cobbles.contains(e.getBlock().getType()) || ores.contains(e.getBlock().getType())){
            //Mining Skill - Common
            String nick = p.getName();
            int mEarth = CCAchieved.get().getInt(nick + ".Mined.EarthBlocks");
            mEarth++;
            CCAchieved.get().set((nick + ".Mined.EarthBlocks"), mEarth);
            int amp = 0;
            int time = 0;
            List CmnSkills = CCSkills.get().getList(nick + ".Skills.Common.Name");
            List CmnRanks = CCSkills.get().getList(nick + ".Skills.Common.Rank");
            List CmnProfNeed1 = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
            int index = CmnSkills.indexOf("Mining");
            if (index != -1) {
                switch ((String) CmnRanks.get(index)) {
                    case "F":
                        amp = -1;
                        time = 40;
                        break;
                    case "E":
                        amp = 0;
                        time = 40;
                        break;
                    case "D":
                        amp = 0;
                        time = 40;
                        break;
                    case "C":
                        amp = 1;
                        time = 40;
                        break;
                    case "B":
                        amp = 1;
                        time = 40;
                        break;
                    case "A":
                        amp = 2;
                        time = 40;
                        break;
                    case "S":
                        amp = 2;
                        time = 40;
                        break;
                    case "SS":
                        amp = 2;
                        time = 10;
                        break;
                    case "SSS":
                        amp = 3;
                        time = 10;
                        break;
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, time, amp, false, false));

            }
            if(cobbles.contains(e.getBlock().getType())) {
                if(mEarth==100){
                    if (!CCSkills.get().getList(nick + ".Skills.Common.Name").contains("Mining")) {
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnType = CCSkills.get().getList(nick + ".Skills.Common.Type");


                        CmnSkills.add("Mining");
                        CmnType.add("PASSIVE");
                        CmnRanks.add("F");
                        CmnProfHave.add(100);
                        CmnProfNeed.add(1000);
                        CmnDesc.add(5);
                        CmnDesc.add("This skill makes Mining");
                        CmnDesc.add("faster!");
                        CmnDesc.add("When you mine a tree it breaks");
                        CmnDesc.add("down faster than normally");
                        CmnDesc.add("Current mining boost: Haste 1");


                        CCSkills.get().set(nick + ".Skills.Common.Name", CmnSkills);
                        CCSkills.get().set(nick + ".Skills.Common.Description", CmnDesc);
                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.get().set(nick + ".Skills.Common.Type", CmnType);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) You have acquired new skill! Mining Skill - Common"));
                    }
                }else if(mEarth == 1000){
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");


                    CmnRanks.set(index, "E");
                    //have to get to E to get to Hard as Rock
                    CmnProfHave.set(index, mEarth);
                    CmnProfNeed.set(index, 2000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased F->E!"));
                }else if (mEarth == 2000) {
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                    CmnRanks.set(index, "D");
                    //have to get to E to get to Hard as Rock
                    CmnProfHave.set(index, mEarth);
                    CmnProfNeed.set(index, 4000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased E->D!"));
                } else if (mEarth == 4000) {
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                    CmnRanks.set(index, "C");
                    //have to get to E to get to Hard as Rock
                    int indexD = CmnDesc.indexOf("Current mining boost: Haste 1");
                    CmnDesc.set(indexD,"Current mining boost: Haste 2");
                    CmnProfHave.set(index, mEarth);
                    CmnProfNeed.set(index, 6000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased D->C!"));
                } else if (mEarth == 6000) {
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                    CmnRanks.set(index, "B");
                    //have to get to E to get to Hard as Rock
                    CmnProfHave.set(index, mEarth);
                    CmnProfNeed.set(index, 8000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased C->B!"));
                } else if (mEarth == 8000) {
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                    CmnRanks.set(index, "A");
                    //have to get to E to get to Hard as Rock
                    CmnProfHave.set(index, mEarth);
                    CmnProfNeed.set(index, 11000);
                    int indexD = CmnDesc.indexOf("Current mining boost: Haste 2");
                    CmnDesc.set(indexD,"Current mining boost: Haste 3");


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased B->A!"));
                } else if (mEarth == 11000) {
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                    CmnRanks.set(index, "S");
                    //have to get to E to get to Hard as Rock
                    CmnProfNeed.set(index, 14000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased A->S!"));
                } else if (mEarth == 14000) {
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                    CmnRanks.set(index, "SS");
                    //have to get to E to get to Hard as Rock
                    CmnProfNeed.set(index, 20000);


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased S->SS!"));
                } else if (mEarth == 20000) {
                    List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                    List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                    CmnRanks.set(index, "SSS");
                    //have to get to E to get to Hard as Rock
                    CmnProfNeed.set(index, 0);
                    int indexD = CmnDesc.indexOf("Current mining boost: Haste 3");
                    CmnDesc.set(indexD,"Current mining boost: Haste 4");


                    CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                    CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                    CCSkills.save();
                    p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased SS->SSS!"));
                }
                List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");

                if (CmnSkills.contains("Mining") && mEarth!=100) {
                    CmnProfHave.set(index, mEarth);
                    CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                    CCSkills.save();
                }

            }
            if(ores.contains(e.getBlock().getType())){
                if(!(p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH))){
                    if(mEarth==100){
                        if (!CCSkills.get().getList(nick + ".Skills.Common.Name").contains("Mining")) {
                            List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");
                            List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                            List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                            List CmnType = CCSkills.get().getList(nick + ".Skills.Common.Type");


                            CmnSkills.add("Mining");
                            CmnType.add("PASSIVE");
                            CmnRanks.add("F");
                            CmnProfHave.add(100);
                            CmnProfNeed.add(2000);
                            CmnDesc.add(5);
                            CmnDesc.add("This skill makes Mining");
                            CmnDesc.add("faster!");
                            CmnDesc.add("When you mine a tree it breaks");
                            CmnDesc.add("down faster than normally");
                            CmnDesc.add("Current mining boost: Haste 1");


                            CCSkills.get().set(nick + ".Skills.Common.Name", CmnSkills);
                            CCSkills.get().set(nick + ".Skills.Common.Description", CmnDesc);
                            CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                            CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                            CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                            CCSkills.get().set(nick + ".Skills.Common.Type", CmnType);
                            CCSkills.save();
                            p.sendMessage(color("&2&l(!) You have acquired new skill! Mining Skill - Common"));
                        }
                    }else if(mEarth == 2000){
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");


                        CmnRanks.set(index, "E");
                        //have to get to E to get to Hard as Rock
                        CmnProfHave.set(index, mEarth);
                        CmnProfNeed.set(index, 4000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased F->E!"));
                    }else if (mEarth == 4000) {
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                        CmnRanks.set(index, "D");
                        //have to get to E to get to Hard as Rock
                        CmnProfHave.set(index, mEarth);
                        CmnProfNeed.set(index, 8000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased E->D!"));
                    } else if (mEarth == 8000) {
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                        CmnRanks.set(index, "C");
                        //have to get to E to get to Hard as Rock
                        int indexD = CmnDesc.indexOf("Current mining boost: Haste 1");
                        CmnDesc.set(indexD,"Current mining boost: Haste 2");
                        CmnProfHave.set(index, mEarth);
                        CmnProfNeed.set(index, 12000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased D->C!"));
                    } else if (mEarth == 12000) {
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                        CmnRanks.set(index, "B");
                        //have to get to E to get to Hard as Rock
                        CmnProfHave.set(index, mEarth);
                        CmnProfNeed.set(index, 15000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased C->B!"));
                    } else if (mEarth == 15000) {
                        List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                        CmnRanks.set(index, "A");
                        //have to get to E to get to Hard as Rock
                        CmnProfHave.set(index, mEarth);
                        CmnProfNeed.set(index, 17000);
                        int indexD = CmnDesc.indexOf("Current mining boost: Haste 2");
                        CmnDesc.set(indexD,"Current mining boost: Haste 3");


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased B->A!"));
                    } else if (mEarth == 17000) {
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                        CmnRanks.set(index, "S");
                        //have to get to E to get to Hard as Rock
                        CmnProfNeed.set(index, 22000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased A->S!"));
                    } else if (mEarth == 22000) {
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");

                        CmnRanks.set(index, "SS");
                        //have to get to E to get to Hard as Rock
                        CmnProfNeed.set(index, 30000);


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased S->SS!"));
                    } else if (mEarth == 30000) {
                        List CmnProfNeed = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Need");
                        List CmnDesc = CCSkills.get().getList(nick + ".Skills.Common.Description");

                        CmnRanks.set(index, "SSS");
                        //have to get to E to get to Hard as Rock
                        CmnProfNeed.set(index, 0);
                        int indexD = CmnDesc.indexOf("Current mining boost: Haste 3");
                        CmnDesc.set(indexD,"Current mining boost: Haste 4");


                        CCSkills.get().set(nick + ".Skills.Common.Rank", CmnRanks);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Need", CmnProfNeed);
                        CCSkills.get().set(nick+".Skills.Common.Description",CmnDesc);
                        CCSkills.save();
                        p.sendMessage(color("&2&l(!) Your skill Mining Skill - Common Proficiency increased SS->SSS!"));
                    }
                    List CmnProfHave = CCSkills.get().getList(nick + ".Skills.Common.Proficiency.Have");

                    if (CmnSkills.contains("Mining") && mEarth!=100 &&(int)CmnProfNeed1.get(index)!=0) {
                        CmnProfHave.set(index, mEarth);
                        CCSkills.get().set(nick + ".Skills.Common.Proficiency.Have", CmnProfHave);
                        CCSkills.save();
                    }


                }
            }
        }
    }
}
