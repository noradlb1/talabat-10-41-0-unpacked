package com.talabat.collectiondetails.utils;

import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001H\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004H\u0000\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\bH\u0000¨\u0006\t"}, d2 = {"incrementPosition", "", "Lkotlin/Pair;", "", "Ldatamodels/Restaurant;", "Lcom/talabat/collectiondetails/utils/RestaurantImpression;", "mapToImpressionTracking", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImpresionTrackingMapperKt {
    @NotNull
    public static final List<Pair<Integer, Restaurant>> incrementPosition(@NotNull List<Pair<Integer, RestaurantImpression>> list) {
        Restaurant restaurant;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            Integer valueOf = Integer.valueOf(((Number) pair.getFirst()).intValue() + 1);
            RestaurantImpression restaurantImpression = (RestaurantImpression) pair.getSecond();
            if (restaurantImpression != null) {
                restaurant = restaurantImpression.getRestaurant();
            } else {
                restaurant = null;
            }
            arrayList.add(new Pair(valueOf, restaurant));
        }
        return arrayList;
    }

    @NotNull
    public static final RestaurantImpression mapToImpressionTracking(@Nullable Restaurant restaurant) {
        return new RestaurantImpression(restaurant);
    }

    @NotNull
    public static final List<RestaurantImpression> mapToImpressionTracking(@Nullable ArrayList<Restaurant> arrayList) {
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Restaurant mapToImpressionTracking : arrayList) {
            arrayList2.add(mapToImpressionTracking(mapToImpressionTracking));
        }
        return arrayList2;
    }
}
