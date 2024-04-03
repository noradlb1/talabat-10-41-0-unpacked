package com.talabat.feature.pickup.data.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/talabat/feature/pickup/data/events/PopupClicked;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "restaurant", "Ldatamodels/Restaurant;", "selectedCountryCode", "", "proceedWithPickup", "", "(Ldatamodels/Restaurant;Ljava/lang/String;Z)V", "getProceedWithPickup", "()Z", "getRestaurant", "()Ldatamodels/Restaurant;", "getSelectedCountryCode", "()Ljava/lang/String;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopupClicked extends TalabatEvent {
    @NotNull
    public static final String BACK_TO_DELIVERY = "back_to_list";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "popup_clicked";
    @NotNull
    public static final String SELF_PICKUP = "self_pickup";
    private final boolean proceedWithPickup;
    @NotNull
    private final Restaurant restaurant;
    @NotNull
    private final String selectedCountryCode;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pickup/data/events/PopupClicked$Companion;", "", "()V", "BACK_TO_DELIVERY", "", "EVENT_NAME", "SELF_PICKUP", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PopupClicked(@NotNull Restaurant restaurant2, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(str, "selectedCountryCode");
        this.restaurant = restaurant2;
        this.selectedCountryCode = str;
        this.proceedWithPickup = z11;
    }

    public static /* synthetic */ PopupClicked copy$default(PopupClicked popupClicked, Restaurant restaurant2, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            restaurant2 = popupClicked.restaurant;
        }
        if ((i11 & 2) != 0) {
            str = popupClicked.selectedCountryCode;
        }
        if ((i11 & 4) != 0) {
            z11 = popupClicked.proceedWithPickup;
        }
        return popupClicked.copy(restaurant2, str, z11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (this.proceedWithPickup) {
            str = SELF_PICKUP;
        } else {
            str = BACK_TO_DELIVERY;
        }
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("shopType", "pickup"), TuplesKt.to("screenType", "shop_list"), TuplesKt.to(ConstantsKt.POPUP_TYPE, "vendor_list_pickup"), TuplesKt.to("screenName", "Restaurant Screen"), TuplesKt.to("shopName", this.restaurant.f13873name), TuplesKt.to("locationAddress", "N/A"), TuplesKt.to("shopId", String.valueOf(this.restaurant.f13872id)), TuplesKt.to("locationCountry", this.selectedCountryCode), TuplesKt.to("locationLat", String.valueOf(this.restaurant.latitude)), TuplesKt.to("locationLon", String.valueOf(this.restaurant.longitude)), TuplesKt.to(ConstantsKt.POPUP_BUTTON, str));
    }

    @NotNull
    public final Restaurant component1() {
        return this.restaurant;
    }

    @NotNull
    public final String component2() {
        return this.selectedCountryCode;
    }

    public final boolean component3() {
        return this.proceedWithPickup;
    }

    @NotNull
    public final PopupClicked copy(@NotNull Restaurant restaurant2, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(str, "selectedCountryCode");
        return new PopupClicked(restaurant2, str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupClicked)) {
            return false;
        }
        PopupClicked popupClicked = (PopupClicked) obj;
        return Intrinsics.areEqual((Object) this.restaurant, (Object) popupClicked.restaurant) && Intrinsics.areEqual((Object) this.selectedCountryCode, (Object) popupClicked.selectedCountryCode) && this.proceedWithPickup == popupClicked.proceedWithPickup;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public final boolean getProceedWithPickup() {
        return this.proceedWithPickup;
    }

    @NotNull
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    @NotNull
    public final String getSelectedCountryCode() {
        return this.selectedCountryCode;
    }

    public int hashCode() {
        int hashCode = ((this.restaurant.hashCode() * 31) + this.selectedCountryCode.hashCode()) * 31;
        boolean z11 = this.proceedWithPickup;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public String toString() {
        Restaurant restaurant2 = this.restaurant;
        String str = this.selectedCountryCode;
        boolean z11 = this.proceedWithPickup;
        return "PopupClicked(restaurant=" + restaurant2 + ", selectedCountryCode=" + str + ", proceedWithPickup=" + z11 + ")";
    }
}
