package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BusinessHoursIntervalCreator")
@SafeParcelable.Reserved({1000})
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzg();
    @SafeParcelable.Field(id = 1)
    private final int zzcs;
    @SafeParcelable.Field(id = 2)
    private final int zzct;

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12) {
        this.zzcs = i11;
        this.zzct = i12;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzcs);
        SafeParcelWriter.writeInt(parcel, 2, this.zzct);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
