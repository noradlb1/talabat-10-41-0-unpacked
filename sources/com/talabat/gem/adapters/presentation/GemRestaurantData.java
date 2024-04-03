package com.talabat.gem.adapters.presentation;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0002\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemRestaurantData;", "", "()V", "restaurantId", "", "getRestaurantId$com_talabat_Components_gem_gem", "()Ljava/lang/Integer;", "setRestaurantId$com_talabat_Components_gem_gem", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "id", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemRestaurantData {
    @Nullable
    private Integer restaurantId;

    @Nullable
    public final Integer getRestaurantId$com_talabat_Components_gem_gem() {
        return this.restaurantId;
    }

    @GemViewsDsl
    public final void restaurantId(@Nullable Integer num) {
        this.restaurantId = num;
    }

    public final void setRestaurantId$com_talabat_Components_gem_gem(@Nullable Integer num) {
        this.restaurantId = num;
    }
}
