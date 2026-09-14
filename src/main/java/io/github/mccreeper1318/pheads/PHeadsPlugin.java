package io.github.mccreeper1318.pheads;

import org.bukkit.plugin.java.JavaPlugin;

public final class PHeadsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        HeadDropConfig headDropConfig = HeadDropConfig.from(getConfig(), getLogger());
        getServer().getPluginManager().registerEvents(new HeadDropListener(headDropConfig), this);
    }
}
