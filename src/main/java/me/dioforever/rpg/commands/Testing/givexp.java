package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.dioforever.rpg.Utils.color;

public class givexp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==2){
            String nick = args[0];
            double xpadd = Integer.parseInt(args[1]);
            if(CCPlayerInfo.get().getString(nick+".PC")!=null){
                double xphave = CCPlayerInfo.get().getDouble(nick+".XP");
                int levelP = CCPlayerInfo.get().getInt(nick+".Level");
                if(xphave+xpadd>CCPlayerInfo.get().getDouble(nick+".XPNeeded")){
                    double XPP = xphave+xpadd-CCPlayerInfo.get().getDouble(nick+".XPNeeded");
                    CCPlayerInfo.get().set(nick+".Level",levelP+1);
                    CCPlayerInfo.get().set(nick+".XP",0+XPP);
                    CCPlayerInfo.get().set(nick+".XPNeeded",levelP*50+100);
                    int StatStrength = CCStats.get().getInt(nick+".Strength");
                    int StatDefense = CCStats.get().getInt(nick+".Defense");
                    int StatHealth= CCStats.get().getInt(nick+".Health");
                    int StatAgility = CCStats.get().getInt(nick+".Agility");
                    int StatIntelligence = CCStats.get().getInt(nick+".Intelligence");
                    int StatStamina = CCStats.get().getInt(nick+".Stamina");
                    int Points = CCStats.get().getInt(nick+".Points");
                    Points+=2;
                    StatStrength++;
                    StatAgility++;
                    StatDefense++;
                    StatHealth++;
                    StatIntelligence++;
                    StatStamina++;
                    CCStats.get().set(nick+".Points",Points);
                    CCStats.get().set(nick+".Strength",StatStrength);
                    CCStats.get().set(nick+".Defense",StatDefense);
                    CCStats.get().set(nick+".Health",StatHealth);
                    CCStats.get().set(nick+".Intelligence",StatIntelligence);
                    CCStats.get().set(nick+".Stamina",StatStamina);
                    CCStats.get().set(nick+".Agility",StatAgility);
                    CCStats.save();
                    CCPlayerInfo.save();
                    Player p = Bukkit.getPlayerExact(nick);
                    System.out.println(p);
                    Player ps = (Player) sender;
                    p.sendMessage(color("&2&l(!) You have been given "+xpadd+"XP by "+ps.getName()+"!"));
                    ps.sendMessage(color("&2&l(!) You have  given "+xpadd+"XP to "+ nick +"!"));
                }else{
                    CCPlayerInfo.get().set(nick+".XP",xphave+xpadd);
                    CCPlayerInfo.save();
                    Player p = Bukkit.getPlayerExact(nick);
                    System.out.println(p);
                    Player ps = (Player) sender;
                    p.sendMessage(color("&2&l(!) You have been given "+xpadd+"XP by "+ps.getName()+"!"));
                    ps.sendMessage(color("&2&l(!) You have  given "+xpadd+"XP to "+ nick +"!"));
                }
            }else{

            }
        }else {

        }

        return true;
    }
}
