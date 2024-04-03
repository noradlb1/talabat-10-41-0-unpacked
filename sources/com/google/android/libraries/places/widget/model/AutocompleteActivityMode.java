package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;

public enum AutocompleteActivityMode implements Parcelable {
    FULLSCREEN,
    OVERLAY;
    
    @RecentlyNonNull
    public static final Parcelable.Creator<AutocompleteActivityMode> CREATOR = null;

    /* access modifiers changed from: public */
    static {
        CREATOR = new zza();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i11) {
        parcel.writeString(name());
    }
}
