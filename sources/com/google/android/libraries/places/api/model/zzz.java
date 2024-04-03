package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.List;

final class zzz extends zzb {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();

    public zzz(String str, @Nullable String str2, List<String> list) {
        super(str, str2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(getName());
        if (getShortName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getShortName());
        }
        parcel.writeList(getTypes());
    }
}
