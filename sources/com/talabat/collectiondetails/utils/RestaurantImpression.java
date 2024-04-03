package com.talabat.collectiondetails.utils;

import com.talabat.impressions.ImpressionsItem;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/collectiondetails/utils/RestaurantImpression;", "Lcom/talabat/impressions/ImpressionsItem;", "restaurant", "Ldatamodels/Restaurant;", "(Ldatamodels/Restaurant;)V", "id", "", "getId", "()Ljava/lang/Integer;", "getRestaurant", "()Ldatamodels/Restaurant;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantImpression implements ImpressionsItem {
    @Nullable
    private final Restaurant restaurant;

    public RestaurantImpression(@Nullable Restaurant restaurant2) {
        this.restaurant = restaurant2;
    }

    @Nullable
    public Integer getId() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return Integer.valueOf(restaurant2.f13872id);
        }
        return null;
    }

    @Nullable
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }
}
