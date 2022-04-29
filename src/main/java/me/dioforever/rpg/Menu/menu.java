package me.dioforever.rpg.Menu;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cod;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static me.dioforever.rpg.Utils.color;

public class menu implements CommandExecutor {

    private ItemStack Profile;
    private ItemStack Glass;
    private ItemStack Skills;
    private ItemStack UniqueClassItem;
    private ItemStack Magic;
    private ItemStack MartialArts;
    private ItemStack Classles;
    private ItemStack GuildI;
    private ItemStack Stats;
    private ItemStack Recipes;
    private ItemStack Codex;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("This feature is allowed only for players!");
            return true;
        }
        Player player = (Player) sender;
        String nick = player.getName();
        String UniqueClass = CCPlayerInfo.get().getString(nick+".Class.Unique");
        String Class = CCPlayerInfo.get().getString(nick+".Class.Normal");
        int Health = CCStats.get().getInt(nick+".Health");
        int Defense = CCStats.get().getInt(nick+".Defense");
        int Intelligence = CCStats.get().getInt(nick+".Intelligence");
        int Luck = CCStats.get().getInt(nick+".Luck");
        int Agility = CCStats.get().getInt(nick+".Agility");
        int Strength = CCStats.get().getInt(nick+".Strength");
        int Wisdom = CCStats.get().getInt(nick+".Wisdom");
        int Stamina = CCStats.get().getInt(nick+".Stamina");
        int XP = CCPlayerInfo.get().getInt(nick+".XP");
        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
        int Level = CCPlayerInfo.get().getInt(nick+".Level");
        String race = CCPlayerInfo.get().getString(nick+".Race");
        String GuildName = CCPlayerInfo.get().getString(nick + ".Guild.Name");
        String GuildPosition = CCPlayerInfo.get().getString(nick+".Guild.Position");


        //Profile
        Profile = new ItemStack(Material.NETHER_STAR,1);
        ItemMeta ProfileMeta = Profile.getItemMeta();
        ProfileMeta.setDisplayName(color("&b&lProfile of "+ sender.getName()));
        ProfileMeta.setLore(Arrays.asList
                        (color("&l&6[&eGuild&6] &e"+GuildName),
                        color("&l&6[&eGuild Position&6] &e"+GuildPosition),
                        color("&6[&eLevel&6] &e"+Level),
                        color( "&6"+XP+"&6XP"+"&6/"+XPN+"&6XP"),
                        color("&6[&eRace&6]&e "+race),
                        color("&6[&eClass&6] &e"+ Class),
                        color("&6[&eUnique Class&6]&e "+ UniqueClass),
                        color("&4[Health] "+Health),
                        color("&6[Stamina] "+ Stamina),
                        color("&c[Strength] "+Strength),
                        color("&5[Defense] "+ Defense),
                        color("&9[Intelligence] "+ Intelligence),
                        color("&b[Wisdom] "+ Wisdom),
                        color("&e[Agility] "+ Agility),
                        color("&2[Luck] "+Luck)));
        Profile.setItemMeta(ProfileMeta);
        //Glass
        Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta GlassMeta = Glass.getItemMeta();
        GlassMeta.setDisplayName(color("&0-----"));
        GlassMeta.setLore(Arrays.asList(color("")));
        Glass.setItemMeta(GlassMeta);
        //Skills
        Skills = new ItemStack(Material.RED_CONCRETE,1);
        ItemMeta SkillsMeta = Skills.getItemMeta();
        SkillsMeta.setDisplayName(color("&4&lSkills"));
        SkillsMeta.setLore(Arrays.asList(color("&7Click to open Skills")));
        Skills.setItemMeta(SkillsMeta);
        //Magic
        Magic = new ItemStack(Material.PURPLE_CONCRETE,1);
        ItemMeta MagicMeta = Magic.getItemMeta();
        MagicMeta.setDisplayName(color("&5&l[&dMage&5]&d - Magic"));
        MagicMeta.setLore(Arrays.asList(color("&dClick to open Magic")));
        Magic.setItemMeta(MagicMeta);
        //Martial Arts
        MartialArts = new ItemStack(Material.RED_CONCRETE,1);
        ItemMeta MartialArtsMeta = Magic.getItemMeta();
        MartialArtsMeta.setDisplayName(color("&4&l[&cWarrior&4]&c - Martial Arts"));
        MartialArtsMeta.setLore(Arrays.asList(color("&cClick to open Martial Arts")));
        MartialArts.setItemMeta(MartialArtsMeta);
        //Classles
        Classles = new ItemStack(Material.GRAY_CONCRETE,1);
        ItemMeta ClasslesMeta = Magic.getItemMeta();
        ClasslesMeta.setDisplayName(color("&8&l[&7CLASSLES&8]&7 - XXXXXXXX"));
        ClasslesMeta.setLore(Arrays.asList(color("&7Use /classes to chose a class")));
        Classles.setItemMeta(ClasslesMeta);
        //Guild
        GuildI = new ItemStack(Material.YELLOW_CONCRETE,1);
        ItemMeta GuildMeta = GuildI.getItemMeta();
        GuildMeta.setDisplayName(color("&e&lGuild"));
        GuildMeta.setLore(Arrays.asList(color("&7Click to open Guild")));
        GuildI.setItemMeta(GuildMeta);
        //UniqueClass
        UniqueClassItem = new ItemStack(Material.YELLOW_CONCRETE,1);
        ItemMeta UniqueClassMeta = UniqueClassItem.getItemMeta();
        UniqueClassMeta.setDisplayName(color("&6&lUnique Class"));
        UniqueClassMeta.setLore(Arrays.asList(color("&7Click to open Unique Class")));
        UniqueClassItem.setItemMeta(UniqueClassMeta);
        //Stats
        Stats = new ItemStack(Material.LIGHT_BLUE_CONCRETE,1);
        ItemMeta StatsMeta = GuildI.getItemMeta();
        StatsMeta.setDisplayName(color("&b&lStats"));
        StatsMeta.setLore(Arrays.asList(color("&7Click to open Stats")));
        Stats.setItemMeta(StatsMeta);
        //Stats
        Recipes = new ItemStack(Material.LIME_TERRACOTTA,1);
        ItemMeta RecipesMeta = GuildI.getItemMeta();
        RecipesMeta.setDisplayName(color("&a&lRecipes"));
        RecipesMeta.setLore(Arrays.asList(color("&7Click to open Recipes")));
        Recipes.setItemMeta(RecipesMeta);
        //Stats
        Codex = new ItemStack(Material.CYAN_TERRACOTTA,1);
        ItemMeta CodexMeta = GuildI.getItemMeta();
        CodexMeta.setDisplayName(color("&7&lMonster Codex"));
        CodexMeta.setLore(Arrays.asList(color("&7Click to open Monster Codex")));
        Codex.setItemMeta(CodexMeta);



        Inventory Menu = Bukkit.createInventory(null, 27, color("&b&lMenu"));
        Menu.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(4,editItem(Profile.clone(),1,Arrays.asList("")));
        Menu.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
        //Menu.setItem(10,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(11,editItem(Skills.clone(),1,Arrays.asList("")));
        if(Class.equals("Classles")){
            Menu.setItem(12,editItem(Classles.clone(),1,Arrays.asList("")));
        }else if(Class.equals("Mage")){
            Menu.setItem(12,editItem(Magic.clone(),1,Arrays.asList("")));
        }else if(Class.equals("Warrior")){
            Menu.setItem(12,editItem(MartialArts.clone(),1,Arrays.asList("")));
        }
        Menu.setItem(13,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(14,editItem(GuildI.clone(),1,Arrays.asList("")));
        Menu.setItem(10,editItem(UniqueClassItem.clone(),1,Arrays.asList("")));
        Menu.setItem(15,editItem(Recipes.clone(),1,Arrays.asList("")));
        Menu.setItem(16,editItem(Codex.clone(),1,Arrays.asList("")));
        //Menu.setItem(16,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(19,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(20,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(22,editItem(Stats.clone(),1,Arrays.asList("")));
        Menu.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(24,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(25,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
        player.openInventory(Menu);


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
