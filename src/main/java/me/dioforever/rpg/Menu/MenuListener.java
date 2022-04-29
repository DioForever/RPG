package me.dioforever.rpg.Menu;

import me.dioforever.rpg.files.*;
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
import java.util.*;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class MenuListener implements Listener {

    private ItemStack MagicBench;
    private ItemStack MagicAnvil;
    private ItemStack MagicFurnace;
    private ItemStack ExtractionTable;
    private ItemStack ManaHeatGenerator;
    private ItemStack ManaLightningGenerator;
    private ItemStack ManaWaterGenerator;
    private ItemStack ManaStorageLowTier;
    private ItemStack ManaStorageMidTier;
    private ItemStack ManaStorageHighTier;
    private ItemStack HarvestingStation;
    private ItemStack TravelStation;
    private ItemStack TowerOfSorcery;
    private ItemStack ProtectionTowerLowTier;
    private ItemStack ProtectionTowerMidTier;
    private ItemStack ProtectionTowerHighTier;



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



    //Runner
    private ItemStack RunnerI;
    private ItemStack RunnerII;
    private ItemStack RunnerIII;
    //Tank
    private ItemStack TankI;
    private ItemStack TankII;
    private ItemStack TankIII;
    //Jumper
    private ItemStack JumperI;
    private ItemStack JumperII;
    private ItemStack JumperIII;

    //Lucker
    private ItemStack LuckerI;
    private ItemStack LuckerII;
    private ItemStack LuckerIII;

    //Third Eye
    private ItemStack ThirdEyeI;
    private ItemStack ThirdEyeII;
    private ItemStack ThirdEyeIII;

    //Blood Thief
    private ItemStack BloodThiefI;
    private ItemStack BloodThiefII;
    private ItemStack BloodThiefIII;

    //Mana Chosen
    private ItemStack ManaAffinityI;
    private ItemStack ManaAffinityII;
    private ItemStack ManaAffinityIII;


    //Night Watcher
    private ItemStack NightWatcherI;
    private ItemStack NightWatcherII;
    private ItemStack NightWatcherIII;


    //Power of Giant
    private ItemStack PowerOfGiantI;
    private ItemStack PowerOfGiantII;
    private ItemStack PowerOfGiantIII;


    //Master Swordsman
    private ItemStack MasterSwordsmanI;
    private ItemStack MasterSwordsmanII;
    private ItemStack MasterSwordsmanIII;


    //Master Archer
    private ItemStack MasterArcherI;
    private ItemStack MasterArcherII;
    private ItemStack MasterArcherIII;


    //Commander
    private ItemStack CommanderI;
    private ItemStack CommanderII;
    private ItemStack CommanderIII;

    //Solo
    private ItemStack SoloI;
    private ItemStack SoloII;
    private ItemStack SoloIII;


    //Reinforcer
    private ItemStack ReinforcementsI;
    private ItemStack ReinforcementsII;
    private ItemStack ReinforcementsIII;


    //Skills
    private ItemStack LegendarySkill;
    private ItemStack EpicSkill;
    private ItemStack RareSkill;
    private ItemStack CommonSkill;


    private static final DecimalFormat df = new DecimalFormat("0.00");




    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&b&lMenu"))){

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
        WhiteGlassMeta.setDisplayName(color("&l&bMenu"));
        WhiteGlassMeta.setLore(Arrays.asList(color("&bClick to go back to Menu")));
        WhiteGlass.setItemMeta(WhiteGlassMeta);

        //Points
        Points = new ItemStack(Material.ENDER_PEARL, PointsInt);
        ItemMeta PointsMeta = Points.getItemMeta();
        PointsMeta.setDisplayName(color("&5Stat Points: "+PointsInt));
        PointsMeta.setLore(Arrays.asList(color("")));
        Points.setItemMeta(PointsMeta);



        int MAXHP = (int) player.getMaxHealth();
        int HPWRITE = MAXHP-100;

        //Stats - Menu
        Inventory Stats = Bukkit.createInventory(null,54,color("&b&lStats"));

        if(true){
            //Health
            int HealthStat = CCStats.get().getInt(nick+".Health");
            int BHealthStat = CCStats.get().getInt(nick+".BHealth");
            int THealthStat = CCStats.get().getInt(nick+".THealth");
            Health = new ItemStack(Material.RED_WOOL);
            ItemMeta HealthMeta = Health.getItemMeta();
            if(THealthStat>=0){
                HealthMeta.setDisplayName(color("&l&4[&cHealth&4]&c "+HealthStat+" &4(+"+BHealthStat+"&4) " +"&4(+"+THealthStat+"&4)"));
            }else{
                HealthMeta.setDisplayName(color("&l&4[&cHealth&4]&c "+HealthStat+" &4(+"+BHealthStat+"&4) " +"&4("+THealthStat+"&4)"));
            }
            HealthMeta.setLore(Arrays.asList(
                    color("&c - Increases your Health"),
                    color("&c + 1HP per 1 point invested"),
                    color("&c = "+((CCLeft.get().getInt(nick+".MAXHP")-100))+"&cHP")));
            Health.setItemMeta(HealthMeta);

            double DefenseStat = CCStats.get().getInt(nick+".Defense");
            double BDefenseStat = CCStats.get().getInt(nick+".BDefense");
            double TDefenseStat = CCStats.get().getInt(nick+".TDefense");
            //Defense
            Defense = new ItemStack(Material.PURPLE_WOOL);
            ItemMeta DefenseMeta = Defense.getItemMeta();
            if(TDefenseStat>=0){
                DefenseMeta.setDisplayName(color("&l&5[&dDefense&5]&d "+DefenseStat+" &5(&d+"+BDefenseStat+"&5)"+" &5(&d+"+TDefenseStat+"&5)"));
            }else{
                DefenseMeta.setDisplayName(color("&l&5[&dDefense&5]&d "+DefenseStat+" &5(&d+"+BDefenseStat+"&5)"+" &5(&d"+TDefenseStat+"&5)"));
            }

            DefenseMeta.setLore(Arrays.asList(
                    color("&d - Increases your Defense"),
                    color("&d + 5HP less damage per 10 points invested"),
                    color("&d - works only for Physical type of damage"),
                    color("&d = &5"+(df.format(DefenseStat/15))+"&d (&5+"+df.format(BDefenseStat/15)+"&d)"+"&d less damage")));
            Defense.setItemMeta(DefenseMeta);

            double StrengthStat = CCStats.get().getInt(nick+".Strength");
            double BStrengthStat = CCStats.get().getInt(nick+".BStrength");
            double TStrengthStat = CCStats.get().getInt(nick+".TStrength");
            //Strength
            Strength = new ItemStack(Material.RED_CONCRETE);
            ItemMeta StrengthMeta = Strength.getItemMeta();
            if(TStrengthStat>=0){
                StrengthMeta.setDisplayName(color("&l&4[&cStrength&4]&c "+StrengthStat+"&4 (&c+"+BStrengthStat+"&4)"+ "&4 (&c+"+TStrengthStat+"&4)"));
            }else{
                StrengthMeta.setDisplayName(color("&l&4[&cStrength&4]&c "+StrengthStat+"&4 (&c+"+BStrengthStat+"&4)"+ "&4 (&c"+TStrengthStat+"&4)"));
            }

            StrengthMeta.setLore(Arrays.asList(
                    color("&c - Increases your Strength"),
                    color("&c + 5HP more damage per 10 points invested"),
                    color("&c - increases only your physical damage"),
                    color("&c = &4"+df.format(StrengthStat/15)+"&c (&4+"+df.format(BStrengthStat/15)+"&c)"+"&c more damage")));
            Strength.setItemMeta(StrengthMeta);

            double AgilityStat = CCStats.get().getDouble(nick+".Agility");
            double BAgilityStat = CCStats.get().getDouble(nick+".BAgility");
            double TAgilityStat = CCStats.get().getDouble(nick+".TAgility");
            //Agility
            Agility = new ItemStack(Material.GOLD_BLOCK);
            ItemMeta AgilityMeta = Agility.getItemMeta();
            if(TAgilityStat>=0){
                AgilityMeta.setDisplayName(color("&l&6[&eAgility&6]&e "+AgilityStat+" &6(&e+"+BAgilityStat+"&6)" +" &6(&e+"+BAgilityStat+"&6)"));
            }else{
                AgilityMeta.setDisplayName(color("&l&6[&eAgility&6]&e "+AgilityStat+" &6(&e+"+BAgilityStat+"&6)" +" &6(&e"+BAgilityStat+"&6)"));
            }
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
            int TIntelStat = CCStats.get().getInt(nick+".TIntelligence");
            //Intelligence
            Intelligence = new ItemStack(Material.CYAN_WOOL);
            ItemMeta IntelligenceMeta = Intelligence.getItemMeta();
            if(TIntelStat>=0){
                IntelligenceMeta.setDisplayName(color("&l&3[&9Intelligence&3]&9 "+IntelStat+" &3(&9+"+BIntelStat+"&3)"+" &3(&9+"+TIntelStat+"&3)"));
            }else{
                IntelligenceMeta.setDisplayName(color("&l&3[&9Intelligence&3]&9 "+IntelStat+" &3(&9+"+BIntelStat+"&3)"+" &3(&9"+TIntelStat+"&3)"));
            }
            IntelligenceMeta.setLore(Arrays.asList(
                    color("&3 - Increases your Mana"),
                    color("&3 + 5MP per 1 point invested"),
                    color("&3 = &9"+(IntelStat*5)+"&3 (&9+"+(BIntelStat*5)+"&3)"+" more Mana")));
            Intelligence.setItemMeta(IntelligenceMeta);

            int WisdomStat = CCStats.get().getInt(nick+".Wisdom");
            int BWisdomStat = CCStats.get().getInt(nick+".BWisdom");
            int TWisdomStat = CCStats.get().getInt(nick+".TWisdom");
            //Wisdom
            Wisdom = new ItemStack(Material.LIGHT_BLUE_WOOL);
            ItemMeta WisdomMeta = Wisdom.getItemMeta();
            if(TWisdomStat>=0){
                WisdomMeta.setDisplayName(color("&l&9[&bWisdom&9]&b "+WisdomStat+" &9(&b+"+BWisdomStat+"&9)"+" &9(&b+"+TWisdomStat+"&9)"));
            }else{
                WisdomMeta.setDisplayName(color("&l&9[&bWisdom&9]&b "+WisdomStat+" &9(&b+"+BWisdomStat+"&9)"+" &9(&b"+TWisdomStat+"&9)"));
            }

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
            int TStaminaStat = CCStats.get().getInt(nick+".TStamina");
            //Stamina
            Stamina = new ItemStack(Material.ORANGE_WOOL);
            ItemMeta StaminaMeta = Stamina.getItemMeta();
            if(TStaminaStat>=0){
                StaminaMeta.setDisplayName(color("&l&6[&eStamina&6]&e "+StaminaStat+" &6(&e+"+BStaminaStat+"&6)"+" &6(&e+"+TStaminaStat+"&6)"));
            }else{
                StaminaMeta.setDisplayName(color("&l&6[&eStamina&6]&e "+StaminaStat+" &6(&e+"+BStaminaStat+"&6)"+" &6(&e"+TStaminaStat+"&6)"));
            }StaminaMeta.setLore(Arrays.asList(
                    color("&e - Increases your Stamina"),
                    color("&e + 5SP per 1 point invested"),
                    color("&e = &6"+(StaminaStat*5)+"&e (&6+"+BStaminaStat+"&e)"+"&eSP more"),
                    color("&e - Regenerates 1% SP per 2sec")));
            Stamina.setItemMeta(StaminaMeta);

            double LuckStat = CCStats.get().getDouble(nick+".Luck");
            double BLuckStat = CCStats.get().getDouble(nick+".BLuck");
            double TLuckStat = CCStats.get().getDouble(nick+".TLuck");
            //LuckSS
            Luck = new ItemStack(Material.EMERALD_BLOCK);
            ItemMeta LuckMeta = Luck.getItemMeta();
            if(TLuckStat>=0){
                LuckMeta.setDisplayName(color("&l&2[&aLuck&2]&a "+LuckStat+" &a(&2+"+BLuckStat+"&a)" + " &a(&2+"+TLuckStat+"&a)"));
            }else{
                LuckMeta.setDisplayName(color("&l&2[&aLuck&2]&a "+LuckStat+" &a(&2+"+BLuckStat+"&a)" + " &a(&2"+TLuckStat+"&a)"));
            }
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



            Stats.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(4,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(10,editItem(Health.clone(),HealthStat,Arrays.asList()));
            Stats.setItem(11,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(12,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(13,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(14,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(15,editItem(Intelligence.clone(),IntelStat,Arrays.asList()));
            Stats.setItem(16,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(19,editItem(Defense.clone(),(int)DefenseStat,Arrays.asList()));
            Stats.setItem(20,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(22,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(24,editItem(Wisdom.clone(),WisdomStat,Arrays.asList()));
            Stats.setItem(25,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(27,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(28,editItem(Strength.clone(), (int) StrengthStat,Arrays.asList()));
            Stats.setItem(29,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(30,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(31,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(32,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(33,editItem(Stamina.clone(),StaminaStat,Arrays.asList()));
            Stats.setItem(34,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(35,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(36,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(37,editItem(Agility.clone(),(int)AgilityStat,Arrays.asList()));
            Stats.setItem(38,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(39,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(40,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(41,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(42,editItem(Luck.clone(),(int)LuckStat,Arrays.asList()));
            Stats.setItem(43,editItem(Plus.clone(),1,Arrays.asList()));
            Stats.setItem(44,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(45,editItem(WhiteGlass.clone(),1,Arrays.asList()));
            Stats.setItem(46,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(47,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(48,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(49,editItem(Points.clone(),1,Arrays.asList()));
            Stats.setItem(50,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(51,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(52,editItem(Glass.clone(),1,Arrays.asList()));
            Stats.setItem(53,editItem(Glass.clone(),1,Arrays.asList()));

        }

        //Unique skills - ItemStacks
        String UniqueClass = CCPlayerInfo.get().getString(nick+".Class.Unique");
        if(true){


            //Reinforcer I
            ReinforcementsI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta ReinforcementsIMeta = ReinforcementsI.getItemMeta();
            ReinforcementsIMeta.setDisplayName(color("&l&7Reinforcer I "));
            ReinforcementsIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you &2&lHard as Wood Skill")));
            ReinforcementsI.setItemMeta(ReinforcementsIMeta);

            //ReinforcementsII
            if(UniqueClass.contains("Reinforcer II") || UniqueClass.contains("ReinforcementsIII")){
                ReinforcementsII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ReinforcementsII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta ReinforcementsIIMeta = ReinforcementsII.getItemMeta();
            ReinforcementsIIMeta.setDisplayName(color("&l&7ReinforcerII "));
            ReinforcementsIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you &8&lHard as Rock Skill")));
            ReinforcementsII.setItemMeta(ReinforcementsIIMeta);

            //ExampleIII
            if(UniqueClass.contains("Reinforcer III")){
                ReinforcementsIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ReinforcementsIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta ReinforcementsIIIMeta = ReinforcementsIII.getItemMeta();
            ReinforcementsIIIMeta.setDisplayName(color("&l&7Reinforcer III "));
            ReinforcementsIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you &7&lHard as Iron Skill")));
            ReinforcementsIII.setItemMeta(ReinforcementsIIIMeta);

            //Solo I
            SoloI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta SoloIMeta = SoloI.getItemMeta();
            SoloIMeta.setDisplayName(color("&l&6Solo I "));
            SoloIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to debuff Players around"),
                    color("&you by 15% every stat")));
            SoloI.setItemMeta(SoloIMeta);

            //SoloII
            if(UniqueClass.contains("Solo II") || UniqueClass.contains("Solo III")){
                SoloII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                SoloII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta SoloIIMeta = SoloII.getItemMeta();
            SoloIIMeta.setDisplayName(color("&l&6Solo II "));
            SoloIIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to debuff Players around"),
                    color("&you by 15% every stat")));
            SoloII.setItemMeta(SoloIIMeta);

            //SoloIII
            if(UniqueClass.contains("Solo III")){
                SoloIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                SoloIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta SoloIIIMeta = SoloIII.getItemMeta();
            SoloIIIMeta.setDisplayName(color("&l&bSolo III "));
            SoloIIIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to debuff Players around"),
                    color("&you by 15% every stat")));
            SoloIII.setItemMeta(SoloIIIMeta);

            //Commander I
            CommanderI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta CommanderIMeta = CommanderI.getItemMeta();
            CommanderIMeta.setDisplayName(color("&l&6Commander I "));
            CommanderIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to boost Players around"),
                    color("&you by 5% every stat")));
            CommanderI.setItemMeta(CommanderIMeta);

            //CommanderII
            if(UniqueClass.contains("Commander II") || UniqueClass.contains("Commander III")){
                CommanderII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                CommanderII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta CommanderIIMeta = CommanderII.getItemMeta();
            CommanderIIMeta.setDisplayName(color("&l&6Commander II "));
            CommanderIIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to boost Players around"),
                    color("&you by 10% every stat")));
            CommanderII.setItemMeta(CommanderIIMeta);

            //CommanderIII
            if(UniqueClass.contains("Commander III")){
                CommanderIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                CommanderIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta CommanderIIIMeta = CommanderIII.getItemMeta();
            CommanderIIIMeta.setDisplayName(color("&l&6Commander III "));
            CommanderIIIMeta.setLore(Arrays.asList(color("&bThis Skill allows you to boost Players around"),
                    color("&you by 15% every stat")));
            CommanderIII.setItemMeta(CommanderIIIMeta);

            //MasterArcherI
            MasterArcherI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta MasterArcherIMeta = MasterArcherI.getItemMeta();
            MasterArcherIMeta.setDisplayName(color("&l&eMaster Archer I "));
            MasterArcherIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you 5% more damage with Bows")));
            MasterArcherI.setItemMeta(MasterArcherIMeta);

            //MasterArcherII
            if(UniqueClass.contains("Master Archer II") || UniqueClass.contains("MasterArcher III")){
                MasterArcherII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                MasterArcherII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta MasterArcherIIMeta = MasterArcherII.getItemMeta();
            MasterArcherIIMeta.setDisplayName(color("&l&eMaster Archer II "));
            MasterArcherIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you"),
                    color("v10% more damage with Bows")));
            MasterArcherII.setItemMeta(MasterArcherIIMeta);
            //MasterArcherIII
            if(UniqueClass.contains("Master Archer III")){
                MasterArcherIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                MasterArcherIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta MasterArcherIIIMeta = MasterArcherIII.getItemMeta();
            MasterArcherIIIMeta.setDisplayName(color("&l&eMaster Archer III "));
            MasterArcherIIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you"),
                    color("&b15% more damage with Bows")));
            MasterArcherIII.setItemMeta(MasterArcherIIIMeta);

            //MasterSwordsman I
            MasterSwordsmanI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta MasterSwordsmanIMeta = MasterSwordsmanI.getItemMeta();
            MasterSwordsmanIMeta.setDisplayName(color("&l&4Master Swordsman I "));
            MasterSwordsmanIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you"),
                    color("&b5% more damage with swords")));
            MasterSwordsmanI.setItemMeta(MasterSwordsmanIMeta);

            //MasterSwordsmanII
            if(UniqueClass.contains("Master Swordsman II") || UniqueClass.contains("Master Swordsman III")){
                MasterSwordsmanII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                MasterSwordsmanII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta MasterSwordsmanIIMeta = MasterSwordsmanII.getItemMeta();
            MasterSwordsmanIIMeta.setDisplayName(color("&l&4Master Swordsman II "));
            MasterSwordsmanIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you"),
                    color("&b10% more damage with swords")));
            MasterSwordsmanII.setItemMeta(MasterSwordsmanIIMeta);

            //MasterSwordsmanIII
            if(UniqueClass.contains("Master Swordsman III")){
                MasterSwordsmanIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                MasterSwordsmanIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta MasterSwordsmanIIIMeta = MasterSwordsmanIII.getItemMeta();
            MasterSwordsmanIIIMeta.setDisplayName(color("&l&4Master Swordsman III "));
            MasterSwordsmanIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you &4&lSwords Ambition Skill")));
            MasterSwordsmanIII.setItemMeta(MasterSwordsmanIIIMeta);


            //PowerOfGiant I
            PowerOfGiantI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta PowerOfGiantIMeta = PowerOfGiantI.getItemMeta();
            PowerOfGiantIMeta.setDisplayName(color("&l&bPower of Giant I "));
            PowerOfGiantIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you 5 Strength points")));
            PowerOfGiantI.setItemMeta(PowerOfGiantIMeta);

            //PowerOfGiantII
            if(UniqueClass.contains("Power of Giant II") || UniqueClass.contains("Power of Giant III")){
                PowerOfGiantII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                PowerOfGiantII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta PowerOfGiantIIMeta = PowerOfGiantII.getItemMeta();
            PowerOfGiantIIMeta.setDisplayName(color("&l&bPower of Giant II "));
            PowerOfGiantIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill grants you 10 Strength points")));
            PowerOfGiantII.setItemMeta(PowerOfGiantIIMeta);

            //PowerOfGiantIII
            if(UniqueClass.contains("Power of Giant III")){
                PowerOfGiantIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                PowerOfGiantIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta PowerOfGiantIIIMeta = PowerOfGiantIII.getItemMeta();
            PowerOfGiantIIIMeta.setDisplayName(color("&l&bPower of Giant III "));
            PowerOfGiantIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you &4&lUltimate Giant Skill")));
            PowerOfGiantIII.setItemMeta(PowerOfGiantIIIMeta);

            //NightWatcher I
            NightWatcherI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta NightWatcherIMeta = NightWatcherI.getItemMeta();
            NightWatcherIMeta.setDisplayName(color("&l&bNight Watcher I "));
            NightWatcherIMeta.setLore(Arrays.asList(
                    color("&bThis Skill gives you Night Vision Effect")));
            NightWatcherI.setItemMeta(NightWatcherIMeta);

            //NightWatcherII
            if(UniqueClass.contains("Night Watcher II") || UniqueClass.contains("Night Watcher III")){
                NightWatcherII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                NightWatcherII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta NightWatcherIIMeta = NightWatcherII.getItemMeta();
            NightWatcherIIMeta.setDisplayName(color("&l&bNight Watcher II "));
            NightWatcherIIMeta.setLore(Arrays.asList(color("&bThis Skill gives you &1&lNight Walking Skill")));
            NightWatcherII.setItemMeta(NightWatcherIIMeta);

            //NightWatcherIII
            if(UniqueClass.contains("Nigh tWatcher III")){
                NightWatcherIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                NightWatcherIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta NightWatcherIIIMeta = NightWatcherIII.getItemMeta();
            NightWatcherIIIMeta.setDisplayName(color("&l&bNight Watcher III "));
            NightWatcherIIIMeta.setLore(Arrays.asList(color("&bThis Skill gives you &1&lNight Walker Skill")));
            NightWatcherIII.setItemMeta(NightWatcherIIIMeta);


            //ManaAffinity I
            ManaAffinityI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta ManaAffinityIMeta = ManaAffinityI.getItemMeta();
            ManaAffinityIMeta.setDisplayName(color("&l&bMana Chosen I "));
            ManaAffinityIMeta.setLore(Arrays.asList(
                    color("&bThis Skill gives you 3 Intelligence points and 3 Wisdom points")));
            ManaAffinityI.setItemMeta(ManaAffinityIMeta);

            //ManaAffinityII
            if(UniqueClass.contains("Mana Chosen II") || UniqueClass.contains("Mana Chosen III")){
                ManaAffinityII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ManaAffinityII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta ManaAffinityIIMeta = ManaAffinityII.getItemMeta();
            ManaAffinityIIMeta.setDisplayName(color("&l&bMana Chosen II "));
            ManaAffinityIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill gives you 5 Intelligence points and 5 Wisdom points")));
            ManaAffinityII.setItemMeta(ManaAffinityIIMeta);

            //ManaAffinityIII
            if(UniqueClass.contains("Mana Chosen III")){
                ManaAffinityIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ManaAffinityIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta ManaAffinityIIIMeta = ManaAffinityIII.getItemMeta();
            ManaAffinityIIIMeta.setDisplayName(color("&l&bMana Chosen III "));
            ManaAffinityIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you &b&lMana Control Skill")));
            ManaAffinityIII.setItemMeta(ManaAffinityIIIMeta);


            //BloodThief I
            BloodThiefI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta BloodThiefIMeta = BloodThiefI.getItemMeta();
            BloodThiefIMeta.setDisplayName(color("&l&bBlood Thief I "));
            BloodThiefIMeta.setLore(Arrays.asList(
                    color("&bThis Skill doens't heal you for hitting enemy, yet")));
            BloodThiefI.setItemMeta(BloodThiefIMeta);

            //BloodThiefII
            if(UniqueClass.contains("Blood Thief II") || UniqueClass.contains("Blood Thief III")){
                BloodThiefII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                BloodThiefII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta BloodThiefIIMeta = BloodThiefII.getItemMeta();
            BloodThiefIIMeta.setDisplayName(color("&l&bBlood Thief II "));
            BloodThiefIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill steals HP of enemy"),
                    color("&band heals you of 5% of enemy HP")));
            BloodThiefII.setItemMeta(BloodThiefIIMeta);

            //BloodThiefIII
            if(UniqueClass.contains("Blood Thief III")){
                BloodThiefIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                BloodThiefIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta BloodThiefIIIMeta = BloodThiefIII.getItemMeta();
            BloodThiefIIIMeta.setDisplayName(color("&l&bBlood Thief III "));
            BloodThiefIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you the &4&lBloody Killer Skill")));
            BloodThiefIII.setItemMeta(BloodThiefIIIMeta);




            //ThirdEye I
            ThirdEyeI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta ThirdEyeIMeta = ThirdEyeI.getItemMeta();
            ThirdEyeIMeta.setDisplayName(color("&l&bThird Eye I "));
            ThirdEyeIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to show stats of enemy")));
            ThirdEyeI.setItemMeta(ThirdEyeIMeta);

            //ThirdEyeII
            if(UniqueClass.contains("Third Eye II") || UniqueClass.contains("Third Eye III")){
                ThirdEyeII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ThirdEyeII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta ThirdEyeIIMeta = ThirdEyeII.getItemMeta();
            ThirdEyeIIMeta.setDisplayName(color("&l&bThird Eye II "));
            ThirdEyeIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to"),
                    color("&bshow more stats of enemy")));
            ThirdEyeII.setItemMeta(ThirdEyeIIMeta);
            //ThirdEyeIII
            if(UniqueClass.contains("Third Eye III")){
                ThirdEyeIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                ThirdEyeIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta ThirdEyeIIIMeta = ThirdEyeIII.getItemMeta();
            ThirdEyeIIIMeta.setDisplayName(color("&l&bThird Eye III "));
            ThirdEyeIIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to see"),
                    color("&ball stats and gives you &2&lThird Eye Sage Skill")));
            ThirdEyeIII.setItemMeta(ThirdEyeIIIMeta);



            //Runner
            //Runner I
            RunnerI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta RunnerIMeta = RunnerI.getItemMeta();
            RunnerIMeta.setDisplayName(color("&l&bRunner I "));
            RunnerIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to run 10% faster")));
            RunnerI.setItemMeta(RunnerIMeta);

            //Runner II
            if(UniqueClass.contains("Runner II") || UniqueClass.contains("Runner III")){
                RunnerII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                RunnerII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta RunnerIIMeta = RunnerII.getItemMeta();
            RunnerIIMeta.setDisplayName(color("&l&bRunner II "));
            RunnerIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to run 20% faster")));
            RunnerII.setItemMeta(RunnerIIMeta);
            //Runner III
            if(UniqueClass.contains("Runner III")){
                RunnerIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                RunnerIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta RunnerIIIMeta = RunnerIII.getItemMeta();
            RunnerIIIMeta.setDisplayName(color("&l&bRunner III "));
            RunnerIIIMeta.setLore(Arrays.asList(
                    color("&bThis Skill allows you to run 30% faster")));
            RunnerIII.setItemMeta(RunnerIIIMeta);

            //Tank
            //Tank 1
            TankI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta TankIMeta = TankI.getItemMeta();
            TankIMeta.setDisplayName(color("&l&4Tank I "));
            TankIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you 2.5HP")));
            TankI.setItemMeta(TankIMeta);

            //Tank II
            if(UniqueClass.contains("Tank II") || UniqueClass.contains("Tank III")){
                TankII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                TankII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta TankIIMeta = TankII.getItemMeta();
            TankIIMeta.setDisplayName(color("&l&4Tank II "));
            TankIIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you 5HP")));
            TankII.setItemMeta(TankIIMeta);
            //Tank III
            if(UniqueClass.contains("Tank III")){
                TankIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                TankIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta TankIIIMeta = TankIII.getItemMeta();
            TankIIIMeta.setDisplayName(color("&l&4Tank III "));
            TankIIIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you 10HP")));
            TankIII.setItemMeta(TankIIIMeta);

            //Jumper
            //Jumper 1
            JumperI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta JumperIMeta = TankI.getItemMeta();
            JumperIMeta.setDisplayName(color("&l&4Jumper I "));
            JumperIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you Jump Boost I")));
            JumperI.setItemMeta(JumperIMeta);

            //Jumper II
            if(UniqueClass.contains("Jumper II") || UniqueClass.contains("Jumper III")){
                JumperII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                JumperII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta JumperIIMeta = JumperII.getItemMeta();
            JumperIIMeta.setDisplayName(color("&l&4Jumper II "));
            JumperIIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you Jump Boost II")));
            JumperII.setItemMeta(JumperIIMeta);
            //Jumper III
            if(UniqueClass.contains("Tank III")){
                JumperIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                JumperIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta JumperIIIMeta = JumperIII.getItemMeta();
            JumperIIIMeta.setDisplayName(color("&l&4Jumper III "));
            JumperIIIMeta.setLore(Arrays.asList(
                    color("&4This Skill gives you Jump Boost III")));
            JumperIII.setItemMeta(JumperIIIMeta);

            //LuckerI
            LuckerI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta LuckerIMeta = LuckerI.getItemMeta();
            LuckerIMeta.setDisplayName(color("&l&aLucker I "));
            LuckerIMeta.setLore(Arrays.asList(color("&bThis Skill grants you 5 Luck Points!")));
            LuckerI.setItemMeta(LuckerIMeta);

            //LuckerII
            if(UniqueClass.contains("Lucker II") || UniqueClass.contains("Lucker III")){
                LuckerII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                LuckerII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            ItemMeta LuckerIIMeta = LuckerII.getItemMeta();
            LuckerIIMeta.setDisplayName(color("&l&aLucker II"));
            LuckerIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you 10 Luck Points!")));
            LuckerII.setItemMeta(LuckerIIMeta);
            //LuckerIII
            if(UniqueClass.contains("Lucker III")){
                LuckerIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }else{
                LuckerIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
            ItemMeta LuckerIIIMeta = LuckerIII.getItemMeta();
            LuckerIIIMeta.setDisplayName(color("&l&aLucker III "));
            LuckerIIIMeta.setLore(Arrays.asList(color("&bThis Skill grants you &l&1U&2n&3i&4q&5u&6e &7L&8u&9c&ak &bS&ck&di&el&fl")));
            LuckerIII.setItemMeta(LuckerIIIMeta);
        }

        //Unique Abilities - Menu
        Inventory UniqueSkill = Bukkit.createInventory(null, 27,color("&6&lUnique Skill"));
        if(true){
            UniqueSkill.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(4,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(10,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(11,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(15,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(16,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(18,editItem(WhiteGlass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(19,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(20,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(22,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(24,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(25,editItem(Glass.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));


            if(UniqueClass.contains("Runner")){
                UniqueSkill.setItem(12,editItem(RunnerI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(RunnerII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(RunnerIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Tank")){
                UniqueSkill.setItem(12,editItem(TankI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(TankII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(TankIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Jumper")){
                UniqueSkill.setItem(12,editItem(JumperI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(JumperII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(JumperIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Lucker")){
                UniqueSkill.setItem(12,editItem(LuckerI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(LuckerII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(LuckerIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Third Eye")){
                UniqueSkill.setItem(12,editItem(ThirdEyeI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(ThirdEyeII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(ThirdEyeIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Blood Thief")){
                UniqueSkill.setItem(12,editItem(BloodThiefI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(BloodThiefII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(BloodThiefIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Mana Chosen")){
                UniqueSkill.setItem(12,editItem(ManaAffinityI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(ManaAffinityII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(ManaAffinityIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Night Watcher")){
                UniqueSkill.setItem(12,editItem(NightWatcherI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(NightWatcherII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(NightWatcherIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Power of Giant")){
                UniqueSkill.setItem(12,editItem(PowerOfGiantI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(PowerOfGiantII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(PowerOfGiantIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Master Swordsman")){
                UniqueSkill.setItem(12,editItem(MasterSwordsmanI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(MasterSwordsmanII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(MasterSwordsmanIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Master Archer")){
                UniqueSkill.setItem(12,editItem(MasterArcherI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(MasterArcherII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(MasterArcherIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Commander")){
                UniqueSkill.setItem(12,editItem(CommanderI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(CommanderII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(CommanderIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Solo")){
                UniqueSkill.setItem(12,editItem(SoloI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(SoloII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(SoloIII.clone(),1,Arrays.asList()));
            }
            if(UniqueClass.contains("Reinforcer")){
                UniqueSkill.setItem(12,editItem(ReinforcementsI.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(13,editItem(ReinforcementsII.clone(),1,Arrays.asList()));
                UniqueSkill.setItem(14,editItem(ReinforcementsIII.clone(),1,Arrays.asList()));
            }
        }


        //Skills Menu
        Inventory Skills = Bukkit.createInventory(null,54,color("&4&lSkills"));
        if(true){

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
                        EpicSkillMeta.setLore(Arrays.asList(color("&5["+"&d"+EpType.get(i)+color("&5]")),
                                color("&5[&dRank "+"&d"+EpRanks.get(i)+"&5]"),
                                color("&5[&dProficiency  "+"&d"+EpProfHave.get(i)+"&5/&d"+EpProfNeed.get(i)+"&5]"),
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
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
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
                        if(!CCPlayerInfo.get().getString(nick+".Unique.Class").contains("Lucker")&& RarSkills.get(i)=="Lucky Coin"){
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
                                color("&1[&9Proficiency  "+"&9"+RarProfHave.get(i)+"&1/&9"+RarProfNeed.get(i)+"&1]"),
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
                        if(!CCPlayerInfo.get().getString(nick+".Class.Unique").contains("Lucker")&& RarSkills.get(i)=="Lucky Coin"){
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


        Inventory MonsterCodex = Bukkit.createInventory(null,54,color("&7&lMonster Codex"));
        if(true){

            //LEFT SIDE
            MonsterCodex.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(27,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(36,editItem(Glass.clone(),1,Arrays.asList()));
            //RIGHT SIDE
            MonsterCodex.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(35,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(44,editItem(Glass.clone(),1,Arrays.asList()));
            //BOTTOM
            MonsterCodex.setItem(46,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(47,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(48,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(49,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(50,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(45,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(51,editItem(Glass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(52,editItem(Glass.clone(),1,Arrays.asList()));
            //LEFT AND RIGHT BOTTOM CORNER
            MonsterCodex.setItem(45,editItem(WhiteGlass.clone(),1,Arrays.asList()));
            MonsterCodex.setItem(53,editItem(WhiteGlass.clone(),1,Arrays.asList()));

            //Check if MonstersMet exists
            if(CCAchieved.get().getList(nick+".MonstersMet")!=null){

            }else{
                //Doesnt exist so dont add anythin to the menu
            }

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


        }
        Inventory Recipes = Bukkit.createInventory(null,54,color("&a&lRecipes"));
        if(true){
            MagicBench = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
            ItemMeta MagicBenchMeta = MagicBench.getItemMeta();
            MagicBenchMeta.setDisplayName(color("&6&Magic Table"));
            MagicBenchMeta.setLore(Arrays.asList(color("&7 - Crafting custom items in this magic table")));
            MagicBench.setItemMeta(MagicBenchMeta);

            //LEFT SIDE
            Recipes.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(27,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(36,editItem(Glass.clone(),1,Arrays.asList()));
            //RIGHT SIDE
            Recipes.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(35,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(44,editItem(Glass.clone(),1,Arrays.asList()));
            //BOTTOM
            Recipes.setItem(46,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(47,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(48,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(49,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(50,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(45,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(51,editItem(Glass.clone(),1,Arrays.asList()));
            Recipes.setItem(52,editItem(Glass.clone(),1,Arrays.asList()));
            //LEFT AND RIGHT BOTTOM CORNER
            Recipes.setItem(45,editItem(WhiteGlass.clone(),1,Arrays.asList()));
            Recipes.setItem(53,editItem(WhiteGlass.clone(),1,Arrays.asList()));

            if(CCAchieved.get().getList(nick+".Recipes")!=null){
                List recipes = CCAchieved.get().getList(nick+".Recipes");
                //UniqueClass

            }else{
                //Doesnt exist so dont add anythin to the menu
            }

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


        }

        /*class WW{
            void what(List whatL){
                whatL= what;
            }
            void where(List whereL){
                whereL=where;

            }
        }*/




        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }

        if(click!=null){
                switch (slot) {
                    case 11:
                        if(click == ClickType.LEFT){
                            player.openInventory(Skills);
                        }
                        break;
                    case 10:
                        //
                        if(click == ClickType.LEFT){
                            player.openInventory(UniqueSkill);
                        }
                        break;
                    case 22:
                        //
                        if(click == ClickType.LEFT){
                            player.openInventory(Stats);
                        }
                        break;
                    case 15:
                        //
                        if(click == ClickType.LEFT){
                            player.openInventory(Recipes);
                        }
                        break;
                    case 16:
                        //
                        if(click == ClickType.LEFT){
                            player.openInventory(MonsterCodex);
                        }
                        break;

                }

        }else{
            return;
        }




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


    //public void getClass(List skIndex) {
    //}
}

