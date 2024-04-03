package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzba;
import com.talabat.helpers.GlobalConstants;

@SafeParcelable.Class(creator = "FeatureLayerOptionsCreator")
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private static final zzba zza = zzba.zzi("ADMINISTRATIVE_AREA_LEVEL_1", "ADMINISTRATIVE_AREA_LEVEL_2", GlobalConstants.PrefsConstants.COUNTRY_ID, "LOCALITY", "POSTAL_CODE", "SCHOOL_DISTRICT", new String[0]);
    @SafeParcelable.Field(getter = "getFeatureType", id = 1)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 1) String str) {
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        String str = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
