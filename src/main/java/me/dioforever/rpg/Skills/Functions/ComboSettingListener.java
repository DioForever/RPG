package me.dioforever.rpg.Skills.Functions;

import me.dioforever.rpg.Menu.MenuListener;
import me.dioforever.rpg.files.CCCombos;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class ComboSettingListener implements Listener{

    private ItemStack Skill;
    private ItemStack ItemC;
    private ItemStack LeftClick;
    private ItemStack RightClick;
    private ItemStack EmptyClick;

    private ItemStack Glass;
    private ItemStack WhiteGlass;
    private ItemStack LegendarySkill;
    private ItemStack EpicSkill;
    private ItemStack RareSkill;
    private ItemStack CommonSkill;

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (!event.getView().getTitle().equalsIgnoreCase(color("&5&lCombo Setting"))) {

            //Player doesn´t have Menu opened
            return;

        }
        //Cancel all item  moving, editing, droping etc., and player inv too
        event.setCancelled(true);
        if (event.getCurrentItem() != null) {
            if (!event.getClickedInventory().equals(inv)) {
                return;
            }
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();
        String nick = player.getName();


        Skill = inv.getItem(4);
        ItemMeta Skillmeta = Skill.getItemMeta();
        String skillName = Skillmeta.getDisplayName();
        //Delete first 17 letters

        char[] ch = skillName.toCharArray();
        int sizech = ch.length;
        char[] skillch = Arrays.copyOfRange(ch, 18,sizech);
        String skill = String.valueOf(skillch);

        EmptyClick = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE,1);
        ItemMeta EmptyClickMeta = EmptyClick.getItemMeta();
        EmptyClickMeta.setDisplayName(color("&5Empty"));
        EmptyClickMeta.setLore(Arrays.asList(
                color("&d - This is currently empty and"),
                color("&d will not be counted in the combo"),
                color("&d - Click to change to Left Click")));
        EmptyClick.setItemMeta(EmptyClickMeta);

        LeftClick = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
        ItemMeta LeftClickMeta = LeftClick.getItemMeta();
        LeftClickMeta.setDisplayName(color("&9Left Click"));
        LeftClickMeta.setLore(Arrays.asList(
                color("&b - This is currently Left Click and"),
                color("&b will be counted in the combo"),
                color("&b - Click to change to Right Click")));
        LeftClick.setItemMeta(LeftClickMeta);

        RightClick = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
        ItemMeta RightClickMeta = RightClick.getItemMeta();
        RightClickMeta.setDisplayName(color("&4Right Click"));
        RightClickMeta.setLore(Arrays.asList(
                color("&c - This is currently Right Click and"),
                color("&c will be counted in the combo"),
                color("&c - Click to change to Empty")));
        RightClick.setItemMeta(RightClickMeta);


        //Skills Menu
        Inventory Skills = Bukkit.createInventory(null,54,color("&4&lSkills"));
        if(true){

            //Glass
            Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
            ItemMeta GlassMeta = Glass.getItemMeta();
            GlassMeta.setDisplayName(color("&0-----"));
            GlassMeta.setLore(Arrays.asList(color("")));
            Glass.setItemMeta(GlassMeta);

            //WhiteGlass
            WhiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
            ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
            WhiteGlassMeta.setDisplayName(color("&l&bMenu"));
            WhiteGlassMeta.setLore(Arrays.asList(color("&bClick to go back to Menu")));
            WhiteGlass.setItemMeta(WhiteGlassMeta);

            //LEFT SIDE
            Skills.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(27,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(36,editItem(Glass.clone(),1,Arrays.asList()));
            //RIGHT SIDE
            Skills.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(35,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(44,editItem(Glass.clone(),1,Arrays.asList()));
            //BOTTOM
            Skills.setItem(46,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(47,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(48,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(49,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(50,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(45,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(51,editItem(Glass.clone(),1,Arrays.asList()));
            Skills.setItem(52,editItem(Glass.clone(),1,Arrays.asList()));
            //LEFT AND RIGHT BOTTOM CORNER
            Skills.setItem(45,editItem(WhiteGlass.clone(),1,Arrays.asList()));
            Skills.setItem(53,editItem(WhiteGlass.clone(),1,Arrays.asList()));


            //Legendary Skills
            List LegSkills = CCSkills.get().getList(nick+".Skills.Legendary.Name");
            int kLegSkills = LegSkills.size();
            //System.out.println(kLegSkills+" Legendary skills");
            List LegDesc = CCSkills.get().getList(nick+".Skills.Legendary.Description");
            int kLegDesc = LegDesc.size();
            List LegRanks = CCSkills.get().getList(nick+".Skills.Legendary.Rank");
            int kLegRanks = LegRanks.size();
            List LegProfHave = CCSkills.get().getList(nick+".Skills.Legendary.Proficiency.Have");
            int kLegProfHave = LegProfHave.size();
            List LegProfNeed = CCSkills.get().getList(nick+".Skills.Legendary.Proficiency.Need");
            int kLegProfNeed = LegProfNeed.size();
            List LegType = CCSkills.get().getList(nick+".Skills.Legendary.Type");
            int kLegType = LegType.size();


            //Epic Skills
            List EpSkills = CCSkills.get().getList(nick+".Skills.Epic.Name");
            int kEpSkills =  EpSkills.size();
            //System.out.println(kEpSkills+" Epic skills");

            List EpDesc = CCSkills.get().getList(nick+".Skills.Epic.Description");
            int kEpDesc = EpDesc.size();

            List EpRanks = CCSkills.get().getList(nick+".Skills.Epic.Rank");
            int kEpRanks = EpRanks.size();

            List EpProfHave = CCSkills.get().getList(nick+".Skills.Epic.Proficiency.Have");
            int kEpProfHave = EpProfHave.size();

            List EpProfNeed = CCSkills.get().getList(nick+".Skills.Epic.Proficiency.Need");
            int kEpProfNeed = EpProfNeed.size();

            List EpType = CCSkills.get().getList(nick+".Skills.Epic.Type");
            int kEpType = EpType.size();

            //Rare Skills
            List RarSkills = CCSkills.get().getList(nick+".Skills.Rare.Name");
            int kRarSkills = RarSkills.size();
            //System.out.println(kRarSkills+" Rare skills");

            List RarDesc = CCSkills.get().getList(nick+".Skills.Rare.Description");
            int kRarDesc = RarDesc.size();

            List RarRanks = CCSkills.get().getList(nick+".Skills.Rare.Rank");
            int kRarRanks = RarRanks.size();

            List RarProfHave = CCSkills.get().getList(nick+".Skills.Rare.Proficiency.Have");
            int kRarProfHave = RarProfHave.size();

            List RarProfNeed = CCSkills.get().getList(nick+".Skills.Rare.Proficiency.Need");
            int kRarProfNeed = RarProfHave.size();

            List RarType = CCSkills.get().getList(nick+".Skills.Rare.Type");
            int kRarType = RarType.size();

            //Common Skills
            List CmnSkills = CCSkills.get().getList(nick+".Skills.Common.Name");
            int kCmnSkills = CmnSkills.size();
            //System.out.println(kCmnSkills+" Common skills");

            List CmnDesc = CCSkills.get().getList(nick+".Skills.Common.Description");
            int kCmnDesc = CmnDesc.size();

            List CmnRanks = CCSkills.get().getList(nick+".Skills.Common.Rank");
            int kCmnRanks = CmnRanks.size();

            List CmnProfHave = CCSkills.get().getList(nick+".Skills.Common.Proficiency.Have");
            int kCmnProfHave = CmnProfHave.size();

            List CmnProfNeed = CCSkills.get().getList(nick+".Skills.Common.Proficiency.Need");
            int kCmnProfNeed = CmnProfNeed.size();

            List CmnType = CCSkills.get().getList(nick+".Skills.Common.Type");
            int kCmnType = CmnType.size();

            List what = new ArrayList<>();
            List where = new ArrayList<>();


            List taken = new ArrayList<>();
            //1
            taken.add(1);
            taken.add(2);
            taken.add(3);
            taken.add(4);
            taken.add(5);
            taken.add(6);
            taken.add(7);
            //2
            taken.add(10);
            taken.add(11);
            taken.add(12);
            taken.add(13);
            taken.add(14);
            taken.add(15);
            taken.add(16);
            //3
            taken.add(19);
            taken.add(20);
            taken.add(21);
            taken.add(22);
            taken.add(23);
            taken.add(24);
            taken.add(25);
            //4
            taken.add(28);
            taken.add(29);
            taken.add(30);
            taken.add(31);
            taken.add(32);
            taken.add(33);
            taken.add(34);
            //3
            taken.add(37);
            taken.add(38);
            taken.add(39);
            taken.add(40);
            taken.add(41);
            taken.add(42);
            taken.add(43);
            //


            //Legendary

            int i = 0;
            int k = 0;
            int d = 0;
            int v = 0;



            for(int l = 0; l<kLegSkills;l++){
                LegendarySkill = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                ItemMeta LegendarySkillMeta = LegendarySkill.getItemMeta();
                LegendarySkillMeta.setDisplayName(color("&l&6"+ LegSkills.get(i)+"&6 - Legendary"));
                v = (int)LegDesc.get(k);
                k += v;

                if(LegType.get(i).equals("ACTIVE")){
                    if(v==3){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k)),
                                color("&6[&eClick to open Combo Setting&6]")));
                    }else if(v==4){
                        if(LegSkills.get(i).equals("Critical Luck")){
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>35){
                                Chance=35;
                            }else{
                                int luck_stat = CCStats.get().getInt(nick+".Luck");
                                Chance = luck_stat*0.5;
                            }
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&6[&eChance  "+"&e"+Chance+"%&6/&e35%"+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k)),
                                    color("&6[&eClick to open Combo Setting&6]")));
                        }else if(LegSkills.get(i).equals("Hard as Diamond")){
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&6[&eDurability  "+"&e"+200+"&6/&e"+200+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k)),
                                    color("&6[&eClick to open Combo Setting&6]")));
                        }else{
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k)),
                                    color("&6[&eClick to open Combo Setting&6]")));
                        }
                    }else if(v==5){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-4)),
                                color("&e - "+LegDesc.get(k-3)),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k)),
                                color("&6[&eClick to open Combo Setting&6]")));
                    }else if(v==7){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-6)),
                                color("&e - "+LegDesc.get(k-5)),
                                color("&e - "+LegDesc.get(k-4)),
                                color("&e - "+LegDesc.get(k-3)),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k)),
                                color("&6[&eClick to open Combo Setting&6]")));
                    }
                }else{
                    if(v==3){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k))));
                    }else if(v==4){
                        if(LegSkills.get(i).equals("Critical Luck")){
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>35){
                                Chance=35;
                            }else{
                                int luck_stat = CCStats.get().getInt(nick+".Luck");
                                Chance = luck_stat*0.5;
                            }
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&6[&eChance  "+"&e"+Chance+"%&6/&e35%"+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k))));
                        }else if(LegSkills.get(i).equals("Hard as Diamond")){
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&6[&eDurability  "+"&e"+200+"&6/&e"+200+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k))));
                        }else{
                            LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                    color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                    color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                    color("&e - "+LegDesc.get(k-3)),
                                    color("&e - "+LegDesc.get(k-2)),
                                    color("&e - "+LegDesc.get(k-1)),
                                    color("&e - "+LegDesc.get(k))));
                        }
                    }else if(v==5){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-4)),
                                color("&e - "+LegDesc.get(k-3)),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k))));
                    }else if(v==7){
                        LegendarySkillMeta.setLore(Arrays.asList(color("&6["+"&e"+LegType.get(i)+color("&6] - Legendary")),
                                color("&6[&eRank "+"&e"+LegRanks.get(i)+"&6]"),
                                color("&6[&eProficiency  "+"&e"+LegProfHave.get(i)+"&6/&e"+LegProfNeed.get(i)+"&6]"),
                                color("&e - "+LegDesc.get(k-6)),
                                color("&e - "+LegDesc.get(k-5)),
                                color("&e - "+LegDesc.get(k-4)),
                                color("&e - "+LegDesc.get(k-3)),
                                color("&e - "+LegDesc.get(k-2)),
                                color("&e - "+LegDesc.get(k-1)),
                                color("&e - "+LegDesc.get(k))));
                    }
                }

                LegendarySkill.setItemMeta(LegendarySkillMeta);

                Skills.setItem((int)taken.get(0),editItem(LegendarySkill.clone(),1,Arrays.asList()));
                what.add(LegSkills.get(i));
                where.add((int)taken.get(0));
                taken.remove(0);

                k++;
                i++;


            }
            k=0;
            i=0;

            for(int e = 0; e<kEpSkills;e++){

                EpicSkill = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
                ItemMeta EpicSkillMeta = EpicSkill.getItemMeta();
                EpicSkillMeta.setDisplayName(color("&l&5"+ EpSkills.get(i)+"&5 - Epic"));
                v = (int)EpDesc.get(k);
                k += v;
                if(EpType.get(i).equals("ACTIVE")){
                    if(v==1){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k)),
                                color("&5[&dClick to open Combo Setting&5]")));
                    }else if(v==2){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k)),
                                color("&5[&dClick to open Combo Setting&5]")));
                    }else if(v==3){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k)),
                                color("&5[&dClick to open Combo Setting&5]")));
                    }else if(v==4){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-3)),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k)),
                                color("&5[&dClick to open Combo Setting&5]")));
                    }else if(v==5){
                        EpicSkillMeta.setLore(Arrays.asList(color("&6["+"&d"+EpType.get(i)+color("&6]")),
                                color("&6[&dRank "+"&d"+EpRanks.get(i)+"&6]"),
                                color("&6[&dProficiency  "+"&d"+EpProfHave.get(i)+"&6/&d"+EpProfNeed.get(i)+"&6]"),
                                color("&d - "+EpDesc.get(k-4)),
                                color("&d - "+EpDesc.get(k-3)),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k)),
                                color("&5[&dClick to open Combo Setting&5]")));
                    }else if(v==12){
                        if(EpSkills.get(i).equals("Lucky Coin")){
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>80){
                                Chance=80;
                            }else{
                                int luck_stat = CCStats.get().getInt(nick+".Luck");
                                Chance = luck_stat*0.5;
                            }
                            EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                    color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                    color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                    color("&5[&dChance  "+"&d"+Chance+"%&5/&d80%"+"&5]"),
                                    color("&d - "+EpDesc.get(k-11)),
                                    color("&d - "+EpDesc.get(k-10)),
                                    color("&d - "+EpDesc.get(k-9)),
                                    color("&d - "+EpDesc.get(k-8)),
                                    color("&d - "+EpDesc.get(k-7)),
                                    color("&d - "+EpDesc.get(k-6)),
                                    color("&d - "+EpDesc.get(k-5)),
                                    color("&d - "+EpDesc.get(k-4)),
                                    color("&d - "+EpDesc.get(k-3)),
                                    color("&d - "+EpDesc.get(k-2)),
                                    color("&d - "+EpDesc.get(k-1)),
                                    color("&d - "+EpDesc.get(k)),
                                    color("&5[&dClick to open Combo Setting&5]")));

                        }else{
                            EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                    color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                    color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                    color("&d - "+EpDesc.get(k-11)),
                                    color("&d - "+EpDesc.get(k-10)),
                                    color("&d - "+EpDesc.get(k-9)),
                                    color("&d - "+EpDesc.get(k-8)),
                                    color("&d - "+EpDesc.get(k-7)),
                                    color("&d - "+EpDesc.get(k-6)),
                                    color("&d - "+EpDesc.get(k-5)),
                                    color("&d - "+EpDesc.get(k-4)),
                                    color("&d - "+EpDesc.get(k-3)),
                                    color("&d - "+EpDesc.get(k-2)),
                                    color("&d - "+EpDesc.get(k-1)),
                                    color("&d - "+EpDesc.get(k)),
                                    color("&5[&dClick to open Combo Setting&5]")));
                        }

                    }
                }else{
                    if(v==1){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k))));
                    }else if(v==2){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k))));
                    }else if(v==3){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k))));
                    }else if(v==4){
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                color("&d - "+EpDesc.get(k-3)),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k))));
                    }else if(v==5){
                        EpicSkillMeta.setLore(Arrays.asList(color("&6["+"&d"+EpType.get(i)+color("&6]")),
                                color("&6[&dRank "+"&d"+EpRanks.get(i)+"&6]"),
                                color("&6[&dProficiency  "+"&d"+EpProfHave.get(i)+"&6/&d"+EpProfNeed.get(i)+"&6]"),
                                color("&d - "+EpDesc.get(k-4)),
                                color("&d - "+EpDesc.get(k-3)),
                                color("&d - "+EpDesc.get(k-2)),
                                color("&d - "+EpDesc.get(k-1)),
                                color("&d - "+EpDesc.get(k))));
                    }else if(v==12){
                        if(EpSkills.get(i).equals("Lucky Coin")){
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>80){
                                Chance=80;
                            }else{
                                int luck_stat = CCStats.get().getInt(nick+".Luck");
                                Chance = luck_stat*0.5;
                            }
                            EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                    color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                    color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                    color("&5[&dChance  "+"&d"+Chance+"%&5/&d80%"+"&5]"),
                                    color("&d - "+EpDesc.get(k-11)),
                                    color("&d - "+EpDesc.get(k-10)),
                                    color("&d - "+EpDesc.get(k-9)),
                                    color("&d - "+EpDesc.get(k-8)),
                                    color("&d - "+EpDesc.get(k-7)),
                                    color("&d - "+EpDesc.get(k-6)),
                                    color("&d - "+EpDesc.get(k-5)),
                                    color("&d - "+EpDesc.get(k-4)),
                                    color("&d - "+EpDesc.get(k-3)),
                                    color("&d - "+EpDesc.get(k-2)),
                                    color("&d - "+EpDesc.get(k-1)),
                                    color("&d - "+EpDesc.get(k))));

                        }else{
                            EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                    color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                    color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
                                    color("&d - "+EpDesc.get(k-11)),
                                    color("&d - "+EpDesc.get(k-10)),
                                    color("&d - "+EpDesc.get(k-9)),
                                    color("&d - "+EpDesc.get(k-8)),
                                    color("&d - "+EpDesc.get(k-7)),
                                    color("&d - "+EpDesc.get(k-6)),
                                    color("&d - "+EpDesc.get(k-5)),
                                    color("&d - "+EpDesc.get(k-4)),
                                    color("&d - "+EpDesc.get(k-3)),
                                    color("&d - "+EpDesc.get(k-2)),
                                    color("&d - "+EpDesc.get(k-1)),
                                    color("&d - "+EpDesc.get(k))));
                        }

                    }
                }

                EpicSkill.setItemMeta(EpicSkillMeta);

                Skills.setItem((int)taken.get(0),editItem(EpicSkill.clone(),1,Arrays.asList()));
                what.add(EpSkills.get(i));
                where.add((int)taken.get(0));
                taken.remove(0);

                k++;
                i++;
            }
            k=0;
            i=0;

            for(int r = 0; r<kRarSkills;r++){

                RareSkill = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
                ItemMeta RareSkillMeta = RareSkill.getItemMeta();
                RareSkillMeta.setDisplayName(color("&l&1"+ RarSkills.get(i)+"&1 - Rare"));
                v = (int)RarDesc.get(k);
                k += v;

                if(RarType.get(i).equals("ACTIVE")){
                    if(v==1){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k)),
                                color("&1[&9Click to open Combo Setting&1]")));
                    }else if(v==2){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k)),
                                color("&1[&9Click to open Combo Setting&1]")));
                    }else if(v==3){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k)),
                                color("&1[&9Click to open Combo Setting&1]")));
                    }else if(v==4){

                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-3)),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k)),
                                color("&1[&9Click to open Combo Setting&1]")));
                    }else if(v==5){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-4)),
                                color("&9 - "+RarDesc.get(k-3)),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k)),
                                color("&1[&9Click to open Combo Setting&1]")));
                    }else if(v==12){
                        if(!CCSkills.get().getString(nick+".Skills.Unique").contains("Lucker")&& RarSkills.get(i)=="Lucky Coin"){
                            RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                    color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                    color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                    color("&9 - "+RarDesc.get(k-11)),
                                    color("&9 - "+RarDesc.get(k-10)),
                                    color("&9 - "+RarDesc.get(k-9)),
                                    color("&9 - "+RarDesc.get(k-8)),
                                    color("&9 - "+RarDesc.get(k-7)),
                                    color("&9 - "+RarDesc.get(k-6)),
                                    color("&9 - "+RarDesc.get(k-5)),
                                    color("&9 - "+RarDesc.get(k-4)),
                                    color("&9 - "+RarDesc.get(k-3)),
                                    color("&9 - "+RarDesc.get(k-2)),
                                    color("&9 - "+RarDesc.get(k-1)),
                                    color("&9 - "+RarDesc.get(k)),
                                    color("&1[&9Click to open Combo Setting&1]")));
                        }else{
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>80){
                                Chance=80;
                            }else{
                                Chance= (int) (CCStats.get().getInt(nick+".Luck")*0.5);
                            }
                            RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                    color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                    color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                    color("&1[&9Chance  "+"&9"+Chance+"%&1/&980%"+"&1]"),
                                    color("&9 - "+RarDesc.get(k-11)),
                                    color("&9 - "+RarDesc.get(k-10)),
                                    color("&9 - "+RarDesc.get(k-9)),
                                    color("&9 - "+RarDesc.get(k-8)),
                                    color("&9 - "+RarDesc.get(k-7)),
                                    color("&9 - "+RarDesc.get(k-6)),
                                    color("&9 - "+RarDesc.get(k-5)),
                                    color("&9 - "+RarDesc.get(k-4)),
                                    color("&9 - "+RarDesc.get(k-3)),
                                    color("&9 - "+RarDesc.get(k-2)),
                                    color("&9 - "+RarDesc.get(k-1)),
                                    color("&9 - "+RarDesc.get(k)),
                                    color("&1[&9Click to open Combo Setting&1]")));
                        }

                    }
                }else{
                    if(v==1){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k))));
                    }else if(v==2){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k))));
                    }else if(v==3){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k))));
                    }else if(v==4){

                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&1]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-3)),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k))));
                    }else if(v==5){
                        RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                color("&9 - "+RarDesc.get(k-4)),
                                color("&9 - "+RarDesc.get(k-3)),
                                color("&9 - "+RarDesc.get(k-2)),
                                color("&9 - "+RarDesc.get(k-1)),
                                color("&9 - "+RarDesc.get(k))));
                    }else if(v==12){
                        if(!CCSkills.get().getString(nick+".Skills.Unique").contains("Lucker")&& RarSkills.get(i)=="Lucky Coin"){
                            RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                    color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                    color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                    color("&9 - "+RarDesc.get(k-11)),
                                    color("&9 - "+RarDesc.get(k-10)),
                                    color("&9 - "+RarDesc.get(k-9)),
                                    color("&9 - "+RarDesc.get(k-8)),
                                    color("&9 - "+RarDesc.get(k-7)),
                                    color("&9 - "+RarDesc.get(k-6)),
                                    color("&9 - "+RarDesc.get(k-5)),
                                    color("&9 - "+RarDesc.get(k-4)),
                                    color("&9 - "+RarDesc.get(k-3)),
                                    color("&9 - "+RarDesc.get(k-2)),
                                    color("&9 - "+RarDesc.get(k-1)),
                                    color("&9 - "+RarDesc.get(k))));
                        }else{
                            double Chance = 0;
                            if(CCStats.get().getInt(nick+".Luck")*0.5>80){
                                Chance=80;
                            }else{
                                Chance= (int) (CCStats.get().getInt(nick+".Luck")*0.5);
                            }
                            RareSkillMeta.setLore(Arrays.asList(color("&1["+"&9"+RarType.get(i)+color("&1]")),
                                    color("&1[&9Rank "+"&9"+RarRanks.get(i)+"&9]"),
                                    color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
                                    color("&1[&9Chance  "+"&9"+Chance+"%&1/&980%"+"&1]"),
                                    color("&9 - "+RarDesc.get(k-11)),
                                    color("&9 - "+RarDesc.get(k-10)),
                                    color("&9 - "+RarDesc.get(k-9)),
                                    color("&9 - "+RarDesc.get(k-8)),
                                    color("&9 - "+RarDesc.get(k-7)),
                                    color("&9 - "+RarDesc.get(k-6)),
                                    color("&9 - "+RarDesc.get(k-5)),
                                    color("&9 - "+RarDesc.get(k-4)),
                                    color("&9 - "+RarDesc.get(k-3)),
                                    color("&9 - "+RarDesc.get(k-2)),
                                    color("&9 - "+RarDesc.get(k-1)),
                                    color("&9 - "+RarDesc.get(k))));
                        }

                    }

                }
                RareSkill.setItemMeta(RareSkillMeta);

                Skills.setItem((int)taken.get(0),editItem(RareSkill.clone(),1,Arrays.asList()));
                what.add(RarSkills.get(i));
                where.add((int)taken.get(0));
                taken.remove(0);


                k++;
                i++;
            }
            k=0;
            i=0;

            for(int c = 0; c<kCmnSkills;c++){

                CommonSkill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta CommonSkillMeta = CommonSkill.getItemMeta();
                CommonSkillMeta.setDisplayName(color("&l&8"+ CmnSkills.get(i)+"&8 - Common"));
                v = (int)CmnDesc.get(k);
                k += v;
                if(CmnType.get(i).equals("ACTIVE")){
                    if(v==3){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&8]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k)),
                                color("&8[&7Click to open Combo Setting&8]")));
                    }else if(v==4){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&8]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-3)),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k)),
                                color("&8[&7Click to open Combo Setting&8]")));
                    }else if(v==5){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&6]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-4)),
                                color("&7 - "+CmnDesc.get(k-3)),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k)),
                                color("&8[&7Click to open Combo Setting&8]")));
                    }
                }else{
                    if(v==3){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&8]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k))));
                    }else if(v==4){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&8]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-3)),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k))));
                    }else if(v==5){
                        CommonSkillMeta.setLore(Arrays.asList(color("&8["+"&7"+CmnType.get(i)+color("&6]")),
                                color("&8[&7Rank "+"&7"+CmnRanks.get(i)+"&8]"),
                                color("&8[&7Proficiency  "+"&7"+CmnProfHave.get(i)+"&8/&7"+CmnProfNeed+"&8]"),
                                color("&7 - "+CmnDesc.get(k-4)),
                                color("&7 - "+CmnDesc.get(k-3)),
                                color("&7 - "+CmnDesc.get(k-2)),
                                color("&7 - "+CmnDesc.get(k-1)),
                                color("&7 - "+CmnDesc.get(k))));
                    }
                }

                CommonSkill.setItemMeta(CommonSkillMeta);

                Skills.setItem((int)taken.get(0),editItem(CommonSkill.clone(),1,Arrays.asList()));
                what.add(CmnSkills.get(i));
                where.add((int)taken.get(0));
                taken.remove(0);

                k++;
                i++;
            }











        }

        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        if(click!=null){
            switch (slot){
                case 10:
                        ItemC = inv.getItem(10);
                        ItemMeta ItemCMeta = ItemC.getItemMeta();
                    System.out.println(ItemCMeta.getDisplayName());
                    if(ItemCMeta.getDisplayName().contains("Empty")){
                        inv.setItem(10,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemCMeta.getDisplayName().contains("Left")){
                        inv.setItem(10,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemCMeta.getDisplayName().contains("Right")){
                        inv.setItem(10,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 11:
                    ItemC = inv.getItem(11);
                    ItemMeta ItemC1Meta = ItemC.getItemMeta();
                    if(ItemC1Meta.getDisplayName().contains("Empty")){
                        inv.setItem(11,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC1Meta.getDisplayName().contains("Left")){
                        inv.setItem(11,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC1Meta.getDisplayName().contains("Right")){
                        inv.setItem(11,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 12:
                    ItemC = inv.getItem(12);
                    ItemMeta ItemC2Meta = ItemC.getItemMeta();
                    if(ItemC2Meta.getDisplayName().contains("Empty")){
                        inv.setItem(12,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC2Meta.getDisplayName().contains("Left")){
                        inv.setItem(12,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC2Meta.getDisplayName().contains("Right")){
                        inv.setItem(12,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 13:
                    ItemC = inv.getItem(13);
                    ItemMeta ItemC3Meta = ItemC.getItemMeta();
                    if(ItemC3Meta.getDisplayName().contains("Empty")){
                        inv.setItem(13,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC3Meta.getDisplayName().contains("Left")){
                        inv.setItem(13,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC3Meta.getDisplayName().contains("Right")){
                        inv.setItem(13,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 14:
                    ItemC = inv.getItem(14);
                    ItemMeta ItemC4Meta = ItemC.getItemMeta();
                    if(ItemC4Meta.getDisplayName().contains("Empty")){
                        inv.setItem(14,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC4Meta.getDisplayName().contains("Left")){
                        inv.setItem(14,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC4Meta.getDisplayName().contains("Right")){
                        inv.setItem(14,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 15:
                    ItemC = inv.getItem(15);
                    ItemMeta ItemC5Meta = ItemC.getItemMeta();
                    if(ItemC5Meta.getDisplayName().contains("Empty")){
                        inv.setItem(15,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC5Meta.getDisplayName().contains("Left")){
                        inv.setItem(15,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC5Meta.getDisplayName().contains("Right")){
                        inv.setItem(15,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 16:
                    ItemC = inv.getItem(16);
                    ItemMeta ItemC6Meta = ItemC.getItemMeta();
                    if(ItemC6Meta.getDisplayName().contains("Empty")){
                        inv.setItem(16,editItem(LeftClick.clone(),1,Arrays.asList()));
                    }else if(ItemC6Meta.getDisplayName().contains("Left")){
                        inv.setItem(16,editItem(RightClick.clone(),1,Arrays.asList()));
                    }else if(ItemC6Meta.getDisplayName().contains("Right")){
                        inv.setItem(16,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    }
                    break;
                case 17:
                    //Save
                    String combo = "";
                    ItemC = inv.getItem(10);
                    ItemMeta ItemC10Meta = ItemC.getItemMeta();
                    if(!ItemC10Meta.getDisplayName().contains("Empty")){
                        if(ItemC10Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(11);
                    ItemMeta ItemC11Meta = ItemC.getItemMeta();
                    if(!ItemC11Meta.getDisplayName().contains("Empty")){
                        if(ItemC11Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(12);
                    ItemMeta ItemC12Meta = ItemC.getItemMeta();
                    if(!ItemC12Meta.getDisplayName().contains("Empty")){
                        if(ItemC12Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(13);
                    ItemMeta ItemC13Meta = ItemC.getItemMeta();
                    if(!ItemC13Meta.getDisplayName().contains("Empty")){
                        if(ItemC13Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(14);
                    ItemMeta ItemC14Meta = ItemC.getItemMeta();
                    if(!ItemC14Meta.getDisplayName().contains("Empty")){
                        if(ItemC14Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(15);
                    ItemMeta ItemC15Meta = ItemC.getItemMeta();
                    if(!ItemC15Meta.getDisplayName().contains("Empty")){
                        if(ItemC15Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }
                    ItemC = inv.getItem(16);
                    ItemMeta ItemC16Meta = ItemC.getItemMeta();
                    if(!ItemC16Meta.getDisplayName().contains("Empty")){
                        if(ItemC16Meta.getDisplayName().contains("Left")){
                            combo+="L";
                        }else{
                            combo+="R";
                        }
                    }

                    int size = CCCombos.get().getList(nick+".Skills.Name").size();
                    List ComboSkillsN = CCCombos.get().getList(nick+".Skills.Name");
                    List ComboSkillsC = CCCombos.get().getList(nick+".Skills.Combos");
                    boolean taken = false;
                    int index = ComboSkillsN.indexOf(skill);
                    if(ComboSkillsC!=null){

                        //Rewrite the combo
                        if(ComboSkillsN.contains(skill)){
                            //Is already taken (maybe by itself)
                            if(ComboSkillsC.contains(combo)){
                                //Isnt taken by itself
                                //if is taken by itself just write it hasnt been changed due to it being same as before
                                if(combo!=ComboSkillsC.get(index)){
                                    player.sendMessage(color("&e&l(!)&r&e The Combo couldn´t be saved cuz combo is already used elsewhere or here!"));
                                    inv.setItem(10,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(11,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(12,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(13,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(14,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(15,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                    inv.setItem(16,editItem(EmptyClick.clone(),1,Arrays.asList()));

                                }else{
                                    player.sendMessage(color("&e&l(!)&r&e The Combo didn´t change due to it being the same as before!"));
                                }

                            }else{
                                //combo isnt taken yet but skill is set
                                ComboSkillsC.remove(index);
                                ComboSkillsN.remove(index);
                                ComboSkillsC.add(combo);
                                ComboSkillsN.add(skill);

                                player.sendMessage(color("&e&l(!)&r&e The Combo was successfully changed!"));
                                CCCombos.get().set(nick+".Skills.Name",ComboSkillsN);
                                CCCombos.get().set(nick+".Skills.Combos",ComboSkillsC);
                                CCCombos.save();
                            }


                        }else{
                            //skill hasnt been set yet

                            //Combo isnt used
                            if(!ComboSkillsC.contains(combo)){
                                ComboSkillsN.add(skill);
                                ComboSkillsC.add(combo);
                                CCCombos.get().set(nick+".Skills.Name",ComboSkillsN);
                                CCCombos.get().set(nick+".Skills.Combos",ComboSkillsC);
                                CCCombos.save();
                                player.sendMessage(color("&e&l(!)&r&e The Combo has been successfully saved!"));
                            }else{
                                //Combo is already used
                                player.sendMessage(color("&e&l(!)&r&e The Combo couldn´t be saved cuz combo is already used elsewhere!"));
                                inv.setItem(10,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(11,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(12,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(13,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(14,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(15,editItem(EmptyClick.clone(),1,Arrays.asList()));
                                inv.setItem(16,editItem(EmptyClick.clone(),1,Arrays.asList()));
                            }
                        }







                    }




                    System.out.println(combo);
                    break;
                case 18:
                case 26:
                        player.openInventory(Skills);
                    break;
            }
        }



    }
    public ItemStack editItem(ItemStack item, int amount, List<String> lore){
        if(amount == 0) {
            //Can´t have item with amount 0
            amount = 1;
        }
        item.setAmount(amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        return item;

    }
}