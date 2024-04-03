package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

final class zzaw implements Parcelable.Creator<zzax> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Class<RectangularBounds> cls = RectangularBounds.class;
        return new zzax((LatLng) parcel.readParcelable(cls.getClassLoader()), (LatLng) parcel.readParcelable(cls.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzax[i11];
    }
}
