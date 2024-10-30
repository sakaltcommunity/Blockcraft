package blockcraft.items;

import blockcraft.blocks.varaniumoreblock;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

public class varaniumgreatsword extends SwordItem {
    @ObjectHolder("blockcraft:varanium_greatsword")
    public static final Item varanium_greatsword = null;

    public varaniumgreatsword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    public static void registerItem(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new varaniumgreatsword(varaniumitemtier.INSTANCE, 18, -3.0F, new Item.Properties().tab(ItemGroup.TAB_COMBAT))
                .setRegistryName(new ResourceLocation("blockcraft", "varanium_greatsword"))
        );
    }

    public static class varaniumitemtier implements IItemTier {
        public static final varaniumitemtier INSTANCE = new varaniumitemtier();

        @Override
        public int getUses() {
            return 1561;  // 耐久値
        }

        @Override
        public float getSpeed() {
            return 8.0F;  // 採掘速度
        }

        @Override
        public float getAttackDamageBonus() {
            return 18.5F;  // 攻撃力
        }

        @Override
        public int getLevel() {
            return 3;  // 採掘レベル（ダイヤ相当）
        }

        @Override
        public int getEnchantmentValue() {
            return 22;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(varaniumoreblock.varanium_ore);
        }
    }
}
