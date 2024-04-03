package com.deliveryhero.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/deliveryhero/contract/model/LocationData;", "Landroid/os/Parcelable;", "lat", "", "lon", "accuracy", "", "source", "Lcom/deliveryhero/contract/model/Source;", "correlationID", "(DDLjava/lang/String;Lcom/deliveryhero/contract/model/Source;Ljava/lang/String;)V", "getAccuracy", "()Ljava/lang/String;", "getCorrelationID", "getLat", "()D", "getLon", "getSource", "()Lcom/deliveryhero/contract/model/Source;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class LocationData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<LocationData> CREATOR = new Creator();
    @NotNull
    private final String accuracy;
    @NotNull
    private final String correlationID;
    private final double lat;
    private final double lon;
    @Nullable
    private final Source source;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LocationData> {
        @NotNull
        public final LocationData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationData(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readInt() == 0 ? null : Source.valueOf(parcel.readString()), parcel.readString());
        }

        @NotNull
        public final LocationData[] newArray(int i11) {
            return new LocationData[i11];
        }
    }

    public LocationData(double d11, double d12, @NotNull String str, @Nullable Source source2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "accuracy");
        Intrinsics.checkNotNullParameter(str2, "correlationID");
        this.lat = d11;
        this.lon = d12;
        this.accuracy = str;
        this.source = source2;
        this.correlationID = str2;
    }

    public static /* synthetic */ LocationData copy$default(LocationData locationData, double d11, double d12, String str, Source source2, String str2, int i11, Object obj) {
        LocationData locationData2 = locationData;
        return locationData.copy((i11 & 1) != 0 ? locationData2.lat : d11, (i11 & 2) != 0 ? locationData2.lon : d12, (i11 & 4) != 0 ? locationData2.accuracy : str, (i11 & 8) != 0 ? locationData2.source : source2, (i11 & 16) != 0 ? locationData2.correlationID : str2);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lon;
    }

    @NotNull
    public final String component3() {
        return this.accuracy;
    }

    @Nullable
    public final Source component4() {
        return this.source;
    }

    @NotNull
    public final String component5() {
        return this.correlationID;
    }

    @NotNull
    public final LocationData copy(double d11, double d12, @NotNull String str, @Nullable Source source2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "accuracy");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "correlationID");
        return new LocationData(d11, d12, str, source2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationData)) {
            return false;
        }
        LocationData locationData = (LocationData) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(locationData.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lon), (Object) Double.valueOf(locationData.lon)) && Intrinsics.areEqual((Object) this.accuracy, (Object) locationData.accuracy) && this.source == locationData.source && Intrinsics.areEqual((Object) this.correlationID, (Object) locationData.correlationID);
    }

    @NotNull
    public final String getAccuracy() {
        return this.accuracy;
    }

    @NotNull
    public final String getCorrelationID() {
        return this.correlationID;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    @Nullable
    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        int a11 = ((((Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lon)) * 31) + this.accuracy.hashCode()) * 31;
        Source source2 = this.source;
        return ((a11 + (source2 == null ? 0 : source2.hashCode())) * 31) + this.correlationID.hashCode();
    }

    @NotNull
    public String toString() {
        return "LocationData(lat=" + this.lat + ", lon=" + this.lon + ", accuracy=" + this.accuracy + ", source=" + this.source + ", correlationID=" + this.correlationID + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lon);
        parcel.writeString(this.accuracy);
        Source source2 = this.source;
        if (source2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(source2.name());
        }
        parcel.writeString(this.correlationID);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationData(double d11, double d12, String str, Source source2, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d11, d12, str, source2, (i11 & 16) != 0 ? "" : str2);
    }
}
