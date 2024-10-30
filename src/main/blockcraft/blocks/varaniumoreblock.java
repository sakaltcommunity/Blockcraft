package blockcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class varaniumoreblock extends Block {
    @ObjectHolder("blockcraft:varanium_ore")
    public static final Block varanium_ore = null;

    public varaniumoreblock() {
        super(Properties.of(Material.STONE).strength(3.0F, 3.0F));
    }

    public static void registerBlock(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
            new varaniumoreblock().setRegistryName("blockcraft", "varanium_ore")
        );
    }
}
