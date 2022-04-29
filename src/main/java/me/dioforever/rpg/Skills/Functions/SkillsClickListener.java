package me.dioforever.rpg.Skills.Functions;

import me.dioforever.rpg.Menu.MenuListener;
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

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class SkillsClickListener  extends MenuListener implements Listener {

    private ItemStack Glass;
    private ItemStack WhiteGlass;
    private ItemStack Points;

    //Menu
    private ItemStack Profile;
    private ItemStack Skills;
    private ItemStack UniqueSkill;
    private ItemStack Magic;
    private ItemStack GuildI;
    private ItemStack Stats;

    //Settings of Combos
    private ItemStack SOS;
    private ItemStack Save;
    private ItemStack EmptyClick;
    private ItemStack LeftClick;
    private ItemStack RightClick;
    private ItemStack SkillGlass;
    private ItemStack Classles;
    private ItemStack MartialArts;
    private ItemStack UniqueClassItem;
    private ItemStack Codex;
    private ItemStack Recipes;


    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&4&lSkills"))){

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

        List what = new ArrayList<>();
        List where = new ArrayList<>();
        //WhiteGlass
        SkillGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta SkillGlassMeta = SkillGlass.getItemMeta();
        SkillGlassMeta.setDisplayName(color("&l&4Skills"));
        SkillGlassMeta.setLore(Arrays.asList(color("&cClick to go back to Skills")));
        SkillGlass.setItemMeta(SkillGlassMeta);

        //Menu
        Inventory Menu = Bukkit.createInventory(null, 27, color("&b&lMenu"));
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
            //Points
            Points = new ItemStack(Material.ENDER_PEARL,PointsInt);
            ItemMeta PointsMeta = Points.getItemMeta();
            PointsMeta.setDisplayName(color("&5Stat Points: "+PointsInt));
            PointsMeta.setLore(Arrays.asList(color("")));
            Points.setItemMeta(PointsMeta);
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

            Inventory Skills = Bukkit.createInventory(null,54,color("&4&lSkills"));

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

                //List of active skills
                List activeN = new ArrayList<>();
                List activeP = new ArrayList<>();


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
                    v = (int)LegDesc.get(k);
                    k += v;
                    if(LegType.get(i).equals("ACTIVE")){
                        activeN.add(LegSkills.get(i));
                        activeP.add((int)taken.get(0));
                    }
                    what.add(LegSkills.get(i));
                    where.add((int)taken.get(0));
                    taken.remove(0);


                    k++;
                    i++;


                }
                k=0;
                i=0;

                for(int e = 0; e<kEpSkills;e++){
                    v = (int)EpDesc.get(k);
                    k += v;
                    if(EpType.get(i).equals("ACTIVE")){
                        activeN.add(EpSkills.get(i));
                        activeP.add((int)taken.get(0));
                    }
                    what.add(EpSkills.get(i));
                    where.add((int)taken.get(0));
                    taken.remove(0);

                    k++;
                    i++;
                }
                k=0;
                i=0;

                for(int r = 0; r<kRarSkills;r++){
                    v = (int)RarDesc.get(k);
                    k += v;
                    if(RarType.get(i).equals("ACTIVE")){
                        activeN.add(RarSkills.get(i));
                        activeP.add((int)taken.get(0));
                    }
                    what.add(RarSkills.get(i));
                    where.add((int)taken.get(0));
                    taken.remove(0);

                    k++;
                    i++;
                }
                k=0;
                i=0;

                for(int c = 0; c<kCmnSkills;c++){
                    v = (int)CmnDesc.get(k);
                    k += v;
                    if(CmnType.get(i).equals("ACTIVE")){
                        activeN.add(CmnSkills.get(i));
                        activeP.add((int)taken.get(0));
                    }
                    what.add(CmnSkills.get(i));
                    where.add((int)taken.get(0));
                    taken.remove(0);
                    k++;
                    i++;
                }
                //System.out.println(what);
                //System.out.println(where);








        Inventory ComboSettings = Bukkit.createInventory(null,27,color("&5&lCombo Setting"));
        //MENU BUTTONS
        ComboSettings.setItem(18,editItem(SkillGlass.clone(),1,Arrays.asList()));
        ComboSettings.setItem(26,editItem(SkillGlass.clone(),1,Arrays.asList()));
        //TOP LINE
        if(true){
            ComboSettings.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
        }
        //SIDE LINES
        if(true){
            ComboSettings.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
        }
        //BOTTOM
        if(true){
            ComboSettings.setItem(19,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(20,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(22,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(24,editItem(Glass.clone(),1,Arrays.asList()));
            ComboSettings.setItem(25,editItem(Glass.clone(),1,Arrays.asList()));

        }





        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        if(click!=null){
            if(activeP.contains(slot)){

                String rarity = "";
                String rarits = "";
                if(LegSkills.contains(what.get(slot-1))){
                    rarity = "6";
                    rarits = "e";
                }else if(EpSkills.contains(what.get(slot-1))){
                    rarity = "5";
                    rarits = "d";
                }else if(RarSkills.contains(what.get(slot-1))){
                    rarity = "1";
                    rarits = "9";
                }else if(CmnSkills.contains(what.get(slot-1))){
                    rarity = "8";
                    rarits = "7";
                }
                //Setting of Skill
                SOS = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE,1);
                ItemMeta SOSMeta = SOS.getItemMeta();
                SOSMeta.setDisplayName(color("&"+rarity+ "[&"+ rarits +"&lSkill"+"&"+rarity+"] &"+rarits+what.get(slot-1)));
                SOSMeta.setLore(Arrays.asList(color("&"+rarits+"You are currently in setting"),
                        color("&"+rarits+"of the skill combo"),
                        color("&"+rarits+"Combo is the order of Left and "),
                        color("&"+rarits+"Right clicks that will activate the "),
                        color("&"+rarits+"skill upon shifting with correct combo")));
                SOS.setItemMeta(SOSMeta);

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
                LeftClickMeta.setDisplayName(color("&1Left Click"));
                LeftClickMeta.setLore(Arrays.asList(
                        color("&9 - This is currently Left Click and"),
                        color("&9 will be counted in the combo"),
                        color("&9 - Click to change to Right Click")));
                LeftClick.setItemMeta(LeftClickMeta);

                RightClick = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
                ItemMeta RightClickMeta = RightClick.getItemMeta();
                RightClickMeta.setDisplayName(color("&4Right Click"));
                RightClickMeta.setLore(Arrays.asList(
                        color("&c - This is currently Right Click and"),
                        color("&c will be counted in the combo"),
                        color("&c - Click to change to Empty")));
                RightClick.setItemMeta(RightClickMeta);

                Save = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
                ItemMeta SaveMeta = Save.getItemMeta();
                SaveMeta.setDisplayName(color("&6Save"));
                SaveMeta.setLore(Arrays.asList(
                        color("&e - Click this to save the combo,"),
                        color("&e   otherwise the combo will not be saved")));
                Save.setItemMeta(SaveMeta);

                String ComboN = (String) what.get(slot-1);
                System.out.println(ComboN);
                String Combo="";
                if(CCCombos.get().getList(nick+".Skills.Name").contains(ComboN)){
                    int indexC = CCCombos.get().getList(nick+".Skills.Name").indexOf(ComboN);
                    List combo = CCCombos.get().getList(nick+".Skills.Combos");
                    Combo = (String) combo.get(indexC);
                }

                if(Combo==""){

                    ComboSettings.setItem(10,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(11,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(12,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(13,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(14,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(15,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(16,editItem(EmptyClick.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(17,editItem(Save.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(4,editItem(SOS.clone(),1,Arrays.asList()));
                }else{
                    char[] comboch = Combo.toCharArray();
                    int p = 10;
                    for(int l =0; l< comboch.length;l++){
                        char typ = (comboch[l]);
                        if(typ == 'L'){
                            ComboSettings.setItem(p,editItem(LeftClick.clone(),1,Arrays.asList()));
                        }
                        if(typ == 'R'){
                            ComboSettings.setItem(p,editItem(RightClick.clone(),1,Arrays.asList()));
                        }
                        p++;
                    }
                    if(p<18){
                        int h = 17-p;
                        for(int l = 0; l<h;l++){
                            ComboSettings.setItem(p,editItem(EmptyClick.clone(),1,Arrays.asList()));
                            p++;
                        }
                    }
                    ComboSettings.setItem(17,editItem(Save.clone(),1,Arrays.asList()));
                    ComboSettings.setItem(4,editItem(SOS.clone(),1,Arrays.asList()));
                }

                player.openInventory(ComboSettings);
            }
        }
        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        if(click!=null) {
            switch (slot) {

                case 45:
                case 53:
                    //
                    if (click == ClickType.LEFT) {
                        player.openInventory(Menu);
                    }
                    break;
            }
        }else{
            return;
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



