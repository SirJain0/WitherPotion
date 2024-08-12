package com.sirjain.content;

import com.sirjain.MPMain;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class MPUtil {
        public static RegistryEntry<Potion> WITHER_POTION, LONG_WITHER_POTION, STRONG_WITHER_POTION;
        public static RegistryEntry<Potion> HUNGER_POTION, LONG_HUNGER_POTION, STRONG_HUNGER_POTION;
        public static RegistryEntry<Potion> LEVITATING_POTION, LONG_LEVITATING_POTION, STRONG_LEVITATING_POTION;

        public static RegistryEntry<StatusEffect> WITHER = StatusEffects.WITHER;
        public static RegistryEntry<StatusEffect> HUNGER = StatusEffects.HUNGER;
        public static RegistryEntry<StatusEffect> LEVITATION = StatusEffects.LEVITATION;

        // Registers potions
        public static void registerPotions() {
                WITHER_POTION = registerPotion("wither_potion", new Potion(new StatusEffectInstance(WITHER, 20 * 16, 0)));
                LONG_WITHER_POTION = registerPotion("long_wither_potion", new Potion(new StatusEffectInstance(WITHER, 20 * 36, 0)));
                STRONG_WITHER_POTION = registerPotion("strong_wither_potion", new Potion(new StatusEffectInstance(WITHER, 20 * 10, 1)));

                HUNGER_POTION = registerPotion("hunger_potion", new Potion(new StatusEffectInstance(HUNGER, 20 * 30, 0)));
                LONG_HUNGER_POTION = registerPotion("long_hunger_potion", new Potion(new StatusEffectInstance(HUNGER, 20 * 60, 0)));
                STRONG_HUNGER_POTION = registerPotion("strong_hunger_potion", new Potion(new StatusEffectInstance(HUNGER, 20 * 22, 1)));

                LEVITATING_POTION = registerPotion("levitating_potion", new Potion(new StatusEffectInstance(LEVITATION, 20 * 16, 0)));
                LONG_LEVITATING_POTION = registerPotion("long_levitating_potion", new Potion(new StatusEffectInstance(LEVITATION, 20 * 28, 0)));
                STRONG_LEVITATING_POTION = registerPotion("strong_levitating_potion", new Potion(new StatusEffectInstance(LEVITATION, 20 * 10, 1)));
        }

        // Registers potion recipes
        public static void registerRecipes() {
                FabricBrewingRecipeRegistryBuilder.BUILD.register((recipes -> {
                        recipes.registerPotionRecipe(Potions.AWKWARD, MPItems.WITHERED_ASHES, WITHER_POTION);
                        recipes.registerPotionRecipe(WITHER_POTION, Items.REDSTONE, LONG_WITHER_POTION);
                        recipes.registerPotionRecipe(LONG_WITHER_POTION, Items.GLOWSTONE_DUST, STRONG_WITHER_POTION);

                        recipes.registerPotionRecipe(Potions.WATER, Items.ROTTEN_FLESH, HUNGER_POTION);
                        recipes.registerPotionRecipe(HUNGER_POTION, Items.REDSTONE, LONG_HUNGER_POTION);
                        recipes.registerPotionRecipe(LONG_HUNGER_POTION, Items.GLOWSTONE_DUST, STRONG_HUNGER_POTION);
                }));
        }

        // Helper method to shorten process of registering potions
        private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
                return Registry.registerReference(
                        Registries.POTION,
                        Identifier.of(MPMain.MOD_ID, name),
                        potion
                );
        }
}
