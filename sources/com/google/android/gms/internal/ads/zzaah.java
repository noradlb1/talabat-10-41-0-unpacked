package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzaah implements zzdc {
    public static final Parcelable.Creator<zzaah> CREATOR = new zzaaf();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public /* synthetic */ zzaah(Parcel parcel, zzaag zzaag) {
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzfn.zzC(parcel.createByteArray());
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzaah(String str, byte[] bArr, int i11, int i12) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i11;
        this.zzd = i12;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaah.class == obj.getClass()) {
            zzaah zzaah = (zzaah) obj;
            if (!this.zza.equals(zzaah.zza) || !Arrays.equals(this.zzb, zzaah.zzb) || this.zzc != zzaah.zzc || this.zzd != zzaah.zzd) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final /* synthetic */ void zza(zzbc zzbc) {
    }
}
