package com.ordana.spelunkery.reg;

import com.ordana.spelunkery.Spelunkery;
import com.ordana.spelunkery.blocks.entity.CarvedNephriteBlockEntity;
import com.ordana.spelunkery.blocks.entity.NephriteSpoutEntity;
import com.ordana.spelunkery.entities.GlowstickEntity;
import net.mehvahdjukaar.moonlight.api.platform.PlatformHelper;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModEntities {
    public static <T extends Entity> Supplier<EntityType<T>> regEntity(String name, Supplier<EntityType.Builder<T>> builder) {
        return RegHelper.registerEntityType(Spelunkery.res(name), () -> builder.get().build(name));
    }

    public static void init() {
    }

    public static final Supplier<BlockEntityType<CarvedNephriteBlockEntity>> NEPHRITE_TILE = RegHelper.registerBlockEntityType(
            Spelunkery.res("carved_nephrite"),
            () -> PlatformHelper.newBlockEntityType(CarvedNephriteBlockEntity::new, ModBlocks.CARVED_NEPHRITE.get()));

    public static final Supplier<BlockEntityType<NephriteSpoutEntity>> NEPHRITE_SPOUT = RegHelper.registerBlockEntityType(
            Spelunkery.res("nephrite_spout"),
            () -> PlatformHelper.newBlockEntityType(NephriteSpoutEntity::new, ModBlocks.NEPHRITE_SPOUT.get()));

    public static Supplier<EntityType<GlowstickEntity>> GLOWSTICK = RegHelper.registerEntityType(
            Spelunkery.res("glowstick"),
            GlowstickEntity::new, MobCategory.MISC, 0.28F, 0.98F, 10, 20);

}
