package io.github.mccreeper1318.pheads;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class PHeadsCommand implements CommandExecutor, TabCompleter {

    private static final String RELOAD_PERMISSION = "pheads.reload";
    private static final String GIVE_PERMISSION = "pheads.give";
    private static final List<String> HEAD_KEYS = Arrays.stream(HeadType.values())
            .map(HeadType::configKey)
            .sorted()
            .toList();

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
            return handleReload(sender);
        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("give")) {
            return handleGive(sender, args);
        }

        sender.sendMessage("Usage: /pheads reload | /ph give <mob-head>");
        return true;
    }

    private boolean handleReload(CommandSender sender) {
        if (!sender.hasPermission(RELOAD_PERMISSION)) {
            sender.sendMessage("You do not have permission to reload PHeads.");
            return true;
        }

        if (plugin.reloadHeadDropConfig()) {
            sender.sendMessage("PHeads configuration reloaded.");
        } else {
            sender.sendMessage("PHeads configuration reload failed. Check the server console for details.");
        }
        return true;
    }

    private boolean handleGive(CommandSender sender, String[] args) {
        if (!sender.hasPermission(GIVE_PERMISSION)) {
            sender.sendMessage("You do not have permission to give PHeads mob heads.");
            return true;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use /ph give <mob-head>.");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage("Usage: /ph give <mob-head>");
            return true;
        }

        String requestedHead = String.join("-", Arrays.copyOfRange(args, 1, args.length))
                .toLowerCase(Locale.ROOT)
                .replace('_', '-');
        HeadType headType = Arrays.stream(HeadType.values())
                .filter(type -> type.configKey().equals(requestedHead))
                .findFirst()
                .orElse(null);

        if (headType == null) {
            sender.sendMessage("Unknown mob head '" + requestedHead + "'. Use tab completion to see supported heads.");
            return true;
        }

        var leftovers = player.getInventory().addItem(HeadItemFactory.create(headType));
        leftovers.values().forEach(item -> player.getWorld().dropItemNaturally(player.getLocation(), item));
        sender.sendMessage("Gave you 1 " + headType.displayName() + ".");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String alias,
            @NotNull String[] args) {
        if (args.length == 1) {
            String prefix = args[0].toLowerCase(Locale.ROOT);
            return availableSubcommands(sender).stream()
                    .filter(subcommand -> subcommand.startsWith(prefix))
                    .toList();
        }

        if (args.length == 2
                && args[0].equalsIgnoreCase("give")
                && sender.hasPermission(GIVE_PERMISSION)) {
            String prefix = args[1].toLowerCase(Locale.ROOT).replace('_', '-');
            return HEAD_KEYS.stream()
                    .filter(head -> head.startsWith(prefix))
                    .toList();
        }

        return List.of();
    }

    private static List<String> availableSubcommands(CommandSender sender) {
        var commands = new java.util.ArrayList<String>(2);
        if (sender.hasPermission(GIVE_PERMISSION)) {
            commands.add("give");
        }
        if (sender.hasPermission(RELOAD_PERMISSION)) {
            commands.add("reload");
        }
        return commands;
    }
}
