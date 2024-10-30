package blockcraft.dimension;

import blockcraft.blocks.varaniumoreblock;
import blockcraft.entities.redentity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class varasotodimension {
    public static final Biome varasoto_biome = createVarasotoBiome();
    public static EntityType<redentity> red;

    private static Biome createVarasotoBiome() {
        BiomeAmbience effects = new BiomeAmbience.Builder()
            .setFogColor(0xAA0000)
            .setWaterColor(0xAA0000)
            .setWaterFogColor(0x550000)
            .setSkyColor(0xFF0000)
            .build();

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        addVaraniumOre(generationSettings);

        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(red, 100, 2, 4));

        return new Biome.Builder()
            .precipitation(Biome.RainType.NONE)
            .category(Biome.Category.PLAINS)
            .downfall(0.0F)
            .depth(0.125F)
            .scale(0.05F)
            .temperature(1.0F)
            .generationSettings(generationSettings.build())
            .mobSpawnSettings(mobSpawnInfo.copy())
            .setEffects(effects)
            .build();
    }

    public static void register() {
        red = EntityType.Builder.of(redentity::new, EntityClassification.MONSTER)
                .sized(0.6F, 1.95F)
                .build("blockcraft:red")
                .setRegistryName(new ResourceLocation("blockcraft", "red"));

        net.minecraftforge.registries.ForgeRegistries.BIOMES.register(new ResourceLocation("blockcraft", "varasoto_biome"), varasoto_biome);
    }

    private static void addVaraniumOre(BiomeGenerationSettings.Builder generationSettings) {
        generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
            Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, varaniumoreblock.varanium_ore.defaultBlockState(), 8)).decorated(net.minecraft.world.gen.feature.Placement.RANGE.configured(new net.minecraft.world.gen.feature.TopRangeConfig(0, 0, 16))).squared().count(20));
    }
}
