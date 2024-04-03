package com.talabat.feature.pickup.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/pickup/data/entity/PickupVendorDto;", "", "vendors", "", "Lcom/talabat/feature/pickup/data/entity/PickupDto;", "pageNumber", "", "pageSize", "isNewPickupCustomer", "", "swimlanes", "Lcom/talabat/feature/pickup/data/entity/PickupSwimlaneDto;", "(Ljava/util/List;IIZLjava/util/List;)V", "()Z", "getPageNumber", "()I", "getPageSize", "getSwimlanes", "()Ljava/util/List;", "getVendors", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupVendorDto {
    @SerializedName("is_new_pickup_customer")
    private final boolean isNewPickupCustomer;
    @SerializedName("page_no")
    private final int pageNumber;
    @SerializedName("page_size")
    private final int pageSize;
    @SerializedName("swimlanes")
    @Nullable
    private final List<PickupSwimlaneDto> swimlanes;
    @SerializedName("vendors")
    @NotNull
    private final List<PickupDto> vendors;

    public PickupVendorDto(@NotNull List<PickupDto> list, int i11, int i12, boolean z11, @Nullable List<PickupSwimlaneDto> list2) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        this.vendors = list;
        this.pageNumber = i11;
        this.pageSize = i12;
        this.isNewPickupCustomer = z11;
        this.swimlanes = list2;
    }

    public static /* synthetic */ PickupVendorDto copy$default(PickupVendorDto pickupVendorDto, List<PickupDto> list, int i11, int i12, boolean z11, List<PickupSwimlaneDto> list2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            list = pickupVendorDto.vendors;
        }
        if ((i13 & 2) != 0) {
            i11 = pickupVendorDto.pageNumber;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = pickupVendorDto.pageSize;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            z11 = pickupVendorDto.isNewPickupCustomer;
        }
        boolean z12 = z11;
        if ((i13 & 16) != 0) {
            list2 = pickupVendorDto.swimlanes;
        }
        return pickupVendorDto.copy(list, i14, i15, z12, list2);
    }

    @NotNull
    public final List<PickupDto> component1() {
        return this.vendors;
    }

    public final int component2() {
        return this.pageNumber;
    }

    public final int component3() {
        return this.pageSize;
    }

    public final boolean component4() {
        return this.isNewPickupCustomer;
    }

    @Nullable
    public final List<PickupSwimlaneDto> component5() {
        return this.swimlanes;
    }

    @NotNull
    public final PickupVendorDto copy(@NotNull List<PickupDto> list, int i11, int i12, boolean z11, @Nullable List<PickupSwimlaneDto> list2) {
        Intrinsics.checkNotNullParameter(list, "vendors");
        return new PickupVendorDto(list, i11, i12, z11, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickupVendorDto)) {
            return false;
        }
        PickupVendorDto pickupVendorDto = (PickupVendorDto) obj;
        return Intrinsics.areEqual((Object) this.vendors, (Object) pickupVendorDto.vendors) && this.pageNumber == pickupVendorDto.pageNumber && this.pageSize == pickupVendorDto.pageSize && this.isNewPickupCustomer == pickupVendorDto.isNewPickupCustomer && Intrinsics.areEqual((Object) this.swimlanes, (Object) pickupVendorDto.swimlanes);
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @Nullable
    public final List<PickupSwimlaneDto> getSwimlanes() {
        return this.swimlanes;
    }

    @NotNull
    public final List<PickupDto> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        int hashCode = ((((this.vendors.hashCode() * 31) + this.pageNumber) * 31) + this.pageSize) * 31;
        boolean z11 = this.isNewPickupCustomer;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        List<PickupSwimlaneDto> list = this.swimlanes;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public final boolean isNewPickupCustomer() {
        return this.isNewPickupCustomer;
    }

    @NotNull
    public String toString() {
        List<PickupDto> list = this.vendors;
        int i11 = this.pageNumber;
        int i12 = this.pageSize;
        boolean z11 = this.isNewPickupCustomer;
        List<PickupSwimlaneDto> list2 = this.swimlanes;
        return "PickupVendorDto(vendors=" + list + ", pageNumber=" + i11 + ", pageSize=" + i12 + ", isNewPickupCustomer=" + z11 + ", swimlanes=" + list2 + ")";
    }
}
