package blockcraft;

import dimension.VarasotoDimension;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.ModLifecycleEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@Mod("blockcraft")
public class BlockcraftMod {
    public BlockcraftMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        VarasotoDimension.register();
    }

    @SubscribeEvent
    public void onCreativeTabRegister(CreativeModeTabEvent.BuildContents event) {
        // アイテムをクリエイティブタブに追加する場合の処理
    }
}
