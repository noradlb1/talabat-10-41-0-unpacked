package com.talabat.gem.adapters.data;

import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CacheKt$cachedSelectedRestaurantId$1 extends Lambda implements Function0<Integer> {
    public static final CacheKt$cachedSelectedRestaurantId$1 INSTANCE = new CacheKt$cachedSelectedRestaurantId$1();

    public CacheKt$cachedSelectedRestaurantId$1() {
        super(0);
    }

    @Nullable
    public final Integer invoke() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant != null) {
            return Integer.valueOf(restaurant.f13872id);
        }
        return null;
    }
}
