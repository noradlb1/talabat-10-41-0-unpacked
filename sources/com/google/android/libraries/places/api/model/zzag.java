package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;

final class zzag implements Parcelable.Creator<zzah> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzah((ParcelUuid) parcel.readParcelable(AutocompleteSessionToken.class.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzah[i11];
    }
}
