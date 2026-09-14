package io.github.mccreeper1318.pheads;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PHeadsPlugin extends JavaPlugin {

    private HeadDropListener headDropListener;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        headDropListener = new HeadDropListener(loadHeadDropConfig());
        getServer().getPluginManager().registerEvents(headDropListener, this);

        PluginCommand pheadsCommand = getCommand("pheads");
        if (pheadsCommand == null) {
            throw new IllegalStateException("The pheads command is missing from plugin.yml");
        }

        PHeadsCommand commandHandler = new PHeadsCommand(this);
        pheadsCommand.setExecutor(commandHandler);
        pheadsCommand.setTabCompleter(commandHandler);
    }

    void reloadHeadDropConfig() {
        reloadConfig();
        headDropListener.setConfig(loadHeadDropConfig());
    }

    private HeadDropConfig loadHeadDropConfig() {
        return HeadDropConfig.from(getConfig(), getLogger());
    }
}
