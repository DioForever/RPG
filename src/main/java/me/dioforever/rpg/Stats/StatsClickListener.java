package me.dioforever.rpg.Stats;

import me.dioforever.rpg.files.CCPlayerInfo;
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

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class StatsClickListener implements Listener{
        private ItemStack Glass;
        private ItemStack WhiteGlass;
        private ItemStack Plus;
        private ItemStack Points;

    private ItemStack Health;
    private ItemStack Defense;
    private ItemStack Strength;
    private ItemStack Agility;
    private ItemStack Intelligence;
    private ItemStack Wisdom;
    private ItemStack Stamina;
    private ItemStack Luck;
    //Menu
    private ItemStack Profile;
    private ItemStack Skills;
    private ItemStack UniqueClassItem;
    private ItemStack MartialArts;
    private ItemStack Classles;
    private ItemStack Recipes;
    private ItemStack Codex;
    private ItemStack Magic;
    private ItemStack GuildI;
    private ItemStack Stats;

    private static final DecimalFormat df = new DecimalFormat("0.00");


        @EventHandler
        public void onInvClick(InventoryClickEvent event){
            Inventory inv = event.getInventory();
            if(!event.getView().getTitle().equalsIgnoreCase(color("&b&lStats"))){

                //Player doesn´t have Menu opened
                return;

            }
            //Cancel all item  moving, editing, droping etc., and player inv too
            event.setCancelled(true);
            if(event.getCurrentItem()!=null ){
                if(!event.getClickedInventory().equals(inv)){
                    return;
                }
            }

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();
            int slot = event.getSlot();
            ClickType click = event.getClick();
            String nick = player.getName();
            int PointsInt = CCStats.get().getInt(nick+".Points");

            //Glass
            Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
            ItemMeta GlassMeta = Glass.getItemMeta();
            GlassMeta.setDisplayName(color("&0-----"));
            GlassMeta.setLore(Arrays.asList(color("")));
            Glass.setItemMeta(GlassMeta);

            //WhiteGlass
            WhiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
            ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
            WhiteGlassMeta.setDisplayName(color("&f-----"));
            WhiteGlassMeta.setLore(Arrays.asList(color("")));
            WhiteGlass.setItemMeta(WhiteGlassMeta);

            //Points
            Points = new ItemStack(Material.ENDER_PEARL, PointsInt);
            ItemMeta PointsMeta = Points.getItemMeta();
            PointsMeta.setDisplayName(color("&5Stat Points: "+PointsInt));
            PointsMeta.setLore(Arrays.asList(color("")));
            Points.setItemMeta(PointsMeta);

            //Stats - ItemStacks
            if(true){
                //Health
                int HealthStat = CCStats.get().getInt(nick+".Health");
                int BHealthStat = CCStats.get().getInt(nick+".BHealth");
                Health = new ItemStack(Material.RED_WOOL);
                ItemMeta HealthMeta = Health.getItemMeta();
                HealthMeta.setDisplayName(color("&l&4[&cHealth&4]&c "+HealthStat+" &4(+"+BHealthStat+"&4)"));
                HealthMeta.setLore(Arrays.asList(
                        color("&c - Increases your Health"),
                        color("&c + 1HP per 1 point invested"),
                        color("&c = "+((CCPlayerInfo.get().getInt(nick+".MAXHP")-100))+"&cHP")));
                Health.setItemMeta(HealthMeta);

                double DefenseStat = CCStats.get().getInt(nick+".Defense");
                double BDefenseStat = CCStats.get().getInt(nick+".BDefense");
                //Defense
                Defense = new ItemStack(Material.PURPLE_WOOL);
                ItemMeta DefenseMeta = Defense.getItemMeta();
                DefenseMeta.setDisplayName(color("&l&5[&dDefense&5]&d "+DefenseStat+" &5(&d+"+BDefenseStat+"&5)"));
                DefenseMeta.setLore(Arrays.asList(
                        color("&d - Increases your Defense"),
                        color("&d + 1HP less damage per 15 points invested"),
                        color("&d - works for every type of damage"),
                        color("&d = &5"+(df.format(DefenseStat/15))+"&d (&5+"+df.format(BDefenseStat/15)+"&d)"+"&d less damage")));
                Defense.setItemMeta(DefenseMeta);

                double StrengthStat = CCStats.get().getInt(nick+".Strength");
                double BStrengthStat = CCStats.get().getInt(nick+".BStrength");
                //Strength
                Strength = new ItemStack(Material.RED_CONCRETE);
                ItemMeta StrengthMeta = Strength.getItemMeta();
                StrengthMeta.setDisplayName(color("&l&4[&cStrength&4]&c "+StrengthStat+"&4 (&c+"+BStrengthStat+"&4)"));
                StrengthMeta.setLore(Arrays.asList(
                        color("&c - Increases your Strength"),
                        color("&c + 1HP more damage per 15 points invested"),
                        color("&c - increases only your physical damage"),
                        color("&c = &4"+df.format(StrengthStat/15)+"&c (&4+"+df.format(BStrengthStat/15)+"&c)"+"&c more damage")));
                Strength.setItemMeta(StrengthMeta);

                double AgilityStat = CCStats.get().getDouble(nick+".Agility");
                double BAgilityStat = CCStats.get().getDouble(nick+".BAgility");
                //Agility
                Agility = new ItemStack(Material.GOLD_BLOCK);
                ItemMeta AgilityMeta = Agility.getItemMeta();
                AgilityMeta.setDisplayName(color("&l&6[&eAgility&6]&e "+AgilityStat+" &6(&e+"+BAgilityStat+"&6)"));
                AgilityMeta.setLore(Arrays.asList(
                        color("&e - Increases your Agility"),
                        color("&e + 0.01 speed per 5 points invested"),
                        color("&e - Maximum is 0.98 speed"),
                        color("&e - However it doesn't disable to invest"),
                        color("&e - points in this stat"),
                        color("&e = &6"+(AgilityStat/100)+"&e (&6+"+BAgilityStat/100+"&e)"+"&e% more speed")));
                Agility.setItemMeta(AgilityMeta);

                int IntelStat = CCStats.get().getInt(nick+".Intelligence");
                int BIntelStat = CCStats.get().getInt(nick+".BIntelligence");
                //Intelligence
                Intelligence = new ItemStack(Material.CYAN_WOOL);
                ItemMeta IntelligenceMeta = Intelligence.getItemMeta();
                IntelligenceMeta.setDisplayName(color("&l&3[&9Intelligence&3]&9 "+IntelStat+" &3(&9+"+BIntelStat+"&3)"));
                IntelligenceMeta.setLore(Arrays.asList(
                        color("&3 - Increases your Mana"),
                        color("&3 + 5MP per 1 point invested"),
                        color("&3 = &9"+(IntelStat*5)+"&3 (&9+"+(BIntelStat*5)+"&3)"+" more Mana")));
                Intelligence.setItemMeta(IntelligenceMeta);

                int WisdomStat = CCStats.get().getInt(nick+".Wisdom");
                int BWisdomStat = CCStats.get().getInt(nick+".BWisdom");
                //Wisdom
                Wisdom = new ItemStack(Material.LIGHT_BLUE_WOOL);
                ItemMeta WisdomMeta = Wisdom.getItemMeta();
                WisdomMeta.setDisplayName(color("&l&9[&bWisdom&9]&b "+WisdomStat+" &9(&b+"+BWisdomStat+"&9)"));

                WisdomMeta.setLore(Arrays.asList(
                        color("&9 - Increases your Mana Regeneration"),
                        color("&9 + 0.25MP/s per 10 points invested"),
                        color("&9 - up to 1% of your MP/sec"),
                        color("&9 - if you have stat higher than 1% MP/S "),
                        color("&9 - it can´t be higher than 1% and will be"),
                        color("&9 - set to 1%"),
                        color("&9 = &b"+(WisdomStat/10*0.25)+" &9(&b+"+BWisdomStat+"&9)"+"&9MP/s Mana Regen")));
                Wisdom.setItemMeta(WisdomMeta);

                int StaminaStat = CCStats.get().getInt(nick+".Stamina");
                int BStaminaStat = CCStats.get().getInt(nick+".BStamina");
                //Stamina
                Stamina = new ItemStack(Material.ORANGE_WOOL);
                ItemMeta StaminaMeta = Stamina.getItemMeta();
                StaminaMeta.setDisplayName(color("&l&6[&eStamina&6]&e "+StaminaStat+" &6(&e+"+BStaminaStat+"&6)"));
                StaminaMeta.setLore(Arrays.asList(
                        color("&e - Increases your Stamina"),
                        color("&e + 5SP per 1 point invested"),
                        color("&e = &6"+(StaminaStat*5)+"&e (&6+"+BStaminaStat+"&e)"+"&eSP more"),
                        color("&e - Regenerates 1% SP per 2sec")));
                Stamina.setItemMeta(StaminaMeta);

                double LuckStat = CCStats.get().getDouble(nick+".Luck");
                double BLuckStat = CCStats.get().getDouble(nick+".BLuck");
                //Luck
                Luck = new ItemStack(Material.EMERALD_BLOCK);
                ItemMeta LuckMeta = Luck.getItemMeta();
                LuckMeta.setDisplayName(color("&l&2[&aLuck&2]&a "+LuckStat+" &a(&2+"+BLuckStat+"&a)"));
                LuckMeta.setLore(Arrays.asList(
                        color("&a - Increases your luck"),
                        color("&a + 0.1% per 1 point invested"),
                        color("&a = &2"+(LuckStat/10)+" &a(&2+"+BLuckStat/10+"&a)"+"&a% more luck")));
                Luck.setItemMeta(LuckMeta);

                //Plus
                Plus = new ItemStack(Material.SUNFLOWER);
                ItemMeta PlusMeta = Plus.getItemMeta();
                PlusMeta.setDisplayName(color("&eClick to add Stat points"));
                PlusMeta.setLore(Arrays.asList(color("")));
                Plus.setItemMeta(PlusMeta);
            }

            //Menu
            Inventory Menu = Bukkit.createInventory(null, 27, color("&b&lMenu"));
            if(true){

                //Menu
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
                ProfileMeta.setDisplayName(color("&b&lProfile of "+ player.getName()));
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

            }





            if(click != ClickType.LEFT && click != ClickType.RIGHT){
                //We only allow single left / right clicks
                // No dropping, tripple click, shift clicking etc.
                return;
            }
            if(click!=null) {
                switch (slot) {
                    case 11:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick+".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Health");
                                CCStats.get().set(nick + ".Health", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 20:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Defense");
                                CCStats.get().set(nick + ".Defense", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 29:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Strength");
                                CCStats.get().set(nick + ".Strength", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 38:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Agility");
                                CCStats.get().set(nick + ".Agility", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 16:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Intelligence");
                                CCStats.get().set(nick + ".Intelligence", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 25:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Wisdom");
                                CCStats.get().set(nick + ".Wisdom", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 34:
                        //
                        if (click == ClickType.LEFT) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Regeneration");
                                CCStats.get().set(nick + ".Regeneration", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 43:
                        //
                        if (click == ClickType.LEFT ) {
                            int Points = CCStats.get().getInt(nick + ".Points");
                            if (Points != 0) {
                                CCStats.get().set(nick + ".Points", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Luck");
                                CCStats.get().set(nick + ".Luck", (HPStat + 1));
                                CCStats.save();
                            }
                        }
                        break;
                    case 45:
                        //
                        if (click == ClickType.LEFT) {
                            player.openInventory(Menu);
                        }
                        break;
                }
            }else{

            }
            int HPStat = CCStats.get().getInt(nick+".Health");
            int DFStat = CCStats.get().getInt(nick+".Defense");
            int STRStat = CCStats.get().getInt(nick+".Strength");
            int AGLStat = CCStats.get().getInt(nick+".Agility");
            int POINTSS = CCStats.get().getInt(nick+".Points");
            inv.setItem(10,editItem(Health.clone(),HPStat,Arrays.asList()));

            inv.setItem(19,editItem(Defense.clone(),DFStat,Arrays.asList()));

            inv.setItem(28,editItem(Strength.clone(),STRStat,Arrays.asList()));

            inv.setItem(37,editItem(Agility.clone(),AGLStat,Arrays.asList()));

            inv.setItem(49,editItem(Points.clone(),PointsInt,Arrays.asList()));


            int INTStat = CCStats.get().getInt(nick+".Intelligence");
            int WSDStat = CCStats.get().getInt(nick+".Wisdom");
            int STMStat = CCStats.get().getInt(nick+".Stamina");
            int LUCKStat = CCStats.get().getInt(nick+".Luck");
            inv.setItem(15,editItem(Intelligence.clone(),INTStat,Arrays.asList()));

            inv.setItem(24,editItem(Wisdom.clone(),WSDStat,Arrays.asList()));

            inv.setItem(33,editItem(Stamina.clone(),STMStat,Arrays.asList()));

            inv.setItem(42,editItem(Luck.clone(),LUCKStat,Arrays.asList()));



            //Update player effects stat changes(even if its nothing!)
            //1. Set health
            //Base Hearth 20, 1 heart = 2HP
            //player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D + skills.getHealth() * 2);
            //This is the 1. 8. 9. and belows way of setting
            //2. Set agility - speed increase by 10%
            //player.setWalkSpeed((float) (0.2 + ((skills.getAgility() / 10) * 0.2)));
            //3. Set intelligence

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

