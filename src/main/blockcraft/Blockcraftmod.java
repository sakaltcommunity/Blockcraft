package blockcraft;

import blockcraft.dimension.VarasotoDimension;
import blockcraft.entities.RedEntity;
import blockcraft.items.VaraniumGreatsword;
import blockcraft.blocks.VaraniumOreBlock;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod("blockcraft")
public class BlockcraftMod {
    public BlockcraftMod() {
        // イベントバスに自分自身を登録
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        // 共通セットアップ処理
        VarasotoDimension.register();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        // アイテムの登録
        VaraniumGreatsword.registerItem(event);
        VaraniumOreBlock.registerBlock(event);
    }

    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        // エンティティの登録
        RedEntity.register(event);
    }

    @SubscribeEvent
    public void onCreativeTabRegister(CreativeModeTabEvent.BuildContents event) {
        // アイテムをクリエイティブタブに追加する場合の処理
    }
}
