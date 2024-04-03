package com.talabat.feature.pickup.presentation;

import androidx.recyclerview.widget.DiffUtil;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/talabat/feature/pickup/presentation/PickupAdapter$Companion$PICKUP_COMPARATOR$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ldatamodels/Restaurant;", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupAdapter$Companion$PICKUP_COMPARATOR$1 extends DiffUtil.ItemCallback<Restaurant> {
    public boolean areContentsTheSame(@NotNull Restaurant restaurant, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(restaurant, "oldItem");
        Intrinsics.checkNotNullParameter(restaurant2, "newItem");
        return restaurant.equals(restaurant2);
    }

    public boolean areItemsTheSame(@NotNull Restaurant restaurant, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(restaurant, "oldItem");
        Intrinsics.checkNotNullParameter(restaurant2, "newItem");
        return restaurant.f13872id == restaurant2.f13872id;
    }
}
