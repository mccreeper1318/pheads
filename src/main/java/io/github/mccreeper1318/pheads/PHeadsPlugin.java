package io.github.mccreeper1318.pheads;

import java.nio.file.Path;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PHeadsPlugin extends JavaPlugin {

    private HeadDropListener headDropListener;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        final HeadDropConfig initialConfig;
        try {
            initialConfig = loadHeadDropConfig();
        } catch (HeadDropConfigException exception) {
            getLogger().severe("Unable to load PHeads configuration: " + exception.getMessage());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        headDropListener = new HeadDropListener(initialConfig);
        getServer().getPluginManager().registerEvents(headDropListener, this);

        PluginCommand pheadsCommand = getCommand("pheads");
        if (pheadsCommand == null) {
            throw new IllegalStateException("The pheads command is missing from plugin.yml");
        }

        PHeadsCommand commandHandler = new PHeadsCommand(this);
        pheadsCommand.setExecutor(commandHandler);
        pheadsCommand.setTabCompleter(commandHandler);
    }

    boolean reloadHeadDropConfig() {
        final HeadDropConfig reloadedConfig;
        try {
            reloadedConfig = loadHeadDropConfig();
        } catch (HeadDropConfigException exception) {
            getLogger().warning("Unable to reload PHeads configuration: " + exception.getMessage());
            return false;
        }

        headDropListener.setConfig(reloadedConfig);
        return true;
    }

    private HeadDropConfig loadHeadDropConfig() throws HeadDropConfigException {
        return HeadDropConfig.load(configPath());
    }

    private Path configPath() {
        return getDataFolder().toPath().resolve("config.yml");
    }
}
