package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzak implements Parcelable.Creator<zzal> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Class<OpeningHours> cls = OpeningHours.class;
        return new zzal(parcel.readArrayList(cls.getClassLoader()), parcel.readArrayList(cls.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzal[i11];
    }
}
