package me.dioforever.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class Updates implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List list = new ArrayList<String>();
        list.add("Tank");
        list.add("Lucker");
        list.add("Mana Affinity");
        list.add("Runner");
        list.add("Power of Giant");
        list.add("Jumper");
        list.add("Reinforcement");
        list.add("Night Watcher");
        List listG = new ArrayList<String>();
        listG.add("/Guild create <NameOfGuild>");
        listG.add("/Guild invite <NameOfPlayer>");
        listG.add("/Guild join <NameOfGuild>");


        Player player = (Player) sender;
        player.sendMessage(color("&4The last update added:"));
        player.sendMessage(color("&aXP from Farming &4&l-- WORKING --"));
        player.sendMessage(color("&aXP from Mining &4&l-- WORKING --"));
        player.sendMessage(color("&aGuilds &4&l-- WORKING ON--"));
        player.sendMessage(color("&aWorking Guild commands: &e"));
        player.sendMessage(color("&e/Guild create <NameOfGuild>"));
        player.sendMessage(color("&e/Guild invite <NameOfPlayer>"));
        player.sendMessage(color("&e/Guild join <NameOfGuild>"));
        player.sendMessage(color("&e/Guild leave <NameOfGuild>"));
        player.sendMessage(color("&eleave allows you to leave/delete Guild!"));
        player.sendMessage(color("&aUnique Abilities &4&l-- WORKING ON --"));
        player.sendMessage(color("&aWorking Unique Abilities: &e"+list));



        return true;
    }
}
