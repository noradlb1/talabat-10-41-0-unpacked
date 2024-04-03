package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaa implements Parcelable.Creator<zzab> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzab(parcel.readArrayList(AddressComponents.class.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzab[i11];
    }
}
