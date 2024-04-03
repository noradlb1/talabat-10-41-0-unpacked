package com.talabat.feature.pickup.domain.entity;

import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "", "vendors", "", "Ldatamodels/Restaurant;", "pageNumber", "", "pageSize", "(Ljava/util/List;II)V", "getPageNumber", "()I", "getPageSize", "getVendors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupVendor {
    private final int pageNumber;
    private final int pageSize;
    @NotNull
    private final List<Restaurant> vendors;

    public PickupVendor(@NotNull List<? extends Restaurant> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        this.vendors = list;
        this.pageNumber = i11;
        this.pageSize = i12;
    }

    public static /* synthetic */ PickupVendor copy$default(PickupVendor pickupVendor, List<Restaurant> list, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = pickupVendor.vendors;
        }
        if ((i13 & 2) != 0) {
            i11 = pickupVendor.pageNumber;
        }
        if ((i13 & 4) != 0) {
            i12 = pickupVendor.pageSize;
        }
        return pickupVendor.copy(list, i11, i12);
    }

    @NotNull
    public final List<Restaurant> component1() {
        return this.vendors;
    }

    public final int component2() {
        return this.pageNumber;
    }

    public final int component3() {
        return this.pageSize;
    }

    @NotNull
    public final PickupVendor copy(@NotNull List<? extends Restaurant> list, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        return new PickupVendor(list, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupVendor)) {
            return false;
        }
        PickupVendor pickupVendor = (PickupVendor) obj;
        return Intrinsics.areEqual((Object) this.vendors, (Object) pickupVendor.vendors) && this.pageNumber == pickupVendor.pageNumber && this.pageSize == pickupVendor.pageSize;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final List<Restaurant> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        return (((this.vendors.hashCode() * 31) + this.pageNumber) * 31) + this.pageSize;
    }

    @NotNull
    public String toString() {
        List<Restaurant> list = this.vendors;
        int i11 = this.pageNumber;
        int i12 = this.pageSize;
        return "PickupVendor(vendors=" + list + ", pageNumber=" + i11 + ", pageSize=" + i12 + ")";
    }
}
