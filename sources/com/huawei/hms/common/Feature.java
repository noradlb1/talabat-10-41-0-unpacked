package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public class Feature extends AbstractSafeParcelable {
    public static final int ARGS_NAME = 1;
    public static final int ARGS_SVC_VER = 2;
    public static final int ARGS_VER = 3;
    public static final Parcelable.Creator<Feature> CREATOR = new FeatureCreator();
    private static final int SVC_VER = -1;
    private final long apiVersion;

    /* renamed from: name  reason: collision with root package name */
    private final String f48088name;
    @Deprecated
    private final int serviceVersion;

    public Feature(String str, long j11) {
        this(str, -1, j11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        if (this.f48088name.equals(feature.getName()) && getVersion() == feature.getVersion()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.f48088name;
    }

    public long getVersion() {
        long j11 = this.apiVersion;
        if (-1 == j11) {
            return (long) this.serviceVersion;
        }
        return j11;
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        if (parcel != null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getName(), false);
            SafeParcelWriter.writeInt(parcel, 2, this.serviceVersion);
            SafeParcelWriter.writeLong(parcel, 3, getVersion());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    public Feature(String str, int i11, long j11) {
        this.f48088name = str;
        this.serviceVersion = i11;
        this.apiVersion = j11;
    }
}
