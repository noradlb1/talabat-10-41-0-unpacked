package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzat extends zzs {
    public static final Parcelable.Creator<zzat> CREATOR = new zzas();

    public zzat(Place place, double d11) {
        super(place, d11);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getPlace(), i11);
        parcel.writeDouble(getLikelihood());
    }
}
