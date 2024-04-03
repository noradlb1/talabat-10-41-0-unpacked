package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

final class zzax extends zzw {
    public static final Parcelable.Creator<zzax> CREATOR = new zzaw();

    public zzax(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getSouthwest(), i11);
        parcel.writeParcelable(getNortheast(), i11);
    }
}
