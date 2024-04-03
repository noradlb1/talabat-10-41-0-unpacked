package com.talabat.talabatlife.features.vendors.vendorAreas.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/VendorAreasResponse;", "", "areas", "", "Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/Area;", "(Ljava/util/List;)V", "getAreas", "()Ljava/util/List;", "setAreas", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorAreasResponse {
    @SerializedName("areas")
    @Nullable
    private List<Area> areas;

    public VendorAreasResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public VendorAreasResponse(@Nullable List<Area> list) {
        this.areas = list;
    }

    public static /* synthetic */ VendorAreasResponse copy$default(VendorAreasResponse vendorAreasResponse, List<Area> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = vendorAreasResponse.areas;
        }
        return vendorAreasResponse.copy(list);
    }

    @Nullable
    public final List<Area> component1() {
        return this.areas;
    }

    @NotNull
    public final VendorAreasResponse copy(@Nullable List<Area> list) {
        return new VendorAreasResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VendorAreasResponse) && Intrinsics.areEqual((Object) this.areas, (Object) ((VendorAreasResponse) obj).areas);
    }

    @Nullable
    public final List<Area> getAreas() {
        return this.areas;
    }

    public int hashCode() {
        List<Area> list = this.areas;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setAreas(@Nullable List<Area> list) {
        this.areas = list;
    }

    @NotNull
    public String toString() {
        List<Area> list = this.areas;
        return "VendorAreasResponse(areas=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorAreasResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
