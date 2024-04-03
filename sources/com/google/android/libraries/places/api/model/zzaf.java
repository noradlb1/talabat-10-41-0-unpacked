package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaf extends zzg {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();

    public zzaf(int i11, int i12) {
        super(i11, i12);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(zzb());
        parcel.writeInt(zza());
    }
}
