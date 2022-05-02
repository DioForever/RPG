package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.CCOutposts;
import me.dioforever.rpg.files.CCStats;
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
            List everythings = CCOutposts.get().getList("everything");
            int index = everythings.indexOf(id);
            List locs = CCOutposts.get().getList("loc");
            Location locFile = (Location) locs.get(index);
            if(locFile.getWorld()!=loc.getWorld()){
                return;
            }
            List types = CCOutposts.get().getList("Type");
            Player p =  e.getPlayer();
            p.sendMessage("You broke the core of the outpost!");
            String type = (String) types.get(index);
            //p.sendMessage(type);
            p.sendMessage(String.valueOf(types));
            p.sendMessage(String.valueOf(locs));
            p.sendMessage(String.valueOf(everythings));
            types.remove(index);
            locs.remove(index);
            everythings.remove(index);






        }
    }
}
