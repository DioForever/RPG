package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Outposts {

    //Outposts
    private static File fileOutposts;
    private static FileConfiguration customfileOutposts;


    //Finds or generates custom config file
    public static void setup(){

        fileOutposts = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "outposts.yml");

        if(!fileOutposts.exists()){
            try{
                fileOutposts.createNewFile();
            } catch (IOException e){

            }

        }
        customfileOutposts = YamlConfiguration.loadConfiguration(fileOutposts);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfileOutposts;
    }

    //Saving
    public static void save(){
        try {
            customfileOutposts.save(fileOutposts);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (outposts.yml)");
        }

    }

    public static void reload(){
        customfileOutposts = YamlConfiguration.loadConfiguration(fileOutposts);
    }

}
