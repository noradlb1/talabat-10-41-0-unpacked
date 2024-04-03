package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzac implements Parcelable.Creator<zzad> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Integer num;
        String readString = parcel.readString();
        if (parcel.readInt() == 0) {
            num = Integer.valueOf(parcel.readInt());
        } else {
            num = null;
        }
        Integer num2 = num;
        Class<AutocompletePrediction> cls = AutocompletePrediction.class;
        return new zzad(readString, num2, parcel.readArrayList(cls.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readArrayList(cls.getClassLoader()), parcel.readArrayList(cls.getClassLoader()), parcel.readArrayList(cls.getClassLoader()));
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzad[i11];
    }
}
