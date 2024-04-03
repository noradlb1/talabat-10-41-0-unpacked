package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzay implements Parcelable.Creator<zzaz> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Class<TimeOfWeek> cls = TimeOfWeek.class;
        return new zzaz((DayOfWeek) parcel.readParcelable(cls.getClassLoader()), (LocalTime) parcel.readParcelable(cls.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzaz[i11];
    }
}
