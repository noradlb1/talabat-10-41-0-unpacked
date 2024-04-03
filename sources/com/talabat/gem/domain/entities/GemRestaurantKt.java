package com.talabat.gem.domain.entities;

import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.ImpressionProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"toImpressionProperties", "Ldatamodels/ImpressionProperties;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "position", "", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemRestaurantKt {
    @NotNull
    public static final ImpressionProperties toImpressionProperties(@NotNull GemRestaurant gemRestaurant, int i11) {
        String str;
        Intrinsics.checkNotNullParameter(gemRestaurant, "<this>");
        Integer verticalType = gemRestaurant.getVerticalType();
        if (verticalType != null && verticalType.intValue() == 0) {
            str = StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT;
        } else {
            str = "groceries";
        }
        String str2 = str;
        int i12 = i11 + 1;
        String valueOf = String.valueOf(gemRestaurant.getBranchId());
        String name2 = gemRestaurant.getName();
        if (name2 == null) {
            name2 = "";
        }
        String str3 = name2;
        Integer deliveryAverageMinutes = gemRestaurant.getDeliveryAverageMinutes();
        Float deliveryChargesOrigin = gemRestaurant.getDeliveryChargesOrigin();
        Float ratingRaw = gemRestaurant.getRatingRaw();
        return new ImpressionProperties(i12, valueOf, str3, str2, str2, deliveryAverageMinutes + "/" + deliveryChargesOrigin + "/ /" + ratingRaw, "");
    }
}
