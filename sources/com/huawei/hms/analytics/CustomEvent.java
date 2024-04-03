package com.huawei.hms.analytics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CustomEvent implements Parcelable {
    public static final Parcelable.Creator<CustomEvent> CREATOR = new Parcelable.Creator<CustomEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CustomEvent(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new CustomEvent[i11];
        }
    };
    public Bundle ikl;
    public String klm;
    public String lmn;

    public CustomEvent() {
    }

    private CustomEvent(Parcel parcel) {
        this.lmn = parcel.readString();
        this.klm = parcel.readString();
        this.ikl = parcel.readBundle();
    }

    public /* synthetic */ CustomEvent(Parcel parcel, byte b11) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.lmn);
        parcel.writeString(this.klm);
        parcel.writeBundle(this.ikl);
    }
}
