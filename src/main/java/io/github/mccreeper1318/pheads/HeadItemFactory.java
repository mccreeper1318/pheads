package io.github.mccreeper1318.pheads;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;

final class HeadItemFactory {

    private HeadItemFactory() {}

    static ItemStack create(HeadType headType) {
        if (!headType.customTextured()) {
            return new ItemStack(headType.material());
        }

        ItemStack item = new ItemStack(headType.material());
        item.editMeta(SkullMeta.class, skullMeta -> applyCustomHeadMeta(skullMeta, headType));
        return item;
    }

    static UUID profileIdFor(HeadType headType) {
        return UUID.nameUUIDFromBytes(("pheads:" + headType.configKey()).getBytes(StandardCharsets.UTF_8));
    }

    private static void applyCustomHeadMeta(SkullMeta skullMeta, HeadType headType) {
        var profile = Bukkit.createProfile(profileIdFor(headType));
        PlayerTextures textures = profile.getTextures();
        try {
            textures.setSkin(URI.create(headType.textureUrl()).toURL());
        } catch (MalformedURLException exception) {
            throw new IllegalStateException("Invalid bundled texture URL for " + headType.configKey(), exception);
        }
        profile.setTextures(textures);

        skullMeta.setPlayerProfile(profile);
        skullMeta.displayName(Component.text(headType.displayName()).decoration(TextDecoration.ITALIC, false));
    }
}
