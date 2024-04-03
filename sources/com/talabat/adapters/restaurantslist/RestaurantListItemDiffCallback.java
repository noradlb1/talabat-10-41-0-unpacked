package com.talabat.adapters.restaurantslist;

import androidx.recyclerview.widget.DiffUtil;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/adapters/restaurantslist/RestaurantListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Ldatamodels/RestaurantListItemModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantListItemDiffCallback extends DiffUtil.ItemCallback<RestaurantListItemModel> {
    @NotNull
    public static final RestaurantListItemDiffCallback INSTANCE = new RestaurantListItemDiffCallback();

    private RestaurantListItemDiffCallback() {
    }

    public boolean areContentsTheSame(@NotNull RestaurantListItemModel restaurantListItemModel, @NotNull RestaurantListItemModel restaurantListItemModel2) {
        Intrinsics.checkNotNullParameter(restaurantListItemModel, "oldItem");
        Intrinsics.checkNotNullParameter(restaurantListItemModel2, "newItem");
        return restaurantListItemModel.equals(restaurantListItemModel2);
    }

    public boolean areItemsTheSame(@NotNull RestaurantListItemModel restaurantListItemModel, @NotNull RestaurantListItemModel restaurantListItemModel2) {
        Intrinsics.checkNotNullParameter(restaurantListItemModel, "oldItem");
        Intrinsics.checkNotNullParameter(restaurantListItemModel2, "newItem");
        Restaurant restaurant = restaurantListItemModel.restaurant;
        Integer num = null;
        Integer valueOf = restaurant != null ? Integer.valueOf(restaurant.f13872id) : null;
        Restaurant restaurant2 = restaurantListItemModel2.restaurant;
        if (restaurant2 != null) {
            num = Integer.valueOf(restaurant2.f13872id);
        }
        return Intrinsics.areEqual((Object) valueOf, (Object) num);
    }
}
