package me.dioforever.rpg.commands.Testing;

import me.dioforever.rpg.Customs.Entities.Cryomancer;
import me.dioforever.rpg.Main;
import me.dioforever.rpg.Utils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class spawnparticle implements CommandExecutor {


    static Main plugin;

    public spawnparticle(Main main){
        plugin=main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            new BukkitRunnable() {
                int l =1;
                @Override
                public void run() {
                    Location location = ((Player) sender).getLocation();
                    location.add(0,1,0);
                    for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                        double radius = Math.sin(i);
                        double y = Math.cos(i)*l;
                        for (double a = 0; a < Math.PI * 2; a+= Math.PI / 10) {
                            double x = Math.cos(a) * radius*l;
                            double z = Math.sin(a) * radius*l;
                            location.add(x, y, z);
                            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.WHITE,0.8F);
                            p.getWorld().spawnParticle(Particle.REDSTONE,location,1,dustOptions);
                            List<Entity> nearby = (List<Entity>) location.getWorld().getNearbyEntities(location,1,1,1);
                            for(int k=0;k<nearby.size();k++){
                                Entity entity = nearby.get(k);
                                //Utils.dealDamage(Cryomancer,entity,15,"freeze");
                            }
                            location.subtract(x, y, z);
                        }
                    }
                    l++;
                    if(l>5)cancel();
                }
            }.runTaskTimer(plugin,0,1);
            }
        return true;
    }
}
