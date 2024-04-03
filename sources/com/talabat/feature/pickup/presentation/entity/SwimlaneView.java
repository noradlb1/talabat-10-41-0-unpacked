package com.talabat.feature.pickup.presentation.entity;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/talabat/feature/pickup/presentation/entity/SwimlaneView;", "", "restaurantName", "", "hint", "distance", "imageUrl", "ratingCount", "vendor", "Ldatamodels/Restaurant;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldatamodels/Restaurant;)V", "getDistance", "()Ljava/lang/String;", "getHint", "getImageUrl", "getRatingCount", "getRestaurantName", "getVendor", "()Ldatamodels/Restaurant;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneView {
    @NotNull
    private final String distance;
    @NotNull
    private final String hint;
    @NotNull
    private final String imageUrl;
    @NotNull
    private final String ratingCount;
    @NotNull
    private final String restaurantName;
    @NotNull
    private final Restaurant vendor;

    public SwimlaneView(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(str, "restaurantName");
        Intrinsics.checkNotNullParameter(str2, ViewHierarchyConstants.HINT_KEY);
        Intrinsics.checkNotNullParameter(str3, "distance");
        Intrinsics.checkNotNullParameter(str4, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str5, "ratingCount");
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        this.restaurantName = str;
        this.hint = str2;
        this.distance = str3;
        this.imageUrl = str4;
        this.ratingCount = str5;
        this.vendor = restaurant;
    }

    public static /* synthetic */ SwimlaneView copy$default(SwimlaneView swimlaneView, String str, String str2, String str3, String str4, String str5, Restaurant restaurant, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlaneView.restaurantName;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlaneView.hint;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = swimlaneView.distance;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = swimlaneView.imageUrl;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = swimlaneView.ratingCount;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            restaurant = swimlaneView.vendor;
        }
        return swimlaneView.copy(str, str6, str7, str8, str9, restaurant);
    }

    @NotNull
    public final String component1() {
        return this.restaurantName;
    }

    @NotNull
    public final String component2() {
        return this.hint;
    }

    @NotNull
    public final String component3() {
        return this.distance;
    }

    @NotNull
    public final String component4() {
        return this.imageUrl;
    }

    @NotNull
    public final String component5() {
        return this.ratingCount;
    }

    @NotNull
    public final Restaurant component6() {
        return this.vendor;
    }

    @NotNull
    public final SwimlaneView copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(str, "restaurantName");
        Intrinsics.checkNotNullParameter(str2, ViewHierarchyConstants.HINT_KEY);
        Intrinsics.checkNotNullParameter(str3, "distance");
        Intrinsics.checkNotNullParameter(str4, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str5, "ratingCount");
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        return new SwimlaneView(str, str2, str3, str4, str5, restaurant);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneView)) {
            return false;
        }
        SwimlaneView swimlaneView = (SwimlaneView) obj;
        return Intrinsics.areEqual((Object) this.restaurantName, (Object) swimlaneView.restaurantName) && Intrinsics.areEqual((Object) this.hint, (Object) swimlaneView.hint) && Intrinsics.areEqual((Object) this.distance, (Object) swimlaneView.distance) && Intrinsics.areEqual((Object) this.imageUrl, (Object) swimlaneView.imageUrl) && Intrinsics.areEqual((Object) this.ratingCount, (Object) swimlaneView.ratingCount) && Intrinsics.areEqual((Object) this.vendor, (Object) swimlaneView.vendor);
    }

    @NotNull
    public final String getDistance() {
        return this.distance;
    }

    @NotNull
    public final String getHint() {
        return this.hint;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getRatingCount() {
        return this.ratingCount;
    }

    @NotNull
    public final String getRestaurantName() {
        return this.restaurantName;
    }

    @NotNull
    public final Restaurant getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        return (((((((((this.restaurantName.hashCode() * 31) + this.hint.hashCode()) * 31) + this.distance.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.ratingCount.hashCode()) * 31) + this.vendor.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.restaurantName;
        String str2 = this.hint;
        String str3 = this.distance;
        String str4 = this.imageUrl;
        String str5 = this.ratingCount;
        Restaurant restaurant = this.vendor;
        return "SwimlaneView(restaurantName=" + str + ", hint=" + str2 + ", distance=" + str3 + ", imageUrl=" + str4 + ", ratingCount=" + str5 + ", vendor=" + restaurant + ")";
    }
}
