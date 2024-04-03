package com.talabat.restaurants.inlineads.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.gem.adapters.analytics.GemApiCallEvent;
import datamodels.Restaurant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0010\u001a\u00020\bHÂ\u0003J3\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/restaurants/inlineads/tracking/InlineAdsShownEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "user", "", "", "restaurant", "Ldatamodels/Restaurant;", "shopPosition", "", "(Ljava/util/Map;Ldatamodels/Restaurant;I)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "name", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsShownEvent extends TalabatEvent {
    @NotNull
    private final Restaurant restaurant;
    private final int shopPosition;
    @NotNull
    private final Map<String, String> user;

    public InlineAdsShownEvent(@NotNull Map<String, String> map, @NotNull Restaurant restaurant2, int i11) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        this.user = map;
        this.restaurant = restaurant2;
        this.shopPosition = i11;
    }

    private final Map<String, String> component1() {
        return this.user;
    }

    private final Restaurant component2() {
        return this.restaurant;
    }

    private final int component3() {
        return this.shopPosition;
    }

    public static /* synthetic */ InlineAdsShownEvent copy$default(InlineAdsShownEvent inlineAdsShownEvent, Map<String, String> map, Restaurant restaurant2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            map = inlineAdsShownEvent.user;
        }
        if ((i12 & 2) != 0) {
            restaurant2 = inlineAdsShownEvent.restaurant;
        }
        if ((i12 & 4) != 0) {
            i11 = inlineAdsShownEvent.shopPosition;
        }
        return inlineAdsShownEvent.copy(map, restaurant2, i11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        boolean z11;
        String str;
        boolean z12;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        String nameSlug = this.restaurant.getNameSlug();
        if (nameSlug == null || nameSlug.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str2 = "N/A";
        if (z11) {
            str = str2;
        } else {
            str = this.restaurant.getNameSlug();
            Intrinsics.checkNotNullExpressionValue(str, "restaurant.getNameSlug()");
        }
        String branchNameSlug = this.restaurant.getBranchNameSlug();
        if (branchNameSlug == null || branchNameSlug.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            str2 = this.restaurant.getBranchNameSlug();
            Intrinsics.checkNotNullExpressionValue(str2, "restaurant.getBranchNameSlug()");
        }
        HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("chainName", str), TuplesKt.to("chainId", Integer.valueOf(this.restaurant.f13872id)), TuplesKt.to("shopName", str2), TuplesKt.to("shopId", Integer.valueOf(this.restaurant.branchId)), TuplesKt.to("shopPosition", Integer.valueOf(this.shopPosition)), TuplesKt.to("shopSponsoring", Boolean.FALSE));
        hashMapOf.putAll(this.user);
        return hashMapOf;
    }

    @NotNull
    public final InlineAdsShownEvent copy(@NotNull Map<String, String> map, @NotNull Restaurant restaurant2, int i11) {
        Intrinsics.checkNotNullParameter(map, "user");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        return new InlineAdsShownEvent(map, restaurant2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InlineAdsShownEvent)) {
            return false;
        }
        InlineAdsShownEvent inlineAdsShownEvent = (InlineAdsShownEvent) obj;
        return Intrinsics.areEqual((Object) this.user, (Object) inlineAdsShownEvent.user) && Intrinsics.areEqual((Object) this.restaurant, (Object) inlineAdsShownEvent.restaurant) && this.shopPosition == inlineAdsShownEvent.shopPosition;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GemApiCallEvent.FEATURE_NAME;
    }

    public int hashCode() {
        return (((this.user.hashCode() * 31) + this.restaurant.hashCode()) * 31) + this.shopPosition;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "inline_banner_shown";
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.user;
        Restaurant restaurant2 = this.restaurant;
        int i11 = this.shopPosition;
        return "InlineAdsShownEvent(user=" + map + ", restaurant=" + restaurant2 + ", shopPosition=" + i11 + ")";
    }
}
