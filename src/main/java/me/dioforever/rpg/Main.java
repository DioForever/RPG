package me.dioforever.rpg;

import me.dioforever.rpg.CustomHealth.HealListener;
import me.dioforever.rpg.Customs.Entities.Cryomancer;
import me.dioforever.rpg.Customs.Outposts.BreakCoreListener;
import me.dioforever.rpg.Leveling.FarmMineListener;
import me.dioforever.rpg.Leveling.FishingListener;
import me.dioforever.rpg.Leveling.KillEntityListener;
import me.dioforever.rpg.Skills.LumberingSkill;
import me.dioforever.rpg.Skills.MiningSkill;
import me.dioforever.rpg.Listeners.CastingSystem;
import me.dioforever.rpg.Menu.MonsterCodex;
import me.dioforever.rpg.Menu.RecipeInvListener;
import me.dioforever.rpg.Skills.FriendofNature;
import me.dioforever.rpg.Skills.Functions.ComboSettingListener;
import me.dioforever.rpg.Skills.Functions.SkillsClickListener;
import me.dioforever.rpg.Skills.IncompleteFireDragonsSkin;
import me.dioforever.rpg.Skills.TwistedSunAndMoon;
import me.dioforever.rpg.StatWork.DamageListener;
import me.dioforever.rpg.Listeners.JoinListener;
import me.dioforever.rpg.Menu.MenuListener;
import me.dioforever.rpg.Stats.StatsClickListener;
import me.dioforever.rpg.UniqueAbility.UniqueAbilityListener;
import me.dioforever.rpg.UniqueAbility.UniqueAbilityWork;
import me.dioforever.rpg.UniqueAbility.UniqueSkillsLeveling;
import me.dioforever.rpg.commands.*;
import me.dioforever.rpg.commands.Guilds.GuildCMDS;
import me.dioforever.rpg.commands.Races.*;
import me.dioforever.rpg.Menu.menu;
import me.dioforever.rpg.commands.Testing.*;
import me.dioforever.rpg.files.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;
import java.util.logging.Logger;

import static me.dioforever.rpg.Utils.color;

public final class Main extends JavaPlugin {

    private static Logger logger;
    private ArrayList listP = new ArrayList();

    public static Map <String,List> SkillsActivatedTemp = new HashMap<String,List>();
    public static Map <String,List> SkillsActivated = new HashMap<String,List>();
    public static Map <String,HashMap> SkillsEffectT= new HashMap<String,HashMap>();
    public static Map <String,HashMap> SkillsEffect= new HashMap<String,HashMap>();
    public static Map <String,HashMap> SkillsCooldown= new HashMap<String,HashMap>();
    public static Map <String,HashMap> SkillsCooldownT= new HashMap<String,HashMap>();

    public static Map<UUID,List> CustomMobsStats = new HashMap<>();
    public static Map<UUID,List> CustomMobsSkills = new HashMap<>();
    public static Map<UUID,String> CustomMobsType = new HashMap<>();


    //Will have nick - Hashmap of the Skill (String) + Effect(List) for example



