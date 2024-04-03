package com.talabat.restaurants;

import com.talabat.R;
import com.talabat.cuisines.navigation.CuisineView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"EVENT_TRIGGER", "", "bindCuisineView", "", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisinesBinderKt {
    @NotNull
    private static final String EVENT_TRIGGER = "category_applied";

    /* access modifiers changed from: private */
    public static final void bindCuisineView(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        ((CuisineView) restaurantsListScreenRefactor.findViewById(R.id.cuisineViewLayout)).invoke(new CuisinesBinderKt$bindCuisineView$1(restaurantsListScreenRefactor));
    }
}
