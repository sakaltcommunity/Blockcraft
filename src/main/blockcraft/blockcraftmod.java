package blockcraft;

import blockcraft.dimension.varasotodimension;
import blockcraft.entities.redentity;
import blockcraft.items.varaniumgreatsword;
import blockcraft.blocks.varaniumoreblock;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod("blockcraft")
public class blockcraftmod {
    public blockcraftmod() {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        varasotodimension.register();
        redentity.register(event);
        varaniumoreblock.registerBlock(event);
        varaniumgreatsword.registerItem(event);
    }

    @SubscribeEvent
    public void onCreativeTabRegister(CreativeModeTabEvent.BuildContents event) {
        // アイテムをクリエイティブタブに追加する場合の処理
    }
}
