package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzyz implements zzdc {
    public static final Parcelable.Creator<zzyz> CREATOR = new zzyy();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzyz(int i11, String str, String str2, int i12, int i13, int i14, int i15, byte[] bArr) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = i15;
        this.zzh = bArr;
    }

    public zzyz(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = (byte[]) zzfn.zzC(parcel.createByteArray());
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyz.class == obj.getClass()) {
            zzyz zzyz = (zzyz) obj;
            if (this.zza == zzyz.zza && this.zzb.equals(zzyz.zzb) && this.zzc.equals(zzyz.zzc) && this.zzd == zzyz.zzd && this.zze == zzyz.zze && this.zzf == zzyz.zzf && this.zzg == zzyz.zzg && Arrays.equals(this.zzh, zzyz.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb2.append("Picture: mimeType=");
        sb2.append(str);
        sb2.append(", description=");
        sb2.append(str2);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzbc zzbc) {
        zzbc.zza(this.zzh, this.zza);
    }
}
