package com.talabat.components.gem.menu;

import com.talabat.RestaurantMenuScreenR;
import com.talabat.gem.integration.Gem;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/components/gem/menu/GemMenuFooterViewBinder;", "Lio/reactivex/functions/Consumer;", "Lcom/talabat/RestaurantMenuScreenR;", "()V", "accept", "", "activity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemMenuFooterViewBinder implements Consumer<RestaurantMenuScreenR> {
    public void accept(@NotNull RestaurantMenuScreenR restaurantMenuScreenR) {
        Intrinsics.checkNotNullParameter(restaurantMenuScreenR, "activity");
        Gem.withGemComponent(new GemMenuFooterViewBinder$accept$1$1(restaurantMenuScreenR));
    }
}