    @Override
    public void onEnable() {
        // Plugin startup logic


        //Settings file
        PluginSettings.setup();
        if(PluginSettings.get().getString("FileCreated")==null){
            PluginSettings.get().set("FileCreated",true);
            PluginSettings.get().set("MobLevels",true);
            PluginSettings.get().set("Proficiency",true);
            PluginSettings.get().set("Leveling.Mobs",true);
            PluginSettings.get().set("Leveling.Farming",true);
            PluginSettings.get().set("Leveling.Mining",true);
            PluginSettings.get().set("Leveling.Enchanting",true);
        }
        //End


        getConfig().options().copyDefaults();
        saveDefaultConfig();
        List test1 = new ArrayList();
        test1.add("testC");

        List test2 = new ArrayList();
        test2.add("testS");

        List test3 = new ArrayList();
        test3.add("testG");
        List test4 = new ArrayList();
        test4.add("Player0");

        logger = getLogger();


        CCLeft.setup();
        CCOn.setup();
        CCGuilds.setup();
        CCStats.setup();
        CCMagic.setup();
        CCSkills.setup();
        CCPlayerInfo.setup();
        CCCombos.setup();
        CCAchieved.setup();
        Outposts.setup();
        Outposts.get().options().copyDefaults(true);
        CCOn.get().options().copyDefaults(true);
        CCLeft.get().options().copyDefaults(true);
        CCGuilds.get().options().copyDefaults(true);
        CCStats.get().options().copyDefaults(true);
        CCSkills.get().options().copyDefaults(true);
        CCMagic.get().options().copyDefaults(true);
        CCPlayerInfo.get().options().copyDefaults(true);
        CCCombos.get().options().copyDefaults(true);
        PluginSettings.get().options().copyDefaults(true);
        CCAchieved.get().options().copyDefaults(true);
        CCGuilds.get().addDefault("Guilds",test3);
        CCGuilds.get().addDefault("GuildJoined",test4);
        Outposts.save();
        CCOn.save();
        CCLeft.save();
        PluginSettings.save();
        CCAchieved.save();
        CCGuilds.save();
        CCStats.save();
        CCMagic.save();
        CCSkills.save();
        CCCombos.save();
        CCPlayerInfo.save();

        OfflinePlayer[] players = Bukkit.getOfflinePlayers();
        //Reset all temporary stats
        for(int i = 0; i<players.length;i++){
            String nick = players[i].getName();
            if(CCPlayerInfo.get().getString(nick+".PC")!=null){
                CCStats.get().set(nick + ".TLuck", 0);
                CCStats.get().set(nick + ".TIntelligence", 0);
                CCStats.get().set(nick + ".TWisdom", 0);
                CCStats.get().set(nick + ".TAgility", 0);
                CCStats.get().set(nick + ".THealth", 0);
                CCStats.get().set(nick + ".TStrength", 0);
                CCStats.get().set(nick + ".TStamina", 0);
                CCStats.get().set(nick + ".TWisdom", 0);
                CCStats.get().set(nick + ".TDefense", 0);
            }
        }
        CCStats.save();

        //Necessary
        getServer().getPluginManager().registerEvents(new UniqueAbilityListener(),this);
        getServer().getPluginManager().registerEvents(new UniqueAbilityWork(),this);
        getServer().getPluginManager().registerEvents(new RacesInvListener(),this);
        getServer().getPluginManager().registerEvents(new SkillsClickListener(),this);
        getServer().getPluginManager().registerEvents(new JoinListener(this),this);
        getServer().getPluginManager().registerEvents(new MenuListener(),this);
        getServer().getPluginManager().registerEvents(new StatsClickListener(),this);
        getServer().getPluginManager().registerEvents(new LumberingSkill(),this);
        getServer().getPluginManager().registerEvents( new MiningSkill(),this);

        //Skills
        getServer().getPluginManager().registerEvents(new FriendofNature(this),this);
        getServer().getPluginManager().registerEvents(new IncompleteFireDragonsSkin(this),this);

        //Optional - Leveling
        getServer().getPluginManager().registerEvents(new FarmMineListener(this),this);
        getServer().getPluginManager().registerEvents(new FishingListener(this),this);


        //Optional - Mob Spawning
        //getServer().getPluginManager().registerEvents(new MobSpawnListener(),this);

        getServer().getPluginManager().registerEvents(new DamageListener(),this);
        getServer().getPluginManager().registerEvents(new me.dioforever.rpg.CustomHealth.DamageListener(),this);
        getServer().getPluginManager().registerEvents(new HealListener(),this);
        getServer().getPluginManager().registerEvents(new BreakCoreListener(),this);


        //getServer().getPluginManager().registerEvents(new DamageListener(),this);
        //getServer().getPluginManager().registerEvents(new Regen(this),this);
        getServer().getPluginManager().registerEvents(new KillEntityListener(this),this);

        getServer().getPluginManager().registerEvents(new ComboSettingListener(),this);
        getServer().getPluginManager().registerEvents(new CastingSystem(),this);
        getServer().getPluginManager().registerEvents(new UniqueSkillsLeveling(this),this);
        getServer().getPluginManager().registerEvents(new RecipeInvListener(),this);
        getServer().getPluginManager().registerEvents(new MonsterCodex(),this);

        //Monsters
        getServer().getPluginManager().registerEvents(new Cryomancer(this),this);


        getCommand("updates").setExecutor(new Updates());
        getCommand("preload").setExecutor(new ReloadCommand());
        getCommand("message").setExecutor(new message());
        getCommand("menu").setExecutor(new menu());
        getCommand("guild").setExecutor(new GuildCMDS());
        getCommand("uachange").setExecutor(new ChangeUniqueCmd());
        getCommand("skilladd").setExecutor(new GiveSkillCmd());
        getCommand("xpmultiplier").setExecutor(new xpmultiplier());
        getCommand("levelbar").setExecutor(new levelBarCmd());
        getCommand("givexp").setExecutor(new givexp());
        getCommand("racechange").setExecutor(new racechange());
        getCommand("spawnoutpost").setExecutor(new spawnStructer());
        getCommand("spawnparticle").setExecutor(new spawnparticle(this));

        //Races
        getCommand("races").setExecutor(new Races());
        getCommand("classes").setExecutor(new Races());
        //Summon
        getCommand("Seth").setExecutor(new SummonCmd());


        //BukkitTask temporaryStats = new TwistedSunAndMoon().runTaskTimer(this,0,20*30);


        //
        Bar();
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+" -------------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"    Loading DioRPG plugin..");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"   |=======================|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"   |                       |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"   |     Version 1.0.1     |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"   |                       |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"   |=======================|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"     Made by DioForever");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+"     Website: dioforever.live");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"["+ChatColor.GOLD+ "DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "["+ChatColor.GOLD+"DioRPG"+ChatColor.YELLOW +"]"+ChatColor.GOLD+" -------------------------");

        //PERIODICAL SAVE
        new BukkitRunnable() {
            @Override
            public void run() {
                CCLeft.save();
                CCAchieved.save();
                CCSkills.save();
                CCCombos.save();
                CCSkills.save();
                CCPlayerInfo.save();
                CCStats.save();
                CCGuilds.save();
                CCMagic.save();
                PluginSettings.save();
                Outposts.save();
            }
        }.runTaskTimer(this,0,12000);

        //Inform();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CCStats.save();
        CCMagic.save();
        CCSkills.save();
        CCPlayerInfo.save();
        PluginSettings.save();
        CCAchieved.save();
        Outposts.save();
        CCLeft.save();
        CCAchieved.save();
        CCCombos.save();
        CCGuilds.save();
    }
    int count = 0;
    int count1 = 0;

    public static Logger getPluginLogger() {
        return logger;
    }

    public void Inform(){
        new BukkitRunnable() {
            @Override

            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendMessage("SkillsTemp: "+getSkillsActivatedTemp());
                    p.sendMessage("SkillsCooldownTemp: "+getSkillsCooldownT());
                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,20*5);
    }
    public void Bar(){
        new BukkitRunnable() {
            @Override

            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){

                    String nick = p.getName();
                    int SPBNS = CCLeft.get().getInt(nick+".SPBNS");
                    int MPBNS = CCLeft.get().getInt(nick+".MPBNS");
                    //MP setting
                    int MPRn =  CCLeft.get().getInt(nick+".MP");
                    int MPStat = CCStats.get().getInt(nick+".Intelligence");
                    int MPRegen = CCStats.get().getInt(nick+".Wisdom");

                    int MAXMPset = (MPStat*5)+30+MPBNS*5;
                    CCLeft.get().set(nick+".MAXMP",MAXMPset);
                    CCPlayerInfo.save();


                    //Mana Regen
                    if(!(MPRn>=MAXMPset)){
                        if(MPRegen!=1){
                            CCLeft.get().set(nick+".MP",(MPRn+(MPRegen/6)));
                            CCLeft.save();
                        }else{
                            CCLeft.get().set(nick+".MP",(MPRn+(1)));
                            CCLeft.save();
                        }
                    }
                    if(MAXMPset<MPRn){
                        CCLeft.get().set(nick+".MP",MAXMPset);
                        CCLeft.save();
                    }
                    //

                    //Stamina Regen
                    int SPRn = CCLeft.get().getInt(nick+".SP");
                    int SPStat = CCStats.get().getInt(nick+".Stamina");
                    double SPRegen = SPStat/33;
                    int SPMAX = SPStat*5+30+SPBNS*5;

                    if(!(SPRn>=SPMAX)){
                        if(SPRegen!=1){
                            CCLeft.get().set(nick+".SP",(SPRn+(SPRegen)));
                            CCLeft.save();
                        }else{
                            CCLeft.get().set(nick+".SP",(SPRn+(1)));
                            CCLeft.save();
                        }
                    }
                    if(MAXMPset<MPRn){
                        CCLeft.get().set(nick+".SP",SPMAX);
                        CCLeft.save();
                    }
                    //




                    //HP setting
                    int HPRn = (int) p.getHealth();
                    int HPRN = HPRn*5;
                    //CCLeft.get().set(nick+".HP",HPRN);
                    CCLeft.save();

                    int HPSTAT = CCStats.get().getInt(nick+".Health");
                    int HPTMP = CCStats.get().getInt(nick+".THealth");
                    CCLeft.get().set(nick+".MAXHP",(100+(HPSTAT))+HPTMP);
                    //Check if players HP make sense
                    int HpMax = CCLeft.get().getInt(nick+".MAXHP");
                    if(HPRN>HpMax){
                        CCLeft.get().set(nick+".HP",HpMax);
                    }
                    if(p.getHealth()==p.getMaxHealth()&&(HPRN!=HpMax)){
                        p.setHealth(p.getMaxHealth());
                    }
                    CCPlayerInfo.save();
                    CCLeft.save();
                    // 100HP = 20Health
                    //5HP = 1Health

                    p.setMaxHealth(HpMax/5);


                    CCPlayerInfo.save();

                    int MP = CCLeft.get().getInt(nick+".MP");
                    int MAXMP = (MPStat*5)+30+MPBNS*5;

                    int SP = CCLeft.get().getInt(nick+".SP");

                    int MAXHP = CCLeft.get().getInt(nick+".MAXHP");
                    int HPRNN = (int) p.getHealth()*5;
                    //CCLeft.get().set(nick+".HP",HPRNN);
                    CCLeft.save();
                    int HP = CCLeft.get().getInt(nick+".HP");
                    /*
                    if(MAXHP<HPRNN){
                        CCLeft.get().set(nick+".HP",MAXHP);
                        CCLeft.save();
                    }*/
                    String Class = CCPlayerInfo.get().getString(nick+".Class.Normal");

                    String Combo = CastingSystem.combo;
                    String ComboN = "";
                    List SkillComboC = CCCombos.get().getList(nick+".Skills.Combos");
                    if(SkillComboC.contains(Combo)){
                        int index = SkillComboC.indexOf(Combo);
                        List SkillComboN = CCCombos.get().getList(nick+".Skills.Name");
                        ComboN = (String) SkillComboN.get(index);
                    }
                    List MagicComboC = CCCombos.get().getList(nick+".Magic.Combos");
                    if(MagicComboC.contains(Combo)){
                        int index = MagicComboC.indexOf(Combo);
                        List MagicComboN = CCCombos.get().getList(nick+".Magic.Name");
                        ComboN = (String) MagicComboN.get(index);
                    }
                    List MArtsComboC = CCCombos.get().getList(nick+".MArts.Combos");
                    if(MArtsComboC.contains(Combo)){
                        int index = MArtsComboC.indexOf(Combo);
                        List MArtsComboN = CCCombos.get().getList(nick+".MArts.Name");
                        ComboN = (String) MArtsComboN.get(index);
                    }
                    if(Combo==null){
                        Combo="";
                    }

                    if(Class.equals("Warrior")){
                        if(p.getHealth()!=0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText((color(("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&c"+Combo+"&7] "+" &7["+"&6"+ComboN+"&7] "+"&7MP:"+"&6"+SP+"&7/"+"&6"+SPMAX)))));
                        }if(p.getHealth()==0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText((color(("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&c"+Combo+"&7] "+" &7["+"&6"+ComboN+"&7] "+"&7MP:"+"&6"+SP+"&7/"+"&6"+SPMAX)))));

                        }
                    }else if(Class.equals("Mage")){
                        if(p.getHealth()!=0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&9"+Combo+"&7] "+" &7["+"&6"+ComboN+"&7] "+"&7MP:"+"&9"+MP+"&7/"+"&9"+MAXMP)));
                        }if(p.getHealth()==0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color(("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&9"+Combo+"&7] "+" &7["+"&6"+ComboN+"&7] "+"&7MP:"+"&9"+MP+"&7/"+"&9"+MAXMP))));

                        }
                    }else{
                        if(p.getHealth()!=0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&6"+Combo+"&7]"+" &7["+"&6"+ComboN+"&7] ")));
                        }if(p.getHealth()==0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color("&7"+"HP:"+"&c"+HP+"&7/"+"&c"+MAXHP+" &7["+"&6"+Combo+"&7]"+" &7["+"&6"+ComboN+"&7] ")));

                        }
                    }




                   //Agility
                    int Agility = CCStats.get().getInt(nick+".Agility");
                    //                               100/20=5*0,02=0.1*2=0.2 = 100% + 100% = 200% speed


                    if((float) (0.2 + Agility/5*0.01*2)>1){
                        p.setWalkSpeed((float) 1);
                    }else{
                        p.setWalkSpeed((float) (0.2 + Agility/5*0.01));
                    }

                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,4);
    }
    //Skills

    public static Map<String, List> getSkillsActivatedTemp() {
        return SkillsActivatedTemp;
    }

    public static void setSkillsActivatedTemp(Map<String, List> skillsActivatedTemp) {
        SkillsActivatedTemp = skillsActivatedTemp;
    }

    public static Map<String, List> getSkillsActivated() {
        return SkillsActivated;
    }

    public static void setSkillsActivated(Map<String, List> skillsActivated) {
        SkillsActivated = skillsActivated;
    }

    public static Map<String, HashMap> getSkillsCooldown() {
        return SkillsCooldown;
    }

    public static void setSkillsCooldown(Map<String, HashMap> skillsCooldown) {
        SkillsCooldown = skillsCooldown;
    }

    public static void setSkillsEffectT(Map<String, HashMap> skillsEffectT) {
        SkillsEffectT = skillsEffectT;
    }

    public static Map<String, HashMap> getSkillsEffectT() {
        return SkillsEffectT;
    }

    public static void setSkillsCooldownT(Map<String, HashMap> skillsCooldownT) {
        SkillsCooldownT = skillsCooldownT;
    }

    public static Map<String, HashMap> getSkillsCooldownT() {
        return SkillsCooldownT;
    }

    public static Map<String, HashMap> getSkillsEffect() {
        return SkillsEffect;
    }

    public static void setSkillsEffect(Map<String, HashMap> skillsEffect) {
        SkillsEffect = skillsEffect;
    }

    public static void setCustomMobsStats(Map<UUID, List> customMobsStats) {
        CustomMobsStats = customMobsStats;
    }

    public static Map<UUID, List> getCustomMobsStats() {
        return CustomMobsStats;
    }

    public static void setCustomMobsSkills(Map<UUID, List> customMobsSkills) {
        CustomMobsSkills = customMobsSkills;
    }

    public static Map<UUID, List> getCustomMobsSkills() {
        return CustomMobsSkills;
    }

    public static void setCustomMobsType(Map<UUID, String> customMobsType) {
        CustomMobsType = customMobsType;
    }

    public static Map<UUID, String> getCustomMobsType() {
        return CustomMobsType;
    }

}
