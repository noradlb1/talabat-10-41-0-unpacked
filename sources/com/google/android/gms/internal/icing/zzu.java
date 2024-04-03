package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ScoringConfigCreator")
@SafeParcelable.Reserved({1000})
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    @SafeParcelable.Field(id = 1)
    public final boolean zza;

    @SafeParcelable.Constructor
    public zzu(@SafeParcelable.Param(id = 1) boolean z11) {
        this.zza = z11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzu) && this.zza == ((zzu) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zza ? 1 : 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
