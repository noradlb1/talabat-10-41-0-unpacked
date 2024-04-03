package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzao implements Parcelable.Creator<zzap> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzap(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzap[i11];
    }
}
