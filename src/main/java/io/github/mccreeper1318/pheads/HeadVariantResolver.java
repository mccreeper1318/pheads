package io.github.mccreeper1318.pheads;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bukkit.Keyed;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Goat;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Llama;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.ZombieVillager;

final class HeadVariantResolver {

    private static final Map<HeadType, Map<String, HeadVariantAppearance>> APPEARANCES = createAppearances();

    private HeadVariantResolver() {}

    static HeadVariantAppearance resolve(Entity entity, HeadType headType) {
        String variantKey = variantKey(entity, headType);
        return variantKey == null ? null : appearanceFor(headType, variantKey);
    }

    static HeadVariantAppearance appearanceFor(HeadType headType, String variantKey) {
        Map<String, HeadVariantAppearance> variants = APPEARANCES.get(headType);
        return variants == null ? null : variants.get(variantKey);
    }

    static Collection<HeadVariantAppearance> allAppearances() {
        return APPEARANCES.values().stream()
                .flatMap(variants -> variants.values().stream())
                .toList();
    }

    static String variantKey(Entity entity, HeadType headType) {
        if (entity == null) {
            return null;
        }

        return switch (headType) {
            case SHEEP -> entity instanceof Sheep sheep ? enumKey(sheep.getColor()) : null;
            case CAT -> entity instanceof Cat cat ? keyedKey(cat.getCatType()) : null;
            case WOLF -> entity instanceof Wolf wolf ? keyedKey(wolf.getVariant()) : null;
            case FROG -> entity instanceof Frog frog ? keyedKey(frog.getVariant()) : null;
            case AXOLOTL -> entity instanceof Axolotl axolotl ? enumKey(axolotl.getVariant()) : null;
            case RABBIT -> entity instanceof Rabbit rabbit ? enumKey(rabbit.getRabbitType()) : null;
            case HORSE -> entity instanceof Horse horse ? enumKey(horse.getColor()) : null;
            case LLAMA, TRADER_LLAMA -> entity instanceof Llama llama ? enumKey(llama.getColor()) : null;
            case PARROT -> entity instanceof Parrot parrot ? enumKey(parrot.getVariant()) : null;
            case PANDA -> entity instanceof Panda panda
                    ? pandaVariantKey(panda.getMainGene(), panda.getHiddenGene())
                    : null;
            case FOX -> entity instanceof Fox fox ? enumKey(fox.getFoxType()) : null;
            case MOOSHROOM -> entity instanceof MushroomCow mushroomCow
                    ? enumKey(mushroomCow.getVariant())
                    : null;
            case VILLAGER -> entity instanceof Villager villager ? keyedKey(villager.getProfession()) : null;
            case ZOMBIE_VILLAGER -> entity instanceof ZombieVillager zombieVillager
                    ? keyedKeyOrNone(zombieVillager.getVillagerProfession())
                    : null;
            case GOAT -> entity instanceof Goat goat ? (goat.isScreaming() ? "screaming" : "normal") : null;
            default -> null;
        };
    }

    static String pandaVariantKey(Panda.Gene mainGene, Panda.Gene hiddenGene) {
        if (mainGene.isRecessive() && mainGene != hiddenGene) {
            return "normal";
        }
        return enumKey(mainGene);
    }

    private static String enumKey(Enum<?> value) {
        return value.name().toLowerCase(Locale.ROOT).replace('_', '-');
    }

    @SuppressWarnings("deprecation")
    private static String keyedKey(Keyed value) {
        return value.getKey().getKey();
    }

    private static String keyedKeyOrNone(Keyed value) {
        return value == null ? "none" : keyedKey(value);
    }

