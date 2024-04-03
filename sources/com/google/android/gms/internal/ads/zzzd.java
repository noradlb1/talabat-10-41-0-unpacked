package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

public final class zzzd implements zzdc {
    public static final Parcelable.Creator<zzzd> CREATOR = new zzzc();
    public final int zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzzd(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, int i12) {
        boolean z12 = true;
        if (i12 != -1 && i12 <= 0) {
            z12 = false;
        }
        zzdy.zzd(z12);
        this.zza = i11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z11;
        this.zzf = i12;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzd.class == obj.getClass()) {
            zzzd zzzd = (zzzd) obj;
            if (this.zza != zzzd.zza || !zzfn.zzP(this.zzb, zzzd.zzb) || !zzfn.zzP(this.zzc, zzzd.zzc) || !zzfn.zzP(this.zzd, zzzd.zzd) || this.zze != zzzd.zze || this.zzf != zzzd.zzf) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13 = (this.zza + 527) * 31;
        String str = this.zzb;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = (i13 + i11) * 31;
        String str2 = this.zzc;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        String str3 = this.zzd;
        if (str3 != null) {
            i14 = str3.hashCode();
        }
        return ((((i16 + i14) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzb;
        int i11 = this.zza;
        int i12 = this.zzf;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        sb2.append("IcyHeaders: name=\"");
        sb2.append(str);
        sb2.append("\", genre=\"");
        sb2.append(str2);
        sb2.append("\", bitrate=");
        sb2.append(i11);
        sb2.append(", metadataInterval=");
        sb2.append(i12);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        zzfn.zzO(parcel, this.zze);
        parcel.writeInt(this.zzf);
    }

    public final /* synthetic */ void zza(zzbc zzbc) {
    }

    public zzzd(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        this.zze = zzfn.zzV(parcel);
        this.zzf = parcel.readInt();
    }
}
