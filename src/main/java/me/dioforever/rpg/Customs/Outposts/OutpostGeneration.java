package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.CCOutposts;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Chain;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutpostGeneration implements Listener {

    public void onChunkLoad(ChunkLoadEvent e){


    }

    public static void spawnStructer(Location middle){
        //SpawnOutpost with the core inside
        middle.getBlock().setType(Material.CRYING_OBSIDIAN);
        double x1 = middle.getBlockX();;
        double y1 = middle.getBlockY();;
        double z1 = middle.getBlockZ();;
        String idx = String.valueOf((int)x1);
        String idy = String.valueOf((int)y1);
        String idz = String.valueOf((int)z1);
        String id = "x"+idx+"y"+idy+"z"+idz+middle.getWorld();

        Random random = new Random();
        int rand = random.nextInt(2);
        String type = "";
        switch (rand){
            case 0:
                    type="goblin";
                break;
            case 1:
                    type="orc";
                break;
        }

        List everything = new ArrayList<>();
        if(CCOutposts.get().getList("everything")!=null){
            everything=CCOutposts.get().getList("everything");
        }
        everything.add(id);
        if(CCOutposts.get().getList("everything")==null){
            CCOutposts.get().addDefault("everything",everything);
        }else{
            CCOutposts.get().set("everything",everything);
        }
        CCOutposts.get().addDefault("Type."+id,type);
        CCOutposts.get().addDefault("loc."+id,middle);
        CCOutposts.save();

        //CHAINS FROM CORE 1.0
        Location locChain1 = new Location(middle.getWorld(), x1+1,y1,z1);
        locChain1.getBlock().setType(Material.CHAIN);
        Location locChain2 = new Location(middle.getWorld(), x1-1,y1,z1);
        locChain2.getBlock().setType(Material.CHAIN);
        //THE ABOVE DONT NEED THE ROTATION EDIT, JUST 3-10
        Location locChain3 = new Location(middle.getWorld(), x1,y1,z1+1);
        locChain3.getBlock().setType(Material.CHAIN);
        Location locChain4 = new Location(middle.getWorld(), x1,y1,z1-1);
        locChain4.getBlock().setType(Material.CHAIN);
        Location locChain5 = new Location(middle.getWorld(), x1,y1+1,z1);
        locChain5.getBlock().setType(Material.CHAIN);
        Location locChain6 = new Location(middle.getWorld(), x1,y1-1,z1);
        locChain6.getBlock().setType(Material.CHAIN);
        Location locChain7 = new Location(middle.getWorld(), x1,y1,z1-2);
        locChain7.getBlock().setType(Material.CHAIN);
        Location locChain8 = new Location(middle.getWorld(), x1,y1,z1+2);
        locChain8.getBlock().setType(Material.CHAIN);
        Location locChain9 = new Location(middle.getWorld(), x1+2,y1,z1);
        locChain9.getBlock().setType(Material.CHAIN);
        Location locChain10 = new Location(middle.getWorld(), x1-2,y1,z1);
        locChain10.getBlock().setType(Material.CHAIN);
        //ROTTATING THE CHAINS 1.1





        //CHISELEDS FROM THE CHAINS 1.0

        Location locChiseled1 = new Location(middle.getWorld(), x1,y1-2,z1);
        locChiseled1.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled2 = new Location(middle.getWorld(), x1,y1+2,z1);
        locChiseled2.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled3 = new Location(middle.getWorld(), x1,y1,z1-3);
        locChiseled3.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled4 = new Location(middle.getWorld(), x1,y1,z1+3);
        locChiseled4.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled5 = new Location(middle.getWorld(), x1-3,y1,z1);
        locChiseled5.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled6 = new Location(middle.getWorld(), x1+3,y1,z1);
        locChiseled6.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        //BLACKSTONE BRICK WALL FROM THE CHISELEDS 1.0
        Location locWall1 = new Location(middle.getWorld(), x1,y1-1,z1-3);
        locWall1.getBlock().setType(Material.DEEPSLATE_BRICK_WALL);
        Location locWall2 = new Location(middle.getWorld(), x1,y1-1,z1+3);
        locWall2.getBlock().setType(Material.DEEPSLATE_BRICK_WALL);
        Location locWall3 = new Location(middle.getWorld(), x1+3,y1-1,z1);
        locWall3.getBlock().setType(Material.DEEPSLATE_BRICK_WALL);
        Location locWall4 = new Location(middle.getWorld(), x1-3,y1-1,z1);
        locWall4.getBlock().setType(Material.DEEPSLATE_BRICK_WALL);
        //CHISELEDS FROM THE BRICK WALLS 1.0
        Location locChiseled7 = new Location(middle.getWorld(), x1-3,y1-2,z1);
        locChiseled7.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled8 = new Location(middle.getWorld(), x1+3,y1-2,z1);
        locChiseled8.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled9 = new Location(middle.getWorld(), x1,y1-2,z1-3);
        locChiseled9.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        Location locChiseled10 = new Location(middle.getWorld(), x1,y1-2,z1+3);
        locChiseled10.getBlock().setType(Material.CHISELED_POLISHED_BLACKSTONE);
        //BLACKSTONE STAIRS ABOVE CHISELEDS 1.0
        Location locStairs1 = new Location(middle.getWorld(), x1,y1+1,z1-3);
        locStairs1.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs2 = new Location(middle.getWorld(), x1,y1+1,z1+3);
        locStairs2.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs3 = new Location(middle.getWorld(), x1+3,y1+1,z1);
        locStairs3.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs4 = new Location(middle.getWorld(), x1-3,y1+1,z1);
        locStairs4.getBlock().setType(Material.BLACKSTONE_STAIRS);
        //SETTINGS STAIRS
        //BLACKSTONE STAIRS BEHIND THE STAIRS 1.0
        Location locStairs5 = new Location(middle.getWorld(), x1,y1+1,z1-2);
        locStairs5.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs6 = new Location(middle.getWorld(), x1,y1+1,z1+2);
        locStairs6.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs7 = new Location(middle.getWorld(), x1+2,y1+1,z1);
        locStairs7.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs8 = new Location(middle.getWorld(), x1-2,y1+1,z1);
        locStairs8.getBlock().setType(Material.BLACKSTONE_STAIRS);
        //CRACKED POLISHED BLACKSTONE BRICKS ABOVE STAIRS 1.0
        //BLACKSTONE STAIRS ABOVE CHISELEDS 1.0
        Location locBricks1 = new Location(middle.getWorld(), x1,y1+2,z1-2);
        locBricks1.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks2 = new Location(middle.getWorld(), x1,y1+2,z1+2);
        locBricks2.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks3 = new Location(middle.getWorld(), x1+2,y1+2,z1);
        locBricks3.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks4 = new Location(middle.getWorld(), x1-2,y1+2,z1);
        locBricks4.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);

        Location locBricks5 = new Location(middle.getWorld(), x1,y1+2,z1-1);
        locBricks5.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks6 = new Location(middle.getWorld(), x1,y1+2,z1+1);
        locBricks6.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks7 = new Location(middle.getWorld(), x1+1,y1+2,z1);
        locBricks7.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        Location locBricks8 = new Location(middle.getWorld(), x1-1,y1+2,z1);
        locBricks8.getBlock().setType(Material.CRACKED_POLISHED_BLACKSTONE_BRICKS);

    }

}

