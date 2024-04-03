package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzas implements Parcelable.Creator<zzat> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzat((Place) parcel.readParcelable(PlaceLikelihood.class.getClassLoader()), parcel.readDouble());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzat[i11];
    }
}
