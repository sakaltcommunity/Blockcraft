package blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;

public class VaraniumOreBlock extends Block {
    public static final Block VARANIUM_ORE = new VaraniumOreBlock();

    public VaraniumOreBlock() {
        super(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
