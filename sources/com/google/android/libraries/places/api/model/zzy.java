package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzy implements Parcelable.Creator<zzz> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str;
        String readString = parcel.readString();
        if (parcel.readInt() == 0) {
            str = parcel.readString();
        } else {
            str = null;
        }
        return new zzz(readString, str, parcel.readArrayList(AddressComponent.class.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzz[i11];
    }
}
