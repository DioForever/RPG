package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.files.CCSkills;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class GiveSkillCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(p.isOp()){
                String nick = p.getName();
                List posSkills = new ArrayList();
                posSkills.add("trash");
                posSkills.add("bomb");
                posSkills.add("Quadra Insta Killer");
                posSkills.add("Lmao");
                List classes = new ArrayList();
                classes.add("Legendary");
                classes.add("Epic");
                classes.add("Rare");
                classes.add("Common");
                if(args.length<1){
                    p.sendMessage(color("&e&l(!)&r&e You didn´t specify the skill and the class of the skill!"));
                }else {
                    String class_ = args[0];
                    if(!classes.contains(class_)){
                        p.sendMessage(color("&e&l(!)&r&e You specified wrongly or didn´t the class of the skill! [Legendary, Epic, Rare, Common]"));
                    }else{
                        String skill_ = args[1];
                        if(!posSkills.contains(skill_)){
                            p.sendMessage(color("&e&l(!)&r&e You didn´t specify the skill or specified the skill that doesn´t exist!"));
                        }else{
                            List wSkills = CCSkills.get().getList(nick+".Skills."+class_);
                            wSkills.add(skill_);
                            CCSkills.get().set(nick+".Skills."+class_,wSkills);
                            CCSkills.save();
                            p.sendMessage(color("&e&l(!)&r&e Skill "+skill_+" in class "+class_+" has been added to your Skills!"));
                        }
                    }
                }

            }else{
                p.sendMessage(color("&e&l(!)&r&e You don´t have perms to this command!"));
            }

        }
        return true;
    }
}
