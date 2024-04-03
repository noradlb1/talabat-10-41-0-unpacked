package com.talabat.helpers;

import datamodels.Restaurant;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isFavourite", "", "Ldatamodels/Restaurant;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RestaurantExtensionsKt {
    public static final boolean isFavourite(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "<this>");
        HashSet<Integer> favouriteVendorIds = SharedPreferencesManager.getInstance().getFavouriteVendorIds();
        Intrinsics.checkNotNullExpressionValue(favouriteVendorIds, "getInstance().favouriteVendorIds");
        if ((favouriteVendorIds instanceof Collection) && favouriteVendorIds.isEmpty()) {
            return false;
        }
        for (Integer equals : favouriteVendorIds) {
            if (equals.equals(Integer.valueOf(restaurant.f13872id))) {
                return true;
            }
        }
        return false;
    }
}
