package me.dioforever.rpg.commands.Races;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static me.dioforever.rpg.Utils.color;


public class Races implements CommandExecutor {

    private ItemStack Human;
    private ItemStack Elf;
    private ItemStack Dwarf;
    private ItemStack Dragonborn;
    private ItemStack Undead;

    private ItemStack Warrior;
    private ItemStack Mage;

    private ItemStack Glass;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(true){
                //Creating inventory
                Inventory rc = Bukkit.createInventory(null, 27,color("&5&lChoose a race and a class"));

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

                player.openInventory(rc);
            }

        }

        return true;
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
