package com.talabat.core.tracking.common.helpers;

import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/tracking/common/helpers/EventDataHelper;", "", "()V", "getCampaignIds", "", "getOfferType", "restaurant", "Ldatamodels/Restaurant;", "getPaymentMethods", "getRestaurantForDarkstores", "extraRestaurant", "getScreenName", "vericalId", "", "screenName", "getShopOffer", "getShopStatus", "statusType", "getTalabatCreditBalance", "listingType", "restaurantType", "com_talabat_core_tracking_common_common"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventDataHelper {
    @NotNull
    public final String getCampaignIds() {
        return TalabatGTM.Companion.getCampaignIds();
    }

    @NotNull
    public final String getOfferType(@Nullable Restaurant restaurant) {
        return TalabatGTM.Companion.getOfferType(restaurant);
    }

    @NotNull
    public final String getPaymentMethods(@Nullable Restaurant restaurant) {
        return TalabatGTM.Companion.getPaymentMethods(restaurant);
    }

    @Nullable
    public final Restaurant getRestaurantForDarkstores(@Nullable String str) {
        return TalabatGTM.Companion.getRestaurantForDarkstores(str);
    }

    @NotNull
    public final String getScreenName(int i11, @Nullable String str) {
        return TalabatGTM.Companion.getScreenName(i11, str);
    }

    @NotNull
    public final String getShopOffer(@Nullable Restaurant restaurant) {
        return TalabatGTM.Companion.getShopOffer(restaurant);
    }

    @Nullable
    public final String getShopStatus(int i11) {
        return TalabatGTM.Companion.getShopStatus(i11);
    }

    @NotNull
    public final String getTalabatCreditBalance() {
        return TalabatGTM.Companion.getTalabatCreditBalance();
    }

    @NotNull
    public final String listingType(@Nullable Restaurant restaurant) {
        return TalabatGTM.Companion.listingType(restaurant);
    }

    @NotNull
    public final String restaurantType(@Nullable Restaurant restaurant) {
        return TalabatGTM.Companion.restaurantType(restaurant);
    }
}
