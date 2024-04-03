package com.talabat.feature.pickup.data.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0011\u001a\u00020\bHÂ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u001a\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/pickup/data/events/ShopListLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "restaurants", "", "Ldatamodels/Restaurant;", "creditBalance", "", "eventOrigin", "", "(Ljava/util/List;FLjava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "shopsPreOrder", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopListLoadedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "shop_list_loaded";
    private final float creditBalance;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final List<Restaurant> restaurants;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/data/events/ShopListLoadedEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShopListLoadedEvent(@NotNull List<? extends Restaurant> list, float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        this.restaurants = list;
        this.creditBalance = f11;
        this.eventOrigin = str;
    }

    private final List<Restaurant> component1() {
        return this.restaurants;
    }

    private final float component2() {
        return this.creditBalance;
    }

    private final String component3() {
        return this.eventOrigin;
    }

    public static /* synthetic */ ShopListLoadedEvent copy$default(ShopListLoadedEvent shopListLoadedEvent, List<Restaurant> list, float f11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = shopListLoadedEvent.restaurants;
        }
        if ((i11 & 2) != 0) {
            f11 = shopListLoadedEvent.creditBalance;
        }
        if ((i11 & 4) != 0) {
            str = shopListLoadedEvent.eventOrigin;
        }
        return shopListLoadedEvent.copy(list, f11, str);
    }

    private final String shopsPreOrder(List<? extends Restaurant> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((Restaurant) next).statusType == 5) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return String.valueOf(arrayList.size());
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Iterable<Restaurant> iterable = this.restaurants;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i11 = 0;
            for (Restaurant restaurant : iterable) {
                if (restaurant.statusType == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (i11 = i11 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i11 = 0;
        }
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.restaurants, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ShopListLoadedEvent$attributes$shopsIds$1.INSTANCE, 31, (Object) null);
        float f11 = this.creditBalance;
        TrackerHelpers trackerHelpers = TrackerHelpers.INSTANCE;
        Map<String, Object> mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ConstantsKt.LOADED_SHOPS_OPEN, Integer.valueOf(i11)), TuplesKt.to(ConstantsKt.LOADED_LIST_VIEW_TYPE, "list_view"), TuplesKt.to(ConstantsKt.LOADED_SHOP_CATEGORY_SELECTED_QUANTITY, "0"), TuplesKt.to(ConstantsKt.LOADED_SHOP_QUANTITY_SHOWN, String.valueOf(this.restaurants.size())), TuplesKt.to(ConstantsKt.LOADED_SHOP_QUANTITY_TOTAL, String.valueOf(this.restaurants.size())), TuplesKt.to("eventOrigin", this.eventOrigin), TuplesKt.to("screenName", "pickup_vendor_list"), TuplesKt.to("screenType", "shop_list"), TuplesKt.to("shopCokeUpsell", "FALSE"), TuplesKt.to(ConstantsKt.LOADED_SHOP_COKE_UPSELL_QUANTITY, "0"), TuplesKt.to(ConstantsKt.LOADED_SHOPS_PREORDER, shopsPreOrder(this.restaurants)), TuplesKt.to("shopListType", "pickup_vendor_list"), TuplesKt.to("listingPageType", "pickup"), TuplesKt.to(ConstantsKt.LOADED_SHOP_LIST_TRIGGER, "pickup_vertical"), TuplesKt.to(ConstantsKt.LOADED_SHOPS_OFFERS, "sub_free_delivery:0"), TuplesKt.to("userOnlinePaymentMethods", "credit:" + f11), TuplesKt.to(ConstantsKt.LOADED_SHOP_RECOMMENDED_QUANTITY, "0"), TuplesKt.to("shopsIds", trackerHelpers.orNotAvailable$com_talabat_feature_pickup_data_data(joinToString$default)));
        trackerHelpers.addShopsLoadedNotAvailableParams$com_talabat_feature_pickup_data_data(mutableMapOf);
        return mutableMapOf;
    }

    @NotNull
    public final ShopListLoadedEvent copy(@NotNull List<? extends Restaurant> list, float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        return new ShopListLoadedEvent(list, f11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopListLoadedEvent)) {
            return false;
        }
        ShopListLoadedEvent shopListLoadedEvent = (ShopListLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.restaurants, (Object) shopListLoadedEvent.restaurants) && Intrinsics.areEqual((Object) Float.valueOf(this.creditBalance), (Object) Float.valueOf(shopListLoadedEvent.creditBalance)) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) shopListLoadedEvent.eventOrigin);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        return (((this.restaurants.hashCode() * 31) + Float.floatToIntBits(this.creditBalance)) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public String toString() {
        List<Restaurant> list = this.restaurants;
        float f11 = this.creditBalance;
        String str = this.eventOrigin;
        return "ShopListLoadedEvent(restaurants=" + list + ", creditBalance=" + f11 + ", eventOrigin=" + str + ")";
    }
}
