package net.fabricmc.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class StrongStatusEffect extends StatusEffect {
    public StrongStatusEffect(){
        super(StatusEffectCategory.BENEFICIAL, 2552540);
    }

    //check if and when effect can be applied
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){

    }

    //what the effect does
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if(entity instanceof PlayerEntity){
            ((PlayerEntity) entity).setGlowing(true);
        }
    }

}
