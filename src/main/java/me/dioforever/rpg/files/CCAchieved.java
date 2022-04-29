package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CCAchieved {
    //Stats
    private static File fileLists;
    private static FileConfiguration customfileLists;


    //Finds or generates custom config file
    public static void setup(){

        fileLists = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "achieved.yml");

        if(!fileLists.exists()){
            try{
                fileLists.createNewFile();
            } catch (IOException e){

            }

        }
        customfileLists = YamlConfiguration.loadConfiguration(fileLists);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfileLists;
    }

    //Saving
    public static void save(){
        try {
            customfileLists.save(fileLists);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (achieved.yml)");
        }

    }

    public static void reload(){
        customfileLists = YamlConfiguration.loadConfiguration(fileLists);
    }

}

