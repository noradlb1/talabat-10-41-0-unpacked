package com.talabat.collectiondetails.tracking;

import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.Restaurant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.RestaurantsEventsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\t\u0010\u0010\u001a\u00020\bHÂ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/collectiondetails/tracking/FavouriteVendorAddedRemovedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "isSelected", "", "user", "", "", "restaurant", "Ldatamodels/Restaurant;", "(ZLjava/util/Map;Ldatamodels/Restaurant;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavouriteVendorAddedRemovedEvent extends TalabatEvent {
    private final boolean isSelected;
    @NotNull
    private final Restaurant restaurant;
    @NotNull
    private final Map<String, String> user;

    public FavouriteVendorAddedRemovedEvent(boolean z11, @NotNull Map<String, String> map, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        this.isSelected = z11;
        this.user = map;
        this.restaurant = restaurant2;
    }

    private final boolean component1() {
        return this.isSelected;
    }

    private final Map<String, String> component2() {
        return this.user;
    }

    private final Restaurant component3() {
        return this.restaurant;
    }

    public static /* synthetic */ FavouriteVendorAddedRemovedEvent copy$default(FavouriteVendorAddedRemovedEvent favouriteVendorAddedRemovedEvent, boolean z11, Map<String, String> map, Restaurant restaurant2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = favouriteVendorAddedRemovedEvent.isSelected;
        }
        if ((i11 & 2) != 0) {
            map = favouriteVendorAddedRemovedEvent.user;
        }
        if ((i11 & 4) != 0) {
            restaurant2 = favouriteVendorAddedRemovedEvent.restaurant;
        }
        return favouriteVendorAddedRemovedEvent.copy(z11, map, restaurant2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        boolean z11;
        String str;
        boolean z12;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        String branchNameSlug = this.restaurant.getBranchNameSlug();
        boolean z13 = false;
        if (branchNameSlug == null || branchNameSlug.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str2 = "N/A";
        if (z11) {
            str = str2;
        } else {
            str = this.restaurant.getBranchNameSlug();
            Intrinsics.checkNotNullExpressionValue(str, "restaurant.getBranchNameSlug()");
        }
        String totalRating = this.restaurant.getTotalRating();
        if (totalRating == null || totalRating.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            str2 = this.restaurant.getTotalRating();
        }
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("screenType", "shop_list");
        pairArr[1] = TuplesKt.to("screenName", "Restaurant List Screen");
        pairArr[2] = TuplesKt.to("shopId", Integer.valueOf(this.restaurant.branchId));
        pairArr[3] = TuplesKt.to("chainId", Integer.valueOf(this.restaurant.f13872id));
        pairArr[4] = TuplesKt.to("shopType", StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        if (this.restaurant.statusType == 0) {
            z13 = true;
        }
        pairArr[5] = TuplesKt.to(ShopDetailsLoadedEvent.SHOP_OPEN, Boolean.valueOf(z13));
        pairArr[6] = TuplesKt.to(ShopDetailsLoadedEvent.SHOP_RATING_QUANTITY, str2);
        pairArr[7] = TuplesKt.to(ShopDetailsLoadedEvent.SHOP_RATING_QUALITY, Float.valueOf(this.restaurant.getRating()));
        pairArr[8] = TuplesKt.to("shopSponsoring", RestaurantsEventsKt.sponsoringData(this.restaurant));
        pairArr[9] = TuplesKt.to("shopName", str);
        pairArr[10] = TuplesKt.to("shopCategoryList", this.restaurant.getCuisineString());
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final FavouriteVendorAddedRemovedEvent copy(boolean z11, @NotNull Map<String, String> map, @NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        return new FavouriteVendorAddedRemovedEvent(z11, map, restaurant2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FavouriteVendorAddedRemovedEvent)) {
            return false;
        }
        FavouriteVendorAddedRemovedEvent favouriteVendorAddedRemovedEvent = (FavouriteVendorAddedRemovedEvent) obj;
        return this.isSelected == favouriteVendorAddedRemovedEvent.isSelected && Intrinsics.areEqual((Object) this.user, (Object) favouriteVendorAddedRemovedEvent.user) && Intrinsics.areEqual((Object) this.restaurant, (Object) favouriteVendorAddedRemovedEvent.restaurant);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_list";
    }

    public int hashCode() {
        boolean z11 = this.isSelected;
        if (z11) {
            z11 = true;
        }
        return ((((z11 ? 1 : 0) * true) + this.user.hashCode()) * 31) + this.restaurant.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (this.isSelected) {
            return "favourite_vendor_added";
        }
        return "favourite_vendor_removed";
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isSelected;
        Map<String, String> map = this.user;
        Restaurant restaurant2 = this.restaurant;
        return "FavouriteVendorAddedRemovedEvent(isSelected=" + z11 + ", user=" + map + ", restaurant=" + restaurant2 + ")";
    }
}
