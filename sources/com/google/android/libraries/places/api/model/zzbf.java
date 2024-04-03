package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.Place;

final class zzbf implements Parcelable.Creator<Place.BusinessStatus> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        return Place.BusinessStatus.valueOf(readString);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new Place.BusinessStatus[i11];
    }
}
