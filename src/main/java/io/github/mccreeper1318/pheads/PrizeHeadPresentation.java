package io.github.mccreeper1318.pheads;

import java.util.List;

record PrizeHeadPresentation(String displayName, String mobKey, String tier, List<String> lore) {

    static PrizeHeadPresentation forHead(HeadType headType) {
        String mobName = headType.displayName();
        if (mobName.endsWith(" Head")) {
            mobName = mobName.substring(0, mobName.length() - " Head".length());
        } else if (mobName.endsWith(" Skull")) {
            mobName = mobName.substring(0, mobName.length() - " Skull".length());
        }

        return new PrizeHeadPresentation(
                "✦ " + mobName + " Trophy ✦",
                headType.configKey(),
                "prize",
                List.of("Ultra-rare PHeads Prize Head", "Trophy from " + mobName));
    }
}
