package com.talabat.feature.pickup.domain.entity;

import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.Restaurant;
import datamodels.Strategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JC\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006("}, d2 = {"Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "", "title", "", "subtitle", "slug", "strategy", "Ldatamodels/Strategy;", "restaurants", "", "Ldatamodels/Restaurant;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldatamodels/Strategy;Ljava/util/List;)V", "getRestaurants", "()Ljava/util/List;", "setRestaurants", "(Ljava/util/List;)V", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "getStrategy", "()Ldatamodels/Strategy;", "setStrategy", "(Ldatamodels/Strategy;)V", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupSwimlane {
    @NotNull
    private List<? extends Restaurant> restaurants;
    @NotNull
    private String slug;
    @Nullable
    private Strategy strategy;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;

    public PickupSwimlane(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Strategy strategy2, @NotNull List<? extends Restaurant> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(str3, "slug");
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        this.title = str;
        this.subtitle = str2;
        this.slug = str3;
        this.strategy = strategy2;
        this.restaurants = list;
    }

    public static /* synthetic */ PickupSwimlane copy$default(PickupSwimlane pickupSwimlane, String str, String str2, String str3, Strategy strategy2, List<? extends Restaurant> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pickupSwimlane.title;
        }
        if ((i11 & 2) != 0) {
            str2 = pickupSwimlane.subtitle;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = pickupSwimlane.slug;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            strategy2 = pickupSwimlane.strategy;
        }
        Strategy strategy3 = strategy2;
        if ((i11 & 16) != 0) {
            list = pickupSwimlane.restaurants;
        }
        return pickupSwimlane.copy(str, str4, str5, strategy3, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final String component3() {
        return this.slug;
    }

    @Nullable
    public final Strategy component4() {
        return this.strategy;
    }

    @NotNull
    public final List<Restaurant> component5() {
        return this.restaurants;
    }

    @NotNull
    public final PickupSwimlane copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Strategy strategy2, @NotNull List<? extends Restaurant> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(str3, "slug");
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        return new PickupSwimlane(str, str2, str3, strategy2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupSwimlane)) {
            return false;
        }
        PickupSwimlane pickupSwimlane = (PickupSwimlane) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) pickupSwimlane.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) pickupSwimlane.subtitle) && Intrinsics.areEqual((Object) this.slug, (Object) pickupSwimlane.slug) && Intrinsics.areEqual((Object) this.strategy, (Object) pickupSwimlane.strategy) && Intrinsics.areEqual((Object) this.restaurants, (Object) pickupSwimlane.restaurants);
    }

    @NotNull
    public final List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Strategy getStrategy() {
        return this.strategy;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.slug.hashCode()) * 31;
        Strategy strategy2 = this.strategy;
        return ((hashCode + (strategy2 == null ? 0 : strategy2.hashCode())) * 31) + this.restaurants.hashCode();
    }

    public final void setRestaurants(@NotNull List<? extends Restaurant> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.restaurants = list;
    }

    public final void setSlug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.slug = str;
    }

    public final void setStrategy(@Nullable Strategy strategy2) {
        this.strategy = strategy2;
    }

    public final void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        String str3 = this.slug;
        Strategy strategy2 = this.strategy;
        List<? extends Restaurant> list = this.restaurants;
        return "PickupSwimlane(title=" + str + ", subtitle=" + str2 + ", slug=" + str3 + ", strategy=" + strategy2 + ", restaurants=" + list + ")";
    }
}
