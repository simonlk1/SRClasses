package io.github.simonlk1.srclasses.warrior;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.UUID;

public class LeapExecutor {
    private final UUID playerID;

    public LeapExecutor(UUID playerID){
        this.playerID = playerID;
        this.leap();
    }

    private void leap(){
        Player player = Bukkit.getPlayer(playerID);
        if(player != null){
            Location location = player.getLocation();
            Vector direction = location.getDirection();
            Vector velocity = player.getVelocity();
            Vector newVelocity = velocity.add(direction.multiply(2));

            player.spawnParticle(Particle.EXPLOSION_NORMAL, location, 5);
            player.setVelocity(newVelocity);
        }
    }


}
