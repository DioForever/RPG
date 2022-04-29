package me.dioforever.rpg.commands.Guilds;

import me.dioforever.rpg.files.CCGuilds;
import me.dioforever.rpg.files.CCPlayerInfo;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class GuildCMDS implements CommandExecutor {

    static List ExGuildList;
    static List PlayersJoinedG;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length==0){
                p.sendMessage(color("&e&l(!)&r&e You didnt specify what you want to do with the Guild!"));
            }else{
                String firstArg = args[0];
                if(args[0].contains("create")){
                    if(!(CCGuilds.get().getList("Guilds").isEmpty())){
                        ExGuildList = CCGuilds.get().getList("Guilds");
                    }
                    String nick = p.getName();
                        if(args.length>1){
                            String arg = args[1];
                            if(!(ExGuildList.contains(arg))){
                                ExGuildList.add(arg);
                                PlayersJoinedG = CCGuilds.get().getList("GuildJoined");
                                if(!(PlayersJoinedG.contains(nick))){
                                    PlayersJoinedG.add(nick);
                                    List<String> Members = new ArrayList(15);
                                    Members.add("0");
                                    List<String> Invited = new ArrayList();
                                    Invited.add("0");

                                    CCPlayerInfo.get().set(nick+".Guild",arg);
                                    CCGuilds.get().set("Guild."+arg+".Owner",nick);
                                    CCGuilds.get().set("Guild."+arg+".Members",Members);
                                    CCGuilds.get().set("Guild."+arg+".invited",Invited);
                                    CCGuilds.get().set("GuildJoined",PlayersJoinedG);
                                    p.sendMessage(color("&a&l(!) &r&aGuild has been created!"));
                                    CCGuilds.save();
                                    CCPlayerInfo.save();
                                }else{
                                    p.sendMessage(color("&4&l(!) &r&4You already are in Guild!"));
                                }
                            }else{
                                p.sendMessage(color("&4&l(!) &r&4Guild with this name already exists!"));
                            }

                        }else{
                            p.sendMessage(color("&e&l(!)&r&e You didnt specify the name of the Guild!'"));
                        }


                        //INVITE COMMAND
                }else if(args[0].contains("invite")){
                    if(args.length>1){
                        String nick = p.getName();
                        String Guild = CCPlayerInfo.get().getString(nick+".Guild");
                        Player target = Bukkit.getPlayerExact(args[1]);
                        String nickT = target.getName();
                        List Members = new ArrayList();
                        Members = CCGuilds.get().getList("Guild."+Guild+".Members");
                        List invited;
                        invited = CCGuilds.get().getList("Guild."+Guild+".invited");
                        invited.add(nickT);
                        CCGuilds.get().set("Guild."+Guild+".invited",invited);

                        TextComponent message = new TextComponent("(!) Click to join "+Guild+" Guild.");
                        message.setBold(true);
                        message.setColor(net.md_5.bungee.api.ChatColor.YELLOW);
                        message.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild join "+Guild ));
                        target.spigot().sendMessage(message);
                        p.sendMessage(color("&a&l(!)&r&a You have invited "+nickT+" to join "+Guild+" Guild!"));
                        CCGuilds.save();
                        CCPlayerInfo.save();
                    }
                    //JOIN COMMAND
                }else if(args[0].contains("join")){
                    if(args.length>1){
                        String Guild = args[1];
                        Player pl = (Player) sender;
                        String nickT = pl.getName();
                        List<String> Members = new ArrayList();
                        Members = CCGuilds.get().getStringList("Guild."+Guild+".Members");
                        List invited = new ArrayList();
                        invited = CCGuilds.get().getList("Guild."+Guild+".invited");
                        if(invited.contains(nickT)){
                            String GOwner = CCGuilds.get().getString("Guild."+Guild+".Owner");
                            Player PGOwner = Bukkit.getPlayerExact(GOwner);
                            //Player joined - listed
                            PlayersJoinedG = CCGuilds.get().getList("GuildJoined");
                            PlayersJoinedG.add(nickT);
                            CCGuilds.get().set("GuildJoined",PlayersJoinedG);

                            CCGuilds.save();
                            CCPlayerInfo.save();

                            //Player added to Guild - listed
                            Members.add(nickT);
                            CCPlayerInfo.get().set(nickT+".Guild",Guild);
                            CCGuilds.get().set("Guild."+Guild+".Members",Members);
                            pl.sendMessage(color("&a&l(!)&r&a You have joined "+Guild+" Guild!"));
                            PGOwner.sendMessage(color("&a&l(!)&r&a"+nickT+" have joined your Guild!"));
                            CCGuilds.save();
                            CCPlayerInfo.save();


                        }

                    }
                }else if(args[0].contains("leave")){
                    if(args.length>1){
                        String nick = p.getName();
                        String Guild = args[1];
                        List Guilds = new ArrayList();
                        Guilds = CCGuilds.get().getList("Guilds");
                        if(Guilds.contains(Guild)){
                            String Owner = CCGuilds.get().getString("Guild."+Guild+".Owner");
                            List<String>members =  new ArrayList();
                            members = CCGuilds.get().getStringList("Guild."+Guild+".Members");
                            List GJoined = new ArrayList();
                            GJoined = CCGuilds.get().getList("GuildJoined");

                            if(members.contains(nick)){
                                members.remove(nick);
                                GJoined.remove(nick);
                                Guilds.remove(Guild);
                                CCGuilds.get().set("GuildJoined",GJoined);
                                CCGuilds.get().set("Guilds",Guilds);
                                CCGuilds.get().set("Guild."+Guild+".Members",members);
                                CCPlayerInfo.get().set(nick+".Guild","");

                                CCGuilds.save();
                                CCPlayerInfo.save();
                                p.sendMessage(color("&e&l(!)&r&e You have left the Guild "+Guild+"&e!"));
                            }else if(Owner.contains(nick)){
                                members.remove(nick);
                                GJoined.remove(nick);
                                Guilds.remove(Guild);
                                CCGuilds.get().set("GuildJoined",GJoined);
                                CCPlayerInfo.get().set(nick+".Guild","");
                                CCGuilds.get().set("Guild."+Guild,null);
                                CCGuilds.get().set("Guilds",Guilds);
                                CCGuilds.save();
                                CCPlayerInfo.save();
                                p.sendMessage(color("&e&l(!)&r&e You have deleted the Guild "+Guild+"&e!"));
                            }
                        }else{
                            List GJoined = new ArrayList();
                            GJoined = CCGuilds.get().getList("GuildJoined");
                            GJoined.remove(nick);
                            CCPlayerInfo.get().set(nick+".Guild","");
                            CCGuilds.get().set("GuildJoined",GJoined);
                            CCGuilds.save();
                            CCPlayerInfo.save();
                            p.sendMessage(color("&e&l(!)&r&e You have left the Guild "+Guild+"&e!"));
                        }



                    }

                } else{
                    p.sendMessage(color("&e&l(!)&r&e System couldn't´t recognize what you want to do with the Guild'"));
                }


            }
        }else{

        }


        return true;
    }
}
