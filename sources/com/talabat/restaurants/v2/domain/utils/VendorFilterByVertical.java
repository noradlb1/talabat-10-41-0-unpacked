package com.talabat.restaurants.v2.domain.utils;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/restaurants/v2/domain/utils/VendorFilterByVertical;", "", "()V", "filter", "", "Ldatamodels/Restaurant;", "vendors", "segregateVerticals", "", "verticalId", "", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "vendorFilterPredicate", "vendor", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorFilterByVertical {
    @NotNull
    public static final VendorFilterByVertical INSTANCE = new VendorFilterByVertical();

    private VendorFilterByVertical() {
    }

    @NotNull
    public final List<Restaurant> filter(@NotNull List<? extends Restaurant> list, boolean z11, int i11, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (INSTANCE.vendorFilterPredicate((Restaurant) next, z11, i11, iTalabatFeatureFlag)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final boolean vendorFilterPredicate(@NotNull Restaurant restaurant, boolean z11, int i11, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        List<Integer> list;
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        if (!iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.LAUNCHER_ENABLE_TILES, false) && (i11 != 0 || z11)) {
            if (z11 && (list = restaurant.verticals) != null) {
                return list.contains(Integer.valueOf(i11));
            }
            if (restaurant.shopType != i11) {
                return false;
            }
        }
        return true;
    }
}
