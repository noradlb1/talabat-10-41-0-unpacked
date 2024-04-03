package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaz extends zzx {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzay();

    public zzaz(DayOfWeek dayOfWeek, LocalTime localTime) {
        super(dayOfWeek, localTime);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(getDay(), i11);
        parcel.writeParcelable(getTime(), i11);
    }
}
