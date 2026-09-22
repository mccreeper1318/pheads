package io.github.mccreeper1318.pheads;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerTextures;

final class HeadItemFactory {

    private HeadItemFactory() {}

    static ItemStack create(HeadType headType) {
        if (!headType.customTextured()) {
            return new ItemStack(headType.material());
        }

        return createCustom(
                headType,
                profileIdFor(headType),
                headType.textureUrl(),
                headType.displayName());
    }

    static ItemStack create(HeadType headType, Entity sourceEntity) {
        if (!headType.customTextured()) {
            return new ItemStack(headType.material());
        }

        HeadVariantAppearance appearance = HeadVariantResolver.resolve(sourceEntity, headType);
        if (appearance == null) {
            return create(headType);
        }

        return createCustom(
                headType,
                profileIdFor(headType, appearance.key()),
                appearance.textureUrl(),
                appearance.displayName());
    }

    static UUID profileIdFor(HeadType headType) {
        return UUID.nameUUIDFromBytes(("pheads:" + headType.configKey()).getBytes(StandardCharsets.UTF_8));
    }

    static UUID profileIdFor(HeadType headType, String variantKey) {
        return UUID.nameUUIDFromBytes(
                ("pheads:" + headType.configKey() + ":" + variantKey).getBytes(StandardCharsets.UTF_8));
    }

    private static ItemStack createCustom(
            HeadType headType,
            UUID profileId,
            String textureUrl,
            String displayName) {
        ItemStack item = new ItemStack(headType.material());
        item.editMeta(
                SkullMeta.class,
                skullMeta -> applyCustomHeadMeta(skullMeta, headType, profileId, textureUrl, displayName));
        return item;
    }

    private static void applyCustomHeadMeta(
            SkullMeta skullMeta,
            HeadType headType,
            UUID profileId,
            String textureUrl,
            String displayName) {
        var profile = Bukkit.createProfile(profileId);
        PlayerTextures textures = profile.getTextures();
        try {
            textures.setSkin(URI.create(textureUrl).toURL());
        } catch (MalformedURLException exception) {
            throw new IllegalStateException("Invalid bundled texture URL for " + headType.configKey(), exception);
        }
        profile.setTextures(textures);

        skullMeta.setPlayerProfile(profile);
        skullMeta.displayName(Component.text(displayName).decoration(TextDecoration.ITALIC, false));
    }
}
