package com.talabat.gem.samples;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/gem/samples/NavigationData;", "Ljava/io/Serializable;", "restaurantId", "", "subTotal", "", "(ID)V", "getRestaurantId", "()I", "getSubTotal", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationData implements Serializable {
    private final int restaurantId;
    private final double subTotal;

    public NavigationData(int i11, double d11) {
        this.restaurantId = i11;
        this.subTotal = d11;
    }

    public static /* synthetic */ NavigationData copy$default(NavigationData navigationData, int i11, double d11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = navigationData.restaurantId;
        }
        if ((i12 & 2) != 0) {
            d11 = navigationData.subTotal;
        }
        return navigationData.copy(i11, d11);
    }

    public final int component1() {
        return this.restaurantId;
    }

    public final double component2() {
        return this.subTotal;
    }

    @NotNull
    public final NavigationData copy(int i11, double d11) {
        return new NavigationData(i11, d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavigationData)) {
            return false;
        }
        NavigationData navigationData = (NavigationData) obj;
        return this.restaurantId == navigationData.restaurantId && Intrinsics.areEqual((Object) Double.valueOf(this.subTotal), (Object) Double.valueOf(navigationData.subTotal));
    }

    public final int getRestaurantId() {
        return this.restaurantId;
    }

    public final double getSubTotal() {
        return this.subTotal;
    }

    public int hashCode() {
        return (this.restaurantId * 31) + Double.doubleToLongBits(this.subTotal);
    }

    @NotNull
    public String toString() {
        int i11 = this.restaurantId;
        double d11 = this.subTotal;
        return "NavigationData(restaurantId=" + i11 + ", subTotal=" + d11 + ")";
    }
}
