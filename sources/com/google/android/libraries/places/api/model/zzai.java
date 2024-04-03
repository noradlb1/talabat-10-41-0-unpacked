package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzai implements Parcelable.Creator<zzaj> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzaj(parcel.readInt(), parcel.readInt());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzaj[i11];
    }
}
