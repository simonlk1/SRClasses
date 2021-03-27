package io.github.simonlk1.srclasses.warrior;

import io.github.simonlk1.srclasses.CooldownManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Consumer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LeapConsumer implements Consumer<PlayerInteractEvent> {
    private final CooldownManager cooldownManager;

    public LeapConsumer(){
        cooldownManager = new CooldownManager(5000);
    }

    @Override
    public void accept(PlayerInteractEvent playerInteractEvent) {
        Player player = playerInteractEvent.getPlayer();
        UUID playerID = player.getUniqueId();

        long cooldown = cooldownManager.getCooldownSeconds(playerID);

        if(cooldown <= 0){
            player.sendMessage(ChatColor.GREEN + "Leap!");
            cooldownManager.setCooldown(playerID);
            new LeapExecutor(playerID);
        } else {
            player.sendMessage(ChatColor.RED + String.valueOf(cooldown) + " seconds before you can leap again");
        }
    }

}
