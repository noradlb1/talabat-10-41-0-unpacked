package com.talabat.feature.pickup.data.events;

import com.talabat.core.network.midas.MidasHttpInterceptorKt;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/pickup/data/events/ShopClickEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "restaurant", "Ldatamodels/Restaurant;", "withCuisines", "", "(Ldatamodels/Restaurant;Z)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopClickEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "shop_clicked";
    @NotNull
    private final Restaurant restaurant;
    private final boolean withCuisines;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/data/events/ShopClickEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShopClickEvent(@NotNull Restaurant restaurant2, boolean z11) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        this.restaurant = restaurant2;
        this.withCuisines = z11;
    }

    private final Restaurant component1() {
        return this.restaurant;
    }

    private final boolean component2() {
        return this.withCuisines;
    }

    public static /* synthetic */ ShopClickEvent copy$default(ShopClickEvent shopClickEvent, Restaurant restaurant2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            restaurant2 = shopClickEvent.restaurant;
        }
        if ((i11 & 2) != 0) {
            z11 = shopClickEvent.withCuisines;
        }
        return shopClickEvent.copy(restaurant2, z11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[16];
        if (this.withCuisines) {
            str = "pickup_cuisine";
        } else {
            str = "pickup_vendor_list";
        }
        pairArr[0] = TuplesKt.to("shopClickOrigin", str);
        pairArr[1] = TuplesKt.to("deliveryProvider", "pickup");
        TrackerHelpers trackerHelpers = TrackerHelpers.INSTANCE;
        pairArr[2] = TuplesKt.to("shopStatus", trackerHelpers.getShopStatus$com_talabat_feature_pickup_data_data(this.restaurant.statusType));
        pairArr[3] = TuplesKt.to(ConstantsKt.CLICK_MIDAS_REQUEST_ID, MidasHttpInterceptorKt.getMidasRequestId());
        pairArr[4] = TuplesKt.to("shopId", Integer.valueOf(this.restaurant.branchId));
        pairArr[5] = TuplesKt.to("screenName", "pickup_vendor_list");
        pairArr[6] = TuplesKt.to("screenType", "pickup_vendor_list");
        pairArr[7] = TuplesKt.to("shopName", trackerHelpers.orNotAvailable$com_talabat_feature_pickup_data_data(this.restaurant.branchName));
        pairArr[8] = TuplesKt.to("shopType", StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        pairArr[9] = TuplesKt.to("shopPosition", String.valueOf(this.restaurant.itemPosition));
        pairArr[10] = TuplesKt.to("shopListType", "pickup");
        pairArr[11] = TuplesKt.to("listingPageType", "pickup");
        pairArr[12] = TuplesKt.to("chainId", Integer.valueOf(this.restaurant.f13872id));
        pairArr[13] = TuplesKt.to("chainName", trackerHelpers.orNotAvailable$com_talabat_feature_pickup_data_data(this.restaurant.f13873name));
        pairArr[14] = TuplesKt.to("shopDeliveryTime", trackerHelpers.orNotAvailable$com_talabat_feature_pickup_data_data(this.restaurant.deliveryTime));
        pairArr[15] = TuplesKt.to("shopMainCuisine", trackerHelpers.mainCuisine$com_talabat_feature_pickup_data_data(this.restaurant));
        Map<String, Object> mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        trackerHelpers.addShopClickNotAvailableParams$com_talabat_feature_pickup_data_data(mutableMapOf);
        return mutableMapOf;
    }

    @NotNull
    public final ShopClickEvent copy(@NotNull Restaurant restaurant2, boolean z11) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        return new ShopClickEvent(restaurant2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClickEvent)) {
            return false;
        }
        ShopClickEvent shopClickEvent = (ShopClickEvent) obj;
        return Intrinsics.areEqual((Object) this.restaurant, (Object) shopClickEvent.restaurant) && this.withCuisines == shopClickEvent.withCuisines;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        int hashCode = this.restaurant.hashCode() * 31;
        boolean z11 = this.withCuisines;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_clicked";
    }

    @NotNull
    public String toString() {
        Restaurant restaurant2 = this.restaurant;
        boolean z11 = this.withCuisines;
        return "ShopClickEvent(restaurant=" + restaurant2 + ", withCuisines=" + z11 + ")";
    }
}
