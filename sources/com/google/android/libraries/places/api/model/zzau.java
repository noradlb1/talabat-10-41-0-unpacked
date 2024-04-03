package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzau implements Parcelable.Creator<zzav> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str;
        String str2 = null;
        if (parcel.readInt() == 0) {
            str = parcel.readString();
        } else {
            str = null;
        }
        if (parcel.readInt() == 0) {
            str2 = parcel.readString();
        }
        return new zzav(str, str2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzav[i11];
    }
}
