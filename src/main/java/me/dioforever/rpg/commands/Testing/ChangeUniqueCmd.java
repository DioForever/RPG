package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class ChangeUniqueCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            String nick = p.getName();

            String UA = CCPlayerInfo.get().getString(nick+".Class.Unique");
            if(p.isOp()){
                if(args.length==0){
                    p.sendMessage(color("&e&l(!)&r&e You didnt specify what Unique Ability you want to change to!"));
                }else{
                    String UAW = "";
                    int k = args.length;
                    for(int i = 0; i<k;i++){
                        if(i==0){
                            UAW = args[0];
                        }else{
                            UAW = UAW+" "+args[i];
                        }
                    }
                    List UAL = new ArrayList();
                    UAL.add("Reinforcer I");
                    UAL.add("Lucker I");
                    UAL.add("Miner I");
                    UAL.add("Tank I");
                    UAL.add("Blacksmith I");
                    UAL.add("Night Watcher I");
                    UAL.add("Regenerate I");
                    UAL.add("Third Eye I");
                    UAL.add("Blood Thief I");
                    UAL.add("Power of Giant I");
                    UAL.add("Master Swordsman I");
                    UAL.add("Master Archer I");
                    UAL.add("Mana Affinity I");
                    UAL.add("Commander I");
                    UAL.add("Solo I");
                    //Level 2
                    UAL.add("Reinforcer II");
                    UAL.add("Lucker II");
                    UAL.add("Miner II");
                    UAL.add("Tank II");
                    UAL.add("Blacksmith II");
                    UAL.add("Night Watcher II");
                    UAL.add("Regenerate II");
                    UAL.add("Third Eye II");
                    UAL.add("Blood Thief II");
                    UAL.add("Power of Giant II");
                    UAL.add("Master Swordsman II");
                    UAL.add("Master Archer II");
                    UAL.add("Mana Affinity II");
                    UAL.add("Commander II");
                    UAL.add("Solo II");
                    //Level 3
                    UAL.add("Reinforcer III");
                    UAL.add("Lucker III");
                    UAL.add("Miner III");
                    UAL.add("Tank III");
                    UAL.add("Blacksmith III");
                    UAL.add("Night Watcher III");
                    UAL.add("Regenerate III");
                    UAL.add("Third Eye III");
                    UAL.add("Blood Thief III");
                    UAL.add("Power of Giant III");
                    UAL.add("Master Swordsman III");
                    UAL.add("Master Archer III");
                    UAL.add("Mana Affinity III");
                    UAL.add("Commander III");
                    UAL.add("Solo III");

                    if(!UAL.contains(UAW)){
                        p.sendMessage(color("&e&l(!)&r&e You wrote the wanted Unique Ability wrongly!"));
                    }else{
                        CCPlayerInfo.get().set(nick+".Class.Unique",UAW);
                        CCPlayerInfo.save();
                        p.sendMessage(color("&e&l(!)&r&e Your Unique Ability has been changed to "+UAW+"!"));
                    }


                }
            }else {
                p.sendMessage(color("&e&l(!)&r&e You don´t have perms to this command!"));
            }



        }


        return true;
    }
}
