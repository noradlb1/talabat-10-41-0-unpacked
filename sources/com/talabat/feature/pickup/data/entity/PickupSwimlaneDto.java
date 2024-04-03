package com.talabat.feature.pickup.data.entity;

import com.google.gson.annotations.SerializedName;
import datamodels.Restaurant;
import datamodels.Strategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JK\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006("}, d2 = {"Lcom/talabat/feature/pickup/data/entity/PickupSwimlaneDto;", "", "title", "", "subtitle", "slug", "strategy", "Ldatamodels/Strategy;", "restaurants", "", "Ldatamodels/Restaurant;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldatamodels/Strategy;Ljava/util/List;)V", "getRestaurants", "()Ljava/util/List;", "setRestaurants", "(Ljava/util/List;)V", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "getStrategy", "()Ldatamodels/Strategy;", "setStrategy", "(Ldatamodels/Strategy;)V", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupSwimlaneDto {
    @SerializedName("restaurants")
    @Nullable
    private List<? extends Restaurant> restaurants;
    @SerializedName("slug")
    @Nullable
    private String slug;
    @SerializedName("strategy")
    @Nullable
    private Strategy strategy;
    @SerializedName("subtitle")
    @Nullable
    private String subtitle;
    @SerializedName("title")
    @Nullable
    private String title;

    public PickupSwimlaneDto(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Strategy strategy2, @Nullable List<? extends Restaurant> list) {
        this.title = str;
        this.subtitle = str2;
        this.slug = str3;
        this.strategy = strategy2;
        this.restaurants = list;
    }

    public static /* synthetic */ PickupSwimlaneDto copy$default(PickupSwimlaneDto pickupSwimlaneDto, String str, String str2, String str3, Strategy strategy2, List<? extends Restaurant> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pickupSwimlaneDto.title;
        }
        if ((i11 & 2) != 0) {
            str2 = pickupSwimlaneDto.subtitle;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = pickupSwimlaneDto.slug;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            strategy2 = pickupSwimlaneDto.strategy;
        }
        Strategy strategy3 = strategy2;
        if ((i11 & 16) != 0) {
            list = pickupSwimlaneDto.restaurants;
        }
        return pickupSwimlaneDto.copy(str, str4, str5, strategy3, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    @Nullable
    public final String component3() {
        return this.slug;
    }

    @Nullable
    public final Strategy component4() {
        return this.strategy;
    }

    @Nullable
    public final List<Restaurant> component5() {
        return this.restaurants;
    }

    @NotNull
    public final PickupSwimlaneDto copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Strategy strategy2, @Nullable List<? extends Restaurant> list) {
        return new PickupSwimlaneDto(str, str2, str3, strategy2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupSwimlaneDto)) {
            return false;
        }
        PickupSwimlaneDto pickupSwimlaneDto = (PickupSwimlaneDto) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) pickupSwimlaneDto.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) pickupSwimlaneDto.subtitle) && Intrinsics.areEqual((Object) this.slug, (Object) pickupSwimlaneDto.slug) && Intrinsics.areEqual((Object) this.strategy, (Object) pickupSwimlaneDto.strategy) && Intrinsics.areEqual((Object) this.restaurants, (Object) pickupSwimlaneDto.restaurants);
    }

    @Nullable
    public final List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Strategy getStrategy() {
        return this.strategy;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.slug;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Strategy strategy2 = this.strategy;
        int hashCode4 = (hashCode3 + (strategy2 == null ? 0 : strategy2.hashCode())) * 31;
        List<? extends Restaurant> list = this.restaurants;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setRestaurants(@Nullable List<? extends Restaurant> list) {
        this.restaurants = list;
    }

    public final void setSlug(@Nullable String str) {
        this.slug = str;
    }

    public final void setStrategy(@Nullable Strategy strategy2) {
        this.strategy = strategy2;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        String str3 = this.slug;
        Strategy strategy2 = this.strategy;
        List<? extends Restaurant> list = this.restaurants;
        return "PickupSwimlaneDto(title=" + str + ", subtitle=" + str2 + ", slug=" + str3 + ", strategy=" + strategy2 + ", restaurants=" + list + ")";
    }
}
