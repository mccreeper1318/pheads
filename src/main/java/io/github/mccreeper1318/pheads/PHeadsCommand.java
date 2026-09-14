package io.github.mccreeper1318.pheads;

import java.util.List;
import java.util.Locale;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class PHeadsCommand implements CommandExecutor, TabCompleter {

    private static final String RELOAD_PERMISSION = "pheads.reload";

    private final PHeadsPlugin plugin;

    PHeadsCommand(PHeadsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission(RELOAD_PERMISSION)) {
                sender.sendMessage("You do not have permission to reload PHeads.");
                return true;
            }

            plugin.reloadHeadDropConfig();
            sender.sendMessage("PHeads configuration reloaded.");
            return true;
        }

        sender.sendMessage("Usage: /pheads reload");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String alias,
            @NotNull String[] args) {
        if (args.length == 1
                && sender.hasPermission(RELOAD_PERMISSION)
                && "reload".startsWith(args[0].toLowerCase(Locale.ROOT))) {
            return List.of("reload");
        }

        return List.of();
    }
}
