package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.Outposts;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Chain;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutpostGeneration implements Listener {


    public void onChunkLoad(ChunkLoadEvent e){

    }

    public static void spawnStructer(Location middle1){
        Location middle = new Location(middle1.getWorld(),middle1.getBlockX(),middle1.getBlockY()-2,middle1.getBlockZ());

        World world = middle.getWorld();
        world.strikeLightningEffect(middle);
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
        List locs = new ArrayList<>();
        List types = new ArrayList<>();
        List chunks = new ArrayList<>();
        if(Outposts.get().getList("everything")!=null){
            everything=Outposts.get().getList("everything");
            locs=Outposts.get().getList("loc");
            types=Outposts.get().getList("Type");
            //chunks=Outposts.get().getList("Chunks");

        }
        everything.add(id);
        locs.add(middle);
        types.add(type);
        chunks.add(middle.getChunk());
        if(Outposts.get().getList("everything")==null){
            Outposts.get().addDefault("everything",everything);
            Outposts.get().addDefault("Type",types);
            Outposts.get().addDefault("loc",locs);
            //Outposts.get().addDefault("Chunks",chunks);
        }else{
            Outposts.get().set("everything",everything);
            Outposts.get().set("Type",types);
            Outposts.get().set("loc",locs);
            //Outposts.get().set("Chunks",chunks);
        }
        Outposts.save();


        //CHAINS FROM CORE 1.0
        Location locChain1 = new Location(middle.getWorld(), x1+1,y1,z1);
        locChain1.getBlock().setType(Material.CHAIN);
        Location locChain2 = new Location(middle.getWorld(), x1-1,y1,z1);
        locChain2.getBlock().setType(Material.CHAIN);
        Location locChain3 = new Location(middle.getWorld(), x1,y1,z1+1);
        locChain3.getBlock().setType(Material.CHAIN);
        Location locChain4 = new Location(middle.getWorld(), x1,y1,z1-1);
        locChain4.getBlock().setType(Material.CHAIN);
        //EXCLUDE 5,6 CUZ ITS ALREADY ON Y Axis
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
        Block blockchain3 = locChain3.getBlock();
        BlockState stateC3 = blockchain3.getState();
        Chain chain3 = (Chain) stateC3.getBlockData();
        chain3.setAxis(Axis.Z);
        stateC3.setBlockData(chain3);
        stateC3.update(false, false);

        Block blockchain4 = locChain4.getBlock();
        BlockState stateC4 = blockchain4.getState();
        Chain chain4 = (Chain) stateC4.getBlockData();
        chain4.setAxis(Axis.Z);
        stateC4.setBlockData(chain4);
        stateC4.update(false, false);

        Block blockchain7 = locChain7.getBlock();
        BlockState stateC7 = blockchain7.getState();
        Chain chain7 = (Chain) stateC7.getBlockData();
        chain7.setAxis(Axis.Z);
        stateC7.setBlockData(chain7);
        stateC7.update(false, false);

        Block blockchain8 = locChain8.getBlock();
        BlockState stateC8 = blockchain8.getState();
        Chain chain8 = (Chain) stateC8.getBlockData();
        chain8.setAxis(Axis.Z);
        stateC8.setBlockData(chain4);
        stateC8.update(false, false);

        Block blockchain1 = locChain1.getBlock();
        BlockState stateC1 = blockchain1.getState();
        Chain chain1 = (Chain) stateC1.getBlockData();
        chain1.setAxis(Axis.X);
        stateC1.setBlockData(chain1);
        stateC1.update(false, false);

        Block blockchain2 = locChain2.getBlock();
        BlockState stateC2 = blockchain2.getState();
        Chain chain2 = (Chain) stateC2.getBlockData();
        chain2.setAxis(Axis.X);
        stateC2.setBlockData(chain2);
        stateC2.update(false, false);

        Block blockchain9 = locChain9.getBlock();
        BlockState stateC9 = blockchain9.getState();
        Chain chain9 = (Chain) stateC9.getBlockData();
        chain9.setAxis(Axis.X);
        stateC9.setBlockData(chain9);
        stateC9.update(false, false);

        Block blockchain10 = locChain10.getBlock();
        BlockState stateC10 = blockchain10.getState();
        Chain chain10 = (Chain) stateC10.getBlockData();
        chain10.setAxis(Axis.X);
        stateC10.setBlockData(chain10);
        stateC10.update(false, false);



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
        //SETTINGS STAIRS ROTATION
        Block blockStairs1 = locStairs1.getBlock();
        BlockState state1 = blockStairs1.getState();
        Stairs stairs1 = (Stairs) state1.getBlockData();
        stairs1.setFacing(BlockFace.SOUTH);
        state1.setBlockData(stairs1);
        state1.update(false, false);

        Block blockStairs3 = locStairs3.getBlock();
        BlockState state3 = blockStairs3.getState();
        Stairs stairs3 = (Stairs) state3.getBlockData();
        stairs3.setFacing(BlockFace.WEST);
        state3.setBlockData(stairs3);
        state3.update(false, false);

        Block blockStairs4 = locStairs4.getBlock();
        BlockState state4 = blockStairs4.getState();
        Stairs stairs4 = (Stairs) state4.getBlockData();
        stairs4.setFacing(BlockFace.EAST);
        state4.setBlockData(stairs4);
        state4.update(false, false);





        //stairs.setHalf(Bisected.Half.TOP);

        //BLACKSTONE STAIRS BEHIND THE STAIRS 1.0
        Location locStairs5 = new Location(middle.getWorld(), x1,y1+1,z1-2);
        locStairs5.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs6 = new Location(middle.getWorld(), x1,y1+1,z1+2);
        locStairs6.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs7 = new Location(middle.getWorld(), x1+2,y1+1,z1);
        locStairs7.getBlock().setType(Material.BLACKSTONE_STAIRS);
        Location locStairs8 = new Location(middle.getWorld(), x1-2,y1+1,z1);
        locStairs8.getBlock().setType(Material.BLACKSTONE_STAIRS);
        //ROTATING STAIRS 1.1

        Block blockStairs5 = locStairs5.getBlock();
        BlockState state5 = blockStairs5.getState();
        Stairs stairs5 = (Stairs) state5.getBlockData();
        stairs5.setFacing(BlockFace.NORTH);
        stairs5.setHalf(Bisected.Half.TOP);
        state5.setBlockData(stairs5);
        state5.update(false, false);

        Block blockStairs6 = locStairs6.getBlock();
        BlockState state6 = blockStairs6.getState();
        Stairs stairs6 = (Stairs) state6.getBlockData();
        stairs6.setFacing(BlockFace.SOUTH);
        stairs6.setHalf(Bisected.Half.TOP);
        state6.setBlockData(stairs6);
        state6.update(false, false);

        Block blockStairs7 = locStairs7.getBlock();
        BlockState state7 = blockStairs7.getState();
        Stairs stairs7 = (Stairs) state7.getBlockData();
        stairs7.setFacing(BlockFace.EAST);
        stairs7.setHalf(Bisected.Half.TOP);
        state7.setBlockData(stairs7);
        state7.update(false, false);

        Block blockStairs8 = locStairs8.getBlock();
        BlockState state8 = blockStairs8.getState();
        Stairs stairs8 = (Stairs) state8.getBlockData();
        stairs8.setFacing(BlockFace.WEST);
        stairs8.setHalf(Bisected.Half.TOP);
        state8.setBlockData(stairs8);
        state8.update(false, false);

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
    /*
    public static Location getCenterChunkLocation(Chunk c){
        Location center = new Location(c.getWorld(), c.getX() << 4, 64, c.getZ() << 4).add(8, 0, 8);
        center.setY(center.getWorld().getHighestBlockYAt(center) + 1);
        return center;
    }

    public static Location getSouthEast(Chunk chunk){
        Location center = getCenterChunkLocation(chunk);
        Location topLeft = center.clone().add(7.5, 0, 7.5);
        return topLeft;
    }

    public static Location getNorthEast(Chunk chunk){
        Location center = getCenterChunkLocation(chunk);
        Location topRight = center.clone().add(7.5, 0, -7.5);
        return topRight;
    }

    public static Location getNorthWest(Chunk chunk){
        Location center = getCenterChunkLocation(chunk);
        Location bottomLeft = center.clone().add(-7.5, 0, -7.5);
        return bottomLeft;
    }

    public static Location getSouthWest(Chunk chunk){
        Location center = getCenterChunkLocation(chunk);
        Location bottomRight = center.clone().add(-7.5, 0, 7.5);
        return bottomRight;
    }
    */

}

