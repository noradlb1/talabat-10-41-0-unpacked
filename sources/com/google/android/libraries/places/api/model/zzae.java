package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzae implements Parcelable.Creator<zzaf> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzaf(parcel.readInt(), parcel.readInt());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzaf[i11];
    }
}
