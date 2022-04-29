package me.dioforever.rpg.Listeners;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static me.dioforever.rpg.Utils.color;

public class JoinListener implements Listener {

    static Main plugin;
    private ItemStack Human;
    private ItemStack Elf;
    private ItemStack Dwarf;
    private ItemStack Dragonborn;
    private ItemStack Undead;
    private ItemStack Mage;
    private ItemStack Warrior;
    private ItemStack Glass;

    public JoinListener(Main main){
        plugin = main;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        String nick = player.getName();
        List empty= new ArrayList<>();
        empty.add(" ");
        empty.add(" ");
        List empt = new ArrayList<>();
        empt.add(" ");
        empt.add(" ");
        List empts = new ArrayList<>();
        empts.add(" ");
        empts.add(" ");


        System.out.println(ChatColor.AQUA + player.getName() + " has joined the server!");
        String PC = CCPlayerInfo.get().getString(nick+".PC");
        if(CCPlayerInfo.get().getString(nick+".Race")==null){
            CCPlayerInfo.get().addDefault(nick+".Race","None");
        }
        if(CCPlayerInfo.get().getString(nick+".Class.Normal")==null){
            CCPlayerInfo.get().addDefault(nick+".Race","Classes");
        }
        if(CCPlayerInfo.get().getString(nick+".Race")==null){
            CCPlayerInfo.get().addDefault(nick+".Race","None");
        }

        if (PC == null) {


            //PlayerInfo
            CCPlayerInfo.get().addDefault(nick+".PC", "Player Created");
            CCPlayerInfo.get().addDefault(nick+".Race","None");
            CCPlayerInfo.get().addDefault(nick+".Class.Normal","Classles");
            CCPlayerInfo.get().addDefault(nick+".LevelBars",true);
            //Mana, HP
            CCLeft.get().addDefault(nick+".MPBNS",0);
            CCLeft.get().addDefault(nick+".SP",80);
            CCLeft.get().addDefault(nick+".SPBNS",0);
            CCLeft.get().addDefault(nick+".MP",80);
            CCLeft.get().addDefault(nick + ".MAXMP", 80);
            CCLeft.get().addDefault(nick + ".HP", 100);

            CCLeft.get().set(nick+".Skills.Activated",empt);
            CCLeft.get().set(nick+".Magic.Activated",empt);
            CCLeft.get().set(nick+".MArts.Activated",empt);
            CCLeft.get().set(nick+".Speed",100);
            CCLeft.save();



            Random randomCh = new Random();
            //Achieved
            CCAchieved.get().addDefault(nick+".Mined.Wood",0);
            CCAchieved.get().addDefault(nick+".Mined.EarthBlocks",0);
            CCAchieved.get().addDefault(nick+".Farmed",0);
            CCAchieved.get().addDefault(nick+".Used.Sword",0);
            CCAchieved.get().addDefault(nick+".Used.Bow",0);
            CCAchieved.get().addDefault(nick+".Used.CrossBow",0);
            CCAchieved.get().addDefault(nick+".Used.Trident",0);
            CCAchieved.get().addDefault(nick+".Used.Shield",0);
            CCAchieved.get().addDefault(nick+".Enchanted",0);
            CCAchieved.save();

            //Unique Class
            int min = 1;
            int max = 84;

            int UniqueSkill = randomCh.nextInt((max - min)) + min;
            if (!(CCStats.get().contains(nick + ".Health"))) {
                //Stats
                //B - Bonus, if some skill, rune of equipment adds stats
                CCStats.get().addDefault(nick+".Points",2);
                CCStats.get().addDefault(nick + ".Health", 10);
                CCStats.get().addDefault(nick + ".BHealth",0);
                CCStats.get().addDefault(nick + ".THealth",0);
                CCStats.get().addDefault(nick + ".Stamina", 10);
                CCStats.get().addDefault(nick + ".BStamina", 0);
                CCStats.get().addDefault(nick + ".TStamina", 0);
                CCStats.get().addDefault(nick + ".Defense", 10);
                CCStats.get().addDefault(nick + ".BDefense", 0);
                CCStats.get().addDefault(nick + ".TDefense", 0);
                CCStats.get().addDefault(nick + ".Intelligence", 10);
                CCStats.get().addDefault(nick + ".BIntelligence", 0);
                CCStats.get().addDefault(nick + ".TIntelligence", 0);
                CCStats.get().addDefault(nick + ".Luck", 10);
                CCStats.get().addDefault(nick + ".BLuck", 0);
                CCStats.get().addDefault(nick + ".TLuck", 0);
                CCStats.get().addDefault(nick + ".Agility", 10);
                CCStats.get().addDefault(nick + ".BAgility", 0);
                CCStats.get().addDefault(nick + ".TAgility", 0);
                CCStats.get().addDefault(nick + ".Strength", 10);
                CCStats.get().addDefault(nick + ".BStrength", 0);
                CCStats.get().addDefault(nick + ".TStrength", 0);
                CCStats.get().addDefault(nick + ".Wisdom", 10);
                CCStats.get().addDefault(nick + ".BWisdom", 0);
                CCStats.get().addDefault(nick + ".TWisdom", 0);
                CCStats.save();
            }

            if (!(CCMagic.get().contains(nick + ".Magic"))) {
                //Magic
                CCMagic.get().addDefault(nick + ".Magic", "");
                CCMagic.save();
            }

            if (!(CCStats.get().contains(nick + ".Level"))) {
                //PlayerInfo

                CCPlayerInfo.get().addDefault(nick + ".Level", 1);
                CCPlayerInfo.get().addDefault(nick + ".XP", 0);
                //XP Multiplier
                CCPlayerInfo.get().addDefault(nick + ".MXP",1);
                CCPlayerInfo.get().addDefault(nick + ".XPNeeded", 100);
                CCPlayerInfo.get().addDefault(nick + ".Guild.Name", "None");
                CCPlayerInfo.get().addDefault(nick+".Guild.Position","None");
                CCPlayerInfo.save();
            }
            List trash = new ArrayList<>();
            List trash1 = new ArrayList<>();
            List trash2 = new ArrayList<>();
            List trash3 = new ArrayList<>();
            List desrp = new ArrayList<>();
            List desrp1 = new ArrayList<>();
            List desrp2 = new ArrayList<>();
            List desrp3 = new ArrayList<>();
            List Rank = new ArrayList<>();
            List Rank1 = new ArrayList<>();
            List Rank2 = new ArrayList<>();
            List Rank3 = new ArrayList<>();

            List Prof = new ArrayList<Integer>();
            List Prof1 = new ArrayList<Integer>();
            List Prof2 = new ArrayList<Integer>();
            List Prof3 = new ArrayList<Integer>();
            List ProfN = new ArrayList<Integer>();
            List Prof1N = new ArrayList<Integer>();
            List Prof2N = new ArrayList<Integer>();
            List Prof3N = new ArrayList<Integer>();
            List Type = new ArrayList<>();
            List Type1 = new ArrayList<>();
            List Type2 = new ArrayList<>();
            List Type3 = new ArrayList<>();

            List Empty1 = new ArrayList<>();
            List Empty2 = new ArrayList<>();
            List Empty3 = new ArrayList<>();
            List Empty4 = new ArrayList<>();
            List Empty5 = new ArrayList<>();
            List Empty6 = new ArrayList<>();

            //Skills
            //Names
            CCSkills.get().addDefault(nick+".Skills.Legendary.Name",trash);
            CCSkills.get().addDefault(nick+".Skills.Epic.Name",trash1);
            CCSkills.get().addDefault(nick+".Skills.Rare.Name",trash2);
            CCSkills.get().addDefault(nick+".Skills.Common.Name",trash3);
            CCSkills.save();
            //Type
            CCSkills.get().addDefault(nick+".Skills.Legendary.Type",Type);
            CCSkills.get().addDefault(nick+".Skills.Epic.Type",Type1);
            CCSkills.get().addDefault(nick+".Skills.Rare.Type",Type2);
            CCSkills.get().addDefault(nick+".Skills.Common.Type",Type3);
            CCSkills.save();
            //Rank
            CCSkills.get().addDefault(nick+".Skills.Legendary.Rank",Rank);
            CCSkills.get().addDefault(nick+".Skills.Epic.Rank",Rank1);
            CCSkills.get().addDefault(nick+".Skills.Rare.Rank",Rank2);
            CCSkills.get().addDefault(nick+".Skills.Common.Rank",Rank3);
            CCSkills.save();
            //Proficiency
            CCSkills.get().addDefault(nick+".Skills.Legendary.Proficiency.Have",Prof);
            CCSkills.get().addDefault(nick+".Skills.Epic.Proficiency.Have",Prof1);
            CCSkills.get().addDefault(nick+".Skills.Rare.Proficiency.Have",Prof2);
            CCSkills.get().addDefault(nick+".Skills.Common.Proficiency.Have",Prof3);
            CCSkills.save();

            CCSkills.get().addDefault(nick+".Skills.Legendary.Proficiency.Need",ProfN);
            CCSkills.get().addDefault(nick+".Skills.Epic.Proficiency.Need",Prof1N);
            CCSkills.get().addDefault(nick+".Skills.Rare.Proficiency.Need",Prof2N);
            CCSkills.get().addDefault(nick+".Skills.Common.Proficiency.Need",Prof3N);
            CCSkills.save();
            //Descriptions
            CCSkills.get().addDefault(nick+".Skills.Legendary.Description",desrp);
            CCSkills.get().addDefault(nick+".Skills.Epic.Description",desrp1);
            CCSkills.get().addDefault(nick+".Skills.Rare.Description",desrp2);
            CCSkills.get().addDefault(nick+".Skills.Common.Description",desrp3);
            CCSkills.save();

            //Combos

            CCCombos.get().addDefault(nick+".Skills.Name",Empty1);
            CCCombos.get().addDefault(nick+".Skills.Combos",Empty2);
            CCCombos.get().addDefault(nick+".Magic.Name",Empty3);
            CCCombos.get().addDefault(nick+".Magic.Combos",Empty4);
            CCCombos.get().addDefault(nick+".MArts.Name",Empty5);
            CCCombos.get().addDefault(nick+".MArts.Combos",Empty6);
            CCCombos.save();

            //Unique Skills
            if(true){
                if (UniqueSkill == 1 || UniqueSkill == 2 || UniqueSkill == 3 || UniqueSkill == 4 || UniqueSkill == 5 || UniqueSkill == 6) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Reinforcer");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as strong willed individual so you are granted &5&lReinforcer"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill == 7 || UniqueSkill == 8 || UniqueSkill == 9 || UniqueSkill == 10 || UniqueSkill == 11 || UniqueSkill == 12) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Lucker I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as Lucky individual so you are granted &a&lLucker"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill == 13 || UniqueSkill == 14 || UniqueSkill == 15 || UniqueSkill == 16 || UniqueSkill == 17 || UniqueSkill == 18) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Miner I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as one with Earth so you are granted &6&lMiner"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill == 19 || UniqueSkill == 20 || UniqueSkill == 21 || UniqueSkill == 22 || UniqueSkill == 23 || UniqueSkill == 24) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Tank I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as a Solid guy so you are granted &4&lTank"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill == 25 || UniqueSkill == 26 || UniqueSkill == 27 || UniqueSkill == 28 || UniqueSkill == 29 || UniqueSkill == 30) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Blacksmith I");
                    player.sendMessage(color("&2The &lGaia &2has recognized your talent"));
                    player.sendMessage(color("&2at blacksmithing so you are granted &3&lJumper"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill == 31 || UniqueSkill == 32 || UniqueSkill == 33 || UniqueSkill == 34 || UniqueSkill == 35 || UniqueSkill == 36) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Night Watcher I");
                    player.sendMessage(color("&2The &lGaia &2has recognized your"));
                    player.sendMessage(color("&2talent of seeing rare things so you get &1&lNight Watcher"));
                    CCPlayerInfo.save();
                }

