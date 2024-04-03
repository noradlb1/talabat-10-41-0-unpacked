package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

final class zzan extends zzn {
    public static final Parcelable.Creator<zzan> CREATOR = new zzam();

    public zzan(@Nullable TimeOfWeek timeOfWeek, @Nullable TimeOfWeek timeOfWeek2) {
        super(timeOfWeek, timeOfWeek2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getOpen(), i11);
        parcel.writeParcelable(getClose(), i11);
    }
}
