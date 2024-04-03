package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.domain.model.Source;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "", "accuracy", "", "latitude", "", "longitude", "source", "Lcom/deliveryhero/chatsdk/domain/model/Source;", "(Ljava/lang/String;DDLcom/deliveryhero/chatsdk/domain/model/Source;)V", "getAccuracy", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getSource", "()Lcom/deliveryhero/chatsdk/domain/model/Source;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationContent {
    @NotNull
    private final String accuracy;
    private final double latitude;
    private final double longitude;
    @NotNull
    private final Source source;

    public LocationContent(@NotNull @Json(name = "accuracy") String str, @Json(name = "lat") double d11, @Json(name = "lon") double d12, @NotNull @Json(name = "source") Source source2) {
        Intrinsics.checkNotNullParameter(str, "accuracy");
        Intrinsics.checkNotNullParameter(source2, "source");
        this.accuracy = str;
        this.latitude = d11;
        this.longitude = d12;
        this.source = source2;
    }

    public static /* synthetic */ LocationContent copy$default(LocationContent locationContent, String str, double d11, double d12, Source source2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = locationContent.accuracy;
        }
        if ((i11 & 2) != 0) {
            d11 = locationContent.latitude;
        }
        double d13 = d11;
        if ((i11 & 4) != 0) {
            d12 = locationContent.longitude;
        }
        double d14 = d12;
        if ((i11 & 8) != 0) {
            source2 = locationContent.source;
        }
        return locationContent.copy(str, d13, d14, source2);
    }

    @NotNull
    public final String component1() {
        return this.accuracy;
    }

    public final double component2() {
        return this.latitude;
    }

    public final double component3() {
        return this.longitude;
    }

    @NotNull
    public final Source component4() {
        return this.source;
    }

    @NotNull
    public final LocationContent copy(@NotNull @Json(name = "accuracy") String str, @Json(name = "lat") double d11, @Json(name = "lon") double d12, @NotNull @Json(name = "source") Source source2) {
        Intrinsics.checkNotNullParameter(str, "accuracy");
        Intrinsics.checkNotNullParameter(source2, "source");
        return new LocationContent(str, d11, d12, source2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationContent)) {
            return false;
        }
        LocationContent locationContent = (LocationContent) obj;
        return Intrinsics.areEqual((Object) this.accuracy, (Object) locationContent.accuracy) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(locationContent.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(locationContent.longitude)) && this.source == locationContent.source;
    }

    @NotNull
    public final String getAccuracy() {
        return this.accuracy;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((((this.accuracy.hashCode() * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "LocationContent(accuracy=" + this.accuracy + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", source=" + this.source + ')';
    }
}
