package blockcraft.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class redentity extends ZombieEntity {

    public redentity(EntityType<? extends ZombieEntity> type, World world) {
        super(type, world);
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, net.minecraft.entity.player.PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return ZombieEntity.createAttributes().add(Attributes.MAX_HEALTH, 45.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
    }
}