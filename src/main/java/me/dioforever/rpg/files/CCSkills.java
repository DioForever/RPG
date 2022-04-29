package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CCSkills {

    //Skills
    private static File fileSkills;
    private static FileConfiguration customfileSkills;


    //Finds or generates custom config file
    public static void setup(){

        fileSkills = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "skills.yml");

        if(!fileSkills.exists()){
            try{
                fileSkills.createNewFile();
            } catch (IOException e){

            }

        }
        customfileSkills = YamlConfiguration.loadConfiguration(fileSkills);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfileSkills;
    }

    //Saving
    public static void save(){
        try {
            customfileSkills.save(fileSkills);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (skills.yml)");
        }

    }

    public static void reload(){
        customfileSkills = YamlConfiguration.loadConfiguration(fileSkills);
    }

}
