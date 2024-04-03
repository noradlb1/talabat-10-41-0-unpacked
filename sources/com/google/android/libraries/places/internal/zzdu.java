package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class zzdu implements Parcelable.Creator<zzdv> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdv.valueOf(parcel.readString());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzdv[i11];
    }
}
