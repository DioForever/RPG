package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CCPlayerInfo {

    //Stats
    private static File filePlayerInfo;
    private static FileConfiguration customfilePlayerInfo;


    //Finds or generates custom config file
    public static void setup(){

        filePlayerInfo = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "playerinfo.yml");

        if(!filePlayerInfo.exists()){
            try{
                filePlayerInfo.createNewFile();
            } catch (IOException e){

            }

        }
        customfilePlayerInfo = YamlConfiguration.loadConfiguration(filePlayerInfo);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfilePlayerInfo;
    }

    //Saving
    public static void save(){
        try {
            customfilePlayerInfo.save(filePlayerInfo);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (playerinfo.yml)");
        }

    }

    public static void reload(){
        customfilePlayerInfo = YamlConfiguration.loadConfiguration(filePlayerInfo);
    }

}
