package com.uladdressform.presentation.channel;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormMapBundle;", "Landroid/os/Parcelable;", "latitude", "", "longitude", "areaId", "", "(DDI)V", "getAreaId", "()I", "getLatitude", "()D", "getLongitude", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class AddressFormMapBundle implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AddressFormMapBundle> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int areaId;
    private final double latitude;
    private final double longitude;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormMapBundle$Companion;", "", "()V", "fromFlutterMap", "Lcom/uladdressform/presentation/channel/AddressFormMapBundle;", "map", "", "", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AddressFormMapBundle fromFlutterMap(@NotNull Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, Param.MAP);
            return new AddressFormMapBundle(ParcelableKt.asDouble(map.get("latitude")), ParcelableKt.asDouble(map.get("longitude")), ParcelableKt.asInt(map.get("areaId")));
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddressFormMapBundle> {
        @NotNull
        public final AddressFormMapBundle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressFormMapBundle(parcel.readDouble(), parcel.readDouble(), parcel.readInt());
        }

        @NotNull
        public final AddressFormMapBundle[] newArray(int i11) {
            return new AddressFormMapBundle[i11];
        }
    }

    public AddressFormMapBundle(double d11, double d12, int i11) {
        this.latitude = d11;
        this.longitude = d12;
        this.areaId = i11;
    }

    public static /* synthetic */ AddressFormMapBundle copy$default(AddressFormMapBundle addressFormMapBundle, double d11, double d12, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            d11 = addressFormMapBundle.latitude;
        }
        double d13 = d11;
        if ((i12 & 2) != 0) {
            d12 = addressFormMapBundle.longitude;
        }
        double d14 = d12;
        if ((i12 & 4) != 0) {
            i11 = addressFormMapBundle.areaId;
        }
        return addressFormMapBundle.copy(d13, d14, i11);
    }

    @JvmStatic
    @NotNull
    public static final AddressFormMapBundle fromFlutterMap(@NotNull Map<String, ? extends Object> map) {
        return Companion.fromFlutterMap(map);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    public final int component3() {
        return this.areaId;
    }

    @NotNull
    public final AddressFormMapBundle copy(double d11, double d12, int i11) {
        return new AddressFormMapBundle(d11, d12, i11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressFormMapBundle)) {
            return false;
        }
        AddressFormMapBundle addressFormMapBundle = (AddressFormMapBundle) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(addressFormMapBundle.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(addressFormMapBundle.longitude)) && this.areaId == addressFormMapBundle.areaId;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (((Double.doubleToLongBits(this.latitude) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.areaId;
    }

    @NotNull
    public String toString() {
        double d11 = this.latitude;
        double d12 = this.longitude;
        int i11 = this.areaId;
        return "AddressFormMapBundle(latitude=" + d11 + ", longitude=" + d12 + ", areaId=" + i11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeInt(this.areaId);
    }
}
