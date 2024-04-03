package com.huawei.hms.support.api.entity.location.fence;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.Geofence;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class GeofenceEntity implements Parcelable, Geofence, IMessageEntity {
    private static final int CONVERSIONS_MAX = 7;
    public static final Parcelable.Creator<GeofenceEntity> CREATOR = new yn();
    private static final double DEFAULT_LATITUDE_MAX = 90.0d;
    private static final double DEFAULT_LATITUDE_MIN = -90.0d;
    private static final double DEFAULT_LONGITUDE_MAX = 180.0d;
    private static final double DEFAULT_LONGITUDE_MIN = -180.0d;
    private static final float DEFAULT_RADIUS = 0.0f;
    private static final int DEFAULT_UNIQUE_ID_LENGTH_MAX = 100;
    @Packed
    private int conversions;
    @Packed
    private int dwellDelayTime;
    @Packed
    private double latitude;
    @Packed
    private double longitude;
    @Packed
    private int notificationInterval;
    @Packed
    private float radius;
    @Packed
    private String uniqueId;
    @Packed
    private long validDuration;

    public static class yn implements Parcelable.Creator<GeofenceEntity> {
        public Object createFromParcel(Parcel parcel) {
            return new GeofenceEntity(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new GeofenceEntity[i11];
        }
    }

    private GeofenceEntity(Parcel parcel) {
        this.dwellDelayTime = -1;
        this.uniqueId = parcel.readString();
        this.conversions = parcel.readInt();
        this.validDuration = parcel.readLong();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.radius = parcel.readFloat();
        this.notificationInterval = parcel.readInt();
        this.dwellDelayTime = parcel.readInt();
    }

    public /* synthetic */ GeofenceEntity(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public GeofenceEntity(String str, int i11, double d11, double d12, float f11, long j11, int i12, int i13) {
        this.dwellDelayTime = -1;
        if (TextUtils.isEmpty(str) || str.length() > 100) {
            throw new IllegalArgumentException(TextUtils.isEmpty(str) ? "uniqueId is null" : "uniqueId is too long: ".concat(str));
        } else if (f11 <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f11);
        } else if (d11 > DEFAULT_LATITUDE_MAX || d11 < DEFAULT_LATITUDE_MIN) {
            throw new IllegalArgumentException("invalid latitude");
        } else if (d12 > DEFAULT_LONGITUDE_MAX || d12 < DEFAULT_LONGITUDE_MIN) {
            throw new IllegalArgumentException("invalid longitude");
        } else if ((i11 & 7) != 0) {
            this.uniqueId = str;
            this.latitude = d11;
            this.longitude = d12;
            this.radius = f11;
            this.validDuration = j11;
            this.conversions = i11;
            this.notificationInterval = i12;
            this.dwellDelayTime = i13;
        } else {
            throw new IllegalArgumentException("invalid conversions: " + i11);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public String toString() {
        return "GeofenceEntity{uniqueId='" + this.uniqueId + '\'' + ", conversions=" + this.conversions + ", validDuration=" + this.validDuration + ", radius=" + this.radius + ", notificationInterval=" + this.notificationInterval + ", dwellDelayTime=" + this.dwellDelayTime + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.conversions);
        parcel.writeLong(this.validDuration);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeFloat(this.radius);
        parcel.writeInt(this.notificationInterval);
        parcel.writeInt(this.dwellDelayTime);
    }
}