    private static Map<HeadType, Map<String, HeadVariantAppearance>> createAppearances() {
        Map<HeadType, Map<String, HeadVariantAppearance>> all = new EnumMap<>(HeadType.class);
        put(all, HeadType.SHEEP, "black", "Black Sheep Head", "13335e8065c7b5dfea58d3df7474f396af4fa0a2ba52a3c9b7fba68319271c91", "data/more_mob_heads/loot_table/entities/sheep/black.json", "80a62c5aeb1c3bc03d7920813ece95fa011c6357");
        put(all, HeadType.SHEEP, "blue", "Blue Sheep Head", "740e277da6c398b749a32f9d080f1cf4c4ef3f1f20dd9e5f422509e7ff593c0", "data/more_mob_heads/loot_table/entities/sheep/blue.json", "176b76c21f22717e2c2c7c2b5554bfe6b3226209");
        put(all, HeadType.SHEEP, "brown", "Brown Sheep Head", "3128d086bc81669fc2255bb22cadc66a0f5ed70885e84c32d37c1b484db35901", "data/more_mob_heads/loot_table/entities/sheep/brown.json", "0e736a7e79b6459a79e2cbf4f3ee60c21131c4f2");
        put(all, HeadType.SHEEP, "cyan", "Cyan Sheep Head", "5d42fcbcaf9d48f73ffb0c3c36f34b4643295f6daa6cc74ab9d242ed5aa5636", "data/more_mob_heads/loot_table/entities/sheep/cyan.json", "4fb88739bf4f6724d93b64245cda70acee1a279b");
        put(all, HeadType.SHEEP, "gray", "Gray Sheep Head", "3fafecf0603b2dcd7984d252586069895db9aa78e1841bd554b19508dcf967a1", "data/more_mob_heads/loot_table/entities/sheep/gray.json", "5a3e757192447b802d1eec5e3bcac276431b5712");
        put(all, HeadType.SHEEP, "green", "Green Sheep Head", "9ea887eae4b07636e9e2f906609b00ab8d9b86b74728b819ff6f376583ea139", "data/more_mob_heads/loot_table/entities/sheep/green.json", "29d2e154be932d5b30c877128f64b0b9da566cc8");
        put(all, HeadType.SHEEP, "light-blue", "Light Blue Sheep Head", "ebf23af8719c437b3ee84019ba3c9e69ca854d3a8afd5cba6d9696c053b48614", "data/more_mob_heads/loot_table/entities/sheep/light_blue.json", "aff70b87635eeb7b20c9bf0ff83e27c52d1585f8");
        put(all, HeadType.SHEEP, "light-gray", "Light Gray Sheep Head", "1d2e2e93a142bfd43f240d37de8f9b0976e76e65b22651908259e46db770e", "data/more_mob_heads/loot_table/entities/sheep/light_gray.json", "e7da5847066284c8f7ad2f112cc1195c14676ede");
        put(all, HeadType.SHEEP, "lime", "Lime Sheep Head", "6bead0342ae89b8dfd3d711a60add65e2c2bfea8d0bd274a7587deed7a31892e", "data/more_mob_heads/loot_table/entities/sheep/lime.json", "77decfbcdf55c90b68fe0a9563a5113973b42090");
        put(all, HeadType.SHEEP, "magenta", "Magenta Sheep Head", "a8e1f05f0dacca63a731874f90a693ffe21ff832e2b1e1d07b65c8764526f089", "data/more_mob_heads/loot_table/entities/sheep/magenta.json", "6d5951fab9c8511f06da2fae6699290776be5b08");
        put(all, HeadType.SHEEP, "orange", "Orange Sheep Head", "f684d04fa80aa59da14535dead3883d097fbba400625659f5259964806ba66f0", "data/more_mob_heads/loot_table/entities/sheep/orange.json", "e3d57c19126622d5860d95ec799fa2e641fc762a");
        put(all, HeadType.SHEEP, "pink", "Pink Sheep Head", "6363e8a93d287a84e640309ae83ca1de0a0b257505a20ec55b3349d40a44854", "data/more_mob_heads/loot_table/entities/sheep/pink.json", "cc12cafe1345f0fd81f3e278f5b8d2a1b07b1ab0");
        put(all, HeadType.SHEEP, "purple", "Purple Sheep Head", "3449d08291dae45a24673619602f435b57f4cd4e9e98d2e0fbec4f18144781d3", "data/more_mob_heads/loot_table/entities/sheep/purple.json", "3f7c9c53e6c824e238351ff9a16f197b72da6942");
        put(all, HeadType.SHEEP, "red", "Red Sheep Head", "5478e057158de6f45e2541cd17788e640ccb59723de59c254e82ab5711f3fc27", "data/more_mob_heads/loot_table/entities/sheep/red.json", "a6ff7597b64319d8a5526fa3f8834969129b7c6e");
        put(all, HeadType.SHEEP, "white", "White Sheep Head", "6dfe7cc46d749b153261c1dc11abbf2a3108ea1ba0b2650280eed1592dcfc75b", "data/more_mob_heads/loot_table/entities/sheep/white.json", "89e50cc3911c85affc37a20a5d549e3f3bc2cb30");
        put(all, HeadType.SHEEP, "yellow", "Yellow Sheep Head", "94b28f035735906f82ffc4dba99c9f0b55240e426cd1c525a9aa77180eec4934", "data/more_mob_heads/loot_table/entities/sheep/yellow.json", "9ab2355aefa280377d5e309d77b5e7ef0f1e52a1");
        put(all, HeadType.CAT, "tabby", "Tabby Cat Head", "de28d30db3f8c3fe50ca4f26f3075e36f003ae8028135a8cd692f24c9a98ae1b", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "black", "Tuxedo Cat Head", "4fd10c8e75f67398c47587d25fc146f311c053cc5d0aeab8790bce36ee88f5f8", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "red", "Ginger Cat Head", "2113dbd3c6a078a17b4edb78ce07d836c38dace5027d4b0a83fd60e7ca7a0fcb", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "siamese", "Siamese Cat Head", "d5b3f8ca4b3a555ccb3d194449808b4c9d783327197800d4d65974cc685af2ea", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "british_shorthair", "British Shorthair Cat Head", "5389e0d5d3e81f84b570e2978244b3a73e5a22bcdb6874b44ef5d0f66ca24eec", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "calico", "Calico Cat Head", "340097271bb680fe981e859e8ba93fea28b813b1042bd277ea3329bec493eef3", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "persian", "Persian Cat Head", "ff40c746260ef91c96b27159795e87191ae7ce3d5f767bf8c74faad9689af25d", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "ragdoll", "Ragdoll Cat Head", "dc7a45d25889e3fdf7797cb258e26d4e94f5bc13eef00795dafef2e83e0ab511", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "white", "White Cat Head", "21d15ac9558e98b89aca89d3819503f1c5256c2197dd3c34df5aac4d72e7fbed", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "jellie", "Jellie Cat Head", "a0db41376ca57df10fcb1539e86654eecfd36d3fe75e8176885e93185df280a5", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.CAT, "all_black", "Black Cat Head", "22c1e81ff03e82a3e71e0cd5fbec607e11361089aa47f290d46c8a2c07460d92", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2");
        put(all, HeadType.WOLF, "ashen", "Ashen Wolf Head", "72384c5cf18948b83a89548dba5a9945edeefc5e9654c5d6d38ae10a5d502e75", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "black", "Black Wolf Head", "c5a66a42b25f822a7e16a2187528d1a2e294a01d9f850671b94c95742bb4916e", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "chestnut", "Chestnut Wolf Head", "cb9b0d48442204ff6fd39fa074167118e9c066cde3888977d0f6036e1d8a69ee", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "pale", "Pale Wolf Head", "1ee33c2dc07d76b4f03e66427a08cba2e8179d075ae64b9ce150aa4209c5af39", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "rusty", "Rusty Wolf Head", "23455f6048a68098cd27634e3146c81c8269aeefcf0aff91cc976efa0baa1146", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "snowy", "Snowy Wolf Head", "4ecadab50aa8d41fa9b369a2f84f97456be7900b220ece3b95e8a00968660d5", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "spotted", "Spotty Wolf Head", "573b9a6431af26bcb31826eb6fd9f4b35b947ba5882c6e4aa93588633f7b8d9d", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "striped", "Striped Wolf Head", "7fc52fb3cdfc6aeb00e67c1b7a59d8d320df44656c7af6824b13ca60792aa7d7", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.WOLF, "woods", "Woods Wolf Head", "8d12ab17647b69c9421769572ac674de199124c284b9ed1f65a285c38cd2a504", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183");
        put(all, HeadType.FROG, "cold", "Cold Frog Head", "76877893e920ff5dfa4b5fbd14dabee2e6308a6f97c3a19b08e241a29eb9a5c3", "data/more_mob_heads/loot_table/entities/frog.json", "9b073aa1371564190d2fcad06877875a47f516a6");
        put(all, HeadType.FROG, "temperate", "Temperate Frog Head", "a50d1073d41f193405d95b1d941f9fe1a7ff080e38155d7bb780bbbd8e86f70d", "data/more_mob_heads/loot_table/entities/frog.json", "9b073aa1371564190d2fcad06877875a47f516a6");
        put(all, HeadType.FROG, "warm", "Warm Frog Head", "d5b0da43975b83c3322788dda317506333843aebe5512787cb2e3d769ed2b382", "data/more_mob_heads/loot_table/entities/frog.json", "9b073aa1371564190d2fcad06877875a47f516a6");
        put(all, HeadType.AXOLOTL, "lucy", "Lucy Axolotl Head", "667e15eab73064b6680d1db98ba445ed0914ba35a799997c0da2b03ffc3a8826", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53");
        put(all, HeadType.AXOLOTL, "wild", "Wild Axolotl Head", "47cf0274998bf5a7f38b37036e154f112fa2e28bad40d5a7c94765fe4f52211e", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53");
        put(all, HeadType.AXOLOTL, "gold", "Gold Axolotl Head", "e58560115faad11619b3d55de79ef2a053f478a67194bbe9247edea0bc98e834", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53");
        put(all, HeadType.AXOLOTL, "cyan", "Cyan Axolotl Head", "851196d43930659d717e1b6a046a08d1220fcb4e31c4856bc33e7551986ef1d", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53");
        put(all, HeadType.AXOLOTL, "blue", "Blue Axolotl Head", "68fd10b0fef4595960b1f64193bc8a1865a2d2ed48b2e2ce03d994563027df95", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53");
        put(all, HeadType.RABBIT, "brown", "Brown Rabbit Head", "cfd4f86cf7473fbae93b1e090489b64c0be126c7bb16ffc88c002447d5c72795", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "white", "White Rabbit Head", "9542d7160987148a5d8e20e469bd9b3c2a3946c7fb5923f55b9beae99185f", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "black", "Black Rabbit Head", "b2b425ff2a236ab19cc9397195db40f8f185b191c40bf44b26e95eac9fb5efa3", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "black-and-white", "Black and White Rabbit Head", "35f72a2195ebf4117c5056cfe2b7357ec5bf832ede1856a7773ee42a0d0fb3f0", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "gold", "Gold Rabbit Head", "767b722656fdeec39974d3395c5e18b47c5e237bce5bbced9b7553aa14b54587", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "salt-and-pepper", "Salt and Pepper Rabbit Head", "9238519ff39815b16c4062823e43161ffaac96894fe088b018e6a24c26e181ec", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.RABBIT, "the-killer-bunny", "The Killer Bunny Head", "71dd767929ef2fd2d43e86e8744c4b0d810853471201f2dfa18f96a67de56e2f", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3");
        put(all, HeadType.HORSE, "white", "White Horse Head", "c7bc61609730f2cb010268fab0821bd47352699750a150599f21c3fc4e92591a", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "creamy", "Creamy Horse Head", "42a0d54cc071267d6bfd5f523f8c89dcfdc5e805fabbb76010cb3befa465aa94", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "chestnut", "Chestnut Horse Head", "6c8720d1f552693b40a9a33afa41cef06afd142833bed9fa5b887e88f05f49fa", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "brown", "Brown Horse Head", "6771800770cb4e814a3d91186fcd795ec82e06102ff7c1ee4e5c380102a0c70f", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "black", "Black Horse Head", "6723fa5be6ac2292a72230f5fd7ab663493bd8f7e64816424dc5bf24f133890c", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "gray", "Gray Horse Head", "c25986102181083fb317bc5712f7104daa5a3e889264dfebb9159f6e08bac90c", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.HORSE, "dark-brown", "Dark Brown Horse Head", "7f2341aaa0c82c22bbc207063e319291097c539adad9aa913eb8001b11aa59da", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893");
        put(all, HeadType.LLAMA, "creamy", "Creamy Llama Head", "4d67fd4bff293269cb908974dca83c33485e435ed5a8e1dbd6521c61687140", "data/more_mob_heads/loot_table/entities/llama.json", "18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e");
        put(all, HeadType.LLAMA, "white", "White Llama Head", "80277e6b3d9f7819efc7da4b42745f7ab9a63ba8f36d6b84a7a250c6d1a358eb", "data/more_mob_heads/loot_table/entities/llama.json", "18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e");
        put(all, HeadType.LLAMA, "brown", "Brown Llama Head", "c2b1ecff77ffe3b503c30a548eb23a1a08fa26fd67cdff389855d74921368", "data/more_mob_heads/loot_table/entities/llama.json", "18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e");
        put(all, HeadType.LLAMA, "gray", "Gray Llama Head", "cf24e56fd9ffd7133da6d1f3e2f455952b1da462686f753c597ee82299a", "data/more_mob_heads/loot_table/entities/llama.json", "18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e");
        put(all, HeadType.TRADER_LLAMA, "creamy", "Creamy Trader Llama Head", "e89a2eb17705fe7154ab041e5c76a08d41546a31ba20ea3060e3ec8edc10412c", "data/more_mob_heads/loot_table/entities/trader_llama.json", "50df37f55ceaadeb9581546b0173af99e79fe056");
        put(all, HeadType.TRADER_LLAMA, "white", "White Trader Llama Head", "7087a556d4ffa95ecd2844f350dc43e254e5d535fa596f540d7e77fa67df4696", "data/more_mob_heads/loot_table/entities/trader_llama.json", "50df37f55ceaadeb9581546b0173af99e79fe056");
        put(all, HeadType.TRADER_LLAMA, "brown", "Brown Trader Llama Head", "8424780b3c5c5351cf49fb5bf41fcb289491df6c430683c84d7846188db4f84d", "data/more_mob_heads/loot_table/entities/trader_llama.json", "50df37f55ceaadeb9581546b0173af99e79fe056");
        put(all, HeadType.TRADER_LLAMA, "gray", "Gray Trader Llama Head", "be4d8a0bc15f239921efd8be3480ba77a98ee7d9ce00728c0d733f0a2d614d16", "data/more_mob_heads/loot_table/entities/trader_llama.json", "50df37f55ceaadeb9581546b0173af99e79fe056");
        put(all, HeadType.PARROT, "red", "Red Parrot Head", "40a3d47f54e71a58bf8f57c5253fb2d213f4f55bb7934a19104bfb94edc76eaa", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20");
        put(all, HeadType.PARROT, "blue", "Blue Parrot Head", "b94bd3fcf4d46354ede8fef73126dbcab52b301a1c8c23b6cdfc12d612b61bea", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20");
        put(all, HeadType.PARROT, "green", "Green Parrot Head", "6a1dc33115232f800825cac9e3d9ed03fc18ae553c25b8059513000c59e354fe", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20");
        put(all, HeadType.PARROT, "cyan", "Light Blue Parrot Head", "7268ce37be8507ed67e3d40b617e2d72f66f9d20b106efb08e6ba041f9b9ef10", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20");
        put(all, HeadType.PARROT, "gray", "Gray Parrot Head", "71be723aa17393d99daddc119c98b2c79c54b35debe05c7138edeb8d0256dc46", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20");
        put(all, HeadType.PANDA, "normal", "Panda Head", "59df47e015d5c1c68d72be11bb656380fc6db533aab38941a91b1d3d5e396497", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "lazy", "Lazy Panda Head", "587f1f5db2e24df4daaed4685d6aee5deb7cdd029630f0079c1f8e1f9741acfd", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "worried", "Worried Panda Head", "fb86fd1bf8cbce23bc08fb90691717611addc85ab823b7714aec98a5660eff15", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "playful", "Playful Panda Head", "8cadd4bf3c4cace916680e1fef90b5d16ad6643951725668ba6b4996b69ca140", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "brown", "Brown Panda Head", "1d5f6d6126728671b44c1c775f99617424e33611b5d31ad2acff2804eb96eb06", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "weak", "Weak Panda Head", "cc56a355fbe0e2fbd28e85c4d815ffa5d1f9d5f8798dbc259ff88c4addb202ae", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.PANDA, "aggressive", "Aggressive Panda Head", "e546e436d166b17f0521bd8538ea13cd6ee3b5df102eb32e3e425cb285d44063", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875");
        put(all, HeadType.FOX, "red", "Fox Head", "d7e0043111bc57090856259155571c7906e707046df041b8b572704c451fcd82", "data/more_mob_heads/loot_table/entities/fox.json", "0773baf51242e5c42d0f9cc99842f537bd3b0a19");
        put(all, HeadType.FOX, "snow", "Snow Fox Head", "41436377eb4c4b4e39fb0e1ed8899fb61ee1814a9169b8d08729ef01dc85d1ba", "data/more_mob_heads/loot_table/entities/fox.json", "0773baf51242e5c42d0f9cc99842f537bd3b0a19");
        put(all, HeadType.MOOSHROOM, "red", "Red Mooshroom Head", "da80606e82c642f141587733e3180ae57f646442c9fffd4e5997457e34311a29", "data/more_mob_heads/loot_table/entities/mooshroom.json", "8dd974618d80d9fc8f68d4c7249ee23f167592a6");
        put(all, HeadType.MOOSHROOM, "brown", "Brown Mooshroom Head", "7e6466302a5ab4398b4e477349808e5d9402ea3ad8fc42e2446e4bed0a5ed5e", "data/more_mob_heads/loot_table/entities/mooshroom.json", "8dd974618d80d9fc8f68d4c7249ee23f167592a6");
        put(all, HeadType.VILLAGER, "armorer", "Armorer Villager Head", "1ef627f566ac0a7828bad93e9e4b9643d99a928a13d5f977bf441e40db1336bf", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "butcher", "Butcher Villager Head", "a1bad64185e04bf1dafe3da84933d02545ea4a63221a10d0f07759179112bdc2", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "cartographer", "Cartographer Villager Head", "e3aecfbe801cf32b5d1b0b1f6680049666158678c53f4a651fc83e0df9d3738b", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "cleric", "Cleric Villager Head", "5b9e582e2f9b89d556e79c4697f706b1dd4929ecae3c07ee90bf1d5be319bf6f", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "farmer", "Farmer Villager Head", "d9272d03cda6290e4d925a7e850a745e711fe5760f6f06f93d92b8f8c739db07", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "fisherman", "Fisherman Villager Head", "d189fb4acd15d73ff2a58a88df0466ad9f4c154a2008e5c6265d5c2f07d39376", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "fletcher", "Fletcher Villager Head", "bf611f12e18ce44a57238eef1cae03cd9f730a7a45e0ec248f14ce84e9c48056", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "leatherworker", "Leatherworker Villager Head", "ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "librarian", "Librarian Villager Head", "cdcaa574babb40ee0fa83f2fd5ea20cff31ffa272fe113588ceee469682128e7", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "mason", "Mason Villager Head", "ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "nitwit", "Nitwit Villager Head", "ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "none", "Villager Head", "ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "shepherd", "Shepherd Villager Head", "2abf4e9154ac9271941c733eacc62dc9fc0a6dc1b5d67c78ca98afb5cb1be9b2", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "toolsmith", "Toolsmith Villager Head", "ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.VILLAGER, "weaponsmith", "Weaponsmith Villager Head", "8476ffa410bbe7fa70909965a125f4a4e9a4fb1ce1b8b3c34bfb73aaffd4ce43", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37");
        put(all, HeadType.ZOMBIE_VILLAGER, "armorer", "Zombie Armorer Head", "c8679e034767d518660d9416dc5eaf319d697682ac40c886e3c2bc8dfa1de1d", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "butcher", "Zombie Butcher Head", "9cce8d6ce4124cec3e84a852e70f50293f244ddc9ee8578f7d6d8929e16bad69", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "cartographer", "Zombie Cartographer Head", "e60800b01012e963e7c20c8ba14b70a0264d146a850deffbca7bfe512f4cb23d", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "cleric", "Zombie Cleric Head", "2958578be0e12172734a78242dab14964abc85ab9b596361f7c5daf8f14a0feb", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "farmer", "Zombie Farmer Head", "f77d415f9baa4fa4b5e058f5b81bf7f003b0a2c90a4831e53a7dbc09841c5511", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "fisherman", "Zombie Fisherman Head", "6905d53fe4faeb0b315a6878c9ab81b4be52c31cd478c027f0d7ece9f6da8914", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "fletcher", "Zombie Fletcher Head", "2ea26ac0e25498adada4ecea58bb4e76da32d5ca2de307efe5e4218fb7c5ef89", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "leatherworker", "Zombie Leatherworker Head", "fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "librarian", "Zombie Librarian Head", "62211a1f409cca4249c70d20ca80399fa4844ea417458be988cc21eb4797375e", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "mason", "Zombie Mason Head", "fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "nitwit", "Zombie Nitwit Head", "fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "none", "Zombie Villager Head", "fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "shepherd", "Zombie Shepherd Head", "691391bef3a46ef267d3b7171086ba4c8d17f2a6b0f83fa2ac30efe914b7c249", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "toolsmith", "Zombie Toolsmith Head", "fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.ZOMBIE_VILLAGER, "weaponsmith", "Zombie Weaponsmith Head", "4370894b5cc305d87aa08c3b4b08587db68ff29e7a3ef354cad6abca50e5528b", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c");
        put(all, HeadType.GOAT, "normal", "Goat Head", "87473e055df6e7fd98664e9fdb63675f088106305d744024a41bb358918a142b", "data/more_mob_heads/loot_table/entities/goat.json", "66717150ffb1b96e35aa086f3d249344b7a4f3a1");
        put(all, HeadType.GOAT, "screaming", "Screaming Goat Head", "bda485ac23512420891a5ae1e8de989f091d848d15a9068da4720d316fc4330f", "data/more_mob_heads/loot_table/entities/goat.json", "66717150ffb1b96e35aa086f3d249344b7a4f3a1");

        Map<HeadType, Map<String, HeadVariantAppearance>> frozen = new EnumMap<>(HeadType.class);
        for (Map.Entry<HeadType, Map<String, HeadVariantAppearance>> entry : all.entrySet()) {
            frozen.put(entry.getKey(), Map.copyOf(entry.getValue()));
        }
        return Map.copyOf(frozen);
    }

    private static void put(
            Map<HeadType, Map<String, HeadVariantAppearance>> all,
            HeadType headType,
            String key,
            String displayName,
            String textureHash,
            String sourcePath,
            String sourceBlobSha) {
        all.computeIfAbsent(headType, ignored -> new HashMap<>())
                .put(key, new HeadVariantAppearance(key, displayName, textureHash, sourcePath, sourceBlobSha));
    }
}
