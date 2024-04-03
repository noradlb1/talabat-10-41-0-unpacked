package com.talabat.feature.pickup.data.entity;

import datamodels.Cuisine;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006\u0005"}, d2 = {"toRestaurant", "Ldatamodels/Restaurant;", "Lcom/talabat/feature/pickup/data/entity/PickupDto;", "toRestaurants", "", "com_talabat_feature_pickup_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PickupDtoKt {
    @NotNull
    public static final Restaurant toRestaurant(@NotNull PickupDto pickupDto) {
        Intrinsics.checkNotNullParameter(pickupDto, "<this>");
        Restaurant restaurant = new Restaurant();
        restaurant.f13872id = pickupDto.getChainId();
        restaurant.logo = pickupDto.getChainLogo();
        restaurant.f13873name = pickupDto.getChainName();
        restaurant.branchId = pickupDto.getVendorId();
        restaurant.branchName = pickupDto.getVendorName();
        restaurant.statusType = pickupDto.getStatusType();
        restaurant.rating = (float) pickupDto.getRating();
        restaurant.deliveryTimeInteger = String.valueOf(pickupDto.getPickupMinutes());
        restaurant.deliveryTime = pickupDto.getPickupTimeText();
        restaurant.isNewRestaurant = pickupDto.isNewVendor();
        Iterable<PickupCuisineDto> cuisines = pickupDto.getCuisines();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cuisines, 10));
        for (PickupCuisineDto pickupCuisineDto : cuisines) {
            Cuisine cuisine = new Cuisine();
            cuisine.f13848id = pickupCuisineDto.getId();
            cuisine.f13849name = pickupCuisineDto.getName();
            cuisine.slugName = "";
            cuisine.setPrimary(Boolean.valueOf(pickupCuisineDto.isPrimary()));
            arrayList.add(cuisine);
        }
        Object[] array = arrayList.toArray(new Cuisine[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        restaurant.cuisines = (Cuisine[]) array;
        restaurant.longitude = pickupDto.getLatLng().getLon();
        restaurant.latitude = pickupDto.getLatLng().getLat();
        restaurant.isDiscountAvaialble = pickupDto.isDiscountAvailable();
        restaurant.betterOfferText = pickupDto.getDiscountText();
        restaurant.moreOffers = pickupDto.getMoreDiscounts();
        restaurant.priceTag = pickupDto.getPriceTag();
        restaurant.setPickupDistanceInKm(String.valueOf(pickupDto.getDistance().getDistanceInKM()));
        restaurant.setAllOrderDiscountText(pickupDto.getAllOrderDiscountText());
        restaurant.setCuisinesText(pickupDto.getCuisinesText());
        restaurant.setRatingText(pickupDto.getRatingText());
        restaurant.setStatusText(pickupDto.getStatusText());
        restaurant.totalRatingNonformatted = pickupDto.getTotalRating();
        restaurant.setPickup(Boolean.TRUE);
        restaurant.setPickupDiscountCode(pickupDto.getVoucherCode());
        restaurant.setPickupDiscountDisplayText(pickupDto.getVoucherDisplayText());
        restaurant.setPickupDiscountText(pickupDto.getPickupDiscountText());
        return restaurant;
    }

    @NotNull
    public static final List<Restaurant> toRestaurants(@NotNull List<PickupDto> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<PickupDto> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (PickupDto restaurant : iterable) {
            arrayList.add(toRestaurant(restaurant));
        }
        return arrayList;
    }
}
