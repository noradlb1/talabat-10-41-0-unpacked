package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.VisibleForTesting;

public enum DayOfWeek implements Parcelable {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    
    @RecentlyNonNull
    public static final Parcelable.Creator<DayOfWeek> CREATOR = null;

    /* access modifiers changed from: public */
    static {
        CREATOR = new zzbc();
    }

    @VisibleForTesting
    public static DayOfWeek zza(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        return valueOf(readString);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        parcel.writeString(name());
    }
}
