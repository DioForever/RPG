package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.CCOutposts;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class BreakCoreListener implements Listener {
    @EventHandler
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
        String id = "x"+idx+"y"+idy+"z"+idz+loc.getWorld();

        if(CCOutposts.get().getList("everything").contains(id)){
            Location locFile = CCOutposts.get().getLocation("loc."+id);
            if(locFile.getWorld()!=loc.getWorld()){
                return;
            }
            Player p =  e.getPlayer();
            p.sendMessage("You broke the core of the outpost!");
            String type = CCOutposts.get().getString("Type."+id);
            p.sendMessage(type);
            List types = CCOutposts.get().getList("Type."+id);
            List locs = CCOutposts.get().getList("loc."+id);
            List everythings = CCOutposts.get().getList("everything");
            int index = everythings.indexOf(id);
            p.sendMessage(String.valueOf(index));
            types.remove(index);
            locs.remove(index);
            everythings.remove(index);





        }
    }
}
