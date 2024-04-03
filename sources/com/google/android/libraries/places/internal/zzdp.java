package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

final class zzdp implements Parcelable.Creator<zzdq> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str;
        Class<zzdx> cls = zzdx.class;
        AutocompleteActivityMode autocompleteActivityMode = (AutocompleteActivityMode) parcel.readParcelable(cls.getClassLoader());
        zzge zzk = zzge.zzk(parcel.readArrayList(Place.Field.class.getClassLoader()));
        zzdv zzdv = (zzdv) parcel.readParcelable(cls.getClassLoader());
        String str2 = null;
        if (parcel.readInt() == 0) {
            str = parcel.readString();
        } else {
            str = null;
        }
        if (parcel.readInt() == 0) {
            str2 = parcel.readString();
        }
        return new zzdq(autocompleteActivityMode, zzk, zzdv, str, str2, (LocationBias) parcel.readParcelable(cls.getClassLoader()), (LocationRestriction) parcel.readParcelable(cls.getClassLoader()), zzge.zzk(parcel.readArrayList(String.class.getClassLoader())), (TypeFilter) parcel.readParcelable(cls.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzdq[i11];
    }
}
