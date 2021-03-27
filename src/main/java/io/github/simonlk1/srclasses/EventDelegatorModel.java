package io.github.simonlk1.srclasses;

import io.github.simonlk1.srclasses.warrior.LeapConsumer;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Consumer;

import java.util.HashMap;
import java.util.Map;

public class EventDelegatorModel {
    private final Map<Material, Consumer<PlayerInteractEvent>> playerInteractDelegator;

    public EventDelegatorModel() {
        this.playerInteractDelegator = new HashMap<>();
        this.initPlayerInteract();
    }

    public Map<Material, Consumer<PlayerInteractEvent>> getPlayerInteractDelegator(){
        return playerInteractDelegator;
    }

    private void initPlayerInteract() {
        playerInteractDelegator.put(Material.STICK, new LeapConsumer());
    }
}
