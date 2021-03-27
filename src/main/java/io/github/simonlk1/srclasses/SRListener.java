package io.github.simonlk1.srclasses;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Consumer;

import java.util.Map;

public class SRListener implements Listener {
    private final EventDelegatorModel eventDelegatorModel;

    public SRListener(){
        eventDelegatorModel = new EventDelegatorModel();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Map<Material, Consumer<PlayerInteractEvent>> delegator = eventDelegatorModel.getPlayerInteractDelegator();
        ItemStack item = event.getItem();
        if(item == null) return;
        Material material = item.getType();

        if(event.getAction() == Action.RIGHT_CLICK_AIR){
            if(delegator.containsKey(material))
                delegator.get(material).accept(event);
        }
    }
}
