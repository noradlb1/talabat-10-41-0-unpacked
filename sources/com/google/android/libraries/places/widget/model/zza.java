package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zza implements Parcelable.Creator<AutocompleteActivityMode> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        return AutocompleteActivityMode.valueOf(readString);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new AutocompleteActivityMode[i11];
    }
}
