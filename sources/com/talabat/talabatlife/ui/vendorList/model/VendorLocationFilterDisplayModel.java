package com.talabat.talabatlife.ui.vendorList.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006("}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "Landroid/os/Parcelable;", "areaId", "", "areaName", "", "cityName", "longitude", "", "latitude", "filterType", "Lcom/talabat/talabatlife/ui/vendorList/model/FilterType;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/talabat/talabatlife/ui/vendorList/model/FilterType;)V", "getAreaId", "()I", "setAreaId", "(I)V", "getAreaName", "()Ljava/lang/String;", "setAreaName", "(Ljava/lang/String;)V", "getCityName", "setCityName", "getFilterType", "()Lcom/talabat/talabatlife/ui/vendorList/model/FilterType;", "setFilterType", "(Lcom/talabat/talabatlife/ui/vendorList/model/FilterType;)V", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLongitude", "setLongitude", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class VendorLocationFilterDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<VendorLocationFilterDisplayModel> CREATOR = new Creator();
    private int areaId;
    @NotNull
    private String areaName;
    @NotNull
    private String cityName;
    @NotNull
    private FilterType filterType;
    @Nullable
    private Double latitude;
    @Nullable
    private Double longitude;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VendorLocationFilterDisplayModel> {
        @NotNull
        public final VendorLocationFilterDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VendorLocationFilterDisplayModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), FilterType.valueOf(parcel.readString()));
        }

        @NotNull
        public final VendorLocationFilterDisplayModel[] newArray(int i11) {
            return new VendorLocationFilterDisplayModel[i11];
        }
    }

    public VendorLocationFilterDisplayModel() {
        this(0, (String) null, (String) null, (Double) null, (Double) null, (FilterType) null, 63, (DefaultConstructorMarker) null);
    }

    public VendorLocationFilterDisplayModel(int i11, @NotNull String str, @NotNull String str2, @Nullable Double d11, @Nullable Double d12, @NotNull FilterType filterType2) {
        Intrinsics.checkNotNullParameter(str, "areaName");
        Intrinsics.checkNotNullParameter(str2, "cityName");
        Intrinsics.checkNotNullParameter(filterType2, "filterType");
        this.areaId = i11;
        this.areaName = str;
        this.cityName = str2;
        this.longitude = d11;
        this.latitude = d12;
        this.filterType = filterType2;
    }

    public int describeContents() {
        return 0;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    @NotNull
    public final FilterType getFilterType() {
        return this.filterType;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    public final void setAreaId(int i11) {
        this.areaId = i11;
    }

    public final void setAreaName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.areaName = str;
    }

    public final void setCityName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityName = str;
    }

    public final void setFilterType(@NotNull FilterType filterType2) {
        Intrinsics.checkNotNullParameter(filterType2, "<set-?>");
        this.filterType = filterType2;
    }

    public final void setLatitude(@Nullable Double d11) {
        this.latitude = d11;
    }

    public final void setLongitude(@Nullable Double d11) {
        this.longitude = d11;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.areaId);
        parcel.writeString(this.areaName);
        parcel.writeString(this.cityName);
        Double d11 = this.longitude;
        if (d11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d11.doubleValue());
        }
        Double d12 = this.latitude;
        if (d12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d12.doubleValue());
        }
        parcel.writeString(this.filterType.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorLocationFilterDisplayModel(int r5, java.lang.String r6, java.lang.String r7, java.lang.Double r8, java.lang.Double r9, com.talabat.talabatlife.ui.vendorList.model.FilterType r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 0
        L_0x0005:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000f
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x000f:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x001a:
            r0 = r7
            r6 = r11 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0022
            r1 = r7
            goto L_0x0023
        L_0x0022:
            r1 = r8
        L_0x0023:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0029
            r2 = r7
            goto L_0x002a
        L_0x0029:
            r2 = r9
        L_0x002a:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0030
            com.talabat.talabatlife.ui.vendorList.model.FilterType r10 = com.talabat.talabatlife.ui.vendorList.model.FilterType.CITY_FILTER
        L_0x0030:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel.<init>(int, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, com.talabat.talabatlife.ui.vendorList.model.FilterType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
