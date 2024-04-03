package com.talabat.talabatlife.features.vendors.vendorAreas;

import com.talabat.talabatcommon.extentions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorAreas/VendorAreasRequestModel;", "", "countryCode", "", "lat", "", "long", "(ILjava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()I", "setCountryCode", "(I)V", "getLat", "()Ljava/lang/String;", "setLat", "(Ljava/lang/String;)V", "getLong", "setLong", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorAreasRequestModel {
    private int countryCode;
    @Nullable
    private String lat;
    @Nullable

    /* renamed from: long  reason: not valid java name */
    private String f51long;

    public VendorAreasRequestModel() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public VendorAreasRequestModel(int i11, @Nullable String str, @Nullable String str2) {
        this.countryCode = i11;
        this.lat = str;
        this.f51long = str2;
    }

    public static /* synthetic */ VendorAreasRequestModel copy$default(VendorAreasRequestModel vendorAreasRequestModel, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = vendorAreasRequestModel.countryCode;
        }
        if ((i12 & 2) != 0) {
            str = vendorAreasRequestModel.lat;
        }
        if ((i12 & 4) != 0) {
            str2 = vendorAreasRequestModel.f51long;
        }
        return vendorAreasRequestModel.copy(i11, str, str2);
    }

    public final int component1() {
        return this.countryCode;
    }

    @Nullable
    public final String component2() {
        return this.lat;
    }

    @Nullable
    public final String component3() {
        return this.f51long;
    }

    @NotNull
    public final VendorAreasRequestModel copy(int i11, @Nullable String str, @Nullable String str2) {
        return new VendorAreasRequestModel(i11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorAreasRequestModel)) {
            return false;
        }
        VendorAreasRequestModel vendorAreasRequestModel = (VendorAreasRequestModel) obj;
        return this.countryCode == vendorAreasRequestModel.countryCode && Intrinsics.areEqual((Object) this.lat, (Object) vendorAreasRequestModel.lat) && Intrinsics.areEqual((Object) this.f51long, (Object) vendorAreasRequestModel.f51long);
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    @Nullable
    public final String getLat() {
        return this.lat;
    }

    @Nullable
    public final String getLong() {
        return this.f51long;
    }

    public int hashCode() {
        int i11 = this.countryCode * 31;
        String str = this.lat;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f51long;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return hashCode + i12;
    }

    public final void setCountryCode(int i11) {
        this.countryCode = i11;
    }

    public final void setLat(@Nullable String str) {
        this.lat = str;
    }

    public final void setLong(@Nullable String str) {
        this.f51long = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryCode;
        String str = this.lat;
        String str2 = this.f51long;
        return "VendorAreasRequestModel(countryCode=" + i11 + ", lat=" + str + ", long=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorAreasRequestModel(int i11, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? IntKt.orZero(IntCompanionObject.INSTANCE) : i11, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : str2);
    }
}
