package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.common.util.Objects;

@Deprecated
public class StreetViewSource implements Parcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new Parcelable.Creator<StreetViewSource>() {
        /* renamed from: a */
        public StreetViewSource createFromParcel(Parcel parcel) {
            return new StreetViewSource(parcel);
        }

        /* renamed from: a */
        public StreetViewSource[] newArray(int i11) {
            return new StreetViewSource[i11];
        }
    };
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_OUTDOOR = 1;

    /* renamed from: a  reason: collision with root package name */
    private final int f49559a;

    public StreetViewSource(int i11) {
        this.f49559a = i11;
    }

    public StreetViewSource(Parcel parcel) {
        this.f49559a = new ParcelReader(parcel).readInt(2, 0);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f49559a == ((StreetViewSource) obj).f49559a;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f49559a));
    }

    public final String toString() {
        return "Type is:" + this.f49559a;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeInt(2, this.f49559a);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
