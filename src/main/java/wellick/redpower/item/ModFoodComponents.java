package wellick.redpower.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DIHH = new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200), 1.0f).build();
}
