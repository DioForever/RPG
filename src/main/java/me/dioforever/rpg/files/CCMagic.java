package me.dioforever.rpg.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CCMagic {

    //Stats
    private static File fileMagic;
    private static FileConfiguration customfileMagic;


    //Finds or generates custom config file
    public static void setup(){

        fileMagic = new File(Bukkit.getServer().getPluginManager().getPlugin("RPG").getDataFolder(), "magic.yml");

        if(!fileMagic.exists()){
            try{
                fileMagic.createNewFile();
            } catch (IOException e){

            }

        }
        customfileMagic = YamlConfiguration.loadConfiguration(fileMagic);

    }

    //Getting it at other places
    public static FileConfiguration get(){
        return customfileMagic;
    }

    //Saving
    public static void save(){
        try {
            customfileMagic.save(fileMagic);
        }catch (IOException e){
            System.out.println("Couldn´t save your file (magic.yml)");
        }

    }

    public static void reload(){
        customfileMagic = YamlConfiguration.loadConfiguration(fileMagic);
    }

}
