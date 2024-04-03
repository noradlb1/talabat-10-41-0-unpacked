package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class zzad extends zze {
    public static final Parcelable.Creator<zzad> CREATOR = new zzac();

    public zzad(String str, @Nullable Integer num, List<Place.Type> list, String str2, String str3, String str4, @Nullable List<zzbb> list2, @Nullable List<zzbb> list3, @Nullable List<zzbb> list4) {
        super(str, num, list, str2, str3, str4, list2, list3, list4);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(getPlaceId());
        if (getDistanceMeters() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getDistanceMeters().intValue());
        }
        parcel.writeList(getPlaceTypes());
        parcel.writeString(zza());
        parcel.writeString(zzb());
        parcel.writeString(zzc());
        parcel.writeList(zzd());
        parcel.writeList(zze());
        parcel.writeList(zzf());
    }
}
