package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzbj implements Parcelable.Creator<TypeFilter> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        return TypeFilter.valueOf(readString);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new TypeFilter[i11];
    }
}
