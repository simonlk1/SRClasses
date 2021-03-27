package io.github.simonlk1.srclasses;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");

        //register listener(s?)
        this.getServer().getPluginManager().registerEvents(new SRListener(), this);

    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }

}
