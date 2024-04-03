package com.talabat.feature.pickup.data.entity;

import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import com.talabat.feature.pickup.domain.entity.PickupVendor;
import datamodels.Restaurant;
import datamodels.Strategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, d2 = {"toDomain", "Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "Lcom/talabat/feature/pickup/data/entity/PickupSwimlaneDto;", "Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "Lcom/talabat/feature/pickup/data/entity/PickupVendorDto;", "com_talabat_feature_pickup_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PickupVendorDtoKt {
    @NotNull
    public static final PickupVendor toDomain(@NotNull PickupVendorDto pickupVendorDto) {
        Intrinsics.checkNotNullParameter(pickupVendorDto, "<this>");
        return new PickupVendor(PickupDtoKt.toRestaurants(pickupVendorDto.getVendors()), pickupVendorDto.getPageNumber(), pickupVendorDto.getPageSize());
    }

    @NotNull
    public static final PickupSwimlane toDomain(@NotNull PickupSwimlaneDto pickupSwimlaneDto) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(pickupSwimlaneDto, "<this>");
        String title = pickupSwimlaneDto.getTitle();
        String str3 = title == null ? "" : title;
        String subtitle = pickupSwimlaneDto.getSubtitle();
        if (subtitle == null) {
            str = "";
        } else {
            str = subtitle;
        }
        String slug = pickupSwimlaneDto.getSlug();
        if (slug == null) {
            str2 = "";
        } else {
            str2 = slug;
        }
        Strategy strategy = pickupSwimlaneDto.getStrategy();
        List<Restaurant> restaurants = pickupSwimlaneDto.getRestaurants();
        if (restaurants == null) {
            restaurants = CollectionsKt__CollectionsKt.emptyList();
        }
        return new PickupSwimlane(str3, str, str2, strategy, restaurants);
    }
}
