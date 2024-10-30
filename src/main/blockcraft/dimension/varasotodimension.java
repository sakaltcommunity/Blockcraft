package dimension;

import blocks.VaraniumOreBlock;
import entities.RedEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.BiomeRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class VarasotoDimension {
    public static final Biome VARASOTO_BIOME = createVarasotoBiome();
    public static EntityType<RedEntity> RED;

    private static Biome createVarasotoBiome() {
        BiomeAmbience effects = new BiomeAmbience.Builder()
            .setFogColor(0xAA0000)
            .setWaterColor(0xAA0000)
            .setWaterFogColor(0x550000)
            .setSkyColor(0xFF0000)
            .build();

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder()
            .withSurfaceBuilder(ConfiguredSurfaceBuilders.NOPE);

        generationSettings.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, DefaultBiomeFeatures.DESERT_WELL);
        addVaraniumOre(generationSettings); // ヴァラニウム鉱石を追加

        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(RED, 100, 2, 4));

        DefaultBiomeFeatures.withCavesAndCanyons(generationSettings);
        DefaultBiomeFeatures.withOverworldOres(generationSettings);

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
        RED = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("blockcraft:red"), EntityType.Builder.of(RedEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).build("red"));
        BiomeRegistry.registerBiome(new ResourceLocation("blockcraft:varasoto_biome"), VARASOTO_BIOME);
    }

    private static void addVaraniumOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, VaraniumOreBlock.VARANIUM_ORE.defaultBlockState(), 8)).range(20).square().func_227226_c_());
    }
}
