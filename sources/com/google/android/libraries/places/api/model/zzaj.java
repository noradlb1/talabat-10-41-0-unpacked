package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaj extends zzj {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzai();

    public zzaj(int i11, int i12) {
        super(i11, i12);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(getHours());
        parcel.writeInt(getMinutes());
    }
}
