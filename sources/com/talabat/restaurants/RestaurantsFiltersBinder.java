package com.talabat.restaurants;

import com.talabat.R;
import com.talabat.filters.navigation.FiltersViewKt;
import com.talabat.filters.navigation.RestaurantsFiltersView;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/restaurants/RestaurantsFiltersBinder;", "Lio/reactivex/functions/Consumer;", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "()V", "accept", "", "activity", "bind", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantsFiltersBinder implements Consumer<RestaurantsListScreenRefactor> {
    private final void bind(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        RestaurantsFiltersView restaurantsFiltersView = (RestaurantsFiltersView) restaurantsListScreenRefactor.findViewById(R.id.restaurantsFiltersView);
        Intrinsics.checkNotNullExpressionValue(restaurantsFiltersView, "restaurantsFiltersView");
        FiltersViewKt.invoke(restaurantsFiltersView, new RestaurantsFiltersBinder$bind$1(restaurantsListScreenRefactor));
    }

    public void accept(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "activity");
        ((RestaurantsFiltersView) restaurantsListScreenRefactor.findViewById(R.id.restaurantsFiltersView)).setVisibility(0);
        bind(restaurantsListScreenRefactor);
    }
}