                // Tier II
                if (UniqueSkill==37 || UniqueSkill==38|| UniqueSkill==39|| UniqueSkill==40 ||UniqueSkill==41 ||UniqueSkill==42) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Tank I");
                    System.out.println("Tank I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as a Solid guy so you are granted &4&lTank"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill==43 || UniqueSkill==44|| UniqueSkill==45|| UniqueSkill==46 ||UniqueSkill==47 ||UniqueSkill==48) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Third Eye I");
                    player.sendMessage(color("&2The &lGaia &2has recognized your"));
                    player.sendMessage(color("&2talent at observing hidden things so you are granted &5&lThird Eye"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill==49 || UniqueSkill==50|| UniqueSkill==51|| UniqueSkill==52 ||UniqueSkill==53 ||UniqueSkill==54) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Blood Thief I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as persevering so you are granted &c&lBlood Thief"));
                    CCPlayerInfo.save();
                }
                if(UniqueSkill==79 || UniqueSkill==80|| UniqueSkill==81|| UniqueSkill==82 ||UniqueSkill==83 ||UniqueSkill==84){
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Descendant of Giants");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as Strong so you are granted &4&lPower of Giant"));
                    CCPlayerInfo.save();
                }

                if (UniqueSkill==55 || UniqueSkill==56|| UniqueSkill==57|| UniqueSkill==58 ||UniqueSkill==59 ||UniqueSkill==60) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Master Swordsman I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as good Swordsman so you are granted &c&lMaster Swordsman"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill==61 || UniqueSkill==62|| UniqueSkill==63|| UniqueSkill==64 ||UniqueSkill==65 ||UniqueSkill==66) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Master Archer I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as good Archer so you get &c&lMaster Archer"));
                    CCPlayerInfo.save();
                }
                //Tier III
                if (UniqueSkill==67 || UniqueSkill==68|| UniqueSkill==69|| UniqueSkill==70) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique","Mana Chosen I");
                    player.sendMessage(color("&2The &lGaia &2has seen you"));
                    player.sendMessage(color("&2as one with Mana so you are granted &b&lMana Chosen"));
                    CCPlayerInfo.save();
                }

                if (UniqueSkill==71 || UniqueSkill==72|| UniqueSkill==73|| UniqueSkill==74) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Commander I");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as Commander in nature so you are granted &4&lCommander"));
                    CCPlayerInfo.save();
                }
                if (UniqueSkill==75 || UniqueSkill==76|| UniqueSkill==77|| UniqueSkill==78) {
                    CCPlayerInfo.get().addDefault(nick + ".Class.Unique", "Solo I ");
                    player.sendMessage(color("&2The &lGaia &2has recognized you"));
                    player.sendMessage(color("&2as an strong individual so you are granted &6&lSolo"));
                    CCPlayerInfo.save();
                }
            }
            Inventory rc = Bukkit.createInventory(null, 27,color("&5&lChoose a race and a class"));
            if(true){
                if(true){
                    //Creating inventory


                    //Glass
                    Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
                    ItemMeta GlassMeta = Glass.getItemMeta();
                    GlassMeta.setDisplayName(color("&0-----"));
                    GlassMeta.setLore(Arrays.asList(color("")));
                    Glass.setItemMeta(GlassMeta);

                    //Human - Race
                    Human = new ItemStack(Material.LLAMA_SPAWN_EGG,1);
                    ItemMeta HumanMeta = Human.getItemMeta();
                    HumanMeta.setDisplayName(color("&l&aThe Human Race "));
                    HumanMeta.setLore(Arrays.asList
                            (color("&a- The Human race is race which"),
                                    color("&a- is not good or bad specifically at anything."),
                                    color( "&a- Agility +2"),
                                    color("&a- Strength +2"),
                                    color("&a- Defense +2"),
                                    color("&a- Health +2"),
                                    color("&a- Intelligence +2"),
                                    color("&a- &5[&dGoddess' Blessing&5]&a Epic Skill"),
                                    color("&a  - You get 5% more XP from everything"),
                                    color("&a  - UNGROWABLE")));
                    Human.setItemMeta(HumanMeta);
                    //Elf - Race
                    Elf = new ItemStack(Material.CREEPER_SPAWN_EGG,1);
                    ItemMeta ElfMeta = Elf.getItemMeta();
                    ElfMeta.setDisplayName(color("&l&2The Elf Race "));
                    ElfMeta.setLore(Arrays.asList
                            (color("&a- The Elf race is race has good agility,"),
                                    color("&a- intelligence and strength."),
                                    color( "&a- Agility +5"),
                                    color("&a- Strength +5"),
                                    color("&a- &1[&9Friend of Nature&1]&a Rare Skill"),
                                    color("&a  - if attacked and at 20% health"),
                                    color("&a  - two Dire Wolfs with the level 3"),
                                    color("&a  - will be summoned for 30 seconds"),
                                    color("&c  - with 5 min cooldown")));
                    Elf.setItemMeta(ElfMeta);
                    //Dwarf - Race
                    Dwarf = new ItemStack(Material.BAT_SPAWN_EGG,1);
                    ItemMeta DwarfMeta = Dwarf.getItemMeta();
                    DwarfMeta.setDisplayName(color("&l&6The Dwarf Race "));
                    DwarfMeta.setLore(Arrays.asList
                            (color("&e- The Dwarf race is has high defense,"),
                                    color("&e- health, strength."),
                                    color( "&e- Defense +4"),
                                    color("&e- Health +3"),
                                    color("&e- Strength +3"),
                                    color("&a- &1[&9Toughness&1]&e Rare Skill"),
                                    color("&e  - Attacks that deal 5HP or less"),
                                    color("&e  - are ignored"),
                                    color("&e  - UNGROWABLE")));
                    Dwarf.setItemMeta(DwarfMeta);
                    //Dragonborn - Race
                    Dragonborn = new ItemStack(Material.SPIDER_SPAWN_EGG,1);
                    ItemMeta DragonbornMeta = Dragonborn.getItemMeta();
                    DragonbornMeta.setDisplayName(color("&l&4The Dragonborn Race "));
                    DragonbornMeta.setLore(Arrays.asList
                            (color("&c- The Dragonborn race has high intelligence"),
                                    color("&c- and strength."),
                                    color( "&c- Intelligence +5"),
                                    color("&c- Strength +5"),
                                    color("&c- &1[&9Incomplete Fire Dragon's Scales&1]&c Rare Skill"),
                                    color("&c  - You are immune to fire for 5seconds"),
                                    color("&c  - from the moment you are on fire"),
                                    color("&c  - with 30 sec cooldown")));
                    Dragonborn.setItemMeta(DragonbornMeta);
                    //Undead - Race
                    Undead = new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG,1);
                    ItemMeta UndeadMeta = Undead.getItemMeta();
                    UndeadMeta.setDisplayName(color("&l&7The Undead"));
                    UndeadMeta.setLore(Arrays.asList
                            (color("&7- The Undead race has high intelligence"),
                                    color("&7- and wisdom"),
                                    color( "&7- Intelligence +6"),
                                    color("&7- Wisdom + 6"),
                                    color("&7- Health -2"),
                                    color("&7- &1[&9Twisted Sun and Moon&1]&7 Rare Skill"),
                                    color("&7  - You are cursed when the sun is up"),
                                    color("&7  - for 10% of all your stats and"),
                                    color("&7  - you are boosted by 15% when its night")
                            ));
                    Undead.setItemMeta(UndeadMeta);
                    //Classes
                    Mage = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
                    ItemMeta MageMeta = Mage.getItemMeta();
                    MageMeta.setDisplayName(color("&l&5[&dMage&5]"));
                    MageMeta.setLore(Arrays.asList
                            (color("&d- Uses mana to perform any type of Magic")));
                    Mage.setItemMeta(MageMeta);

                    Warrior = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
                    ItemMeta  WarriorMeta =  Warrior.getItemMeta();
                    WarriorMeta.setDisplayName(color("&l&4[&cWarrior&4]"));
                    WarriorMeta.setLore(Arrays.asList
                            (color("&c- Uses stamina to perform Martial Arts"),
                                    color("&c- and other attacks")));
                    Warrior.setItemMeta( WarriorMeta);


                    //Inventory Race and Class - Settings
                    rc.setItem(0,Glass);
                    rc.setItem(1,Glass);
                    rc.setItem(2,Glass);
                    rc.setItem(3,Glass);
                    rc.setItem(4,Glass);
                    rc.setItem(5,Glass);
                    rc.setItem(6,Glass);
                    rc.setItem(7,Glass);
                    rc.setItem(8,Glass);
                    rc.setItem(9,Glass);
                    rc.setItem(10,Glass);
                    rc.setItem(11,editItem(Human.clone(),1,Arrays.asList()));
                    rc.setItem(12,editItem(Elf.clone(),1,Arrays.asList()));
                    rc.setItem(13,editItem(Dwarf.clone(),1,Arrays.asList()));
                    rc.setItem(14,editItem(Dragonborn.clone(),1,Arrays.asList()));
                    rc.setItem(15,editItem(Undead.clone(),1,Arrays.asList()));
                    rc.setItem(16,Glass);
                    rc.setItem(17,Glass);
                    rc.setItem(18,Glass);
                    rc.setItem(19,Glass);
                    rc.setItem(20,Glass);
                    rc.setItem(21,editItem(Mage.clone(),1,Arrays.asList()));
                    rc.setItem(22,Glass);
                    rc.setItem(23,editItem(Warrior.clone(),1,Arrays.asList()));
                    rc.setItem(24,Glass);
                    rc.setItem(25,Glass);
                    rc.setItem(26,Glass);

                }
            }



            player.sendMessage(color("&aUse &l/races or /classes &r&acommand to chose a race!"));

            CCPlayerInfo.save();

            Bukkit.getScheduler().runTaskLater(plugin, () -> player.openInventory(rc), 120);
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
