package com.talabat.cuisines.domain;

import datamodels.Cuisine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0007"}, d2 = {"Cuisine", "Ldatamodels/Cuisine;", "id", "", "name", "", "slugName", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EntitiesKt {
    @NotNull
    public static final Cuisine Cuisine(int i11, @Nullable String str, @Nullable String str2) {
        Cuisine cuisine = new Cuisine();
        cuisine.f13848id = i11;
        cuisine.f13849name = str;
        cuisine.slugName = str2;
        return cuisine;
    }

    public static /* synthetic */ Cuisine Cuisine$default(int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        if ((i12 & 2) != 0) {
            str = null;
        }
        if ((i12 & 4) != 0) {
            str2 = null;
        }
        return Cuisine(i11, str, str2);
    }
}
