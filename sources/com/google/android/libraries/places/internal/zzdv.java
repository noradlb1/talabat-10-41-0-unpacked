package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

public enum zzdv implements Parcelable {
    FRAGMENT,
    INTENT;
    
    public static final Parcelable.Creator<zzdv> CREATOR = null;

    /* access modifiers changed from: public */
    static {
        CREATOR = new zzdu();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(name());
    }
}
