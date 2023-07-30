package com.wither_potion.potion;

import com.wither_potion.WitherPotion;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WitherPotions {
        public static Potion WITHER_POTION;

        public static void registerPotions() {
                WITHER_POTION = registerPotion("wither_potion", new Potion(new StatusEffectInstance(StatusEffects.WITHER, 20 * 8, 0)));
        }

        private static Potion registerPotion(String name, Potion potion) {
                return Registry.register(
                        Registries.POTION,
                        new Identifier(WitherPotion.MOD_ID, name),
                        potion
                );
        }
}
