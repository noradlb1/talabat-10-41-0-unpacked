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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/pickup/data/events/PopupLoaded;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "restaurant", "Ldatamodels/Restaurant;", "selectedCountryCode", "", "(Ldatamodels/Restaurant;Ljava/lang/String;)V", "getRestaurant", "()Ldatamodels/Restaurant;", "getSelectedCountryCode", "()Ljava/lang/String;", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopupLoaded extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "popup_shown";
    @NotNull
    private final Restaurant restaurant;
    @NotNull
    private final String selectedCountryCode;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/data/events/PopupLoaded$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PopupLoaded(@NotNull Restaurant restaurant2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(str, "selectedCountryCode");
        this.restaurant = restaurant2;
        this.selectedCountryCode = str;
    }

    public static /* synthetic */ PopupLoaded copy$default(PopupLoaded popupLoaded, Restaurant restaurant2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            restaurant2 = popupLoaded.restaurant;
        }
        if ((i11 & 2) != 0) {
            str = popupLoaded.selectedCountryCode;
        }
        return popupLoaded.copy(restaurant2, str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("shopType", "pickup"), TuplesKt.to("screenType", "shop_list"), TuplesKt.to(ConstantsKt.POPUP_TYPE, "vendor_list_pickup"), TuplesKt.to("screenName", "Restaurant Screen"), TuplesKt.to("shopName", this.restaurant.f13873name), TuplesKt.to("locationAddress", "N/A"), TuplesKt.to("shopId", String.valueOf(this.restaurant.f13872id)), TuplesKt.to("locationCountry", this.selectedCountryCode), TuplesKt.to("locationLat", String.valueOf(this.restaurant.latitude)), TuplesKt.to("locationLon", String.valueOf(this.restaurant.longitude)), TuplesKt.to(ConstantsKt.POPUP_BUTTON, "N/A"));
    }

    @NotNull
    public final Restaurant component1() {
        return this.restaurant;
    }

    @NotNull
    public final String component2() {
        return this.selectedCountryCode;
    }

    @NotNull
    public final PopupLoaded copy(@NotNull Restaurant restaurant2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(str, "selectedCountryCode");
        return new PopupLoaded(restaurant2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupLoaded)) {
            return false;
        }
        PopupLoaded popupLoaded = (PopupLoaded) obj;
        return Intrinsics.areEqual((Object) this.restaurant, (Object) popupLoaded.restaurant) && Intrinsics.areEqual((Object) this.selectedCountryCode, (Object) popupLoaded.selectedCountryCode);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
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
        return (this.restaurant.hashCode() * 31) + this.selectedCountryCode.hashCode();
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
        return "PopupLoaded(restaurant=" + restaurant2 + ", selectedCountryCode=" + str + ")";
    }
}
