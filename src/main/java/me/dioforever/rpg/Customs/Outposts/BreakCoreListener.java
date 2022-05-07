package me.dioforever.rpg.Customs.Outposts;

import me.dioforever.rpg.files.Outposts;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class BreakCoreListener implements Listener {
    //static OrcChampion orcChampion;
    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (e.getBlock().getType() != Material.CRYING_OBSIDIAN) return;
        if (Outposts.get().getList("everything") == null) return;
        Location loc = e.getBlock().getLocation();
        double x1 = loc.getBlockX();
        double y1 = loc.getBlockY();
        double z1 = loc.getBlockZ();
        String idx = String.valueOf((int) x1);
        String idy = String.valueOf((int) y1);
        String idz = String.valueOf((int) z1);
        String id = "x" + idx + "y" + idy + "z" + idz + loc.getWorld();


        if (Outposts.get().getList("everything").contains(id)) {
            List everythings = Outposts.get().getList("everything");
            int index = everythings.indexOf(id);
            List locs = Outposts.get().getList("loc");
            List chunks = Outposts.get().getList("Chunks");
            Location locFile = (Location) locs.get(index);
            if (locFile.getWorld() != loc.getWorld()) {
                return;
            }
            List types = Outposts.get().getList("Type");
            Player p = e.getPlayer();
            p.sendMessage("You broke the core of the outpost!");
            String type = (String) types.get(index);
            //p.sendMessage(type);
            chunks.remove(index);
            types.remove(index);
            locs.remove(index);
            everythings.remove(index);
            Location location = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ() + 5);
            switch (type) {
                case "goblin":
                    //OrcChampion.SpawnOrcChampion(p,location,10);
                    break;
                case "orc":
                    //OrcChampion.SpawnOrcChampion(p,location,10);
                    break;
            }


        }
    }
}
