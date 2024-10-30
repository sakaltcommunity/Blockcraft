package com.example.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class VaraniumOreBlock extends Block {

    @ObjectHolder("modid:varanium_ore")
    public static final Block VARANIUM_ORE = null;

    public VaraniumOreBlock() {
        super(AbstractBlock.Properties.of(Material.STONE)
            .strength(3.0f, 3.0f)
            .sound(SoundType.STONE));
    }

    public static void registerBlock(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            new VaraniumOreBlock().setRegistryName(new ResourceLocation("modid", "varanium_ore"))
        );
    }

    public static void registerBlockItem(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new BlockItem(VARANIUM_ORE, new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS))
                .setRegistryName(new ResourceLocation("modid", "varanium_ore"))
        );
    }
}
