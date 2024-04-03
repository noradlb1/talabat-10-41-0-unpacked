package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

public final class zzaan implements zzdc {
    public static final Parcelable.Creator<zzaan> CREATOR = new zzaal();
    public final float zza;
    public final int zzb;

    public zzaan(float f11, int i11) {
        this.zza = f11;
        this.zzb = i11;
    }

    public /* synthetic */ zzaan(Parcel parcel, zzaam zzaam) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaan.class == obj.getClass()) {
            zzaan zzaan = (zzaan) obj;
            return this.zza == zzaan.zza && this.zzb == zzaan.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f11 = this.zza;
        int i11 = this.zzb;
        StringBuilder sb2 = new StringBuilder(73);
        sb2.append("smta: captureFrameRate=");
        sb2.append(f11);
        sb2.append(", svcTemporalLayerCount=");
        sb2.append(i11);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final /* synthetic */ void zza(zzbc zzbc) {
    }
}
