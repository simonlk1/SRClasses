package io.github.simonlk1.srclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CooldownManager {
    private final Map<UUID, Long> cooldowns;
    //cooldown in milliseconds
    private final int cooldown;

    public CooldownManager(int cooldown){
        this.cooldowns = new HashMap<>();
        this.cooldown = cooldown;
    }

    private void setCooldown(UUID playerID, long time){
        if(time < 1L) {
            cooldowns.remove(playerID);
        } else {
            cooldowns.put(playerID, time);
        }
    }

    public void setCooldown(UUID playerID){
        this.setCooldown(playerID, System.currentTimeMillis());
    }

    public long getCooldownSeconds(UUID playerID){
        long usedTimeStamp = cooldowns.getOrDefault(playerID, 0L);
        long nowTimeStamp = System.currentTimeMillis();
        long cdMillis = (usedTimeStamp + cooldown) - nowTimeStamp;
        return TimeUnit.MILLISECONDS.toSeconds(cdMillis);
    }

}
