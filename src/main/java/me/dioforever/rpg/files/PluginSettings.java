package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PluginSettings {

    //Stats
    private static File fileStats;
    private static FileConfiguration customfileStats;


    //Finds or generates custom config file
    public static void setup(){

        fileStats = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "settings.yml");

        if(!fileStats.exists()){
            try{
                fileStats.createNewFile();
            } catch (IOException e){

            }

        }
        customfileStats = YamlConfiguration.loadConfiguration(fileStats);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfileStats;
    }

    //Saving
    public static void save(){
        try {
            customfileStats.save(fileStats);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (settings.yml)");
        }

    }

    public static void reload(){
        customfileStats = YamlConfiguration.loadConfiguration(fileStats);
    }

}
