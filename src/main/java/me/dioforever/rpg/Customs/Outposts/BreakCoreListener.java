package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.CCOutposts;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakCoreListener implements Listener {
    public void onBreakBlock(BlockBreakEvent e){
        if(e.getBlock().getType()!= Material.CRYING_OBSIDIAN)return;
        if(CCOutposts.get().getList("everything")==null)return;
        Location loc = e.getBlock().getLocation();
        double x1 = loc.getBlockX();
        double y1 = loc.getBlockY();
        double z1 = loc.getBlockZ();
        String idx = String.valueOf((int)x1);
        String idy = String.valueOf((int)y1);
        String idz = String.valueOf((int)z1);
        String id = "x"+idx+"y"+idy+"z"+idz;

        if(CCOutposts.get().getList("everything").contains(id)){
            Player p =  e.getPlayer();
            p.sendMessage("You broke the core of the outpost!");
        }
    }
}
