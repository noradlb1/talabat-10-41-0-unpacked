package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;

public enum TypeFilter implements Parcelable {
    ADDRESS,
    CITIES,
    ESTABLISHMENT,
    GEOCODE,
    REGIONS;
    
    @RecentlyNonNull
    public static final Parcelable.Creator<TypeFilter> CREATOR = null;

    /* access modifiers changed from: public */
    static {
        CREATOR = new zzbj();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        parcel.writeString(name());
    }
}
