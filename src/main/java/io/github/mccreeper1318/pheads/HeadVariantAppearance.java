package io.github.mccreeper1318.pheads;

record HeadVariantAppearance(
        String key,
        String displayName,
        String textureHash,
        String sourcePath,
        String sourceBlobSha) {

    private static final String TEXTURE_BASE_URL = "http://textures.minecraft.net/texture/";

    String textureUrl() {
        return TEXTURE_BASE_URL + textureHash;
    }
}
