package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

final class zzdq extends zzdo {
    public static final Parcelable.Creator<zzdq> CREATOR = new zzdp();

    public zzdq(AutocompleteActivityMode autocompleteActivityMode, zzge<Place.Field> zzge, zzdv zzdv, @Nullable String str, @Nullable String str2, @Nullable LocationBias locationBias, @Nullable LocationRestriction locationRestriction, zzge<String> zzge2, @Nullable TypeFilter typeFilter, int i11, int i12) {
        super(autocompleteActivityMode, zzge, zzdv, str, str2, locationBias, locationRestriction, zzge2, typeFilter, i11, i12);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(zzh(), i11);
        parcel.writeList(zzj());
        parcel.writeParcelable(zzf(), i11);
        if (zzl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(zzl());
        }
        if (zzk() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(zzk());
        }
        parcel.writeParcelable(zzc(), i11);
        parcel.writeParcelable(zzd(), i11);
        parcel.writeList(zzi());
        parcel.writeParcelable(zze(), i11);
        parcel.writeInt(zza());
        parcel.writeInt(zzb());
    }
}
