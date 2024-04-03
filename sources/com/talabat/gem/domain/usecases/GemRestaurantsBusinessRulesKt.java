package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.presentation.GemRestaurantsViewPort;
import com.talabat.gem.ports.presentation.GemViewPort;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"bindRestaurants", "", "Lcom/talabat/gem/ports/presentation/GemRestaurantsViewPort;", "onRestaurantSelected", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "restaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "isGemCollectionRestaurant", "", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemRestaurantsBusinessRulesKt {
    @BusinessRules
    public static final void bindRestaurants(@NotNull GemRestaurantsViewPort gemRestaurantsViewPort) {
        Intrinsics.checkNotNullParameter(gemRestaurantsViewPort, "<this>");
        gemRestaurantsViewPort.autoDispose(new GemRestaurantsBusinessRulesKt$bindRestaurants$1(gemRestaurantsViewPort));
    }

    @BusinessRules
    public static final void onRestaurantSelected(@NotNull GemViewPort gemViewPort, @NotNull GemRestaurant gemRestaurant, boolean z11) {
        Intrinsics.checkNotNullParameter(gemViewPort, "<this>");
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        IntegrationKt.getDataSources().updateSelectedGemRestaurant(gemRestaurant, z11);
    }

    public static /* synthetic */ void onRestaurantSelected$default(GemViewPort gemViewPort, GemRestaurant gemRestaurant, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        onRestaurantSelected(gemViewPort, gemRestaurant, z11);
    }
}
