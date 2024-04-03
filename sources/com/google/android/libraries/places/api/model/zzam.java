package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzam implements Parcelable.Creator<zzan> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Class<Period> cls = Period.class;
        return new zzan((TimeOfWeek) parcel.readParcelable(cls.getClassLoader()), (TimeOfWeek) parcel.readParcelable(cls.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzan[i11];
    }
}
